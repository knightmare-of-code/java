package com.koc.kocplatform.pagination;

import java.util.List;

public class PageableResultVo<T> {

    public PageableResultVo() {
    }

    public PageableResultVo(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
