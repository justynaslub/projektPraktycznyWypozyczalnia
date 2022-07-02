package carRental;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CustomersRepository customersRepository;

    public static void main(String[] args) throws SQLException {

        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-project_rents");
        entityManager = entityManagerFactory.createEntityManager();
        customersRepository = new CustomersJpaRepository(entityManager);




        try (var connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/project_rents", "admin", "Password1");){
            System.out.println("Sucessfully connected to database.");

        } catch (SQLException e) {
            System.out.println("Something went wrong.");
        }

        testCreateCustomer();

        entityManager.close();
        entityManagerFactory.close();

    }

    private static void testCreateCustomer() throws SQLException {
        var customer = new Customers();
        customer.setId("jan1234");
        customer.setCustomer_password("jan1234");
        customer.setFirst_name("Jan");
        customer.setLst_name("Kowalski");
        customer.setBirth_date(LocalDate.of(1990,4,20));
        customer.setPhone_number("123456789");
        customer.setCustomer_email("jan.kowalski@gmail.com");
        customer.setLicence(2);
        customersRepository.createCustomer(customer);


    }






}
