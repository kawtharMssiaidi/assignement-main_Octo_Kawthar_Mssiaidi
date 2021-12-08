package ma.octo.assignement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMPTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 16, unique = true)
    private String nrCompte;

    @Column(length = 24,  unique = true)
    private String rib;


    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Column(precision = 16, scale = 2)
    private double solde;

    @ManyToOne()
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}

