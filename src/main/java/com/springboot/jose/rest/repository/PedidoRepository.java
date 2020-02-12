package com.springboot.jose.rest.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.jose.rest.model.Pedido;
import com.springboot.jose.rest.model.UserEntity;




public interface PedidoRepository extends JpaRepository<Pedido, Long>  {

	Page<Pedido> findByCliente(UserEntity cliente, Pageable pageable);

}
