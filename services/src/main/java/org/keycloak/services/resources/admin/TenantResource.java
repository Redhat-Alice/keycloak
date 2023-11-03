package org.keycloak.services.resources.admin;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.keycloak.common.Profile;
import org.keycloak.common.Profile.Feature;
import org.keycloak.representations.idm.TenantRepresentation;
import org.keycloak.services.resources.KeycloakOpenAPI;

@Extension(name = KeycloakOpenAPI.Profiles.ADMIN, value = "")
public class TenantResource {

    String placeholderTenant;

    public TenantResource(String placeholderTenant) {
        // active development, intentionally blank for now
        this.placeholderTenant = placeholderTenant;
    }

    @GET
    public TenantRepresentation getTenant() {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }

        return new TenantRepresentation();
    }

    @Path("groups")
    public GroupsResource tenantGroups() {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }
        return new GroupsResource(null, null, placeholderTenant, null, null);
    }

    @Path("users")
    public UsersResource tenantUsers() {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }
        return new UsersResource(null, placeholderTenant, null, null);
    }

    // TODO: should this method be limited entirely to only the tenant specific fields?
    // We can hand off the group details to the group api
    // the user details to the user api
    // we can overload their constructors and inject an optional "tenant" model or id to do operations on those APIs, separates out concerns
    @POST
    public TenantRepresentation updateTenant(TenantRepresentation tenantRepresentation) {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }
        return tenantRepresentation;
    }

    @DELETE
    public Response deleteTenant() {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }

        return Response.status(501).build();
    }

}
