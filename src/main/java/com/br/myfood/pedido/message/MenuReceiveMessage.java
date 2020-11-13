package com.br.myfood.pedido.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.br.myfood.pedido.dto.MenuOrderDto;
import com.br.myfood.pedido.entity.Client;
import com.br.myfood.pedido.repository.ClientRepository;

@Component
public class MenuReceiveMessage {

    private final ClientRepository clientRepository;

    @Autowired
    public MenuReceiveMessage(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RabbitListener(queues = {"${cadastro.menu.queue}"})
    public void receive(@Payload MenuOrderDto menuOrderDto) {
        System.out.println(menuOrderDto);
    }

}