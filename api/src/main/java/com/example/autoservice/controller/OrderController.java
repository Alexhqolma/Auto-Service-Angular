package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.OrderMapper;
import com.example.autoservice.dto.mapper.ProductMapper;
import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.request.ProductRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.dto.response.ServiceForCarResponseDto;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Status;
import com.example.autoservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    public OrderController(OrderService orderService,
                           OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
    }

    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderService.save(orderMapper.mapToModel(orderRequestDto));
        return orderMapper.mapToDto(order);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@PathVariable Long id,
                                   @RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderMapper.mapToModel(orderRequestDto);
        order.setId(id);
        return orderMapper.mapToDto(orderService.save(order));
    }

    @PostMapping("/product/{id}")
    public OrderResponseDto addProduct(@PathVariable Long id,
                                       @RequestBody ProductRequestDto productRequestDto) {
        Order order = orderService
                .addProductToOrder(id, productMapper.mapToModel(productRequestDto));
        return orderMapper.mapToDto(order);
    }

    @PutMapping("/status/{id}")
    public OrderResponseDto changeStatus(@PathVariable Long id,
                                                 @RequestBody OrderRequestDto orderRequestDto,
                                                 @RequestBody Status status) {
        Order order = orderMapper.mapToModel(orderRequestDto);
        order.setId(id);
        order.setStatus(status);
        return orderMapper.mapToDto(orderService.save(order));
    }

    @GetMapping("/price/{id}")
    public OrderResponseDto getPrice(@PathVariable Long id) {
        return orderMapper.mapToDto(orderService.getOrderPrice(id));
    }

    @GetMapping
    public List<OrderResponseDto> getOrders() {
        return orderService.findAll().stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
