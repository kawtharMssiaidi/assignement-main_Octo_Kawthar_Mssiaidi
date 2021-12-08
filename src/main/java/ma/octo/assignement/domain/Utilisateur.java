package ma.octo.assignement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.octo.assignement.domain.util.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "UTILISATEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;

    @Column(length = 70, nullable = true)
    private String username;
    
    @Column(length = 40, nullable = false)
    private String lastname;

    @Column(length = 40, nullable = false)
    private String firstname;

    @Temporal(TemporalType.DATE)
    private Date birthdate;


}
