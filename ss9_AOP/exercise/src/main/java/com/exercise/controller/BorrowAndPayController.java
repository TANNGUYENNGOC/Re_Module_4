package com.exercise.controller;

import com.exercise.model.BorrowAndPay;
import com.exercise.service.borrowAndPay.IBorrowAndPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrowAndPay")
public class BorrowAndPayController {
    @Autowired
    IBorrowAndPayService borrowAndPayService;

    @PostMapping("/borrow")
    public String borrowBooks(){

    }
}
