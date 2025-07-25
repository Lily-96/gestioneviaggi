package liliyasavitska.gestioneviaggi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Dipendente {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String nome;
    private String cognome;
    private String email;


    public Dipendente(String nome, String cognome, String email, String username) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }


}
