package thy.common.service.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 通用接口-增删改查
 * @author wanghaiming
 * @since 2018-10-23
 * @param <T>
 * @param <PK>
 */
public interface ICURD<T extends BaseEntity, PK extends Serializable> {

	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	T insert(T entity);
	
	/**
	 * 全部修改
	 * @param entity
	 * @return
	 */
	int update(T entity);
	
	/**
	 * 有选择的修改
	 * @param entity
	 * @return
	 */
	int updateSelective(T entity);
	
	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	int delete(PK id);
	
	/**
	 * 查询
	 *
	 * @param id
	 * @return
	 */
	T get(PK id);
	
	/**
	 * 查找数量
	 *
	 * @param example
	 * @return
	 */
	<Example extends BaseExample> int count(Example example);
	
	/**
	 * 通过模板查询
	 * 
	 * @param example
	 * @return
	 */
	<Example extends BaseExample> List<T> select(Example example);
	
	/**
	 * 通过模板查找单个
	 *
	 * @param example
	 * @return
	 */
	<Example extends BaseExample> T selectOne(Example example);
	
	/**
	 * 根据模板条件删除
	 * 
	 * @param example
	 * @return
	 */
	<Example extends BaseExample> int delete(Example example);
	
	/**
	 * 根据模板条件修改
	 * 
	 * @param entity 需要改的字段值
	 * @param example 条件
	 * @return
	 */
	<Example extends BaseExample> int update(T entity, Example example);
	
	/**
	 * 根据模板条件有选择的修改
	 * 
	 * @param entity 需要改的字段值
	 * @param example 条件
	 * @return
	 */
	<Example extends BaseExample> int updateSelective(T entity, Example example);
}
