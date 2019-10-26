package gui;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveDialog {
	
	public SaveDialog() throws IOException {
		
		File f = new File("workspace.wor");

		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		
		oos.writeObject(MainFrame.getInstance().getTreeModel());
		oos.close();
		
	}

}
