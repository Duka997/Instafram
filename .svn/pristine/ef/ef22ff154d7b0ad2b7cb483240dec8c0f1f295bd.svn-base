package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import view.ProductView;

@SuppressWarnings("serial")
public class AddProduct extends AbstractAction {
	
	public AddProduct(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("produkt"));
		//putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("noviProdukt"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_2, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/product.png"));
		putValue(SMALL_ICON, new ImageIcon("images/product.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Frame za kompaniju
		MainFrame.removefrompanCenter();
		ProductView scv = new ProductView();
		MainFrame.addinpanCenter(scv);
		SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
	}
}


