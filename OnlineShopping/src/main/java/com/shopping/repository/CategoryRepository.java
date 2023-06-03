package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
