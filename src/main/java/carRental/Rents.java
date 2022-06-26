package carRental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rents")

public class Rents {

    private int id;
    private String rented_car;
    private String renting_customer;
    private Timestamp rent_date;
    private Timestamp return_date;
    private double rent_cost;
}
