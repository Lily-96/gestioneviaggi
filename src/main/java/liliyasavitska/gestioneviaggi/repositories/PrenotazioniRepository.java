package liliyasavitska.gestioneviaggi.repositories;

import liliyasavitska.gestioneviaggi.entities.Dipendente;
import liliyasavitska.gestioneviaggi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    Optional<Prenotazione> findByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}
