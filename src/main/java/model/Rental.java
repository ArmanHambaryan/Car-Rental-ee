package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    private int id;
    private int carId;
    private int customerId;
    private String startDate;
    private String endDate;
    private double totalCost;
    private RentalStatus status;

}
