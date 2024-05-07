package org.keycloak.services.resources.admin.permissions;

import jakarta.ws.rs.ForbiddenException;
import org.keycloak.authorization.AuthorizationProvider;
import org.keycloak.authorization.model.Policy;
import org.keycloak.authorization.model.Resource;
import org.keycloak.authorization.model.ResourceServer;
import org.keycloak.authorization.model.Scope;
import org.keycloak.authorization.store.PolicyStore;
import org.keycloak.authorization.store.ResourceStore;
import org.keycloak.models.AdminRoles;
import org.keycloak.models.OrganizationModel;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OrganizationPermissions implements OrganizationPermissionEvaluator {

    private static final String MANAGE_MEMBERSHIP_SCOPE = "manage-org-membership";
    private static final String MANAGE_MEMBERS_SCOPE = "manage-org-members";
    private static final String VIEW_MEMBERS_SCOPE = "view-org-members";

    private final MgmtPermissions root;
    private final ResourceStore resourceStore;

    OrganizationPermissions(AuthorizationProvider authz, MgmtPermissions root) {
        this.root = root;
        if (authz!=null) {
            resourceStore = authz.getStoreFactory().getResourceStore();
        } else {
            resourceStore = null;
        }
    }

    @Override
    public boolean canList() {
        return canViewDefault();
    }

    @Override
    public void requireList() {
        if(!canList()) {
            throw new ForbiddenException();
        }
    }

    @Override
    public boolean canManage(OrganizationModel org) {
        return canManageDefault() || root.hasPermission(getOrgResource(org), null, MgmtPermissions.MANAGE_SCOPE);
    }

    @Override
    public boolean canManageDefault() {
        return root.hasOneAdminRole(AdminRoles.MANAGE_ORGANIZATIONS);
    }

    private Resource getOrgResource(OrganizationModel org) {
        ResourceServer server = root.realmResourceServer();
        if (server == null) {
            return null;
        }

        return resourceStore.findByName(server, org.getResourceName());
    }

    @Override
    public void requireManage(OrganizationModel org) {
        if (!canManage(org)) {
            throw new ForbiddenException();
        }
    }

    @Override
    public boolean canView(OrganizationModel org) {
        return canViewDefault() || root.hasPermission(getOrgResource(org), null, MgmtPermissions.VIEW_SCOPE);
    }

    @Override
    public boolean canViewDefault() {
        return root.hasOneAdminRole(AdminRoles.VIEW_ORGANIZATIONS);
    }

    @Override
    public void requireView(OrganizationModel org) {
        if (!canView(org)) {
            throw new ForbiddenException();
        }
    }

    @Override
    public void requireViewMembers(OrganizationModel org) {
        if (!canViewMembers(org)) {
            throw new ForbiddenException();
        }
    }

    @Override
    public boolean canManageMembers(OrganizationModel org) {
        return canManage(org) || root.hasPermission(getOrgResource(org), null, MANAGE_MEMBERS_SCOPE);
    }

    @Override
    public boolean canManageMembership(OrganizationModel org) {
        return canManage(org) || root.hasPermission(getOrgResource(org), null, MANAGE_MEMBERSHIP_SCOPE);
    }

    @Override
    public boolean canViewMembers(OrganizationModel org) {
        return canViewDefault() || root.hasPermission(getOrgResource(org), null, VIEW_MEMBERS_SCOPE);
    }

    @Override
    public void requireManageMembership(OrganizationModel org) {
        if (!canManageMembership(org)) {
            throw new ForbiddenException();
        }
    }

    @Override
    public void requireManageMembers(OrganizationModel org) {
        if (!canManageMembers(org)) {
            throw new ForbiddenException();
        }
    }

    @Override
    public Map<String, Boolean> getAccess(OrganizationModel org) {
        return Map.of();
    }

}
