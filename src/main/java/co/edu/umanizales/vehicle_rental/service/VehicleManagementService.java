package co.edu.umanizales.vehicle_rental.service;
import co.edu.umanizales.vehicle_rental.dto.FilterDTO;
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
        AbstractVehicle motorcycle = new Motorcycle("Motorcycle","azul","OUC43F",5000,true,450000, true);
        AbstractVehicle.add(motorcycle);
        AbstractVehicle car= new Car("Car","verde","MTO325",5000,true,588888, false);
        AbstractVehicle.add(car);
        AbstractVehicle van= new Van ("Van","rojo","COT879",6000,true,987776,(short) 5);
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
    public List<FilterDTO>filterByColor(String color, String type) {
        int countOne=0;
        int countTwo=0;
        int countThree=0;
        for (AbstractVehicle filteredVehicle:this.AbstractVehicle ) {
            if (filteredVehicle.getColor().equals(color)) {
                if ("car".equalsIgnoreCase(filteredVehicle.getType())) {
                    countOne++;
                }
            }
                if (filteredVehicle.getColor().equals(color) ) {
                    if ("motocycle".equalsIgnoreCase(filteredVehicle.getType())) {
                        countTwo++;
                    }


            } else if (filteredVehicle.getColor().equals(color)) {
                    if ("van".equalsIgnoreCase(filteredVehicle.getType())) {
                        countThree++;
                    }
            }

        }
        ArrayList<FilterDTO> filteredVehicles = new ArrayList<>();
        filteredVehicles.add(new FilterDTO("car", countOne));
        filteredVehicles.add(new FilterDTO("motocycle", countTwo));
        filteredVehicles.add(new FilterDTO("van", countThree));
        return filteredVehicles;


    }
}
