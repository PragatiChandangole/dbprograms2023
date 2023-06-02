package pragati.com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MobileOrder {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://bwmqfbgauilvc42l0fqo-mysql.services.clever-cloud.com:3306/bwmqfbgauilvc42l0fqo?user=u7ihrncogw9jr2bg&password=IuZqAXGAoVAzq4K5vdWF");

           
            statement = connection.createStatement();

            System.out.print("Enter the field to order by: ");
            String orderByField = scanner.nextLine();

            String query = "SELECT * FROM MOBILES ORDER BY " + orderByField + " DESC";

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String modelname = resultSet.getString("modelname");
                double price = resultSet.getDouble("price");
                double rating = resultSet.getDouble("rating");

                System.out.println("Brand: " + brand);
                System.out.println("Model Name: " + modelname);
                System.out.println("Price: " + price);
                System.out.println("Rating: " + rating);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
