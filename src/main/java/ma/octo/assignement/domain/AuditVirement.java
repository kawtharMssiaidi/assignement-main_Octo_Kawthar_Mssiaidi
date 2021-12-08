package ma.octo.assignement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="type_transfert")
public class AuditVirement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision = 16, scale = 2, nullable = false)
    private double montantVirement;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExecution;

    @ManyToOne
    private Compte compteBeneficiaire;


}