package liliyasavitska.gestioneviaggi.repositories;

import liliyasavitska.gestioneviaggi.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {
    Optional<Dipendente> findByEmail(String email);
}
