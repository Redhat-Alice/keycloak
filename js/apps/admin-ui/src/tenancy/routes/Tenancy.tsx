import { lazy } from "react";
import type { AppRouteObject } from "../../routes";

const TenancySection = lazy(() => import("../TenancySection"));

export const TenancyRoute: AppRouteObject = {
  path: "/:realm/tenancy/*",
  element: <TenancySection />,
  handle: {
    access: "query-tenants",
  },
};

export const TenancyWithIdRoute: AppRouteObject = {
  ...TenancyRoute,
  path: "/:realm/tenancy/:id",
};
