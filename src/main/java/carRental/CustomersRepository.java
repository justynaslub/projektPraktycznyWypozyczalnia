package carRental;

import java.sql.SQLException;

public interface CustomersRepository {

    void deleteCustomerByIdAndPassword (String id, String customer_password) throws SQLException;
    void updateFirstName (String first_name) throws SQLException;
    void updateFirstAndLastName (String last_name) throws SQLException;
    void updatePassword (String customer_password) throws SQLException;
    void updateLicence (int licence) throws SQLException;
    void updatePhoneNumber (int phone_number) throws SQLException;
}
