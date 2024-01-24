package org.keycloak.models;

import org.keycloak.provider.ProviderFactory;

public interface TenantProviderFactory <T extends TenantProvider> extends ProviderFactory<T> {
}
