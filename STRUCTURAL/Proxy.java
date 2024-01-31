// Subject interface
interface RealSubject {
    void request();
}

// RealSubject class
class RealSubjectImpl implements RealSubject {
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

// Proxy class
class Proxy implements RealSubject {
    private RealSubject realSubject;

    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubjectImpl();
        }
        // Additional logic can be added here before or after forwarding the request to the real object.
        realSubject.request();
    }
}

// Client code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

