package com.huai.booksystem.web.dao;

import com.huai.booksystem.web.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @Created by laiyunjing
 * @Date 2019/11/18 22:49
 * @Version
 */
public interface BookTypeDao extends JpaRepository<BookType,Integer>, JpaSpecificationExecutor<BookType> {

    @Query(value = "select * from T_A_BOOK_TYPE where id = ?1",nativeQuery = true)
     BookType findId(Integer id);
}
