package com.huai.booksystem.web.controller;

import com.huai.booksystem.unit.BrowserveUnit;
import com.huai.booksystem.web.dao.MenuDao;
import com.huai.booksystem.web.dao.RoleMenuDao;
import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.entity.RoleMenu;
import com.huai.booksystem.web.entity.User;
import com.huai.booksystem.web.service.MenuService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页
 * @Created by laiyunjing
 * @Date 2019/11/13 23:11
 * @Version
 */
@Controller
public class IndexController {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuDao roleMenuDao;

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
//    @RequestMapping("/admin/main")
    public String admin_main(){
        return "/admin/main";
    }

    @RequestMapping("/admin/main")
    public ModelAndView andmin(HttpServletRequest request,HttpServletResponse response) throws Exception{
            ModelAndView mav = new ModelAndView();
            String UserAgent = request.getHeader("user-agent");
            if(BrowserveUnit.checkUserAger(UserAgent)){
                mav.setViewName("/admin/main");
            }else {
                mav.setViewName("/common/s_mode");
            }

            User  user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
            if(user.getRole() == null){
                return mav;
            }

        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("pId",-1);
        List<Menu> menuList = menuService.list(map,0,100);
        List<JSONObject>  list = new ArrayList<>();
        for(Menu menu: menuList){
            RoleMenu roleMenu = roleMenuDao.findByRoleIdAndMenuId(user.getRole().getId(),menu.getId());
            if(roleMenu != null){
                JSONObject node = new JSONObject();
                node.put("id",menu.getId());
                node.put("text",menu.getName());
                node.put("url",menu.getUrl());
                node.put("type",menu.getType());
                node.put("icon",menu.getIcon());
                node.put("divId",menu.getDivId());
                node.put("children",getChildren(menu.getId(),user.getRole().getId()));
                list.add(node);
            }
        }
        mav.addObject("treeList",list);
            return mav;
    }


//    public List<JSONObject> trrD (HttpServletRequest request,HttpServletResponse response){
//        User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
//        List<JSONObject> list = new ArrayList<JSONObject>();
//
//        List<Menu> menuList = menuDao.findBypId(-1);
//        for(Menu menu:menuList){
//            JSONObject node = new JSONObject();
//            node.put("id",menu.getId());
//            node .put("title",menu.getName());
//            node.put("spread",true);
//            node.put("children",getChildren(menu.getId(),currentUser.getRole().getId()));
//        }
//        return list;
//    }

    public List<JSONObject> getChildren(Integer pId,Integer roleId){

        Map<String, Object> map = new HashMap<String, Object>() ;
        map.put("pId",pId);
        List<Menu> menuList = menuService.list(map,0,100);
        List<JSONObject> list = new ArrayList<JSONObject>();
        for(Menu menu:menuList){
            RoleMenu roleMenu = roleMenuDao.findByRoleIdAndMenuId(roleId,menu.getId());
            if(roleMenu != null) {
                JSONObject node = new JSONObject();
                node.put("id", menu.getId());
                node.put("text", menu.getName());
                node.put("url", menu.getUrl());
                node.put("type", menu.getType());
                node.put("icon", menu.getIcon());
                node.put("divId", menu.getDivId());
                list.add(node);
            }

        }
        return list;
//        List<Menu> menuList = menuDao.findBypId(pId);
//        List<JSONObject> list = new ArrayList<JSONObject>();
//        for(Menu menu:menuList){
//            JSONObject node = new JSONObject();
//            node.put("id",menu.getId());
//            node.put("text",menu.getName());
//            list.add(node);
//        }
//        return list;
    }


}
