package com.exercise.repository;

import com.exercise.model.Blog;
import com.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
//    List<Blog> findByAuthorContainingOrCategory_Id(String author, int category);
    Page<Blog> findByAuthorContainingAndCategory(Pageable pageable, String author, Category category);
    Page<Blog> findByAuthorContaining(Pageable pageable,String author);
}
