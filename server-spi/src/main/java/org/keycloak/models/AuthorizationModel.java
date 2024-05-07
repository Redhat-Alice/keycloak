package org.keycloak.models;

import java.util.Set;

/**
 * Provided a base level contract for any model used in an authorization system, ensuring that any model
 * that implements this interface is able to provide the necessary information about its resource name
 * as well as any associated scopes
 */
public interface AuthorizationModel {
    String getResourceName();

    String getResourceType();

    String getResourcePrefix();

    Set<String> getResourceScopes();
}
