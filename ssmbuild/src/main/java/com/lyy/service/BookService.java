package com.lyy.service;

import com.lyy.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books book);
    //    删除一本书
    int  deleteBookById( int id);
    //更新一本书
//    int updateBookById(int id);
    int updateBook(Books book);
    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();
}
