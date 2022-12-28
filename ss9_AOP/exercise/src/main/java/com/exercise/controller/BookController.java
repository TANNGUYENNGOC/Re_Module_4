package com.exercise.controller;

import com.exercise.model.Order;
import com.exercise.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/list")
    public String showListBook(Model model, Pageable pageable){
        model.addAttribute("list",bookService.findAll(pageable));
        model.addAttribute("borrowAndPay",new Order());
        return "book/list";
    }
}
