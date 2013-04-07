import java.util.ArrayList;


public class Wire {

	//Wire data
	private int startX, endX,startY,endY = 0;
	private Gate isStart, isEnd;
	private boolean isOn,isConnectedToOutput,isInputOne, isInputTwo = false;

	/**
	 * This returns the boolean isInputTwo
	 * @return a boolean
	 */
	public boolean isInputTwo() {
		return isInputTwo;
	}

	/**
	 * This sets the boolean isInputTwo, using parameter
	 * @param isInputTwo
	 */
	public void setInputTwo(boolean isInputTwo) {
		this.isInputTwo = isInputTwo;
	}

	/**
	 * This returns the boolean isInputTwo
	 * @return a boolean
	 */
	public boolean isInputOne() {
		return isInputOne;
	}
	
	/**
	 * This sets the boolean isInputOne, using parameter
	 * @param isInputOne
	 */
	public void setInputOne(boolean isInputOne) {
		this.isInputOne = isInputOne;
	}

	/**
	 * This returns the boolean isConnectedToOutput
	 * @return a boolean
	 */
	public boolean isConnectedToOutput() {
		return isConnectedToOutput;
	}
	
	/**
	 * This sets the boolean isConnectedToOutput, using parameter
	 * @param isConnectedToOutput
	 */
	public void setConnectedToOutput(boolean isConnectedToOutput) {
		this.isConnectedToOutput = isConnectedToOutput;
	}
	
	/**
	 * This returns the boolean isOn
	 * @return a boolean
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * This sets the boolean isOn, using parameter
	 * @param isOn
	 */
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
	/**
	 * This returns the boolean isStart
	 * @return a boolean
	 */
	public Gate getIsStart() {
		return isStart;
	}

	/**
	 * This sets the boolean isStart, using parameter
	 * @param isStart
	 */
	public void setIsStart(Gate isStart) {
		this.isStart = isStart;
	}

	/**
	 * This returns the boolean isEnd
	 * @return a boolean
	 */
	public Gate getIsEnd() {
		return isEnd;
	}

	/**
	 * This sets the boolean isEnd, using parameter
	 * @param isEnd
	 */
	public void setIsEnd(Gate isEnd) {
		this.isEnd = isEnd;
	}

	/**
	 * This returns the int startX
	 * @return an int
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * This sets the boolean startX, using parameter
	 * @param startX
	 */
	public void setStartX(int startX) {
		this.startX = startX;
	}

	/**
	 * This returns the int endX
	 * @return an int
	 */
	public int getEndX() {
		return endX;
	}

	/**
	 * This sets the boolean endX, using parameter
	 * @param endX
	 */
	public void setEndX(int endX) {
		this.endX = endX;
	}

	/**
	 * This returns the int startY
	 * @return an int
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * This sets the boolean startY, using parameter
	 * @param startY
	 */
	public void setStartY(int startY) {
		this.startY = startY;
	}

	/**
	 * This returns the int endY
	 * @return an int
	 */ 
	public int getEndY() {
		return endY;
	}

	/**
	 * This sets the boolean endY, using parameter
	 * @param endY
	 */
	public void setEndY(int endY) {
		this.endY = endY;
	}
	
	/**
	 * Determines if the startpoint of the wire is on a terminal of a gate.
	 * @param gates takes in an array of gates
	 * @return a boolean
	 */
	//This method could use more commenting
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
	
	/**
	 * This is used to find the end point for an outpoint wire and
	 * connect it to a gate
	 * @param gates takes in a parameter of Gates
	 * @return a boolean
	 */
	 //This could use more commenting
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
	
	/**
	 * This is used to determine whether the boolean oneInput is on
	 * or off
	 * @param gate takes in the Gate the Wire is connected to
	 * @return a boolean
	 */
	 //This could use more commenting
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
	
	/**
	 * Determines if the end of the wire is on a terminal of a gate.
	 * @param gates takes in an array of Gates
	 * @return a boolean
	 */
	//This could use more commenting
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

	/**
	 * This finds the end of the wire
	 * @param gates, takes in an array of Gates
	 * @return a boolean
	 */
	//This could use better commenting
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

	/**
	 * This determines the boolean at the end of the Wire
	 * @param gates takes in an array of Gates
	 * @return a boolean
	 */
	//This could use better commenting
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

	/**
	 * This is used to check the boolean of the Gate at the start, 
	 * and set the boolean of the Gate at the end
	 * @param wires takes in an array of Wires
	 */
	//This could use better commenting
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
