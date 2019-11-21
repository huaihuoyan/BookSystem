package com.huai.booksystem.web.service.Impl;

import com.huai.booksystem.web.dao.UserDao;
import com.huai.booksystem.web.entity.User;
import com.huai.booksystem.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 23:14
 * @Version
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer update(User user) {
//        原数据
        User origin = userDao.findId(user.getId());

        user = repalce(user,origin);
       userDao.save(user);
        return 1;
    }

    @Override
    public List<User>  list(Map<String, Object> map, Integer page, Integer pageSize) {
        Pageable pageable = new PageRequest(page,pageSize, Sort.Direction.ASC,"orderNo");
        Page<User> list = userDao.findAll(pageable);
        return list.getContent();
    }

    @Override
    public Long getTotal(Map<String, Object> map) {

        return userDao.count();
    }

    public User repalce(User curr,User origin){
        if(curr.getName() == null){
            curr.setName(origin.getName());
        }
        if(curr.getPwd() == null){
            curr.setPwd(origin.getPwd());
        }
        if(curr.getTurename() == null){
            curr.setTurename(origin.getTurename());
        }
        if(curr.getOrderNo() == null){
            curr.setOrderNo(origin.getOrderNo());
        }
        if(curr.getCreatDateTime() == null){
            curr.setCreatDateTime(origin.getCreatDateTime());
        }
        if(curr.getRole() == null){
            curr.setRole(origin.getRole());
        }

        if(curr.getRemark() == null){
            curr.setRemark(origin.getRemark());
        }
        return curr;
    }
}
