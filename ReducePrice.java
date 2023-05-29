package pragati.com;

import java.sql.*;

public class ReducePrice {
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");

           
            String procedureCall = "{CALL reduce_price(?, ?)}";
            cst = con.prepareCall(procedureCall);

           
            cst.setString(1, "Apple");
            cst.setDouble(2, 200.0); 
            
            cst.executeUpdate();

            System.out.println("Price reduced successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cst != null) {
                try {
                    cst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
