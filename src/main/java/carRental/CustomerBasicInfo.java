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
@SuperBuilder
public class CustomerBasicInfo {

    private String id;
    private String customer_email;

}
