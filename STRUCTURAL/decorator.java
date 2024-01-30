// Component interface
interface Car {
    String getDescription();
    double getCost();
}

// Concrete Components
class BMW implements Car {
    @Override
    public String getDescription() {
        return "BMW Car";
    }

    @Override
    public double getCost() {
        return 50000.0;
    }
}

class Ferrari implements Car {
    @Override
    public String getDescription() {
        return "Ferrari Car";
    }

    @Override
    public double getCost() {
        return 100000.0;
    }
}

// Decorator
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCar.getCost();
    }
}

// Concrete Decorators
class SeatCoverDecorator extends CarDecorator {
    public SeatCoverDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Seat Cover";
    }

    @Override
    public double getCost() {
        return super.getCost() + 500.0;
    }
}

class FogLampDecorator extends CarDecorator {
    public FogLampDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Fog Lamps";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1000.0;
    }
}

class ACDecorator extends CarDecorator {
    public ACDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with AC";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2000.0;
    }
}

// Client Code
public class CarDecoratorExample {
    public static void main(String[] args) {
        // Base cars
        Car bmw = new BMW();
        Car ferrari = new Ferrari();

        // Decorated cars with additional features
        Car bmwWithSeatCover = new SeatCoverDecorator(bmw);
        Car ferrariWithFogLampAndAC = new ACDecorator(new FogLampDecorator(ferrari));

        // Display details
        System.out.println("BMW Details: " + bmw.getDescription() + ", Cost: $" + bmw.getCost());
        System.out.println("BMW with Seat Cover: " + bmwWithSeatCover.getDescription() + ", Cost: $" + bmwWithSeatCover.getCost());

        System.out.println("\nFerrari Details: " + ferrari.getDescription() + ", Cost: $" + ferrari.getCost());
        System.out.println("Ferrari with Fog Lamps and AC: " + ferrariWithFogLampAndAC.getDescription() + ", Cost: $" + ferrariWithFogLampAndAC.getCost());
    }
}
