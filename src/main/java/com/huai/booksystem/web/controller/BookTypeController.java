package com.huai.booksystem.web.controller;

import com.huai.booksystem.web.dao.BookTypeDao;
import com.huai.booksystem.web.entity.BookType;
import com.huai.booksystem.web.entity.Role;
import com.huai.booksystem.web.service.BookTypeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/12/21 0021 10:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/booktype")
public class BookTypeController {
    @Autowired
    private BookTypeDao bookTypeDao;
    @Autowired
    private BookTypeService bookTypeService;


    @RequestMapping("/manage")
    public ModelAndView manage() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "图书类型");
        mav.addObject("title", "图书类型");
        mav.setViewName("/admin/page/bookType/bookType_manage");
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
        mav.addObject("btn_text", "添加");
        mav.addObject("save_url", "/admin/booktype/add");
        mav.setViewName("/admin/page/bookType/add_update");
        return mav;
    }


    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        BookType bookType = bookTypeDao.findId(id);
        mav.addObject("bookType", bookType);
        mav.addObject("btn_text", "修改");
        mav.addObject("save_url", "/admin/booktype/update?id=" + id);
        mav.setViewName("/admin/page/bookType/add_update");
        return mav;
    }


    @RequestMapping("/add")
    @ResponseBody
    public JSONObject add(@Valid BookType bookType, BindingResult bindingResult, HttpServletRequest request , HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();

        if(bindingResult.hasErrors()){
            jsonObject.put("success",false);
            jsonObject.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return jsonObject;
        }else {
            bookType.setCreatDateTime(new Date());
            bookTypeDao.save(bookType);
            jsonObject.put("success",true);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public JSONObject update(@Valid BookType bookType, BindingResult bindingResult, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        if(bindingResult.hasErrors()){
            jsonObject.put("success",false);
            jsonObject.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return jsonObject;
        }else {

            bookType.setUpdateDateTime(new Date());
            bookTypeService.update(bookType);
            jsonObject.put("success",true);
            jsonObject.put("msg","修改成功");
            return jsonObject;
        }
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam(value = "page", required = false) Integer page,
                                    @RequestParam(value = "limit", required = false) Integer limit,
                                    HttpServletResponse response,
                                    HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        PageRequest pageable = new PageRequest(page-1,limit, Sort.Direction.DESC,"orderNo");
        Page<BookType> list = bookTypeDao.findAll(pageable);
       List<BookType>bookTypeList = list.getContent();
        Long total = bookTypeDao.count();
        map.put("data", bookTypeList);
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
            try {
                bookTypeDao.deleteById(Integer.parseInt(idsStr[i]));
            }catch (Exception e){
                e.printStackTrace();
                result.put("success", false);
                result.put("msg","用户正在使用此角色");
                return result;
            }

        }
        result.put("success", true);
        return result;
    }
}

