package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import gui.SaveDialog;

public class SaveAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	public SaveAction(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("sacuvaj"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_S);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("sacuvajSve"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_S, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/save.png"));
		putValue(SMALL_ICON, new ImageIcon("images/save.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			new SaveDialog();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}