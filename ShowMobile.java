package pragati.com;

import java.sql.*;

public class ShowMobile {
	public static void main(String[] args) {
		Connection con;
		Statement st;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM MOBILES");

			while(rs.next())
			{
				System.out.println(rs.getString("company")+" | "+rs.getString("price"));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
