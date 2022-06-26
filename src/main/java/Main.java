import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {



        try (var connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/project_rents", "admin", "Password1");){
            System.out.println("Sucessfully connected to database.");

        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }


    }






}
