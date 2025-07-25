package liliyasavitska.gestioneviaggi.services;

import liliyasavitska.gestioneviaggi.entities.Dipendente;
import liliyasavitska.gestioneviaggi.exeptions.BadRequestException;
import liliyasavitska.gestioneviaggi.exeptions.NotFoundException;
import liliyasavitska.gestioneviaggi.payloads.DipendenteDTO;
import liliyasavitska.gestioneviaggi.repositories.DipendentiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DipendentiService {

    @Autowired
    private DipendentiRepository dipendenteRepository;

    public Dipendente save(DipendenteDTO body) {
        dipendenteRepository.findByEmail(body.email()).ifPresent(existing -> {
            throw new BadRequestException("Email già usata: " + body.email());
        });

        Dipendente newDipendente = new Dipendente(body.nome(), body.cognome(), body.email(), body.username());

        Dipendente savedDipendente = this.dipendenteRepository.save(newDipendente);
        log.info("L'utente con id: " + savedDipendente.getId() + " è stato salvato correttamente!");
        return savedDipendente;
    }

    public Dipendente findById(UUID dipendenteId) {
        return this.dipendenteRepository.findById(dipendenteId).orElseThrow(() -> new NotFoundException(dipendenteId));

    }
}