package carRental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")

public class Cars {
    private String licence_plate;
    private String car_brand;
    private String car_model;
    private int car_category;
    private int car_fuel;
    private String car_color;
    private double cost_per_day;

}
