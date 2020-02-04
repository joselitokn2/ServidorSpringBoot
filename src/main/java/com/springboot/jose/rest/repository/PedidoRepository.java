package com.springboot.jose.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.jose.rest.model.Pedido;
import com.springboot.jose.rest.model.Producto;



public interface PedidoRepository extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Producto>  {

}
