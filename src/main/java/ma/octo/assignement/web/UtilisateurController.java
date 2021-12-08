package ma.octo.assignement.web;


import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("utilisateurs")
    List<Utilisateur> loadAllUtilisateur() {
        List<Utilisateur> utilisateurs = utilisateurService.loadAll();

        if (CollectionUtils.isEmpty(utilisateurs)) {
            return null;
        } else {
            return utilisateurs;
        }
    }


}
