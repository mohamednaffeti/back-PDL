package aicha.pfe.tasks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Team implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")

    List<User> users;
    @OneToOne(mappedBy = "team")
    @JsonIgnore
    Project project;
}
