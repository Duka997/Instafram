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
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import controllers.ParameterController;
import gui.MainFrame;
import model.Parameter;
import model.Product;

@SuppressWarnings("serial")
public class ParameterView extends JPanel{

	private Parameter parameter;
	private ParameterController parameterController;
	private JPanel pnlContent;

	private JButton btnOk;
	private JButton btnCancel;
	private JPanel pnlOkOrCancel;
	
	private JLabel lblNazivParametra;
	private JTextField tfNazivParametra;
	private JLabel lblVrednostParametra;
	private JTextField tfVrednostParametra;
	
	private static String nazivParametra;
	private static String vrednostParametra;
	
	public ParameterView() {
		
		setLayout(new BorderLayout());
		
		pnlContent = new JPanel(new GridBagLayout());

		lblNazivParametra = new JLabel(MainFrame.getInstance().getResourceBundle().getString("nazivParametra"));
		tfNazivParametra = new JTextField(20);

		lblVrednostParametra = new JLabel(MainFrame.getInstance().getResourceBundle().getString("vrParametra"));
		tfVrednostParametra = new JTextField(20);
		
		btnOk = new JButton(MainFrame.getInstance().getResourceBundle().getString("dodaj"));
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		
		pnlOkOrCancel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
				
			}
		});
		
		//konstrukcija gui
		parameter = new Parameter();
		
		pnlContent.add(lblNazivParametra, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfNazivParametra, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblVrednostParametra, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfVrednostParametra, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlOkOrCancel.add(btnOk);
		pnlOkOrCancel.add(btnCancel);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlOkOrCancel, BorderLayout.SOUTH);
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter Parameter) {
		this.parameter = Parameter;
		Parameter = null;
	}
	
	private void ok() {
		if (parameterController == null) {
			parameterController = new ParameterController(parameter, this);
		}
		
		
		String NazivParametra = tfNazivParametra.getText();
		String VrednostParametra = tfVrednostParametra.getText();
		
		nazivParametra = NazivParametra;
		vrednostParametra = VrednostParametra;
	
		String message = parameterController.updateParameter(NazivParametra, VrednostParametra);
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		if (message == "Uspesno dodato") {
			DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
					.getInstance().getTree().getLastSelectedPathComponent();
			if (parentNodeView == null) {
				message = "Morate da selektujete cvor kako bi ste dodali novi parametar";
			}else {
				Object InfRoot=parentNodeView.getUserObject();
				if (InfRoot instanceof Product) {
				Product parentNodeModel = (Product)parentNodeView.getUserObject();
				
				parentNodeModel.addChildren(parameter);
				DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(parameter);
				
				DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
				model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
				// selekcija novododatog cvora
				JTree tree = MainFrame.getInstance().getTree();
				tree.setSelectionPath(new TreePath(childNodeView.getPath()));
				tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
				
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
				} 
				else if(InfRoot instanceof Parameter) {
					
					Parameter parentNodeModel = (Parameter)parentNodeView.getUserObject();
					
					parentNodeModel.addChildren(parameter);
					DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(parameter);
					
					DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					// ovde se selektuje novi cvor
					JTree tree = MainFrame.getInstance().getTree();
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					
					MainFrame.removefrompanCenter();
					SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());	
				}
				else {
					message="Morate da selektujete cvor";
				}
			}
		}
		
		JOptionPane.showMessageDialog(parent, message);	
	}
	
	public static String getNazivParametra(){
		return nazivParametra;
	}
	
	public static String getVrednostParametra(){
		return vrednostParametra;
	}
}
