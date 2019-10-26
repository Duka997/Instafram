package actions;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import gui.ConfigDialog;
import gui.MainFrame;
import model.Parameter;

@SuppressWarnings("serial")
public class ExportAction extends AbstractAction implements Serializable{
	
	public ExportAction() throws IOException, ClassNotFoundException{
		
		String message = "Greska";
		Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());
		
		JTree tree = ConfigDialog.getTree();
		
		//niz svih selektovanih putanja iz drveta ciji root je proizvod
		TreePath selectedPaths[] = tree.getSelectionPaths();
		//ako nije nista selektovano izbacuje poruku o tome
		if(selectedPaths == null) {
			message = MainFrame.getInstance().getResourceBundle().getString("selektGreska");
			JOptionPane.showMessageDialog(parent, message);
			return;
		}
		
		//provera da li je selektovan parametar
		for(int i = 0; i<selectedPaths.length; i++) {
			DefaultMutableTreeNode selPar = (DefaultMutableTreeNode) selectedPaths[i].getLastPathComponent();
			Object selObj = selPar.getUserObject();
			
			if(!(selObj instanceof Parameter)) {
				message = MainFrame.getInstance().getResourceBundle().getString("selektGreska");
				JOptionPane.showMessageDialog(parent, message);
				return;
			}
		}
		
		//pravi novi fajl za upis kljuca i njegove vrednosti
		File f = new File("properties.txt");
		f.createNewFile();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		
		Properties pr = new Properties();
		//svaka putanja se kastuje u DefaultMutableTreeNode i iz userObjecta se uzimaju naziv i vrednost
		for(int i = 0; i<selectedPaths.length; i++) {
			Object selParam = selectedPaths[i].getLastPathComponent();
			DefaultMutableTreeNode b = (DefaultMutableTreeNode) selParam;
			
			String nazivParametra = b.getUserObject().toString();
			String vrednostParametra = "";
			//refleksija
			Object objekat = b.getUserObject();
			for(Field field : objekat.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(objekat);
					if(value != null) {
						if(field.getName() == "VrednostParametra")
							vrednostParametra = (String)value;
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}			
			}
			
			pr.setProperty(nazivParametra, vrednostParametra);
			try {
				writer.write(nazivParametra);
				writer.write(" = ");
				writer.write(vrednostParametra);
				writer.newLine();
			} finally {
				
			}
		}
		writer.close(); //zatvara fajl properties.txt
		
		//Primenom ObjectOutputStream-a pravi jednu datoteku setup.xxx i u nju upisuje parametre, sadrzaj zipa
		//fajla, welecome, licence, verziju
		
		if(ConfigDialog.getFile() == null) {
			message = MainFrame.getInstance().getResourceBundle().getString("zipGreska");
			JOptionPane.showMessageDialog(parent, message);
			return;
		}
		
		File setup = new File("setup.hsl");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(setup)));
		try {
			oos.writeObject(pr);
			oos.writeObject(ConfigDialog.getFile());
			oos.writeObject(ConfigDialog.getWelecomeText());
			oos.writeObject(ConfigDialog.getLicenca());
			oos.writeObject(ConfigDialog.getVerzija());
			oos.writeObject(ConfigDialog.getImeProizvoda());
		} finally {
			oos.close(); //Zatvara i tok nizeg nivoa.
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
