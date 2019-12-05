package com.huai.booksystem.web.controller;

import com.huai.booksystem.unit.CryptographyUtil;
import com.huai.booksystem.web.dao.RoleMenuDao;
import com.huai.booksystem.web.dao.UserDao;
import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.entity.RoleMenu;
import com.huai.booksystem.web.entity.User;
import com.huai.booksystem.web.service.MenuService;
import com.huai.booksystem.web.service.RoleMenuService;
import com.huai.booksystem.web.service.RoleService;
import com.huai.booksystem.web.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:53
 * @Version
 */
@Controller
@RequestMapping("/admin/user")
public class AdminController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private RoleMenuDao roleMenuDao;

    private RoleService roleService;

    @RequestMapping("/add")
    @ResponseBody
    public JSONObject add(@Valid User user, BindingResult bindingResult, HttpServletRequest request , HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();

        if(bindingResult.hasErrors()){
            jsonObject.put("success",false);
            jsonObject.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return jsonObject;
        }else {
            user.setCreatDateTime(new Date());
            user.setPwd(CryptographyUtil.md5(user.getPwd(),"java"));
            userDao.save(user);
            jsonObject.put("success",true);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
    }


    @RequestMapping("/update")
    @ResponseBody
    public JSONObject update(@Valid User user, BindingResult bindingResult, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        if(bindingResult.hasErrors()){
            jsonObject.put("success",false);
            jsonObject.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return jsonObject;
        }else {

            user.setUpdateDateTime(new Date());
            userService.update(user);
            jsonObject.put("success",true);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
    }


    @ResponseBody
    @RequestMapping("/set_new_pwd")
    public JSONObject set_new_pwd(User user)throws Exception {
        JSONObject result = new JSONObject();
        user.setUpdateDateTime(new Date());
        if(StringUtils.isNotEmpty(user.getPwd())){
            user.setPwd(CryptographyUtil.md5(user.getPwd(),"java"));
        }
        userService.update(user);
        result.put("success", true);
        result.put("msg", "修改成功");
        return result;
    }



    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam(value = "page", required = false) Integer page,
                                    @RequestParam(value = "limit", required = false) Integer limit,
                                    HttpServletResponse response,
                                    HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        List<User> userList = userService.list(map, page-1, limit);
        long total = userService.getTotal(map);
        map.put("data", userList);
        map.put("count", total);
        map.put("code", 0);
        map.put("msg", "");
        return map;
    }



    @ResponseBody
    @RequestMapping("/delete")
    public JSONObject delete(@RequestParam(value = "ids", required = false) String ids) throws Exception {
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for (int i = 0; i < idsStr.length; i++) {
            userDao.deleteById(Integer.parseInt(idsStr[i]));
        }
        result.put("success", true);
        return result;
    }
    @ResponseBody
    @RequestMapping("/getCheckTreeMenu")
    public List<JSONObject> getCheckTreeMenu(@RequestParam(value = "roleId",required = false) Integer roleId,
                                             HttpServletResponse response)throws Exception{
        List<JSONObject> list = new ArrayList<>();
        List<Menu> menuList = menuService.findByPId(-1);
        for(Menu menu:menuList){
            JSONObject node = new JSONObject();
            node.put("id",menu.getId());
            node.put("text",menu.getName());
            node.put("state","close");
            RoleMenu roleMenu = roleMenuDao.findByRoleIdAndMenuId(roleId,menu.getId());
            if(roleMenu == null){
                node.put("checked",false);
            }else{
                node.put("checked",true);
            }
            node.put("children",getChildren(menu.getId(),roleId));
            list.add(node);
        }
        return list;
    }

    public  List<JSONObject>getChildren(Integer pId,Integer roleId)throws Exception{
         List<Menu>menuList = menuService.findByPId(pId);
         List<JSONObject> list = new ArrayList<JSONObject>();
         for(Menu menu:menuList){
             JSONObject node = new JSONObject();
             node.put("id",menu.getId());
             node.put("text",menu.getName());
             node.put("state","opend");
             RoleMenu roleMenu = roleMenuDao.findByRoleIdAndMenuId(roleId,menu.getId());
             if(roleMenu == null){
                 node.put("checked",false);
             }else{
                 node.put("checked",true);
             }
             list.add(node);
         }
         return list;
    }

    @ResponseBody
    @RequestMapping("/updateMenu")
    public  JSONObject updateMenu(@RequestParam(value = "roleId",required = false) Integer roleId,
                                  @RequestParam(value = "menuIds",required = false) String menuIds){
        JSONObject node = new JSONObject();
        roleService.updateMenu(roleId,menuIds);
        node.put("success",true);
        node.put("msg","修改成功");
        return node;
    }
}
