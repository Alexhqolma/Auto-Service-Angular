package com.example.autoservice.repository;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.ServiceForCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select s from ServiceForCar s join s.order o where o.id = :id")
    List<ServiceForCar> findAllServicesById(Long id);

    @Query("select p from Product p join Order o join o.products where o.id= :id")
    List<Product> findAllProductsById(Long id);

    @Query("select o from Order o join fetch o.car c where c.owner.id = :id")
    List<Order> findAllOrdersByOwnerId(Long id);
}
