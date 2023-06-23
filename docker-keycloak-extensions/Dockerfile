FROM alpine:latest

RUN mkdir -p /keycloak/themes /keycloak/extensions && \
	chown -R nobody:nobody /keycloak/

USER nobody

	# Add Themes
COPY themes/ /keycloak/themes

	# Add Extensions
COPY extensions/ /keycloak/extensions


WORKDIR /keycloak
