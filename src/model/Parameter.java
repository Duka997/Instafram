package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parameter implements Serializable {

	private static final long serialVersionUID = -366599513884585002L;
	private String 	NazivParametra;
	private String VrednostParametra;
	private Product parent1;
	private Parameter parent2;
	List<Parameter> children;

	public Parameter(String name, String value, Product parentt, Parameter parenttt) {
		setNazivParametra(name);
		setVrednostParametra(value);
		this.parent1=parentt;
		this.parent2=parenttt;
		this.children=new ArrayList<Parameter>();
	}
	
	public Parameter() {
		NazivParametra="";
		VrednostParametra="";
		this.parent1=null;
		this.parent2=null;
		this.children=new ArrayList<Parameter>();
		
	}
	
	public String getNazivParametra() {
		return NazivParametra;
	}


	public void setNazivParametra(String NazivParametra) {
		if (NazivParametra == null) {
			throw new NullPointerException();
		}
		NazivParametra = NazivParametra.trim();
		if (NazivParametra.isEmpty()) {
			throw new IllegalArgumentException("Polje za naziv parametra je prazno");
		}
		this.NazivParametra = NazivParametra;
	}
	
	public String getVrednostParametra() {
		return VrednostParametra;
	}

	public void setVrednostParametra(String VrednostParametra) {
		if (VrednostParametra == null) {
			throw new NullPointerException();
		}
		VrednostParametra = VrednostParametra.trim();
		if (VrednostParametra.isEmpty()) {
			throw new IllegalArgumentException("Polje za vrednost parametra je prazno");
		}
		this.VrednostParametra= VrednostParametra;
	}
	
	public Product getParent1() {
		return parent1;
	}

	public void setParent1(Product parent) {
		this.parent1=parent;
	}
	
	public Parameter getParent2() {
		return parent2;
	}

	public void setParent2(Parameter parent) {
		this.parent2=parent;
	}

	public void removeFromParent() {
		this.parent1.removeChild(this);
	}
	
	public List<Parameter> getChildren() {
		return children;
	}

	public void setChildren(List<Parameter> children) {
		this.children = children;
	}
	public void addChildren(Parameter newChild) {
		this.children.add(newChild);
		newChild.setParent2(this);
	}
	
	public void removeChild(Parameter child) {
		this.children.remove(child);
		child.setParent2(null);
	}
	
	@Override
	public String toString(){
		return NazivParametra;
	}
	
}
