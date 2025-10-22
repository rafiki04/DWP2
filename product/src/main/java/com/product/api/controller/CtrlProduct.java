package com.product.api.controller;
import org.springframework.http.ResponseEntity;
import com.product.api.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.api.service.SvcCategory;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.commons_dto.ApiResponse;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/category")
public class CtrlProduct{

    @Autowired
    private SvcCategory svcCategory;


/*@GetMapping("/category")
public ResponseEntity<List<Category>> Categoria(){
   List<Category> categorias = new ArrayList<>();

        categorias.add(new Category(1, "Lentes", "Lts", 1));
        categorias.add(new Category(2, "Relojes", "Rljs", 1));

        return svcCategory.getCategories();
	
	}
*/
    @GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok(svcCategory.findAll());
	}
	
	@GetMapping("/active")
	public ResponseEntity<List<Category>> findActive(){
		return ResponseEntity.ok(svcCategory.findActive());
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> create(@Valid @RequestBody DtoCategoryIn in) {
		return ResponseEntity.ok(svcCategory.create(in));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> update(@Valid @RequestBody DtoCategoryIn in, @PathVariable("id") Integer id){
		return ResponseEntity.ok(svcCategory.update(in, id));
	}

	@PatchMapping("/{id}/enable")
	public ResponseEntity<ApiResponse> enable(@PathVariable Integer id) {
		return ResponseEntity.ok(svcCategory.enable(id));
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<ApiResponse> disable(@PathVariable Integer id) {
		return ResponseEntity.ok(svcCategory.disable(id));
	}

	
}

