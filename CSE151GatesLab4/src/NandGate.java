import java.io.File;

import javax.swing.ImageIcon;

public class NandGate extends Gate {
	
	public NandGate(){
		super();
		myIcon = "src/NANDGate.png";
		setIcon();
	}
	
	public boolean LogicOperation(){
		if(inputOne == true && inputTwo == true){
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
