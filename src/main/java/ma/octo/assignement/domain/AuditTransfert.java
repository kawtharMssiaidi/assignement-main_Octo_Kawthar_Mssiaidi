package ma.octo.assignement.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.octo.assignement.domain.util.EventType;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="type_audit")
public class AuditTransfert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String message;

    @Enumerated(EnumType.STRING)
    private EventType eventType;
}