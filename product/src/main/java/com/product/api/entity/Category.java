package com.product.api.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.util.Scanner;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("category_id")
	@Column(name = "category_id")
    int id;
	@JsonProperty("category")
	@Column(name = "Category")
    String nombre;
	@JsonProperty("tag")
	@Column(name = "tag")
    String tag;
	@JsonProperty("status")
	@Column(name = "status")
    int status;
	 public Category() {
		 
	 } 

    // Lista de categorías
    ArrayList<Category> categorias = new ArrayList<>();

    // Metodo constructor
    public Category(int id, String nombre, String tag, int status) {
        this.id = id;
        this.nombre = nombre;
        this.tag = tag;
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return nombre;
    }

    public String gettag() {
        return tag;
    }

    public int getStatus() {
        return status;
    }

}
