package aicha.pfe.tasks.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditable<String> implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Long id;
    String firstName;
    String lastName;
    String username;
    String birthDay;
    String phone;
    String email;
    @Column(columnDefinition = "integer default 22")
    Integer daysConge = 22;
    String password;

    String address;

    @Enumerated(EnumType.STRING)
    Gender gender;
    String dateOfJoin;
    Boolean active;

    @Enumerated(EnumType.STRING)
    Designation designation;
    @Enumerated(EnumType.STRING)
    Department department;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    List<Absence> absences;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<Leaves> leaves;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<Experience> experiences;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<Education> educations;

    @JsonIgnore
    @ManyToOne
    Team team;
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    Set<Role> roles;






}
