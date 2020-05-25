package test;

import java.util.List;

public class Parent {
	private List<Tables> tab;
	private String tname;
	public Parent() {
		super();
	}



	public String getTname() {
		return tname;
	}



	public void setTname(String tname) {
		this.tname = tname;
	}



	public List<Tables> getTab() {
		return tab;
	}



	public void setTab(List<Tables> tab) {
		this.tab = tab;
	}



	@Override
	public String toString() {
		return "Parent [tab=" + tab + "]";
	}


}
