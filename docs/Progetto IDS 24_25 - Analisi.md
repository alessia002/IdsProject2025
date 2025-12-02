# Progetto IDS 24/25

Questo documento definisce requisiti, glossario e casi d’uso per il progetto di Ingegneria del Software.

# Iterazione 0

## Attori

1. **Produttore**: può caricare informazioni sui propri prodotti (metodi di coltivazione, certificazioni ecc.) e venderli nel marketplace.  
2. **Trasformatore**: può caricare informazioni sui processi di trasformazione dei prodotti e sulle certificazioni di qualità, con la possibilità di collegare le fasi della produzione ai produttori locali. Può vendere i prodotti nel marketplace.  
3. **Distributore di Tipicità**: può caricare informazioni relative ai prodotti in vendita. Questi prodotti possono essere venduti singolarmente tramite il marketplace. Inoltre, il distributore può creare pacchetti di prodotti che combinano più articoli in un’unica offerta, favorendo l’acquisto di esperienze gastronomiche legate al territorio.  
4. **Curatore**: verifica i contenuti caricati dai produttori, trasformatori e venditori. Gestisce la validità delle informazioni e le approva prima della pubblicazione.   
5. **Animatore della Filiera:** può organizzare eventi e fiere invitando produttori, trasformatori e venditori. Inoltre, può proporre visite alle aziende, come eventi di presentazione e tour di degustazione.  
6. **Acquirente**: accede alla piattaforma per informarsi sulla provenienza dei prodotti e può acquistare dai vari attori della filiera. Può inoltre prenotare la partecipazione a fiere ed eventi.  
7. **Utente Generico**: accede ai contenuti per informarsi sulla provenienza e la qualità dei prodotti locali.  
8. **Gestore della Piattaforma**: ha la responsabilità di gestire gli aspetti amministrativi della piattaforma, le autorizzazioni e gli accrediti per gli attori coinvolti.  
9. **Sistemi Social destinatari di contenuti**:  gli utenti che creano contenuti possono condividerli sui propri canali social.  
10. **Sistema OSM**: fornisce informazioni sulle mappe del territorio e la visualizzazione dei punti della filiera agricola.

## 

## 

## 

## Requisiti

| ID | Nome | Descrizione | Attori | Priorità |
| ----- | ----- | ----- | ----- | ----- |
| RF-01 | Consultazione dei contenuti | Il sistema deve permettere di consultare contenuti. | Utente Generico, Acquirente, Curatore | Alta |
| RF-02 | Gestione eventi | Il sistema deve consentire l’organizzazione e consultazione di eventi e fiere locali. | Animatore della Filiera, Acquirente, Sistemi OSM | Media |
| RF-03 | Consultazione filiera agricola | Il sistema deve permettere di inserire e consultare le informazioni su una filiera agricola. | Utente Generico, Acquirente, Produttore, Curatore, Sistemi OSM  | Alta |
| RF-04 | Tracciabilità prodotto | Il sistema deve esporre la tracciabilità dei prodotti lungo le fasi della filiera. | Utente Generico, Acquirente, Trasformatore, | Media |
| RF-05 | Consultazione mappa dei punti della filiera | La piattaforma deve permettere di visualizzare i punti della filiera. | Utente Generico, Acquirente, Trasformatore, Sistema OSM | Media |
| RF-06 | Recensioni | La piattaforma deve permettere di pubblicare e visualizzare valutazioni sui prodotti. | Acquirente, Utente generico, Sistemi Social, Produttore | Media |
| RF-07 | Validazione contenuti | Il sistema deve consentire al curatore di validare i contenuti prima della pubblicazione. | Curatore | Media |
| RF-08 | Creazione contenuti | Il sistema deve consentire la creazione di contenuti. | Distributore di Tipicità, Produttore, Trasformatore | Alta |
| RF-09 | Condivisione sui social media | Il sistema deve permettere la condivisione dei contenuti sui social degli utenti. | Sistemi social destinatari di contenuti, Utente Generico, Acquirente, Distributore di Tipicità, Animatore | Media |
| RF-10 | Gestione autorizzazioni | Il sistema deve permettere di gestire le autorizzazioni degli attori | Gestore della piattaforma | Media |
| RF-11 |  |  |  |  |
|  |  |  |  |  |

