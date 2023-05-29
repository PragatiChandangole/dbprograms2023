package pragati.com;
import java.sql.*;
import java.util.*;

public class ChangePrice {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement pst;
		Scanner sc=new Scanner(System.in);
		int id;
		float price;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
			pst=con.prepareStatement("update MOBILES set price=? where prodid=?");
			
			System.out.print("Enter Product Id : ");
			id=sc.nextInt();
			System.out.print("Enter new Price : ");
			price=sc.nextFloat();
			
			pst.setInt(1, id);
			pst.setFloat(2,price);
			int cnt=pst.executeUpdate();
			System.out.println("Price Updated Succesfully");
			
			
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}