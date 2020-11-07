package com.br.myfood.pedido.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	private Long idClient;
	
	private Long idrestaurant;
	
	private Long idMenu;
	
}