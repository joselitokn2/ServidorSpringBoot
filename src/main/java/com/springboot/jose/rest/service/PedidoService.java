package com.springboot.jose.rest.service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.jose.rest.dto.CreatePedidoDto;
import com.springboot.jose.rest.model.LineaPedido;
import com.springboot.jose.rest.model.Pedido;
import com.springboot.jose.rest.model.Producto;
import com.springboot.jose.rest.model.UserEntity;
import com.springboot.jose.rest.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class PedidoService extends BaseService<Pedido, Long, PedidoRepository> {
	@Autowired
	ProductoServiceImpl productoService;
	
	public Pedido nuevoPedido(CreatePedidoDto nuevo, UserEntity cliente) {
		
		return save(Pedido.builder()
				.cliente(cliente)
				.lineas(nuevo.getLineas().stream()
							.map(lineaDto -> {
								
								Optional<Producto> p = productoService.findById(lineaDto.getProductoId());								
								if (p.isPresent()) {
									Producto producto = p.get();
									return LineaPedido.builder()
											.cantidad(lineaDto.getCantidad())
											.precio(producto.getPrecio())
											.producto(producto)
											.build();
								} else {
									return null;
								}
							})
							.filter(Objects::nonNull)
							.collect(Collectors.toSet())
						)							
				.build());
		
		
	}

	public Page<Pedido> findAllByUser(UserEntity user, Pageable pageable) {
		return repositorio.findByCliente(user, pageable);
	}

}
