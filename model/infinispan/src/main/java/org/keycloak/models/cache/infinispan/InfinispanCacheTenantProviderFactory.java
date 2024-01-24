package org.keycloak.models.cache.infinispan;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.cache.CacheTenantProvider;
import org.keycloak.models.cache.CacheTenantProviderFactory;

public class InfinispanCacheTenantProviderFactory implements CacheTenantProviderFactory {
    @Override
    public CacheTenantProvider create(KeycloakSession session) {
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
}
