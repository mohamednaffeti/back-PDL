package aicha.pfe.tasks.entity;



import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    private String content;
    private String senderId;
    private String recipientId;







}
