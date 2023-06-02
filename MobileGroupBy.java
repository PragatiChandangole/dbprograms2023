package pragati.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MobileGroupBy {
    public static void main(String[] args) {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");

            statement = con.createStatement();

            String query = "SELECT brand, COUNT(*) AS total_models, AVG(price) AS avg_price, AVG(rating) AS avg_rating FROM MOBILES GROUP BY brand";
            resultSet = statement.executeQuery(query);

            System.out.println("Brand\t\tTotal Models\tAvg Price\tAvg Rating");
            System.out.println("----------------------------------------------");
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                int totalModels = resultSet.getInt("total_models");
                double avgPrice = resultSet.getDouble("avg_price");
                double avgRating = resultSet.getDouble("avg_rating");

                System.out.printf("%-10s\t%-12d\t%.2f\t\t%.2f%n", brand, totalModels, avgPrice, avgRating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
