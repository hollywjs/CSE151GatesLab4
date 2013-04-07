public class Light extends Gate{
	
	//Light data
	private boolean isOn = false;
	
	/**
	 * Returns the boolean, of whether or not it is on
	 * @return a boolean
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * This is used to construct a Light, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public Light(){
		myIcon = "src/LIGHTOFF.png";
		setIcon();
	}
	
	/**
	 * Sets the boolean is on
	 * @param used to set the boolean isOn
	 */
	public void setOn(boolean on) {
		isOn = on;
	}
	
	/**
	 * This is used to change the Light Image from off to 
	 * on and from on to off
	 */
	public void flipSwitch(){
		if(isOn){
			myIcon = "src/LIGHTON.png";
			setIcon();
		}
		else{
			myIcon = "src/LIGHTOFF.png";
			setIcon();
		}
	}
}