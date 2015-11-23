
public class Inheritance {

	public static void main(String[] args){
		
		A a1 = new B();
		a1.get();
		((B)a1).get();		
	}
	
}

class A {
	

	void get(){
		float c = 10/2;
		System.out.println("Inside A");
	}
	
}

class B extends A{
	

	void get(){
		double c =  (33454%844);
		System.out.println("Inside B "+c);
	}
	
}
