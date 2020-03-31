package com.lyy.controller;

import com.lyy.pojo.Books;
import com.lyy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //实现去调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBooks")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBooks";
    }

    @RequestMapping("/toAddBook")
//    点击新增跳转到这里然后再转addBook.jsp
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBooks";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
        Books book = bookService.queryBookById(id);
        //debug
        System.out.println(book);
        model.addAttribute("book",book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model,Books book){
        bookService.updateBook(book);
        Books changebook = bookService.queryBookById(book.getBookID());
        model.addAttribute("changebook",changebook);
        return "redirect:/book/allBooks";
    }

//    删除
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId")int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBooks";
    }
}
