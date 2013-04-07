
public class XorGate extends Gate {
	
	/**
	 * Constructor for the XorGate, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public XorGate(){
		super();
		myIcon = "src/XORGate.png";
		setIcon();
	}
	
	/**
	 * Logic for the XorGate, if both inputs are on or both inputs
	 * are off then the output will be off otherwise the output will be
	 * on
	 */
	public boolean LogicOperation(){
		if(inputOne == true && inputTwo == true){
			return false;
		}
		else if(inputOne == false && inputTwo == false){
			return false;
		}
		else{
			return true;
		}
	}
}
