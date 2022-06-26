package carRental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")

public class Customers {

    private String id;
    private String customer_password;
    private String first_name;
    private String last_name;
    private Date birth_date;
    private String phone_number;
    private String customer_email;
    private int licence;

}
