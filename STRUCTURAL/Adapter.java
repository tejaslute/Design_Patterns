import java.util.*;
import java.lang.*;

class oldSystem{
	public void securitySystem() {
		System.out.println("Old security is being used ");
	}
}

interface newSystemInterface{
	public void securitySystem();
}


class newSystem implements newSystemInterface{
	
	private oldSystem oldS;
	
	newSystem(oldSystem oldS){
		this.oldS=oldS;
	}
	
	@Override
	public void securitySystem() {
		oldS.securitySystem();
	}
	
}
public class Adapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		oldSystem old = new oldSystem();
		newSystem newS= new newSystem(old);
		newS.securitySystem();
	}

}
