package com.product.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import com.product.api.commons_dto.ApiResponse;
import com.product.api.dto.DtoProductImageIn;
import com.product.api.dto.DtoProductImageOut;
import com.product.api.entity.Product;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProduct;
import com.product.api.repository.RepoProductImage;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;


@Service
public class SvcProductImageImp implements SvcProductImage{

	@Autowired
	private RepoProduct repoproduct;
	@Autowired
	public RepoProductImage repoProductImage;

	
	public ResponseEntity<List<DtoProductImageOut>> getProductImages(Integer productId){
		try {
			if(repoproduct.findById(productId).isEmpty()) 
			throw new ApiException(HttpStatus.NOT_FOUND,"el id del producto no existe");
			
			
			   List<ProductImage> images = repoProductImage.findByProductProductId(productId);
	            List<DtoProductImageOut> dtoList = images.stream()
	                    .map(DtoProductImageOut::fromEntity)
	                    .toList();
			return new ResponseEntity<>(dtoList, HttpStatus.OK);
		}
		catch(DataAccessException e){
			throw new DBAccessException(e);
			
		}
		
		
	}
	public ResponseEntity<ApiResponse> createProductImage(Integer productId, DtoProductImageIn in){
		try {
			 Product product = repoproduct.findById(productId)
	                    .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "El id del producto no existe"));
			 
		     ProductImage image = new ProductImage();
	            image.setProduct(product);
	            image.setImage(in.getImage());
	            image.setStatus(1);

	            repoProductImage.save(image);

	            return new ResponseEntity<>(new ApiResponse("La imagen fue registrada"), HttpStatus.CREATED);
		}
		catch(DataAccessException e){
			throw new DBAccessException(e);
			
		}			
	}
	
	public ResponseEntity<ApiResponse> deleteProductImage(Integer productId, Integer productImageId){
				
		
		
	    try {
	        ProductImage image = repoProductImage.findById(productImageId)
	            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "La imagen no existe"));

	        if (!image.getProduct().getProduct_id().equals(productId)) {
	            throw new ApiException(HttpStatus.NOT_FOUND, "La imagen no pertenece a este producto");
	        }

	        repoProductImage.delete(image);

	        return new ResponseEntity<>(new ApiResponse("La imagen fue eliminada"), HttpStatus.OK);
	    } catch (DataAccessException e) {
	        throw new DBAccessException(e);
	    }
		
		
		
		
		
		
		
		
		/* try {
	            if (!repoProductImage.existsByProductImageIdAndProductProductId(productImageId, productId))
	                throw new ApiException(HttpStatus.NOT_FOUND, "La imagen no existe para este producto");

	            repoProductImage.deleteByProductImageIdAndProductProductId(productImageId, productId);

	            return new ResponseEntity<>(new ApiResponse("La imagen fue eliminada"), HttpStatus.OK);
	        } catch (DataAccessException e) {
	            throw new DBAccessException(e);
	        }
	}*/

	}
}