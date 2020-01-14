package com.koc.auth.user.entity.domain;

import com.koc.kocplatform.utils.UUIdGenId;
import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description:
 * Author: yuxiaoyu
 * Date: 2019/11/19
 */
@Table(name = "user")
public class User {

    @Id
    @KeySql(genId = UUIdGenId.class)
    @ApiModelProperty(value = "主键")
    private String sid;

    @ApiModelProperty(value = "姓名")
    private String sname;

    @ApiModelProperty(value = "学生卡")
    private String idcard;

    @ApiModelProperty(value = "学号")
    private String sno;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "银行卡号")
    private String bankid;

    @ApiModelProperty(value = "是否缴费 0:未缴费，1已缴费")
    private Integer ispay;

    @ApiModelProperty(value = "是否管理员 0:学生，1管理员")
    private Integer type;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
