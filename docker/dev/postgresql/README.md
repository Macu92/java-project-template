# Glassy backend postgresql DB

## How to build image?
1. Current version should be placed in app folder
2. Run `docker build -t new-project-name-postgresql .`

## How to run container based on previous image?
`docker run -p <host-port>:<docker-hosted-app-port> new-project-name-postgresql`

- host-port - host port that will be redirected to docker-hosted-app-port
- docker-hosted-app-port - port of application in docker. Default 15432

## How to do backup?
`docker exec new-project-name-postgresql pg_dump -U postgres -Fc new-project-name > ./pg_backups/new-project-name-$(date +%Y-%m-%dT%H-%M-%S).dump`

## How to restore backup?
TBD
