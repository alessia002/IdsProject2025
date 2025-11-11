import { createContext, useContext, useState, ReactNode } from 'react';
import {
    getAllPackages,
    deletePackage, publishPackage, unpublishPackage
} from '../packagesApi';
import {ProductPackage} from "../types";

interface PackageContextType {
    productPackages: ProductPackage[];
    refreshPackages: () => Promise<void>;
    handleDeletePackage: (id: number) => Promise<void>;
    handlePublishPackage: (id: number) => Promise<void>;
    handleUnpublishPackage: (id: number) => Promise<void>;
}

const PackageContext = createContext<PackageContextType | undefined>(undefined);

export const usePackages = () => {
    const context = useContext(PackageContext);
    if (!context) throw new Error('usePackages must be used within PackageProvider');
    return context;
};

export const PackagesProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
    const [productPackages, setProductPackages] = useState<ProductPackage[]>([]);

    const refreshPackages = async () => {
        const token = localStorage.getItem('token');
        if (!token) return;
        const data = await getAllPackages(token);
        setProductPackages(data);
    };

    const handleDeletePackage = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await deletePackage(id, token);
        } catch (error) {
            console.error(error);
        }
    };

    const handlePublishPackage = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await publishPackage(id, token);
        } catch (error) {
            console.error(error);
        }
    };

    const handleUnpublishPackage = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await unpublishPackage(id, token);
        } catch (error) {
            console.error(error);
        }
    };


    return (
        <PackageContext.Provider value={{ productPackages, refreshPackages, handleDeletePackage, handlePublishPackage, handleUnpublishPackage }}>
            {children}
        </PackageContext.Provider>
    );
};
