package com.wang.green.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 基础控制类 异常统一处理
 * 
 * @author wangjq
 *
 */
public class BaseController {

	private Logger logger = LoggerFactory.getLogger(BaseController.class);

	@ExceptionHandler(Throwable.class)
	public @ResponseBody ResponseVO<Void> processThrowable(Throwable t) {

		ResponseVO<Void> vo = new ResponseVO<Void>();

		vo.setResponseStatus(CommonStatusEnum.FAIL);

		if (t instanceof CommonException) {
			handleException(vo, t);
		} else {
			handleException(vo, (CommonException) t);
		}
		return null;

	}

	public void handleException(ResponseVO<Void> vo, Throwable t) {
		
		vo.addError(CommonErrorEnum.COMMON_ERROR_1);
		if(logger.isErrorEnabled()){
			String requestURI = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getRequestURI();
			logger.error("系统处理错误："+requestURI , t);
		}
		
	}

	private void handleException(ResponseVO<Void> vo, CommonException e) {
			if(null != e.getErrorEnum()){
				vo.addError(e.getErrorEnum());
			}
		
		
		
	}

}
