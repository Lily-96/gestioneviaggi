package liliyasavitska.gestioneviaggi.services;

import liliyasavitska.gestioneviaggi.entities.Dipendente;
import liliyasavitska.gestioneviaggi.exeptions.BadRequestException;
import liliyasavitska.gestioneviaggi.exeptions.NotFoundException;
import liliyasavitska.gestioneviaggi.repositories.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DipendentiService {

    @Autowired
    private DipendentiRepository dipendenteRepository;

    public Dipendente save(Dipendente body) {
        dipendenteRepository.findByEmail(body.getEmail()).ifPresent(existing -> {
            throw new BadRequestException("Email già usata: " + body.getEmail());
        });
        return dipendenteRepository.save(body);
    }

    public List<Dipendente> getAll() {
        return dipendenteRepository.findAll();
    }

    public Dipendente findById(UUID id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Dipendente con id " + id + " non trovato"));
    }

    public Dipendente update(UUID id, Dipendente body) {
        Dipendente existing = findById(id);
        existing.setNome(body.getNome());
        existing.setCognome(body.getCognome());
        existing.setEmail(body.getEmail());
        existing.setUsername(body.getUsername());
        return dipendenteRepository.save(existing);
    }

    public void delete(UUID id) {
        Dipendente found = findById(id);
        dipendenteRepository.delete(found);
    }

}