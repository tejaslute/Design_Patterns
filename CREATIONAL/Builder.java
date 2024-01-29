// Product class
class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    // Constructor, getters, setters...
}

// Builder interface
interface HouseBuilder {
    HouseBuilder buildFoundation(String foundation);
    HouseBuilder buildStructure(String structure);
    HouseBuilder buildRoof(String roof);
    HouseBuilder buildInterior(String interior);
    House build();
}

// Concrete Builder
class ConcreteHouseBuilder implements HouseBuilder {
    private House house = new House();

    public HouseBuilder buildFoundation(String foundation) {
        house.setFoundation(foundation);
        return this;
    }

    public HouseBuilder buildStructure(String structure) {
        house.setStructure(structure);
        return this;
    }

    public HouseBuilder buildRoof(String roof) {
        house.setRoof(roof);
        return this;
    }

    public HouseBuilder buildInterior(String interior) {
        house.setInterior(interior);
        return this;
    }

    public House build() {
        return house;
    }
}

// Director
class HouseDirector {
    public House constructLuxuryHouse(HouseBuilder builder) {
        return builder
            .buildFoundation("Luxury Foundation")
            .buildStructure("Luxury Structure")
            .buildRoof("Luxury Roof")
            .buildInterior("Luxury Interior")
            .build();
    }

    public House constructSimpleHouse(HouseBuilder builder) {
        return builder
            .buildFoundation("Simple Foundation")
            .buildStructure("Simple Structure")
            .buildRoof("Simple Roof")
            .buildInterior("Simple Interior")
            .build();
    }
}

// Client
public class BuilderPatternExample {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        HouseDirector director = new HouseDirector();

        // Construct a luxury house
        House luxuryHouse = director.constructLuxuryHouse(builder);

        // Construct a simple house
        House simpleHouse = director.constructSimpleHouse(builder);

        // Use the constructed houses...
    }
}
