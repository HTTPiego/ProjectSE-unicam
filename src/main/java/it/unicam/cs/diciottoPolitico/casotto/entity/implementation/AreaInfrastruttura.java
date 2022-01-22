package it.unicam.cs.diciottoPolitico.casotto.entity.implementation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Rappresenta un' area dell' infrastruttura chalet che si occupa di fornire informazioni su
 * questa stessa area specifica.
 */
@Entity
@Table(name = "area_infrastruttura")
@EqualsAndHashCode
public class AreaInfrastruttura {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    @Setter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String nome;

    @Column
    @Getter
    @Setter
    private String descrizione;

    /**
     * Crea un' area dell' infrastruttura dello chalet in base a id, nome e descrizione specificati.
     *
     * @param nome        il nome di quest' area infrastruttura
     * @param descrizione la descrizione di quest' area infrastruttura
     */
    public AreaInfrastruttura(String nome, String descrizione) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descrizione = descrizione;
    }

    protected AreaInfrastruttura() {
    }


}
