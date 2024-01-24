package org.keycloak.models.jpa;

import jakarta.persistence.EntityManager;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.TenantModel;
import org.keycloak.models.TenantProvider;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class JpaTenantProvider implements TenantProvider {

    private final KeycloakSession session;
    private final EntityManager em;
    private final Set<String> clientSearchableAttributes;
    private final Set<String> tenantSearchableAttributes;

    public JpaTenantProvider(KeycloakSession session, EntityManager em, Set<String> clientSearchableAttributes, Set<String> tenantSearchableAttributes) {
        this.session = session;
        this.em = em;
        this.clientSearchableAttributes = clientSearchableAttributes;
        this.tenantSearchableAttributes = tenantSearchableAttributes;
    }

    @Override
    public void close() {

    }

    @Override
    public Stream<TenantModel> getTenants(RealmModel realm, Stream<String> ids, String search, Integer first, Integer max) {
        return null;
    }

    @Override
    public Stream<TenantModel> getTenantsByAttribute(RealmModel realm, Map<String, String> attributes, Integer first, Integer max) {
        return null;
    }

    @Override
    public TenantModel getTenantById(RealmModel realm, String id) {
        return null;
    }

    @Override
    public TenantModel createTenant(RealmModel realm, String id, String name) {
        return null;
    }

    @Override
    public TenantModel removeTenant(RealmModel realm, TenantModel tenantModel) {
        return null;
    }

    @Override
    public TenantModel removeTenantById(RealmModel realm, String id) {
        return null;
    }

    @Override
    public Integer getTenantsCount(RealmModel realm) {
        return null;
    }
}
