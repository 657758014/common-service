package thy.common.service.bean;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 基础通用service
 * 
 * @author wanghaiming
 * @since 2018-10-23
 * @param <T> 实体对象继承BaseEntity
 * @param <PK> 主键字段类型
 */
public abstract class BaseService<T extends BaseEntity, PK extends Serializable> implements ICURD<T, PK>, IPage<T> {

	protected abstract BaseMapper<PK, T, BaseExample> getMapper();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <Example extends BaseExample> PageInfo<T> search(Example example, PageHandler pageHandler) {
		if(pageHandler.getOrderBy() == null || pageHandler.getOrderBy().trim() == ""){
			PageHelper.startPage(pageHandler.getPageNo(), pageHandler.getPageSize());
		}else{
			PageHelper.startPage(pageHandler.getPageNo(), pageHandler.getPageSize(), pageHandler.getOrderBy());
		}
		List<T> list = select(example);
		PageInfo pageInfo = new PageInfo(list);
		return pageInfo;
	}

	@Override
	public T insert(T entity) {
		if(entity == null){
			throw new IllegalArgumentException("新增实体不能为空");
		}
		getMapper().insertSelective(entity);
		return entity;
	}

	@Override
	public int update(T entity) {
		return getMapper().updateByPrimaryKey(entity);
	}

	@Override
	public int updateSelective(T entity) {
		return getMapper().updateByPrimaryKeySelective(entity);
	}

	@Override
	public int delete(PK id) {
		if(id == null){
			return 0;
		}
		return getMapper().deleteByPrimaryKey(id);
	}

	@Override
	public T get(PK id) {
		if(id == null){
			return null;
		}
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public <Example extends BaseExample> List<T> select(Example example) {
		return getMapper().selectByExample(example);
	}
	
	@Override
	public <Example extends BaseExample> T selectOne(Example example) {
		List<T> list = select(example);
		return list.size() == 0 ? null : list.get(0);
	}
	
	@Override
	public <Example extends BaseExample> int count(Example example) {
		return getMapper().countByExample(example);
	}

	@Override
	public <Example extends BaseExample> int delete(Example example) {
		return getMapper().deleteByExample(example);
	}

	@Override
	public <Example extends BaseExample> int update(T entity, Example example) {
		return getMapper().updateByExample(entity, example);
	}

	@Override
	public <Example extends BaseExample> int updateSelective(T entity, Example example) {
		return getMapper().updateByExampleSelective(entity, example);
	}
	
}
