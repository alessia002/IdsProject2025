import axios from 'axios';

const API_URL = '/api/product';

export const getAllProducts = async (token: string) => {
    const res = await axios.get(`${API_URL}/getAll`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return res.data;
};

export const getProductById = async (id: number, token: string) => {
    const res = await axios.get(`${API_URL}/searchById?id=${id}`, {
        headers: { Authorization: `Bearer ${token}` },
    });
    return res.data;
};

export const uploadProduct = async (product: {
    name: string;
    price: number;
    category: string;
    status?: string | null;
}, token: string) => {
    const res = await axios.post(`${API_URL}/upload`, product, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const updateProduct = async (id: number, product: {
    name: string;
    price: number;
    category?: string;
    status?: string | null;
}, token: string) => {
    const res = await axios.post(`${API_URL}/update?id=${id}`, product, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const deleteProduct = async (id: number, token: string) => {
    const res = await axios.delete(`${API_URL}/delete?id=${id}`, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const publishProduct = async (id: number, token: string) => {
    const res = await axios.post(`${API_URL}/publish?id=${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}

export const unpublishProduct = async (id: number, token: string) => {
    const res = await axios.post(`${API_URL}/unpublish?id=${id}`, {}, {
        headers: { Authorization: `Bearer ${token}` },
    })
    return res.data;
}
