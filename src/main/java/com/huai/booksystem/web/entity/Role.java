package com.huai.booksystem.web.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.huai.booksystem.unit.DatetimeUnit;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 角色
 * @Author: laiyunjing
 * @Date: 2019/11/13 0013 17:15
 * @Version 1.0
 */
@Entity
@Table(name="T_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "用户名不为空")
    @Column(length = 30)
    private String name;


    @Column(length = 200)
    private String remark;

    @NotNull(message = "排序号不为空")
    @Column(length = 10)
    private Integer orderNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @JsonSerialize(using = DatetimeUnit.class)
    public Date getCreatDateTime() {
        return creatDateTime;
    }

    public void setCreatDateTime(Date creatDateTime) {
        this.creatDateTime = creatDateTime;
    }

    @JsonSerialize(using = DatetimeUnit.class)
    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
