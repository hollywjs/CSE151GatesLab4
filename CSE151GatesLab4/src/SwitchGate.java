public class SwitchGate extends Gate{
	
	//Switch data
	private boolean isOn = false;

	/**
	 * Constructor of the Switch, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public SwitchGate(){
		inputOne = true;
		myIcon = "src/SWITCHOFF.png";
		setIcon();
	}
	
	/**
	 * This is used to return the boolean isOn
	 * @return used to set the boolean isOn
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * This is used to set the boolean isOn, using the parameter
	 * @param used to set the boolean isOn
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	/**
	 * This is used to change the switch boolean, if it is on
	 * it will be turned to off, if it is off it will be turned
	 * to on
	 */
	public void updateState(){
		if(isOn){
			myIcon = "src/SWITCHON.png";
			output = true;
		}
		else{
			myIcon = "src/SWITCHOFF.png";
			output = false;
		}
		setIcon();
	}
}
