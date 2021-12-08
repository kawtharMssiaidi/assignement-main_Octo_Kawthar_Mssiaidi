package ma.octo.assignement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.octo.assignement.domain.Compte;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class VersementDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Compte CompteBeneficiaire;
    private double montant;
    private Date date;
}
