package ma.octo.assignement.service;

import java.util.List;
import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.TransactionException;

public interface VirementService {
	List<VirementDto> loadAll();
    void saveVirementDto(VirementDto virementDto) throws CompteNonExistantException, TransactionException;
}
