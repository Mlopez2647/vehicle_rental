package co.edu.umanizales.vehicle_rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RentalVehicle  {
    public AbstractVehicle vehicle;
    public User registerUser;
    public Date rentalDate;
    public Date returnDate;
    public Customer customer;

    public RentalVehicle(String car, String smaxi, String s, String s1, String santi) {
    }
}
