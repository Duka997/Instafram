package gui;

import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.About;
import actions.AddCompany;
import actions.AddParameter;
import actions.AddProduct;
import actions.CloseAction;
import actions.ConfigAction;
import actions.DeleteNode;
import actions.Help;
import actions.OpenAction;
import actions.SaveAction;

/*
 * Menu bar koji sadrzi osnovne funkcije
 * */

@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar{
	
	public MyMenuBar (ResourceBundle resourceBundle) {
		
		JMenu file = new JMenu(resourceBundle.getString("fajl"));
		JMenu miNew = new JMenu(resourceBundle.getString("novo"));
		AddCompany cda = new AddCompany(resourceBundle);
		miNew.add(cda);
		AddProduct cda2 = new AddProduct(resourceBundle);
		miNew.add(cda2);
		AddParameter cda3 = new AddParameter(resourceBundle);
		miNew.add(cda3);
		
		OpenAction open = new OpenAction(resourceBundle);
		SaveAction save = new SaveAction(resourceBundle);
		CloseAction close = new CloseAction(resourceBundle);

		JMenuItem miOpen = new JMenuItem(open);
		JMenuItem miSave = new JMenuItem(save);
		JMenuItem miClose = new JMenuItem(close);
		
		file.add(miNew);
		file.addSeparator();
		file.add(miOpen);
		file.add(miSave);
		file.addSeparator();
		file.add(miClose);
		
		JMenu edit=new JMenu(resourceBundle.getString("izmeni"));
		//Brisanje cvora
		DeleteNode cda4 = new DeleteNode(resourceBundle);
		edit.add(cda4);
		
		JMenu tools=new JMenu(resourceBundle.getString("alat"));
		ConfigAction config = new ConfigAction(resourceBundle);
		JMenuItem miConfig = new JMenuItem(config);
		tools.add(miConfig);
		
		
		JMenu help = new JMenu(new Help(resourceBundle));
		help.add(new About(resourceBundle));
		
		add(file);
		add(edit);
		add(tools);
		add(help);
		
	}

}
