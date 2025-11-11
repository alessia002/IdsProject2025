import axios from 'axios';

const API_URL = '/api/auth';

export const login = async (username: string, password: string) => {
    const res = await axios.post(`${API_URL}/login`, { username, password });
    return res.data; // { token: string }
};

export const me = async (token: string) => {
    const res = await axios.get(`${API_URL}/me`, {
        headers: {Authorization: `Bearer ${token}`},
    });
    return res.data; // { username: string, authorities: [{authority: string}] }
};
