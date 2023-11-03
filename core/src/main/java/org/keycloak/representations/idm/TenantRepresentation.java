package org.keycloak.representations.idm;

public class TenantRepresentation {
    private String id;
    private String name;
    private String realmId; // do we want the id and the name or just one or the other?
    private String domain; // this is the concept of the username@tenant.realm.id or some other format of addressing users. this could just be generatable on demand if the information on this object is enough

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
