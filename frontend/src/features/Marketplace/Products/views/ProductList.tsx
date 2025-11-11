import {
    IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonList, IonItem, IonButton, useIonViewWillEnter,
    useIonRouter
} from '@ionic/react';
import {useProducts} from "../hooks/useProducts";
import ProductCard from "../components/ProductCard";
import React from "react";

const ProductList: React.FC = () => {
    const { products, refreshProducts } = useProducts();
    const router = useIonRouter();

    useIonViewWillEnter(() => {
        refreshProducts();
    });

    const goToAddProduct = () => {
        router.push('/add-product');
    };


    return (
        <IonPage>
            <IonHeader>
                <IonToolbar className="ion-padding">
                    <IonTitle>Products</IonTitle>
                    <IonButton slot="end" onClick={goToAddProduct}>Aggiungi prodotto</IonButton>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonList lines="none">
                    {products.map(p => (
                        <IonItem key={p.id}>
                            <ProductCard id={p.id} name={p.name} price={p.price} category={p.category} status={p.status}></ProductCard>
                        </IonItem>
                    ))}
                </IonList>
            </IonContent>
        </IonPage>
    );
};

export default ProductList;
