import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

interface Subject {
    List<Observer> observers = new ArrayList<>();

    void add(Observer o);

    void remove(Observer o);

    void notifyObservers();
}

class ConcreteSubject implements Subject {
    public void add(Observer o) {
        observers.add(o);
    }

    public void remove(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ObserverConcrete implements Observer {
    public void update() {
        System.out.println("ObserverConcrete has been updated.");
    }
}

public class ObserverPattern {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ObserverConcrete observer = new ObserverConcrete();

        subject.add(observer);
        subject.notifyObservers();
    }
}
