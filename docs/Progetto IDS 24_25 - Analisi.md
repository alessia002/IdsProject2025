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
| RF-01 | Consultazione del catalogo | Il sistema deve permettere di inserire e consultare un catalogo prodotti. | Utente Generico, Acquirente, Curatore | Alta |
| RF-02 | Gestione eventi | Il sistema deve consentire l’organizzazione e consultazione di eventi e fiere locali. | Animatore della Filiera, Acquirente, Sistemi OSM | Media |
| RF-03 | Consultazione filiera agricola | Il sistema deve permettere di inserire e consultare le informazioni su una filiera agricola. | Utente Generico, Acquirente, Produttore, Curatore, Sistemi OSM  | Alta |
| RF-04 | Tracciabilità prodotto | Il sistema deve esporre la tracciabilità dei prodotti lungo le fasi della filiera. | Utente Generico, Acquirente, Trasformatore, | Media |
| RF-05 | Consultazione mappa dei punti della filiera | La piattaforma deve permettere di visualizzare i punti della filiera. | Utente Generico, Acquirente, Trasformatore, Sistema OSM | Media |
| RF-06 | Recensioni | La piattaforma deve permettere di pubblicare e visualizzare valutazioni sui prodotti. | Acquirente, Utente generico, Sistemi Social, Produttore | Media |
| RF-07 | Gestione contenuti | Il sistema deve consentire al curatore di validare i contenuti prima della pubblicazione. | Curatore | Media |
| RF-08 | Creazione pacchetti | Il sistema deve consentire ai distributori di creare pacchetti di prodotti. | Distributore di Tipicità | Media |
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
|  |  |
|  |  |

## 

## Casi d’uso

| ID | Nome | Attori | Descrizione |
| ----- | ----- | ----- | ----- |
| UC-01 | Consultare catalogo | Utente Generico, Acquirente | L’utente accede al catalogo e visualizza i prodotti disponibili. |
| UC-02 | Pubblicare prodotti | Produttore, Trasformatore, Distributore di Tipicità | Un attore pubblica un prodotto per la vendita. |
| UC-03 | Creare pacchetti | Distributore di Tipicità | Il distributore crea un pacchetto di prodotti combinando più articoli. |
| UC-04 | Organizzare eventi | Animatore della Filiera | L’animatore crea un evento. |
| UC-05 | Acquistare prodotti | Acquirente | L’acquirente acquista un prodotto. |
| UC-06 | Validare contenuti | Curatore | Il curatore consulta e approva un contenuto. |
| UC-07 | Condividere contenuti sui social | Sistemi social destinatari di contenuti, Utente Generico, Acquirente, Distributore di Tipicità, Animatore | Un attore condivide un contenuto sui social |
| UC-08 | Prenotare la partecipazione a eventi | Acquirente | Un acquirente prenota la partecipazione a un evento. |
| UC-09 | Rimuovere prodotti | Produttore, Trasformatore, Distributore di Tipicità | Un attore rimuove un prodotto precedentemente pubblicato. |
| UC-10 | Modificare prodotti | Produttore, Trasformatore, Distributore di Tipicità | Un attore modifica un prodotto pubblicato. |
| UC-11 | Recensire prodotto | Utente generico, Acquirente | Un utente recensisce un prodotto. |
| UC-12 | Caricare prodotti | Produttore, Trasformatore, Distributore di Tipicità | Un attore carica un prodotto senza pubblicarlo. |
|  |  |  |  |

