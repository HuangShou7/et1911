package com.etoak.exception;
//自定义异常
/**
 * 异常类型::
 * 运行时异常 - 非检查型Unchecked Exception:
 * 编译时异常 - 检查型checked exception:
 */
public class ParamException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamException(String message) {
		super(message);
	}
}
