/*package com.wang.green.common.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyUserFilter extends UserFilter {
	private Logger log = LoggerFactory.getLogger(MyUserFilter.class);

	private String ignoreUrls;

	private String unLoginUrl;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private com.wang.green.common.cache.RedisTemplate redisTemplate;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		
		if (isIgnoreRequests(request, response)||isUnLoginRequest(request, response)) {
			return Boolean.TRUE;
		} 
		else if(!isLoginRequest(request, response)&&null==MySecurityUtils.getUserProfile()) {
			return Boolean.FALSE;
		}
		else {
//			Subject subject = getSubject(request, response);
//			String userName = (String) subject.getPrincipal();
//			String cacheKey = RedisKeyEnum.PASSWORD_CHANGE_REASON_USERNAME.key(userName);
//			Object cachedReason = jedisManager.getValue(cacheKey);
//			//需要修改密码则认为没登陆 
//			if(null!=cachedReason) {
//				subject.logout();
//				return Boolean.FALSE;
//			}
			return super.isAccessAllowed(request, response, mappedValue);
		}
	}
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		
		this.setRequestResource((HttpServletRequest)request);
		
		return super.preHandle(request, response);
	}
	
	private void setRequestResource(HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		String ip = WebUtil.getRequestIP(request);
		MyResources resources = new MyResources(ip, url);
		request.setAttribute(WebUtil.RES, resources);
	}

	@Override
	protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
		
		MyResources resources = (MyResources)request.getAttribute(WebUtil.RES);
		long time = System.currentTimeMillis() - resources.getStartTime();
		log.info("[uri:{}][耗时:{}ms]", resources.getUri(), time);
		
		super.postHandle(request, response);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		MyResources resources = (MyResources)request.getAttribute(WebUtil.RES);
		saveRequest(request);
		if(resources.getUri().contains("web-api")){
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(unlogin()));
		}
		else {
			redirectToUnLogin(request, response);
		}
		return false;
	}

	protected void redirectToUnLogin(ServletRequest request, ServletResponse response) throws IOException {
		String unloginUrl = getUnLoginUrl();
		WebUtils.issueRedirect(request, response, unloginUrl);
	}
	
	protected boolean isUnLoginRequest(ServletRequest request, ServletResponse response) {
        return pathsMatch(getUnLoginUrl(), request);
    }

	protected boolean isIgnoreRequests(ServletRequest request, ServletResponse response) {
		Boolean isIgnoreRequests = Boolean.FALSE;
		if (null != ignoreUrls && "" != ignoreUrls) {
			String[] ignoreUrlArray = ignoreUrls.split(",");
			for (String ignoreUrl : ignoreUrlArray) {
				if (pathsMatch(ignoreUrl, request)) {
					isIgnoreRequests = Boolean.TRUE;
				}
			}
		}
		return isIgnoreRequests;
	}
	
	private Response<Void> unlogin() {
		Response<Void> responseVO = new Response<Void>();
		responseVO.setResponseStatus(StatusEnum.FAIL);
		responseVO.setResponseStatus(UserErrorEnum.ERR01);
		return responseVO;
	}

	public String getIgnoreUrls() {
		return ignoreUrls;
	}

	public void setIgnoreUrls(String ignoreUrls) {
		this.ignoreUrls = ignoreUrls;
	}

	public String getUnLoginUrl() {
		return unLoginUrl;
	}

	public void setUnLoginUrl(String unLoginUrl) {
		this.unLoginUrl = unLoginUrl;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
*/