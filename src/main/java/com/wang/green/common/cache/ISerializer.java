package com.wang.green.common.cache;

/**
 * ISerializer.
 */
public interface ISerializer {
	
    byte[] keyToBytes(String key);
    String keyFromBytes(byte[] bytes);
    
    byte[] fieldToBytes(Object field);
    Object fieldFromBytes(byte[] bytes);
    
	byte[] valueToBytes(Object value);
    Object valueFromBytes(byte[] bytes);
}
