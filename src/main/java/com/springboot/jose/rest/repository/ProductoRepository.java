package com.springboot.jose.rest.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jose.rest.model.Producto;


public interface ProductoRepository  extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

	
	Page<Producto> findByNombreContainsIgnoreCase(String txt, Pageable pageable);

	
	

}
