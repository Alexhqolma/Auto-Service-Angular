package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.ServiceForCar;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.ProductService;
import com.example.autoservice.service.ServiceForCarService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements RequestDtoMapper<OrderRequestDto, Order>,
        ResponseDtoMapper<OrderResponseDto, Order> {
    private final CarService carService;
    private final ServiceForCarService serviceForCarService;
    private final ProductService productService;

    public OrderMapper(CarService carService, ServiceForCarService serviceForCarService,
                       ProductService productService) {
        this.carService = carService;
        this.serviceForCarService = serviceForCarService;
        this.productService = productService;
    }

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setCar(carService.findById(dto.getCarId()));
        order.setProblemDescription(dto.getProblemDescription());
        order.setStartDate(dto.getStartDate());
        if (dto.getCarServicesId() != null) {
            order.setServices(dto.getCarServicesId()
                    .stream()
                    .map(serviceForCarService::findById)
                    .collect(Collectors.toList()));
        }
        if (dto.getProductsId() != null) {
            order.setProducts(dto.getProductsId()
                    .stream()
                    .map(productService::findById)
                    .collect(Collectors.toList()));
        }
        order.setStatus(dto.getStatus());
        order.setPrice(dto.getPrice());
        order.setFinishDate(dto.getFinishDate());
        return order;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setCarId(order.getCar().getId());
        orderResponseDto.setProblemDescription(order.getProblemDescription());
        orderResponseDto.setStartDate(order.getStartDate());
        if (order.getServices() != null) {
            orderResponseDto.setCarServicesId(order.getServices()
                    .stream()
                    .map(ServiceForCar::getId)
                    .collect(Collectors.toList()));
        }
        if (order.getProducts() != null) {
            orderResponseDto.setProductsId(order.getProducts()
                    .stream()
                    .map(Product::getId)
                    .collect(Collectors.toList()));
        }
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setFinishDate(order.getFinishDate());
        return orderResponseDto;
    }
}
