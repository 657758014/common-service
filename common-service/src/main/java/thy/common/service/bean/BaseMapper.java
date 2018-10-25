package thy.common.service.bean;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 基础通用CURD层,接口定义基础通用服务,各业务Mapper只需继承该接口并完成sqlMap的实现即可
 * @author wanghaiming
 * @since 2018-10-11
 * @param <PK,BaseEntity,BaseExample>主键,实体(所有业务实体必须继承BaseEntity),模板(所有业务模板必须继承BaseExample)
 */
@SuppressWarnings("hiding")
public interface BaseMapper<PK, BaseEntity, BaseExample> {
	
	/**
	 * 根据模板条件统计数量
	 * @param example
	 * @return
	 */
	int countByExample(BaseExample example);

    /**
     * 根据模板条件物理删除
     * @param example
     * @return
     */
    int deleteByExample(BaseExample example);

    /**
     * 根据主键物理删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(BaseEntity record);

    /**
     * 有选择的新增,忽略为null的字段
     * @param record
     * @return
     */
    int insertSelective(BaseEntity record);

    /**
     * 根据模板条件查询
     * @param example
     * @return
     */
    List<BaseEntity> selectByExample(BaseExample example);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    BaseEntity selectByPrimaryKey(PK id);

    /**
     * 根据模板条件有选择的修改,忽略为null的字段
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseEntity record, @Param("example") BaseExample example);

    /**
     * 根据模板条件修改
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseEntity record, @Param("example") BaseExample example);

    /**
     * 根据主键有选择的修改,忽略为null的字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseEntity record);

    /**
     * 根据主键修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseEntity record);
}
