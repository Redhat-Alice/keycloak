import type { AppRouteObject } from "../routes";
import { TenancyRoute, TenancyWithIdRoute } from "./routes/Tenancy";

const routes: AppRouteObject[] = [TenancyRoute, TenancyWithIdRoute];

export default routes;
