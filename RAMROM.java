package pragati.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RAMROM {

    public static void main(String[] args) {
        Connection con;
        PreparedStatement pst;
        Scanner sc = new Scanner(System.in);
        int rm, ro,id;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
            pst = con.prepareStatement("INSERT INTO MOBILES (prodid, ram, rom) VALUES (?, ?, ?)");
           System.out.print("Enter Product ID:");
           id=sc.nextInt();
            System.out.print("Enter Ram: ");
            rm = sc.nextInt();
            System.out.print("Enter Rom: ");
            ro = sc.nextInt();
            System.out.println("Added Succesfully");
            pst.setInt(1, id);
            pst.setInt(2, rm);
            pst.setInt(3, ro);
            pst.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
