package com.springboot.jose.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.repository.ProductoRepository;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public void addProducto(Producto empleado) {
		productoRepository.save(empleado);

	}

	@Override
	public List<Producto> listaProductos() {
		return  productoRepository.findAll();
	}

	@Override
	public void deleteProducto(long productoId) {
		if (productoRepository.existsById(productoId)) {
			productoRepository.deleteById(productoId);
		} 
	}

	@Override
	public void updateProducto(long productoId, Producto producto) {
		if (productoRepository.existsById(productoId)) {
			producto.setProducto_id(productoId);
			productoRepository.save(producto);
		} 

	}

	@Override
	public Producto findProducto(long productoId) {
		return productoRepository.findById(productoId).orElse(null);
	}

}
