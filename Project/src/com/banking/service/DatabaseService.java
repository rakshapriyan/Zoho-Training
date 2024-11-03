package com.banking.service;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.config.DBConfig;

public class DatabaseService<T> {
    private static final Connection connection = DBConfig.getConnection();
    private final Class<T> type;

    public DatabaseService(Class<T> type) {
        this.type = type;
    }

    public void insert(T obj) throws SQLException {
        String tableName = type.getSimpleName().toLowerCase();
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder();

        Method[] methods = type.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                String columnName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                sql.append(columnName).append(", ");
                values.append("?, ");
            }
        }
        sql.setLength(sql.length() - 2);
        values.setLength(values.length() - 2);
        sql.append(") VALUES (").append(values).append(")");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            int index = 1;
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    Object value = method.invoke(obj);
                    preparedStatement.setObject(index++, value);
                }
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error inserting object into the database.");
        }
    }

    public void update(T obj, int id) throws SQLException {
        String tableName = type.getSimpleName().toLowerCase();
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET ");
        Method[] methods = type.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                String columnName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                sql.append(columnName).append(" = ?, ");
            }
        }
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id = ?");

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            int index = 1;
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    Object value = method.invoke(obj);
                    preparedStatement.setObject(index++, value);
                }
            }
            preparedStatement.setObject(index, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error updating object in the database.");
        }
    }

    public void delete(int id) throws SQLException {
        String tableName = type.getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error deleting object from the database.");
        }
    }

    public T findById(int id) throws SQLException {
        String tableName = type.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapRowToObject(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error finding object by ID.");
        }
        return null;
    }

    public List<T> findAll() throws SQLException {
        List<T> resultList = new ArrayList<>();
        String tableName = type.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                resultList.add(mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error finding all objects.");
        }
        return resultList;
    }

    private T mapRowToObject(ResultSet resultSet) throws SQLException {
        try {
            T obj = type.getDeclaredConstructor().newInstance();
            Method[] methods = type.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().startsWith("set")) {
                    String columnName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                    Object value = resultSet.getObject(columnName);
                    method.invoke(obj, value);
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error mapping row to object.");
        }
    }
}
