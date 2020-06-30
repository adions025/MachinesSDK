package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class InputsCalibration extends JPanel implements ActionListener{

	private JTabbedPane tabs;
	private InCalibrationActuator calibration;
	private JButton btnRunStop;
	private JButton btnApply;
	private boolean runFlag = false;
	private Machine machine;
	
	public InputsCalibration(Machine machine) {
		this.machine = machine;
		initComponents();
	}

	private void initComponents() {
		Border etchedLoweredBorder = 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		this.setLayout(new MigLayout("", "0[fill, grow, push, 100%]0",
				"0[fill, grow, push, 95%] [fill, grow, push, 5%]0"));
		
		tabs = new JTabbedPane();
		calibration = new InCalibrationActuator();
		
		tabs.addTab("HyperG", calibration);
		this.add(tabs, "wrap");
		
		
		JPanel runContent = new JPanel(new MigLayout("", "[][]","8[]"));
		
		btnRunStop = new JButton("Start");
		btnApply = new JButton("Apply");
		btnApply.addActionListener(this);
		btnRunStop.addActionListener(this);
		runContent.add(btnApply);
		runContent.add(btnRunStop);

		runContent.setBorder(etchedLoweredBorder);
		this.add(runContent);
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnApply) {
//			//HERE APPLY BUTTON FUNCTION
//		}
//		if (e.getSource() == btnRunStop) {
//			changeBtnState();
//		}
//	}
//	
//	private void changeBtnState() {
//		if (runFlag) {
//			runFlag = false;
//			btnRunStop.setText("Stop");
//		}else {
//			runFlag = true;
//			btnRunStop.setText("Start");
//		}
//	}
//	
	
	private void setEnable(boolean activate) {
		machine.getTabs().setEnabledAt(0, activate);
		machine.getTabs().setEnabledAt(1, activate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRunStop) {
			if (btnRunStop.isSelected()) {
				btnRunStop.setText("Stop");
				setEnable(false);
			}else {
				btnRunStop.setText("Start");
				setEnable(true);
			}
			
			
		}
	}
}