package com.incito.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @title 手动静态获取bean对象工具类
 * @author zhaiguangtao
 * @date 2014-02-16
 */
@Component
public class SpringContextUtils implements ApplicationContextAware{

    // spring 容器上下文对象
	private static ApplicationContext ctx = null;

    public void setApplicationContext(ApplicationContext context)throws BeansException {
        ctx = context;
    }
    
    public static ApplicationContext getApplicationContext() throws BeansException {
    	checkApplicationContext();
        return ctx;
    }
    
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) ctx.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) ctx.getBeansOfType(clazz);
	}

	/**
	 * 清除applicationContext静态变量.
	 */
	public static void cleanApplicationContext() {
		ctx = null;
	}

	private static void checkApplicationContext() {
		if (ctx == null) {
			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}
}
