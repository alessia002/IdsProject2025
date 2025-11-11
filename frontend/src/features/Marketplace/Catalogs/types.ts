import {Product} from "../Products/types";

export interface Catalog {
    id: number;
    name: string;
    description: string;
    productList: Product[];
    numProduct: number;
    status?: string | null;
}
