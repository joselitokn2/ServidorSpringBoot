package com.springboot.jose.rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Categoria {
	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
//	@ManyToMany(mappedBy = "categorias")
//	private List<Producto> productos;
}
