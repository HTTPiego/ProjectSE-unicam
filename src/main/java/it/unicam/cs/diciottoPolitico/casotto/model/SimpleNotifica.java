package it.unicam.cs.diciottoPolitico.casotto.model;

import it.unicam.cs.diciottoPolitico.casotto.model.interfaces.Notifica;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notifica")
@Getter
@Setter
public class SimpleNotifica implements Notifica {

    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @Column(updatable = false)
    private String messaggio;

    @ManyToMany(mappedBy = "notifiche", fetch = FetchType.LAZY)
    @NonNull
    private List<SimpleUtente> utenti;

    public SimpleNotifica(){
        this.id = UUID.randomUUID();
        this.utenti = new ArrayList<>();
    }
}
