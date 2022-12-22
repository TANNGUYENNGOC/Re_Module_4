package com.exercise.controller;

import com.exercise.model.Category;
import com.exercise.service.ICategoryService;
import com.exercise.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listCategory")
    public String showListCategory(Model model,@PageableDefault(page = 0,size = 4) Pageable pageable){
        model.addAttribute("listCategory",categoryService.findAll(pageable));
        model.addAttribute("category",new Category());
        return "category/list";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute("category")Category category, RedirectAttributes model){
        categoryService.save(category);
        model.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/category/listCategory";
    }

    @PostMapping("removeCategory")
    public String removeCategory(@RequestParam("idCategoryRemove") Long id,RedirectAttributes redirectAttributes){
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Xóa Thành công");
        return "redirect:/category/listCategory";
    }

    @PostMapping("updateCategory")
    public String updateCategory(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa Thành công");
        return "redirect:/category/listCategory";
    }
}
