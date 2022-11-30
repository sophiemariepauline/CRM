package com.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
