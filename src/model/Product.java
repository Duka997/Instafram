package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Product implements Serializable {

	private static final long serialVersionUID = 961839852546067994L;
	private String 	nazivProizvoda;
	private String verzija;
	private String UtrosenBrojCasova;
	private ImageIcon logo;
	private Company parent;
	List<Parameter> children;	
	
	public Product(String name, String verzija, String brCasova, ImageIcon logo, Company parent) {
		setNazivProizvoda(name);
		setVerzijaProizvoda(verzija);
		setUtrosenBrojCasova(brCasova);
		setLogo(logo);
		this.parent=parent;
		this.children=new ArrayList<Parameter>();
	}
	
	public Product() {
		nazivProizvoda="";
		verzija="";
		UtrosenBrojCasova="";
		logo=null;
		this.parent=null;
		this.children=new ArrayList<Parameter>();
	}

	public String getNazivProizvoda() {
		return nazivProizvoda;
	}

	public void setNazivProizvoda(String nazivProizvoda) {
		if (nazivProizvoda == null) {
			throw new NullPointerException();
		}
		nazivProizvoda = nazivProizvoda.trim();
		if (nazivProizvoda.isEmpty()) {
			throw new IllegalArgumentException("Niste uneli naziv prozivoda");
		}
		this.nazivProizvoda = nazivProizvoda;
	}
	
	public String getVerzijaProizvoda() {
		return verzija;
	}


	public void setVerzijaProizvoda(String verzija) {
		if (verzija == null) {
			throw new NullPointerException();
		}
		verzija = verzija.trim();
		if (verzija.isEmpty()) {
			throw new IllegalArgumentException("Niste uneli verziju proizvoda");
		}
		this.verzija= verzija;
	}
	
	public String getUtrosenBrojCasova() {
		return UtrosenBrojCasova;
	}

	public void setUtrosenBrojCasova(String UtrosenBrojCasova) {
		this.UtrosenBrojCasova = UtrosenBrojCasova;
	}
	
	public ImageIcon getLogo() {
		return logo;
	}

	public void setLogo(ImageIcon logo) {
		if (logo == null) {
			throw new IllegalArgumentException();
		}
		this.logo = logo;
	}
	
	public ImageIcon getProductImage() {
		return logo;
	}


	public void setProductImage(ImageIcon logo){
		this.logo=logo;
	}
	
	public Company getParent() {
		return parent;
	}

	public void setParent(Company parent) {
		this.parent=parent;
	}

	public void removeFromParent() {
		this.parent.removeChild(this);
	}

	public List<Parameter> getChildren() {
		return children;
	}

	public void setChildren(List<Parameter> children) {
		this.children = children;
	}
	public void addChildren(Parameter newChild) {
		this.children.add(newChild);
		newChild.setParent1(this);
	}
	
	public void removeChild(Parameter child) {
		this.children.remove(child);
		child.setParent1(null);
	}
	
	@Override
	public String toString(){
		return nazivProizvoda;
	}
}
