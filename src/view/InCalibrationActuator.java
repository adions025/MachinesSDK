package view;

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

import net.miginfocom.swing.MigLayout;

public class InCalibrationActuator extends JPanel{
	private static final int NUM_SERVO = 12;
	private JLabel [] lblServo = new JLabel[NUM_SERVO];
	private JTextField [] jTxtServo = new JTextField[NUM_SERVO];

	private JLabel [] lblSpanSensor = new JLabel[NUM_SERVO];
	private JTextField [] jTxtSpanSensor = new JTextField[NUM_SERVO];
	private JLabel [] lblBtnSpanSensor = new JLabel[NUM_SERVO];

	private JLabel [] lblOffServo= new JLabel[NUM_SERVO];
	private JTextField [] jTxtlblOffServo = new JTextField[NUM_SERVO];
	private JLabel [] lblBtnlblOffServo = new JLabel[NUM_SERVO];
	//-------------------------------------------------------------------//

	private static final int NUM_PRESSURES = 12;
	private JLabel [] lblPressures = new JLabel[NUM_PRESSURES];
	private JTextField [] jTxtPres = new JTextField[NUM_PRESSURES];

	private JLabel [] lblSpanPres= new JLabel[NUM_PRESSURES];
	private JTextField [] jTxtSpanPres = new JTextField[NUM_PRESSURES];
	private JLabel [] lblBtnSpanPres = new JLabel[NUM_PRESSURES];

	private JLabel [] lblOffPres = new JLabel[NUM_PRESSURES];
	private JTextField [] jTxtOffPres = new JTextField[NUM_PRESSURES];
	private JLabel [] lblBtnOffPres = new JLabel[NUM_PRESSURES];
	//-------------------------------------------------------------------//

	private static final int NUM_SPAN = 3;
	private JLabel [] lblSpan = new JLabel[NUM_SPAN];
	private JTextField [] jTxtSpane = new JTextField[NUM_SPAN];
	private JLabel [] lblBtnSpan = new JLabel[NUM_SPAN];

	private static final int NUM_OFFSET = 3;
	private JLabel [] lblOffset = new JLabel[NUM_OFFSET];
	private JTextField [] jTxtOffset = new JTextField[NUM_OFFSET];
	private JLabel [] lblBtnOffset = new JLabel[NUM_OFFSET];

	private static final int NUM_RUN_APPLY = 2;
	private JLabel [] lblRunApply = new JLabel[NUM_RUN_APPLY];
	private JCheckBox [] checkRunApply = new JCheckBox[NUM_RUN_APPLY];

	public InCalibrationActuator() {
		initComponents();
	}

