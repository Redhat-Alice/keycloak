import { PageSection } from "@patternfly/react-core";
import { ViewHeader } from "../components/view-header/ViewHeader";
import { TenancyList } from "../components/tenants-list/TenancyList";
import helpUrls from "../help-urls";
/*import { AngleLeftIcon, TreeIcon } from "@patternfly/react-icons";
import { useState } from "react";*/

// be prepared to create an addTenant
import { toAddRole } from "../realm-roles/routes/AddRole";
import { useRealm } from "../context/realm-context/RealmContext";
import { toRealmRole } from "../realm-roles/routes/RealmRole";

export default function TenancySection() {
  const { realm } = useRealm();

  /*const sampleList = [
    {"name": "Hershey"},
    {"name": "IBM"},
    {"name": "General Motors"}
  ];*/

  return (
    <>
      <ViewHeader
        titleKey="titleTenancy"
        subKey="tenancyExplain"
        helpUrl={helpUrls.realmRolesUrl}
      />
      <PageSection>
        <TenancyList
          isReadOnly={true}
          toDetail={(roleId) =>
            toRealmRole({ realm, id: roleId, tab: "details" })
          }
          toCreate={toAddRole({ realm })}
        />
      </PageSection>
    </>
  );
}
