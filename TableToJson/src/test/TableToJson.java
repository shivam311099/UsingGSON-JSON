package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TableToJson {

	public static void main(String[] args) {
		try {
			
			ArrayList<Tables> al = new ArrayList<>();
			String tableName = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			PreparedStatement ps = con.prepareStatement("SELECT table_name FROM user_tables");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tables tab = new Tables();
				tableName = rs.getString(1);
				ArrayList<Columns> ls=new ArrayList<>();
				tab.setTableName(tableName);
				PreparedStatement ps2 = con.prepareStatement("SELECT column_name ," // DESC Query (Background mechanism)
						+ "concat(concat(concat(data_type,'('),data_length),')') "
						+ " FROM user_tab_columns WHERE table_name='" + tableName + "'");
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					
					Columns col=new Columns();
					col.setName(rs2.getString(1));
					col.setType(rs2.getString(2));
					ls.add(col);
					
				}
				tab.setColumns(ls);
				al.add(tab);
			}

			/* Writing As Json */ 
			StringBuilder sb=new StringBuilder(); 
			for(Tables t:al) {

				Gson gson = new GsonBuilder()
			             .disableHtmlEscaping()
			             .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
			             .setPrettyPrinting()
			             .serializeNulls()
			             .create(); 
				sb.append(gson.toJson(t)); 
			}
			sb.append(new Date()); 
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
