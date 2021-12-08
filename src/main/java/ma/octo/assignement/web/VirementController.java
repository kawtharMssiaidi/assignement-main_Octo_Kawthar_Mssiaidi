package ma.octo.assignement.web;


import ma.octo.assignement.dto.VirementDto;
import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.exceptions.TransactionException;

import ma.octo.assignement.service.VirementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("virements")
class VirementController {

    @Autowired
    private VirementService virementService;

    @GetMapping("")
    List<VirementDto> loadAll() {
        return virementService.loadAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody VirementDto virementDto)
            throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException {

        virementService.saveVirementDto(virementDto);
    }

}
