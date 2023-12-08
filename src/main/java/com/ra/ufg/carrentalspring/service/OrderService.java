package com.ra.ufg.carrentalspring.service;

import com.ra.ufg.carrentalspring.domain.PlacedOrder;
import com.ra.ufg.carrentalspring.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Map<String, Object>> getMostRentedCarsInMonth(int month) {
        List<Object[]> result = orderRepository.findMostRentedCarsInMonth(month);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : result) {
            Map<String, Object> carInfo = new HashMap<>();
            carInfo.put("model", (String) row[1]); // Assuming model is the second element in the array
            carInfo.put("rentalCount", (Long) row[2]); // Assuming rental count is the third element
            response.add(carInfo);
        }

        return response;
    }

    public List<Map<String, Object>> getNumberOfVehiclesPerUser() {
        List<Object[]> result = orderRepository.findNumberOfVehiclesPerUser();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : result) {
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("userId", (Long) row[0]); // Assuming userId is the first element in the array
            userInfo.put("vehicleCount", (Long) row[1]); // Assuming vehicle count is the second element
            response.add(userInfo);
        }

        return response;
    }

    public List<Map<String, Object>> getRentalCountPerVehicle() {
        List<Object[]> result = orderRepository.findRentalCountPerVehicle();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] row : result) {
            Map<String, Object> vehicleInfo = new HashMap<>();
            vehicleInfo.put("model", (String) row[0]);
            vehicleInfo.put("rentalCount", (Long) row[1]);
            response.add(vehicleInfo);
        }

        return response;
    }

}
