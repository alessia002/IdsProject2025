import { createContext, useContext, useState, ReactNode } from 'react';
import {
    getAllProducts,
    deleteProduct,
    publishProduct,
    unpublishProduct
} from '../productsApi';
import {Product} from "../types";

interface ProductsContextType {
    products: Product[];
    refreshProducts: () => Promise<void>;
    handleDeleteProduct: (id: number) => Promise<void>;
    handlePublishProduct: (id: number) => Promise<void>;
    handleUnpublishProduct: (id: number) => Promise<void>;
}

const ProductsContext = createContext<ProductsContextType | undefined>(undefined);

export const useProducts = () => {
    const context = useContext(ProductsContext);
    if (!context) throw new Error('useProducts must be used within ProductsProvider');
    return context;
};

export const ProductsProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
    const [products, setProducts] = useState<Product[]>([]);

    const refreshProducts = async () => {
        const token = localStorage.getItem('token');
        if (!token) return;
        const data = await getAllProducts(token);
        setProducts(data);
    };

    const handleDeleteProduct = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await deleteProduct(id, token);
        } catch (error) {
            console.error(error);
        }
    };

    const handlePublishProduct = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await publishProduct(id, token);
        } catch (error) {
            console.error(error);
        }
    };
    const handleUnpublishProduct = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await unpublishProduct(id, token);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <ProductsContext.Provider value={{ products, refreshProducts, handleDeleteProduct, handlePublishProduct, handleUnpublishProduct }}>
            {children}
        </ProductsContext.Provider>
    );
};
