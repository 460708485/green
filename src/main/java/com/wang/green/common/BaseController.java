package com.wang.green.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

		
		
	}

	private void handleException(ResponseVO<Void> vo, CommonException e) {

	}

}
