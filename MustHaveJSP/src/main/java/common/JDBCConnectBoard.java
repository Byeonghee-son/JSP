package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class JDBCConnectBoard {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pwd = "tiger";
	
	public JDBCConnectBoard() {}
	
	public JDBCConnectBoard(String driver, String url, String id, String pwd) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pwd = pwd;
	}
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void writeBoardToTable(Connection con1, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		try {
			out.write("<table>");
			out.write("<tr>");
			out.write("<td>num</td><td>title</td><td>content</td><td>id</td><td>postdate</td><td>visitcount</td>");
			out.write("</tr>");
			st = con1.createStatement();
			rs = st.executeQuery("select * from board");
			while(rs.next()) {
				out.write("<tr>");
				out.write("<td>"); out.print(rs.getInt("num")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("title")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("content")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("postdate")); out.write("</td>");
				out.write("<td>"); out.print(rs.getInt("visitcount")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
