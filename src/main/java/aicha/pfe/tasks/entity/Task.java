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
public class Task implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Long id;
    String title;
    String description;
    @Temporal(TemporalType.DATE)
    Date dueDate;
    @Enumerated(EnumType.STRING)
    TaskStatus taskStatus;
    @ManyToOne
    User user;
}