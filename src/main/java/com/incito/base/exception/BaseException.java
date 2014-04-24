package com.incito.base.exception;

/**
 * @title :底层异常类，当系统出现运行时异常时都抛出此类异常
 * @description :
 * @author: zhaiguangtao
 * @date: 2014-2-16
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    /**
	 * @description:
	 */
	public BaseException(){
		super();
	}
	/**
	 * @description: 
	 * @param message
	 */
	public BaseException(String message){
		super(message);
	}
    /**
     * @description: 
     * @param cause
     */
    public BaseException(Throwable cause) {
        super(cause);
    }
	/**
	 * @description: 
	 * @param message
	 * @param cause
	 */
	public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
