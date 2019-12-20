package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.entity.Role;
import com.huai.booksystem.web.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:46
 * @Version
 */
public interface RoleMenuDao extends JpaRepository<RoleMenu,Integer>, JpaSpecificationExecutor<RoleMenu> {

    @Query(value = "select * from T_ROLE_MENU where id = ?1",nativeQuery = true)
    RoleMenu findId(Integer id);

    @Query(value = "select * from T_ROLE_MENU where role_id = ?1 and menu_id = ?2",nativeQuery = true)
    RoleMenu findByRoleIdAndMenuId(Integer roleId,Integer MenuId);

    @Transactional
    @Modifying
    @Query(value = "delete  from T_ROLE_MENU where role_id = ?1",nativeQuery = true)
    Integer deleteByRoleId(Integer roleId);

    List<RoleMenu>findByRole(Role role);


}
