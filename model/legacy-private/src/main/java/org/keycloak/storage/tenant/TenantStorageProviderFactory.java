package org.keycloak.storage.tenant;

import org.keycloak.Config;
import org.keycloak.component.ComponentFactory;
import org.keycloak.component.ComponentModel;
import org.keycloak.component.ComponentValidationException;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.RealmModel;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.storage.group.GroupStorageProviderSpi;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TenantStorageProviderFactory<T extends TenantStorageProvider> extends ComponentFactory<T, TenantStorageProvider> {
    /**
     * called per Keycloak transaction.
     *
     * @param session
     * @param model
     * @return
     */
    @Override
    T create(KeycloakSession session, ComponentModel model);

    /**
     * This is the name of the provider.
     *
     * @return
     */
    @Override
    String getId();

    @Override
    default void init(Config.Scope config) {
    }

    @Override
    default void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    default void close() {
    }

    @Override
    default String getHelpText() {
        return "";
    }

    @Override
    default List<ProviderConfigProperty> getConfigProperties() {
        return Collections.EMPTY_LIST;
    }

    @Override
    default void validateConfiguration(KeycloakSession session, RealmModel realm, ComponentModel config) throws ComponentValidationException {
    }

    /**
     * Called when GroupStorageProviderModel is created.  This allows you to do initialization of any additional configuration
     * you need to add.
     *
     * @param session
     * @param realm
     * @param model
     */
    @Override
    default void onCreate(KeycloakSession session, RealmModel realm, ComponentModel model) {
    }

    /**
     * configuration properties that are common across all GroupStorageProvider implementations
     *
     * @return
     */
    @Override
    default
    List<ProviderConfigProperty> getCommonProviderConfigProperties() {
        return GroupStorageProviderSpi.commonConfig();
    }

    @Override
    default Map<String, Object> getTypeMetadata() {
        return new HashMap<>();
    }
}
