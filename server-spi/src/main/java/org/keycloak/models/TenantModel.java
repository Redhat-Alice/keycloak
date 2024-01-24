package org.keycloak.models;

import org.keycloak.provider.ProviderEvent;

import java.util.Map;

public interface TenantModel extends RoleContainerModel {
    // We have the tenant as a role container so that users and groups that are part of a tenant can map tenant specific roles
    // that way roles that are part of other tenants aren't accessible




    // what about users and groups? Those are separate entities even if they're linked... should the model reflect that?
    // my though is that we shouldn't be populating all of the users and groups in a tenant here. We can ask the API for that info

    interface TenantRemovedEvent extends ProviderEvent {
        RealmModel getRealm();
        TenantModel getTenant();
        KeycloakSession getKeycloakSession();
    }

    @Override
    String getId();

    String getRealmId();

    String getName();

    void setName(String name);

    // do we actually care about having a different display name from the set name?
    String getDisplayName();

    void setDisplayName(String displayName);

    String getDisplayNameHtml();

    void setDisplayNameHtml(String displayNameHtml);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    void setAttribute(String name, String value);

    default void setAttribute(String name, Boolean value) {
        setAttribute(name, value.toString());
    }

    default void setAttribute(String name, Integer value) {
        setAttribute(name, value.toString());
    }

    default void setAttribute(String name, Long value) {
        setAttribute(name, value.toString());
    }

    void removeAttribute(String name);

    String getAttribute(String name);

    default Integer getAttribute(String name, Integer defaultValue) {
        String v = getAttribute(name);
        return v != null ? Integer.valueOf(v) : defaultValue;
    }

    default Long getAttribute(String name, Long defaultValue) {
        String v = getAttribute(name);
        return v != null ? Long.valueOf(v) : defaultValue;
    }

    default Boolean getAttribute(String name, Boolean defaultValue) {
        String v = getAttribute(name);
        return v != null ? Boolean.valueOf(v) : defaultValue;
    }

    Map<String, String> getAttributes();

    // TODO should a tenant be concerned about this in addition to the realm?
    // if realm allows should the tenants be able to decide if they want it?
    // UMA is more of an authz concept rather than authority and IAM... but also keycloak does have resources and authz baked in
    // ---------------------------------------------------------------------------
    boolean isUserManagedAccessAllowed();

    void setUserManagedAccessAllowed(boolean userManagedAccessAllowed);

    // TODO should tenants control their individual 2FA settings?
    // behavior would have to be "if otp policy non-enforcing then defer to realm else use tenant policy"
    // -----------------------------------------
    OTPPolicy getOTPPolicy();
    void setOTPPolicy(OTPPolicy policy);

    // TODO we definitely want to implement custom themes for different tenants. This behavior is highly requested
    // --------------------------------------
    String getLoginTheme();

    void setLoginTheme(String name);

    String getAccountTheme();

    void setAccountTheme(String name);

    String getAdminTheme();

    void setAdminTheme(String name);

    String getEmailTheme();

    void setEmailTheme(String name);

    // TODO support creation of groups in a tenant and fetching groups from the model
    // the actual implementation can hand off to the storage layer via the session to follow single responsibility
    // ------------------------------------------------------------------------
    GroupModel createGroup(String id, String name, GroupModel toParent);

    GroupModel getGroupById(String id);

    Long getGroupsCount(Boolean onlyTopGroups);
    Long getGroupsCountByNameContaining(String search);

    // TODO we'll need special logic for group moving and deleting within a tenant to make sure that it
    // only moves or removes within a tenant and not without
    // -------------------------------------------------------------------------
    boolean removeGroup(GroupModel group);
    void moveGroup(GroupModel group, GroupModel toParent);
}
