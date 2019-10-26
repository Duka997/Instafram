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

import controllers.CompanyController;
import gui.MainFrame;
import model.Company;

@SuppressWarnings("serial")
public class UpdateCompanyView extends JPanel{

	private Company company;
	private CompanyController companyController;

	private JPanel pnlContent;
	private JLabel lblImeKompanije;
	private JTextField tfImeKompanije;
	private JLabel lblSediste;
	private JTextField tfSediste;
	private JLabel lblBrojZaposlenihr;
	private JTextField tfBrojZaposlenihr;
	
	private JPanel pnlUpdate;
	private JButton btnUpdate;
	private JButton btnCancel;
	
	public UpdateCompanyView(DefaultMutableTreeNode node) {
		initGUI();
		constructGUI();
		
		Company nodeU=(Company) node.getUserObject();
		company=nodeU;
		
		tfImeKompanije.setText(company.getImeKompanije());
		tfSediste.setText(company.getSediste());
		tfBrojZaposlenihr.setText(company.getBrojZaposlenih());
	}

	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());

		lblImeKompanije = new JLabel(MainFrame.getInstance().getResourceBundle().getString("imeKompanije"));
		tfImeKompanije = new JTextField(20);

		lblSediste = new JLabel(MainFrame.getInstance().getResourceBundle().getString("sediste"));
		tfSediste = new JTextField(20);

		lblBrojZaposlenihr = new JLabel(MainFrame.getInstance().getResourceBundle().getString("brZaposlenih"));
		tfBrojZaposlenihr = new JTextField(20);

		btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
			}
		});
		

		pnlUpdate = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnUpdate = new JButton(MainFrame.getInstance().getResourceBundle().getString("azuriraj"));
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
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
		pnlContent.add(lblBrojZaposlenihr, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfBrojZaposlenihr, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		

		pnlUpdate.add(btnUpdate);
		pnlUpdate.add(btnCancel);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlUpdate, BorderLayout.SOUTH);

	}

	@SuppressWarnings("unused")
	private void setCompany(Company company) {
		this.company = company;
		companyController = null;
	}

	public Company getCompany() {
		return company;
	}

	private void update() {
		if (companyController == null) {
			companyController = new CompanyController(company, this);
		}
		String ImeKompanije = tfImeKompanije.getText();
		String Sediste = tfSediste.getText();
		String BrojZaposlenih = tfBrojZaposlenihr.getText();

		String message = companyController.updateCompany(ImeKompanije, Sediste, BrojZaposlenih);

		Window parent = SwingUtilities.getWindowAncestor(this);
		
		if (message == MainFrame.getInstance().getResourceBundle().getString("uspesnoDodato")) {
			JOptionPane.showMessageDialog(parent, MainFrame.getInstance().getResourceBundle().getString("uspesnoAzurirano"));
		}else {
			JOptionPane.showMessageDialog(parent, message);
		}
		
		MainFrame.getInstance().getTree().revalidate();
	}
}
