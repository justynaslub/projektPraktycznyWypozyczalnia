package carRental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class CustomerBasicInfo {

    private String id;
    private String customer_email;

}
