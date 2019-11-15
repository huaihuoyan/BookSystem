package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Created by laiyunjing
 * @Date 2019/11/14 21:06
 * @Version
 */
public interface ConfigDao extends JpaRepository<Config,Integer> {

    @Query(value = "select * from T_CONFIG where id = ?",nativeQuery = true)
    public Config findId(Integer id);
}
