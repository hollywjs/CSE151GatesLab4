
import java.io.File;

import javax.swing.ImageIcon;

public class NorGate extends Gate {
	
	public NorGate(){
		super();
		myIcon = "src/NORGate.png";
		setIcon();
	}
	
	public boolean LogicOperation(){
		if(inputOne == false && inputTwo == false){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setIcon(){
		img = resizeIcon(new File(myIcon));
	}
}
