
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Gate {
	
	//Gate data
	protected boolean inputOne;
	protected boolean inputTwo;
	protected boolean output = false;
	protected ImageIcon img = new ImageIcon();
	protected JLabel lab = new JLabel();
	protected String myIcon = null;
	protected int x,y = 0;
	public static final int IN_UPPERY = 46,IN_LOWERY = 64,OUTPUTY = 64,
				IN_UPPERX = 6,IN_LOWERX = 6,OUTPUTX = 122;
	private Wire upperInputWire;
	private Wire lowerInputWire;
	private Wire outputWire;
	private boolean isOn = false;
	
	/**
	 * This will be implemented in children classes
	 */
	public Gate(){
		//setIcon();
	}
	
	/**
	 * This will construct a Gate with 2 inputs and 1 output
	 * @param inputOne this is a boolean input
	 * @param inputTwo this is a boolean input
	 * @param output this is a boolean output
	 * @param img this is the image of the icon
	 * @param lab this is the JLable the image sits on
	 * @param myIcon this is the String address of the image
	 */
	public Gate(boolean inputOne, boolean inputTwo, boolean output, ImageIcon img, JLabel lab, String myIcon){
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
		this.output = output;
		this.img = img;
		this.lab = lab;
		this.myIcon = myIcon;
	}

	/**
	 * This is another Gate constructor
	 * @param inputOne used for the upper input
	 * @param inputTwo used for the lower input
	 * @param output used for the output
	 */
	public Gate(boolean inputOne, boolean inputTwo, boolean output){
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
		this.output = output;
	}
	
	/**
	 * Alternative style for a copy constructor, using a static newInstance
	 * method.
	 */
	public static Gate newInstance(Gate gate) {
		return new Gate(gate.isInputOne(),gate.isInputTwo(),gate.isOutput(),gate.getImg(),gate.getLab(),gate.getMyIcon());
	}
	
	/**
	 * This will be implemented in the Switch child classes
	 */
	public void flipSwitch(){
		
	}
	
	/**
	 * This will be implemented in the Switch child class
	 * @return isON which is a boolean of whether the switch
	 * is on or not
	 */
	public boolean isOn() {
		//only for switch
		return isOn;
	}
	
	/**
	 * This will be implemented in the Switch child class
	 * @param isOn takes in a boolean
	 */
	public void setOn(boolean isOn) {
		//only for switch
	}

	/**
	 * This will be implemented in the Switch child class
	 */
	public void updateState(){
		//only for switch
	}
	
		
	/**
	 * This will check the bounds of the window to make sure the
	 * Gate is being drawn only in areas allowed.
	 * @param x takes in the x location of where the Gate is being
	 * dropped
	 * @param y takes in the y location of where the Gate is being
	 * dropped
	 * @return a boolean of whether the Gate is in bounds or not
	 */
	public static boolean checkBounds(int x, int y){
		if(x < SystemGUI.WINDOW_X - 100 && x > 170  && y < SystemGUI.WINDOW_Y - 125 - 40 && y > 0){
			return true;
		}
		return false;
	}
	
	//I am not sure if this is different from the function above
	public boolean isInBounds(int x, int y){
		if(x >= this.x && y >= this.y && x < this.x + 82 && y < this.y + 82)
		{
			return true;
		}
		return false;
	}

	/**
	 * This will return the upper Wire that is attached to the Gate
	 * @return a Wire
	 */
	public Wire getUpperInputWire() {
		return upperInputWire;
	}

	/**
	 * This will set the upper Wire that is attached to the Gate
	 * @param upperInputWire sets the Gate's upper Wire to the Wire
	 * parameter
	 */
	public void setUpperInputWire(Wire upperInputWire) {
		this.upperInputWire = upperInputWire;
	}

	/**
	 * This will return the lower Wire that is attached to the Gate
	 * @return a Wire
	 */
	public Wire getLowerInputWire() {
		return lowerInputWire;
	}

	/**
	 * This will set the upper Wire that is attached to the Gate
	 * @param lowerInputWire sets the Gate's lower Wire to the Wire
	 * parameter
	 */
	public void setLowerInputWire(Wire lowerInputWire) {
		this.lowerInputWire = lowerInputWire;
	}

	/**
	 * This will return the output Wire that is attached to the Gate
	 * @return a Wire
	 */
	public Wire getOutputWire() {
		return outputWire;
	}

	/**
	 * This will set the output Wire that is attached to the Gate
	 * @param outputWire sets the Gate's output Wire to the Wire
	 * parameter
	 */
	public void setOutputWire(Wire outputWire) {
		this.outputWire = outputWire;
	}

	/**
	 * This returns the X location of the Gate
	 * @return integer, the X location
	 */
	public int getX() {
		return x;
	}

	/**
	 * This sets the X location of the Gate
	 * @param x sets the integer X location 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * This returns the Y location of the Gate
	 * @return integer, the Y location
	 */
	public int getY() {
		return y;
	}

	/**
	 * This sets the Y location of the Gate
	 * @param y sets the integer Y location
 	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * This returns the boolean of the upper input to the Gate
	 * @return a boolean, the upper input
	 */
	public boolean isInputOne() {
		return inputOne;
	}

	/**
	 * This sets the boolean of the upper input to the Gate
	 * @param inputOne used to set the upper input to the Gate
	 */
	public void setInputOne(boolean inputOne) {
		this.inputOne = inputOne;
	}

	/**
	 * This returns the boolean of the lower input to the Gate
	 * @return a boolean, the lower input
	 */
	public boolean isInputTwo() {
		return inputTwo;
	}

	/**
	 * This sets the boolean of the lower input to the Gate
	 * @param inputTwo used to set the lower input to the Gate
	 */
	public void setInputTwo(boolean inputTwo) {
		this.inputTwo = inputTwo;
	}

	/**
	 * This returns the boolean of the output to the Gate
	 * @return a boolean, the output
	 */
	public boolean isOutput() {
		return output;
	}

	/**
	 * This sets the boolean of the output to the Gate
	 * @param output used to set the output to the Gate
	 */
	public void setOutput(boolean output) {
		this.output = output;
	}

	/**
	 * This returns the Image Icon of the particular Gate
	 * @return an Image Icon
	 */
	public ImageIcon getImg() {
		return img;
	}

	/**
	 * This sets the Image Icon of the particular Gate
	 * @param img, used to set the Image Icon of the Gate
	 */
	public void setImg(ImageIcon img) {
		this.img = img;
	}

	/**
	 * This returns the String location of the Gate Image
	 * @return the Strin location of the Gate
	 */
	public String getMyIcon() {
		return myIcon;
	}

	/**
	 * This sets the String location of the Gate Image
	 * @param myIcon, used ot set the String location of the Gate Image
	 */
	public void setMyIcon(String myIcon) {
		this.myIcon = myIcon;
	}

	//I am not sure that this is different from the getImg() method
	public ImageIcon getIcon(){
		return this.img;
	}

	/**
	 * This will return the JLabel the Gate is placed on
	 * @return the JLabel
	 */
	public JLabel getLab() {
		return lab;
	}

	/**
	 * This will set the JLabel the Gate will be place on
	 * @param lab, used to set the JLabel
	 */
	public void setLab(JLabel lab) {
		this.lab = lab;
	}
	
	/**
	 * This is used to call the resize method if myIcon is not null
	 */
	public void setIcon(){
		if(myIcon != null){
			img = resizeIcon(new File(myIcon));
		}
	}

	/**
	 * Method to resize an image and return it as an imageIcon. See detailed comments below.
	 */
	public static ImageIcon resizeIcon(File src){
		int newHeight = 80, newWidth = 80;        // Variables for the new height and width
		int priorHeight = 0, priorWidth = 0;
		BufferedImage image = null;
		ImageIcon sizeImage; 					// Need to return an imageIcon for JLabel

		try {
			image = ImageIO.read(src);        // read the image
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Image could not be found!");
		}
		//set icon to image
		sizeImage = new ImageIcon(image);
		//set old dimensions
		if(sizeImage != null)
		{
			priorHeight = sizeImage.getIconHeight(); 
			priorWidth = sizeImage.getIconWidth();
		}

		//Create a new Buffered Image and Graphic2D object
		//Notice I am using ABGR and not RGB, alpha channel must be used for transparency
		BufferedImage resizedImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2 = resizedImg.createGraphics();

		//This was to rotate the image of wire 45 degrees(method takes radians so 45 * pi/180 = .785
		//It works just fine but the layout manager is clipping it and only half is showing. We can fix later or throw it out. Not a big priority issue obviously
		if(src.toString().contains("WIRE")){
			//g2.rotate(.785, 10, 0);
		}
		//Use the Graphic object to draw a new image to the image in the buffer
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(image, 0, 0, newWidth, newHeight, null);
		//need to dispose after creating Graphics instance
		g2.dispose();

		// Convert the buffered image into an ImageIcon for return
		return (new ImageIcon(resizedImg));
	}
	
	/**
	 * This will be implemented in the children classes
	 * @return a boolean
	 */
	public boolean LogicOperation(){
		return true;
	}
	
	/**
	 * Not what this does right now
	 * Uses substring to just return the name of the gate(i.e. src/ANDGate.png will return the string: ANDGate
	 */
	public String toString(){
		String sub = myIcon.substring(myIcon.indexOf('/') + 1, myIcon.length() - 4);
		return sub;
	}

}
