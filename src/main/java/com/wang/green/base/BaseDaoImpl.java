package com.wang.green.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected SqlMapClientTemplate sqlMapClientTemplate;
	
	@SuppressWarnings("unchecked")
	private Class<T> poClass = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	String poClassName = poClass.getSimpleName();
	
	@SuppressWarnings("unchecked")
	public T getModel(Map<String, Object> param) {
		return (T) this.sqlMapClientTemplate.queryForObject("get" + poClassName, param);
	}

	public void insert(T po) {
		// TODO Auto-generated method stub

	}

	public void insertBat(List<T> list) {
		// TODO Auto-generated method stub

	}

	public int update(T po) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateBatch(List<T> list) {
		// TODO Auto-generated method stub

	}

	public int updateList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		return this.sqlMapClientTemplate.queryForList("get" + poClassName);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(Map<String, Object> param) {
		return this.sqlMapClientTemplate.queryForList("get" + poClassName, param);
	}

	public int deleteBatch(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int batchAdd(String method, Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<T> getForPageList(Map<String, Object> params, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
