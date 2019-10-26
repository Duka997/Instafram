package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {

	private static final long serialVersionUID = 269578202714249792L;
	String name;
	List<Company> children;

	public Node() {
		this.children = new ArrayList<Company>();
	}

	public Node(String name, Node parent) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Company> getChildren() {
		return children;
	}

	public void setChildren(List<Company> children) {
		this.children = children;
	}

	public String toString() {
		return this.name;
	}

	public void addChildren(Company newChild) {
		this.children.add(newChild);
		newChild.setParent(this);
	}

	public void removeChild(Company child) {
		this.children.remove(child);
		child.setParent(null);
	}
	

}
