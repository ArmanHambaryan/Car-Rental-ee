package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private int id;
    private String brand;
    private String model;
    private String year;
    private double dailyRate;
    private CarStatus status;

}
