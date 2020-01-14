package com.koc.auth.user.dao;

import com.koc.auth.user.entity.domain.User;
import com.koc.auth.user.entity.dto.UserPageDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/11/19
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Select("<script>" +
            "select * from student" +
            "<where>"+
            "<if test=\"dto.sid != null and dto.sid != ''\"> AND sid = #{dto.sid}</if>" +
            "<if test=\"dto.sname != null and dto.sname != ''\"> AND sname = #{dto.sname}</if>" +
            "<if test=\"dto.sno != null and dto.sno != ''\"> AND sno = #{dto.sno}</if>" +
            "<if test=\"dto.password != null and dto.password != ''\"> AND password = #{dto.password}</if>"+
            "<if test=\"dto.idcard != null and dto.idcard != ''\"> AND idcard = #{dto.idcard}</if>"+
            "<if test=\"dto.type != null\"> AND type = #{dto.type}</if>"+
            "</where>"+
            "</script>")
    @ResultType(User.class)
    List<User> findAll(@Param("dto") UserPageDto dto);
}
