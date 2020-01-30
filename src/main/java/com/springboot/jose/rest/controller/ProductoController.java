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

import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.service.ProductoService;

@CrossOrigin(origins = "*")
@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@PostMapping("/producto/alta")
	public ResponseEntity<String> altaProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
		return new ResponseEntity<>("Ha sido creado", HttpStatus.OK);
	}

	@GetMapping("/producto/lista")
	public ResponseEntity<List<Producto>> listaProductos() {
		List<Producto> producto = productoService.listaProductos();
		return ResponseEntity.ok().body(producto);
	}

	@PutMapping("/prodcuto/update/{id}")
	public ResponseEntity<String> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
		productoService.updateProducto(id, producto);
		return new ResponseEntity<>("Ha sido actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/producto/delete/{id}")
	public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
		productoService.deleteProducto(id);
		return new ResponseEntity<>("Ha sido eliminado", HttpStatus.OK);
	}

}
