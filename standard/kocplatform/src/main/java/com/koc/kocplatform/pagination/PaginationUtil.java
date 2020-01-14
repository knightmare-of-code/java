package com.koc.kocplatform.pagination;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * ClassName:PaginationUtil
 * Description:分页工具类
 * Author: yuxiaoyu
 * Date: 2019/9/29
 */
public class PaginationUtil {

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param select
     * @param <T>
     * @return
     */
    public static <T> PageableResultVo<T> list(int pageNum, int pageSize, ISelect select) {
        Page<T> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(select);
        return new PageableResultVo<>(page.getTotal(), page.getResult());
    }

    /**
     * 分页查询使用PageHelper的orderBy
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @param select
     * @param <T>
     * @return
     */
    public static <T> PageableResultVo<T> list(int pageNum, int pageSize, String orderBy, ISelect select) {
        Page<T> page = PageHelper.startPage(pageNum, pageSize).setOrderBy(orderBy).doSelectPage(select);
        return new PageableResultVo<>(page.getTotal(), page.getResult());
    }

    /**
     * 只查count
     * @param select
     * @return
     */
    public static long count(ISelect select) {
        return PageHelper.count(select);
    }

}
