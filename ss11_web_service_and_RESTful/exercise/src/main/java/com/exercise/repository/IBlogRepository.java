package com.exercise.repository;

import com.exercise.model.Blog;
import com.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    //    List<Blog> findByAuthorContainingOrCategory_Id(String author, int category);
    Page<Blog> findByAuthorContainingAndCategoryOrderByDateOfWritingAsc(Pageable pageable, String author, Category category);

    Page<Blog> findByAuthorContainingOrderByDateOfWritingAsc(Pageable pageable, String author);

    @Query(value = "select * from blog where category_id = :id"
            , countQuery = "select * from (select * from blog where category_id = :id)"
            ,nativeQuery = true)
     List<Category> listBlogFindIdCategory(@Param("id") Long id);

    List<Blog> findByCategory_Id(Long categoryId);
}
