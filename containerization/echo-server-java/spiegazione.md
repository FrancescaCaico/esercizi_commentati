Questo esercizio si propone di containerizzare un'applicazione java Spring tramite un dockerfile ad hoc. 

Il docker file è il seguente:

- L'immagine di partenza è eclipse-temurin con versione java 21.
- Si genera una variabile JAR_FILE locale al docker file che viene usata per istanziare il container. 
- Si copia il file jar (anche se ci sono + jar maven li unisce in uno solo) nel file application.jar interno al docker = nuovo strato
- L’istruzione ENTRYPOINT specifica il comando che verrà eseguito come processo principale del container. A differenza dell’istruzione CMD, i comandi ENTRYPOINT non vengono sovrascritti quando il container viene avviato con argomenti aggiuntivi. È usato per garantire che il container esegua sempre il processo specificato.
  - In questo caso l'entry point è il jar --> il nostro servizio implementato tramite spring. 

FROM eclipse-temurin:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"] 

Buildiamo l'immagine

docker buildx build -t echo-server-java:latest .

Nel buildare l'immagine ci rendiamo conto che: 

PS C:\Users\franc\IdeaProjects\esercizi_commentati\containerization\echo-server-java> docker images
REPOSITORY                                TAG       IMAGE ID       CREATED          SIZE
echo-server-java                          latest    43425f158e21   8 seconds ago    751MB

L'immagine generata è grande quasi un GB --> bisogna ottimizzare il dockerfile.

- Cambiare l'immagine di base: in modo che usando un'immagine più piccola si abbia un minore dispendio di memoria
- JLINK --> da una JDK si genera una JDK ottimizzata in cui si scartano i metodi che non uso + processi di building multistage.
