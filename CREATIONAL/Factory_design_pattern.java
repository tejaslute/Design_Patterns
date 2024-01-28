import java.lang.*;
import java.util.*;

interface Vehicle{
	void startEngine();
	void applyBreak();
}

class Bike implements Vehicle{
	
	Bike(){
		System.out.println("In Bike class ");
	}
	
	public void startEngine() {
		System.out.println("Starting a bike");
	}
	
	public void applyBreak() {
		System.out.println("Applying brake of bike");
	}
}
class Car implements Vehicle{
	
	Car(){
		System.out.println("In Car class ");
	}
	
	public void startEngine() {
		System.out.println("Starting a Car");
	}
	
	public void applyBreak() {
		System.out.println("Applying brake of Car");
	}
}
class Truck implements Vehicle{
	
	Truck(){
		System.out.println("In Truck class ");
	}
	
	public void startEngine() {
		System.out.println("Starting a Truck");
	}
	
	public void applyBreak() {
		System.out.println("Applying brake of Truck");
	}
}



class factoryClass{
	
	public static Vehicle create(String name) {
		if(name.equals("Bike")) {
			return new Bike();
		}else if(name.equals("Truck"))
		{
			return new Truck();
		}else {
		return new Car();
		}
	}
}
public class FactoryDesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter an name of vehicle ");
		Scanner sc= new Scanner(System.in);
		String x=sc.next();
		
		Vehicle v = factoryClass.create(x);
		v.applyBreak();
		v.startEngine();
		
		// Client gives an Vehicle type and factory class creates class for user input and gives .
		// User doesnt know how factory makes it ... this forms an loose coupling .
		// if in future we have to add train then we will only change an factpory class and create new class 
		// whiich implemnets an Vehicle called Train .
		
	}

}
