package com.huai.booksystem.web.controller;

import com.huai.booksystem.unit.BrowserveUnit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 主页
 * @Created by laiyunjing
 * @Date 2019/11/13 23:11
 * @Version
 */
@Controller
public class IndexController {

    /**
     *# 请求首页
     */
    @RequestMapping("/")
    public String  index_1(HttpServletResponse res, HttpServletRequest req) throws Exception {
        return "redirect:/login";
    }

    /**
     *   #请求首页  /index
     */
    @RequestMapping("/index")
    public String index(HttpServletResponse  res,HttpServletRequest req) throws Exception {
        return "redirect:/login";
    }


    /**
     *    /login
     *    #后台 用户电脑登陆
     */
    @RequestMapping("/login")
    public String login(){
        return "/pc/login/login";
    }

    /**
     * # 后台主页
     */
    @RequestMapping("/admin/main")
    public String admin_main(){
        return "/admin/main";
    }


}
