package org.keycloak.storage.tenant;

import org.keycloak.provider.*;
import org.keycloak.storage.group.GroupStorageProvider;
import org.keycloak.storage.group.GroupStorageProviderFactory;

import java.util.Collections;
import java.util.List;

public class TenantStorageProviderSpi implements Spi {

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public String getName() {
        return "tenant-storage";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        return TenantStorageProvider.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        return TenantStorageProviderFactory.class;
    }

    private static final List<ProviderConfigProperty> commonConfig;

    static {
        //corresponds to properties defined in CacheableStorageProviderModel and PrioritizedComponentModel
        List<ProviderConfigProperty> config = ProviderConfigurationBuilder.create()
                .property()
                .name("enabled").type(ProviderConfigProperty.BOOLEAN_TYPE).add()
                .property()
                .name("priority").type(ProviderConfigProperty.STRING_TYPE).add()
                .property()
                .name("cachePolicy").type(ProviderConfigProperty.STRING_TYPE).add()
                .property()
                .name("maxLifespan").type(ProviderConfigProperty.STRING_TYPE).add()
                .property()
                .name("evictionHour").type(ProviderConfigProperty.STRING_TYPE).add()
                .property()
                .name("evictionMinute").type(ProviderConfigProperty.STRING_TYPE).add()
                .property()
                .name("evictionDay").type(ProviderConfigProperty.STRING_TYPE).add()
                .property()
                .name("cacheInvalidBefore").type(ProviderConfigProperty.STRING_TYPE).add()
                .build();
        commonConfig = Collections.unmodifiableList(config);
    }

    public static List<ProviderConfigProperty> commonConfig() {
        return commonConfig;
    }
}
