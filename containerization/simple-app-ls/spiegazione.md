Questo esercizio propone il più semplice esempio di generazione di un'immagine docker tramite dockerfile.
In questo esercizio si genera un container che contiene il comando ls e lo esegue.

Il docker file istruisce docker per la realizzazione del container. In particolare:

# Use an official Alpine Linux image as a parent image: questa immagine ha già ls all'interno.
FROM alpine:3.18

# Run the ls command
CMD ["ls", "-al"]

Per buildare il container e lanciarlo eseguiamo i comandi:
In questo caso il container avrà il nome della cartella del progetto ovvero simple-app-python
```bash
docker buildx build -t simple-app-ls .
```

```bash
docker images
```
```bash
docker run simple-app-ls
```
