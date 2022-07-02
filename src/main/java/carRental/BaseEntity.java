package carRental;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
abstract class BaseEntity {

    @Id
    protected String id;
}

