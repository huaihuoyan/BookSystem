package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/15 0015 16:13
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<User,Integer> , JpaSpecificationExecutor<User> {

    @Query(value = "select * from T_USER where id = ?1",nativeQuery = true)
    public User findId(Integer id);

    public User findByName(String name);


}
