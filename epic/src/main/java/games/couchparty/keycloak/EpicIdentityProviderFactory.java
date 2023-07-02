ackage games.couchparty.keycloak.provider;

import org.keycloak.Config;
import org.keycloak.broker.social.SocialIdentityProviderFactory;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class EpicIdentityProviderFactory implements SocialIdentityProviderFactory<EpicIdentityProvider> {

    @Override
    public String getName() {
        return "Epic OpenID2";
    }

    @Override
    public EpicIdentityProvider create(KeycloakSession keycloakSession, IdentityProviderModel identityProviderModel) {
        return new EpicIdentityProvider(keycloakSession, new EpicIdentityProviderConfig(identityProviderModel));
    }

    @Override
    public Map<String, String> parseConfig(KeycloakSession keycloakSession, InputStream inputStream) {
        return new HashMap<>();
    }

    @Override
    public EpicIdentityProvider create(KeycloakSession keycloakSession) {
        return null;
    }

    @Override
    public void init(Config.Scope scope) {
    }

	@Override
    public EpicIdentityProviderConfig createConfig() {
		return new EpicIdentityProviderConfig();
	}

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "epic";
    }
}