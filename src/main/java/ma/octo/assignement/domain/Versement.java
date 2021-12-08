package ma.octo.assignement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "VERSEMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("VERSEMENT")
public class Versement extends AuditVirement{

    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
