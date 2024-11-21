package co.edu.umanizales.vehicle_rental.dto;

public class FilterDTO {
    private String type;
    private String color;
    private int countOne;
    private int countTwo;
    private int countThree;

    public FilterDTO(String type, int countOne) {
        this.type = type;
        this.color = color;
        this.countOne = countOne;
        this.countTwo = countTwo;
        this.countThree = countThree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCountOne() {
        return countOne;
    }

    public void setCountOne(int countOne) {
        this.countOne = countOne;
    }

    public int getCountTwo() {
        return countTwo;
    }

    public void setCountTwo(int countTwo) {
        this.countTwo = countTwo;
    }

    public int getCountThree() {
        return countThree;
    }

    public void setCountThree(int countThree) {
        this.countThree = countThree;
    }
}
