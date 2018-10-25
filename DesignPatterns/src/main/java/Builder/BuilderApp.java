package Builder;

public class BuilderApp {
    public static void main(String[] args) {
        /*Car car = new CarBuilder()
                .buildBrand("KIA")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(180)
                .build();
        System.out.println(car);*/

        // В директоре просто устанавливаем нужный билдер и он сам соберет все.
        Director director = new Director();
        director.setBuilder(new FordMondeoBuilder());
        Car car = director.BuildCar();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String brand;
    Transmission transmission;
    int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand = " + brand + ", transmission = " + transmission + ", maxspeed = " + maxSpeed + "]";
    }
}

/*  -- УПРОЩЕННАЯ ВЕРСИЯ ШАБЛОНА

class CarBuilder {
    String brnd = "No name";
    Transmission trnsmssn = Transmission.MANUAL;
    int spd = 120;

    CarBuilder buildBrand(String brnd) {
        this.brnd = brnd;
        return this;
    }

    CarBuilder buildTransmission(Transmission trnsmssn) {
        this.trnsmssn = trnsmssn;
        return this;
    }

    CarBuilder buildMaxSpeed(int spd) {
        this.spd = spd;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setBrand(brnd);
        car.setTransmission(trnsmssn);
        car.setMaxSpeed(spd);
        return car;
    }
}*/


abstract class CarBuilder{
    Car car;
    void createCar() {
        car = new Car();
    }

    abstract void buildBrand();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();
    Car getCar() {
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder {
    void buildBrand() {
        car.setBrand("Ford Mondeo");
    }
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }
    void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }
}

class SubaruBuilder extends CarBuilder {
    void buildBrand() {
        car.setBrand("Subaru");
    }
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }
    void buildMaxSpeed() {
        car.setMaxSpeed(300);
    }
}

class Director {
    CarBuilder builder;
    void setBuilder(CarBuilder b) {builder = b;}

    Car BuildCar() {
        builder.createCar();
        builder.buildBrand();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }

}

