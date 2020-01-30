package com.springboot.jose.rest.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jose.rest.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
