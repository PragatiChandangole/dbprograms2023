package pragati.com;

import java.sql.*;
import java.util.*;

public class MobileUpdate {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement selectStmt;
        PreparedStatement updateStmt;
        ResultSet rs;
        Scanner sc = new Scanner(System.in);
        String modelName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");
            selectStmt = con.prepareStatement("SELECT * FROM  MOBILES WHERE modelname=?");
            updateStmt = con.prepareStatement("UPDATE MOBILES SET purpose=? WHERE modelname=?");

            
            System.out.print("Enter the model name: ");
            modelName = sc.nextLine();

            selectStmt.setString(1, modelName);
            rs = selectStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Current Purpose: " + rs.getString("purpose"));

             
                System.out.print("Enter the new purpose: ");
                String newPurpose = sc.nextLine();

                updateStmt.setString(1, newPurpose);
                updateStmt.setString(2, modelName);
                int rowsAffected = updateStmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Mobile purpose updated successfully.");
                } else {
                    System.out.println("Failed to update mobile purpose.");
                }
            } else {
                System.out.println("Mobile not found for the specified model.");
            }

            
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
