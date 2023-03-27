package com.example.autoservice.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @JoinTable
    @OneToMany
    private List<Order> readyOrders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Order> getReadyOrders() {
        return readyOrders;
    }

    public void setReadyOrders(List<Order> readyOrders) {
        this.readyOrders = readyOrders;
    }
}
