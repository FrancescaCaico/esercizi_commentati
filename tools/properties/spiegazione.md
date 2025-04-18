# Proprierties
Questo esercizio si basa su quello dei beans ed è un esempio di utilizzo delle proprierties.
Si riferiscono a un meccanismo di configurazione per gestire le impostazioni e i parametri dell'applicazione in modo flessibile e modulare. 
Le properties possono essere utilizzate per configurare variabili di ambiente, impostazioni di connessione, parametri di configurazione e altre informazioni necessarie per l'applicazione.
Le proprierties vengono definite all'interno dell'application.yml. 

In questo esercizio l'application.yml è il seguente: 

```
server:
  port: 7000

app:
  name: My Application
  version: 1.0.0
  max-users: 1000

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

In questo caso le proprierties sono indicate nella sezione "app" e sono 3: name, version, max-users che definiscono il nome, la versione e il numero di utenti massimo dell'app. 
Questi valori vengono poi utilizzati nella classe AppService: 

```
@Component
public class AppService {
private final String appName;
private final String appVersion;
private final Integer maxUsers;

Con l'annotazione @Value si estrapola il valore che si vuole assegnare in fase di costruzione all'istanza della classe AppService 

    public AppService(
            @Value("${app.name}") String appName,
            @Value("${app.version}") String appVersion,
            @Value("${app.max-users}") Integer maxUsers) {
        this.appName = appName;
        this.appVersion = appVersion;
        this.maxUsers = maxUsers;
    }

    @PostConstruct
    public void printAppDetails() {
        System.out.println("Application Name: " + appName);
        System.out.println("Version: " + appVersion);
        System.out.println("Max Users: " + maxUsers);
    }
}
```
