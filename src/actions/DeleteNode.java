package actions;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.AbstractAction;

import model.Company;
import model.Node;
import model.Product;
import model.Parameter;
import gui.MainFrame;

@SuppressWarnings("serial")
public class DeleteNode extends AbstractAction{

	public DeleteNode(ResourceBundle resourceBundle) {
		putValue(NAME, resourceBundle.getString("obrisi"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, resourceBundle.getString("obrisiCvor"));
		putValue(SMALL_ICON, new ImageIcon());
		putValue(ACCELERATOR_KEY, 
				KeyStroke.getKeyStroke(
						KeyEvent.VK_D, 
						KeyEvent.CTRL_MASK));
		putValue(LARGE_ICON_KEY, new ImageIcon("images/delete.png"));
		putValue(SMALL_ICON, new ImageIcon("images/delete.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String message = "Greska";

		Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());

		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (childNodeView == null) {
			message = MainFrame.getInstance().getResourceBundle().getString("cvorBrisanje");
		}else {
			Object nodeInfo = childNodeView.getUserObject();
			if(nodeInfo instanceof Node) {
				message = MainFrame.getInstance().getResourceBundle().getString("greskaBrisanje");
			}else if(nodeInfo instanceof Company) {
				Company company = (Company)childNodeView.getUserObject();
				company.removeFromParent();
				MainFrame.getInstance().getTreeModel().removeNodeFromParent(childNodeView);
				message = MainFrame.getInstance().getResourceBundle().getString("uspesnoBrisanje") + "'"+company+"'";
			}else if(nodeInfo instanceof Product) {
				Product product = (Product)childNodeView.getUserObject();
				product.removeFromParent();
				MainFrame.getInstance().getTreeModel().removeNodeFromParent(childNodeView);
				message = MainFrame.getInstance().getResourceBundle().getString("uspesnoBrisanje") + "'"+product+"'";
			}else if(nodeInfo instanceof Parameter) {
				Parameter parameter = (Parameter)childNodeView.getUserObject();
				parameter.removeFromParent();
				MainFrame.getInstance().getTreeModel().removeNodeFromParent(childNodeView);
				message = MainFrame.getInstance().getResourceBundle().getString("uspesnoBrisanje") + "'"+parameter+"'";
			}
		}
		JOptionPane.showMessageDialog(parent, message);	
	}
}