## Glossario

| Termine | Definizione |
| ----- | ----- |
| Catalogo prodotti | Elenco dei prodotti agricoli disponibili per la consultazione online. |
| Tracciabilità | Capacità di seguire e registrare ogni fase della produzione di un prodotto, dalla coltivazione alla vendita. |
| Evento | Attività pianificata per promuovere i prodotti agricoli locali, come fiere o mercati. |
| Pacchetto | Combinazione di prodotti offerti insieme dal distributore. |
| Contenuti | Prodotti, pacchetti, cataloghi, processi di trasformazione, certificazioni di qualità, metodi di coltivazione. |
|  |  |

## 

## Casi d’uso

| ID | Nome | Attori | Descrizione |
| ----- | ----- | ----- | ----- |
| UC-01 | Consultare contenuti | Utente Generico, Acquirente | L’utente accede al catalogo e visualizza i contenuti disponibili. |
| UC-02 | Pubblicare contenuti | Produttore, Trasformatore, Distributore di Tipicità | Un attore pubblica un prodotto per la vendita. |
| UC-03 | Organizzare eventi | Animatore della Filiera | L’animatore crea un evento. |
| UC-04 | Acquistare prodotti | Acquirente | L’acquirente acquista un prodotto. |
| UC-05 | Validare contenuti | Curatore | Il curatore consulta e approva un contenuto. |
| UC-06 | Condividere contenuti sui social | Sistemi social destinatari di contenuti, Utente Generico, Acquirente, Distributore di Tipicità, Animatore | Un attore condivide un contenuto sui social |
| UC-07 | Prenotare la partecipazione a eventi | Acquirente | Un acquirente prenota la partecipazione a un evento. |
| UC-08 | Rimuovere contenuti | Produttore, Trasformatore, Distributore di Tipicità | Un attore rimuove un contenuto precedentemente pubblicato. |
| UC-09 | Modificare contenuti | Produttore, Trasformatore, Distributore di Tipicità | Un attore modifica un contenuto pubblicato. |
| UC-10 | Recensire prodotto | Utente generico, Acquirente | Un utente recensisce un prodotto. |
| UC-11 | Creazione contenuti | Produttore, Trasformatore, Distributore di Tipicità | Un attore crea un contenuto senza pubblicarlo. |
| UC-12 | Valutare richiesta di registrazione | Gestore della piattaforma | Il gestore della piattaforma approva o rifiuta una richiesta di registrazione |
| UC-13 | Richiedere la registrazione | Produttore, Trasformatore, Distributore di Tipicità | Un attore invia una richiesta di registrazione  |
| UC-14  | Visualizzare la mappa dei punti di filiera | Utente generico, Acquirente, Trasformatore, Sistema OSM | L’ utente visualizza sulla mappa i punti della filiera agricola |
| UC-15 | Consultare tracciabilità dell’ordine | Utente generico, Acquirente, Trasformatore | L’ utente accede alla scheda di un ordine e ne visualizza lo stato |
| UC-16 | Gestione ruoli attori | Gestore della piattaforma | Il gestore assegna, modifica o revoca i ruoli degli attori nella piattaforma |
| UC-17 | Consultare filiera agricola | Utente generico, Acquirente, Produttore, Curatore | L’ utente consulta le informazioni relative alla filiera agricola, comprese le relazioni tra produttori e trasformatori |

## 

# Iterazioni

