package com.banking.databaseOperations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.banking.config.ConfigReader;
import com.banking.config.Criteria;
import com.banking.config.DBConfig;
import com.banking.config.QueryBuilder;

public class DBService {

    private static final Logger LOGGER = Logger.getLogger(DBService.class.getName());
    private Connection connection;
    private ConfigReader configReader;
    private YAMLReader yamlReader;

    public DBService(String filePath) {
        this.connection = DBConfig.getConnection();
        yamlReader = new YAMLReader(filePath);
        this.configReader = new ConfigReader(filePath);
    }

    

//    private <T> T mapResultSetToObject(ResultSet resultSet, Class<T> clazz) throws SQLException, ReflectiveOperationException {
//        T instance = clazz.getDeclaredConstructor().newInstance();
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        for (int i = 1; i <= metaData.getColumnCount(); i++) {
//            String columnName = metaData.getColumnName(i);
//            Object columnValue = resultSet.getObject(i);
//            String setterMethodName = "set" + capitalizeFirstLetter(columnName);
//            try {
//                Method setterMethod = clazz.getMethod(setterMethodName, columnValue.getClass());
//                setterMethod.invoke(instance, columnValue);
//            } catch (NoSuchMethodException e) {
//                LOGGER.log(Level.WARNING, "Setter not found for column: " + columnName);
//            }
//        }
//        return instance;
//    }

    
    

    public int performDelete(String className, String field, String operator, String value) {
        int rowsAffected = 0;
        String query = null;

        PreparedStatement preparedStatement = null;

        try {
        	System.out.println(className);
            query = new QueryBuilder()
                    .table(className)
                    .delete()
                    .where(field, operator, value)
                    .build();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            rowsAffected = preparedStatement.executeUpdate();
            
//            Map<String, String> references = configReader.getFirstForeignKeyMapping(className);
//            query = new QueryBuilder().table(references.get("referenced_class")).delete().where(references.get("references"), operator, value).build();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error executing delete query: " + query, e);
        } finally {
            closeResources(preparedStatement, null);
        }

        return rowsAffected;
    }

    

    private <T> void insertQueryBuilder(T obj, String className) throws SQLException {
   	 String tableName = yamlReader.getTableName(className);
       Map<String, String> columns = yamlReader.getColumns(className); 
       StringBuilder columnNames = new StringBuilder();
       StringBuilder values = new StringBuilder();
       List<Object> parameters = new ArrayList<>();
       
       for (Map.Entry<String, String> entry : columns.entrySet()) {
           String columnName = entry.getKey();
           String fieldName = entry.getValue();
           
           if (columnNames.length() > 0) {
               columnNames.append(", ");
               values.append(", ");
           }
           columnNames.append(columnName);
           
           try {
               String getterMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
               Method getterMethod = obj.getClass().getMethod(getterMethodName);
               Object value = getterMethod.invoke(obj);
               
               values.append("?");
               parameters.add(value);
           } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
               e.printStackTrace();
           }
       }
       
       String query = "INSERT INTO " + tableName + " (" + columnNames + ") VALUES (" + values + ")";
       
       try (PreparedStatement stmt = connection.prepareStatement(query)) {
           for (int i = 0; i < parameters.size(); i++) {
               stmt.setObject(i + 1, parameters.get(i));
           }
           stmt.executeUpdate();
       }   
       
   }
   
   
   // insert
   public <T> void insert(T obj) throws SQLException {
       if (obj == null) {
           throw new SQLException("Object cannot be null.");
       }
       
       
       String superClassName = obj.getClass().getSuperclass().getSimpleName();
       if(superClassName != null && !superClassName.equals("Object")) {
       	System.out.println("super class name: "+superClassName);
       	insertQueryBuilder(obj, superClassName);
       	
       }
       
       
       String className = obj.getClass().getSimpleName();
       System.out.println("super class name: "+className);
       
       insertQueryBuilder(obj, className);
          
   }
   
   
   public <T> List<T> get(Class<?> clazz, List<Criteria> criteria) {
       String className = clazz.getSimpleName();
       
       QueryBuilder queryBuilder =  new QueryBuilder();
       
       queryBuilder.select("*").table(className);
       
       Map<String, String> foreignKey = configReader.getFirstForeignKeyMapping(className);
       queryBuilder.join(configReader.getTableName(foreignKey.get("referenced_class")), foreignKey.get("field"), foreignKey.get("references"));
       for(Criteria c : criteria) {
    	   queryBuilder.where(c.getColumn(), c.getCompareOperator(), c.getValue());
       }
       
       String query = queryBuilder.build();
       
       
       return (List<T>) executeQuery(query, clazz);
       
       
   }
   
   
   
   public int performInsertOrUpdate(String tableName, Map<String, String> fieldValuePairs) {
       int rowsAffected = 0;
       String query = null;
       PreparedStatement preparedStatement = null;
       try {
           query = new QueryBuilder()
                   .table(tableName)
                   .update(fieldValuePairs)
                   .build();

           preparedStatement = connection.prepareStatement(query);
           rowsAffected = preparedStatement.executeUpdate();
       } catch (SQLException e) {
           LOGGER.log(Level.SEVERE, "Error executing insert/update query: " + query, e);
       } finally {
           closeResources(preparedStatement, null);
       }

       return rowsAffected;
   }

   public <T> List<T> executeQuery(String query, Class<T> clazz) {
       PreparedStatement preparedStatement = null;
       List<T> list = new ArrayList<>();
       
       try {
           preparedStatement = connection.prepareStatement(query);
           ResultSet rs = preparedStatement.executeQuery();
           ResultSetMetaData metaData = rs.getMetaData();
           int columnCount = metaData.getColumnCount();
           
           // Get all "set" methods from the class T
           Method[] methods = clazz.getMethods();
           
           while (rs.next()) {
               T obj = clazz.getDeclaredConstructor().newInstance(); // Create a new instance of T
               
               // Iterate over each "set" method in T
               for (Method method : methods) {
                   if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                       String propertyName = method.getName().substring(3); // Get property name after "set"
                       
                       // Try to match the method with a column in the ResultSet
                       for (int i = 1; i <= columnCount; i++) {
                           String columnName = metaData.getColumnName(i);
                           String fieldName = configReader.getFieldName(clazz.getSimpleName(), columnName);
                           if (propertyName.equalsIgnoreCase(fieldName)) { // Case-insensitive match
                               Object columnValue = rs.getObject(i); // Get the column value
                               
                               // Check if the column value is compatible with the method parameter
                               if (columnValue != null && method.getParameterTypes()[0].isAssignableFrom(columnValue.getClass())) {
                                   method.invoke(obj, columnValue); // Set the value using the setter
                               }
                               break;
                           }
                       }
                   }
               }
               
               list.add(obj); // Add populated object to the list
           }
           
       } catch (Exception e) {
           LOGGER.log(Level.SEVERE, "Error executing query: " + query, e);
       } finally {
           closeResources(preparedStatement, null);
       }
       
       return list;
   }

    private void closeResources(PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error closing resources", e);
        }
    }

    public void closeConnection() {
        DBConfig.closeConnection();
    }
}
