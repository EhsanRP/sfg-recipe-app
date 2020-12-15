package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by jt on 6/13/17.
 */
@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
