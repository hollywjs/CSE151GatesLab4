import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NotGate extends Gate{
	protected boolean input = false;
	protected boolean output = false;

	/**
	 * Constructor of the NotGate, sets the image and calls the
	 * setIcon method from the parent class, resizes image.
	 */
	public NotGate(){
		super();
		myIcon = "src/NOTGate.png";
		setIcon();
	}
	
	/**
	 * This is a copy constructor for the NotGate
	 * @param input
	 * @param output
	 * @param img
	 * @param lab
	 * @param myIcon
	 */
	public NotGate(boolean input, boolean output, ImageIcon img, JLabel lab, String myIcon){
		this.input = input;
		this.output = output;
		this.img = img;
		this.lab = lab;
		this.myIcon = myIcon;
	}
	
	/**
	 * Alternative style for a copy constructor, using a static newInstance
	 * method.
	 */
	public static Gate newInstance(Gate gate) {
		return new Gate(gate.isInputOne(),gate.isInputTwo(),gate.isOutput(),gate.getImg(),gate.getLab(),gate.getMyIcon());
	}
	
	/**
	 * This determines the logic of the NotGate, the NotGate returns the
	 * opposite of what it takes in
	 * @return a boolean
	 */
	public boolean LogicOperation(){
		return !inputOne;
	}

}

