package carRental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")


public class Customers extends BaseEntity {
    private String first_name;
    private String last_name;
    private LocalDate birth_date;
    private String phone_number;
    private int licence;
    private String customer_password;
    private String customer_email;

}
