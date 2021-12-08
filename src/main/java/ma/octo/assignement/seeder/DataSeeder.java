package ma.octo.assignement.seeder;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.domain.util.Gender;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.mapper.VersementMapper;
import ma.octo.assignement.mapper.VirementMapper;
import ma.octo.assignement.service.CompteService;
import ma.octo.assignement.service.UtilisateurService;
import ma.octo.assignement.service.Versementservice;
import ma.octo.assignement.service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private CompteService compteService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private VirementService virementService;
    @Autowired
    private Versementservice versementService;
    @Override
    public void run(String... args)  {
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setUsername("user1");
        utilisateur1.setLastname("last1");
        utilisateur1.setFirstname("first1");
        utilisateur1.setGender(Gender.M);

        utilisateurService.saveUtilisateur(utilisateur1);


        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.setUsername("user2");
        utilisateur2.setLastname("last2");
        utilisateur2.setFirstname("first2");
        utilisateur2.setGender(Gender.F);

        utilisateurService.saveUtilisateur(utilisateur2);

        Compte compte1 = new Compte();
        compte1.setNrCompte("010000A000001000");
        compte1.setRib("RIB1");
        compte1.setSolde(200000);
        compte1.setUtilisateur(utilisateur1);
        compte1.setDateCreation(new Date());

        compteService.saveCompte(compte1);

        Compte compte2 = new Compte();
        compte2.setNrCompte("010000B025001000");
        compte2.setRib("RIB2");
        compte2.setSolde(140000);
        compte2.setUtilisateur(utilisateur2);
        compte2.setDateCreation(new Date());

        compteService.saveCompte(compte2);

        Virement virement = new Virement();
        virement.setMontantVirement(3000);
        virement.setCompteBeneficiaire(compte2);
        virement.setCompteEmetteur(compte1);
        virement.setDateExecution(new Date());
        virement.setMotifVirement("Assignment 2021");



        VirementDto virementDto = VirementMapper.map(virement);

        try {
            virementService.saveVirementDto(virementDto);
        }catch(Exception e){

        }

        Versement versement = new Versement();
        versement.setMontantVirement(500);
        versement.setCompteBeneficiaire(compte1);
        versement.setDateExecution(new Date());

        VersementDto versementDto = VersementMapper.map(versement);
        try {
            versementService.saveVersementDto(versementDto);
        }catch(Exception e){

        }
    }
}
