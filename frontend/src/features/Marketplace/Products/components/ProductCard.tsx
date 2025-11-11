import React from "react";
import {
    IonButton,
    IonCard,
    IonCardContent,
    IonCardHeader, IonCardSubtitle,
    IonCardTitle,
    useIonRouter
} from "@ionic/react";
import {Product} from "../types";
import {useProducts} from "../hooks/useProducts";

interface Props extends Product{
    showActions?: boolean;
}

const ProductCard: React.FC<Props> = ({ id, name, price, category, status, showActions=true }) => {
    const { handleDeleteProduct, handlePublishProduct, handleUnpublishProduct } = useProducts();
    const router = useIonRouter();

    const handleDelete = async () => {
        await handleDeleteProduct(id);
        router.push(`/products`);
    };

    const handlePublish = async () => {
        await handlePublishProduct(id);
        router.push(`/products`);
    }

    const handleUnpublish = async () => {
        await handleUnpublishProduct(id);
        router.push(`/products`);
    }

    return (
        <IonCard
            routerLink={showActions ? `/edit-product/${id}` : undefined}
            button={showActions}>
            <IonCardHeader>
                <IonCardSubtitle>{status==="DRAFT"?"Bozza":"Pubblicato"}</IonCardSubtitle>
                <IonCardTitle>{name}</IonCardTitle>
            </IonCardHeader>
            <IonCardContent>
                Categoria: {category} | Prezzo: ${price}
            </IonCardContent>

            {showActions && status === "DRAFT" &&
                <IonButton  fill="clear" onClick={handlePublish}>Pubblica</IonButton>
            }
            {showActions && status === "PUBLISHED" &&
                <IonButton fill="clear" onClick={handleUnpublish}>Salva in bozza</IonButton>
            }
            {showActions &&<IonButton fill="clear" onClick={handleDelete}>Elimina</IonButton>}
        </IonCard>
    );
};

export default ProductCard;