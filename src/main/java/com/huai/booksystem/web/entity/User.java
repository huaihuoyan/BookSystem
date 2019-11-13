package com.huai.booksystem.web.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户
 * @Author: laiyunjing
 * @Date: 2019/11/13 0013 16:58
 * @Version 1.0
 */
@Entity
@Table(name="T_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "用户名不为空")
    @Column(length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @Column(length = 200)
    private String pwd;

    @NotNull(message = "用户名不为空")
    @Column(length = 200)
    private String turename;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTurename() {
        return turename;
    }

    public void setTurename(String turename) {
        this.turename = turename;
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

    public Date getCreatDateTime() {
        return creatDateTime;
    }

    public void setCreatDateTime(Date creatDateTime) {
        this.creatDateTime = creatDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
