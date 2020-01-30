package com.springboot.jose.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateProductoDTO {
	
	
	private String nombre;
	private float precio;
	private long categoria_id;

}
