package com.huai.booksystem.web.controller;

import com.huai.booksystem.web.dao.MenuDao;
import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/23 0023 11:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/houtai/menu")
public class HoutaiMenuController {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/manage")
    public ModelAndView manage(@RequestParam(value = "pId",required = false) Integer pId) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "菜单管理");
        mav.addObject("title", "菜单管理");
        mav.addObject("pId",pId);
        mav.setViewName("/admin/page/menu/menu_manage");
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam(value = "pId",required = false) Integer pId) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("btn_text", "添加");
        mav.addObject("save_url", "/admin/menu/add");
        mav.addObject("pId",pId);
        mav.setViewName("/admin/page/menu/add_update");
        return mav;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Menu menu = menuDao.findId(id);
        mav.addObject("menu", menu);
        mav.addObject("btn_text", "修改");
        mav.addObject("pId",menu.getPid());
        mav.addObject("save_url", "/admin/menu/update?id=" + id);
        mav.setViewName("/admin/page/menu/add_update");
        return mav;
    }
}
