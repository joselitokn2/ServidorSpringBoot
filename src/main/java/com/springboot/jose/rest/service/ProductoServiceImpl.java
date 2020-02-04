
package com.springboot.jose.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.springboot.jose.rest.dto.CreateProductoDTO;
import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.dto.converter.ProductoDTOConverter;
import com.springboot.jose.rest.exception.GlobalNotFoundException;
import com.springboot.jose.rest.exception.GlobalSearchException;
import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.repository.CategoriaRepository;
import com.springboot.jose.rest.repository.ProductoRepository;
import com.springboot.jose.rest.upload.StorageService;

@Service

@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProductoDTOConverter productoDTOconverter;

	@Autowired
	StorageService storageService;

	@Override
	public Producto getProducto(long productoId) {
		return productoRepository.findById(productoId).orElse(null);
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
	public void addProducto(CreateProductoDTO createProductoDTO, String imagen) {

		createProductoDTO.setImagen(imagen);
		Producto producto;
		producto = productoDTOconverter.createdToDTO(createProductoDTO);
		categoriaRepository.findById(producto.getCategoria().getCategoria_id().longValue())
				.map(o -> productoRepository.save(producto));

	}

	@Override
	public void addProducto(CreateProductoDTO createProductoDTO) {
		Producto producto = productoDTOconverter.createdToDTO(createProductoDTO);
		categoriaRepository.findById(producto.getCategoria().getCategoria_id().longValue())
				.map(o -> productoRepository.save(producto));

	}

	@Override
	public Page<ProductoDTO> allProductos(Pageable pageable) {
		Page<Producto> productoLista = productoRepository.findAll(pageable);
		Page<ProductoDTO> empleadoListaDTO = productoLista.map(productoDTOconverter::convertToDto);
		if (empleadoListaDTO.isEmpty()) {
			throw new GlobalNotFoundException("empty list");
		} else {
			return empleadoListaDTO;
		}
		
	}

	@Override
	public Page<ProductoDTO> findByNombre(String txt, Pageable pageable) {
		Page<Producto> productoLista = productoRepository.findByNombreContainsIgnoreCase(txt, pageable);
		Page<ProductoDTO> productoListaDTO = productoLista.map(productoDTOconverter::convertToDto);
		if (productoListaDTO.isEmpty()) {
			throw new GlobalSearchException(txt);
		} else {
			return productoListaDTO;
		}
	
	}


	

}
