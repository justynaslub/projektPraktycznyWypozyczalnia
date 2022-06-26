package carRental;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CustomersRepository customersRepository;

    public static void main(String[] args) throws SQLException {

    entityManagerFactory = Persistence.createEntityManagerFactory("mysql-project_rents");
    entityManager = entityManagerFactory.createEntityManager();


        try (var connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/project_rents", "admin", "Password1");){
            System.out.println("Sucessfully connected to database.");

        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }


    }






}
