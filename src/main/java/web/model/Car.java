package web.model;

public class Car {
    private String brand;
    private String model;
    private Integer year;

    // Конструкторы
    public Car() {}

    public Car(String brand, String model, Integer year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Геттеры и сеттеры
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", brand, model, year);
    }
}