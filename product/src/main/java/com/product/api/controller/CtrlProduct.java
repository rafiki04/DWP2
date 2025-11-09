package com.product.api.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.product.api.dto.DtoProductImageIn;
import com.product.api.dto.DtoProductImageOut;
import com.product.api.dto.DtoProductIn;
import com.product.api.dto.DtoProductListOut;
import com.product.api.dto.DtoProductOut;
import com.product.api.entity.Product;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProduct;
import com.product.api.repository.RepoProductImage;
import com.product.api.service.SvcProduct;
import com.product.api.service.SvcProductImageImp;
import com.product.exception.ApiException;
import com.product.api.commons_dto.ApiResponse;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class CtrlProduct {

	@Autowired 
	RepoProduct repoproduct;
	
	@Autowired
	RepoProductImage repoproductimage;
	
	@Autowired
	SvcProduct svc;

	@Autowired
	SvcProductImageImp svcProductImage;
	
	
	@GetMapping("/{id}/image")
    public ResponseEntity<List<DtoProductImageOut>> getProductImages(@PathVariable Integer id) {
       /* Product product = repoproduct.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "El id del producto no existe"));

        List<ProductImage> images = repoproductimage.findByProduct(product);
        return new ResponseEntity<>(images, HttpStatus.OK);*/
		        return svcProductImage.getProductImages(id);
		    
	}
	
	
	 @PostMapping("/{id}/image")
	    public ResponseEntity<ApiResponse> createProductImage(@PathVariable Integer id, @Valid @RequestBody DtoProductImageIn in) {
		 
	        	return svcProductImage.createProductImage(id, in);
	        
	 }
	 
	 
	 
	 
	
	    @DeleteMapping("/{id}/image/{productImageId}")
	    public ResponseEntity<ApiResponse> deleteProductImage(@PathVariable Integer id, @PathVariable("productImageId") Integer imageId) {

	        return svcProductImage.deleteProductImage(id, imageId);
	    }
	
	
	@GetMapping
	public ResponseEntity<List<DtoProductListOut>> getProducts() {
		return svc.getProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<DtoProductOut> getProduct(@PathVariable Integer id) {
		return svc.getProduct(id);
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody DtoProductIn in) {
		return svc.createProduct(in);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer id, @Valid @RequestBody DtoProductIn in) {
		return svc.updateProduct(id, in);
	}

	@PatchMapping("/{id}/enable")
	public ResponseEntity<ApiResponse> enableProduct(@PathVariable Integer id) {
		return svc.enableProduct(id);
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<ApiResponse> disableProduct(@PathVariable Integer id) {
		return svc.disableProduct(id);
	}
}
