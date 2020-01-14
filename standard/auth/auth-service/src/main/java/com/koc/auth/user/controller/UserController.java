package com.koc.auth.user.controller;

import com.koc.auth.user.entity.domain.User;
import com.koc.auth.user.entity.dto.UserPageDto;
import com.koc.auth.user.service.IUserService;
import com.koc.kocplatform.pagination.PageableResultVo;
import com.koc.kocplatform.results.annotation.RestResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/11/19
 */
@RestController
@RequestMapping(value = "/student")
public class UserController {

    @Autowired
    private IUserService userService;

    @RestResponse
    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@RequestBody User dto) {
        return this.userService.add(dto);
    }

    @RestResponse
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long sid) {
        this.userService.delete(sid);
    }

    @RestResponse
    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User update(@RequestBody User dto) {
        return this.userService.update(dto);
    }

    @RestResponse
    @ApiOperation(value = "根据id查找用户")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public User findById(@RequestParam("sid") Long sid) {
        return this.userService.findById(sid);
    }

    @RestResponse
    @ApiOperation(value = "查询全部用户")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<User> findAll(@RequestBody UserPageDto dto) {
        return this.userService.findAll(dto);
    }

    @RestResponse
    @ApiOperation(value = "分页查询全部用户")
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public PageableResultVo<User> listAll(@RequestBody UserPageDto dto) {
        return this.userService.listAll(dto);
    }


}
