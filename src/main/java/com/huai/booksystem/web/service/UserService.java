package com.huai.booksystem.web.service;

import com.huai.booksystem.web.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 23:13
 * @Version
 */
public interface UserService {

    Integer update(User user);

    List<User> list(Map<String,Object> map, Integer page, Integer pageSize);

    Long getTotal(Map<String,Object> map);
}
