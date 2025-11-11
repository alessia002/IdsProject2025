import axios from 'axios';
import {Product} from "../Products/types";

const API_URL = '/api/package';

export const getAllPackages = async (token: string) => {
    const res = await axios.get(`${API_URL}/getAll`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return res.data;
};

export const getPackageById = async (id: number, token: string) => {
    const res = await axios.get(`${API_URL}/searchById?id=${id}`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return res.data;
};

export const uploadPackage = async (productPackage: {
    total: number;
    productList: Product[];
    status?: string | null;
}, token: string) => {
    const res = await axios.post(`${API_URL}/create`, productPackage, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const updatePackage = async (id: number, productPackage: {
    total: number;
    productList: Product[];
    status?: string | null;
}, token: string) => {
    const res = await axios.post(`${API_URL}/update?id=${id}`, productPackage, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const deletePackage = async (id: number, token: string) => {
    const res = await axios.delete(`${API_URL}/delete?id=${id}`, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const publishPackage = async (id: number, token: string) => {
    const res = await axios.post(`${API_URL}/publish?id=${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const unpublishPackage = async (id: number, token: string) => {
    const res = await axios.post(`${API_URL}/unpublish?id=${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}
