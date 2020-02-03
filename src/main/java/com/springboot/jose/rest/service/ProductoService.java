package com.springboot.jose.rest.service;

import java.util.List;

import com.springboot.jose.rest.dto.CreateProductoDTO;
import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.model.Producto;



public interface ProductoService {



	public void addProducto(CreateProductoDTO createProductoDTO, String imagenUrl);

	public List<ProductoDTO> allProductos();
	
	public void deleteProducto(long productoId);

	public void updateProducto(long productoId, Producto producto);

	public Producto getProducto(long productoId);

	public void addProducto(CreateProductoDTO createProductoDTO);

	




	
}
