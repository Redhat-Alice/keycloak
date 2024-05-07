package org.keycloak.services.resources.admin.permissions;

import org.keycloak.models.OrganizationModel;
import java.util.Map;

public interface OrganizationPermissionEvaluator {

    boolean canList();

    void requireList();

    boolean canManage(OrganizationModel org);

    boolean canManageDefault();

    void requireManage(OrganizationModel org);

    boolean canView(OrganizationModel org);

    boolean canViewDefault();

    void requireView(OrganizationModel org);

    void requireViewMembers(OrganizationModel org);

    boolean canManageMembers(OrganizationModel org);

    boolean canManageMembership(OrganizationModel org);

    boolean canViewMembers(OrganizationModel org);

    void requireManageMembership(OrganizationModel org);

    void requireManageMembers(OrganizationModel org);

    Map<String, Boolean> getAccess(OrganizationModel org);

}
