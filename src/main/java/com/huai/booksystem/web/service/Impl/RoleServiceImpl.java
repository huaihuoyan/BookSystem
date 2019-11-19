package com.huai.booksystem.web.service.Impl;

import com.huai.booksystem.web.dao.MenuDao;
import com.huai.booksystem.web.dao.RoleDao;
import com.huai.booksystem.web.entity.Role;
import com.huai.booksystem.web.service.RoleMenuService;
import com.huai.booksystem.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/19 0019 11:27
 * @Version 1.0
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleMenuService roleMenuService;


    @Override
    public Integer add(Role role) {
        roleDao.save(role);
        return 1;
    }

    @Override
    public Integer update(Role role) {
        Role origin = roleDao.findId(role.getId());
       role = repalce(role,origin);
       roleDao.save(role);
        return 1;
    }

    @Override
    public List<Role> list(Map<String, Object> map, Integer page, Integer pageSize) {
        Pageable pageable = new PageRequest(page,pageSize, Sort.Direction.ASC,"orderNo");
        Page<Role> list = roleDao.findAll(pageable);
        return list.getContent();
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return roleDao.count();
    }

    @Override
    public Role findById(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer updateMenu(Integer roleId, String menuIds) {
        return null;
    }


    public Role repalce(Role curr,Role origin){
        if(curr.getName() == null){
            curr.setName(origin.getName());
        }

        if(curr.getOrderNo() == null){
            curr.setOrderNo(origin.getOrderNo());
        }
        if(curr.getCreatDateTime() == null){
            curr.setCreatDateTime(origin.getCreatDateTime());
        }
        if(curr.getRemark() == null){
            curr.setRemark(origin.getRemark());
        }
        return curr;
    }
}
