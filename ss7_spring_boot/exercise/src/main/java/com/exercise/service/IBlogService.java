package com.exercise.service;

import com.exercise.model.Blog;
import com.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    //    List<Blog> findByAuthorContainingOrCategory_Id(String author, int category);
    Page<Blog> findByAuthorContainingAndCategoryOrderByDateOfWritingAsc(Pageable pageable, String author, Category category);

    Page<Blog> findByAuthorContainingOrderByDateOfWritingAsc(Pageable pageable, String author);


}
