package com.springboot.jose.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jose.rest.model.Producto;


public interface ProductoRepository  extends JpaRepository<Producto, Long> {



}
