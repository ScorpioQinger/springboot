package com.scorpiospace.controller;

import com.scorpiospace.domain.model.Book;
import com.scorpiospace.domain.model.Header;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LearnControllor
 * @Description TODO
 * @Author zq
 * @Date 2019/7/22 14:58
 * @Version 1.0
 **/
@Controller
public class BookControllor {

    @RequestMapping("/")
    public ModelAndView index(){
        List<Book> bookList = new ArrayList<>();
        Book book = new Book("《少年歌行》","周木楠","42.5");
        bookList.add(book);
        book = new Book("《Spring Boot 实战》","[美]克雷格.沃斯","59");
        bookList.add(book);
        book = new Book("《微习惯》","[美]斯蒂芬.盖斯","38");
        bookList.add(book);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books",bookList);
        return modelAndView;
    }
}
