package org.example.ms_commande.service;

import org.example.ms_commande.Util.RestClient;
import org.example.ms_commande.dto.UserDto;
import org.example.ms_commande.entity.Order;
import org.example.ms_commande.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired private IOrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Map<String, Object> getAllByUser(long id) {
        RestClient<UserDto> userDtoRestClient = new RestClient<>("http://localhost:8080/user/" + id);
        UserDto userDto = userDtoRestClient.getRequest(UserDto.class);

        Map<String, Object> response = new HashMap<>();
        response.put("user", userDto);
        response.put("orders", orderRepository.findAllByUserId(id));

        return response;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(long id, Order order) {
        Order returnedOrder = orderRepository.findById(id).orElseThrow();
        returnedOrder.setUserId(order.getUserId());
        returnedOrder.setProduct(order.getProduct());
        orderRepository.save(returnedOrder);
        return returnedOrder;
    }
}