import type TenantRepresentation from "@keycloak/keycloak-admin-client/lib/defs/tenantRepresentation";
//import type RealmRepresentation from "@keycloak/keycloak-admin-client/lib/defs/realmRepresentation";
import { To } from "react-router-dom";
import { KeycloakDataTable } from "../table-toolbar/KeycloakDataTable";
import { useFetch } from "../../utils/useFetch";
import { useState } from "react";
import { adminClient } from "../../admin-client";

import { useRealm } from "../../context/realm-context/RealmContext";
import { emptyFormatter } from "../../util";

type TenancyListProps = {
  paginated?: boolean;
  parentRoleId?: string;
  messageBundle?: string;
  isReadOnly: boolean;
  toCreate: To;
  toDetail: (roleId: string) => To;
  loader?: (
    first?: number,
    max?: number,
    search?: string,
  ) => Promise<TenantRepresentation[]>;
};

export const TenancyList = ({ loader, paginated }: TenancyListProps) => {
  //const [realm, setRealm] = useState<RealmRepresentation>();
  const [selectedTenant] = useState<TenantRepresentation>();
  const { realm: realmName } = useRealm();
  const tempColData = [
    {
      name: "Tenant",
      displayKey: "TenantName",
      cellFormatters: [emptyFormatter()],
    },
    {
      name: "",
      displayKey: "",
      cellFormatters: [emptyFormatter()],
    },
  ];

  useFetch(
    () => adminClient.realms.findOne({ realm: realmName }),
    (realm) => {
      setRealm(realm);
    },
    [],
  );

  return (
    <KeycloakDataTable
      key={selectedTenant ? selectedTenant.id : "tenantList"}
      loader={loader!}
      ariaLabelKey="roleList"
      searchPlaceholderKey="searchForRoles"
      isPaginated={paginated}
      columns={tempColData}
      emptyState={true}
    />
  );
};
