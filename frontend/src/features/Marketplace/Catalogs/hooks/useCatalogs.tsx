import { createContext, useContext, useState, ReactNode } from 'react';
import {getAllCatalogs, deleteCatalog, publishCatalog, unpublishCatalog} from '../catalogsApi';
import {Catalog} from "../types";

interface CatalogsContextType {
    catalogs: Catalog[];
    refreshCatalogs: () => Promise<void>;
    handleDeleteCatalog: (id: number) => Promise<void>;
    handlePublishCatalog: (id: number) => Promise<void>;
    handleUnpublishCatalog: (id: number) => Promise<void>;
}

const CatalogsContext = createContext<CatalogsContextType | undefined>(undefined);

export const useCatalogs = () => {
    const context = useContext(CatalogsContext);
    if (!context) throw new Error('useCatalogs must be used within CatalogsProvider');
    return context;
};

export const CatalogsProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
    const [catalogs, setCatalogs] = useState<Catalog[]>([]);

    const refreshCatalogs = async () => {
        const token = localStorage.getItem('token');
        if (!token) return;
        const data = await getAllCatalogs(token);
        setCatalogs(data);
    };

    const handleDeleteCatalog = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await deleteCatalog(id, token);
        } catch (error) {
            console.error(error);
        }
    };

    const handlePublishCatalog = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await publishCatalog(id, token);
        } catch (error) {
            console.error(error);
        }
    };

    const handleUnpublishCatalog = async (id: number) => {
        const token = localStorage.getItem('token');
        if (!token) return;
        try {
            await unpublishCatalog(id, token);
        } catch (error) {
            console.error(error);
        }
    };


    return (
        <CatalogsContext.Provider value={{ catalogs, refreshCatalogs, handleDeleteCatalog, handlePublishCatalog, handleUnpublishCatalog }}>
            {children}
        </CatalogsContext.Provider>
    );
};
