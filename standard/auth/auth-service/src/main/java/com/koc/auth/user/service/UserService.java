package com.koc.auth.user.service;

import com.koc.auth.user.dao.UserMapper;
import com.koc.auth.user.entity.domain.User;
import com.koc.auth.user.entity.dto.UserPageDto;
import com.koc.kocplatform.pagination.PageableResultVo;
import com.koc.kocplatform.pagination.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/11/19
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User add(User dto) {
        this.userMapper.insert(dto);
        return dto;
    }

    @Override
    @Transactional
    public void delete(Long sid) {
        this.userMapper.deleteByPrimaryKey(sid);
    }
    
    @Override
    @Transactional
    public User update(User dto) {
        this.userMapper.updateByPrimaryKey(dto);
        return dto;
    }
    
    @Override
    public User findById(Long sid) {
        return this.userMapper.selectByPrimaryKey(sid);
    }

    @Override
    public List<User> findAll(UserPageDto dto) {
        return this.userMapper.findAll(dto);
    }

    @Override
    public PageableResultVo<User> listAll(UserPageDto dto) {
        return PaginationUtil.list(dto.getPageNum(), dto.getPageSize(),()-> this.userMapper.findAll(dto));
    }


}
