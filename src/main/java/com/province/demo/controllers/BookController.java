package com.province.demo.controllers;

import com.province.demo.models.Book;
import com.province.demo.models.Category;
import com.province.demo.servicies.IBookService;
import com.province.demo.servicies.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryService.findAll();}

    @GetMapping("/user/create-book")
    public ModelAndView showHomeUser(){
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;}

    @PostMapping("/user/create-book")
    public ModelAndView createBook(@ModelAttribute Book book){
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("message", "create successfully");
        return modelAndView;
    }

}
