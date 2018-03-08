package com.xh.token.api.common.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @QQ 1033542070
 * @date 2018年3月7日
 */
public class TokenUtil {

	private final Logger LOGGER = LogManager.getLogger(getClass());

	// 12小时后过期
	private final static int EXPIRE = 3600 * 12;

	public Map<String, Object> createToken(long userId) {
		// 生成一个token
		String token = UUID.randomUUID().toString();
		// 当前时间
		Date now = new Date();

		// 过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
		LOGGER.info("过期时间：" + expireTime);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);
		map.put("expire", EXPIRE);
		
		LOGGER.info("map：" + map.toString());
		
		return map;
	}
}
