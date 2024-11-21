package co.edu.umanizales.vehicle_rental.model;


public class Car extends AbstractVehicle implements VehicleAble{
    public boolean extras;

    public Car(String type,String numberPlate, int km, boolean state, double rentalPrice,boolean extras) {
        super(type,numberPlate, km, state, rentalPrice);
        this.extras = extras;
    }

    @Override
    public void giveBack(int kmFinal) {

    }

    @Override
    public double calculateRent(int km) {
        return 0;
    }

    public boolean isExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }
}
