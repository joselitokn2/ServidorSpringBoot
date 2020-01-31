package com.springboot.jose.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jose.rest.dto.CreateProductoDTO;
import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.dto.converter.ProductoDTOConverter;
import com.springboot.jose.rest.exception.GlobalNotFoundException;
import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.repository.CategoriaRepository;
import com.springboot.jose.rest.repository.ProductoRepository;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProductoDTOConverter productoDTOconverter;
	


	@Override
	public Producto getProducto(long productoId) {
		return productoRepository.findById(productoId).orElse(null);
	}

	@Override
	public List<ProductoDTO> allProductos() {
		List<Producto> listaProductos = productoRepository.findAll();
		return listaProductos.stream().map(producto ->  productoDTOconverter.convertToDto(producto))
				.collect(Collectors.toList());
		
				
	}


	@Override
	public void deleteProducto(long productoId) {
		if (productoRepository.existsById(productoId)) {
			productoRepository.deleteById(productoId);
		} else {
			throw new GlobalNotFoundException(productoId);
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
	public void addProducto(CreateProductoDTO createProductoDTO) {
		Producto producto = productoDTOconverter.createdToDTO(createProductoDTO);
		categoriaRepository.findById(producto.getCategoria().getCategoria_id())
				.map(o -> productoRepository.save(producto));
		
	}
	



}
