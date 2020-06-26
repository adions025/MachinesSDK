package view;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class InputOutput extends JPanel {

	private ResourceBundle bundle = ResourceBundle.getBundle(
			"res/lan/view/InputOutput");
	private JScrollPane general;
	private static final int TOTAL_READINESS = 5;
	private static final int TOTAL_TRIGGERS = 12;
	private static final int TOTAL_SIEMENS = 5;

	private JLabel[] lblReadi = new JLabel[TOTAL_READINESS];
	private JLabel[] lblEvtReadi = new JLabel[TOTAL_READINESS];

	private final JLabel[] lblTrigger = new JLabel[TOTAL_TRIGGERS];
	private final JCheckBox[] checkTrigger = new JCheckBox[TOTAL_TRIGGERS];

	private JLabel[] lblSiemens = new JLabel[TOTAL_SIEMENS];
	private final JCheckBox[] checkSiemens= new JCheckBox[TOTAL_SIEMENS];

	private ControlActuator hyperG;

	public InputOutput() {
		initComponents();
	}

	private void initComponents() {
		this.setLayout(new MigLayout("", "[fill,5%][fill,80%]", "0[]"));
		general = new JScrollPane(new JPanel(new MigLayout("", "[]")));
		general.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		//just icons for labels DI
		String filePathTmp = new File("").getAbsolutePath();
		Path evtDI = Paths.get(filePathTmp, File.separatorChar + "assets" + 
				File.separatorChar + "icons" + File.separatorChar + "22x22"+
				File.separatorChar + "actions" + File.separatorChar + 
				"green.png").normalize();

		for (int i = 0; i<TOTAL_READINESS; i++) {
			lblReadi[i] = new JLabel(bundle.getString("readiInput")+ " "+ 
					(i+1) + ":");
			((JPanel)general.getViewport().getView()).add(lblReadi[i], "");

			lblEvtReadi[i] = new JLabel();
			lblEvtReadi[i].setIcon(new ImageIcon(String.valueOf(evtDI)));
			((JPanel)general.getViewport().getView()).add(lblEvtReadi[i], 
					"wrap");
		}

		for (int i = 0; i<TOTAL_TRIGGERS; i++) {
			lblTrigger[i] = new JLabel(bundle.getString("trigger")+ " "+ 
					(i+1)+ ":");
			((JPanel)general.getViewport().getView()).add(lblTrigger[i], "");

			checkTrigger[i] = new JCheckBox();
			((JPanel)general.getViewport().getView()).add(checkTrigger[i], 
					"wrap");
		}

		lblSiemens[0] = new JLabel(bundle.getString("lightOn")+ ":");
		lblSiemens[1] = new JLabel(bundle.getString("LightBoost")+ ":");
		lblSiemens[2] = new JLabel(bundle.getString("CautionSignal") + " "+
				1 + ":");
		lblSiemens[3] = new JLabel(bundle.getString("CautionSignal") + " "+
				2+ ":");
		lblSiemens[4] = new JLabel(bundle.getString("CautionAcustic") + ":");

		for (int i = 0; i<TOTAL_SIEMENS; i++) {
			((JPanel)general.getViewport().getView()).add(lblSiemens[i], 
					"");

			checkSiemens[i] = new JCheckBox();
			((JPanel)general.getViewport().getView()).add(checkSiemens[i], 
					"wrap");
		}
		
		JButton btnRunStop = new JButton("Start");
		
		//first vertical panel for general in out
		JPanel content = new JPanel(new MigLayout("", "[]", "[][]"));
		content.add(general, "grow, push, wrap");
		content.add(btnRunStop);

		Border etchedLoweredBorder = 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		content.setBorder(etchedLoweredBorder);
		this.add(content, "push, grow");

		//second vertical panel
		JTabbedPane content2 = new JTabbedPane();
		//content2.setBorder(etchedLoweredBorder);
		hyperG = new ControlActuator();
		content2.add("HyperG",hyperG);
		this.add(content2, "push, grow, wrap");
	}

}