package view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class ControlActuator extends JPanel {

	private static final int CONTROL_PRESURE = 12;
	private JLabel[] lblPressure1 = new JLabel[CONTROL_PRESURE];
	private JLabel[] lblPressure2 = new JLabel[CONTROL_PRESURE];
	private JLabel[] lblPressure3 = new JLabel[CONTROL_PRESURE];

	private JTextField[] jtxPressure1 = new JTextField[CONTROL_PRESURE];
	private JTextField[] jtxPressure2 = new JTextField[CONTROL_PRESURE];
	private JTextField[] jtxPressure3 = new JTextField[CONTROL_PRESURE];

	private static final int SLED_BRAKES = 10;
	private JLabel[] lblSled = new JLabel[SLED_BRAKES];
	private JTextField[] jtxsled = new JTextField[SLED_BRAKES];

	public ControlActuator() {
		initComponents();
	}

	private void initComponents() {
		this.setLayout(new MigLayout("", "[]","[fill, 20%][fill, 80%]"));

		JPanel content = new JPanel(new MigLayout("", "[][][][]", "[]"));

		JPanel presure1 = new JPanel(new MigLayout("", "[][fill,15%]", ""));
		JPanel presure2 = new JPanel(new MigLayout("", "[][fill,15%]", ""));
		JPanel presure3 = new JPanel(new MigLayout("", "[][fill,15%]", ""));
		JPanel sledBrake= new JPanel(new MigLayout("", "[][fill,15%]", ""));
		for (int i = 0; i<CONTROL_PRESURE; i++) {
			lblPressure1[i] = new JLabel("Servo position "+(i+1) + ":");
			jtxPressure1[i] = new JTextField();
			jtxPressure1[i].setEnabled(false);
			presure1.add(lblPressure1[i], "");
			presure1.add(jtxPressure1[i], "wrap");

			lblPressure2[i] = new JLabel("Pressure sensor "+(i+1)+ ":");
			jtxPressure2[i] = new JTextField();
			jtxPressure2[i].setEnabled(false);
			presure2.add(lblPressure2[i], "");
			presure2.add(jtxPressure2[i], "wrap");

			lblPressure3[i] = new JLabel("Servo "+(i+1)+ ":");
			jtxPressure3[i] = new JTextField();
			jtxPressure3[i].setEnabled(false);
			presure3.add(lblPressure3[i], "");
			presure3.add(jtxPressure3[i], "wrap");
		}


		int c = 1;
		for (int i = 0; i<SLED_BRAKES; i++) {
			if (i>=0 && i<2) {
				lblSled[i] = new JLabel("Pressure brake "+(c++) + ":");
			}
			if (i>1 && i<4) {
				lblSled[i] = new JLabel("Accumulator pressure brake "+(c++) 
						+ ":");
			}
			if (i>3 && i<6) {
				lblSled[i] = new JLabel("Preload pressure brake "+(c++) + ":");
			}
			if (i>5 && i<8) {
				lblSled[i] = new JLabel("Briding Brake "+(c++) + ":");
			}
			if (i>7) {
				lblSled[i] = new JLabel("Relief of brake cylinder "+(c++) 
						+ ":");
			}
			jtxsled[i] = new JTextField();
			jtxsled[i].setEnabled(false);
			sledBrake.add(lblSled[i], "");
			sledBrake.add(jtxsled[i], "wrap");
			if (i%2!=0) {
				c = 1;
			}

		}

		Border etchedLoweredBorder = 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		presure1.setBorder(etchedLoweredBorder);
		content.add(presure1, "grow, push");

		presure2.setBorder(etchedLoweredBorder);
		content.add(presure2, "grow, push");

		presure3.setBorder(etchedLoweredBorder);
		content.add(presure3, "grow, push");

		sledBrake.setBorder(etchedLoweredBorder);
		content.add(sledBrake, "grow, push");

		this.add(content, "push, grow, wrap");


		JPanel content2 = new JPanel(new MigLayout("", ""));
		//		content2.setBorder(etchedLoweredBorder);
		this.add(content2, "push, grow");
	}
}
