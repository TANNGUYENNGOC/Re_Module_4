package com.exercise.controller;

import com.exercise.model.Blog;
import com.exercise.model.Category;
import com.exercise.service.IBlogService;
import com.exercise.service.ICategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }
    @GetMapping("")
    public String display(@RequestParam(defaultValue = "") String author, @RequestParam(defaultValue = "-1") Long categoryID, Model model,@PageableDefault(page = 0,size = 4) Pageable  pageable){
        if (categoryID!=-1){
            Category category=categoryService.findById(categoryID).get();
            model.addAttribute("blogList", blogService.findByAuthorContainingAndCategory(pageable,author,category));
        }else {
            model.addAttribute("blogList", blogService.findByAuthorContaining(pageable,author));
        }
        model.addAttribute("author",author);
        model.addAttribute("categoryID",categoryID);
        model.addAttribute("categoryList",categoryService.findAll(pageable));
        model.addAttribute("blog",new Blog());
        return "blog/list";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute("blog")Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addAttribute("mess","thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("{id}/update")
    public String showFormUpdate(Model model,@PathVariable("id") Long id,Pageable pageable){
        Blog blog = blogService.findById(id).get();
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",categoryService.findAll(pageable));
        return "blog/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("blog")Blog blog,RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addAttribute("mess","Chỉnh sửa thành công");
        return "redirect:/blog";
    }
    @PostMapping("/removeBlog")
    public String remove(@RequestParam("idRemove") Long id,RedirectAttributes redirectAttributes){
        blogService.remove(id);
        redirectAttributes.addAttribute("mess","Xóa thành công");
        return "redirect:/blog";
    }
}
