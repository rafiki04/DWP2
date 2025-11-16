package com.product.api.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.api.entity.ProductImage;
import com.product.api.repository.RepoProductImage;

public class DtoProductImageOut{

	
	@JsonProperty("product_image_id")
	private Integer productImageId;
	
	@JsonProperty("product_id")
    private Integer productId;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("status")
	private Integer status;
	
	public Integer getproductImageId() {
		return productImageId;
	}
	public void setproductImageId(Integer productImageId) {
		this.productImageId = productImageId;
	}
	public Integer getProductId() { 
		return productId; 
	}
    public void setProductId(Integer productId) { 
    	this.productId = productId; 
	}
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}
	public Integer getstatus() {
		return status;
	}
	public void setstatus(Integer status) {
		this.status = status;
	}
	
	   public static DtoProductImageOut fromEntity(ProductImage entity) {
	        DtoProductImageOut dto = new DtoProductImageOut();
	        dto.setproductImageId(entity.getProductImageId());
	        dto.setimage(entity.getImage());
	        dto.setstatus(entity.getStatus());
	        return dto;
	    }

}