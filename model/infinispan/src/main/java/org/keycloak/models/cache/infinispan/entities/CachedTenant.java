package org.keycloak.models.cache.infinispan.entities;

public class CachedTenant extends AbstractRevisioned implements InRealm {

    public CachedTenant(Long revision, String id) {
        super(revision, id);
    }

    @Override
    public String getRealm() {
        return null;
    }
}
