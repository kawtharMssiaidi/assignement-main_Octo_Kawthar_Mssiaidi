package ma.octo.assignement.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "VIREMENT")
@Data 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("VIREMENT")
public class Virement extends AuditVirement{

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Compte compteEmetteur;


    @Column(length = 200)
    private String motifVirement;
}

