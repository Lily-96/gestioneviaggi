package liliyasavitska.gestioneviaggi.services;

import liliyasavitska.gestioneviaggi.entities.Viaggio;
import liliyasavitska.gestioneviaggi.exeptions.NotFoundException;
import liliyasavitska.gestioneviaggi.repositories.ViaggiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViaggiService {

    @Autowired
    private ViaggiRepository viaggioRepository;

    public Viaggio save(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public List<Viaggio> getAll() {
        return viaggioRepository.findAll();
    }

    public Viaggio findById(UUID id) {
        return viaggioRepository.findById(id).orElseThrow(() -> new NotFoundException("Viaggio con id " + id + " non trovato"));
    }

    public Viaggio update(UUID id, Viaggio body) {
        Viaggio existing = findById(id);
        existing.setDestinazione(body.getDestinazione());
        existing.setData(body.getData());
        existing.setStato(body.getStato());
        return viaggioRepository.save(existing);
    }

    public void delete(UUID id) {
        Viaggio found = findById(id);
        viaggioRepository.delete(found);
    }
}