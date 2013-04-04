public class Light extends Gate{
	private boolean isOn = false;
	
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean on) {
		isOn = on;
	}
	
	public Light(){
		myIcon = "src/LIGHTOFF.png";
		setIcon();
	}
	
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