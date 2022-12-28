package com.product_management.controller;

import com.product_management.dto.CartDto;
import com.product_management.dto.ProductDto;
import com.product_management.model.Product;
import com.product_management.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart") //B1: Khai báo session
public class ProductController {
    @Autowired
    IProductService productService;

    //B2: Tạo 1 giỏ hàng mới
    // => B2 sẽ thực thi khi bước 1 chưa có cart
    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cartDto){
        Product product = productService.findById(id).get();
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cartDto.addProduct(productDto); //B3: mua hàng
        return "cart/list";
    }

    @GetMapping("/listProduct")
    public String sowListProduct(Model model, Pageable pageable) {
        model.addAttribute("list", productService.findAll(pageable));
        return "product/list";
    }
}
