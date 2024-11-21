package co.edu.umanizales.vehicle_rental.controller;
import co.edu.umanizales.vehicle_rental.model.*;
import co.edu.umanizales.vehicle_rental.service.*;
import co.edu.umanizales.vehicle_rental.dto.FilterDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/AbstractVehicle")
public class RentalVehicleController {
    @Autowired
    private VehicleManagementService vehicleManagementService;
    @GetMapping("/fillVehicle")
    public String fillVehicle() {
        vehicleManagementService.fillVehicle();
        return "Filled vehicle";
    }
    @GetMapping("/list")
    public List<AbstractVehicle> getVehicles() {
        return vehicleManagementService.getAbstractVehicle();
    }
    @PostMapping("/register/moto")
    public String add(@RequestBody Motorcycle AbstractVehicle) {
        vehicleManagementService.registerVehicle(AbstractVehicle);
        return "Vehicle added";

    }
    @PostMapping("/register/car")
    public String add(@RequestBody Car AbstractVehicle) {
        vehicleManagementService.registerVehicle(AbstractVehicle);
        return "Vehicle added";
    }
    @PostMapping("/register/van")
    public String add(@RequestBody Van AbstractVehicle) {
        vehicleManagementService.registerVehicle(AbstractVehicle);
        return "Vehicle added";
    }
    @GetMapping("/listType/{type}/{state}")
    public List<AbstractVehicle> getVehicles(@PathVariable String type,@PathVariable boolean state) {
        return vehicleManagementService.getVehicles(type, state);
    }
    @PatchMapping("/changeAvailable/{numberPlate}")
    public String changeAvailable(@RequestBody boolean state, @PathVariable String numberPlate) {
        return vehicleManagementService.getVehicles(numberPlate,state).toString();
    }
    @DeleteMapping("/deleteVehicle/{numberPlate}")
    public String deleteVehicle(@PathVariable String numberPlate) {
        return vehicleManagementService.deleteVehicle(numberPlate);

    }
    @GetMapping("/consult/{numberPlate}")
    public String consultVehicle(@PathVariable String numberPlate) {
        return vehicleManagementService.consultVehicle(numberPlate);
    }
    @GetMapping("/listRental")
    public List<RentalVehicle> getRentalVehicles() {
        return userManagementService.rental;
    }
    @PostMapping("/filter")
    public List<FilterDTO> filter(@RequestBody FilterDTO filter) {
        return vehicleManagementService.filterByColor(filter.getType(),filter.getColor());
    }












    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/fillUser")
    public String fillUser() {
        userManagementService.fillUsers();
        return "Filled user";
    }
    @GetMapping("/listUser")
    public List<User> getUsers() {
        return userManagementService.getLstusers();
    }
    @GetMapping("/listCustomer")
    public List<Customer> getCustomers() {
        return userManagementService.getLstcustomers();
    }
    @PostMapping("/registerUser")
    public String add(@RequestBody User lstuser) {
        userManagementService.registerUser((User)lstuser);
        return "User added";
    }
    @PostMapping("/registerCustomer")
    public String add(@RequestBody Customer lstcustomer) {
        userManagementService.registerCustomer((Customer) lstcustomer);
        return "Customer added";
    }
    @PostMapping("/validateUser/{login}/{password}")
    public boolean validateUser(@PathVariable String login, @PathVariable String password) {
        if(userManagementService.validateUser(login, password)) {
            return true;
        }
        return false;
    }

    @PostMapping("/registerRental")
    public String add(@RequestBody  RentalVehicle rentalVehicle) {
        userManagementService.setRental((List<RentalVehicle>)rentalVehicle);
        return "Rental added";
    }
   @PostMapping("/restriction")
    public String restriction(@RequestBody User user){
        return userManagementService.restriction(user);
   }

}
