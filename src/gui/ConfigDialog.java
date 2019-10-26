package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import actions.ExportAction;
import model.Product;

public class ConfigDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private DefaultTreeModel treeModel;
	private static JTree tree;

	private JPanel pan = new JPanel();
	private JDialog jd = new JDialog();
	private JPanel panLeft = new JPanel(new BorderLayout());
	private JPanel panRight = new JPanel(new GridBagLayout());
	private JPanel panBrowse = new JPanel();
	
	private JLabel lblIzvor;
	private JTextField tfIzvor;
	private JLabel lblWelecomeText;
	private JTextArea tfWelecomeText;
	private JLabel lblLicenca;
	private JTextArea tfLicenca;
	private JLabel lblVerzija;
	private JTextField tfVerzija;
	
	private static String putanja = "";
	private static File selectedFile;
	private static String zipFilePutanja = "";
	
	private static String welecomeText;
	private static String licenca;
	private static String verzija;
	
	private JPanel pnlOK;
	private JButton btnOK;
	private JButton btnCancel;
	private JButton btnBrowse;
	
	private static String imeProzivoda;
	
	public ConfigDialog(String ime, DefaultMutableTreeNode selectedProduct) {
		//uzima naziv proizovda
		Object selObj = selectedProduct.getUserObject();
		Product p = (Product) selObj;
		imeProzivoda = p.getNazivProizvoda();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		jd.setTitle(ime);
		jd.setSize((int)(screenSize.getWidth()*0.5), (int)(screenSize.getHeight()*0.5));
		jd.setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);
		
		pan.setLayout(new FlowLayout());
		pan.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.5), (int)(screenSize.getHeight()*0.5)));
		panRight.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.38), (int)(screenSize.getHeight()*0.5)));
		panLeft.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.12), (int)(screenSize.getHeight()*0.5)));

		lblIzvor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("izvorZip"));
		tfIzvor = new JTextField(putanja, 20);	
		
		lblWelecomeText = new JLabel(MainFrame.getInstance().getResourceBundle().getString("dobrodosli"));
		tfWelecomeText = new JTextArea(5, 20);
		JScrollPane scrollPane = 
			    new JScrollPane(tfWelecomeText,
			                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		lblLicenca = new JLabel(MainFrame.getInstance().getResourceBundle().getString("licenca"));
		tfLicenca = new JTextArea(5, 20);
		JScrollPane scrollPane2 = 
			    new JScrollPane(tfLicenca,
			                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		lblVerzija = new JLabel(MainFrame.getInstance().getResourceBundle().getString("verzija"));
		tfVerzija = new JTextField("1.0.0", 20);
		
		btnBrowse = new JButton("  ...  ");
		btnBrowse.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle(MainFrame.getInstance().getResourceBundle().getString("izaberiteZip"));
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					selectedFile = chooser.getSelectedFile();
					zipFilePutanja = selectedFile.toString();
					putanja = zipFilePutanja;
					tfIzvor.setText(putanja);
					tfIzvor.show();
				}
			}

		});
		panBrowse.add(btnBrowse);
		
		panRight.add(lblIzvor, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		panRight.add(tfIzvor, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		panRight.add(panBrowse, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 5, 5, 15), 0, 0));
		panRight.add(lblWelecomeText, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		panRight.add(scrollPane, new GridBagConstraints(1, 1, 2, 1, 100, 0, GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 15), 0, 0));
		panRight.add(lblLicenca, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		panRight.add(scrollPane2, new GridBagConstraints(1, 2, 2, 1, 100, 0, GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 15), 0, 0));
		panRight.add(lblVerzija, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		panRight.add(tfVerzija, new GridBagConstraints(1, 3, 2, 1, 100, 0, GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 15), 0, 0));
		
		btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jd.setVisible(false);
			}
		});
		
		initTree(selectedProduct);
		
		pnlOK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK = new JButton(MainFrame.getInstance().getResourceBundle().getString("export"));
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					welecomeText = tfWelecomeText.getText();
					licenca = tfLicenca.getText();
					verzija = tfVerzija.getText();
					export();
					jd.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}

			private void export() throws IOException, ClassNotFoundException {
				new ExportAction();
			}
		});
		
		pnlOK.add(btnOK);
		pnlOK.add(btnCancel);
		panRight.add(pnlOK, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		//sklapanje svega
		JScrollPane sp = new JScrollPane(tree);
		panLeft.add(BorderLayout.CENTER, sp);

		JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panLeft, panRight);
		pan.add(splitPanel, BorderLayout.CENTER);

		jd.add(pan);
		
		jd.pack();
		jd.setLocationRelativeTo(null);
		jd.setVisible(true);
	}
	
	private void initTree(DefaultMutableTreeNode p) {
		treeModel = new DefaultTreeModel(p);
		treeModel.setAsksAllowsChildren(true);
		tree = new JTree(treeModel) {
			private static final long serialVersionUID = -8692632059633011762L;
			@Override
			public boolean isPathEditable(TreePath path) {
				// Svi se mogu editovati sem root-a.
				if (path != null) {
					Object tn = path.getLastPathComponent();
					if (tn instanceof Product) {
						return false;
					}
					return true;
				}
				return false;
			}
		};
	}
	
	public static String getImeProizvoda() {
		return imeProzivoda;
	}
	
	public static String getVerzija() {
		return verzija;
	}
	
	public static String getLicenca() {
		return licenca;
	}
	
	public static String getWelecomeText() {
		return welecomeText;
	}
	
	public static File getFile() {
		return selectedFile;
	}
	
	public static String getZipFilePutanja() {
		return zipFilePutanja;
	}
	
	public static JTree getTree() {
		return tree;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		
	}
}
