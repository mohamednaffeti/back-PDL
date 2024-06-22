package aicha.pfe.tasks.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leaves implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Temporal(TemporalType.DATE)
    Date dateFrom;
    @Temporal(TemporalType.DATE)
    Date dateTo;
    int numberOfDays;
    int remainingLeaves;
    String leaveReason;
    String status;
    @Enumerated(EnumType.STRING)
    LeaveType leaveType;
    @ManyToOne
    User user;
}
