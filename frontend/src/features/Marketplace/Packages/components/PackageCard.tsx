import React from "react";
import {
    IonButton,
    IonCard,
    IonCardContent,
    IonCardHeader, IonCardSubtitle,
    IonCardTitle,
    useIonRouter
} from "@ionic/react";
import {usePackages} from "../hooks/usePackages";
import {ProductPackage} from "../types";

const PackageCard: React.FC<ProductPackage> = ({ id, total, status}) => {
    const {handleDeletePackage, handlePublishPackage, handleUnpublishPackage} = usePackages();
    const router = useIonRouter();

    const handleDelete = async () => {
        await handleDeletePackage(id);
        router.push(`/packages`);
    };

    const handlePublish = async () => {
        await handlePublishPackage(id);
        router.push(`/packages`);
    }

    const handleUnpublish = async () => {
        await handleUnpublishPackage(id);
        router.push(`/packages`);
    }

    return (
        <IonCard routerLink={`/edit-package/${id}`} button>
            <IonCardHeader>
                <IonCardSubtitle>{status===null||status==="DRAFT"?"Bozza":"Pubblicato"}</IonCardSubtitle>
                <IonCardTitle>${total}</IonCardTitle>
            </IonCardHeader>
            <IonCardContent>
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

export default PackageCard;