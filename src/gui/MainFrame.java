package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import listeners.TreeListener;
import model.Node;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -4094076853264462271L;
	private MyMenuBar menu;
	private JTree tree;
	private DefaultTreeModel treeModel;
	
	private static DefaultTreeModel treeModelStatic;

	public static MainFrame instance = new MainFrame();
	private static JPanel panCenter;
	
	private Node root;
	
	private ResourceBundle resourceBundle;
	
	private MainFrame() {
		//bira jezik
		JFrame frame = new JFrame();
		Object[] options = {"Srpski", "English"};
		int n = JOptionPane.showOptionDialog(frame,"Odaberite jezik / Choose a language", "Jezik/Language", 
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if(n == 0)
			Locale.setDefault(new Locale("sr", "RS"));
		else if(n == 1)
			Locale.setDefault(new Locale("en", "US"));
		else
			System.exit(0);
		
		resourceBundle =ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setTitle("InstaFram");
		setSize((int)(screenSize.getWidth()*0.5),(int)(screenSize.getHeight()*0.5));
		setLocation(screenWidth/2-getWidth()/2, screenHeight/2-getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panTop=new JPanel();
		panTop.setPreferredSize(new Dimension(280,50));
		
		//initTree, lista kompanija sa leve strane
		JPanel panLeft = new JPanel(new BorderLayout());
		panLeft.setPreferredSize(new Dimension(200,200));
		
		this.root = new Node(resourceBundle.getString("Kompanije"), null);
		treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(this.root));
		treeModel.setAsksAllowsChildren(true);
		tree = new JTree(treeModel);
		treeModelStatic = treeModel;
		tree.setEditable(true);
		
		JScrollPane sp = new JScrollPane(tree);
		panLeft.add(BorderLayout.CENTER, sp);
		
		panCenter = new JPanel();

		JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panLeft,panCenter);
		
		JPanel panBottom=new JPanel();
		panBottom.setPreferredSize(new Dimension(280,30));
		panBottom.setBackground(Color.LIGHT_GRAY);
		panBottom.add(BorderLayout.WEST, new JLabel(resourceBundle.getString("statusBar")));
		 
		add(panTop,BorderLayout.NORTH);
		add(splitPane1,BorderLayout.CENTER);
		add(panBottom,BorderLayout.SOUTH);
		
		 
		//kreiramo labelu
		JLabel lbl = new JLabel("INSTAFRAM");
		lbl.setToolTipText(resourceBundle.getString("instalacioniFramework"));
		panTop.add(lbl);
		
		//kreiranje naslednika klase JMenuBar i njeno postavljanje u glavni prozor aplikacije
		/*MyMenuBar menu=new MyMenuBar();
        this.setJMenuBar(menu);*/
		menu = new MyMenuBar(resourceBundle);
		this.setJMenuBar(menu);
        
        //kreiramo instancu klase Toolbar
        MyToolbar toolbar=new MyToolbar(resourceBundle);
        //dodajemo u Frame naš Toolbar, klasa BorderLayout se odnosi na rad
        //sa prostornim rasporedom komponenti
        add(toolbar, BorderLayout.NORTH);
        
        TreeListener treeListener=new TreeListener();
		tree.addTreeSelectionListener(treeListener);
		
	}
	
	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
		tree.setModel(treeModel);
		tree.updateUI();
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public static DefaultTreeModel getStaticTreeModel() {
		return treeModelStatic;
	}
	
	public static MainFrame getInstance() {
		return instance;
	}

	public JTree getTree() {
		return tree;
	}

	public DefaultTreeModel getModel() {
		return treeModel;
	}
	
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}
	
	public static JPanel getPanCenter() {
		return panCenter;
	}
	
	public static void setPanCenter(JPanel panCenter) {
		MainFrame.panCenter = panCenter;
	}
	
	public static void addinpanCenter(Component scv) {
		panCenter.add(scv);
	}
	
	public static void removefrompanCenter() {
		panCenter.removeAll();
	}
	
}