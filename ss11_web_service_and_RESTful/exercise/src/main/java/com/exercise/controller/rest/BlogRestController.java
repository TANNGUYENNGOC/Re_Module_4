package com.exercise.controller.rest;

import com.exercise.model.Blog;
import com.exercise.model.Category;
import com.exercise.service.IBlogService;
import com.exercise.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogRestController {
    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogRestController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/listBlog")
    public ResponseEntity<Page<Blog>> getListBlog(@PageableDefault(size = 3,page = 0) Pageable pageable){
        Page<Blog> listBlog = blogService.findAll(pageable);
        if(listBlog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBlog, HttpStatus.OK);
    }

    @GetMapping("/listCategory")
    public ResponseEntity<Page<Category>> getListCategory(Pageable pageable){
        Page<Category> listCategory = categoryService.findAll(pageable);
        if (listCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCategory,HttpStatus.OK);
    }

    @GetMapping("/listBlogFindByIdCategory/{id}")
    public ResponseEntity<List<Blog>> showListBlogFindByIdCategory(@PathVariable("id")Long id){
        List<Blog> listBlogFindByIdCategory = blogService.findByCategory_Id(id);
        if (listBlogFindByIdCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBlogFindByIdCategory,HttpStatus.OK);
    }

    @GetMapping("/detaiBlog/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable("id")Long id){
        Blog blog = blogService.findById(id).get(); //Nếu ko tồn tại blog thì .get() ném ra ngoại lệ
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
