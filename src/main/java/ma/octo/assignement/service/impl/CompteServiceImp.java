package ma.octo.assignement.service.impl;

import ma.octo.assignement.domain.Compte;
import ma.octo.assignement.repository.CompteRepository;
import ma.octo.assignement.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CompteServiceImp implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public List<Compte> loadAll() {
        List<Compte> comptes = compteRepository.findAll();

        if (CollectionUtils.isEmpty(comptes)) {
            return null;
        } else {
            return comptes;
        }
    }

    @Override
    public void saveCompte(Compte compte) {
        compteRepository.save(compte);
    }

    @Override
    public Compte getCompte(Long id) {
        return compteRepository.getById(id);
    }

    @Override
    public Compte findByNrCompte(String numeroCompte) {
        return compteRepository.findByNrCompte(numeroCompte);
    }

    @Override
    public Compte findByRib(String rib) {
        return compteRepository.findByRib(rib);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}
