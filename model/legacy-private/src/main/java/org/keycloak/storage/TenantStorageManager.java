package org.keycloak.storage;

import org.keycloak.models.*;
import org.keycloak.storage.tenant.TenantStorageProvider;
import org.keycloak.storage.tenant.TenantStorageProviderFactory;
import org.keycloak.storage.tenant.TenantStorageProviderModel;

import java.util.Map;
import java.util.stream.Stream;

// TODO User storage offers the component model way of adding storage. We should offer that option here as well.
// It's not really that well supported in group storage either though.
// We can override TenantProvider and provide a factory/spi for it instead of trying to do mixin compositions
// TODO add capability interfaces
public class TenantStorageManager extends AbstractStorageManager<TenantStorageProvider, TenantStorageProviderModel> implements TenantProvider {


    // TODO defer to local storage here
    protected TenantProvider localStorage() {
        return session.getProvider(TenantProvider.class);
    }

    public TenantStorageManager(KeycloakSession session) {
        super(session, TenantStorageProviderFactory.class, TenantStorageProvider.class,
                TenantStorageProviderModel::new, "tenant");
    }

    @Override
    public Stream<TenantModel> getTenants(RealmModel realm, Stream<String> ids, String search, Integer first, Integer max) {
        return localStorage().getTenants(realm, ids, search, first, max);
    }

    @Override
    public Stream<TenantModel> getTenantsByAttribute(RealmModel realm, Map<String, String> attributes, Integer first, Integer max) {
        return localStorage().getTenantsByAttribute(realm, attributes, first, max);
    }

    @Override
    public TenantModel getTenantById(RealmModel realm, String id) {
        return localStorage().getTenantById(realm, id);
    }

    @Override
    public TenantModel createTenant(RealmModel realm, String id, String name) {
        return localStorage().createTenant(realm, id, name);
    }

    @Override
    public TenantModel removeTenant(RealmModel realm, TenantModel tenantModel) {
        return localStorage().removeTenant(realm, tenantModel);
    }

    @Override
    public TenantModel removeTenantById(RealmModel realm, String id) {
        return localStorage().removeTenantById(realm, id);
    }

    @Override
    public Integer getTenantsCount(RealmModel realm) {
        return localStorage().getTenantsCount(realm);
    }

    @Override
    public void close() {

    }
}
