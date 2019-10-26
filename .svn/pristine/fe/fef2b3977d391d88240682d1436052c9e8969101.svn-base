package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import gui.OpenDialog;

public class OpenAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	public OpenAction(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("otvori"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("otvoriFajl"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_O, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/open.png"));
		putValue(SMALL_ICON, new ImageIcon("images/open.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			new OpenDialog();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
