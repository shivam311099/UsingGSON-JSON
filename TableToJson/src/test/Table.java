package test;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Table implements Serializable{
	private List<Tables> tables;

	public Table() {
		super();
	}

	
	public List<Tables> getTab() {
		return tables;
	}


	public void setTab(List<Tables> tab) {
		this.tables = tab;
	}


	@Override
	public String toString() {
		return "Table [tab=" + tables + "]";
	}
	
}
