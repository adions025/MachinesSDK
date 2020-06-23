package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.Machine;

public class main {
	
//	private static int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
//	private static int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static void main(String[] args) throws ClassNotFoundException, 
	InstantiationException, IllegalAccessException, 
	UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		Machine machine = new Machine();
		machine.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		machine.setSize(new Dimension(width, height-25));
		machine.setVisible(true);
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//SwingUtilities.updateComponentTreeUI(machine);
		//updateComponentTreeUI(machine);
	}

}
