package task.hashmap;

import java.util.HashMap;
import java.util.Map;

import task.exception.InvalidInputException;
import task.util.HelperUtil;

public class HashMapTask {
	
	public <K, V> Map<K, V> returnHashMap() {
		return new HashMap<K, V>();
	}
	
	
	public <K, V> V add(Map<K, V> map, K key, V value) throws InvalidInputException {
		HelperUtil.isNull(map);
		
		map.put(key, value);
		return value;
	}


	public int size(Map map)throws InvalidInputException {
		return map.size();
	}
	
	
	public <K, V> boolean isKeyPresent(Map<K, V> map, K key) throws InvalidInputException{
		HelperUtil.isNull(map);
		//swami

		return map.containsKey(key);
	}
	
	public <K, V> boolean isValuePresent(Map<K, V> map, K key)throws InvalidInputException {
		HelperUtil.isNull(map);
		
		return map.containsValue(key);
	}
	
	
	public <K,V> void replaceAll(Map<K,V> map)throws InvalidInputException {
		
	}
	
	public <K,V> V getValue(Map<K,V> map, K key)throws InvalidInputException {
		HelperUtil.isNull(map);
		
		
		return map.get(key);
	}
	
	
	public <K,V> V getOrDefault(Map<K,V> map, K key, V value ) throws InvalidInputException{
		HelperUtil.isNull(map);
		
		return map.getOrDefault(key, value);
	}
	
	public <K,V> V removeKey(Map<K,V> map, K key)throws InvalidInputException {
		
		HelperUtil.isNull(map);
	
		return map.remove(key);
	}
	
	
	public <K,V>  boolean removeKeyWithValue(Map<K,V> map, K key, V value ) throws InvalidInputException{
		HelperUtil.isNull(map);
		
		return map.remove(key, value);
	}
	
	
	public <K,V> V replace(Map<K,V> map, K key, V value )throws InvalidInputException{
		HelperUtil.isNull(map);
		
		return map.replace(key, value);
	}
	
	
	public <K,V> boolean replace(Map<K,V> map, K key, V oldValue, V newValue )throws InvalidInputException{
		HelperUtil.isNull(map);
		
		return map.replace(key, oldValue, newValue);
	}
	
	
	public <K, V> void copyMap(Map<K,V> initialMap, Map<K,V> finalMap)throws InvalidInputException{
		HelperUtil.isNull(initialMap);
		HelperUtil.isNull(finalMap);
		finalMap.putAll(initialMap);
	}
	
	public <K,V> void removeAll (Map<K, V> map)throws InvalidInputException {
		HelperUtil.isNull(map);
		map.clear();
	}

}
