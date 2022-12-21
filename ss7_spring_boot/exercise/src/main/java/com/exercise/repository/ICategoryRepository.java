package com.exercise.repository;

import com.exercise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;


@Controller
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