| Iterazione | Caso d’uso |
| :---- | :---- |
| 1 | Creazione contenuti |
| 1 | Modifica Contenuti |
| 1 | Rimozione contenuti |
| 1 | Pubblicazione contenuti |
|  |  |
| 2 | Consultazione contenuti |
| 2 | Acquisto prodotti |
| 2 | Recensione prodotti |
|  |  |
| 3 | Consultazione tracciabilità ordine |
| 3 | Validazione contenuti |
| 3 | Consultazione della filiera |
|  |  |
| 4 | Richiesta registrazione |
| 4 | Valutazione richiesta registrazione |
| 4 | Gestione autorizzazioni attori |
|  |  |
| 5 | Organizzazione eventi |
| 5 | Prenotazione e partecipazione eventi |
| 5 | Condivisione contenuti sui social |
| 5 | Visualizzazione punti filiera |
|  |  |

# Casi d’uso dettagliati

Formato:

- id  
- nome  
- attori  
- descrizione  
- pre-condizioni  
- post-condizioni (creazione o cancellazione di un oggetto, formazione o rottura di collegamento, cambiamento valore di un attributo)  
- frequenza d’uso  
- sequenza principale  
- sequenza alternativa

#### ID: UC-01

Nome: Consultare contenuti.  
Attori: Utente Generico, Acquirente  
Descrizione: L’utente accede al catalogo e visualizza i contenuti disponibili, come prodotti, pacchetti o informazioni sulla filiera.  
Pre-condizioni: Nessuna  
Post-condizioni: E’ stato visualizzato un contenuto  
Frequenza d'uso: Alta, poichè la consultazione è un’ azione frequente degli utenti  
Sequenza principale:   
1- L’ utente accede alla piattaforma  
2- L’ utente seleziona la sezione dedicata ai contenuti  
3- Il sistema recupera l’ elenco dei contenuti disponibili  
4- L’ utente seleziona il contenuto che gli interessa  
5- Il sistema mostra i dettagli del contenuto  
6- L’ utente conclude la consultazione  
Sequenza alternativa:  
3a- Se non sono disponibili i contenuti, il sistema fa visualizzare un messaggio informativo  
4a- Se il contenuto selezionato non è più disponibile, il sistema fa visualizzare un messaggio informativo propone contenuti simili

#### ID: UC-02

Nome: Pubblicare contenuti  
Attori: Produttore, Trasformatore, Distributore di Tipicità  
Descrizione: Un attore pubblica un contenuto rendendolo visibile agli utenti della piattaforma  
Pre-condizioni:   
\-L’ attore è autenticato  
\-L’ attore ha creato un contenuto in stato bozza  
Post-condizioni: Il contenuto è pubblicato ed è visibile agli utenti autorizzati  
Frequenza d'uso: Frequente, legata all’ aggiornamento dell’ offerta  
Sequenza principale:  
1-L’ attore accede alla sezione bozze  
2-L’ attore seleziona il contenuto da pubblicare  
3-Il sistema mostra l’ anteprima del contenuto   
4-L’ attore conferma la pubblicazione  
5-Il sistema aggiorna lo stato del contenuto da bozza a pubblicato  
6-Il sistema notifica la corretta pubblicazione  
Sequenza alternativa:  
3a- Se mancano informazioni obbligatorie, il sistema notifica l’ attore e impedisce la pubblicazione  
4a-L’ attore decide di modificare il contenuto prima della pubblicazione

#### ID: UC-03

Nome: Organizzare eventi  
Attori: Animatore della Filiera  
Descrizione: L ‘animatore crea un evento o una filiera inserendo informazioni come luogo, data, partecipanti e descrizione  
Pre-condizioni: L'animatore della è autenticato ed è autorizzato a creare eventi   
Post-condizioni: L’ evento è registrato nel sistema in stato “programmato” e visibile agli utenti  
Frequenza d'uso: Media, dipende quando sono stati programmati gli eventi  
Sequenza principale:  
1-L’ animatore accede alla sezione “Gestione eventi”  
2-L’ animatore selezione “Crea nuovo evento”   
3-L’ animatore inserisci i dati richiesti   
4-Il sistema valida i dati e crea l’ evento  
5-Il sistema conferma la creazione dell’ evento  
6-L’ evento diventa visibile agli utenti per la consultazione/ prenotazione  
Sequenza alternativa:  
3a-L’ animatore omette dati obbligatori, il sistema richiede l'inserimento  
4a-Il sistema rileva conflitti di orario o luogo e notifica l’ animatore che può modificare i dati

