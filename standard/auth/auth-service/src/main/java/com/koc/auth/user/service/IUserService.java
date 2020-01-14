package com.koc.auth.user.service;

import com.koc.auth.user.entity.domain.User;
import com.koc.auth.user.entity.dto.UserPageDto;
import com.koc.kocplatform.pagination.PageableResultVo;

import java.util.List;

/**
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/11/19
 */
public interface IUserService {

    User add(User dto);

    void delete(Long sid);

    User update(User dto);

    User findById(Long sid);

    List<User> findAll(UserPageDto dto);

    PageableResultVo<User> listAll(UserPageDto dto);
    
}
