package org.keycloak.models.jpa.entities;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="KEYCLOAK_TENANT",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"REALM_ID", "NAME"})})
public class TenantEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne
    @JoinColumn(name = "REALM_ID", nullable = false)
    protected RealmEntity realm;

    @OneToMany(mappedBy = "tenant")
    protected List<GroupEntity> groups = new LinkedList<>();

    @OneToMany(mappedBy = "tenant")
    protected List<UserEntity> users = new LinkedList<>();

    @OneToMany(mappedBy = "tenant")
    protected List<TenantAttributeEntity> tenantAttributes = new LinkedList<>();

    public String getId() {
        return id;
    }

    public RealmEntity getRealm() {
        return realm;
    }

    public void setRealm(RealmEntity realm) {
        this.realm = realm;
    }

    public List<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupEntity> groups) {
        this.groups = groups;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<TenantAttributeEntity> getTenantAttributes() {
        return tenantAttributes;
    }

    public void setTenantAttributes(List<TenantAttributeEntity> tenantAttributes) {
        this.tenantAttributes = tenantAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantEntity that = (TenantEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
