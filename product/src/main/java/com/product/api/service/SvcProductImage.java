package com.product.api.service;


import java.util.List;
import org.springframework.http.ResponseEntity;
import com.product.api.commons_dto.ApiResponse;
import com.product.api.dto.DtoProductImageIn;
import com.product.api.dto.DtoProductImageOut;

public interface SvcProductImage {
    
    ResponseEntity<List<DtoProductImageOut>> getProductImages(Integer productId);
    ResponseEntity<ApiResponse> createProductImage(Integer productId, DtoProductImageIn in);
    ResponseEntity<ApiResponse> deleteProductImage(Integer productId, Integer productImageId);
}