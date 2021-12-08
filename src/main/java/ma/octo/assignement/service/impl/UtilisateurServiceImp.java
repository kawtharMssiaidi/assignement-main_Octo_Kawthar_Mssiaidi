package ma.octo.assignement.service.impl;

import ma.octo.assignement.domain.Utilisateur;
import ma.octo.assignement.repository.UtilisateurRepository;
import ma.octo.assignement.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<Utilisateur> loadAll() {
        return utilisateurRepository.findAll();
    }


    @Override
    public void saveUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }
}

