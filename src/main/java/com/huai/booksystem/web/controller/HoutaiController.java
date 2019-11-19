package com.huai.booksystem.web.controller;

import com.huai.booksystem.web.dao.UserDao;
import com.huai.booksystem.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:53
 * @Version
 */
@Controller
@RequestMapping("/houtai/user")
public class HoutaiController {

    @Autowired
    private UserDao userDao;



    /**
     * /houtai/role/manage
     */
    @RequestMapping("/manage")
    public ModelAndView manage() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "角色管理");
        mav.addObject("title", "角色管理");
        mav.setViewName("/admin/page/user/role_manage");
        return mav;
    }


    /**
     * /houtai/role/add
     */
    @RequestMapping("/add")
    public ModelAndView add() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("btn_text", "添加");
        mav.addObject("save_url", "/admin/role/add");
        mav.setViewName("/admin/page/user/add_update");
        return mav;
    }



    /**
     * /houtai/role/edit?id=1
     */
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        User user = userDao.findId(id);
        mav.addObject("user", user);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/admin/role/update?id=" + id);
        mav.setViewName("/admin/page/user/add_update");
        return mav;
    }


    @RequestMapping("/set_new_pwd")
    public ModelAndView set_new_pwd(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        User user = userDao.findId(id);
        mav.addObject("user", user);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/admin/user/set_new_pwd?id=" + id);
        mav.setViewName("/admin/page/user/set_new_pwd");
        return mav;
    }
}
