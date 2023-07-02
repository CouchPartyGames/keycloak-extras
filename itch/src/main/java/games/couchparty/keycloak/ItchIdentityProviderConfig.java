package games.couchparty.keycloak.provider;

import org.keycloak.models.IdentityProviderModel;

public class ItchIdentityProviderConfig extends IdentityProviderModel {

    public ItchIdentityProviderConfig() {
    }

    public ItchIdentityProviderConfig(IdentityProviderModel model) {
        super(model);
    }

    public String getItchApiKey() {
        return getConfig().get("itchApiKey");
    }

    public void setItchApiKey(String key) {
        getConfig().put("itchApiKey", key);
    }
}