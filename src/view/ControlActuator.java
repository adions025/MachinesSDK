package view;

import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.Global;
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

	//pullback
	private static final int NUM_PULL_DI = 9;
	private static final int NUM_DI_DQ_AI = 2;
	private Object [][] pullDi = new Object[NUM_DI_DQ_AI][NUM_PULL_DI];

	private static final int NUM_PULL_DQ = 9;
	private Object [][] pullDq = new Object[NUM_DI_DQ_AI][NUM_PULL_DQ];
	
	private static final int NUM_PULL_AI = 2;
	private Object [][] pullAi = new Object[NUM_DI_DQ_AI][NUM_PULL_AI];
	
	//Fast Charging ADV SERVICES components
	private static final int NUM_FAST_DI = 8;
	private Object [][] fastDi = new Object[NUM_DI_DQ_AI][NUM_FAST_DI];
	
	private static final int NUM_FAST_DQ = 11;
	private Object [][] fastDq = new Object[NUM_DI_DQ_AI][NUM_FAST_DQ];

	private static final int NUM_FAST_AI = 7;
	private Object [][] fastAi = new Object[NUM_DI_DQ_AI][NUM_FAST_AI];
	
	//HPP brake components
	private static final int NUM_HPPBRAKE_DI = 3;
	private Object [][] hppBrakeDi = new Object[NUM_DI_DQ_AI][NUM_HPPBRAKE_DI];
	
	private static final int NUM_HPPBRAKE_DQ = 2;
	private Object [][] hppBrakeDq = new Object[NUM_DI_DQ_AI][NUM_HPPBRAKE_DQ];

	private static final int NUM_HPPBRAKE_AI = 1;
	private Object [][] hppBrakeAi = new Object[NUM_DI_DQ_AI][NUM_HPPBRAKE_AI];
	
	//HPP brake components
	private static final int NUM_HPPFAST_DI = 2;
	private Object [][] hppFastDi = new Object[NUM_DI_DQ_AI][NUM_HPPFAST_DI];
	
	private static final int NUM_HPPFAST_DQ = 2;
	private Object [][] hppFastDq = new Object[NUM_DI_DQ_AI][NUM_HPPFAST_DQ];

	private static final int NUM_HPPFAST_AI = 1;
	private Object [][] hppFastAi = new Object[NUM_DI_DQ_AI][NUM_HPPFAST_AI];

	public ControlActuator() {
		initComponents();
	}

	private void initComponents() {
		String filePathTmp = new File("").getAbsolutePath();
		Path evtDI = Paths.get(filePathTmp, File.separatorChar + "assets" + 
				File.separatorChar + "icons" + File.separatorChar + "22x22"+
				File.separatorChar + "actions" + File.separatorChar + 
				"green.png").normalize();

		this.setLayout(new MigLayout("", "[]","[fill, 20%][fill, 80%]"));

		JPanel content = new JPanel(new MigLayout("", "[20%][20%][20%][20%]",
				"[]"));

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

		content.setBorder(etchedLoweredBorder);
		this.add(content, "push, grow, wrap");

		//here start second row
		JPanel content2 = new JPanel(new MigLayout("", "[][][]"));
		
		//here start second row and first column
		JPanel pullBack = new JPanel(new MigLayout("", "[][fill,15%][]"));
		int ID_NAME = 0;
		int ID_STATE = 1;
		for (int i = 0; i<pullDi[ID_NAME].length; i++) {
			pullDi[ID_NAME][i]=new JLabel();
			pullDi[ID_STATE][i]=new JLabel();
			((JLabel)pullDi[ID_STATE][i]).setIcon(
					new ImageIcon(String.valueOf(evtDI)));
			pullBack.add((JLabel) pullDi[ID_NAME][i], "");
			pullBack.add((JLabel) pullDi[ID_STATE][i], "wrap");
		}
		// DIs
		((JLabel) pullDi[ID_NAME][0]).setText(
				"Decoupling position carriage:");

		((JLabel) pullDi[ID_NAME][1]).setText(
				"Return cylinder end position:");

		((JLabel)pullDi[ID_NAME][2]).setText(
				"RZZY Pilot P Supply Pressure:");

		((JLabel)pullDi[ID_NAME][3]).setText(
				"Piston lock at the bottom:");

		((JLabel)pullDi[ID_NAME][4]).setText(
				"Piston lock at the top:");

		((JLabel)pullDi[ID_NAME][5]).setText(
				"Chain gripper decoupled:");

		((JLabel)pullDi[ID_NAME][6]).setText(
				"Chain gripper coupled:");

		((JLabel)pullDi[ID_NAME][7]).setText(
				"Retraction cylinder bolt sensor:");

		((JLabel)pullDi[ID_NAME][8]).setText(
				"Retraction cylinder rod sensor:");
		
		int ID_CHECK = 1;
		for (int i = 0; i<pullDq[ID_NAME].length; i++) {
			pullDq[ID_NAME][i]=new JLabel();
			pullDq[ID_CHECK][i]=new JCheckBox();
			pullBack.add((JLabel) pullDq[ID_NAME][i], "");
			pullBack.add((JCheckBox) pullDq[ID_CHECK][i], "wrap");
		}
		
		// DQs
		((JLabel)pullDq[ID_NAME][0]).setText(
				"Couple chain gripper:");
		
		((JLabel)pullDq[ID_NAME][1]).setText(
				"Decouple chain gripper:");
		
		((JLabel)pullDq[ID_NAME][2]).setText(
				"Driving backward:");
		
		((JLabel)pullDq[ID_NAME][3]).setText(
				"Driving forward:");
		
		((JLabel)pullDq[ID_NAME][4]).setText(
				"Switch on:");
		
		((JLabel)pullDq[ID_NAME][5]).setText(
				"Forward button:");
		
		((JLabel)pullDq[ID_NAME][6]).setText(
				"Reward button:");
		
		((JLabel)pullDq[ID_NAME][7]).setText(
				"Enable pull back:");
		
		((JLabel)pullDq[ID_NAME][8]).setText(
				"Slip reduction:");
		
		
		int ID_TXT = 1;
		for (int i = 0; i<pullAi[ID_NAME].length; i++) {
			pullDq[ID_NAME][i]=new JLabel();
			pullDq[ID_TXT][i]=new JTextField();
			((JTextField)pullDq[ID_TXT][i]).setEnabled(false);
			
			pullBack.add((JLabel) pullDq[ID_NAME][i], "");
			pullBack.add((JTextField) pullDq[ID_TXT][i], "wrap");
		}
		//AIs
		((JLabel)pullDq[ID_NAME][0]).setText(
				"Retraction cylinder rod sensor:");
		
		((JLabel)pullDq[ID_NAME][1]).setText(
				"Retraction cylinder rod sensor:");
		
		pullBack.setBorder(etchedLoweredBorder);
		content2.add(pullBack, "grow, push");

		//		JPanel presure1 = new JPanel(new MigLayout("", "[][fill,15%]", ""));
		
		
		//here start second row and second column
		JPanel fastCharge = new JPanel(new MigLayout("", "[][][]"));
		
		for (int i = 0; i<fastDi[ID_NAME].length; i++) {
			fastDi[ID_NAME][i] = new JLabel();
			fastDi[ID_STATE][i]=new JLabel();
			((JLabel)fastDi[ID_STATE][i]).setIcon(
					new ImageIcon(String.valueOf(evtDI)));
			fastCharge.add((JLabel) fastDi[ID_NAME][i], "");
			fastCharge.add((JLabel) fastDi[ID_STATE][i], "wrap");
		}
		
		((JLabel)fastDi[ID_NAME][0]).setText(
				"Feedback safety valve:");
		
		((JLabel)fastDi[ID_NAME][1]).setText(
				"Feedback storage valve:");
		
		((JLabel)fastDi[ID_NAME][2]).setText(
				"Safety valve closed:");
		
		((JLabel)fastDi[ID_NAME][3]).setText(
				"Safety valve opened:");
		
		((JLabel)fastDi[ID_NAME][4]).setText(
				"Storage valve closed:");
	
		((JLabel)fastDi[ID_NAME][5]).setText(
				"Storage valve opened:");
		
		((JLabel)fastDi[ID_NAME][6]).setText(
				"High pressure switch:");
		
		((JLabel)fastDi[ID_NAME][7]).setText(
				"Conditions fast charging ok:");
		
		for (int i = 0; i<fastDq[ID_NAME].length; i++) {
			fastDq[ID_NAME][i] = new JLabel();
			fastDq[ID_CHECK][i]=new JCheckBox();

			fastCharge.add((JLabel) fastDq[ID_NAME][i], "");
			fastCharge.add((JCheckBox) fastDq[ID_CHECK][i], "wrap");
		}
		
		((JLabel)fastDq[ID_NAME][0]).setText(
				"Empty HyperG valve:");
		
		((JLabel)fastDq[ID_NAME][1]).setText(
				"Fill HyperG valve:");
		
		((JLabel)fastDq[ID_NAME][2]).setText(
				"Relieve valve 1:");
		
		((JLabel)fastDq[ID_NAME][3]).setText(
				"Relieve valve 2:");
		
		((JLabel)fastDq[ID_NAME][4]).setText(
				"Refill valve:");
	
		((JLabel)fastDq[ID_NAME][5]).setText(
				"Safety valve:");
		
		((JLabel)fastDq[ID_NAME][6]).setText(
				"Storage valve:");
		
		((JLabel)fastDq[ID_NAME][7]).setText(
				"26KK4 valve:");
		
		((JLabel)fastDq[ID_NAME][8]).setText(
				"26KK8 valve:");
	
		((JLabel)fastDq[ID_NAME][9]).setText(
				"26Y12 valve:");
		
		((JLabel)fastDq[ID_NAME][10]).setText(
				"26Y16 valve:");
		
		fastCharge.setBorder(etchedLoweredBorder);
		content2.add(fastCharge, "grow, push");
		
		

		
		//here start second row and third column
		JPanel fastCharge2 = new JPanel(new MigLayout("", "[][fill,15%][]"));
		
		for (int i = 0; i<fastAi[ID_NAME].length; i++) {
			fastAi[ID_NAME][i] = new JLabel();
			fastAi[ID_TXT][i]=new JTextField();

			fastCharge2.add((JLabel) fastAi[ID_NAME][i], "");
			fastCharge2.add((JTextField) fastAi[ID_TXT][i], "wrap");
		}
		
		((JLabel)fastAi[ID_NAME][0]).setText(
				"HyperG sensor 1:");
		
		((JLabel)fastAi[ID_NAME][1]).setText(
				"HyperG sensor 2:");
		
		((JLabel)fastAi[ID_NAME][2]).setText(
				"Storage sensor:");
		
		((JLabel)fastAi[ID_NAME][3]).setText(
				"HyperG oil sensor:");
		
		((JLabel)fastAi[ID_NAME][4]).setText(
				"Accumulator sensor:");
	
		((JLabel)fastAi[ID_NAME][5]).setText(
				"Accumulator oil sensor:");
		
		((JLabel)fastAi[ID_NAME][6]).setText(
				"Low pressure sensor:");
		
		fastCharge2.setBorder(etchedLoweredBorder);
		content2.add(fastCharge2, "grow, push");
		
		
		//here start second row and fourth column
		JPanel mixed = new JPanel(new MigLayout("", ""));
		//first row inside fourth column
		JPanel hppBrake = new JPanel(new MigLayout("", "[][fill,15%][]"));
		for (int i = 0; i<hppBrakeDi[ID_NAME].length; i++) {
			hppBrakeDi[ID_NAME][i] = new JLabel();
			hppBrakeDi[ID_STATE][i]=new JLabel();
			((JLabel)hppBrakeDi[ID_STATE][i]).setIcon(
					new ImageIcon(String.valueOf(evtDI)));
			hppBrake.add((JLabel) hppBrakeDi[ID_NAME][i], "");
			hppBrake.add((JLabel) hppBrakeDi[ID_STATE][i], "wrap");
			
		}
		
		((JLabel)hppBrakeDi[ID_NAME][0]).setText(
				"Running:");
		
		((JLabel)hppBrakeDi[ID_NAME][1]).setText(
				"Fault:");
		
		((JLabel)hppBrakeDi[ID_NAME][2]).setText(
				"Position monitoring Shut-off valve:");
		
		for (int i = 0; i<hppBrakeDq[ID_NAME].length; i++) {
			hppBrakeDq[ID_NAME][i] = new JLabel();
			hppBrakeDq[ID_CHECK][i]=new JCheckBox();
			hppBrake.add((JLabel) hppBrakeDq[ID_NAME][i], "");
			hppBrake.add((JCheckBox) hppBrakeDq[ID_CHECK][i], "wrap");
		}
		
		((JLabel)hppBrakeDq[ID_NAME][0]).setText(
				"Switch on hydraulic brakes:");
		
		((JLabel)hppBrakeDq[ID_NAME][1]).setText(
				"Stop reset hydraulic brakes:");
		
		hppBrake.setBorder(etchedLoweredBorder);
		mixed.add(hppBrake, "grow, push, wrap");
		
		for (int i = 0; i<hppBrakeAi[ID_NAME].length; i++) {
			hppBrakeAi[ID_NAME][i] = new JLabel();
			hppBrakeAi[ID_TXT][i]=new JTextField();
			((JTextField)hppBrakeAi[ID_TXT][i]).setEnabled(false);
			hppBrake.add((JLabel) hppBrakeAi[ID_NAME][i], "");
			hppBrake.add((JTextField) hppBrakeAi[ID_TXT][i], "wrap");
		}
		
		((JLabel)hppBrakeAi[ID_NAME][0]).setText(
				"Pressure sensor hydraulic brakes:");
		
		hppBrake.setBorder(etchedLoweredBorder);
		mixed.add(hppBrake, "grow, push, wrap");
		
		
		//second row inside fourth column
		JPanel hppFastChar = new JPanel(new MigLayout("", "[][fill,15%][]"));

		for (int i = 0; i<hppFastDi[ID_NAME].length; i++) {
			hppFastDi[ID_NAME][i] = new JLabel();
			hppFastDi[ID_STATE][i]=new JLabel();
			((JLabel)hppFastDi[ID_STATE][i]).setIcon(
					new ImageIcon(String.valueOf(evtDI)));
			hppFastChar.add((JLabel) hppFastDi[ID_NAME][i], "");
			hppFastChar.add((JLabel) hppFastDi[ID_STATE][i], "wrap");
			
		}
		
		((JLabel)hppFastDi[ID_NAME][0]).setText(
				"Running hydraulic FC:");
		
		((JLabel)hppFastDi[ID_NAME][1]).setText(
				"Fault hydraulic FC:");
		
		for (int i = 0; i<hppFastDq[ID_NAME].length; i++) {
			hppFastDq[ID_NAME][i] = new JLabel();
			hppFastDq[ID_STATE][i]=new JCheckBox();

			hppFastChar.add((JLabel) hppFastDq[ID_NAME][i], "");
			hppFastChar.add((JCheckBox) hppFastDq[ID_STATE][i], "wrap");
			
		}
		
		((JLabel)hppFastDq[ID_NAME][0]).setText(
				"Switch on hydraulic FC:");
		
		((JLabel)hppFastDq[ID_NAME][1]).setText(
				"Stop reset hydraulic FC:");
		
		
		for (int i = 0; i<hppFastAi[ID_NAME].length; i++) {
			hppFastAi[ID_NAME][i] = new JLabel();
			hppFastAi[ID_TXT][i]=new JTextField();
			((JTextField)hppFastAi[ID_TXT][i]).setEnabled(false);
			hppFastChar.add((JLabel) hppFastAi[ID_NAME][i], "");
			hppFastChar.add((JTextField) hppFastAi[ID_TXT][i], "wrap");
			
		}
		
		((JLabel)hppFastAi[ID_NAME][0]).setText(
				"Pressure sensor hydraulic FC:");
		

		hppFastChar.setBorder(etchedLoweredBorder);
		mixed.add(hppFastChar, "grow, push, wrap");
		
		//third row inside fourth column
		JPanel hppSledBrake = new JPanel(new MigLayout("", "[][][]"));
		
		hppSledBrake.setBorder(etchedLoweredBorder);
		mixed.add(hppSledBrake, "grow, push");
		
		

		mixed.setBorder(etchedLoweredBorder);
		content2.add(mixed, "grow, push");
		
		
		content2.setBorder(etchedLoweredBorder);
		this.add(content2, "push, grow");
	}
}
