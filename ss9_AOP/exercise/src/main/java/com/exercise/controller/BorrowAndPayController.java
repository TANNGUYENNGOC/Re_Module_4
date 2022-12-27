package com.exercise.controller;

import com.exercise.model.Book;
import com.exercise.model.BorrowAndPay;
import com.exercise.service.book.IBookService;
import com.exercise.service.borrowAndPay.IBorrowAndPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrowAndPay")
public class BorrowAndPayController {
    @Autowired
    IBorrowAndPayService borrowAndPayService;
    @Autowired
    IBookService bookService;

    @PostMapping("/borrow")
    public String borrowBooks(@RequestParam("idBook") int idBook, RedirectAttributes redirectAttributes) {
        Book book1 = bookService.findById(idBook).get();
        book1.setAvailableBooks(book1.getAvailableBooks()-1);
        book1.setBorrowedBooks(book1.getBorrowedBooks()+1);
        bookService.save(book1);

        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        Book book = new Book(idBook);
        BorrowAndPay borrowAndPay = new BorrowAndPay(code,book);
        borrowAndPayService.save(borrowAndPay);
        redirectAttributes.addFlashAttribute("mess","MƯợn thành công");
        return "redirect:/book/list";
    }
}
