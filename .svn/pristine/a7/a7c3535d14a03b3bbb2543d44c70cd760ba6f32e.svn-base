package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import controllers.ProductController;
import gui.MainFrame;
import model.Company;
import model.Product;

@SuppressWarnings("serial")
public class ProductView extends JPanel{

	private Product product;
	private ProductController productController;
	
	private JPanel pnlContent;
	private JLabel lblNazivProizvoda;
	private JTextField tfNazivProizvoda;
	private JLabel lblVerzijaProizvoda;
	private JTextField tfVerzijaProizvoda;
	private JLabel lblBrojCasova;
	private JTextField tfBrojCasova;
	
	private JLabel lblPhoto;
	private JButton btnUploadPhoto;
	private JButton btnDeletePhoto;
	
	private JPanel pnlOkOrCancel;
	private JButton btnOk;
	private JButton btnCancel;
	
	public static String ProductNameConfig;
	
	public ProductView() {
		initGUI();
		constructGUI();
		
		product = new Product();
	}
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		pnlContent = new JPanel(new GridBagLayout());

		lblNazivProizvoda = new JLabel(MainFrame.getInstance().getResourceBundle().getString("nazivProizvoda"));
		tfNazivProizvoda = new JTextField(20);

		lblVerzijaProizvoda = new JLabel(MainFrame.getInstance().getResourceBundle().getString("verzija"));
		tfVerzijaProizvoda = new JTextField(20);

		lblBrojCasova = new JLabel(MainFrame.getInstance().getResourceBundle().getString("brRadnihSati"));
		tfBrojCasova = new JTextField(20);
		
		lblPhoto = new JLabel();
		lblPhoto.setBorder(BorderFactory.createLoweredBevelBorder());
		lblPhoto.setPreferredSize(new Dimension(126, 85));
		
		
		btnUploadPhoto = new JButton(MainFrame.getInstance().getResourceBundle().getString("dodajSliku"));
		btnUploadPhoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uploadPhoto();
			}
		});

		btnDeletePhoto = new JButton(MainFrame.getInstance().getResourceBundle().getString("ukloniSliku"));
		btnDeletePhoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deletePhoto();
			}
		});
		
		
		
		btnOk = new JButton(MainFrame.getInstance().getResourceBundle().getString("dodaj"));
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dodaj();
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
	}

	private void constructGUI() {
		pnlContent.add(lblNazivProizvoda, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfNazivProizvoda, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblVerzijaProizvoda, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfVerzijaProizvoda, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblBrojCasova, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfBrojCasova, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblPhoto, new GridBagConstraints(0, 8, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(15, 5, 5, 5), 0, 0));
		pnlContent.add(btnDeletePhoto, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(btnUploadPhoto, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		pnlOkOrCancel.add(btnOk);
		pnlOkOrCancel.add(btnCancel);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlOkOrCancel, BorderLayout.SOUTH);
		

	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product Product) {
		this.product = Product;
		Product = null;
	}
	
	private void uploadPhoto() {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
			lblPhoto.setIcon(icon);;
		}
	}

	private void deletePhoto() {
		lblPhoto.setIcon(null);
	}
	
	private void dodaj() {
		if (productController == null) {
			productController = new ProductController(product, this);
		}

		String ProductName = tfNazivProizvoda.getText();
		ProductNameConfig = tfNazivProizvoda.getText();
		String VerzijaProizvoda = tfVerzijaProizvoda.getText();
		String BrojCasova = tfBrojCasova.getText();
		ImageIcon photo = null;
		if (lblPhoto.getIcon() != null) {
			photo =  (ImageIcon) lblPhoto.getIcon();
		}
		
		String message = productController.updateProduct(ProductName, VerzijaProizvoda,BrojCasova, photo);
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		if (message == "Uspesno dodato") {
			DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
					.getInstance().getTree().getLastSelectedPathComponent();
			if (parentNodeView == null) {
				message = "Morate izabrati cvor";
			}else {
				Object InfRoot=parentNodeView.getUserObject();
				if (InfRoot instanceof Company) {
				Company parentNodeModel = (Company)parentNodeView.getUserObject();
				
				parentNodeModel.addChildren(product);
				DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(product);
				
				DefaultTreeModel model = MainFrame.getInstance().getTreeModel();
				model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
				//selektujemo novi cvor
				JTree tree = MainFrame.getInstance().getTree();
				tree.setSelectionPath(new TreePath(childNodeView.getPath()));
				tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
				
				MainFrame.removefrompanCenter();
				SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
				}else {
					message="Morate izabrati kompaniju";
				}
			}
		}
		
		JOptionPane.showMessageDialog(parent, message);
		
	}
	
	public static String getImeProizvoda() {
		return ProductNameConfig;
	}
}
