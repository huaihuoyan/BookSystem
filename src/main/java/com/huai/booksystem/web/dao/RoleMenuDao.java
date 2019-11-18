package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:46
 * @Version
 */
public interface RoleMenuDao extends JpaRepository<RoleMenu,Integer>, JpaSpecificationExecutor<RoleMenu> {
}
