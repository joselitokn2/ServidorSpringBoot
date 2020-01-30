package com.springboot.jose.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.jose.rest.model.Categoria;

import com.springboot.jose.rest.service.CategoriaService;

@CrossOrigin(origins = "*")
@RestController
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping("/categoria/alta")
	public ResponseEntity<String> altaCategoria(@RequestBody Categoria categoria) {
		categoriaService.addCategoria(categoria);;
		return new ResponseEntity<>("Ha sido creado", HttpStatus.OK);
	}

	@GetMapping("/categoria/lista")
	public ResponseEntity<List<Categoria>> listaCategorias() {
		List<Categoria> resultCategoria = categoriaService.listaCategorias();
		return ResponseEntity.ok().body(resultCategoria);
	}


	@PutMapping("/categoria/update/{id}")
	public ResponseEntity<String> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		categoriaService.updateCategoria(id, categoria);
		return new ResponseEntity<>("Ha sido actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/categoria/delete/{id}")
	public ResponseEntity<String> deleteCategoria(@PathVariable Long id) {
		categoriaService.deleteCategoria(id);
		return new ResponseEntity<>("Ha sido eliminado", HttpStatus.OK);
	}
	

}
