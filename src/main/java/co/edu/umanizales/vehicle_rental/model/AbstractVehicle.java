package co.edu.umanizales.vehicle_rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
 public abstract class AbstractVehicle implements VehicleAble {
    private String type;
    private String color;
    public String numberPlate;
    public int km;
    public boolean state;
    public double rentalPrice;



    @Override
    public void rent() {

    }

    @Override
    public void giveBack() {

    }

    @Override
    public String showData() {
        return "";
    }
    public abstract double calculateRent(int km);

}

