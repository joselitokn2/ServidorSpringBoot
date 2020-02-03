package com.springboot.jose.rest.controller;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.jose.rest.dto.CreateProductoDTO;
import com.springboot.jose.rest.dto.ProductoDTO;
import com.springboot.jose.rest.dto.converter.ProductoDTOConverter;
import com.springboot.jose.rest.exception.GlobalNotFoundException;
import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.repository.CategoriaRepository;
import com.springboot.jose.rest.repository.ProductoRepository;
import com.springboot.jose.rest.service.ProductoService;
import com.springboot.jose.rest.upload.StorageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {

	@Autowired
	ProductoService productoService;
	@Autowired
	ProductoDTOConverter productoDTOconverter;
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	StorageService storageService;

	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getItem(@PathVariable Long id) {
		if (id <= 0) {
			throw new GlobalNotFoundException("Invalid id");
		}
		Producto producto = productoService.getProducto(id);
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

	@PostMapping("/producto/add")
	public ResponseEntity<CreateProductoDTO> addProducto(@RequestBody CreateProductoDTO createProductoDTO) {
		productoService.addProducto(createProductoDTO);
		return new ResponseEntity<>(createProductoDTO, HttpStatus.CREATED);
	}
	/**
	 * Insertamos un nuevo producto
	 * 
	 * @param nuevo
	 * @return 201 y el producto insertado
	 */
	@PostMapping(value = "/producto", consumes= MediaType.MULTIPART_FORM_DATA_VALUE) //Aunque no es obligatorio, podemos indicar que se consume multipart/form-data
	public ResponseEntity<?> nuevoProducto(@RequestPart("nuevo") CreateProductoDTO createProductoDTO, 
			@RequestPart("file") MultipartFile file) {
		
		// Almacenamos el fichero y obtenemos su URL
		String urlImagen = null;
		
		if (!file.isEmpty()) {
			String imagen = storageService.store(file);
			urlImagen = MvcUriComponentsBuilder
							// El segundo argumento es necesario solo cuando queremos obtener la imagen
							// En este caso tan solo necesitamos obtener la URL
							.fromMethodName(FicherosController.class, "serveFile", imagen, null)  
							.build().toUriString();
		}
		
		// Construimos nuestro nuevo Producto a partir del DTO
		
	
		productoService.addProducto(createProductoDTO);
		return new ResponseEntity<>(createProductoDTO, HttpStatus.CREATED);
	}


	@GetMapping("/producto/all")
	public ResponseEntity<List<ProductoDTO>> allProductos() {
		List<ProductoDTO> producto = productoService.allProductos();
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}

	@PutMapping("/producto/update/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
		if (producto != null) {
			productoService.updateProducto(id, producto);
		}
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}

	@DeleteMapping("/producto/delete/{id}")
	public ResponseEntity<Producto> deleteEmpleado(@PathVariable Long id) {
		Producto producto = productoService.getProducto(id);
		productoService.deleteProducto(id);
		return new ResponseEntity<>(producto, HttpStatus.NO_CONTENT);
	}

}
