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
    public String first_name;
    public String last_name;
    public LocalDate birth_date;
    public String phone_number;
    public int licence;
    public String customer_password;
    public String customer_email;

}