#### ID: UC-04

Nome: Acquistare prodotti  
Attori: Acquirente  
Descrizione: L’ acquirente seleziona un prodotto dal marketplace e procede al suo acquisto  
Pre-condizioni:   
\-L’ acquirente è autenticato  
\-Il prodotto è disponibile all’ acquisto  
Post-condizioni: L’ ordine è registrato nel sistema e lo stato iniziale dell’ ordine è creato  
Frequenza d'uso: Alta, quando si vende molto  
Sequenza principale:  
1-L’ acquirente accede al marketplace  
2-L’ acquirente seleziona un prodotto  
3-Il sistema mostra i dettagli del prodotto  
4-L’ acquirente aggiunge il prodotto al carrello  
5-L’ acquirente conferma l’ ordine  
6-Il sistema registra l’ ordine e genera un identificativo univoco  
7-Il sistema conferma l’ avvenuto acquisto  
Sequenza alternativa:  
2a- Il prodotto non è più disponibile, il sistema mostra un messaggio informativo e propone articoli simili  
5a-Pagamento non andato a buon fine, il sistema richiede di fare un nuovo tentativo o scegliere un altro metodo di pagamento

#### ID: UC-05

Nome: Validare contenuti  
Attori:Curatore  
Descrizione: Il curatore visiona i contenuti caricati dai produttori, trasformatori e/o distributori e ne approva la pubblicazione per garantirne correttezza e qualità  
Pre-condizioni:  
\-Il curatore è autenticato  
\-Sono presenti contenuti in stato di “attesa validazione”  
Post-condizioni:  
\-Il contenuto viene approvato: diventa pubblicabile o viene pubblicato  
\-Il contenuto viene rifiutato: torna accessibile e modificabile dall’ autore  
Frequenza d'uso: Media, in base ai contenuti generati  
Sequenza principale:  
1-Il curatore accede all’ area “contenuti da validare”  
2-Il curatore seleziona un contenuto dalla lista  
3-Il sistema mostra i dettagli del contenuto  
4-Il curatore valuta il contenuto  
5-Il curatore approva il contenuto  
6-Il sistema aggiorna il contenuto come validato  
Sequenza alternativa:  
4a-Il curatore rileva errori o incongruenze e rifiuta il contenuto  
4b-Il sistema registra il rifiuto e notifica l’ autore indicando le modifiche richieste

#### ID: UC-11

Nome: Creazione contenuti.  
Attori: Produttore, Trasformatore, Distributore di Tipicità.  
Descrizione: Un attore crea un contenuto relativo alla propria attività nella filiera agricola, ma senza pubblicarlo immediatamente. Il contenuto resta in stato di bozza non visibile ai clienti fino alla pubblicazione.  
Pre-condizioni: L’attore è autenticato e ha i permessi necessari per creare contenuti nel sistema.  
Post-condizioni: Il contenuto è salvato nel sistema in stato bozza, pronto per essere modificato, eliminato o pubblicato successivamente.  
Frequenza d'uso: Frequente, la creazione è un processo continuo nella gestione della filiera digitale.  
Sequenza principale:

1. L’attore accede all’interfaccia di creazione contenuti nel sistema.  
2. L’attore inserisce o carica dati o informazioni relative al contenuto.  
3. L’attore salva il contenuto senza pubblicarlo, mantenendolo in stato bozza.  
4. Il sistema conferma il salvataggio del contenuto.  
5. L’attore potrà tornare in seguito per modificare, eliminare o pubblicare il contenuto.

