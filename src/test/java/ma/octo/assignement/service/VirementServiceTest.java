package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Virement;
import ma.octo.assignement.domain.util.Gender;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.mapper.VirementMapper;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;



@SpringBootTest
public class VirementServiceTest {
    @Autowired
    private VirementMapper mapper;

    //@Spy
    @Mock
    private static VirementDto virementDto;
    //@Spy
    @Mock
    private static Virement virement;


    @BeforeEach
    public void init() {
        virementDto = new VirementDto();
        virement = new Virement();
        Utilisateur utilisateur1 = new Utilisateur(10L, Gender.M,null, "mssiaidi", "kawthar", null);
        Utilisateur utilisateur2 = new Utilisateur(12L, Gender.M,null, "mekaoui", "salma", null);
        final Compte CompteEmetteur = new Compte(10L, "010000B025001999", "123456010000B02500199912" ,new Date() ,200000, utilisateur1);
        final Compte CompteBeneficiaire = new Compte(11L, "010000B025112399", "123456010000B02511239912" ,new Date() ,200000, utilisateur2);
        final double montantVirement = 2000;
        final String motifVirement = "virement_motif";
        final Date dateVirement = new Date();

        virementDto.setCompteEmetteur(CompteEmetteur);
        virementDto.setCompteBeneficiaire(CompteBeneficiaire);
        virementDto.setMontantVirement(montantVirement);
        virementDto.setMotifVirement(motifVirement);
        virementDto.setDateExecution(dateVirement);

        virement.setCompteEmetteur(CompteEmetteur);
        virement.setCompteBeneficiaire(CompteBeneficiaire);
        virement.setMontantVirement(montantVirement);
        virement.setMotifVirement(motifVirement);
        virement.setDateExecution(dateVirement);
    }

    @Test
    void mapVirementDtoToVirementTest(){
        //System.out.println(virementDto.getCompteEmetteur().getRib());
        //fields should be the same as [virementDto]
        Assertions.assertAll(() -> {

            Virement result = mapper.map(virementDto);

            Assertions.assertEquals(result.getCompteEmetteur().getNrCompte(), virementDto.getCompteEmetteur().getNrCompte());
            Assertions.assertEquals(result.getCompteBeneficiaire().getNrCompte(), virementDto.getCompteBeneficiaire().getNrCompte());
            Assertions.assertEquals(result.getMontantVirement(), virementDto.getMontantVirement());
            Assertions.assertEquals(result.getMotifVirement(), virementDto.getMotifVirement());
            Assertions.assertEquals(result.getDateExecution(), virementDto.getDateExecution());
        });
    }


    @Test
    void mapVirementToVirementDtoTest(){

        
        Assertions.assertAll(() -> {

            VirementDto result = mapper.map(virement);

            Assertions.assertEquals(result.getCompteEmetteur().getNrCompte(), virement.getCompteEmetteur().getNrCompte());
            Assertions.assertEquals(result.getCompteBeneficiaire().getNrCompte(), virement.getCompteBeneficiaire().getNrCompte());
            Assertions.assertEquals(result.getMontantVirement(), virement.getMontantVirement());
            Assertions.assertEquals(result.getMotifVirement(), virement.getMotifVirement());
            Assertions.assertEquals(result.getDateExecution(), virement.getDateExecution());
        });
    }
}
