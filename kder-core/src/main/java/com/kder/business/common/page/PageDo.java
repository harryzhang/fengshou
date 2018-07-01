package com.kder.business.common.page;

import java.io.Serializable;
import java.util.List;

public class PageDo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long page; // 当前页
    private Long rows; // 每页记录数
    private Long total; // 总记录数
    private Long totalPage; // 总页数
    private List<T> datas; // 实体对象列表

    public PageDo() {

    }

    public PageDo(Long currentPage, Long pageSize, Long totalCount, List<T> modelList) {
        this.setPage(currentPage);
        this.setRows(pageSize);
        this.setTotal(totalCount);
        long totalPage = (getTotal() / getRows()) + ((getTotal() % getRows()) > 0 ? 1 : 0);
        this.setTotalPage(totalPage);
        this.setDatas(modelList);
    }

    /**
     * 当前页
     * 
     * @return currentPage
     */
    public Long getPage() {
        return page;
    }

    /**
     * 当前页
     * 
     * @param currentPage the currentPage to set
     */
    public void setPage(Long currentPage) {
        if (currentPage == null || currentPage.intValue() <= 0) {
            currentPage = 1l;
        }
        this.page = currentPage;
    }

    /**
     * 每页记录数
     * 
     * @return pageSize
     */
    public Long getRows() {
        return rows;
    }

    /**
     * 每页记录数
     * 
     * @param pageSize the pageSize to set
     */
    public void setRows(Long pageSize) {
        if (pageSize == null || pageSize.intValue() <= 0) {
            pageSize = 10l;
        }
        this.rows = pageSize;
    }

    /**
     * 总记录数
     * 
     * @return totalCount
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 总记录数
     * 
     * @param totalCount the totalCount to set
     */
    public void setTotal(Long totalCount) {
        if (totalCount == null) {
            totalCount = 0l;
        }
        this.total = totalCount;
    }

    /**
     * 总页数
     * 
     * @return totalPage
     */
    public Long getTotalPage() {
        return totalPage;
    }

    /**
     * 总页数
     * 
     * @param totalPage the totalPage to set
     */
    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 实体对象
     * 
     * @return modelList
     */
    public List<T> getDatas() {
        return datas;
    }

    /**
     * 实体对象
     * 
     * @param modelList the modelList to set
     */
    public void setDatas(List<T> modelList) {
        this.datas = modelList;
    }

    /**
     * 返回limit起始位移量 
     * @return  
     */
    public Long getOffset() {
        long current = getPage() == null ? 1L : getPage();
        long size = getRows() == null ? 0L : getRows();
        return (current - 1) * size;
    }

    /**   
     * 计算并设置分页总页数
     */
    public void calTotalPage() {
        int totalPage = (int) (total / getRows() + ((total % getRows() == 0) ? 0 : 1));
        setTotalPage((long) totalPage);
    }
}