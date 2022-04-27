package com.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.order.exception.OrdersNotFoundException;
import com.order.model.Order;
import com.order.repository.OrderRepository;
import com.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.OperationsException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/place-order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws JsonProcessingException {

        try {
            orderService.bookOrder(order);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get-orders/{name}")
    public ResponseEntity<List<Order>> getOrderByName(@PathVariable("name") String name){
        return new ResponseEntity<>(orderService.getOrderListByName(name), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Order>> getAllOrders(){
        try {
            List<Order> list = orderService.getAllOrders();
            return ResponseEntity.ok().body(list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    @GetMapping("/cancel-order/{id}")
//    public Order cancelOrder(@PathVariable("id") int id) {
//
//    }


}
