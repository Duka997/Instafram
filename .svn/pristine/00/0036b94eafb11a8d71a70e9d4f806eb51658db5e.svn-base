package myappSetup;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import gui.MainFrame;

public class MyAppSetup {
	
	private static File zipFajl;
	private static String welecome;
	private static String licenca;
	private static String verzija;
	
	private static JFrame frejm = new JFrame();
	private static JPanel dugmad = new JPanel();
	private static String adresa = "";
	private static String novaAdresa = "";
	private static String imeProizvoda = "";
	private static Checkbox saglasnost; //proverava saglasnot kod licence
	
	private static JPanel panWele;
	private static JPanel panLicenca;
	private static JPanel panFajl;
	private static JPanel panPoz;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frejm.setSize((int)(screenSize.getWidth()*0.5),(int)(screenSize.getHeight()*0.5));
		frejm.setLocation(screenWidth/2-frejm.getWidth()/2, screenHeight/2-frejm.getHeight()/2);
		frejm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		File f = new File("setup.hsl");

		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		try {
			@SuppressWarnings("unused")
			Properties pr = (Properties)ois.readObject();
			zipFajl = (File)ois.readObject();
			welecome = (String)ois.readObject();
			licenca = (String)ois.readObject();
			verzija = (String)ois.readObject();
			imeProizvoda = (String)ois.readObject();
		} finally {
			ois.close();
		}
		
		//fali ime prozivoda pored verzije
		frejm.setTitle(imeProizvoda + " " + verzija);

		WelecomeDialog();
		
		frejm.setVisible(true);
	
	}

	private static void WelecomeDialog() {
		frejm.remove(dugmad);
		panWele = new JPanel(new GridBagLayout());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		JTextArea tfLicenca = new JTextArea(5, 20);
		JScrollPane scrollPane = 
			    new JScrollPane(tfLicenca,
			                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tfLicenca.setText(welecome);
		tfLicenca.setEditable(false);
		
		scrollPane.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.45),(int)(screenSize.getHeight()*0.3)));

		panWele.add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(30, 30, 30, 30), 0, 0));
		frejm.add(panWele, BorderLayout.CENTER);
		JButton odustani = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton sledece = new JButton(MainFrame.getInstance().getResourceBundle().getString("sledece"));
		sledece.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				panWele.setVisible(false);
				LicencaDialog();
			}
		});
		
		 dugmad = new JPanel();
		dugmad.add(odustani);
		dugmad.add(sledece);
		frejm.add(dugmad, BorderLayout.SOUTH);
	}
	
	private static void LicencaDialog() {
		frejm.remove(dugmad);
		
		panLicenca = new JPanel(new GridBagLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		JTextArea tfLicenca = new JTextArea(5, 20);
		JScrollPane scrollPane2 = 
			    new JScrollPane(tfLicenca,
			                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tfLicenca.setText(licenca);
		tfLicenca.setEditable(false);
		
		scrollPane2.setPreferredSize(new Dimension((int)(screenSize.getWidth()*0.45),(int)(screenSize.getHeight()*0.3)));
		
		panLicenca.add(scrollPane2, new GridBagConstraints(0, 0, 2, 6, 1, 1, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 15, 5, 15), 0, 0));
		saglasnost = new Checkbox(MainFrame.getInstance().getResourceBundle().getString("agree"), false);
		panLicenca.add(saglasnost, new GridBagConstraints(0, 7, 1, 2, 1, 1, GridBagConstraints.WEST,GridBagConstraints.NONE, new Insets(5, 15, 5, 5), 0, 0));
		frejm.add(panLicenca);
		
		JButton prethodno = new JButton(MainFrame.getInstance().getResourceBundle().getString("prethodno"));
		prethodno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panLicenca.setVisible(false);
				WelecomeDialog();
			}
		});
		
		JButton odustani = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton sledece = new JButton(MainFrame.getInstance().getResourceBundle().getString("sledece"));
		sledece.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(saglasnost.getState()) {
					panLicenca.setVisible(false);
					FajlDialog();
				} else {
					return;
				}
			}
		});
		
		dugmad = new JPanel();
		dugmad.add(odustani);
		dugmad.add(prethodno);
		dugmad.add(sledece);
		frejm.add(dugmad, BorderLayout.SOUTH);
	}
	
	private static void FajlDialog() {
		frejm.remove(dugmad);
		adresa = zipFajl.getAbsolutePath();
		JLabel fajlLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("odrediste"));
		JTextField tfOdrediste = new JTextField(novaAdresa, 30);
		Font font2 = new Font("Jokerman", Font.PLAIN, 15);
		fajlLabel.setFont(font2);
		
		JButton browse = new JButton(" ... ");
		browse.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle(MainFrame.getInstance().getResourceBundle().getString("izaberiteZip"));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File newLoc = chooser.getCurrentDirectory(); 
					novaAdresa = newLoc.getAbsolutePath();
					zipFajl = chooser.getSelectedFile();
					tfOdrediste.setText(novaAdresa);
					tfOdrediste.show();
				}
			}
		});
		panFajl = new JPanel();
		panFajl.add(fajlLabel);
		panFajl.add(tfOdrediste);
		panFajl.add(browse);
		frejm.add(panFajl, BorderLayout.NORTH);
		
		JButton prethodno = new JButton(MainFrame.getInstance().getResourceBundle().getString("prethodno"));
		prethodno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panFajl.setVisible(false);
				LicencaDialog();
			}
		});
		
		JButton odustani = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton sledece = new JButton(MainFrame.getInstance().getResourceBundle().getString("sledece"));
		sledece.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(novaAdresa == "") {
						String message = "Greska";
						Window parent = SwingUtilities.getWindowAncestor(MainFrame.getInstance());
						message = MainFrame.getInstance().getResourceBundle().getString("putanjaGreska");
						JOptionPane.showMessageDialog(parent, message);
						return;
					}
					unzip(new File(novaAdresa));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				panFajl.setVisible(false);
				PozDialog();
			}
		});
		
		dugmad = new JPanel();
		dugmad.add(odustani);
		dugmad.add(prethodno);
		dugmad.add(sledece);
		frejm.add(dugmad, BorderLayout.SOUTH);
	}
	
	private static void unzip(File outputDir) throws IOException {
		ZipFile zipFile = new ZipFile(adresa);
		try {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				File entryDestination = new File(outputDir, entry.getName());
				if (entry.isDirectory()) {
					entryDestination.mkdirs();
				} else {
					entryDestination.getParentFile().mkdirs();
					//InputStream in = zipFile.getInputStream(entry);
					OutputStream out = new FileOutputStream(entryDestination);
					//IOUtils.copy(in, out);
					//IOUtils.closeQuietly(in);
					out.close();
				}
			}
		} finally {
			zipFile.close();
		}
	}
	
	private static void PozDialog() {
		frejm.remove(dugmad);
		JLabel pozLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("uspesnoInstaliran"));
		Font font = new Font("Jokerman", Font.PLAIN, 20);
		pozLabel.setFont(font);
		
		panPoz = new JPanel();
		panPoz.add(pozLabel);
		frejm.add(panPoz, BorderLayout.NORTH);
		JButton kraj = new JButton(MainFrame.getInstance().getResourceBundle().getString("kraj"));
		kraj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		dugmad = new JPanel();
		dugmad.add(kraj);
		frejm.add(dugmad, BorderLayout.SOUTH);
	}
	
}