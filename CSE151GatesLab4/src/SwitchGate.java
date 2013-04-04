public class SwitchGate extends Gate{
	private boolean isOn = false;

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

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

	public SwitchGate(){
		inputOne = true;
		myIcon = "src/SWITCHOFF.png";
		setIcon();
	}
}
