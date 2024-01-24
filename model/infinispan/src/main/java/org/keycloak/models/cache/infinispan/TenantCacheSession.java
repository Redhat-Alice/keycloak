package org.keycloak.models.cache.infinispan;

import org.keycloak.models.GroupModel;
import org.keycloak.models.OTPPolicy;
import org.keycloak.models.RoleModel;
import org.keycloak.models.TenantModel;

import java.util.Map;
import java.util.stream.Stream;

public class TenantCacheSession implements TenantModel {
    @Override
    public RoleModel getRole(String name) {
        return null;
    }

    @Override
    public RoleModel addRole(String name) {
        return null;
    }

    @Override
    public RoleModel addRole(String id, String name) {
        return null;
    }

    @Override
    public boolean removeRole(RoleModel role) {
        return false;
    }

    @Override
    public Stream<RoleModel> getRolesStream() {
        return null;
    }

    @Override
    public Stream<RoleModel> getRolesStream(Integer firstResult, Integer maxResults) {
        return null;
    }

    @Override
    public Stream<RoleModel> searchForRolesStream(String search, Integer first, Integer max) {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getRealmId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public void setDisplayName(String displayName) {

    }

    @Override
    public String getDisplayNameHtml() {
        return null;
    }

    @Override
    public void setDisplayNameHtml(String displayNameHtml) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void setEnabled(boolean enabled) {

    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public Map<String, String> getAttributes() {
        return null;
    }

    @Override
    public boolean isUserManagedAccessAllowed() {
        return false;
    }

    @Override
    public void setUserManagedAccessAllowed(boolean userManagedAccessAllowed) {

    }

    @Override
    public OTPPolicy getOTPPolicy() {
        return null;
    }

    @Override
    public void setOTPPolicy(OTPPolicy policy) {

    }

    @Override
    public String getLoginTheme() {
        return null;
    }

    @Override
    public void setLoginTheme(String name) {

    }

    @Override
    public String getAccountTheme() {
        return null;
    }

    @Override
    public void setAccountTheme(String name) {

    }

    @Override
    public String getAdminTheme() {
        return null;
    }

    @Override
    public void setAdminTheme(String name) {

    }

    @Override
    public String getEmailTheme() {
        return null;
    }

    @Override
    public void setEmailTheme(String name) {

    }

    @Override
    public GroupModel createGroup(String id, String name, GroupModel toParent) {
        return null;
    }

    @Override
    public GroupModel getGroupById(String id) {
        return null;
    }

    @Override
    public Long getGroupsCount(Boolean onlyTopGroups) {
        return null;
    }

    @Override
    public Long getGroupsCountByNameContaining(String search) {
        return null;
    }

    @Override
    public boolean removeGroup(GroupModel group) {
        return false;
    }

    @Override
    public void moveGroup(GroupModel group, GroupModel toParent) {

    }
}
