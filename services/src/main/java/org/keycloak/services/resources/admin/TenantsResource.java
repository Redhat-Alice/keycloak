package org.keycloak.services.resources.admin;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.stream.Stream;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.common.Profile;
import org.keycloak.common.Profile.Feature;
import org.keycloak.events.admin.ResourceType;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.representations.idm.TenantRepresentation;
import org.keycloak.services.resources.KeycloakOpenAPI;
import org.keycloak.services.resources.KeycloakOpenAPI.Admin.Tags;
import org.keycloak.services.resources.admin.permissions.AdminPermissionEvaluator;

@Extension(name = KeycloakOpenAPI.Profiles.ADMIN, value = "")
public class TenantsResource {
    private final RealmModel realm;
    private final KeycloakSession session;
    private final AdminPermissionEvaluator auth;
    private final AdminEventBuilder adminEvent;

    public TenantsResource(RealmModel realm, KeycloakSession session, AdminPermissionEvaluator auth, AdminEventBuilder adminEvent) {
        this.realm = realm;
        this.session = session;
        this.auth = auth;
        this.adminEvent = adminEvent.resource(ResourceType.TENANT);
    }

    // get tenants -- this wil let us search for tenants and find tenants based on various top level information

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = Tags.TENANTS)
    @Operation( summary = "Get tenants that belong to the realm. Only name and ids are returned.")
    public Stream<TenantRepresentation> getTenants(@QueryParam("search") String search, @QueryParam("exact") @DefaultValue("false") Boolean exact, @QueryParam("first") @DefaultValue("0") Integer first, @QueryParam("max") @DefaultValue("10") Integer max) {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }

        return Stream.empty();
    }

    @POST
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = Tags.TENANTS)
    @Operation( summary = "Create a tenant and return the created tenant with name and ID")
    public TenantRepresentation createTenant(TenantRepresentation tenantRepresentation) {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }

        return new TenantRepresentation();
    }

    @Path("{id}")
    public TenantResource getTenantById() {
        if(!Profile.isFeatureEnabled(Feature.MULTI_TENANCY)) {
            throw new UnsupportedOperationException("This feature is in development and not enabled on this server");
        }
        return new TenantResource(new String());
    }



    // create tenant

    // updates and deletion should be handled on the individual tenant level, this is the top level at PUT /realm/id/tenants and GET /realm/id/tenants

    // if you want a specific tenant under and circumstance you should fall through to the next layer of the API /realm/id/tenants/id --> GET, POST, UPDATE, DELETE
    // we'll then need to add API hooks for things like adding groups to tenants,
    // restricting the updates of groups (this would be better done with table constraints... you can't have a parent group and be assigned a tenant for instance?)
    // // Could also enforce this at insertion time. Another rule could be that you can't insert a group to a tenant that has a parent unless the parent is also part of the tenant, that gives us a recursive way to enforce the tree
    // tenants also need to be associated with users. This is easier as users aren't hierarchical, but they will need to receive permissions for the admin operations based on tenant membership

    // once the above are established then we can work on the mappers. We'll map users to tenants based on their identity providers or their user federation
    // then we can add the detail mapping. For instance OIDC roles and SAML claims -> tenant w/ preserved roles

    // goal for the API is being able to simply create the tenant object concept, add groups and users to it, and then get the users/groups associated with it
    // once we have this we can set up the bounds of authority, probably using fine grained permissions
    // mappers

    // these are the BARE MINIMUM requirements for establishing some amount of multi-tenancy behavior. We'll need to discuss the public API details

}
