package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

public class Machine extends JFrame{

	private JButton jButtonAcceptar = new JButton("Accept");
	private final JButton jButtonCancelar = new JButton("Cancel");
	private JTabbedPane tabs = new JTabbedPane();
	private ResourceBundle bundle = ResourceBundle.getBundle(
			"res/lan/view/Machine");

	//tabs
	private InputOutput inOut;
	private InputsCalibration inCalibation;
	private ServoValve servo;
	private Object rTest;

	public Machine(Object rTest) {
		this.rTest = rTest;
		initComponents();
		initTabs();
	}

	private void initComponents() {
		this.setTitle(bundle.getString("control"));
		this.setLayout(new MigLayout("", "[]", "[98%][10%]"));
		this.add(tabs, "grow, push, wrap");

		JPanel buttons = new JPanel(new MigLayout("", "push[fill,120px]"
				+ "[fill,120px]0", "10[][]"));
		buttons.add(jButtonAcceptar, "gapbefore push, growx");
		buttons.add(jButtonCancelar, "gapbefore push, growx, wrap");

		this.add(buttons, "grow, push");
		jButtonAcceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonAcceptarActionPerformed(evt);
			}
		});
		jButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonCancelarActionPerformed(evt);
			}
		});
		String filePathTmp = new File("").getAbsolutePath();
		Path accept = Paths.get(filePathTmp, File.separatorChar + "icons" + 
				File.separatorChar + "22x22"
				+ File.separatorChar + "actions" + File.separatorChar + 
				"button_ok.png").normalize();
		Path cancel = Paths.get(filePathTmp, File.separatorChar + "icons" + 
				File.separatorChar + "22x22"
				+ File.separatorChar + "actions" + File.separatorChar + 
				"cancel.png").normalize();
		jButtonAcceptar.setIcon(new ImageIcon(String.valueOf(accept)));
		jButtonCancelar.setIcon(new ImageIcon(String.valueOf(cancel)));
		pack();
	}

	private void jButtonCancelarActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	private void jButtonAcceptarActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	private void initTabs() {
		inOut = new InputOutput(this, rTest);
		inCalibation = new InputsCalibration(this);
		servo = new ServoValve(this);

		tabs.add("Inputs-Outputs"
				+ ""
				+ "", inOut);
		tabs.add("Inputs calibration", inCalibation);
		tabs.add("Servovalve", servo);

	}

	public JTabbedPane getTabs() {
		return tabs;
	}

	public InputOutput getInOut() {
		return inOut;
	}

	public void setInOut(InputOutput inOut) {
		this.inOut = inOut;
	}

	public InputsCalibration getInCalibation() {
		return inCalibation;
	}

	public void setInCalibation(InputsCalibration inCalibation) {
		this.inCalibation = inCalibation;
	}

	public ServoValve getServo() {
		return servo;
	}

	public void setServo(ServoValve servo) {
		this.servo = servo;
	}
}
