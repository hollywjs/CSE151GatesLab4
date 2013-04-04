import java.io.File;

import javax.swing.ImageIcon;

public class XorGate extends Gate {
	
	public XorGate(){
		super();
		myIcon = "src/XORGate.png";
		setIcon();
	}
	
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
	
	public void setIcon(){
		img = resizeIcon(new File(myIcon));
	}
}
