package com.koc.kocplatform.pagination;

/**
 * ClassName:
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/4/4
 */
public class PaginationDto {

    private int pageNum;
    private int pageSize;
    private String order;
    private String sort;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
