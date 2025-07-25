package liliyasavitska.gestioneviaggi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate dataRichiesta;
    private String note;

    @ManyToOne
    private Dipendente dipendente;
    @ManyToOne
    private Viaggio viaggio;
}
