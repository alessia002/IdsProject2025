# Pattern Utilizzati nel Progetto

## 1. Evoluzione: Da Factory Method a Template Method nella Creazione degli Utenti

### Situazione attuale
La piattaforma utilizza una gerarchia di factory (`UserFactory`, `ProducerFactory`, `TransformerFactory`, ecc.) dove ogni sottoclasse ridefinisce il comportamento di autorizzazione dell’utente.  
Il processo di creazione dell'utente è centralizzato in `UserFactory.createUser()`, mentre i ruoli sono assegnati tramite override di `authorizeUser()`.

### Intenzione progettuale: **spostare completamente la logica verso un Template Method**
L’obiettivo è rendere esplicito il fatto che le factory non creano tipi diversi di utenti, ma personalizzano un passo fisso del processo.  
La classe base definirà il flusso completo di creazione come metodo *template*, mentre le sottoclassi forniranno unicamente le personalizzazioni nei metodi “hook” (`authorizeUser`, `unauthorizeUser`).

### Beneficio dell’evoluzione
- Processo di creazione stabile e formalizzato.
- Codice più pulito, meno override del metodo principale.
- Le factory diventano veri e propri definitori di comportamento, non creatori di oggetti.
- Coerenza architetturale con la responsabilità degli attori della piattaforma.


## 2. Decorator per l’Estensione dei Prodotti

### Pattern: **Decorator**
Realizzato tramite `ProductDecorator` e `ReviewDecorator`, consente di estendere dinamicamente le funzionalità degli oggetti `IProduct`, ad esempio con l’aggiunta di recensioni.

### Vantaggio
Aggiunta di comportamenti senza modificare le classi principali dei prodotti, favorendo modularità ed espandibilità.


## 3. Adapter per l’Integrazione con Sistemi Esterni

### Pattern: **Adapter**
Il componente `FacebookShareAdapter` adatta la piattaforma all’interfaccia di un social network esterno.  
Il pattern permette di integrare nuovi sistemi social senza alterare la logica interna.

