import axios from 'axios';
import {Product} from "../Products/types";

const API_URL = '/api/catalog';

export const getAllCatalogs = async (token: string) => {
    const res = await axios.get(`${API_URL}/getAll`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return res.data;
};

export const getCatalogById = async (id: number, token: string) => {
    const res = await axios.get(`${API_URL}/searchById?id=${id}`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return res.data;
};

export const uploadCatalog = async (product: {
    name: string;
    description: string;
    productList: Product[];
    numProduct: number;
    status?: string | null;
}, token: string) => {
    const res = await axios.post(`${API_URL}/upload`, product, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const updateCatalog = async (id: number, product: {
    name: string;
    description: string;
    productList: Product[];
    numProduct: number;
    status?: string | null;
}, token: string) => {
    const res = await axios.post(`${API_URL}/update?id=${id}`, product, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const deleteCatalog = async (id: number, token: string) => {
    const res = await axios.delete(`${API_URL}/delete?id=${id}`, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const publishCatalog = async (id: number, token: string) => {
    const res = await axios.post(`${API_URL}/publish?id=${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const unpublishCatalog = async (id: number, token: string) => {
    const res = await axios.post(`${API_URL}/unpublish?id=${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}
