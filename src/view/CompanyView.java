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

import controllers.CompanyController;
import gui.MainFrame;
import model.Company;
import model.Node;


@SuppressWarnings("serial")
public class CompanyView extends JPanel{

	private Company company;
	private CompanyController companyController;

	private JPanel pnlContent;
	private JLabel lblImeKompanije;
	private JTextField tfImeKompanije;
	private JLabel lblSediste;
	private JTextField tfSediste;
	private JLabel lblBrojZaposlenih;
	private JTextField tfBrojZaposlenih;
	
	private JPanel pnlOK;
	private JButton btnOK;
	private JButton btnCancel;
	
	public CompanyView() {
		initGUI();
		constructGUI();
		
		company=new Company();
	}

	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());

		lblImeKompanije = new JLabel(MainFrame.getInstance().getResourceBundle().getString("imeKompanije"));
		tfImeKompanije = new JTextField(20);

		lblSediste = new JLabel(MainFrame.getInstance().getResourceBundle().getString("sediste"));
		tfSediste = new JTextField(20);

		lblBrojZaposlenih = new JLabel(MainFrame.getInstance().getResourceBundle().getString("brZaposlenih"));
		tfBrojZaposlenih = new JTextField(20);

		btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
			}
		});
		

		pnlOK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK = new JButton(MainFrame.getInstance().getResourceBundle().getString("dodaj"));
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dodaj();
			}
		});
	}
	
	private void constructGUI() {
		pnlContent.add(lblImeKompanije, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfImeKompanije, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblSediste, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfSediste, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblBrojZaposlenih, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfBrojZaposlenih, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		

		pnlOK.add(btnOK);
		pnlOK.add(btnCancel);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlOK, BorderLayout.SOUTH);

	}

	@SuppressWarnings("unused")
	private void setCompany(Company company) {
		this.company = company;
		companyController = null;
	 }

	public Company getCompany() {
		return company;
	}

	private void dodaj() {
		if (companyController == null) {
			companyController = new CompanyController(company, this);
		}
		String ImeKompanije = tfImeKompanije.getText();
		String Sediste = tfSediste.getText();
		String Owner = tfBrojZaposlenih.getText();

		String message = companyController.updateCompany(ImeKompanije, Sediste, Owner);

		Window parent = SwingUtilities.getWindowAncestor(this);
		
		if (message == MainFrame.getInstance().getResourceBundle().getString("uspesnoDodato")) {
			DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
					.getInstance().getTree().getLastSelectedPathComponent();
			if (parentNodeView == null) {
				message = MainFrame.getInstance().getResourceBundle().getString("selektujteCvor");
			}else {
				Object InfRoot=parentNodeView.getUserObject();
				if (InfRoot instanceof Node) {
				Node parentNodeModel = (Node)parentNodeView.getUserObject();
				
				parentNodeModel.addChildren(company);
				DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(company);
				
				DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
				model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
				// selekcija novododatog cvora
				JTree tree = MainFrame.getInstance().getTree();
				tree.setSelectionPath(new TreePath(childNodeView.getPath()));
				tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
				
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
			}else {
				message=MainFrame.getInstance().getResourceBundle().getString("neMozeteDodatiKompaniju");
			}
		}
		}
		JOptionPane.showMessageDialog(parent, message);
	}

}
