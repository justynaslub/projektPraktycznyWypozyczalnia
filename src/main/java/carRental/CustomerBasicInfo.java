package carRental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class CustomerBasicInfo {

    public String id;
    public String customer_email;
    //private String customer_password;

}
