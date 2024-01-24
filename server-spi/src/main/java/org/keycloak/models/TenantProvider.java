package org.keycloak.models;

import org.keycloak.provider.Provider;

import java.util.Map;
import java.util.stream.Stream;

public interface TenantProvider extends Provider {

    // get all tenants
    /**
     * Returns a paginated stream of groups with given ids and given search value in group names.
     *
     * @param realm Realm.
     * @param ids Stream of tenant ids to search for.
     * @param search Case insensitive string which will be searched for. Ignored if null.
     * @param first Index of the first result to return. Ignored if negative or {@code null}.
     * @param max Maximum number of results to return. Ignored if negative or {@code null}.
     * @return Stream of desired groups. Never returns {@code null}.
     */
    Stream<TenantModel> getTenants(RealmModel realm, Stream<String> ids, String search, Integer first, Integer max);

    Stream<TenantModel> getTenantsByAttribute(RealmModel realm, Map<String, String> attributes, Integer first, Integer max);

    TenantModel getTenantById(RealmModel realm, String id);

    TenantModel createTenant(RealmModel realm, String id, String name);

    TenantModel removeTenant(RealmModel realm, TenantModel tenantModel);

    TenantModel removeTenantById(RealmModel realm, String id);

    Integer getTenantsCount(RealmModel realm);

    // reverse lookup? Get tenant by user/group?
    // -- we don't need this because the tenant id is stored as FK on users and groups so the relationship is already implicit

    // update group and user lookups to account for tenant membership
}
