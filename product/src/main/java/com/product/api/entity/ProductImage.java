package com.product.api.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "product_image")
public class ProductImage {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "product_image_id")
   private Integer productImageId;
   
   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;


   @Column(name = "image")
   private String image;


   @Column(name = "status")
   private Integer status;
   
   public Integer getProductImageId() {
	   return productImageId; }
   
   public void setProductImageId(Integer productImageId) {
	   this.productImageId=productImageId; }

   public Product getProduct() {
	   return product; }
   
   public void setProduct(Product product) { 
	   this.product = product; }

   public String getImage() {
	   
	   return image; }
   
   public void setImage(String image) {
	   this.image = image; }

   public Integer getStatus() { 
	   return status; }
   
   public void setStatus(Integer status) { 
	   this.status = status; }
}