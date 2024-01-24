package org.keycloak.models.jpa.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="TENANT_ATTRIBUTE",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"TENANT_ID", "NAME"})})
public class TenantAttributeEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne
    @JoinColumn(name = "TENANT_ID")
    protected TenantEntity tenant;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "VALUE")
    protected String value;

    public TenantEntity getTenant() {
        return tenant;
    }

    public void setTenant(TenantEntity tenant) {
        this.tenant = tenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantAttributeEntity that = (TenantAttributeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
