import java.util.ArrayList;


public class Wire {

	private int startX, endX,startY,endY = 0;
	private Gate isStart, isEnd;
	private boolean isOn,isConnectedToOutput,isInputOne, isInputTwo = false;


	public boolean isInputTwo() {
		return isInputTwo;
	}

	public void setInputTwo(boolean isInputTwo) {
		this.isInputTwo = isInputTwo;
	}

	public boolean isInputOne() {
		return isInputOne;
	}

	public void setInputOne(boolean isInputOne) {
		this.isInputOne = isInputOne;
	}

	public boolean isConnectedToOutput() {
		return isConnectedToOutput;
	}

	public void setConnectedToOutput(boolean isConnectedToOutput) {
		this.isConnectedToOutput = isConnectedToOutput;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public Gate getIsStart() {
		return isStart;
	}

	public void setIsStart(Gate isStart) {
		this.isStart = isStart;
	}

	public Gate getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(Gate isEnd) {
		this.isEnd = isEnd;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}
	//determines if the startpoint of the wire is on a terminal of a gate.
	public boolean startInBounds(ArrayList<Gate> gates){
		for(int i = 0; i < gates.size(); i++){

			//else{
			if(startX <= (gates.get(i).getX() + 40) && startX >= (gates.get(i).getX())
					&& startY <= (gates.get(i).getY() + 80) && startY >= (gates.get(i).getY())){
				if(gates.get(i).toString().equals("NOTGate")){
					return oneInput(gates.get(i));
				}
				else if(gates.get(i).toString().contains("SWITCH") || gates.get(i).toString().contains("CLOCK") || 
						gates.get(i).toString().contains("LIGHT")){
					return otherItem(gates);
				}
				startX = gates.get(i).getX() + 4;
				startY = gates.get(i).getY() + 28;
				isInputOne = true;
				gates.get(i).setInputOne(true);
				gates.get(i).setUpperInputWire(this);
				isStart = gates.get(i);
				return true;
			}
			if(startX <= (gates.get(i).getX() + 40) && startX >= (gates.get(i).getX())
					&& startY <= (gates.get(i).getY() + 80) && startY >= (gates.get(i).getY())){
				if(gates.get(i).toString().equals("NOTGate")){
					return oneInput(gates.get(i));
				}
				else if(gates.get(i).toString().contains("SWITCH") || gates.get(i).toString().contains("CLOCK") || 
						gates.get(i).toString().contains("LIGHT")){
					return otherItem(gates);
				}
				startX = gates.get(i).getX() + 4;
				startY = gates.get(i).getY() + 50;
				isInputTwo = true;
				gates.get(i).setInputTwo(true);
				gates.get(i).setLowerInputWire(this);
				isStart = gates.get(i);
				return true;
			}
			if(startX <= (gates.get(i).getX() + 80) && startX >= (gates.get(i).getX() + 40)
					&& startY <= (gates.get(i).getY() + 80) && startY >= (gates.get(i).getY())){
				if(gates.get(i).toString().equals("NOTGate")){
					return oneInput(gates.get(i));
				}
				else if(gates.get(i).toString().contains("SWITCH") || gates.get(i).toString().contains("CLOCK") || 
						gates.get(i).toString().contains("LIGHT")){
					return otherItem(gates);
				}
				startX = gates.get(i).getX() + 80;
				startY = gates.get(i).getY() + 40;
				gates.get(i).setOutput(true);
				gates.get(i).setOutputWire(this);
				isConnectedToOutput = true;
				isStart = gates.get(i);
				return true;
			}
			//}
		}
		return false;
	}
	public boolean otherItem(ArrayList<Gate> gates){
		for(int i = 0; i < gates.size(); i++){
			if(gates.get(i).toString().contains("LIGHT")){
				if(startX <= (gates.get(i).getX() + 80) && startX >= (gates.get(i).getX())
						&& startY <= (gates.get(i).getY() + 80) && startY >= (gates.get(i).getY())){

					startX = gates.get(i).getX() + 4 ;
					startY = gates.get(i).getY() + 40;
					isStart = gates.get(i);
					gates.get(i).setOutput(true);
					gates.get(i).setOutputWire(this);
					return true;
				}
			}
			if(gates.get(i).toString().contains("SWITCH")){
				if(startX <= (gates.get(i).getX() + 80) && startX >= (gates.get(i).getX())
						&& startY <= (gates.get(i).getY() + 80) && startY >= (gates.get(i).getY())){

					startX = gates.get(i).getX() + 4 + 75;
					startY = gates.get(i).getY() + 40;
					isStart = gates.get(i);
					gates.get(i).setOutput(true);
					gates.get(i).setOutputWire(this);
					return true;
				}
			}
		}
		return false;
	}
	public boolean oneInput(Gate gate){

		if(startX <= (gate.getX() + 40) && startX >= (gate.getX())
				&& startY <= (gate.getY() + 80) && startY >= (gate.getY())){
			startX = gate.getX() + 4;
			startY = gate.getY() + 40;
			gate.setInputOne(true);
			isInputOne = true;
			isStart = gate;
			return true;
		}

		if(startX <= (gate.getX() + 80) && startX >= (gate.getX() + 40)
				&& startY <= (gate.getY() + 80) && startY >= (gate.getY())){
			startX = gate.getX() + 4 + 75;
			startY = gate.getY() + 40;
			isStart = gate;
			gate.setOutput(true);
			return true;
		}

		return false;
	}
	//determines if the end of the wire is on a terminal of a gate.
	public boolean endInBounds(ArrayList<Gate> gates){
		for(int i = 0; i < gates.size(); i++){

			if(endX <= (gates.get(i).getX() + 40) && endX >= (gates.get(i).getX())
					&& endY <= (gates.get(i).getY() + 40) && endY >= (gates.get(i).getY())){
				if(gates.get(i).toString().equals("NOTGate")){
					return oneInputEnd(gates);
				}
				if(gates.get(i).toString().contains("LIGHT")){
					return otherItemEnd(gates);
				}
				endX = gates.get(i).getX() + 4;
				endY = gates.get(i).getY() + 28;
				gates.get(i).setInputOne(true);
				isInputOne = true;
				gates.get(i).setUpperInputWire(this);
				isEnd = gates.get(i);
				return true;
			}
			if(endX <= (gates.get(i).getX() + 40) && endX >= (gates.get(i).getX())
					&& endY <= (gates.get(i).getY() + 80) && endY >= (gates.get(i).getY() + 40)){
				if(gates.get(i).toString().equals("NOTGate")){
					return oneInputEnd(gates);
				}
				if(gates.get(i).toString().contains("LIGHT")){
					return otherItemEnd(gates);
				}
				endX = gates.get(i).getX() + 4;
				endY = gates.get(i).getY() + 50;
				gates.get(i).setInputTwo(true);
				gates.get(i).setLowerInputWire(this);
				isInputTwo = true;
				isEnd = gates.get(i);
				return true;
			}
			if(endX <= (gates.get(i).getX() + 80) && endX >= (gates.get(i).getX() + 40)
					&& endY <= (gates.get(i).getY() + 80) && endY >= (gates.get(i).getY())){
				if(gates.get(i).toString().equals("NOTGate")){
					return oneInputEnd(gates);
				}
				if(gates.get(i).toString().contains("LIGHT")){
					return otherItemEnd(gates);
				}
				endX = gates.get(i).getX() + 80;
				endY = gates.get(i).getY() + 40;
				isInputOne = true;
				gates.get(i).setInputOne(true);
				gates.get(i).setOutputWire(this);
				isEnd = gates.get(i);
				return true;
			}
		}
		return false;
	}


	public boolean otherItemEnd(ArrayList<Gate> gates){
		for(int i = 0; i < gates.size(); i++){
			if(endX <= (gates.get(i).getX()  + 80) && endX >= (gates.get(i).getX())
					&& endY <= (gates.get(i).getY() + 80) && endY >= (gates.get(i).getY())){
				if(gates.get(i).toString().contains("LIGHT")){
					endX = gates.get(i).getX() + 4;
					endY = gates.get(i).getY() + 40;
					isEnd = gates.get(i);
				}
				return true;

			}
		}
		return false;
	}

	public boolean oneInputEnd(ArrayList<Gate> gates){
		for(int i = 0; i < gates.size(); i++){
			if(endX <= (gates.get(i).getX() + 80) && endX >= (gates.get(i).getX())
					&& endY <= (gates.get(i).getY() + 80) && endY >= (gates.get(i).getY())){
				endX = gates.get(i).getX() + 4;
				endY = gates.get(i).getY() + 40;
				gates.get(i).setOutput(true);
				isEnd = gates.get(i);
				isInputOne = true;
				return true;
			}

			if(endX <= (gates.get(i).getX() + 80) && endX >= (gates.get(i).getX())
					&& endY <= (gates.get(i).getY() + 80) && endY >= (gates.get(i).getY())){
				endX = gates.get(i).getX() + 4 + 75;
				endY = gates.get(i).getY() + 40;
				gates.get(i).setOutput(true);
				return true;
			}
		}
		return false;
	}

	public static void checkWires(ArrayList<Wire> wires){
		for(Wire w : wires){
			if(w.getIsStart().isOutput()){
				w.getIsStart().setOn(true);
			}
			else{
				w.getIsStart().setOn(false);
			}
		}
	}

}
