package com.xh.token.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.xh.token.api.annotation.AuthIgnore;
import com.xh.token.api.annotation.LoginUser;
import com.xh.token.api.common.utils.Result;
import com.xh.token.api.common.utils.TokenUtil;
import com.xh.token.api.common.validator.Assert;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @QQ 1033542070
 * @date 2018年3月7日
 */
@RestController
@RequestMapping("/api")
public class ApiLoginController {

	/**
	 * 登录
	 */
	@AuthIgnore
	@GetMapping("login")
	public String login() {

		String name = "15290865680";
		return JSON.toJSONString(name);
	}

	/**
	 * 登录
	 */
	@AuthIgnore
	@PostMapping("login2")
	public Result login2(HttpServletRequest request, String mobile, String password) {
		Assert.isBlank(mobile, "手机号不能为空");
		Assert.isBlank(password, "密码不能为空");

		String name = "18342324340";
		String pwd = "admin";

		// 用户登录
		if (!name.equals(mobile) && !password.equals(pwd)) {
			Assert.isNull(null, "手机号或密码错误");
		}

		TokenUtil token = new TokenUtil();
		// 生成token
		Map<String, Object> map = token.createToken(1l);

		request.getSession().setAttribute("token", map);
		return Result.ok(map);
	}

	
	@LoginUser
	@PostMapping("show")
	public Result show(HttpServletRequest request) {
		Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("token");
		return Result.ok(map);
	}
}
