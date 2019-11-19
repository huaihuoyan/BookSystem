package com.huai.booksystem.web.service;

import com.huai.booksystem.web.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/19 0019 11:26
 * @Version 1.0
 */
public interface RoleService {

    Integer  add(Role role);
    Integer update(Role role);

    List<Role> list(Map<String,Object> map,Integer page,Integer pageSize);

    Long getTotal(Map<String,Object> map);

    Role findById(Integer id);

    Integer delete(Integer id);

    Integer updateMenu(Integer roleId,String menuIds);
}
