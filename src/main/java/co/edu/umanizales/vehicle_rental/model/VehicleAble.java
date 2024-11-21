package co.edu.umanizales.vehicle_rental.model;

public interface VehicleAble {
    public void rent();
    public void giveBack(int kmFinal);
    public double calculateRent(int km);

    void giveBack();

    public String showData();

}
