FROM alpine:latest

LABEL org.opencontainers.image.source https://github.com/couchpartygames/keycloak-extras

RUN mkdir -p /keycloak/providers && \
	chown -R nobody:nobody /keycloak/

USER nobody

	# Add Extensions
COPY providers/ /keycloak/providers

WORKDIR /keycloak
