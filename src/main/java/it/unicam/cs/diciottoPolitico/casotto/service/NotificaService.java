package it.unicam.cs.diciottoPolitico.casotto.service;

import it.unicam.cs.diciottoPolitico.casotto.entity.Utente;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleNotifica;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.repository.NotificaRepository;
import it.unicam.cs.diciottoPolitico.casotto.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificaService extends AbstractService<SimpleNotifica,NotificaRepository>{

    private final UtenteRepository utenteRepository;

    @Autowired
    public NotificaService(NotificaRepository notificaRepository, UtenteRepository utenteRepository) {
        super(notificaRepository);
        this.utenteRepository = utenteRepository;
    }

    // Td0: 25/01/22
    // TODO: 25/01/22
    public void inviaNotifica(SimpleNotifica notifica) {
        //this.notificaRepository.save(notifica);
        this.utenteRepository.
                findAllById(this.getUUIDs(notifica.getUtenti())).
                forEach(utente -> {
                    utente.getNotifiche().add(notifica);
                    this.utenteRepository.save(utente);
                    // necessario risalvare l' utente per salvare la coppia (utente_id,notifica_id)
                    // nella tabella della relazione molti a molti
                });
    }

    private List<UUID> getUUIDs(List<SimpleUtente> utentiDestinatari) {
        return utentiDestinatari.stream().map(SimpleUtente::getId).collect(Collectors.toList());

    }

    public void rimuoviNotifica(SimpleNotifica notifica) {
        //this.notificaRepository.delete(notifica);
        this.utenteRepository.
                findAllById(this.getUUIDs(notifica.getUtenti())).
                forEach(utente -> {
                    utente.getNotifiche().remove(notifica);
                    this.utenteRepository.save(utente);
                });
    }


}