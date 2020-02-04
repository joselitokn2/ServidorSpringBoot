package com.springboot.jose.rest.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jose.rest.model.Categoria;

import com.springboot.jose.rest.repository.CategoriaRepository;

@Service

@Transactional
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Categoria getCategoria(long categoria_id) {
		return categoriaRepository.findById(categoria_id).orElse(null);
	}



	

}
