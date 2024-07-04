class Vehicle {
    String brand;
    int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}
class Car extends Vehicle {

    Car(String brand, int year) {
        super(brand, year); 
    }
}
public class a1{
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2023);

        System.out.println("Car brand: " + myCar.brand);
        System.out.println("Car year: " + myCar.year);

    }
}
