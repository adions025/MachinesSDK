package view;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class InputsCalibration extends JPanel {

	private JTabbedPane tabs;
	private InCalibrationActuator calibration;
	
	public InputsCalibration() {
		initComponents();
	}

	private void initComponents() {
		this.setLayout(new MigLayout("", "[fill, grow, push, 100%]",
				"[fill, grow, push,80%] [fill, grow, push,20%]"));
		
		tabs = new JTabbedPane();
		calibration = new InCalibrationActuator();
		
		tabs.addTab("HyperG", calibration);
		this.add(tabs);
	}
}
