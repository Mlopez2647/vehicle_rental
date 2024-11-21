package co.edu.umanizales.vehicle_rental.model;

public class Van extends AbstractVehicle {
    public short capacity;

    public Van(String type,String color,String numberPlate, int km, boolean state, double rentalPrice, short capacity) {
        super(type,color,numberPlate, km, state, rentalPrice);
        this.capacity = capacity;

    }

    @Override
    public void giveBack(int kmFinal) {

    }

    @Override
    public double calculateRent(int km) {
        return 0;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }
}
