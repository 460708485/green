package com.wang.green.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * @version 1.0
 * @author wangjq
 *
 */
public interface BaseDao<T> {

	/**
	 * @Description:得到数据对象
	 * @param param
	 *            map参数
	 * @return 实体对象
	 */
	public abstract T getModel(Map<String, Object> param);

	/**
	 * @Description:创建数据对象
	 * @param po
	 *            实体对象
	 */
	public abstract void insert(T po);

	/**
	 * @Description:批量创建数据对象
	 * @param po
	 *            实体对象
	 */
	public abstract void insertBat(final List<T> list);

	/**
	 * @Description:单条修改数据对象
	 * @param po
	 *            实体对象
	 * @return 所影响的行数
	 */
	public abstract int update(T po);

	/**
	 * @Description:批量修改数据对象
	 * @param po
	 *            实体对象
	 * @return 所影响的行数
	 */
	public abstract void updateBatch(final List<T> list);

	/**
	 * @Description:批量修改数据对象
	 * @param param
	 *            map参数
	 * @return 所影响的行数
	 */
	public abstract int updateList(Map<String, Object> param);

	/**
	 * @Description:删除数据对象
	 * @param param
	 *            map参数
	 * @return 所影响的行数
	 */
	public abstract int delete(Map<String, Object> param);

	/**
	 * 得到数据对象集合
	 * 
	 * @return
	 */
	public abstract List<T> list();
	
	/**
	 * @Description:得到数据对象列表
	 * @param param
	 *            map参数
	 * @return 实体列表
	 */
	public abstract List<T> list(Map<String, Object> param);

	/**
	 * <p>
	 * 批量删除数据对象
	 * 
	 * @param ids
	 *            String 格式：ID之间以","分隔开。
	 * @return 所影响的行数
	 * @author libing
	 * @created 2011-09-07
	 */
	public abstract int deleteBatch(String ids);

	/**
	 * 批量添加
	 * 
	 * @param method
	 * @param obj
	 * @return
	 */
	int batchAdd(String method, Object obj);

	/**
	 * 分页查询数据
	 * 
	 * @param params
	 * @param startIndex
	 * @return
	 */
	public List<T> getForPageList(Map<String, Object> params, int startIndex, int pageSize);
}
