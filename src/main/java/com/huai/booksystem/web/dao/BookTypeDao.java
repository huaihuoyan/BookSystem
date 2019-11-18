package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:49
 * @Version
 */
public interface BookTypeDao extends JpaRepository<BookType,Integer>, JpaSpecificationExecutor<BookType> {
}
