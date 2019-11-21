package com.huai.booksystem.web.service;

import com.huai.booksystem.web.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/21 0021 17:19
 * @Version 1.0
 */
public interface MenuService {

    Integer add(Menu menu);

    Integer update(Menu menu);

    List<Menu> list (Map<String,Object> map, Integer page, Integer pageSize);

    Long getTotal(Map<String,Object> map);

    Menu findById(Integer id);

    Integer delete(Integer id);

    List<Menu> findByPId(Integer pId);
}
