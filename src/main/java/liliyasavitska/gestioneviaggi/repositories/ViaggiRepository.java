package liliyasavitska.gestioneviaggi.repositories;

import liliyasavitska.gestioneviaggi.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViaggiRepository extends JpaRepository<Viaggio, UUID> {
}
