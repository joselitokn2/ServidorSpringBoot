package com.springboot.jose.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import javax.persistence.ManyToOne;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity // Es una tabla producto
public class Producto implements Serializable {
	
	
	private static final long serialVersionUID = 7897940257027322024L;
	
	/* ID de la Base Datos */
	@Id // ID de la tabla 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generador de valor
	private long producto_id;
	
	/* LO NORMAL */
	private String nombre; 
	private String descripcion;
	private float precio;
	private int stock;
	
	@ManyToOne
	@JoinTable(name = "categoria_id")
	private Categoria categoria;
	
	/* la configuracion */
//	@Version
//	private long version;



	
	
	
}
