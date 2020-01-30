package com.springboot.jose.rest.service;

import java.util.List;

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
	public void addCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> listaCategorias() {
		
		return categoriaRepository.findAll();
	}

	@Override
	public void deleteCategoria(long categoriaId) {
		categoriaRepository.deleteById(categoriaId);

	}

	@Override
	public void updateCategoria(long categoriaId, Categoria categoria) {
		if (categoriaRepository.existsById(categoriaId)) {
			categoria.setCategoria_id(categoriaId);
			categoriaRepository.save(categoria);
		} 

	}

	@Override
	public Categoria findCategoria(long categoriaId) {
		return categoriaRepository.findById(categoriaId).orElse(null);
	}

}
