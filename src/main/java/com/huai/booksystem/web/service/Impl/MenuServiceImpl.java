package com.huai.booksystem.web.service.Impl;

import com.huai.booksystem.web.dao.MenuDao;
import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/21 0021 17:20
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public Integer add(Menu menu) {
        return null;
    }

    @Override
    public Integer update(Menu menu) {
        return null;
    }

    @Override
    public List<Menu> list(Map<String, Object> map, Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    @Override
    public Menu findById(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public List<Menu> findByPId(Integer pId) {
        return null;
    }
}
