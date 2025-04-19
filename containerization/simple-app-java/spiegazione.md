Questo esercizio propone il più semplice esempio di generazione di un'immagine docker tramite dockerfile.
In questo esercizio si ha un solo script in java.

Il docker file istruisce docker per la realizzazione del container. In particolare:

Si compila il sorgente direttamente dentro l'immagine. Solitamente viene compilato sulla macchina host e poi inserito direttamente nel container
Per scopi didattici: 

```
# OpenJDK runtime as a parent image
FROM eclipse-temurin:21

# Set the working directory in the container
WORKDIR /app

Si copia il file App.java
# Copy the current directory contents into the container at /app
COPY . /app

Si crea un nuovo layer che conterrà il sorgente compilato tramite javac 
# Compile the Java program
RUN javac App.java

# Run the Java program
CMD ["java", "App"]
```

Per buildare il container e lanciarlo eseguiamo i comandi:
In questo caso il container avrà il nome della cartella del progetto ovvero simple-app-python
```bash
docker buildx build -t simple-java-app .
docker images
docker run simple-python-app
```
