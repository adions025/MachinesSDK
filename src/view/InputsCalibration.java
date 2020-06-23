package view;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class InputsCalibration extends JPanel {

	private static final int NUM_SERVO = 12;
	private JLabel [] lblServo = new JLabel[NUM_SERVO];
	private JTextField [] jTxtServo = new JTextField[NUM_SERVO];

	private static final int NUM_PRESSURES = 12;
	private JLabel [] lblPressures = new JLabel[NUM_PRESSURES];
	private JTextField [] jTxtPres = new JTextField[NUM_PRESSURES];

	private static final int NUM_RUN_APPLY = 2;
	private JLabel [] lblRunApply = new JLabel[NUM_RUN_APPLY];
	private JCheckBox [] checkRunApply = new JCheckBox[NUM_RUN_APPLY];

	public InputsCalibration() {
		initComponents();
	}

	private void initComponents() {
		Border etchedLoweredBorder = 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		this.setLayout(new MigLayout("", "[][][]"));
		JPanel content = new JPanel(new MigLayout("debug", 
				"[min!][fill, 15%!]", ""));

		for (int i = 0; i<NUM_SERVO; i++) {
			lblServo[i] = new JLabel("Servo " +(i+1)+" position: ");
			jTxtServo[i] = new JTextField();
			jTxtServo[i].setEnabled(false);

			content.add(lblServo[i], "grow, push");
			content.add(jTxtServo[i], "grow, push, wrap");
		}
		content.setBorder(etchedLoweredBorder);
		this.add(content, "pushx, growx, ");

		JPanel content1 = new JPanel(new MigLayout("debug", 
				"[min!][fill, 15%!]", ""));
		for (int i = 0; i<NUM_PRESSURES; i++) {
			lblPressures[i] = new JLabel("Pressure sensor "+i);
			jTxtPres[i] = new JTextField();
			jTxtPres[i].setEnabled(false);

			content1.add(lblPressures[i], "grow, push");
			content1.add(jTxtPres[i], "grow, push, wrap");
		}
		content1.setBorder(etchedLoweredBorder);
		this.add(content1, "pushx, growx");


		JPanel content2 = new JPanel(new MigLayout("debug", 
				"[min!][fill, 15%!]", ""));
		lblRunApply[0] = new JLabel("Run inputs calibration");
		checkRunApply[0] = new JCheckBox();

		lblRunApply[1] = new JLabel("Apply calibration");
		checkRunApply[1] = new JCheckBox();

		content2.add(lblRunApply[0], "grow, push");
		content2.add(checkRunApply[0], "grow, push, wrap");

		content2.add(lblRunApply[1], "grow, push");
		content2.add(checkRunApply[1], "grow, push, wrap");

		content2.setBorder(etchedLoweredBorder);
		this.add(content2, "pushx, growx");
	}
}
