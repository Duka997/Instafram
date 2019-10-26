package actions;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import gui.ConfigDialog;
import gui.MainFrame;
import model.Product;

@SuppressWarnings("serial")
public class ConfigAction extends AbstractAction{
	
	public ConfigAction(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("konfigurator"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("konfInst"));
		putValue(SMALL_ICON, new ImageIcon());
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_K, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/config.png"));
		putValue(SMALL_ICON, new ImageIcon("images/config.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String message = "Greska";
		Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());
		
		DefaultMutableTreeNode selectedProduct = (DefaultMutableTreeNode) MainFrame.getInstance().getTree()
				.getLastSelectedPathComponent();
		
		if(selectedProduct == null) {
			message = MainFrame.getInstance().getResourceBundle().getString("configGreska");
			JOptionPane.showMessageDialog(parent, message);
			return;
		}
		
		Object selObj = selectedProduct.getUserObject();
		if(selObj instanceof Product) {
			Product p = (Product) selObj;
			new ConfigDialog(MainFrame.getInstance().getResourceBundle().getString("configProduct") + p.getNazivProizvoda(), selectedProduct);
		} else {
			message = MainFrame.getInstance().getResourceBundle().getString("configGreska");
			JOptionPane.showMessageDialog(parent, message);
			return;
		}
	}
}
