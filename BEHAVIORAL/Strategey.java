// Strategy interface for driving behavior
interface DriveBehavior {
    void drive();
}

// Concrete strategy: SportDrive
class SportDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Driving in sport mode!");
    }
}

// Concrete strategy: MountainDrive
class MountainDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Driving on mountainous terrain!");
    }
}

// Concrete strategy: IceDrive
class IceDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Driving on icy roads!");
    }
}

// Concrete strategy: ManualDrive
class ManualDrive implements DriveBehavior {
    public void drive() {
        System.out.println("Manual driving experience!");
    }
}

// Context: Car
class Car {
    private DriveBehavior driveBehavior;

    // Setter method for dynamic behavior changes
    public void setDriveBehavior(DriveBehavior driveBehavior) {
        this.driveBehavior = driveBehavior;
    }

    // Delegated behavior method
    public void performDrive() {
        driveBehavior.drive();
    }
}

// Client code
public class StrategyPatternCarExample {
    public static void main(String[] args) {
        Car car = new Car();

        // Set SportDrive behavior
        car.setDriveBehavior(new SportDrive());
        car.performDrive();

        // Set MountainDrive behavior
        car.setDriveBehavior(new MountainDrive());
        car.performDrive();

        // Set IceDrive behavior
        car.setDriveBehavior(new IceDrive());
        car.performDrive();

        // Set ManualDrive behavior
        car.setDriveBehavior(new ManualDrive());
        car.performDrive();
    }
}
