import java.io.File;

public class AndGate extends Gate{
	private boolean switch1;
	private boolean switch2;
	private boolean output;
	
	public AndGate(){
		super();
		myIcon = "src/ANDGate.png";
		setIcon();
	}
	
	public boolean LogicOperation(){
		System.out.println("1: " + inputOne + ", 2: " + inputTwo);
		if(inputOne == true && inputTwo == true){
			return true;
		}
		return false;
	}
	
	public void setIcon(){
			img = resizeIcon(new File(myIcon));
	}
	
	public void setSwitch1(boolean input){
		switch1 = input;
	}
	
	public void setSwitch2(boolean input){
		switch2 = input;
	}
	
	public boolean getOutput(){
		if(switch1 == false || switch2 == false){
			return false;
		}
		else {
			return true;
		}
		
	}
}
