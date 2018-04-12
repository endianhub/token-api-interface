package com.xh.token.api.common.exception;

/**
 * <p>Title: 自定义异常</p>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @date 2018年4月12日
 * 
 */
public class ResultException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public ResultException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public ResultException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public ResultException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public ResultException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
