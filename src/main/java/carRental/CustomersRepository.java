package carRental;

import java.sql.SQLException;
import java.util.List;

public interface CustomersRepository {

    void createCustomer(Customers customer) throws SQLException;
    void deleteCustomerByIdAndPassword (String id, String customer_password) throws SQLException;
    void updateFirstName (String first_name) throws SQLException;
    void updateFirstAndLastName (String last_name) throws SQLException;
    void updatePassword (String customer_password) throws SQLException;
    void updateLicence (int licence) throws SQLException;
    void updatePhoneNumber (int phone_number) throws SQLException;

    List<Customers> getAllCustomers()throws SQLException;
}
