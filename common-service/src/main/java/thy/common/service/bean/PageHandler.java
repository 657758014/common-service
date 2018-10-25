package thy.common.service.bean;

import java.io.Serializable;

/**
 * 通用参数-分页对象
 * @author wanghaiming
 * @since 2018-10-23
 */
public class PageHandler implements Serializable {

	private static final long serialVersionUID = 9110192623519806178L;

	private Integer pageNo = 1;

    private Integer pageSize = 10;
    
    private String orderBy;//升降序

    public PageHandler() {
    }

    /**
     * 分页参数
     * @param pageNo
     * @param pageSize
     */
    public PageHandler(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
    
    /**
     * 分页参数
     * @param pageNo
     * @param pageSize
     * @param orderBy
     */
    public PageHandler(Integer pageNo, Integer pageSize, String orderBy) {
    	this.pageNo = pageNo;
    	this.pageSize = pageSize;
    	this.orderBy = orderBy;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}
