package co.edu.umanizales.vehicle_rental.service;
import co.edu.umanizales.vehicle_rental.model.*;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class UserManagementService {
    public List<User> lstusers= new ArrayList<>();

    public List<Customer> lstcustomers= new ArrayList<>();
   @PostConstruct
   public void fillUsers() {
       lstusers=new ArrayList<>();
       User Miguel= new User("2002902020","Miguel","Mlopez","230020",19,false);
       lstusers.add(Miguel);
       User Camilo= new User("2002344520","Camilo","Ccam","q2334",50,true);
       lstusers.add(Camilo);
       lstcustomers=new ArrayList<>();
       Customer Sebas=new Customer("Sebastina","23232322");
       lstcustomers.add(Sebas);

   }
   public void registerUser(User user) {
       lstusers.add(user);
   }
   public void registerCustomer(Customer customer) {
       lstcustomers.add(customer);
   }
   public boolean validateUser(String login, String password) {
       for (User user : this.lstusers) {
           if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
               return true;
           }
       }
       return false;
   }

    public List<RentalVehicle>rental=new ArrayList<>();
        @PostConstruct
    public void fillRental() {
            rental=new ArrayList<>();
            RentalVehicle Santi=new RentalVehicle("Car","Smaxi","12/05/2024","18/05/2024","Santi");
            rental.add(Santi);
    }
    public void registerRental(RentalVehicle rentavehicle) {
            rental.add(rentavehicle);
    }
    public String restriction(User user) {
            if(user.getAge()<18){
                return "restriction age";
            }
            if(user.isCondition()==true){
                return "restriction condition";
        }
            else;
            return "never restriction";
    }
}
