package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import gui.MainFrame;
import view.ParameterView;

@SuppressWarnings("serial")
public class AddParameter extends AbstractAction {
	
	public AddParameter(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("parametar"));
		//putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("noviParametar"));
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_3, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/parameter.jpg"));
		putValue(SMALL_ICON, new ImageIcon("images/parameter.jpg"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Frame za kompaniju
		MainFrame.removefrompanCenter();
		ParameterView scv = new ParameterView();
		MainFrame.addinpanCenter(scv);
		SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
	}
}


