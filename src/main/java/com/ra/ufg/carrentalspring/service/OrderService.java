package com.ra.ufg.carrentalspring.service;

import com.ra.ufg.carrentalspring.domain.PlacedOrder;
import com.ra.ufg.carrentalspring.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public List<PlacedOrder> getOrders() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }


    public PlacedOrder nuevaOrden(PlacedOrder order){
        log.info("Saving a new order");
        return orderRepository.save(order);
    }

    public List<Object[]> getMostRentedCarsInMonth(int month) {
        log.info("Fetching most rented cars for month: {}", month);
        return orderRepository.findMostRentedCarsInMonth(month);
    }

}
