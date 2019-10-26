package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CloseAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	public CloseAction(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("zatvori"));
		//putValue(MNEMONIC_KEY, KeyEvent.VK_L);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("zatvoriProgram"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_X, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/close.png"));
		putValue(SMALL_ICON, new ImageIcon("images/close.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}