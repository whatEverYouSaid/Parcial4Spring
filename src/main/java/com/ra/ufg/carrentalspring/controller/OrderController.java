package com.ra.ufg.carrentalspring.controller;

import com.ra.ufg.carrentalspring.domain.PlacedOrder;
import com.ra.ufg.carrentalspring.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<PlacedOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity<PlacedOrder> submitOrder(@RequestBody PlacedOrder order) {
        return new ResponseEntity<>(
                orderService.nuevaOrden(order),
                HttpStatus.OK);
    }

    @GetMapping("/most-rented-cars")
    public ResponseEntity<List<Map<String, Object>>> getMostRentedCars(@RequestParam int month) {
        return new ResponseEntity<>(
                orderService.getMostRentedCarsInMonth(month),
                HttpStatus.OK);
    }

    @GetMapping("/vehicles-per-user")
    public ResponseEntity<List<Map<String, Object>>> getNumberOfVehiclesPerUser() {
        return new ResponseEntity<>(
                orderService.getNumberOfVehiclesPerUser(),
                HttpStatus.OK);
    }

    @GetMapping("/rental-count-per-vehicle")
    public ResponseEntity<List<Map<String, Object>>> getRentalCountPerVehicle() {
        return new ResponseEntity<>(
                orderService.getRentalCountPerVehicle(),
                HttpStatus.OK);
    }



}
