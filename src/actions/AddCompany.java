package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import view.CompanyView;

@SuppressWarnings("serial")
public class AddCompany extends AbstractAction {
	
	public AddCompany(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("kompanija"));
		//putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("novaKompanija"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_1, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/company.png"));
		putValue(SMALL_ICON, new ImageIcon("images/company.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Frame za kompaniju
		MainFrame.removefrompanCenter();
		CompanyView scv = new CompanyView();
		MainFrame.addinpanCenter(scv);
		SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
	}
}


