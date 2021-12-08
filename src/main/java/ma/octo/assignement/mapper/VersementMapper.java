package ma.octo.assignement.mapper;

import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;

public class VersementMapper {


    public static VersementDto map(Versement versement) {
        VersementDto versementDto = new VersementDto();

        versementDto.setDate(versement.getDateExecution());
        versementDto.setCompteBeneficiaire(versement.getCompteBeneficiaire());
        versementDto.setMontant(versement.getMontantVirement());

        return versementDto;
    }

    public static Versement map(VersementDto versementDto) {
        Versement versement = new Versement();

        versement.setDateExecution(versementDto.getDate());
        versement.setCompteBeneficiaire(versementDto.getCompteBeneficiaire());
        versement.setMontantVirement(versementDto.getMontant());

        return versement;
    }

}
