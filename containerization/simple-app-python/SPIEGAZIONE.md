Questo esercizio propone il più semplice esempio di generazione di un'immagine docker tramite dockerfile. 
In questo esercizio si ha un solo script in python. 

Il docker file istruisce docker per la realizzazione del container. In particolare: 


L'immagine del container viene generata partendo da un'immagine base che in questo caso è una versione opensource di un sistema operativo in cui gira python
```
# Use an official Python runtime as a parent image
FROM python:3.9-slim
```

Ci si sposta sulla cartella del container che ci interessa e ci copiamo il file script dalla cartella corrente sull'host.
```
# Set the working directory in the container
WORKDIR /app
# Copy the current directory contents into the container at /app
COPY . /app
```

Lanciamo lo script sul container.
```
# Run the command to execute the Python script
CMD ["python", "app.py"]
```

Per buildare il container e lanciarlo eseguiamo i comandi: 
In questo caso il container avrà il nome della cartella del progetto ovvero simple-app-python
```bash
docker buildx build -t simple-python-app .
docker images
docker run simple-python-app
```

```shell
PS C:\Users\franc\IdeaProjects\esercizi_commentati\containerization\simple-app-python> docker buildx build -t simple-python-app .     
[+] Building 0.9s (8/8) FINISHED                                                                                                                               docker:desktop-linux
=> [internal] load build definition from Dockerfile                                                                                                                           0.0s
=> => transferring dockerfile: 330B                                                                                                                                           0.0s
=> [internal] load metadata for docker.io/library/python:3.9-slim                                                                                                             0.7s
=> [internal] load .dockerignore                                                                                                                                              0.0s
=> => transferring context: 2B                                                                                                                                                0.0s
=> [1/3] FROM docker.io/library/python:3.9-slim@sha256:9aa5793609640ecea2f06451a0d6f379330880b413f954933289cf3b27a78567                                                       0.0s
=> => resolve docker.io/library/python:3.9-slim@sha256:9aa5793609640ecea2f06451a0d6f379330880b413f954933289cf3b27a78567                                                       0.0s
=> [internal] load build context                                                                                                                                              0.0s
=> => transferring context: 91B                                                                                                                                               0.0s
=> CACHED [2/3] WORKDIR /app                                                                                                                                                  0.0s
=> CACHED [3/3] COPY . /app                                                                                                                                                   0.0s
=> exporting to image                                                                                                                                                         0.1s
=> => exporting layers                                                                                                                                                        0.0s
=> => exporting manifest sha256:c7e0f9ebeee6ff05b92727eeb8bf150f19f3ae0a779af1bf2a8332aa18fcffcf                                                                              0.0s
=> => exporting config sha256:ce5c269287b1bb04a610b85d8f6356a98cf8393772187e39bbeb3e2e7baaa73a                                                                                0.0s
=> => exporting attestation manifest sha256:93c94e14ff9cbc0d0fe7b9c16991c9b7874141f42da8e0ecd6c742ead257b6f6                                                                  0.0s
=> => exporting manifest list sha256:b1d67ecef2fa65282153dfc211029c000d2d96fedee997f663e959ee5751cd41                                                                         0.0s
=> => naming to docker.io/library/simple-python-app:latest                                                                                                                    0.0s
=> => unpacking to docker.io/library/simple-python-app:latest                                                                                                                 0.0s

View build details: docker-desktop://dashboard/build/desktop-linux/desktop-linux/1bkjbcf0mxz70n7rj5r9kmerf
PS C:\Users\franc\IdeaProjects\esercizi_commentati\containerization\simple-app-python> docker images
REPOSITORY                                TAG       IMAGE ID       CREATED          SIZE
simple-python-app                         latest    b1d67ecef2fa   55 seconds ago   189MB
datetime-resiliency-datetime-composite    latest    c5040e26c06f   11 days ago      362MB
datetime-resiliency-date                  latest    938d2a763695   11 days ago      294MB
datetime-resiliency-time                  latest    5845150b37eb   11 days ago      294MB
datetime-resiliency-eureka                latest    887263b3aa47   11 days ago      302MB
grafana/tempo                             latest    f0bbfa128baf   11 days ago      155MB
grafana/loki                              latest    5fe9fa99e9a7   2 weeks ago      151MB
otel/opentelemetry-collector-contrib      latest    e39311df1f3d   2 weeks ago      417MB
service-discovery-eureka                  latest    aa6fd6e33cff   3 weeks ago      783MB
service-discovery-datetime-1              latest    0a6d2bc4a661   3 weeks ago      762MB
service-discovery-datetime-2              latest    928164a520e8   3 weeks ago      762MB
service-discovery-datetime-composite-ss   latest    478a6286717e   3 weeks ago      762MB
service-discovery-datetime-3              latest    575c49d79258   3 weeks ago      762MB
grafana/grafana                           latest    62d2b9d20a19   4 weeks ago      873MB
postgres                                  latest    fe3f571d128e   7 weeks ago      621MB
prom/prometheus                           v3.2.1    6927e0919a14   7 weeks ago      415MB
nginx                                     latest    124b44bfc9cc   2 months ago     279MB
redis                                     latest    4724941b3ff8   3 months ago     173MB
PS C:\Users\franc\IdeaProjects\esercizi_commentati\containerization\simple-app-python> docker run simple-python-app
Hello, Docker!
PS C:\Users\franc\IdeaProjects\esercizi_commentati\containerization\simple-app-python>
```