package co.edu.umanizales.vehicle_rental.service;
import co.edu.umanizales.vehicle_rental.model.AbstractVehicle;
import co.edu.umanizales.vehicle_rental.model.*;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service

public class VehicleManagementService {
    public List<AbstractVehicle> AbstractVehicle= new ArrayList<>();
    @PostConstruct
    public void fillVehicle() {
        AbstractVehicle =new ArrayList<>();
        AbstractVehicle motorcycle = new Motorcycle("Motorcycle","OUC43F",5000,true,450000, true);
        AbstractVehicle.add(motorcycle);
        AbstractVehicle car= new Car("Car","MTO325",5000,true,588888, false);
        AbstractVehicle.add(car);
        AbstractVehicle van= new Van ("Van","COT879",6000,true,987776,(short) 5);
        AbstractVehicle.add( van);

    }
    public void registerVehicle(AbstractVehicle vehicle) {
        AbstractVehicle.add(vehicle);
    }
    public List<AbstractVehicle> getVehicles(String type, boolean state) {
        List<AbstractVehicle> AbstractVehicles = new ArrayList<>();
        for(AbstractVehicle Abstractvehicle : this.AbstractVehicle){
            if (Abstractvehicle.getType().equals(type) && Abstractvehicle.isState() == state){
                AbstractVehicles.add(Abstractvehicle);
            }
        }
        return AbstractVehicles;
    }
    public String deleteVehicle(String numberPlate) {
        boolean platefound = false;
        for (AbstractVehicle vehicle : this.AbstractVehicle) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                platefound = true;
                this.AbstractVehicle.remove(vehicle);
            }
            if (!platefound) {
                return "Vehicle Not Found";
            }
        }
        return "vehicle deleted";
    }
    public String consultVehicle(String numberPlate) {
        boolean platefound = false;
        for (AbstractVehicle Abstractvehicle : this.AbstractVehicle) {
            if (Abstractvehicle.getNumberPlate().equals(numberPlate)) {
                platefound = true;
                return "found vehicle"+Abstractvehicle.getNumberPlate();
            }
        }
        return "vehicle found";
    }



}
