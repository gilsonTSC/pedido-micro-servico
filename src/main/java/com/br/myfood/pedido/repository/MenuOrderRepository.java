package com.br.myfood.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.myfood.pedido.entity.MenuOrder;

@Repository
public interface MenuOrderRepository extends JpaRepository<MenuOrder, Long>{

}