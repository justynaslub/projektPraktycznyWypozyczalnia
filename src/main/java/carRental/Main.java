package carRental;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j
public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CustomersRepository customersRepository;

    public static void main(String[] args) throws SQLException {

        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-project_rents");
        entityManager = entityManagerFactory.createEntityManager();
        customersRepository = new CustomersJpaRepository(entityManager);

        testCreateCustomer();

        entityManager.close();
        entityManagerFactory.close();


        try (var connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/project_rents", "admin", "Password1");){
            var statement = connection.createStatement();
            log.info("Successfully connected to database.");

        } catch (SQLException e) {
            log.error("Something went wrong.");
            e.printStackTrace();

        }

    }



    private static void testCreateCustomer() throws SQLException {
        var customer = new Customers();
        customer.setId("jan123");
        customer.setCustomer_password("jan123");
        customer.setFirst_name("Jan");
        customer.setLast_name("Kowalski");
        customer.setBirth_date(LocalDate.of(1990,12,01));
        customer.setPhone_number("123456789");
        customer.setCustomer_email("jan@gmail.com");
        customer.setLicence(2);
        customersRepository.createCustomer(customer);
    }

}
