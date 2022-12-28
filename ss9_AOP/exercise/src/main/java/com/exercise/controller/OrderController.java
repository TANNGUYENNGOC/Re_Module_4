package com.exercise.controller;

import com.exercise.model.Book;
import com.exercise.model.Order;
import com.exercise.service.book.IBookService;
import com.exercise.service.borrowAndPay.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/borrowAndPay")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @Autowired
    IBookService bookService;

    @PostMapping("/borrow")
    public String borrowBooks(@RequestParam("idBook") int idBook, RedirectAttributes redirectAttributes) throws Exception {
        Book book1 = bookService.findById(idBook).get();
        if(book1.getAvailableBooks()==0){
             throw new Exception();
        }

        book1.setAvailableBooks(book1.getAvailableBooks() - 1);
        book1.setBorrowedBooks(book1.getBorrowedBooks() + 1);
        bookService.save(book1);

        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        Book book = new Book(idBook);
        Order order = new Order(code, book);
        orderService.save(order);
        redirectAttributes.addFlashAttribute("mess", "MƯợn thành công,Mã mượn sách là " + code);
        return "redirect:/book/list";
    }

    @PostMapping("/pay")
    public String payBook(@RequestParam("codePay") int codePay, RedirectAttributes redirectAttributes) throws Exception {
        if (orderService.borrowAndPay(codePay)==null){
            throw new Exception();
        }
        Order order = orderService.borrowAndPay(codePay);
        Book book = bookService.findById(order.getBook().getId()).get();
        book.setAvailableBooks(book.getAvailableBooks() + 1);
        book.setBorrowedBooks(book.getBorrowedBooks() - 1);
        bookService.save(book);

        orderService.remove(order.getId());
        redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
        return "redirect:/book/list";
    }

    @ExceptionHandler(Exception.class)
    public String handlerError(Exception e){
        return "book/error";
    }
}
