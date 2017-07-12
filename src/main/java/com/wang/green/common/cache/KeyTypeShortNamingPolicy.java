package com.wang.green.common.cache;

/**
 * TODO: 增加描述
 * 
 * @author 
 * @version 1.0.0 
 * @copyright 
 */
public class KeyTypeShortNamingPolicy implements IKeyNamingPolicy {

	public String getKeyName(Object key) {   
		if (key instanceof Number)
			return "N:" + key;
		else {
			Class<? extends Object> keyClass = key.getClass();
			if (String.class.equals(keyClass) || StringBuffer.class.equals(keyClass)
					|| StringBuilder.class.equals(keyClass))
				return "S:" + key;
		}
		return "O:" + key;
	}

}