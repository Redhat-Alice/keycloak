package org.keycloak.storage.tenant;

import org.keycloak.component.ComponentModel;
import org.keycloak.storage.CacheableStorageProviderModel;
import org.keycloak.storage.group.GroupStorageProvider;

public class TenantStorageProviderModel extends CacheableStorageProviderModel {

    public TenantStorageProviderModel() {
        setProviderType(TenantStorageProvider.class.getName());
    }

    public TenantStorageProviderModel(ComponentModel copy) {
        super(copy);
    }

    private transient Boolean enabled;

    @Override
    public void setEnabled(boolean flag) {
        enabled = flag;
        getConfig().putSingle(ENABLED, Boolean.toString(flag));
    }

    @Override
    public boolean isEnabled() {
        if (enabled == null) {
            String val = getConfig().getFirst(ENABLED);
            if (val == null) {
                enabled = true;
            } else {
                enabled = Boolean.valueOf(val);
            }
        }
        return enabled;

    }
}
