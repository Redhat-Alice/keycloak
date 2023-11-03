package org.keycloak.representations.idm;

import java.util.Map;

// TODO how do we want to represent domain ownership in the future? Should a tenant even know that it is "owned".
// downstream this might be used to determine some level of trust, but upstream the keycloak server really only cares about the bounds of authority
// perhaps a public API that let's us ask keycloak for information about "redhat.com" and it returns "maps to xyz tenant"
// separates out concerns, let's us check permissions still, and also allows for a downstream establishment of trust using keycloak functionality
public class TenantRepresentation {
    private String id;
    private String name;
    private String realmId; // do we want the id and the name or just one or the other?
    private String domain; // this is the concept of the username@tenant.realm.id or some other format of addressing users. this could just be generatable on demand if the information on this object is enough

    Map<String, String> attributes; // it's reasonable to assume that we'll want some attributes or metadata associated with a tenant for informing an end user about more nuance with this authority space
    // for instance, a red hat use case might be storing information about the associated organization

    // tenants have groups and users but I think that's separate from the concerns of this object. This object can be used to get those, and those things
    // know that they belong to this object

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealmId() {
        return realmId;
    }

    public void setRealmId(String realmId) {
        this.realmId = realmId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