Sequenza alternativa:  
2a. In caso di errori nel formato o dati mancanti, il sistema notifica l’attore per la correzione.  
3a. L’attore può decidere di annullare la creazione e non salvare il contenuto.

#### ID: UC-12

Nome: Valutare richiesta di registrazione.  
Attori: Gestore della piattaforma.  
Descrizione: Il gestore della piattaforma riceve una richiesta di registrazione da un attore della filiera e la valuta, approvandola o rifiutandola in base ai criteri e ai requisiti definiti per garantire la conformità e la coerenza delle registrazioni nel sistema.  
Pre-condizioni: Il gestore è autenticato e ha accesso allo strumento di valutazione delle richieste.  
Post-condizioni: La richiesta viene approvata e l’attore viene registrato oppure viene rifiutata con motivazioni comunicate al richiedente.  
Frequenza d'uso: Variabile, legata alle richieste di registrazione.  
Sequenza principale:

1. Il gestore accede all’elenco delle richieste di registrazione pendenti.  
2. Il gestore seleziona una richiesta da valutare e ne analizza i dati.  
3. Il gestore verifica la conformità ai requisiti di filiera.  
4. Il gestore prende una decisione di approvazione o rifiuto.  
5. Il sistema aggiorna lo stato della richiesta e notifica l’esito al richiedente.  
6. Il sistema archivia la valutazione per mantenere traccia per eventuali controlli futuri.

Sequenza alternativa:  
4a. Se la richiesta non soddisfa i requisiti, il gestore rifiuta la richiesta comunicando le motivazioni.

#### ID: UC-13

Nome: Richiedere la registrazione.  
Attori: Produttore, Trasformatore, Distributore di Tipicità.  
Descrizione: Un attore invia una richiesta di registrazione al sistema per essere riconosciuto ufficialmente come parte della filiera agricola o agroalimentare tipica, fornendo tutte le informazioni e la documentazione necessarie per la verifica e l’approvazione.  
Pre-condizioni: L’attore ha i requisiti necessari per la registrazione.  
Post-condizioni: La richiesta viene ricevuta e messa in valutazione; l’attore viene registrato nel sistema o riceve comunicazione su eventuali problematiche.  
Frequenza d'uso: Variabile, solitamente in fase iniziale di adesione.  
Sequenza principale:

1. L’attore accede al modulo di registrazione nel sistema.  
2. L’attore compila la richiesta inserendo i dati necessari.  
3. L’attore invia la richiesta per la valutazione.  
4. Il sistema riceve la richiesta e notifica la ricezione al richiedente.  
5. L’attore riceve notifica sull’esito della richiesta.

Sequenza alternativa:  
3a. Se la richiesta è incompleta o errata il sistema richiede integrazioni prima di procedere.

#### ID: UC-14

Nome: Visualizzare la mappa dei punti filiera.  
Attori: Utente generico, Acquirente, Trasformatore, Sistema OSM.  
Descrizione: L’utente visualizza sulla mappa i punti della filiera agricola, come i luoghi di produzione, trasformazione e distribuzione, per comprendere la geolocalizzazione e la distribuzione territoriale degli attori e delle attività nella filiera.  
Pre-condizioni: Nessuna.  
Post-condizioni: L’utente ha ottenuto una rappresentazione visiva sulla mappa dei punti filiera di interesse della filiera agricola.  
Frequenza d'uso: Variabile, dipende dalle necessità informative dell’utente.  
Sequenza principale:

1. L’utente accede al sistema di visualizzazione mappa.  
2. Il sistema recupera i dati geografici relativi ai punti filiera.  
3. Il sistema mostra sulla mappa i punti filiera.  
4. L’utente esplora la mappa.  
5. L’utente conclude la consultazione.

