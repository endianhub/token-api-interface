package com.xh.token.api.common.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xh.token.api.annotation.AuthIgnore;
import com.xh.token.api.common.exception.ResultException;

/**
 * <p>Title: 权限(Token)验证</p>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @date 2018年4月12日
 * 
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	public static final String USER_KEY = "userId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		AuthIgnore annotation;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
		} else {
			return true;
		}

		// 如果有@IgnoreAuth注解，则不验证token
		if (annotation != null) {
			return true;
		}

		// 从header中获取token
		String token = request.getHeader("token");
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter("token");
		}

		// token为空
		if (StringUtils.isBlank(token)) {
			throw new ResultException("token不能为空");
		}

		// 查询token信息
		Map tokenMap = (Map) request.getSession().getAttribute("token");
		if (tokenMap == null) {
			throw new ResultException("token失效，请重新登录");
		}

		// 设置userId到request里，后续根据userId，获取用户信息

		return true;
	}
}
