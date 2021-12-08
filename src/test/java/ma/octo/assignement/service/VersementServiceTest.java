package ma.octo.assignement.service;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.domain.Versement;
import ma.octo.assignement.domain.util.Gender;
import ma.octo.assignement.dto.VersementDto;
import ma.octo.assignement.mapper.VersementMapper;
import org.junit.jupiter.api.*;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;


@SpringBootTest

public class VersementServiceTest {

    private VersementMapper mapper;

    @Spy
    private static VersementDto versementDto;
    @Spy
    private static Versement versement;

   


    @BeforeEach
    public void init() {
        versementDto = new VersementDto();
        versement = new Versement();
        Utilisateur utilisateur2 = new Utilisateur(12L, Gender.F,null, "mssiaidi", "kawthar", null);

        final Compte CompteBeneficiaire = new Compte(11L, "010000B025112399","123456010000B02511239912" ,new Date() ,200000, utilisateur2);
        final double montantVersement = 2000;
        final Date dateVersement = new Date();

        versementDto.setCompteBeneficiaire(CompteBeneficiaire);
        versementDto.setMontant(montantVersement);
        versementDto.setDate(dateVersement);


        versement.setCompteBeneficiaire(CompteBeneficiaire);
        versement.setMontantVirement(montantVersement);
        versement.setDateExecution(dateVersement);
    }


    @Test
    void mapVersementDtoToVersementTest(){

        Assertions.assertAll(() -> {

            Versement result = mapper.map(versementDto);


            Assertions.assertEquals(result.getCompteBeneficiaire().getRib(), versementDto.getCompteBeneficiaire().getRib());
            Assertions.assertEquals(result.getMontantVirement(), versementDto.getMontant());
            Assertions.assertEquals(result.getDateExecution(), versementDto.getDate());
        });
    }


    @Test
    void mapVersementToVersementDtoTest(){

        Assertions.assertAll(() -> {

            VersementDto result = mapper.map(versement);


            Assertions.assertEquals(result.getCompteBeneficiaire().getRib(), versement.getCompteBeneficiaire().getRib());
            Assertions.assertEquals(result.getMontant(), versement.getMontantVirement());
            Assertions.assertEquals(result.getDate(), versement.getDateExecution());
        });
    }




}
