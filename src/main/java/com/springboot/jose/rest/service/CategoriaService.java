package com.springboot.jose.rest.service;

import java.util.List;

import com.springboot.jose.rest.model.Categoria;


public interface CategoriaService {

	public void addCategoria(Categoria categoria) ;

	public List<Categoria> listaCategorias();

	public void deleteCategoria(long categoriaId);

	public void updateCategoria(long categoriaId ,Categoria categoria);

	public Categoria findCategoria (long categoriaId);
}
