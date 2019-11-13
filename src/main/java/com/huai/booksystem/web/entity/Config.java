package com.huai.booksystem.web.entity;

import javax.persistence.*;

/**
 * 网站配置
 * @Created by laiyunjing
 * @Date 2019/11/12 22:02
 * @Version
 */
@Entity
@Table(name="T_CONFIG")
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(length = 50)
    private String webName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }
}
