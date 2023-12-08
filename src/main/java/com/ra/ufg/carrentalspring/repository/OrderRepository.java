package com.ra.ufg.carrentalspring.repository;

import com.ra.ufg.carrentalspring.domain.PlacedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<PlacedOrder, Long> {
        @Query("SELECT carId, model, COUNT(carId) as rentalCount " +
                "FROM PlacedOrder " +
                "WHERE MONTH(startTime) = :month " +
                "GROUP BY carId, model " +
                "ORDER BY rentalCount DESC")
        List<Object[]> findMostRentedCarsInMonth(@Param("month") int month);


        @Query("SELECT userId, COUNT(DISTINCT carId) as vehicleCount " +
                "FROM PlacedOrder " +
                "GROUP BY userId")
        List<Object[]> findNumberOfVehiclesPerUser();

        @Query("SELECT model, COUNT(*) as rentalCount " +
                "FROM PlacedOrder " +
                "GROUP BY model")
        List<Object[]> findRentalCountPerVehicle();

    }


