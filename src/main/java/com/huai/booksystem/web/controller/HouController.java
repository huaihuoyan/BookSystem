package com.huai.booksystem.web.controller;

import com.huai.booksystem.web.dao.RoleDao;
import com.huai.booksystem.web.entity.Role;
import com.huai.booksystem.web.entity.User;
import com.huai.booksystem.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/19 0019 11:36
 * @Version 1.0
 */
@Controller
@RequestMapping("/hou/role")
public class HouController {

    @Resource
    private RoleDao roleDao;
    @Autowired
    private RoleService roleService;


    /**
     * /houtai/user/manage
     */
    @RequestMapping("/manage")
    public ModelAndView manage() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "角色管理");
        mav.addObject("title", "角色管理");
        mav.setViewName("/admin/page/role/role_manage");
        return mav;
    }

    /**
     * /houtai/user/add
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public ModelAndView add() throws Exception {
        ModelAndView mav = new ModelAndView();

//        Map<String, Object> map = null;
//        List<Role> roleList = roleService.list(map, 0, 1000);
//        mav.addObject("roleList", roleList);
//        mav.addObject("flag", true);
        mav.addObject("btn_text", "添加");
        mav.addObject("save_url", "/admin/role/add");
        mav.setViewName("/admin/page/role/add_update");
        return mav;
    }

    /**
     * /houtai/user/edit?id=1
     * @return
     * @throws Exception
     */
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();

//        Map<String, Object> map = null;
//        List<Role> roleList = roleService.list(map, 0, 1000);
//        mav.addObject("roleList", roleList);

        Role role = roleDao.findId(id);
        mav.addObject("role", role);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/admin/role/update?id=" + id);
        mav.setViewName("/admin/page/role/add_update");
        return mav;
    }

    /**
     * /houtai/user/set_new_pwd?id=1
     * @return
     * @throws Exception
     */
    @RequestMapping("/set_menu")
    public ModelAndView set_new_pwd(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Role  role = roleDao.findId(id);
        mav.addObject("role", role);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/admin/role/update?id=" + id);
        mav.setViewName("/admin/page/role/set_menu");
        return mav;
    }

}
