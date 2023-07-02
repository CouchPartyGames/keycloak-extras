package games.couchparty.keycloak.provider;

import org.keycloak.models.IdentityProviderModel;

public class EpicIdentityProviderConfig extends IdentityProviderModel {

    public EpicIdentityProviderConfig() {
    }

    public EpicIdentityProviderConfig(IdentityProviderModel model) {
        super(model);
    }

    public String getEpicApiKey() {
        return getConfig().get("epicApiKey");
    }

    public void setEpicApiKey(String key) {
        getConfig().put("epicApiKey", key);
    }
}