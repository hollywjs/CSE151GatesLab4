

public class AndGate extends Gate{
	
	/**
	 * Constructor of the AndGate, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public AndGate(){
		super();
		myIcon = "src/ANDGate.png";
		setIcon();
	}
	
	/**
	 * Logic for the AndGate, if both inputs are on then the
	 * output will be on
	 */
	public boolean LogicOperation(){
		System.out.println("1: " + inputOne + ", 2: " + inputTwo);
		if(inputOne == true && inputTwo == true){
			return true;
		}
		return false;
	}
	
	
	
	
	
}
