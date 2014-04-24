package com.incito.base.log;

import org.apache.log4j.Logger;

/**
 * @title :日志文件基类，用于记录各种级别的日志信息(Log4j)
 * @deprecated:日志文件基类，用于记录各种级别的日志信息(Log4j)
 * @author: zhaiguangtao
 * @date: 2014-02-16
 */
@SuppressWarnings("unchecked")
public class BaseLog {
    
    /**
     * info:
     * 记录消息提示级别的日志
     * */
    public static void i(Class clazz, String message) {
    	Logger.getLogger(clazz).info(message);
    }
    
    /**
     * debug:
     * 记录开发调试级别日志
     * */
    public static void d(Class clazz, String message) {
    	Logger.getLogger(clazz).debug(message);
    }
    
    /**
     * @title: error记录开发错误级别日志
     * @param Class class
     * @param message   错误消息
     * @param Exception 异常对象
     * @return：String  拼接后的信息
     * eg:BaseLog.error(this.getClass(), "xxx方法：验证xx表单异常", e);
     */
    public static void e(Class clazz, String message,Exception e) {
        String errorInfo = logStyle(clazz.getName(), message, e);
    	Logger.getLogger(clazz).error(errorInfo);
    }
    
    /**
     * @title: error记录开发错误级别日志
     * @param Class class
     * @param message   错误消息
     * @param Exception 异常对象
     * @return：String  拼接后的信息
     * eg:BaseLog.error(this.getClass(), "xxx方法：验证xx表单异常");
     */
    public static void e(Class clazz, String message) {
        Logger.getLogger(clazz).error(message);
    }
    
    /**
     * warn:
     * 记录开发警告级别日志
     * */
    public static void w(Class clazz, String message) {
        Logger.getLogger(clazz).warn(message);
    }
    
    /**
     * @description: 错误信息日志内容组装
     * @param className 类名
     * @param message   错误消息
     * @param Exception 异常对象
     * @return：String  拼接后的信息
     * eg:BaseLog.error(this.getClass(), "xxx方法：验证xx表单异常", e);
     */
    private static String logStyle(String className,String message,Exception e) {
        StringBuffer info = new StringBuffer("");
        info.append("\n错误位置:\n\t");
        info.append(className);
        info.append("\n描述:\n\t");
        info.append(message);
        info.append("\n类型:\n\t");
        info.append(e.getMessage());
        info.append("\n堆栈信息:\n");
      
        StackTraceElement[] message1 = e.getStackTrace();
        int cou = message1.length;
        
        for (int i = 0; i < cou; i++) {
            info.append("\t" + message1[i].toString() + "\n");
        }
        return info.toString();
    }
}
