
public class OrGate extends Gate {
	
	/**
	 * Constructor of the OrGate, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public OrGate(){
		super();
		myIcon = "src/ORGate.png";
		setIcon();
	}
	
	/**
	 * Logic for the OrGate, if either of the  inputs are on then the
	 * output will be on
	 */
	public boolean LogicOperation(){
		if(inputOne == true || inputTwo == true || (inputOne == true && inputTwo == true)){
			return true;
		}
		return false;
	}
}
