package com.huai.booksystem.web.controller;

import com.huai.booksystem.unit.CryptographyUtil;
import com.huai.booksystem.web.dao.UserDao;
import com.huai.booksystem.web.entity.User;
import com.huai.booksystem.web.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

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

//            String webPath = (String) request.getServletContext().getRealPath("111");
            user.setUpdateDateTime(new Date());
            userService.update(user);
            jsonObject.put("success",true);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
    }


//    @Autowired
//    private UserService userService;

//    @RequestMapping("/add")
//    @ResponseBody
//    public JSONObject add(@Valid User user, BindingResult bindingResult){
//        JSONObject result = new JSONObject();
//        if(bindingResult.hasErrors()){
//            result.put("success", false);
//            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
//            return result;
//        }else {
//            user.setPwd(CryptographyUtil.md5(user.getPwd(),"java"));//对存入数据库的密码进行加密加盐
//            user.setCreateDateTime(new Date());//这里两个是取当前存入数据库的时间插入数据库
//            user.setUpdateDateTime(new Date());
//            userMapper.savaUser(user);
//            result.put("success", true);
//            result.put("msg", "添加成功");
//            return result;
//        }
//    }
//
//    @RequestMapping("/update")
//    @ResponseBody
//    public JSONObject update(@Valid User user, BindingResult bindingResult){
//        JSONObject result = new JSONObject();
//        if(bindingResult.hasErrors()){
//            result.put("success", false);
//            result.put("msg", bindingResult.getFieldError().getDefaultMessage());
//            return result;
//        }else {
//            if (!user.getPwd().equals(null)){
//                user.setPwd(CryptographyUtil.md5(user.getPwd(),"java"));}//对存入数据库的密码进行加密加盐
//            user.setUpdateDateTime(new Date());
//            userMapper.updateUser(user);
//            result.put("success", true);
//            result.put("msg", "添加成功");
//            return result;
//        }
//    }
//
//
//    @ResponseBody
//    @RequestMapping("/set_new_pwd")
//    public JSONObject set_new_pwd(User user)throws Exception {
//        JSONObject result = new JSONObject();
//        user.setUpdateDateTime(new Date());
//        if(StringUtil.isNotEmpty(user.getPwd())){
//            user.setPwd(CryptographyUtil.md5(user.getPwd(),"java"));
//        }
//        userMapper.updateUser(user);
//        result.put("success", true);
//        result.put("msg", "修改成功");
//        return result;
//    }
//
//
//    @ResponseBody
//    @RequestMapping("/list")
//    public Map<String, Object> list(@RequestParam(value = "page", required = false) Integer page,
//                                    @RequestParam(value = "limit", required = false) Integer limit,
//                                    HttpServletResponse response,
//                                    HttpServletRequest request) throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        List<User> userList = userMapper.findUserList(map, page-1, limit);
//        long total = userMapper.getTotal(map);
//        map.put("data", userList);
//        map.put("count", total);
//        map.put("code", 0);
//        map.put("msg", "");
//        return map;
//    }
//
//
//
//    @ResponseBody
//    @RequestMapping("/delete")
//    public JSONObject delete(@RequestParam(value = "ids", required = false) String ids) throws Exception {
//        String[] idsStr = ids.split(",");
//        JSONObject result = new JSONObject();
//        for (int i = 0; i < idsStr.length; i++) {
//            userMapper.deleteUser(Integer.parseInt(idsStr[i]));
//        }
//        result.put("success", true);
//        return result;
//    }
}
