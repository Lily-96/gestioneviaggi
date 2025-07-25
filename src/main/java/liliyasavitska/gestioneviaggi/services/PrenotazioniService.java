package liliyasavitska.gestioneviaggi.services;


import liliyasavitska.gestioneviaggi.repositories.DipendentiRepository;
import liliyasavitska.gestioneviaggi.repositories.PrenotazioniRepository;
import liliyasavitska.gestioneviaggi.repositories.ViaggiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioniService {

    @Autowired
    private PrenotazioniRepository prenotazioneRepository;

    @Autowired
    private DipendentiRepository dipendenteRepository;

    @Autowired
    private ViaggiRepository viaggioRepository;


}