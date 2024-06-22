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
public class Education implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    String institution;
    String subject;
    @Temporal(TemporalType.DATE)
    Date startingDate;
    @Temporal(TemporalType.DATE)
    Date completeDate;
    String degree;
    String grade;
    @ManyToOne
    User user;


}