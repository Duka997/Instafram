package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;

public class Company implements Serializable {

	private static final long serialVersionUID = -3309076558783628858L;
	private String 	ImeKompanije;
	private String Sediste;
	private String BrojZaposlenih;
	private Node parent;
	List<Product> children;

	public Company() {
		super();
		this.ImeKompanije = " ";
		this.Sediste = " ";
		this.BrojZaposlenih = " ";
		this.parent=null;
		this.children=new ArrayList<Product>();
	}
	
	public Company(String ImeKompanije, String Sediste, String BrojZaposlenih,Node Parent) {
		super();
		this.ImeKompanije = ImeKompanije;
		this.Sediste = Sediste;
		this.BrojZaposlenih = BrojZaposlenih;
		this.parent=Parent;
		this.children=new ArrayList<Product>();
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent=parent;
	}
	
	public String getImeKompanije() {
		return ImeKompanije;
	}

	public void setImeKompanije(String ImeKompanije) {
		if (ImeKompanije == null) {
			throw new NullPointerException();
		}
		ImeKompanije = ImeKompanije.trim();
		if (ImeKompanije.isEmpty()) {
			throw new IllegalArgumentException(MainFrame.getInstance().getResourceBundle().getString("greskaNazivKompanije"));
		}
		this.ImeKompanije = ImeKompanije;
	}

	public String getSediste() {
		return Sediste;
	}

	public void setSediste(String Sediste) {
		if (Sediste == null) {
			throw new NullPointerException();
		}
		Sediste = Sediste.trim();
		if (Sediste.isEmpty()) {
			throw new IllegalArgumentException(MainFrame.getInstance().getResourceBundle().getString("greskaSediste"));
		}
		this.Sediste = Sediste;
	}

	public String getBrojZaposlenih() {
		return BrojZaposlenih;
	}

	public void setBrojZaposlenih(String BrojZaposlenih) {
		this.BrojZaposlenih = BrojZaposlenih;
	}

	public void removeFromParent() {
		this.parent.removeChild(this);
	}
	
	public List<Product> getChildren() {
		return children;
	}

	public void setChildren(List<Product> children) {
		this.children = children;
	}
	
	public void addChildren(Product newChild) {
		this.children.add(newChild);
		newChild.setParent(this);
	}
	
	public void removeChild(Product child) {
		this.children.remove(child);
		child.setParent(null);
	}
	
	@Override
	public String toString(){
		return ImeKompanije;
	}
	
}
