package com.product.api.service;
import java.util.List;
import com.product.api.entity.Category;

import org.springframework.http.ResponseEntity;
import com.product.api.commons_dto.ApiResponse;
import com.product.api.dto.DtoCategoryIn;


public interface SvcCategory{
	//public ResponseEntity<List<Category>> getCategories();
	public List<Category> findAll();
	public List<Category> findActive();
	public ApiResponse create(DtoCategoryIn in);
	public ApiResponse update(DtoCategoryIn in, Integer id);
	public ApiResponse enable(Integer id);
	public ApiResponse disable(Integer id);

}