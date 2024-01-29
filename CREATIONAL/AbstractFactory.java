// Furniture interface
interface Furniture {
    void make();
}

// Concrete Product Classes
class OfficeChair implements Furniture {
    OfficeChair() {
        System.out.println("Creating an Office Chair");
    }

    public void make() {
        System.out.println("Office chair made");
    }
}

class SimpleChair implements Furniture {
    SimpleChair() {
        System.out.println("Creating a Simple Chair");
    }

    public void make() {
        System.out.println("Simple chair made");
    }
}

class OfficeSofa implements Furniture {
    OfficeSofa() {
        System.out.println("Creating an Office Sofa");
    }

    public void make() {
        System.out.println("Office sofa made");
    }
}

class SimpleSofa implements Furniture {
    SimpleSofa() {
        System.out.println("Creating a Simple Sofa");
    }

    public void make() {
        System.out.println("Simple sofa made");
    }
}

// Abstract Factory Interfaces
interface ChairFactory {
    Furniture createChair();
}

interface SofaFactory {
    Furniture createSofa();
}

// Concrete Factory Classes
class ModernChairFactory implements ChairFactory {
    public Furniture createChair() {
        return new OfficeChair();
    }
}

class SimpleChairFactory implements ChairFactory {
    public Furniture createChair() {
        return new SimpleChair();
    }
}

class ModernSofaFactory implements SofaFactory {
    public Furniture createSofa() {
        return new OfficeSofa();
    }
}

class SimpleSofaFactory implements SofaFactory {
    public Furniture createSofa() {
        return new SimpleSofa();
    }
}

// Client Code
public class FurnitureClient {

    public static void main(String[] args) {
        // Client code using the abstract factories

        // Create modern furniture
        ChairFactory modernChairFactory = new ModernChairFactory();
        SofaFactory modernSofaFactory = new ModernSofaFactory();

        // Create modern chair and sofa
        Furniture modernChair = modernChairFactory.createChair();
        Furniture modernSofa = modernSofaFactory.createSofa();

        // Create simple furniture
        ChairFactory simpleChairFactory = new SimpleChairFactory();
        SofaFactory simpleSofaFactory = new SimpleSofaFactory();

        // Create simple chair and sofa
        Furniture simpleChair = simpleChairFactory.createChair();
        Furniture simpleSofa = simpleSofaFactory.createSofa();
    }
}
