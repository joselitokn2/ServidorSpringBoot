package com.springboot.jose.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.springboot.jose.rest.dto.CreateProductoDTO;
import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.dto.converter.ProductoDTOConverter;
import com.springboot.jose.rest.model.Categoria;
import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.repository.CategoriaRepository;
import com.springboot.jose.rest.repository.ProductoRepository;
import com.springboot.jose.rest.service.ProductoService;

@CrossOrigin(origins = "*")
@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;
	@Autowired
	ProductoDTOConverter productoDTOconverter;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProductoRepository productoRepository;

	@PostMapping("/producto/alta")
	public ResponseEntity<String> altaProducto(@RequestBody Producto producto) {
		productoService.addProducto(producto);
		return new ResponseEntity<>("Ha sido creado", HttpStatus.OK);
	}
	
	/**
	 * Insertamos un nuevo producto
	 * 
	 * @param nuevo
	 * @return 201 y el producto insertado
	 */
	@PostMapping("/producto/altaDTO")
	// public ResponseEntity<?> nuevoProducto(@RequestBody Producto nuevo) {
	public ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		// En este caso, para contrastar, lo hacemos manualmente
		
		// Este código sería más propio de un servicio. Lo implementamos aquí
		// por no hacer más complejo el ejercicio.
		Producto nuevoProducto = new Producto();
		nuevoProducto.setNombre(nuevo.getNombre());
		nuevoProducto.setPrecio(nuevo.getPrecio());
		Categoria categoria = categoriaRepository.findById(nuevo.getCategoria_id()).orElse(null);
		nuevoProducto.setCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepository.save(nuevoProducto));
	}
	/**
	 * Obtenemos todos los productos
	 * 
	 * @return 404 si no hay productos, 200 y lista de productos si hay uno o más
	 */
	@GetMapping("/producto/listaDTO")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepository.findAll();

		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {

			List<ProductoDTO> dtoList = result.stream().map(productoDTOconverter::convertToDto)
					.collect(Collectors.toList());

			return ResponseEntity.ok(dtoList);
		}

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
