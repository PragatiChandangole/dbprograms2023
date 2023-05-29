package pragati.com;

import java.sql.*;
import java.util.*;

public class SearchMobile {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		Scanner sc=new Scanner(System.in);
		String mname;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
			pst=con.prepareStatement("select * from MOBILES where modelname=?");
			
			System.out.print("Enter model name : ");
			mname=sc.nextLine();
			
			
			pst.setString(1, mname);
			rs=pst.executeQuery();
			con.close();
		if(rs.next())
			{
				System.out.println(rs.getString("modelname"));
			}
		else
		{
			System.out.println("Not Found");
		}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
		
