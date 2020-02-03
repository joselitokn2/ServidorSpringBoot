package com.springboot.jose.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.jose.rest.dto.CreateProductoDTO;
import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.model.Producto;



public interface ProductoService {



	public void addProducto(CreateProductoDTO createProductoDTO, String imagenUrl);

	public Page<ProductoDTO> allProductos(Pageable pageable);
	
	public void deleteProducto(long productoId);

	public void updateProducto(long productoId, Producto producto);

	public Producto getProducto(long productoId);

	public void addProducto(CreateProductoDTO createProductoDTO);

	




	
}
