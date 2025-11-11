import React, {useState} from "react";
import {
    IonButton,
    IonContent,
    IonHeader,
    IonInput,
    IonItem,
    IonLabel,
    IonPage,
    IonTitle,
    IonToast,
    IonToolbar,
    useIonRouter, useIonViewWillEnter
} from "@ionic/react";
import {getProductById, updateProduct, uploadProduct} from "../productsApi";
import {useParams} from "react-router-dom";

const ProductForm: React.FC<{ isEdit?: boolean }> = ({ isEdit = false }) => {
    const router = useIonRouter();
    const { id } = useParams<{ id: string }>();
    const token = localStorage.getItem("token");

    const [name, setName] = useState("");
    const [price, setPrice] = useState<number | undefined>(undefined);
    const [category, setCategory] = useState("");
    const [status, setStatus] = useState("DRAFT");
    const [showToast, setShowToast] = useState(false);

    useIonViewWillEnter(() => {
        if (isEdit && id && token) {
            getProductById(parseInt(id), token).then(data => {
                setName(data.name);
                setPrice(data.price);
                setCategory(data.category);
                setStatus(data.status);
            });
        } else {
            setName("");
            setPrice(undefined);
            setCategory("");
            setStatus("DRAFT");
        }
    }, [isEdit, id, token]);

    const handleSubmit = async () => {
        if (!token) return;
        try {
            if (isEdit && id) {
                await updateProduct(parseInt(id), { name,  price: price!, category }, token);
            } else {
                await uploadProduct({ name,  price: price!, category, status: null }, token);
            }
            router.push("/products");
            setShowToast(true);
        } catch (err) {
            console.error(err);
            setShowToast(true);
        }
    };

    const handleCancel = () => {
        router.push("/products");
    };

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>{isEdit ? "Modifica Prodotto" : "Aggiungi Prodotto"}</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonItem>
                    <IonLabel position="floating">Nome</IonLabel>
                    <IonInput value={name} onIonChange={e => setName(e.detail.value!)} />
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Prezzo</IonLabel>
                    <IonInput type="number" value={price} onIonChange={e => setPrice(Number(e.detail.value))} />
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Categoria</IonLabel>
                    <IonInput value={category} onIonChange={e => setCategory(e.detail.value!)} />
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Stato</IonLabel>
                    <IonInput disabled={true} value={status==="DRAFT"?"Bozza":"Pubblicato"} onIonChange={e => setStatus(e.detail.value!)} />
                </IonItem>

                <IonButton expand="block" onClick={handleSubmit}>
                    {isEdit ? "Salva Modifiche" : "Aggiungi"}
                </IonButton>

                <IonButton expand="block" color="danger" onClick={handleCancel}>
                    Annulla
                </IonButton>

                <IonToast
                    isOpen={showToast}
                    message={isEdit ? "Prodotto aggiornato!" : "Prodotto aggiunto!"}
                    duration={2000}
                    onDidDismiss={() => setShowToast(false)}
                />
            </IonContent>
        </IonPage>
    );
};

export default ProductForm;
