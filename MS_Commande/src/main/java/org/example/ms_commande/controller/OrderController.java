package org.example.ms_commande.controller;

import org.example.ms_commande.entity.Order;
import org.example.ms_commande.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Map<String, Object>> getAllOrdersByUser(@PathVariable long id) {
        return ResponseEntity.ok(orderService.getAllByUser(id));
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>("Created !", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Deleted !", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrd(@RequestBody Order order, @PathVariable long id) {
        return ResponseEntity.ok(orderService.updateOrder(id, order));
    }

}