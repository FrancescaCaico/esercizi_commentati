# PRODUCT-SERVICE-H2
## ESEMPIO DI SPRING JPA: PERSISTENZA DEI DATI

In questo esercizio si prende dimestichezza con il plugin JPA di Spring per la gestione della persistenza. 
L'esercizio implementa un servizio di visualizzazione e modifica di prodotti. 
In questo caso: 
- Livello di persistenza: è il livello che si interfaccia con lo storage o i dispositivi di archiviazione fisici o in cloud. Il livello di persistenza gestisce due componenti:
    - REPOSITORY --> si occupa di implementare le funzionalità CRUD sul database agendo sull'entità generica che in questo caso è definita dal MODEL --> in questo caso il repository implementa dello di JPA CRUD. 
    - MODEL --> L'entità oggetto delle operazioni CRUD che in questo caso è identificata dal prodotto.
- Livello di servizio: è il servizio che si occupa di mediare l'interazione tra il livello di presentazione e il livello di persistenza. Mappa le operazioni del livello di presentazione su quello di persistenza
- Livello di presentazione: è definito dal controller. È il livello in cui l'utente interagisce con il servizio: dove troviamo le operazioni HTTP.

L'accesso al database h2 necessita di alcune configurazioni che vengono specificate nel solito file application.yml: 

```
spring:
    datasource:
        url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
        username: sa
        password:
    jpa:
        open-in-view: false
        hibernate.ddl-auto: create-drop
        defer-datasource-initialization: true
    sql:
        init.mode: always
    h2:
        console:
        enabled: true
```