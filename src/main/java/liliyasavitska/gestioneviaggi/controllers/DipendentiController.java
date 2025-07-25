package liliyasavitska.gestioneviaggi.controllers;

import liliyasavitska.gestioneviaggi.entities.Dipendente;
import liliyasavitska.gestioneviaggi.exeptions.BadRequestException;
import liliyasavitska.gestioneviaggi.payloads.DipendenteDTO;
import liliyasavitska.gestioneviaggi.payloads.DipendentiResponseDTO;
import liliyasavitska.gestioneviaggi.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")

public class DipendentiController {
    @Autowired
    DipendentiService dipendentiService;

    // Post
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public DipendentiResponseDTO saveDipendente(@RequestBody @Validated DipendenteDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        Dipendente newDipendente = dipendentiService.save(body);
        return new DipendentiResponseDTO(newDipendente.getId());
    }

    @GetMapping("/{dipendenteId}")
    public Dipendente getById(@PathVariable UUID dipendenteId) {
        return this.dipendentiService.findById(dipendenteId);
    }

}
