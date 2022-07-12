package carRental;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

@Slf4j

public class RegistrationForm extends JDialog {
    private JTextField rfid;
    private JTextField rffirst_name;
    private JTextField rflast_name;
    private JTextField rfbirth_year;
    private JTextField rfbirth_month;
    private JTextField rfbirth_day;
    private JTextField rfphone_number;
    private JTextField rfemail_address;
    private JTextField rfdriving_licence;
    private JPasswordField rfpassword;
    private JButton registerButton;
    private JButton cancelButton;
    private JPanel registrationPanel;

    public RegistrationForm(JFrame parent) {
        super(parent);
        setTitle("Create a new account.");
        setContentPane(registrationPanel);
        setMinimumSize(new Dimension(870, 550));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerCustomer();

            }
        });

        //______________________________________________________________________________________//
        //dodać pętle po wciśnięciu przycisku Cancel - aby powrócił do wyboru ze startu programu//
        //______________________________________________________________________________________//
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.out.println("Anulowałeś rejestrację. Zamykam program.");

            }
        });
        setVisible(true);
    }

    private void registerCustomer() {
        String id = rfid.getText();
        String customer_password = String.valueOf(rfpassword.getPassword());
        String first_name = rffirst_name.getText();
        String last_name = rflast_name.getText();
        int birth_year = Integer.parseInt(rfbirth_year.getText());
        int birth_month = Integer.parseInt(rfbirth_month.getText());
        int birth_day = Integer.parseInt(rfbirth_day.getText());
        String phone_number = rfphone_number.getText();
        String customer_email = rfemail_address.getText();
        int licence = Integer.parseInt(rfdriving_licence.getText());

        if (id.isEmpty() || customer_password.isEmpty() || first_name.isBlank() || last_name.isEmpty()
                || phone_number.isEmpty() || customer_email.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all details.", "Try again.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        customers = addCusomerToDatabase (id, customer_password, first_name, last_name, birth_year, birth_month, birth_day, phone_number, customer_email, licence);
        if (customers != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Failed to register new customer.",
                    "Try again.", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Customers customers;
    private Customers addCusomerToDatabase(String id, String customer_password, String first_name, String last_name, int birth_year, int birth_month, int birth_day, String phone_number, String customer_email, int licence){
        Customers customers = null;


        try (var connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/project_rents", "admin", "Password1");){
            log.info("Successfully connected to database.");

            var statement = connection.createStatement();
            String sql = """
                    INSERT INTO customers
                    (id, customer_password, first_name, last_name,
                    birth_date, phone_number,
                    customer_email, licence)
                    VALUES (?, ?, ?, ?, ?, ? ,?, ?)
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, customer_password);
            preparedStatement.setString(3, first_name);
            preparedStatement.setString(4, last_name);
            preparedStatement.setDate(5, Date.valueOf((LocalDate.of(birth_year, birth_month, birth_day))));
            preparedStatement.setString(6, phone_number);
            preparedStatement.setString(7, customer_email);
            preparedStatement.setInt(8, licence);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                customers = new Customers();
                customers.id = id;
                customers.customer_password = customer_password;
                customers.first_name = first_name;
                customers.last_name = last_name;
                customers.setBirth_date(LocalDate.of(birth_year, birth_month, birth_day));
                customers.phone_number = phone_number;
                customers.customer_email = customer_email;
                customers.licence = licence;

                log.info("Account succesfully created.");
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            log.error("Something went wrong.");
            e.printStackTrace();

        }

        return customers;
    }

}

