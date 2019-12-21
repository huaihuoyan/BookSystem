package com.huai.booksystem.web.service.Impl;

import com.huai.booksystem.web.dao.BookTypeDao;
import com.huai.booksystem.web.entity.BookType;
import com.huai.booksystem.web.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: laiyunjing
 * @Date: 2019/12/21 0021 10:07
 * @Version 1.0
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeDao bookTypeDao;
    @Override
    public void update(BookType bookType) {
            BookType orgin = bookTypeDao.findId(bookType.getId());
            bookType = repalce(bookType,orgin);
            bookTypeDao.save(bookType);
    }

    public BookType repalce(BookType curr,BookType origin){
        if(curr.getName() == null){
            curr.setName(origin.getName());
        }


        if(curr.getOrderNo() == null){
            curr.setOrderNo(origin.getOrderNo());
        }

        if(curr.getCreatDateTime() == null){
            curr.setCreatDateTime(origin.getCreatDateTime());
        }

        if(curr.getUpdateDateTime() == null){
            curr.setUpdateDateTime(origin.getUpdateDateTime());
        }

        return curr;
    }
}
