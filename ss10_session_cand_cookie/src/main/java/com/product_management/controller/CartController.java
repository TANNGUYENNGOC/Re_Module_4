package com.product_management.controller;

import com.product_management.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public String showCart(@SessionAttribute("cart") CartDto cartDto, Model model) {
        //B4: Hiển thị giỏ hàng
        model.addAttribute("cartDto",cartDto);
        return "cart/list";
    }
}
