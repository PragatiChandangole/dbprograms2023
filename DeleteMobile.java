package pragati.com;


import java.sql.*;
import java.util.*;

public class DeleteMobile {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		int id;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
			pst=con.prepareStatement("delete from MOBILES where prodid=?");
			
			System.out.print("Enter Product Id to delete : ");
			id=sc.nextInt();
			
			pst.setInt(1, id);
			int cnt=pst.executeUpdate();
			if(cnt>0)
				System.out.println("account deleted successfully");
			else
				System.out.println("account not found");
			
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
