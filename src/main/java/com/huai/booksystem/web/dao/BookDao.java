package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:48
 * @Version
 */
public interface BookDao extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
}
