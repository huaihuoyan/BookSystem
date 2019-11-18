package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:41
 * @Version
 */
public interface RoleDao extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Role> {
    
}
