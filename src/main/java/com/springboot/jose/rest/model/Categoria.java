package com.springboot.jose.rest.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Categoria {
	@Id @GeneratedValue
	private Long categoria_id;
	
	private String nombre;
	/* la configuracion */
	
//	@Version
//	private long version;
	
}
