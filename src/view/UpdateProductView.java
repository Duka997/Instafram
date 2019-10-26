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
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import controllers.ProductController;
import gui.MainFrame;
import model.Product;

@SuppressWarnings("serial")
public class UpdateProductView extends JPanel{

	private Product product;
	private ProductController productController;
	
	private JPanel pnlContent;
	private JLabel lblNazivProizvoda;
	private JTextField tfNazivProizvoda;
	private JLabel lblVerzijaProizovda;
	private JTextField tfVerzijaProizovda;
	private JLabel lblbrojCasova;
	private JTextField tfbrojCasova;
	
	private JLabel lblLogo;
	private JButton btnUploadLogo;
	private JButton btnDeleteLogo;
	
	private JPanel pnlUpdateOrCancel;
	private JButton btnUpdate;
	private JButton btnCancel;
	
	public static String ProductNameConfig;
	
	public UpdateProductView(DefaultMutableTreeNode node) {
		initGUI();
		constructGUI();
		
		Product nodeU=(Product) node.getUserObject();
		product=nodeU;
		
		tfNazivProizvoda.setText(product.getNazivProizvoda());
		tfVerzijaProizovda.setText(product.getVerzijaProizvoda());
		tfbrojCasova.setText(product.getUtrosenBrojCasova());
		lblLogo.setIcon(product.getProductImage());
	}
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		pnlContent = new JPanel(new GridBagLayout());

		lblNazivProizvoda = new JLabel("Naziv prozivoda");
		tfNazivProizvoda = new JTextField(20);

		lblVerzijaProizovda = new JLabel("Verzija proizvoda");
		tfVerzijaProizovda = new JTextField(20);

		lblbrojCasova = new JLabel("Broj utrosenih casova");
		tfbrojCasova = new JTextField(20);
		
		lblLogo = new JLabel();
		lblLogo.setBorder(BorderFactory.createLoweredBevelBorder());
		lblLogo.setPreferredSize(new Dimension(126, 85));
		
		btnUploadLogo = new JButton("Ubaci sliku");
		btnUploadLogo.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				UploadLogo();
			}
		});

		btnDeleteLogo = new JButton("Ukloni sliku");
		btnDeleteLogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteLogo();
			}
		});	
		
		btnUpdate = new JButton("Azuriraj");
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		pnlUpdateOrCancel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnCancel = new JButton("Cancel");
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
		pnlContent.add(lblVerzijaProizovda, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfVerzijaProizovda, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblbrojCasova, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfbrojCasova, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblLogo, new GridBagConstraints(0, 8, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(15, 5, 5, 5), 0, 0));
		pnlContent.add(btnDeleteLogo, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(btnUploadLogo, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		pnlUpdateOrCancel.add(btnUpdate);
		pnlUpdateOrCancel.add(btnCancel);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlUpdateOrCancel, BorderLayout.SOUTH);
		

	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product Product) {
		this.product = Product;
		Product = null;
	}
	
	public static String getImeProizvoda() {
		return ProductNameConfig;
	}
	
	private void UploadLogo() {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
			lblLogo.setIcon(icon);
		}
	}
	
	private void DeleteLogo() {
		lblLogo.setIcon(null);
	}
	
	private void update() {
		if (productController == null) {
			productController = new ProductController(product, this);
		}
		
		String ProductName = tfNazivProizvoda.getText();
		ProductNameConfig = ProductName;
		String VerzijaProizovda = tfVerzijaProizovda.getText();
		String brojCasova = tfbrojCasova.getText();
		ImageIcon photo = null;
		if (lblLogo.getIcon() != null) {
			photo = ((ImageIcon) lblLogo.getIcon());
		}

		String message = productController.updateProduct(ProductName, VerzijaProizovda,brojCasova, photo);
		
		Window parent = SwingUtilities.getWindowAncestor(this);
		
		if (message == "Uspesno dodato") {
			JOptionPane.showMessageDialog(parent, "Proizvoda je azuriran");
		}else {
			JOptionPane.showMessageDialog(parent, message);
		}
		
		MainFrame.getInstance().getTree().revalidate();
		
	}

}
