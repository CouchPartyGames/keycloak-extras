

## Purpose

Simple docker image used to add themes and extensions to keycloak's bitnami chart.


## Docker 

Docker image to store custom themes and extensions for keycloak. This is used to in container init images to install themes/extensions for keycloak chart.


	wget -O extensions/<some-extension>.jar <url>
	wget -O themes/<some-theme>.jar <url>
    docker build . -t <name>:<tag>


Push changes to Github Repository

    export CR_PAT=YOUR_TOKEN
    echo $CR_PAT | docker login ghcr.io -u USERNAME --password-stdin
    docker push ghcr.io/couchpartygames/IMAGE_NAME:latest
    docker push ghcr.io/couchpartygames/IMAGE_NAME:latest


## Keycloak Bitnami Chart


Here is a small example of using init containers (in values.yaml) to install new extensions and themes to your keycloak server.
https://artifacthub.io/packages/helm/bitnami/keycloak

    initContainers:
      - name: custom-themes
        image: ghcr.io/couchpartygames/keycloak-extras:latest
        command: [ "sh", "-c", "cp -vR /keycloak/themes/* /themes" ]
        volumeMounts:
          - name: custom-themes
            mountPoint: /themes
      - name: custom-extensions
        image: ghcr.io/couchpartygames/keycloak-extras:latest
        command: [ "sh", "-c", "cp -vR /keycloak/extensions/* /extensions" ]
        volumeMounts:
          - name: custom-extensions
            mountPoint: /extensions

    extraVolumes:
      - name: custom-themes
        emptyDir: {}
      - name: custom-extensions
        emptyDir: {}

    extraVolumeMounts:
      - name: custom-themes
        mountPath: /opt/bitnami/keycloak/themes
        emptyDir: {}

