import {Product} from "../Products/types";

export interface ProductPackage {
    id: number;
    total: number;
    productList: Product[];
    status?: string | null;
}
