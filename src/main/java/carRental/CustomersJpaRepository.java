package carRental;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CustomersJpaRepository implements CustomersRepository {

    private final EntityManager entityManager;

    @Override

    public void createCustomer(Customers customer) throws SQLException {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            log.info("Customer successfully created.");
        } catch (NoResultException e) {
            log.warn("Customer already exists.", e); //sprawdzic exception czy działa
        }
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

    @Override
    public List<Cars> getAllCars() throws SQLException {
       var selectAllCars = """
               select new carRental.Cars(c.licence_plate, c.car_brand, c.car_model,
               c.car_category, c.car_fuel, c.car_color, c.cost_per_day)
               from Cars c
               """;
        var query = entityManager.createQuery(selectAllCars, Cars.class);
        return query.getResultList();
    }
}
