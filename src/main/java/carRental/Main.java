package carRental;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CustomersRepository customersRepository;

    public static void main(String[] args) throws SQLException {

        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-project_rents");
        entityManager = entityManagerFactory.createEntityManager();
        customersRepository = new CustomersJpaRepository(entityManager);

        entityManager.close();
        entityManagerFactory.close();


        try (var connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/project_rents", "admin", "Password1");){

            log.info("Successfully connected to database.");


        } catch (SQLException e) {
            log.error("Something went wrong.");

        }

    }



}
