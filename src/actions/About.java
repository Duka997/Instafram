package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import gui.MainFrame;

public class About extends AbstractAction {
	private static final long serialVersionUID = 535327605123994443L;

	public About(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("oProgramu"));
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("oProgramu"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(LARGE_ICON_KEY, new ImageIcon("images/help.png"));
		putValue(SMALL_ICON, new ImageIcon("images/help.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(MainFrame.getInstance(),
				MainFrame.getInstance().getResourceBundle().getString("pomocniDijalog"));

	}
}
