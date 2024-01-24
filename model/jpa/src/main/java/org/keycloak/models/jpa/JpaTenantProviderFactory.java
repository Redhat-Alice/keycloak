package org.keycloak.models.jpa;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.TenantProviderFactory;

public class JpaTenantProviderFactory implements TenantProviderFactory<JpaTenantProvider> {

    private static final int PROVIDER_PRIORITY = 1;

    @Override
    public JpaTenantProvider create(KeycloakSession session) {
        return null;
    }

    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public int order() {
        return PROVIDER_PRIORITY;
    }
}
