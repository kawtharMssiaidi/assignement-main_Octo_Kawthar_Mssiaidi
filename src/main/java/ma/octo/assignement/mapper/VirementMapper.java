package ma.octo.assignement.mapper;

import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.dto.VirementDto;
import org.springframework.stereotype.Component;

@Component
public class VirementMapper {

    public static VirementDto map(Virement virement) {
        VirementDto virementDto = new VirementDto();

        virementDto.setCompteEmetteur(virement.getCompteEmetteur());
        virementDto.setCompteBeneficiaire(virement.getCompteBeneficiaire());
        virementDto.setDateExecution(virement.getDateExecution());
        virementDto.setMotifVirement(virement.getMotifVirement());
        virementDto.setMontantVirement(virement.getMontantVirement());

        return virementDto;
    }

    public  Virement map(VirementDto virementDto) {

        Virement virement = new Virement();
        virement.setCompteEmetteur(virementDto.getCompteEmetteur());
        virement.setCompteBeneficiaire(virementDto.getCompteBeneficiaire());
        virement.setDateExecution(virementDto.getDateExecution());
        virement.setMotifVirement(virementDto.getMotifVirement());
        virement.setMontantVirement(virementDto.getMontantVirement());

        return virement;
    }
}
