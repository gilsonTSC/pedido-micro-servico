package com.br.myfood.pedido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.myfood.pedido.dto.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private Long idClient;
	
	private Long idrestaurant;
	
	private Long idMenu;
	
	public static Order create(OrderDto orderDto) {
		return Order.builder()
				.idClient(orderDto.getIdClient())
				.idMenu(orderDto.getIdMenu())
				.idrestaurant(orderDto.getIdrestaurant())
				.build();
	}
	
}