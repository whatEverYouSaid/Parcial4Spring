package com.ra.ufg.carrentalspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class VehicleDTO {

    private long id;
    private String manufacturer;
    private String model;
    private String year;
    private  double price;
    public boolean reserved;
}
