package com.wang.green.common.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wang.green.common.shiro.MyCredentialsMatcher;


public class RedisCacheManager implements
		org.apache.shiro.cache.CacheManager, Initializable, Destroyable {
	private static final Logger log = LoggerFactory
			.getLogger(RedisCacheManager.class);
	private static final long DEFAULT_TIME_TO_IDLE_SECONDS = 3600L;
	private RedisTemplate redisTemplate;
	private final Map<String,Cache> caches = new ConcurrentHashMap<String,Cache>();

	public RedisTemplate getRedisTemplate() {
		return this.redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@SuppressWarnings("unchecked")
	public final <K, V> Cache<K, V> getCache(String name)
			throws org.apache.shiro.cache.CacheException {
		if (log.isTraceEnabled()) {
			log.trace("Acquiring instance named [" + name + "]");
		}
		Cache<K, V> cache = caches.get(name);
		if(null==cache) {
			Long timeToIdleSeconds = DEFAULT_TIME_TO_IDLE_SECONDS;
			if(MyCredentialsMatcher.PASSWORD_RETRY_CACHE_NAME.equals(name)){
				timeToIdleSeconds = MyCredentialsMatcher.PASSWORD_RETRY_CACHE_TIMEOUT;
			}
			cache = null ; // new RedisCache<K,V>(this.redisTemplate, name, timeToIdleSeconds);
			caches.put(name, cache);
		}
		return cache;
	}

	public final void init() throws org.apache.shiro.cache.CacheException {
		if(null==this.redisTemplate){
			//TODO this.manager = 
		}
	}

	public void destroy() {
		return;
	}
}