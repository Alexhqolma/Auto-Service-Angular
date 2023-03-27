package com.example.autoservice.repository;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterRepository extends JpaRepository<Master, Long> {
    @Query("select o from Order o join fetch o.services s where s.master.id = :id AND o.status = 'Success'")
    List<Order> findReadyOrder(Long id);
}
