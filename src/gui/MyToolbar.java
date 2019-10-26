package gui;

import java.awt.BorderLayout;
import java.util.ResourceBundle;

import javax.swing.JToolBar;

import actions.AddCompany;
import actions.AddParameter;
import actions.AddProduct;
import actions.ConfigAction;
import actions.DeleteNode;
import actions.OpenAction;
import actions.SaveAction;

@SuppressWarnings("serial")
public class MyToolbar extends JToolBar{
	
	public MyToolbar(ResourceBundle resourceBundle) {
		
		JToolBar tb = new JToolBar();

		tb.add(new AddCompany(resourceBundle));
		tb.add(new AddProduct(resourceBundle));
		tb.add(new AddParameter(resourceBundle));
		tb.add(new DeleteNode(resourceBundle));
		tb.addSeparator();
		tb.add(new SaveAction(resourceBundle));
		tb.add(new OpenAction(resourceBundle));
		tb.addSeparator();
		tb.add(new ConfigAction(resourceBundle));
		
		add(tb, BorderLayout.NORTH);
		
	}

}