package carRental;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.sql.SQLException;
@Slf4j
@RequiredArgsConstructor
public class CustomersJpaRepository implements CustomersRepository {

    private final EntityManager entityManager;

    @Override
    public void createCustomer(Customers customer) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomerByIdAndPassword(String id, String customer_password) throws SQLException {

    }

    @Override
    public void updateFirstName(String first_name) throws SQLException {

    }

    @Override
    public void updateFirstAndLastName(String last_name) throws SQLException {

    }

    @Override
    public void updatePassword(String customer_password) throws SQLException {

    }

    @Override
    public void updateLicence(int licence) throws SQLException {

    }

    @Override
    public void updatePhoneNumber(int phone_number) throws SQLException {

    }
}
