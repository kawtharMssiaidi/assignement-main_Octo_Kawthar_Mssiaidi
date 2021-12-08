package ma.octo.assignement.service.impl;


import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.mapper.VersementMapper;
import ma.octo.assignement.repository.VersementRepository;
import ma.octo.assignement.service.AutiService;
import ma.octo.assignement.service.CompteService;
import ma.octo.assignement.service.Versementservice;
import ma.octo.assignement.service.VirementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VersementServiceImp implements Versementservice {

    public static final int MONTANT_MAXIMAL = 10000;
    Logger LOGGER = LoggerFactory.getLogger(VirementService.class);


    @Autowired
    private VersementRepository versementRepository;
    @Autowired
    private CompteService compteService;
    @Autowired
    private AutiService autiService;


    @Override
    public List<VersementDto> loadAll() {
        List<VersementDto> versementDtoList = new ArrayList<>();
        List<Versement> versements = versementRepository.findAll();
        if (!CollectionUtils.isEmpty(versements)) {
            for (int i = 0; i < versements.size(); i++){
                versementDtoList.add(VersementMapper.map(versements.get(i)));
            }
        }
        return versementDtoList;
    }

    @Override
    public void saveVersement(Versement versement) {
        versementRepository.save(versement);
    }

    @Override
    public void saveVersementDto(VersementDto versementDto) throws CompteNonExistantException, TransactionException {
        Compte compteBeneficiaire = compteService.findByRib(versementDto.getCompteBeneficiaire().getRib());
        versementDto.setDate(new Date());
        if (compteBeneficiaire == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (versementDto.getMontant()== 0) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (versementDto.getMontant() == 0) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (versementDto.getMontant() < 10) {
            System.out.println("Montant minimal de Versement non atteint");
            throw new TransactionException("Montant minimal de Versement non atteint");
        } else if (versementDto.getMontant() > MONTANT_MAXIMAL) {
            System.out.println("Montant maximal de Versement dépassé");
            throw new TransactionException("Montant maximal de Versement dépassé");
        }

        compteBeneficiaire
                .setSolde(compteBeneficiaire.getSolde() + versementDto.getMontant());
        compteService.saveCompte(compteBeneficiaire);

        Versement versement = new Versement();
        versement.setDateExecution(versementDto.getDate());
        versement.setCompteBeneficiaire(compteBeneficiaire);
        versement.setMontantVirement(versementDto.getMontant());

        versementRepository.save(versement);


        autiService.auditVersement("Versement d'un montant de " + versementDto.getMontant()+ " vers " + versementDto
                .getCompteBeneficiaire().getRib());
    }
}
