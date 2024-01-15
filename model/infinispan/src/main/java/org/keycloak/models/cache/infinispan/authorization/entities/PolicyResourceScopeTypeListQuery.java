package org.keycloak.models.cache.infinispan.authorization.entities;

import java.util.Set;

public class PolicyResourceScopeTypeListQuery extends PolicyListQuery implements InScope, InResource, InResourceServer {

    String serverId;
    String resourceId;
    Set<String> scopeIds;
    Set<String> policyIds;




    public PolicyResourceScopeTypeListQuery(Long revision, String id, String resourceId, Set<String> scopeIds, Set<String> policyIds, String serverId) {
        super(revision, id, policyIds, serverId);
        this.resourceId = resourceId;
        this.scopeIds = scopeIds;
        this.policyIds = policyIds;
        this.serverId = serverId;
    }

    @Override
    public boolean isInvalid(Set<String> invalidations) {
        return super.isInvalid(invalidations)
                || invalidations.contains(getResourceId())
                || scopeIds.stream().anyMatch(invalidations::contains);
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

    @Override
    public String getScopeId() {
        return String.join(",", scopeIds);
    }
}
