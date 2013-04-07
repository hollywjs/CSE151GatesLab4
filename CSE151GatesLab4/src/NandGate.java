
public class NandGate extends Gate {
	
	/**
	 * Constructor of the NandGate, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public NandGate(){
		super();
		myIcon = "src/NANDGate.png";
		setIcon();
	}
	
	/**
	 * Logic for the NandGate, if both inputs are on the gate
	 * is off otherwise it is on
	 */
	public boolean LogicOperation(){
		if(inputOne == true && inputTwo == true){
			return false;
		}
		else{
			return true;
		}
	}
}
