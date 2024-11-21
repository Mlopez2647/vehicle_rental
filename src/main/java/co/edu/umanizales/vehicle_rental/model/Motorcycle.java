package co.edu.umanizales.vehicle_rental.model;


public class Motorcycle extends AbstractVehicle implements VehicleAble{
    public boolean helmet;

    public Motorcycle(String type,String numberPlate, int km, Boolean state, double rentalPrice, Boolean helmet) {
        super(type,numberPlate, km, state, rentalPrice);
        this.helmet = helmet;
    }

    @Override
    public void giveBack(int kmFinal) {
    }

    @Override
    public double calculateRent(int km) {
        return 200000;
    }

    public boolean isHelmet() {
        return helmet;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }
}
