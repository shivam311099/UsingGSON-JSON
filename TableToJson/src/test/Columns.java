package test;

import java.io.Serializable;

/*Child*/


@SuppressWarnings("serial")
public class Columns implements Serializable {
	private String name;
	private String type;
	public Columns() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Columns [name=" + name + ", type=" + type + "]";
	}



}