package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:43
 * @Version
 */
public interface MenuDao extends JpaRepository<Menu,Integer>, JpaSpecificationExecutor<Menu> {

    @Query(value = "select * from T_MENU where id = ?1",nativeQuery = true)
    public Menu findId(Integer id);

    List<Menu> findByPid(Integer pId);
}
