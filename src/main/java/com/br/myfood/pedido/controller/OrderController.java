package com.br.myfood.pedido.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfood.pedido.dto.OrderDto;
import com.br.myfood.pedido.entity.Order;
import com.br.myfood.pedido.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Order> inserOrder(@RequestBody OrderDto dto) {
		Order order = null;
		try {
			order = this.orderService.insertOrder(Order.create(dto));
		}catch(Exception e){
			ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok(order);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto){
		Order order = Order.create(orderDto);
		order.setId(id);
		
		Order updateOrder = this.orderService.updateOrder(order);
		
		return Objects.nonNull(updateOrder) ? ResponseEntity.ok(updateOrder) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable("id") Long id){
		return this.orderService.deleteOrder(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Order> findById(@PathVariable("id") Long id){
		Optional<Order> order = this.orderService.findbyId(id);
		
		return order.isPresent() ? ResponseEntity.ok(order.get()) : ResponseEntity.notFound().build();
	}
	
}