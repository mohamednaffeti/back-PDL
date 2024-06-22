package aicha.pfe.tasks.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experience implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    String companyName;
    String location;
    String jobPosition;
    @Temporal(TemporalType.DATE)
    Date periodFrom;
    @Temporal(TemporalType.DATE)
    Date periodTo;
    @ManyToOne
    User user;


}