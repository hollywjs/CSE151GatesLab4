
public class NorGate extends Gate {
	
	/**
	 * Constructor for the NorGate, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public NorGate(){
		super();
		myIcon = "src/NORGate.png";
		setIcon();
	}
	
	/**
	 * Logic for the NorGate, if both of the inputs are false
	 * the the output will be on otherwise it will be off
	 */
	public boolean LogicOperation(){
		if(inputOne == false && inputTwo == false){
			return true;
		}
		else{
			return false;
		}
	}
}
