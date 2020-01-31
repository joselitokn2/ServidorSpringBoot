package com.springboot.jose.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoDTO {
	private String nombre;
	private float precio;
	private String descripcion;
	private int stock;
	private String categoriaNombre;

}
