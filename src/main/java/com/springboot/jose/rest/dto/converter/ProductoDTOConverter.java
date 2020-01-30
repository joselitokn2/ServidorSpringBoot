package com.springboot.jose.rest.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.model.Producto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	/*Transforma un producto en un producto nuevo*/
	public ProductoDTO convertToDto(Producto producto) {
		return modelMapper.map(producto, ProductoDTO.class);
	}

}
