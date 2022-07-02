package carRental;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

@Slf4j
public class Main {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CustomersRepository customersRepository;

    public static void main(String[] args) throws SQLException {

        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-project_rents");
        entityManager = entityManagerFactory.createEntityManager();
        customersRepository = new CustomersJpaRepository(entityManager);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz 1 aby się zarejestrować lub 2 jeśli masz już konto i chcesz się zalogować");
        System.out.println();
        int logowanie = scanner.nextInt();

        switch (logowanie) {
            case 1:
                if (logowanie == 1) {
                    System.out.println("Podaj dane do rejestracji.");
                    scanner.nextLine();
                    System.out.println("Podaj swój login:");
                    String login = scanner.nextLine();
                    System.out.printf("Podaj swoje hasło: ");
                    String password = scanner.nextLine();
                    System.out.printf("Podaj swoje imię: ");
                    String first_name = scanner.nextLine();
                    System.out.printf("Podaj swoje nazwisko: ");
                    String last_name = scanner.nextLine();
                    System.out.printf("Podaj rok urodzenia: ");
                    int birth_year = scanner.nextInt();
                    System.out.printf("Podaj miesiąc urodzenia: ");
                    int birth_month = scanner.nextInt();
                    System.out.printf("Podaj dzień urodzenia: ");
                    int birth_day = scanner.nextInt();
                    scanner.nextLine();
                    System.out.printf("Podaj swój numer telefonu w formacie: 456789456: ");
                    String phone_number = scanner.nextLine();
                    System.out.printf("Podaj swój email: ");
                    String customer_email = scanner.nextLine();
                    System.out.printf("Podaj kategorię prawa jazdy: 1 - A \n 2 - B \n 3 - C \n 4 - D+E");
                    int licence = scanner.nextInt();
                    testCreateCustomer(login, password, first_name, last_name, birth_year, birth_month, birth_day, phone_number, customer_email, licence);
                } break;
            case 2:
                if (logowanie == 2) {
                    System.out.println("Podaj swój login i hasło: ");
                } break;

        }





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



    private static void testCreateCustomer
            (String login, String password, String first_name, String last_name, int birth_year, int birth_month, int birth_day, String phone_number, String customer_email, int licence) throws SQLException {

        var customer = new Customers();
        customer.setId(login);
        customer.setCustomer_password(password);
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setBirth_date(LocalDate.of(birth_year,birth_month,birth_day));
        customer.setPhone_number(phone_number);
        customer.setCustomer_email(customer_email);
        customer.setLicence(licence);
        customersRepository.createCustomer(customer);
        System.out.printf("Konto utworzone. \nTwój login i hasło: %s, %s.", login, password);
    }

}
