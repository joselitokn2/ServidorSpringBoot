package com.springboot.jose.rest.service;

import java.util.List;

import com.springboot.jose.rest.model.Producto;



public interface ProductoService {

	public void addProducto(Producto producto) ;

	public List<Producto> listaProductos();

	public void deleteProducto(long productoId);

	public void updateProducto(long productoId ,Producto producto);

	public Producto findProducto(long productoId);
}
