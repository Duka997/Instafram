package listeners;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import gui.MainFrame;
import model.Company;
import model.Parameter;
import model.Product;
import view.UpdateCompanyView;
import view.UpdateParameterView;
import view.UpdateProductView;

public class TreeListener implements TreeSelectionListener{

	@Override
	public void valueChanged(TreeSelectionEvent ev) {
		update();
	}
	
	public static void update() {
		MainFrame.removefrompanCenter();
		DefaultMutableTreeNode node=(DefaultMutableTreeNode) MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (node==null) {
			return;
		}else {
			Object nodeInfo=node.getUserObject();
			if(nodeInfo instanceof Company) {
				UpdateCompanyView ucv=new UpdateCompanyView(node);
				MainFrame.addinpanCenter(ucv);
			}else if (nodeInfo instanceof Product) {
				UpdateProductView upv=new UpdateProductView(node);
				MainFrame.addinpanCenter(upv);
			}else if (nodeInfo instanceof Parameter) {
				UpdateParameterView upv=new UpdateParameterView(node);
				MainFrame.addinpanCenter(upv);
			}
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getPanCenter());
	}
}
