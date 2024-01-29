// Prototype interface
interface AnimalPrototype {
    AnimalPrototype clone();
}

// ConcretePrototype
class Dog implements AnimalPrototype {
    @Override
    public AnimalPrototype clone() {
        return new Dog();
    }

    @Override
    public String toString() {
        return "Dog";
    }
}

// ConcretePrototype
class Cat implements AnimalPrototype {
    @Override
    public AnimalPrototype clone() {
        return new Cat();
    }

    @Override
    public String toString() {
        return "Cat";
    }
}

// Client
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Create prototypes
        AnimalPrototype dogPrototype = new Dog();
        AnimalPrototype catPrototype = new Cat();

        // Client clones objects
        AnimalPrototype clonedDog = dogPrototype.clone();
        AnimalPrototype clonedCat = catPrototype.clone();

        // Use cloned objects
        System.out.println("Cloned Dog: " + clonedDog);
        System.out.println("Cloned Cat: " + clonedCat);
    }
}
