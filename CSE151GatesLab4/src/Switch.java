
public class Switch extends Gate{
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
		}
		else{
			myIcon = "src/SWITCHOFF.png";
		}
		setIcon();
	}

	public Switch(){
		myIcon = "src/SWITCHOFF.png";
		setIcon();
	}
}
