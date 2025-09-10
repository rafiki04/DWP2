package com.product.api.controller;
import com.product.api.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.api.service.SvcCategory;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CtrlProduct{

    @Autowired
    private SvcCategory svcCategory;


@GetMapping("/category")
public List<Category> Categoria(){
   List<Category> categorias = new ArrayList<>();

        categorias.add(new Category(1, "Lentes", "Lts", 1));
        categorias.add(new Category(2, "Relojes", "Rljs", 1));

        return svcCategory.getCategories();
	
	}

}

