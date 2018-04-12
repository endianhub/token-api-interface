package com.xh.token.api.common.validator;

import org.apache.commons.lang3.StringUtils;

import com.xh.token.api.common.exception.ResultException;

/**
 * <p>Title: 数据校验</p>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @date 2018年4月12日
 * 
 */
public abstract class Assert {

	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str)) {
			throw new ResultException(message);
		}
	}

	public static void isNull(Object object, String message) {
		if (object == null) {
			throw new ResultException(message);
		}
	}
}
