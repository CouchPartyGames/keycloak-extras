

## Purpose

Use docker image to extend both the functionality and theme of keycloak using Init Container functionality of kubernetes.


## Docker 

Docker image to store custom themes and extensions for keycloak. This is used to in container init images to install themes/extensions for keycloak chart.


	wget -O extensions/<some-extension>.jar <url>
	wget -O themes/<some-theme>.jar <url>
    docker build . -t <name>:<tag>


#### Keycloak Bitnami Chart

Here is a small example of using init containers to install new extensions and themes to your keycloak server.

#initContainers:
#  - name: custom-themes
#    image: <your-image>
#    command: [ "sh", "-c", "cp -vR /keycloak/themes/* /themes" ]
#    volumeMounts:
#      - name: custom-themes
#        mountPoint: /themes
#  - name: custom-extensions
#    image: ghcr.io/couchpartygames/
#    command: [ "sh", "-c", "cp -vR /keycloak/extensions/* /extensions" ]
#    volumeMounts:
#      - name: custom-extensions
#        mountPoint: /extensions

    extraVolumes:
      - name: custom-themes
        emptyDir: {}
      - name: custom-extensions
        emptyDir: {}

    extraVolumeMounts:
      - name: custom-themes
        mountPath: /opt/bitnami/keycloak/themes
        emptyDir: {}

