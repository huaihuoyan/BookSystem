package com.huai.booksystem.web.controller;

import com.huai.booksystem.web.dao.MenuDao;
import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.service.MenuService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created by laiyunjing
 * @Date 2019/11/22 21:08
 * @Version
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuDao menuDao;

    @RequestMapping("/add")
    @ResponseBody
    public JSONObject add(@Valid Menu menu, BindingResult bindingResult, HttpServletRequest request , HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();

        if(bindingResult.hasErrors()){
            jsonObject.put("success",false);
            jsonObject.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return jsonObject;
        }else {

            menuDao.save(menu);
            jsonObject.put("success",true);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JSONObject update(Menu menu)throws Exception{

        JSONObject jsonObject = new JSONObject();
        menuService.update(menu);
        jsonObject.put("success",true);
        jsonObject.put("msg","修改成功");
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "pId", required = false) String pId,
            HttpServletResponse response,
            HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotEmpty(pId)){
            map.put("pId",pId);
        }

        List<Menu> list = menuService.list(map,page-1,limit);
        long total = menuService.getTotal(map);
        map.clear();
        map.put("data", list);
        map.put("count", total);
        map.put("code", 0);
        map.put("msg", "");
        return map;


    }
}
