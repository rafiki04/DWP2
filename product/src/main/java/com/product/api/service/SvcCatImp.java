package com.product.api.service;
import java.util.List;
import com.product.api.dto.DtoCategoryIn;
import com.product.api.commons_dto.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;
@Service
public class SvcCatImp implements SvcCategory{

	@Autowired
	RepoCategory repo;
	
	//@Override
	/*public ResponseEntity<List<Category>> getCategories() {
				try {
					return new ResponseEntity<>(repo.getCategories(), HttpStatus.OK);
				} catch (DataAccessException e) {
					System.out.println(e.getLocalizedMessage());
			        throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al consultar la base de datos");
				}
	
	}*/
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return repo.getCategories();
	}
	@Override
	public List<Category> findActive() {
		// TODO Auto-generated method stub
		return repo.getActiveCategories();
	}
	@Override
	public ApiResponse create(DtoCategoryIn in) {
		if(repo.existsByNombre(in.getCategory())) {
	        throw new ApiException(HttpStatus.BAD_REQUEST, "El nombre de la categoría ya existe");
	    }
	    if(repo.existsByTag(in.getTag())) {
	        throw new ApiException(HttpStatus.BAD_REQUEST, "El tag de la categoría ya existe");
	    }
		// TODO Auto-generated method stub
		 Category category = new Category();
	        category.setName(in.getCategory());
	        category.setTag(in.getTag());
	        category.setStatus(1);

	        repo.save(category);
	        return new ApiResponse("La categoría ha sido registrada");
	}
	
	@Override
	public ApiResponse update(DtoCategoryIn in, Integer id) {
		  Category category = repo.findById(id).orElse(null);

	        if (category == null) {
	            throw new ApiException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
	        }
	        if(repo.existsByNombreAndIdNot(in.getCategory(), id)) {
	            throw new ApiException(HttpStatus.BAD_REQUEST, "El nombre de la categoría ya existe");
	        }
	        if(repo.existsByTagAndIdNot(in.getTag(), id)) {
	            throw new ApiException(HttpStatus.BAD_REQUEST, "El tag de la categoría ya existe");
	        }

	        category.setName(in.getCategory());
	        category.setTag(in.getTag());
	        repo.save(category);

	        return new ApiResponse("La categoría ha sido actualizada");
		// TODO Auto-generated method stub
	}
	@Override
	public ApiResponse enable(Integer id) {
		// TODO Auto-generated method stub
		 Category category = repo.findById(id).orElse(null);

	        if (category == null) {
	            throw new ApiException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
	        }

	        category.setStatus(1);
	        repo.save(category);

	        return new ApiResponse("La categoría ha sido activada");
	}
	@Override
	public ApiResponse disable(Integer id) {
		// TODO Auto-generated method stub
		 Category category = repo.findById(id).orElse(null);

	        if (category == null) {
	            throw new ApiException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
	        }

	        category.setStatus(0);
	        repo.save(category);

	        return new ApiResponse("La categoría ha sido desactivada");
	}
	
}