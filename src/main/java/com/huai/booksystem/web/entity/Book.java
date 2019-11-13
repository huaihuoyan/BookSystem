package com.huai.booksystem.web.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.huai.booksystem.unit.DatetimeUnit;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Created by laiyunjing
 * @Date 2019/11/13 22:30
 * @Version
 */
@Entity
@Table(name="T_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "用户名不为空")
    @Column(length = 30)
    private String name;

    @Column(precision = 10,scale = 2 )
    private BigDecimal danjia;

    @NotEmpty(message = "作者不为空")
    @Column(length = 30)
    private String author;

    @NotEmpty(message = "出版社不为空")
    @Column(length = 30)
    private String cbs;

    @NotNull(message = "数量不为空")
    @Column(length = 10)
    private Integer num;

    @Column(length = 200)
    private String imagerUrl;

    @ManyToOne
    @JoinColumn(name = "booktypeId")
    private BookType bookType;


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

    public BigDecimal getDanjia() {
        return danjia;
    }

    public void setDanjia(BigDecimal danjia) {
        this.danjia = danjia;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCbs() {
        return cbs;
    }

    public void setCbs(String cbs) {
        this.cbs = cbs;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImagerUrl() {
        return imagerUrl;
    }

    public void setImagerUrl(String imagerUrl) {
        this.imagerUrl = imagerUrl;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
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
