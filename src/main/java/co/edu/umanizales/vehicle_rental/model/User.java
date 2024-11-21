package co.edu.umanizales.vehicle_rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    public String document;
    public String name;
    public String login;
    public String password;
    public int age;
    public boolean condition;
}