	private void initComponents() {
		String filePathTmp = new File("").getAbsolutePath();
		Path evtDI = Paths.get(filePathTmp, File.separatorChar + "assets" + 
				File.separatorChar + "icons" + File.separatorChar + "22x22"+
				File.separatorChar + "actions" + File.separatorChar + 
				"player_play.png").normalize();

		Border etchedLoweredBorder = 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		this.setLayout(new MigLayout("", "[][]"));

		//--------------------------------------------------------------------//
		JPanel content = new JPanel(new MigLayout("", //"",""));
				"[min!][fill, 15%!]", ""));
		for (int i = 0; i<NUM_SERVO; i++) {
			lblServo[i] = new JLabel("Servo " + (i+1) + " position [%]:");
			jTxtServo[i] = new JTextField();
			jTxtServo[i].setEnabled(false);
			content.add(lblServo[i], "push");
			content.add(jTxtServo[i], "push, wrap");
		}
		content.setBorder(etchedLoweredBorder);
		this.add(content, "pushx, grow, ");
		//--------------------------------------------------------------------//

		//--------------------------------------------------------------------//
		JPanel contentSpan = new JPanel(new MigLayout("", //"",""));
				"[min!][fill, 15%!][min!]", ""));
		for (int i = 0; i<NUM_SERVO; i++) {
			lblSpanSensor[i] = new JLabel("Span "+ (i+1) +
					" servo position [16 bits to %]: ");
			jTxtSpanSensor[i]= new JTextField();
			jTxtSpanSensor[i].setEnabled(false);
			lblBtnSpanSensor[i] = new JLabel(
					new ImageIcon(String.valueOf(evtDI)));
			contentSpan.add(lblSpanSensor[i], "push");
			contentSpan.add(jTxtSpanSensor[i], "push");
			contentSpan.add(lblBtnSpanSensor[i], "push, wrap");
		}
		contentSpan.setBorder(etchedLoweredBorder);
		this.add(contentSpan, "pushx, grow, ");
		//--------------------------------------------------------------------//

		//--------------------------------------------------------------------//
		JPanel contentOffSpan = new JPanel(new MigLayout("", //"",""));
				"[min!][fill, 15%!][min!]", ""));
		for (int i = 0; i<NUM_SERVO; i++) {
			lblOffServo[i] = new JLabel("Offset "+ (i+1)
					+ " servo position [%]:");
			jTxtlblOffServo[i]= new JTextField();
			jTxtlblOffServo[i].setEnabled(false);
			lblBtnlblOffServo[i] = new JLabel(
					new ImageIcon(String.valueOf(evtDI)));
			contentOffSpan.add(lblOffServo[i], "push");
			contentOffSpan.add(jTxtlblOffServo[i], "push");
			contentOffSpan.add(lblBtnlblOffServo[i], "push, wrap");
		}
		contentOffSpan.setBorder(etchedLoweredBorder);
		this.add(contentOffSpan, "pushx, grow, wrap");
		//--------------------------------------------------------------------//

		//--------------------------------------------------------------------//
		JPanel content1 = new JPanel(new MigLayout("", //"",""));
				"[min!][fill, 15%!][min!]", ""));
		for (int i = 0; i<NUM_PRESSURES; i++) {
			lblPressures[i] = new JLabel("Pressure sensor "+(i+1) + " [bar]:");
			jTxtPres[i] = new JTextField();
			jTxtPres[i].setEnabled(false);

			content1.add(lblPressures[i], "grow, push");
			content1.add(jTxtPres[i], "growx, push, wrap");
		}
		content1.setBorder(etchedLoweredBorder);
		this.add(content1, "pushx, grow");
		//--------------------------------------------------------------------//

		//--------------------------------------------------------------------//
		JPanel content1Press = new JPanel(new MigLayout("", //"",""));
				"[min!][fill, 15%!][min!]", ""));
		for (int i = 0; i<NUM_PRESSURES; i++) {
			lblSpanPres[i] = new JLabel("Span pressure sensor "+(i+1) 
					+ " [16 bits to bar]:");
			jTxtSpanPres[i] = new JTextField();
			jTxtSpanPres[i].setEnabled(false);
			lblBtnSpanPres[i] = new JLabel(
					new ImageIcon(String.valueOf(evtDI)));

			content1Press.add(lblSpanPres[i], "push");
			content1Press.add(jTxtSpanPres[i], "push");
			content1Press.add(lblBtnSpanPres[i], "grow, push, wrap");
		}
		content1Press.setBorder(etchedLoweredBorder);
		this.add(content1Press, "pushx, grow");
		//--------------------------------------------------------------------//

		//--------------------------------------------------------------------//
		JPanel content1OffPress = new JPanel(new MigLayout("", //"",""));
				"[min!][fill, 15%!][min!]", ""));
		for (int i = 0; i<NUM_PRESSURES; i++) {
			lblOffPres[i] = new JLabel("Offset pressure sensor "+(i+1) 
					+ " [bar]:");
			jTxtOffPres[i] = new JTextField();
			jTxtOffPres[i].setEnabled(false);
			lblBtnOffPres[i] = new JLabel(
					new ImageIcon(String.valueOf(evtDI)));

			content1OffPress.add(lblOffPres[i], "push");
			content1OffPress.add(jTxtOffPres[i], "push");
			content1OffPress.add(lblBtnOffPres[i], "grow, push, wrap");
		}
		content1OffPress.setBorder(etchedLoweredBorder);
		this.add(content1OffPress, "pushx, grow, wrap");
		//--------------------------------------------------------------------//
		
		//--------------------------------------------------------------------//
		JPanel content2 = new JPanel(new MigLayout("", 
				"[min!][fill, 15%!]", ""));
//		lblRunApply[0] = new JLabel("Run inputs calibration");
//		checkRunApply[0] = new JCheckBox();
//
//		lblRunApply[1] = new JLabel("Apply calibration");
//		checkRunApply[1] = new JCheckBox();
//
//		content2.add(lblRunApply[0], "grow, ");
//		content2.add(checkRunApply[0], "grow, , wrap");
//
//		content2.add(lblRunApply[1], "grow, ");
//		content2.add(checkRunApply[1], "grow, wrap");

//		content2.setBorder(etchedLoweredBorder);
		this.add(content2, "pushx, grow");
		//--------------------------------------------------------------------//
		
		//--------------------------------------------------------------------//
		// content 3
		JPanel content3 = new JPanel(new MigLayout("", "[][fill, 15%!][]",
				""));
		for (int i = 0; i<NUM_SPAN; i++) {
			lblSpan[i] = new JLabel();
			jTxtSpane[i] = new JTextField();
			jTxtSpane[i].setEnabled(false);

			lblBtnSpan[i] = new JLabel(new ImageIcon(String.valueOf(evtDI)));
			content3.add(lblSpan[i], "grow");
			content3.add(jTxtSpane[i], "grow");
			content3.add(lblBtnSpan[i], "grow, wrap");
		}
		lblSpan[0].setText("Span sled accelerometer [16 bit to m/s²]:");
		lblSpan[1].setText("Span rod accelerometer [16 bit to m/s²]:");
		lblSpan[2].setText("Span L air pressure [16 bits to bar]:");


		content3.setBorder(etchedLoweredBorder);
		this.add(content3, "pushx, grow");
		//--------------------------------------------------------------------//
		
		//--------------------------------------------------------------------//
		// content 4
		JPanel content4 = new JPanel(new MigLayout("", "[][fill, 15%!][]",
				""));
		for (int i = 0; i<NUM_OFFSET; i++) {
			lblOffset[i] = new JLabel();
			jTxtOffset[i] = new JTextField();
			jTxtOffset[i].setEnabled(false);

			lblBtnOffset[i] = new JLabel(new ImageIcon(String.valueOf(evtDI)));
			content4.add(lblOffset[i], "grow");
			content4.add(jTxtOffset[i], "grow");
			content4.add(lblBtnOffset[i], "grow, wrap");
		}
		lblOffset[0].setText("Offset sled accelerometer [m/s²]:");
		lblOffset[1].setText("Offset rod accelerometer [m/s²]:");
		lblOffset[2].setText("Offset L air pressure [bar]:");
		content4.setBorder(etchedLoweredBorder);
		this.add(content4, "pushx, grow, wrap");
		//--------------------------------------------------------------------//

	}
}
