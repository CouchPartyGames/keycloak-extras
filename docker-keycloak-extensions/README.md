

## Purpose

Simple docker image used to add themes and extensions to keycloak's bitnami chart.


## Docker 

Docker image to store custom themes and extensions for keycloak. This is used to in container init images to install themes/extensions for keycloak chart.


	wget -O providers/<some-extension>.jar <url>
    docker build . -t keycloak-extras:<tag>


Push changes to Github Repository

    export CR_PAT=YOUR_TOKEN
	export TAG=YOUR_TAG
    echo $CR_PAT | docker login ghcr.io -u USERNAME --password-stdin

    docker tag keycloak-extras:$TAG ghcr.io/couchpartygames/keycloak-extras:$TAG
    docker tag keycloak-extras:$TAG ghcr.io/couchpartygames/keycloak-extras:latest

    docker push ghcr.io/couchpartygames/keycloak-extras:$TAG
    docker push ghcr.io/couchpartygames/keycloak-extras:latest


## Keycloak Bitnami Chart


Here is a small example of using init containers (in values.yaml) to install new extensions and themes to your keycloak server.
https://artifacthub.io/packages/helm/bitnami/keycloak

    initContainers:
      - name: custom-providers
        image: ghcr.io/couchpartygames/keycloak-extras:latest
        command: [ "sh", "-c", "cp -vR /keycloak/providers/* /providers" ]
        volumeMounts:
          - name: custom-providers
            mountPoint: /providers

    extraVolumes:
      - name: custom-providers
        emptyDir: {}

    extraVolumeMounts:
      - name: custom-providers
        mountPath: /providers

