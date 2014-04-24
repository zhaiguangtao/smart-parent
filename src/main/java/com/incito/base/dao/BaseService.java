package com.incito.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.incito.base.exception.BaseException;
import com.incito.base.log.BaseLog;

/**
 * @title :数据库公共操作接口实现类
 * @description: 数据库IBATIS公共操作接口实现类
 * @author: zhaiguangtao
 * @date: 2014-02-16
 */
@Service
public class BaseService extends SqlMapClientTemplate {
	
    /**
     * @description: 带传入参数查询
     * @param statementName
     * @param parameterObject ：传入参数
     */
    public Object findForObject(String statementName, Object parameterObject) {
    	try {
    		 return super.queryForObject(statementName,parameterObject);
		} catch (Exception e) {
			 BaseLog.e(this.getClass(), "findForObject", e);
	         throw new BaseException("传入参数查询错误，或数据库连接异常");
		}
    }
    
    /**
     * @description:带传入参数返回值查询
     * @param statementName
     * @param parameterObject：传入参数
     * @param resultObject：返回值类型
     */
    public Object findForObject(String statementName, Object parameterObject,
            Object resultObject) {
    	try {
    		return super.queryForObject(statementName,parameterObject, resultObject);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "findForObject:resultObject", e);
	        throw new BaseException("带传入参数返回值查询错误，或数据库连接异常");
		}
    }
    
    /**
     * @description: 带传入参数集合查询
     * @param statementName
     * @param parameterObject：传入参数
     * @return
     */
    public List findForList(String statementName, Object parameterObject) {
    	try {
    		return super.queryForList(statementName, parameterObject);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "findForList", e);
	        throw new BaseException("带传入参数集合查询错误，或数据库连接异常");
		}
        
    }
    
    /**
     * @description: 带传入参数分页查询
     * @param statementName
     * @param parameterObject
     * @param skipResults ：跳过记录数
     * @param maxResults ：每页最多记录数
     * @return
     */
    public List findForList(String statementName, Object parameterObject,
            int skipResults, int maxResults) {
    	try {
    		return super.queryForList(statementName,parameterObject, skipResults, maxResults);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "findForList分页", e);
	        throw new BaseException("带传入参数分页查询错误，或数据库连接异常");
		}
        
    }
    
    public Map findForMap(String statementName, Object parameterObject,
            String keyProperty) {
    	try {
    		return super.queryForMap(statementName, parameterObject, keyProperty);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "findForMap", e);
	        throw new BaseException("带传入参数的map查询错误，或数据库连接异常");
		}
    }
    
    public Map findForMap(String statementName, Object parameterObject,
            String keyProperty, String valueProperty) {
    	try {
    		return super.queryForMap(statementName,parameterObject, keyProperty, valueProperty);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "findForMap：带返回值", e);
	        throw new BaseException("带返回值的map查询错误，或数据库连接异常");
		}
    }
    
    /**
     * @description: 带传入参数插入操作插入操作
     * @param statementName
     * @param parameterObject
     * @return
     */
    public Object addObject(String statementName, Object parameterObject) {
    	try {
    		return super.insert(statementName, parameterObject);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "addObject", e);
	        throw new BaseException("带传入参数插入操作插入操作错误，或数据库连接异常");
		}
    }
    
    /**
     * @description:更新对象
     * @param statementName
     * @param parameterObject
     * @return
     */
    public int updObject(String statementName, Object parameterObject) {
    	try {
    		return super.update(statementName,parameterObject);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "updObject", e);
	        throw new BaseException("更新对象错误，或数据库连接异常");
		}
    }
    
    public void updObject(String statementName, Object parameterObject,
            int requiredRowsAffected) {
    	try {
    		super.update(statementName,parameterObject, requiredRowsAffected);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "updObject:requiredRowsAffected", e);
	        throw new BaseException("更新对象错误，或数据库连接异常");
		}
    }
    
    /**
     * @description: 删除对象
     * @param statementName
     * @param parameterObject
     * @return
     */
    public int delObject(String statementName, Object parameterObject) {
    	try {
    		return super.delete(statementName,parameterObject);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "delObject", e);
	        throw new BaseException("删除对象错误，或数据库连接异常");
		}
    }
    
    public void delObject(String statementName, Object parameterObject,
            int requiredRowsAffected) {
    	try {
    		super.delete(statementName,parameterObject, requiredRowsAffected);
		} catch (Exception e) {
			BaseLog.e(this.getClass(), "delObject:requiredRowsAffected", e);
	        throw new BaseException("删除对象错误，或数据库连接异常");
		}
    }
    
    /**
     * @title: 获取ibatis数据层处理对象,
     * @description:用于事物开启,提交,回滚,批处理等操作
     * @return：taskey
     */
    public SqlMapClient getSqlMapClient(){
        return super.getSqlMapClient();
    }

	@Autowired
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
}