Sequenza alternativa:  
3a. Se i dati geografici non sono disponibili o il sistema di mappa è offline, viene mostrato un messaggio di errore.  
4a. L’utente può richiedere aggiornamenti o segnalare dati errati per migliorare la correttezza della mappa.

#### ID: UC-15

Nome: Consultare la tracciabilità dell’ordine.  
Attori: Utente generico, Acquirente, Trasformatore.  
Descrizione: L’utente accede alla scheda di un ordine e ne visualizza lo stato attuale, potendo consultare lo storico delle fasi operative e le informazioni di tracciabilità, garantendo trasparenza lungo tutta la filiera produttiva e distributiva.  
Pre-condizioni: L’utente è autenticato e autorizzato ad accedere alle informazioni degli ordini.  
Post-condizioni: L’utente ha visualizzato le informazioni aggiornate e dettagliate riguardanti lo stato e la tracciabilità dell’ordine.  
Frequenza d'uso: Frequente, legata alle fasi di verifica e monitoraggio da parte degli attori della filiera.  
Sequenza principale:

1. L’utente si autentica e accede al sistema.  
2. L’utente seleziona l’ordine di interesse dalla lista ordini.  
3. Il sistema recupera e mostra la scheda dell’ordine con lo stato attuale e lo storico delle operazioni.  
4. L’utente analizza i dettagli di tracciabilità, come fasi completate e date.  
5. L’utente termina la consultazione.

Sequenza alternativa:  
3a. Se l’ordine non viene trovato o non è accessibile, il sistema notifica l’utente e suggerisce una ricerca alternativa.  
4a. In caso di dati mancanti o non aggiornati, il sistema informa e consente di riprovare in un secondo momento.

#### ID: UC-16

Nome: Gestione ruoli attori.  
Attori: Gestore della piattaforma.  
Descrizione: Il gestore della piattaforma assegna, modifica o revoca i ruoli degli attori all’interno della piattaforma, in base alle necessità operative e di sicurezza.  
Pre-condizioni: Il gestore è autenticato e autorizzato a gestire i ruoli nella piattaforma.  
Post-condizioni: I ruoli degli attori sono aggiornati correttamente nella piattaforma e i relativi permessi sono coerenti con le nuove assegnazioni.  
Frequenza d'uso: Periodica, in base alle esigenze di gestione utenti e modifiche organizzative.  
Sequenza principale: 

1. Il gestore accede al pannello di amministrazione dei ruoli nella piattaforma.  
2. Il gestore seleziona l’utente di cui modificare il ruolo.  
3. Il gestore assegna, modifica o revoca il ruolo desiderato.  
4. Il sistema valida le modifiche e aggiorna i dati relativi ai ruoli.  
5. Il gestore riceve conferma dell’avvenuta modifica.  
6. L’attore interessato ha i permessi aggiornati per le funzioni corrispondenti al nuovo ruolo.

Sequenza alternativa:  
3a. In caso di errore, come ruolo non valido o permessi insufficienti, il sistema notifica il gestore e permette di correggere.  
4a. Se l’attore non esiste o non ha diritti modificabili, il sistema informa il gestore e annulla l’operazione.

#### ID: UC-17

Nome: Consultare filiera agricola.  
Attori: Utente generico, Acquirente, Produttore, Curatore.  
Descrizione: L’utente consulta le informazioni relative alla filiera agricola.  
Pre-condizioni: Nessuna.  
Post-condizioni: L’utente ottiene le informazioni sulla filiera.  
Frequenza d'uso: Variabile in base alle necessità degli attori.  
Sequenza principale:

1. L’utente accede al sistema di consultazione della filiera agricola.  
2. Il sistema recupera e mostra le informazioni relative alla filiera.  
3. L’utente esplora i dettagli della filiera.  
4. L’utente termina la consultazione.

Sequenza alternativa:  
2a. Se non sono disponibili informazioni sulla filiera, il sistema notifica l’assenza di dati.  
