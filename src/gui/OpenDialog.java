package gui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//import javax.swing.JFileChooser;
import javax.swing.tree.DefaultTreeModel;

public class OpenDialog {
	
	//private static String novaAdresa;
	//private static File fajl;
	
	public OpenDialog() throws ClassNotFoundException, IOException {
		
		//bira koji workspace ce se otvoriti
		/*JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Izaberite fajl koji zelite da ucitate");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);
		
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			fajl = chooser.getSelectedFile();
			novaAdresa = fajl.getAbsolutePath();
		}*/
		
		//File f = new File(novaAdresa);
		File f = new File("workspace.wor");

		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		Object in = ois.readObject();
		ois.close();

		MainFrame.getInstance().setTreeModel((DefaultTreeModel) in);
		
	}
}
