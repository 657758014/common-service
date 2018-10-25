package thy.common.service.bean;

import com.github.pagehelper.PageInfo;

/**
 * 通用接口-分页
 * @author wanghaiming
 * @since 2018-10-23
 * @param <T>
 */
public interface IPage<T extends BaseEntity> {
	
	/**
	 * 根据模板对象进行分页查询
	 * @param example
	 * @param pageHandler
	 * @return
	 */
	<Example extends BaseExample> PageInfo<T> search(Example example, PageHandler pageHandler);
}
