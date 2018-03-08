package com.xh.token.api.common.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.token.api.common.utils.Result;

/**
 * <p>Title: 异常处理器</p>
 * <p>Description: 异常增强，以JSON的形式返回给客服端</p>
 * 
 * @author H.Yang
 * @date 2018年3月8日
 *
 */
@ControllerAdvice
public class RestExceptionHandler {

	private Logger logger = LogManager.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(ResultException.class)
	@ResponseBody
	public Result handleRRException(ResultException e) {
		Result r = new Result();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

}
