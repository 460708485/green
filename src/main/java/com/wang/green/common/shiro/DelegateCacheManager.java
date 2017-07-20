package com.wang.green.common.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * Shiro CacheManager代理（方便切换不同CacheManager实现）
 * @author wangjq
 *
 */
public class DelegateCacheManager implements CacheManager {
	private CacheManager targetCacheManager;

	public CacheManager getTargetCacheManager() {
		return targetCacheManager;
	}

	public void setTargetCacheManager(CacheManager targetCacheManager) {
		this.targetCacheManager = targetCacheManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String arg0) throws CacheException {
		return targetCacheManager.getCache(arg0);
	}
	
}