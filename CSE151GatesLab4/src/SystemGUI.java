import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class SystemGUI extends JFrame implements ActionListener{
	
	//Declare the buttons for the form
	private JButton wireButton, scissorsButton, runButton, andGateButton, orGateButton, notGateButton, switchButton, clockButton,
								nandGateButton, norGateButton, xorGateButton, lightButton, terminalButton;
	
	//Declare the Labels for the Gates
	private JLabel andGateLabel  = new JLabel(ImageHelper.resizeIcon(new File("src/ANDGate.png")));
	private JLabel orGateLabel   = new JLabel(ImageHelper.resizeIcon(new File("src/ORGate.png")));
	private JLabel notGateLabel  = new JLabel(ImageHelper.resizeIcon(new File("src/NOTGate.png")));
	private JLabel switchLabel   = new JLabel(ImageHelper.resizeIcon(new File("src/SWITCHOFF.png")));
	private JLabel clockLabel    = new JLabel(ImageHelper.resizeIcon(new File("src/CLOCKSpeed1.png")));
	private JLabel nandGateLabel = new JLabel(ImageHelper.resizeIcon(new File("src/NANDGate.png")));
	private JLabel norGateLabel  = new JLabel(ImageHelper.resizeIcon(new File("src/NORGate.png")));
	private JLabel xorGateLabel  = new JLabel(ImageHelper.resizeIcon(new File("src/XORGate.png")));
	private JLabel lightLabel    = new JLabel(ImageHelper.resizeIcon(new File("src/LIGHTOFF.png")));
	private JLabel terminalLabel = new JLabel(ImageHelper.resizeIcon(new File("src/TERMINAL.png")));
	
	//Declare the listeners
	private Insets insets 					 = getInsets();
	private MyMouseListener dragListener 	 = new MyMouseListener();
	private MouseClickListener clickListener = new MouseClickListener();
	
	//Declare the arrays
	private ArrayList<Gate> gates 			 = new ArrayList<Gate>();
	//private ArrayList<SwitchGate> switches   = new ArrayList<SwitchGate>();
	private ArrayList<Wire> wires 			 = new ArrayList<Wire>();
	
	private boolean makeGate 				 = false;
	private int gateChosen 					 = 1;
	private Dimension iconDim 				 = new Dimension(BUTTON_SIZE, BUTTON_SIZE);
	private int currWire 					 = -1;
	private BufferedImage bi;
	private boolean isRunning, drawWire, isDrawing, cutOn = false;
	public static final int BUTTON_SIZE = 82, WINDOW_X = 800, WINDOW_Y = 540,AND_GATE = 0, OR_GATE = 1, NOT_GATE = 2,  SWITCH = 3, CLOCK = 4, 
							  NAND_GATE = 5,  NOR_GATE = 6,XOR_GATE = 7,    LIGHT = 8,TERMINAL = 9;
	
	/**
	 * Creates the buttons for the bottom panel
	 */
	public void makeOptions(){
		wireButton     = new JButton(ImageHelper.resizeIcon(new File("src/WIRE.png")));	
		scissorsButton = new JButton(ImageHelper.resizeIcon(new File("src/SCISSORS.png")));
		runButton      = new JButton(ImageHelper.resizeIcon(new File("src/RUN.png")));
		
		wireButton.setPreferredSize(iconDim);
		wireButton.setActionCommand("wire");
		wireButton.addActionListener(this);
		
		scissorsButton.setPreferredSize(iconDim);
		scissorsButton.setActionCommand("scissors");
		scissorsButton.addActionListener(this);
		
		runButton.setPreferredSize(iconDim);
		runButton.setActionCommand("run");
		runButton.addActionListener(this);
	}
	
	/**
	 * Creates the position for the bottom panel
	 */
	public void positionOptions(){
		wireButton.setBounds((BUTTON_SIZE + 5) + insets.left, (500 + insets.bottom) - iconDim.height,iconDim.width,iconDim.height);
		scissorsButton.setBounds((BUTTON_SIZE*2 + 5) + insets.left, (500 + insets.bottom) - iconDim.height,iconDim.width,iconDim.height);
		runButton.setBounds((BUTTON_SIZE*3 + 5) + insets.left, (500 + insets.bottom) - iconDim.height,iconDim.width,iconDim.height);
	}
	
	/** 
	 * Creates the Gates
	 */
	public void makeGates(){
		
		andGateButton = new JButton(ImageHelper.resizeIcon(new File("src/AndGate.png")));
		andGateButton.setActionCommand("andgate");
		andGateLabel.setPreferredSize(iconDim);
		andGateButton.addActionListener(this);
		andGateButton.setPreferredSize(iconDim);
		
		orGateButton = new JButton(ImageHelper.resizeIcon(new File("src/ORGate.png")));
		orGateButton.setPreferredSize(iconDim);
		orGateButton.setActionCommand("orgate");
		orGateButton.addActionListener(this);
		orGateLabel.setPreferredSize(iconDim);
		
		notGateButton = new JButton(ImageHelper.resizeIcon(new File("src/NOTGate.png")));
		notGateButton.setPreferredSize(iconDim);
		notGateButton.setActionCommand("notgate");
		notGateButton.addActionListener(this);
		notGateLabel.setPreferredSize(iconDim);
		
		switchButton = new JButton(ImageHelper.resizeIcon(new File("src/SWITCHOFF.png")));
		switchButton.setPreferredSize(iconDim);
		switchButton.setActionCommand("switch");
		switchButton.addActionListener(this);
		switchLabel.setPreferredSize(iconDim);
		
		clockButton = new JButton(ImageHelper.resizeIcon(new File("src/CLOCKSpeed1.png")));
		clockButton.setPreferredSize(iconDim);
		clockButton.setActionCommand("clock");
		clockButton.addActionListener(this);
		clockLabel.setPreferredSize(iconDim);
		
		nandGateButton = new JButton(ImageHelper.resizeIcon(new File("src/NANDGate.png")));
		nandGateButton.setPreferredSize(iconDim);
		nandGateButton.setActionCommand("nandgate");
		nandGateButton.addActionListener(this);
		nandGateLabel.setPreferredSize(iconDim);
		
		norGateButton = new JButton(ImageHelper.resizeIcon(new File("src/NORGate.png")));
		norGateButton.setPreferredSize(iconDim);
		norGateButton.setActionCommand("norgate");
		norGateButton.addActionListener(this);
		norGateLabel.setPreferredSize(iconDim);
		
		xorGateButton = new JButton(ImageHelper.resizeIcon(new File("src/XORGate.png")));
		xorGateButton.setPreferredSize(iconDim);
		xorGateButton.setActionCommand("xorgate");
		xorGateButton.addActionListener(this);
		xorGateLabel.setPreferredSize(iconDim);
		
		lightButton = new JButton(ImageHelper.resizeIcon(new File("src/LIGHTOFF.png")));
		lightButton.setPreferredSize(iconDim);
		lightButton.setActionCommand("light");
		lightButton.addActionListener(this);
		lightLabel.setPreferredSize(iconDim);
		
		terminalButton = new JButton(ImageHelper.resizeIcon(new File("src/TERMINAL.png")));
		terminalButton.setPreferredSize(iconDim);
		terminalButton.setActionCommand("terminal");
		terminalButton.addActionListener(this);
		terminalLabel.setPreferredSize(iconDim);
		
		Dimension size = iconDim;
		andGateLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		orGateLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		notGateLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		switchLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		clockLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		nandGateLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		norGateLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		xorGateLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		lightLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
		terminalLabel.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,size.width,size.height);
	}
	
	/**
	 * Positions the Gates on the left panel
	 */
	public void positionGates(){
		andGateButton.setBounds(5 + insets.left, 5 + insets.top,iconDim.width,iconDim.height);
		orGateButton.setBounds(5 + insets.left, (5 + BUTTON_SIZE) + insets.top,iconDim.width,iconDim.height);
		notGateButton.setBounds(5 + insets.left, (5 + BUTTON_SIZE*2) + insets.top,iconDim.width,iconDim.height);
		switchButton.setBounds(5 + insets.left, (5 + BUTTON_SIZE*3) + insets.top,iconDim.width,iconDim.height);
		clockButton.setBounds(5 + insets.left, (5 + BUTTON_SIZE*4) + insets.top,iconDim.width,iconDim.height);
		nandGateButton.setBounds((5 + insets.left + BUTTON_SIZE), 5  + insets.top,iconDim.width,iconDim.height);
		norGateButton.setBounds(5 + insets.left + BUTTON_SIZE, (5 + BUTTON_SIZE) + insets.top,iconDim.width,iconDim.height);
		xorGateButton.setBounds(5 + insets.left + BUTTON_SIZE, (5 + BUTTON_SIZE*2) + insets.top,iconDim.width,iconDim.height);
		lightButton.setBounds(5 + insets.left + BUTTON_SIZE, (5 + BUTTON_SIZE*3) + insets.top,iconDim.width,iconDim.height);
		terminalButton.setBounds(5 + insets.left + BUTTON_SIZE, (5 + BUTTON_SIZE*4) + insets.top,iconDim.width,iconDim.height);
	}
	
	
	/**
	 * Overrides the paint method
	 */
	public void paint(Graphics g){
			bi = new BufferedImage( this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_ARGB);
			draw(bi.getGraphics());
			g.drawImage(bi, 0, 0, null);
	}
	
	/**
	 * Used to draw the gates
	 * @param g
	 */
	public void draw(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        for(Gate gate : gates){
        	g.drawImage(gate.getIcon().getImage(), gate.getX(), gate.getY(), this);
        }
        
        if(isRunning){
        	checkLogic();
        	Wire.checkWires(wires);
        	for(Gate gate : gates){
            	g.drawImage(gate.getIcon().getImage(), gate.getX(), gate.getY(), this);
            }
        	for(Wire w : wires){
        		if(!w.isOn()){
        			g.setColor(Color.black);
        			g.drawLine(w.getStartX() + 1, w.getStartY(), w.getEndX() - 5, w.getEndY());
        		}
        		else{
        			g.setColor(Color.green);
        			g.drawLine(w.getStartX() + 1, w.getStartY(), w.getEndX() - 5, w.getEndY());
        		}
        	}
        }
        else{
        	for(Wire w : wires){
        		g.setColor(Color.black);
				g.drawLine(w.getStartX() + 1, w.getStartY(), w.getEndX() - 5, w.getEndY());
        	}
        }
    }

	/**
	 * Adds the buttons to the form
	 */
	public SystemGUI(){
		super("CSE151 Gates Lab");
		setLayout(null);
		makeGates();
		makeOptions();
		add(wireButton);
		add(scissorsButton);
		add(runButton);
		add(andGateButton);
		add(orGateButton);
		add(notGateButton);
		add(switchButton);
		add(clockButton);
		add(nandGateButton);
		add(norGateButton);
		add(xorGateButton);
		add(lightButton);
		add(terminalButton);
		positionGates();
		positionOptions();
		addMouseMotionListener(dragListener);
		addMouseListener(clickListener);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WINDOW_X,WINDOW_Y);
		setVisible(true);
	}

	/**
	 * Starts the system
	 * @param args
	 */
	public static void main(String args[]){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SystemGUI();
			}
		});
	}
	
	/**
	 * Used to check the logic of the gates
	 */
	public void checkLogic(){
		for(Wire w : wires){
			//w.getIsStart().LogicOperation();
			if(w.getIsStart().isOutput()){
				w.setOn(true);
				if(w.isInputOne()){
					w.getIsEnd().setInputOne(true);
				}
				if(w.isInputTwo()){
					w.getIsEnd().setInputTwo(true);
				}
			}
			else{
				w.setOn(false);
				if(w.isInputOne()){
					w.getIsEnd().setInputOne(false);
				}
				if(w.isInputTwo()){
					w.getIsEnd().setInputTwo(false);
				}
			}
			if(w.getIsStart().toString().equals("SWITCHON")){
				w.getIsStart().setOutput(true);
			}
			else if(w.getIsStart().toString().equals("SWITCHOFF")){
				w.getIsStart().setOutput(false);
			}
			if(!w.getIsStart().toString().contains("SWITCH") && w.getIsStart().LogicOperation()){
				w.getIsStart().setOutput(true);
			}
			if(!w.getIsStart().toString().contains("SWITCH") && !w.getIsStart().LogicOperation()){
				w.getIsStart().setOutput(false);
			}
			if(w.isOn() && w.getIsEnd().toString().contains("LIGHT")){
				w.getIsEnd().setOn(true);
				w.getIsEnd().flipSwitch();
			}
			if(!w.isOn() && w.getIsEnd().toString().contains("LIGHT")){
				w.getIsEnd().setOn(false);
				w.getIsEnd().flipSwitch();
			}
		}
		repaint();
	}
	
	/**
	 * Resets the logic when changes are made
	 */
	public void resetLogic(){
		for(Wire w : wires){
			w.setOn(false);
		}
		for(Gate g : gates){
			g.setOutput(false);
		}
	}

	/**
	 * This is used as the mouse listener
	 */
	private class MouseClickListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(makeGate == true){
				switch (gateChosen){
				case AND_GATE: 
					makeGate = !makeGate;
					andGateLabel.setVisible(false);
					AndGate g = new AndGate();

					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g.setX(e.getX()-32);
						g.setY(e.getY()-25);
						gates.add(g);
					}
					else{
						//this is just a quick fix, if you remove this line and a item is put in an illegal spot, when you select a new item
						//the first frame it is drawn where it was last before it disappeared. 
						andGateLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case OR_GATE:
					makeGate = !makeGate;
					orGateLabel.setVisible(false);
					OrGate g1 = new OrGate();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g1.setX(e.getX()-32);
						g1.setY(e.getY()-25);
						gates.add(g1);
					}
					else{
						orGateLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case NOT_GATE:
					makeGate = !makeGate;
					notGateLabel.setVisible(false);
					NotGate g2 = new NotGate();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g2.setX(e.getX()-32);
						g2.setY(e.getY()-25);
						gates.add(g2);
					}
					else{
						notGateLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case SWITCH:
					makeGate = !makeGate;
					switchLabel.setVisible(false);
					SwitchGate g3 = new SwitchGate();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g3.setX(e.getX()-32);
						g3.setY(e.getY()-25);
						gates.add(g3);
					}
					else{
						switchLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case CLOCK:
					makeGate = !makeGate;
					clockLabel.setVisible(false);
					Clock g4 = new Clock();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g4.setX(e.getX()-32);
						g4.setY(e.getY()-25);
						gates.add(g4);
					}
					else{
						clockLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case NAND_GATE:
					makeGate = !makeGate;
					nandGateLabel.setVisible(false);
					NandGate g5 = new NandGate();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g5.setX(e.getX()-32);
						g5.setY(e.getY()-25);
						gates.add(g5);
					}
					else{
						nandGateLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case NOR_GATE:
					makeGate = !makeGate;
					norGateLabel.setVisible(false);
					NorGate g6 = new NorGate();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g6.setX(e.getX()-32);
						g6.setY(e.getY()-25);
						gates.add(g6);
					}
					else{
						norGateLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case XOR_GATE:
					makeGate = !makeGate;
					xorGateLabel.setVisible(false);
					XorGate g7 = new XorGate();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g7.setX(e.getX()-32);
						g7.setY(e.getY()-25);
						gates.add(g7);
					}
					else{
						xorGateLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				case LIGHT:
					makeGate = !makeGate;
					lightLabel.setVisible(false);
					Light g8 = new Light();
					if(Gate.checkBounds(e.getX()-32, e.getY()-25)){
						g8.setX(e.getX()-32);
						g8.setY(e.getY()-25);
						gates.add(g8);
					}
					else{
						lightLabel.setLocation(-1000, -1000);
						JOptionPane.showMessageDialog(null, "Please drop item on correct area.");
					}
					break;
				}
				repaint();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			//if drawwire button is selected, draw a wire and set isDrawing to true
			System.out.println(e.getXOnScreen() + ", " + e.getYOnScreen());
			if(drawWire){
				Wire w = new Wire();
				w.setStartX(e.getXOnScreen());
				w.setStartY(e.getYOnScreen());
				if(w.startInBounds(gates)){
				
					isDrawing = true;
					wires.add(w);
					currWire++;
					wires.get(currWire).setEndX(e.getXOnScreen());
					wires.get(currWire).setEndY(e.getYOnScreen());
					repaint();
				}
			}
			else{
				if(isRunning){
					for(Gate g : gates){
						if(e.getXOnScreen() <= g.getX() + 80 && e.getYOnScreen() <= g.getY() + 80 
								&& e.getXOnScreen() >= g.getX() && e.getYOnScreen() >= g.getY()){
							if(g.toString().contains("SWITCH")){
								if(g.isOn() == false){
									g.setOn(true);
								}
								else{
									g.setOn(false);
								//	resetLogic();
								}
								g.updateState();
								if(g.isOn()){
									checkLogic();
								}
								repaint();
							}
						}
						
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			//if we were drawing a wire this will draw it where we let go, if it is in bounds (on a terminal)
			//set isDrawing to false, we are done drawing.
			if(drawWire && isDrawing){
				wires.get(currWire).setEndX(e.getXOnScreen());
				wires.get(currWire).setEndY(e.getYOnScreen());
				
				if(!wires.get(currWire).endInBounds(gates)){
					wires.remove(currWire);
					currWire--;
				}
				repaint();
				isDrawing = false;
			}
			
		}
	}
	
	public void resetWires(Gate g){
		for(Wire w : wires){
			if(w.getIsStart() == g){
				if(g.getUpperInputWire() == w){
					w.setStartX(g.getX() + 4);
					w.setStartY(g.getY() + 28);
				}
				if(g.getLowerInputWire() == w){
					w.setStartX(g.getX() + 4);
					w.setStartY(g.getY() + 50);
				}
				if(g.getOutputWire() == w){
					w.setStartX(g.getX() + 75);
					w.setStartY(g.getY() + 40);
				}
			}
			if(w.getIsEnd() == g){
				if(g.getUpperInputWire() == w){
					w.setEndX(g.getX() + 4);
					w.setEndY(g.getY() + 28);
				}
				if(g.getLowerInputWire() == w){
					w.setEndX(g.getX() + 4);
					w.setEndY(g.getY() + 50);
				}
				if(g.getOutputWire() == w){
					w.setEndX(g.getX() + 75);
					w.setEndY(g.getY() + 40);
				}
			}
		}
	}
	
	/**
	 * This is used for showing icons as they are dragged
	 */
	private class MyMouseListener implements MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			//this is if we are dragging an icon around (don't allow if running)
			if(!drawWire && !isRunning){
				for(Gate g : gates){
					if(g.isInBounds(e.getX(), e.getY())){
						g.setX(e.getXOnScreen() - BUTTON_SIZE/2);
						g.setY(e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						resetWires(g);
						repaint();
					}
					
				}
			}
			else{
				//this is to animate the wire we are drawing
				if(isDrawing){
					wires.get(currWire).setEndX(e.getXOnScreen());
					wires.get(currWire).setEndY(e.getYOnScreen());
					repaint();
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if(makeGate == true){
				switch (gateChosen){
				case AND_GATE: 
					andGateLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						andGateLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case OR_GATE:
					orGateLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						orGateLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case NOT_GATE:
					notGateLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						notGateLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case SWITCH:
					switchLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						switchLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case CLOCK:
					clockLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						clockLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case NAND_GATE:
					nandGateLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						nandGateLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case NOR_GATE:
					norGateLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){	
						norGateLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case XOR_GATE:
					xorGateLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						xorGateLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				case LIGHT:
					lightLabel.setVisible(true);
					if(Gate.checkBounds(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2)){
						lightLabel.setLocation(e.getXOnScreen() - BUTTON_SIZE/2, e.getYOnScreen() - BUTTON_SIZE/2 - 15);
						repaint();
					}
					break;
				
					
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() != null){
		if(e.getActionCommand().equals("andgate")){
			makeGate = true;
			gateChosen = AND_GATE;
			this.add(andGateLabel);
		}
		if(e.getActionCommand().equals("orgate")){
			makeGate = true;
			gateChosen = OR_GATE;
			this.add(orGateLabel);
		}
		if(e.getActionCommand().equals("notgate")){
			makeGate = true;
			gateChosen = NOT_GATE;
			this.add(notGateLabel);
		}
		if(e.getActionCommand().equals("wire")){
			
			if(!isRunning){
				drawWire = !drawWire;
				if(drawWire){
					wireButton.setIcon(ImageHelper.resizeIcon(new File("src/WIREON_1.png")));
				}
				else{
					wireButton.setIcon(ImageHelper.resizeIcon(new File("src/WIRE.png")));
				}
			}
		}
		if(e.getActionCommand().equals("switch")){
			makeGate = true;
			gateChosen = SWITCH;
			this.add(switchLabel);
		}
		if(e.getActionCommand().equals("clock")){
			makeGate = true;
			gateChosen = CLOCK;
			this.add(clockLabel);
		}
		if(e.getActionCommand().equals("nandgate")){
			makeGate = true;
			gateChosen = NAND_GATE;
			this.add(nandGateLabel);
		}
		if(e.getActionCommand().equals("norgate")){
			makeGate = true;
			gateChosen = NOR_GATE;
			this.add(norGateLabel);
		}
		if(e.getActionCommand().equals("xorgate")){
			makeGate = true;
			gateChosen = XOR_GATE;
			this.add(xorGateLabel);
		}
		if(e.getActionCommand().equals("light")){
			makeGate = true;
			gateChosen = LIGHT;
			this.add(lightLabel);
		}
		if(e.getActionCommand().equals("run")){
			
			if(!drawWire){
				isRunning = !isRunning;
				if(isRunning){
					runButton.setIcon(ImageHelper.resizeIcon(new File("src/RUNON.png")));
				}
				else{
					runButton.setIcon(ImageHelper.resizeIcon(new File("src/RUN.png")));
					resetLogic();
					repaint();
				}
			}
		}
	}
}
}
