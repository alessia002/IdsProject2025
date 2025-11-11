import React from "react";
import {
    IonButton,
    IonCard,
    IonCardContent,
    IonCardHeader, IonCardSubtitle,
    IonCardTitle,
    useIonRouter
} from "@ionic/react";
import {useCatalogs} from "../hooks/useCatalogs";
import {Catalog} from "../types";

const CatalogCard: React.FC<Catalog> = ({ id, name, description, numProduct, status}) => {
    const { handleDeleteCatalog, handlePublishCatalog, handleUnpublishCatalog } = useCatalogs();
    const router = useIonRouter();

    const handleDelete = async () => {
        await handleDeleteCatalog(id);
        router.push(`/catalogs`);
    };

    const handlePublish = async () => {
        await handlePublishCatalog(id);
        router.push(`/catalogs`);
    }

    const handleUnpublish = async () => {
        await handleUnpublishCatalog(id);
        router.push(`/catalogs`);
    }

    return (
        <IonCard routerLink={`/edit-catalog/${id}`} button>
            <IonCardHeader>
                <IonCardSubtitle>{status===null||status==="DRAFT"?"Bozza":"Pubblicato"}</IonCardSubtitle>
                <IonCardTitle>{name}</IonCardTitle>
            </IonCardHeader>
            <IonCardContent>
                {description} | Numero prodotti: {numProduct}
            </IonCardContent>
            {status === "DRAFT" &&
                <IonButton  fill="clear" onClick={handlePublish}>Pubblica</IonButton>
            }
            {status === "PUBLISHED" &&
                <IonButton fill="clear" onClick={handleUnpublish}>Salva in bozza</IonButton>
            }
            <IonButton fill="clear" onClick={handleDelete}>Elimina</IonButton>
        </IonCard>
    );
};

export default CatalogCard;