package com.example.autoservice.service.impl;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.model.Status;
import com.example.autoservice.repository.OrderRepository;
import com.example.autoservice.service.OrderService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private static final double DIAGNOSTIC_PRICE = 500.0;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        order.setStartDate(LocalDate.now());
        order.setStatus(Status.ACCEPTED);
        return orderRepository.save(order);
    }

    @Override
    public Order addProductToOrder(Long orderId, Product product) {
        Order order = findById(orderId);
        List<Product> products = order.getProducts();
        products.add(product);
        order.setProducts(products);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order orderStatus(Long orderId, Status status) {
        Order order = findById(orderId);
        order.setStatus(status);
        order.setFinishDate(LocalDate.now());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderPrice(Long orderId) {
        Order order = findById(orderId);
        List<ServiceForCar> services = orderRepository.findAllServicesById(orderId);
        List<Product> products = orderRepository.findAllProductsById(orderId);
        double countServices = services.size() == 1
                ? DIAGNOSTIC_PRICE :
                services.stream()
                        .map(ServiceForCar::getPrice)
                        .mapToDouble(BigDecimal::doubleValue).sum();
        double countProducts = products.stream()
                .map(Product::getPrice)
                .mapToDouble(BigDecimal::doubleValue).sum();
        order.setPrice(BigDecimal.valueOf((countServices - (services.size() / 100))
                + (countProducts - (products.size() / 100))));
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find order by id " + id));
    }

    @Override
    public List<Order> findAllOrdersByOwnerId(Long id) {
        return orderRepository.findAllOrdersByOwnerId(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
