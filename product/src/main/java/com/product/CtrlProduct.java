package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CtrlProduct{


@GetMapping("/category")
public List<Category> Categoria(){
   List<Category> categorias = new ArrayList<>();

        categorias.add(new Category(1, "Lentes", "Lts", 1));
        categorias.add(new Category(2, "Relojes", "Rljs", 1));

        return categorias;
	
	}

}

