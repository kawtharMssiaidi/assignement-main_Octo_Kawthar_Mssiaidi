package ma.octo.assignement.service;

import java.util.List;
import ma.octo.assignement.domain.Utilisateur;

public interface UtilisateurService {
	 List<Utilisateur> loadAll();
	    void saveUtilisateur(Utilisateur utilisateur);
}
