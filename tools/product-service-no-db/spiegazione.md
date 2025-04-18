# ** PRODUCT SERVICE NO DB **
Questo esercizio ci propone la realizzazione di un primo progetto SPRING seguendo un'architettura clean a 3 livelli implementati nella cartella _src.main.java.nbicocchi.product_: 
- Livello di persistenza: è il livello che si interfaccia con lo storage o i dispositivi di archiviazione fisici o in cloud. Il livello di persistenza gestisce due componenti: 
  - REPOSITORY --> si occupa di implementare le funzionalità CRUD sul database agendo sull'entità generica che in questo caso è definita dal MODEL  
  - MODEL --> L'entità oggetto delle operazioni CRUD che in questo caso è identificata dal prodotto. 
- Livello di servizio: è il servizio che si occupa di mediare l'interazione tra il livello di presentazione e il livello di persistenza. Mappa le operazioni del livello di presentazione su quello di persistenza
- Livello di presentazione: è definito dal controller. È il livello in cui l'utente interagisce con il servizio: dove troviamo le operazioni HTTP.

Il file APP.java definisce la classe starter del progetto ed è annotata con @SpringBootApplication 

Nel package resources troviamo *application.yml*: è un file di configurazione utilizzato dalle applicazioni Spring Boot per definire parametri di configurazione dell'applicazione in un formato leggibile (YAML).
```
server:
port: 7001

---
spring.config.activate.on-profile: docker
server:
  port: 8080

---
spring.config.activate.on-profile: no-banner
spring:
  main:
    banner-mode: off
```
In questo caso ci sono 3 configurazioni:
- La *configurazione di default* indica che il server dell'applicazione Spring Boot deve ascoltare sulla porta 7001. Questi parametri saranno utilizzati a meno che non venga sovrascritti da un profilo specifico.
- Una configurazione quando il profilo `docker` è attivo. In questo caso, il server sarà configurato per ascoltare sulla porta **8080**. Questo è utile quando si desidera eseguire l'applicazione in un ambiente Docker, dove si usa comunemente una porta diversa.
- In questa sezione, si attiva la configurazione quando il profilo `no-banner` è attivo.
  - La chiave `banner-mode: off` disabilita il banner di avvio predefinito di Spring Boot. Questo è utile se si desidera una console più pulita o si desidera evitare che il banner venga visualizzato nei log, ad esempio in un ambiente di produzione.

PER LANCIARE TUTTO IL PROGETTO: 
1. generare il jar con: ```mvn clean package -Dmaven.skip.test=true```

2. ``` java -jar target/product-service-no-db-0.0.1-SNAPSHOT.jar```

3. oppure: ```mvn spring-boot:run```
