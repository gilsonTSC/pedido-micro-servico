package com.br.myfood.pedido.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfood.pedido.entity.Order;
import com.br.myfood.pedido.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public Order insertOrder(Order order) {
		return this.orderRepository.save(order);
	}
	
	public Order updateOrder(Order order) {
		Optional<Order> newOrder = this.orderRepository.findById(order.getId());
		
		if(newOrder.isPresent()) {
			return this.orderRepository.save(order);
		}else {
			return null;
		}
	}
	
	public boolean deleteOrder(Long id) {
		Optional<Order> order = this.orderRepository.findById(id);
		
		if(order.isPresent()) {
			this.orderRepository.delete(order.get());
			return true;
		}else {
			return false;
		}
	}
	
	public Optional<Order> findbyId(Long id) {
		return this.orderRepository.findById(id);
	}
	
}