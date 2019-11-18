package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:43
 * @Version
 */
public interface MenuDao extends JpaRepository<Menu,Integer>, JpaSpecificationExecutor<Menu> {
}
