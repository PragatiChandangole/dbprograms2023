package pragati.com;

import java.sql.*;
import java.util.Scanner;

public class NewMobile {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
            pst = con.prepareStatement("INSERT INTO MOBILES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            System.out.print("Enter Mobile ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Rom of Mobile: ");
            int rom = sc.nextInt();
            System.out.print("Enter Ram of Mobile: ");
            int ram = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Model Name: ");
            String modelnm = sc.nextLine();
            System.out.print("Enter Company: ");
            String com = sc.nextLine();
            System.out.print("Enter Connectivity: ");
            String conn = sc.nextLine();
            System.out.print("Enter Color: ");
            String col = sc.nextLine();
            System.out.print("Enter Screen: ");
            String scr = sc.nextLine();
            System.out.print("Enter Battery: ");
            String bt = sc.nextLine();
            System.out.print("Enter Processor: ");
            String processor = sc.nextLine();
            System.out.print("Enter Price of Mobile: ");
            float pr = sc.nextFloat();
            System.out.print("Enter Rating of Mobile: ");
            float rt = sc.nextFloat();

            pst.setInt(1, id);
            pst.setInt(2, rom);
            pst.setInt(3, ram);
            pst.setString(4, modelnm);
            pst.setString(5, com);
            pst.setString(6, conn);
            pst.setString(7, col);
            pst.setString(8, scr);
            pst.setString(9, bt);
            pst.setString(10, processor);
            pst.setFloat(11, pr);
            pst.setFloat(12, rt);

            pst.executeUpdate();

            System.out.println("New mobile added successfully");
            con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
