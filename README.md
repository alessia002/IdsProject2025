# IdsProject2025

## Descrizione
Piattaforma dedicata alla gestione e valorizzazione della filiera agroalimentare locale.
Il sistema consente a produttori, trasformatori, distributori, curatori e altri attori della filiera di pubblicare informazioni, condividere contenuti, approvare dati, gestire eventi e vendere prodotti tramite marketplace.
Include inoltre funzionalità di geolocalizzazione e integrazione con canali social.

## Indice
1. [Installazione](#installazione)
2. [Tecnologie](#tecnologie)
3. [Uso](#uso)
4. [Note](#note)

## Installazione
- git clone https://github.com/alessia002/IdsProject2025.git
- cd IdsProject2025
- cd backend
- ./gradlew build | ./gradlew.bat build (win)
- cd frontend
- npm install

## Tecnologie
- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- REST API
- Gradle
- H2 Database (in-memory)
- Ionic Framework
- React

## Uso
- cd backend
- ./gradlew bootRun | ./gradlew.bat bootRun (win)
- cd frontend
- ionic serve
- https://localhost:8080
- https://localhost:8080/h2-console

## Note
Frontend in fase di sviluppo, utilizzare Postman