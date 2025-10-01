package com.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Category;

@Repository 
public interface RepoCategory extends JpaRepository<Category,Integer>{
	
	@Query(value ="SELECT * FROM category ORDER BY category", nativeQuery = true)
	List<Category> getCategories();

	@Query("SELECT c FROM Category c WHERE c.status = 1 ORDER BY c.nombre")
	List<Category> getActiveCategories();
	
	List<Category> findByStatus(int status);
	
    boolean existsByNombre(String nombre);

    
    boolean existsByTag(String tag);

    
    boolean existsByNombreAndIdNot(String nombre, Integer id);

    
    boolean existsByTagAndIdNot(String tag, Integer id);

}