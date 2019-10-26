package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import controllers.ParameterController;
import gui.MainFrame;
import model.Parameter;

@SuppressWarnings("serial")
public class UpdateParameterView extends JPanel{


	private Parameter parameter;
	private ParameterController parameterController;
	
	private JPanel pnlContent;
	private JLabel lblNazivParametra;
	private JTextField tfNazivParametra;
	private JLabel lblVrednostParametra;
	private JTextField tfVrednostParametra;
	
	private JPanel pnlUpdateOrCancel;
	private JButton btnUpdate;
	private JButton btnCancel;
	
	public UpdateParameterView(DefaultMutableTreeNode node) {
		initGUI();
		constructGUI();
		
		Parameter nodeU=(Parameter) node.getUserObject();
		parameter=nodeU;
		
		tfNazivParametra.setText(parameter.getNazivParametra());
		tfVrednostParametra.setText(parameter.getVrednostParametra());
		
	}
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		pnlContent = new JPanel(new GridBagLayout());

		lblNazivParametra = new JLabel(MainFrame.getInstance().getResourceBundle().getString("nazivParametra"));
		tfNazivParametra = new JTextField(20);

		lblVrednostParametra = new JLabel(MainFrame.getInstance().getResourceBundle().getString("vrParametra"));
		tfVrednostParametra = new JTextField(20);
		
		btnUpdate = new JButton(MainFrame.getInstance().getResourceBundle().getString("azuriraj"));
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		pnlUpdateOrCancel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
				
			}
		});
	}

	private void constructGUI() {
		pnlContent.add(lblNazivParametra, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfNazivParametra, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblVrednostParametra, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfVrednostParametra, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlUpdateOrCancel.add(btnUpdate);
		pnlUpdateOrCancel.add(btnCancel);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlUpdateOrCancel, BorderLayout.SOUTH);
	}
	
	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter Parameter) {
		this.parameter = Parameter;
		Parameter = null;
	}
	
	private void update() {
		if (parameterController == null) {
			parameterController = new ParameterController(parameter, this);
		}
		
		
		String NazivParametra = tfNazivParametra.getText();
		String VrednostParametra = tfVrednostParametra.getText();
	
		String message = parameterController.updateParameter(NazivParametra, VrednostParametra);
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		if (message == "Uspesno dodato") 
		{
			JOptionPane.showMessageDialog(parent, "Parametar je uspesno dodat");
		}else {
			JOptionPane.showMessageDialog(parent, message);
		}

		MainFrame.getInstance().getTree().revalidate();
		
	}
	
}
