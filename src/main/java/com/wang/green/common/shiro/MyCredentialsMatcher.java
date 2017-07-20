package com.wang.green.common.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import com.wang.green.common.util.EncryptUtil;


/**
 * @author wangjq
 *
 */
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    public static final String PASSWORD_RETRY_CACHE_NAME = "shiro:passwordRetryCache:";
    //缓存超时时间设置为2小时
    public static final Long PASSWORD_RETRY_CACHE_TIMEOUT = 2*60*60L;
    //最大的密码重试次数
    public static final int MAX_RETRY_COUNT = 5;
    public static final int THREE_RETRY_COUNT = 3;
	private Cache<String, AtomicInteger> passwordRetryCache;

    public MyCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache(PASSWORD_RETRY_CACHE_NAME);
    }

    @Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		int errorTimes = retryCount.incrementAndGet();
		if (errorTimes == THREE_RETRY_COUNT) {
			// if retry count == 3 throw
			passwordRetryCache.put(username, retryCount);
			throw new ExcessiveAttemptsException("retry limitted");
		}
		if (errorTimes > MAX_RETRY_COUNT) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException("retry limitted");
		}
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(token.getPrincipal().toString(),
				EncryptUtil.md5(String.valueOf((char[]) token.getCredentials())));
		boolean matches = super.doCredentialsMatch(usernamePasswordToken, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);
		} else {
			passwordRetryCache.put(username, retryCount);
		}
		return matches;
	}
    
    /**
     * 获取用户的密码重试次数
     * @param username
     * @return
     */
    public int getPasswordRetryCount(String username) {
    	int passwordRetryCount;
    	AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
        	passwordRetryCount = 0;
        }
        else {
        	passwordRetryCount = retryCount.get();
        }
        return passwordRetryCount;
    }
    
    /**
     * 重置用户的密码重试次数为0
     * @param username
     */
    public void resetPasswordRetryCount(String username) {
    	//clear retry count
        passwordRetryCache.remove(username);
    }
}