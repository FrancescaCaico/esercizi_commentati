Questo esercizio propone la generazione di un'immagine di container Docker per un server flask.
Il package contiene 3 file: dockerfile, requirements.txt (contiene le dipendenze per il funzionamento di flask e del server) e app.py (che si occupa di eseguire l'echo della richiesta pervenuta al server)
Il docker file istruisce docker per la realizzazione del container. In particolare:

```dockerfile
# Use the official Python image
FROM python:3.9-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container
COPY . .

# Install the required packages
RUN pip install -r requirements.txt

# Expose port 5000 for the Flask app sul container non sull'host fisico. Bisogna mappare sia quella dell'host che quella del container --> si fa solitamente nell'application.yml
EXPOSE 5000

# Define the command to run the application
CMD ["python", "app.py"]
```

Per buildare il container e lanciarlo eseguiamo i comandi:
In questo caso il container avrà il nome della cartella del progetto ovvero simple-app-python
```bash
docker buildx build -t echo-server-flask .
```

```bash
docker images
```
```bash
docker run simple-app-ls
```
