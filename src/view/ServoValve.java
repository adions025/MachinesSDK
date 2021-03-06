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
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class ServoValve extends JPanel  implements ActionListener{

	private static final int NUM_VALES = 12;
	private JPanel []valves = new JPanel[NUM_VALES];
	private JLabel [] lblServo = new JLabel[NUM_VALES];
	private JLabel [] lblPosition = new JLabel[NUM_VALES];
	private JCheckBox [] checkValve = new JCheckBox[NUM_VALES];
	private JTextField [] jtxtVales = new JTextField[NUM_VALES];

	private JLabel [] lblPressure = new JLabel[NUM_VALES];
	private JTextField [] jtxtPresure = new JTextField[NUM_VALES];

	private JLabel [] lblServoN = new JLabel[NUM_VALES];
	private JTextField [] jtxtServo = new JTextField[NUM_VALES];

	private JLabel [] lblSetPoint = new JLabel[NUM_VALES];
	private JTextField [] jtxtSetPoint = new JTextField[NUM_VALES];
	private JLabel [] lblBtnPoint = new JLabel[NUM_VALES];

	private JToggleButton btnRunStop;
	//	private JButton btnApply;
	private boolean runFlag;
	private Machine machine;

	public ServoValve(Machine machine) {
		this.machine = machine;
		initComponent();
	}

	private void initComponent() {
		//		String filePathTmp = new File("").getAbsolutePath();
		//		Path evtDI = Paths.get(filePathTmp, File.separatorChar + "assets" + 
		//				File.separatorChar + "icons" + File.separatorChar + "22x22"+
		//				File.separatorChar + "actions" + File.separatorChar + 
		//				"player_play.png").normalize();

		String filePathTmp = new File("").getAbsolutePath();
		Path evtDI = Paths.get(filePathTmp, File.separatorChar + "icons" + 
				File.separatorChar + "22x22"
				+ File.separatorChar + "actions" + File.separatorChar + 
				"player_play.png").normalize();

		this.setLayout(new MigLayout("", "", 
				"0[fill, grow, push, 98%] 0[fill, grow, push, 2%]0"));

		JPanel valvesPa = new JPanel(new MigLayout("", "[][][][]","[][][]"));

		Border etchedLoweredBorder = 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		int count = 1;
		for (int i = 0; i<NUM_VALES; i++) {
			valves[i] = new JPanel(new MigLayout("", "[min!]20[15%!]20[]",// ""));
					"[min!][min!][min!][min!][min!]"));
			//		"[15%][15%][15%][15%][15%]"));
			valves[i].setBorder(etchedLoweredBorder);

			//			lblServo[i] = new JLabel("Run servo "+ i + " adjustment:");
			//			checkValve[i] = new JCheckBox();

			lblPosition[i] = new JLabel("Servo "+ i + " position:");
			jtxtVales[i] = new JTextField();
			jtxtVales[i].setEnabled(false);

			lblPressure[i] = new JLabel("Pressure sensor "+ i+ ":");
			jtxtPresure[i] = new JTextField();
			jtxtPresure[i].setEnabled(false);

			lblServoN[i] = new JLabel("Servo "+ i+":");
			jtxtServo[i] = new JTextField();
			jtxtServo[i].setEnabled(false);

			lblSetPoint[i] = new JLabel("Pressure set point "+ i+":");
			jtxtSetPoint[i] = new JTextField();
			jtxtSetPoint[i].setEnabled(false);
			lblBtnPoint[i] = new JLabel();
			lblBtnPoint[i].setIcon(new ImageIcon(String.valueOf(evtDI)));
			if (count % 4 == 0) {
				valvesPa.add(valves[i], "grow, push, wrap");
			}else {
				valvesPa.add(valves[i], "grow, push");
			}
			//			valves[i].add(lblServo[i], "grow, push");
			//			valves[i].add(checkValve[i], "grow, push, wrap");

			valves[i].add(lblPosition[i], "grow, push");
			valves[i].add(jtxtVales[i],  "growx, push, wrap");

			valves[i].add(lblPressure[i], "grow, push");
			valves[i].add(jtxtPresure[i],  "growx, push, wrap");

			valves[i].add(lblServoN[i], "grow, push");
			valves[i].add(jtxtServo[i],  "growx, push, wrap");

			valves[i].add(lblSetPoint[i], "grow, push");
			valves[i].add(jtxtSetPoint[i],  "growx, push, ");
			valves[i].add(lblBtnPoint[i], "grow, push, wrap");
			count++;
		}

		valvesPa.setBorder(etchedLoweredBorder);
		this.add(valvesPa, "grow, push, wrap");

		JPanel footer = new JPanel(new MigLayout("", "", ""));
		footer.setBorder(etchedLoweredBorder);

		btnRunStop = new JToggleButton("Start");
		//		btnApply = new JButton("Apply");
		//		btnApply.addActionListener(this);
		btnRunStop.addActionListener(this);
		//		footer.add(btnApply);
		footer.add(btnRunStop);
		this.add(footer, "grow, push, wrap");
	}

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
