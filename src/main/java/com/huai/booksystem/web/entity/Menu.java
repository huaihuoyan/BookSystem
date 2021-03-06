package com.huai.booksystem.web.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 菜单
 * @Created by laiyunjing
 * @Date 2019/11/13 21:46
 * @Version
 */
@Entity
@Table(name="T_MENU")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private Integer pId;

    @Column(length =50)
    private String name;

    @Column(length =200)
    private String url;

    @Column(length =10)
    private Integer state;

    @Column(length =100)
    private String icon;

    @Column(length =100)
    private String perssion;

    @Column(length =10)
    private Integer type;

    @Column(length =50)
    private String divId;

    @NotNull(message = "排序号不为空")
    @Column(length = 10)
    private Integer orderNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPerssion() {
        return perssion;
    }

    public void setPerssion(String perssion) {
        this.perssion = perssion;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDivId() {
        return divId;
    }

    public void setDivId(String divId) {
        this.divId = divId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
