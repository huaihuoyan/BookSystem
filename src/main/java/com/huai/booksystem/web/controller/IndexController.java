package com.huai.booksystem.web.controller;

import com.huai.booksystem.unit.BrowserveUnit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 主页
 * @Created by laiyunjing
 * @Date 2019/11/13 23:11
 * @Version
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index_1(){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("/pc/index");
        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("/pc/index");
        return mav;
    }

    @RequestMapping("/admin/main")
    public ModelAndView admin_main(){
        ModelAndView mav  = new ModelAndView();
        mav.setViewName("/pc/index");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mav  = new ModelAndView();
       String UserAgent = request.getHeader("User-Agent");
        if(BrowserveUnit.checkUserAger(UserAgent)){
            mav.setViewName("/pc/login/login");
        }else {
            mav.setViewName("/common/s_mode");
        }

        return mav;
    }


}
