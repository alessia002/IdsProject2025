import React, {useState} from "react";
import {
    IonButton,
    IonContent,
    IonHeader,
    IonInput,
    IonItem,
    IonLabel, IonList,
    IonPage,
    IonTitle,
    IonToast,
    IonToolbar,
    useIonRouter, useIonViewWillEnter
} from "@ionic/react";
import {useParams} from "react-router-dom";
import {Product} from "../../Products/types";
import {getProductById} from "../../Products/productsApi";
import ProductCard from "../../Products/components/ProductCard";
import {getPackageById, updatePackage, uploadPackage} from "../packagesApi";

const PackageForm: React.FC<{ isEdit?: boolean }> = ({ isEdit = false }) => {
    const router = useIonRouter();
    const { id } = useParams<{ id: string }>();
    const token = localStorage.getItem("token");
    const [total, setTotal] = useState<number>();
    const [idProductToAdd, setIdProductToAdd] = useState<number>();
    const [productList, setProductList] = useState<Product[]>([]);
    const [status, setStatus] = useState("DRAFT");
    const [showToast, setShowToast] = useState(false);

    useIonViewWillEnter(() => {
        if (isEdit && id && token) {
            getPackageById(parseInt(id), token).then(data => {
                setTotal(data.total);
                setProductList(data.productList);
            });
        } else if(!isEdit && token) {
            setTotal(undefined);
            setProductList([]);
        }
    }, [isEdit, id, token]);

    const handleAddProduct = async () => {
        if (!token) return;
        if (!idProductToAdd) return;
        if (productList.some(p => p.id === idProductToAdd)) {
            console.error("Prodotto già presente nel pacchetto")
            setIdProductToAdd(undefined);
            return}
        try {
            getProductById(idProductToAdd, token).then(data => {
                setProductList(prevProductList => [...prevProductList, data]);
            });
        } catch (err) {
            console.error(err);
        }
        setIdProductToAdd(undefined);
    }

    const handleRemoveProduct = async (id: number) => {
        if (!token) return;
        if (!id) return;
        if (!productList.some(p => p.id === id)) {
            console.error("Prodotto non presente nel pacchetto")
            return
        }
        try {
            setProductList(prevProductList => prevProductList.filter(p => p.id !== id));
        } catch (err) {
            console.error(err);
        }
    }

    const handleSubmit = async () => {
        if (!token) return;
        try {
            if (isEdit && id) {
                await updatePackage(parseInt(id), { total: total!, productList: productList, status: null }, token);
            } else {
                await uploadPackage({ total: total!, productList: productList, status: null }, token);
            }
            router.push("/packages");
            setShowToast(true);
        } catch (err) {
            console.error(err);
            setShowToast(true);
        }
    };

    const handleCancel = () => {
        router.push('/packages');
    }

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>{isEdit ? "Modifica Pacchetto" : "Aggiungi Pacchetto"}</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonItem>
                    <IonLabel position="floating">Totale</IonLabel>
                    <IonInput disabled={true} value={total} onIonChange={e => setTotal(Number(e.detail.value!))} />
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Stato</IonLabel>
                    <IonInput disabled={true} value={status==="DRAFT"?"Bozza":"Pubblicato"} onIonChange={e => setStatus(e.detail.value!)} />
                </IonItem>
                <IonList lines="none" inset={true}>
                        <IonToolbar>
                            <IonItem>
                            <IonLabel position="fixed">Aggiungi prodotto</IonLabel>
                            <IonInput value={idProductToAdd} placeholder="Id prodotto" onIonChange={e=> setIdProductToAdd(Number(e.detail.value))} />
                            <IonButton onClick={handleAddProduct}>Aggiungi</IonButton>
                            </IonItem>
                    </IonToolbar>
                    {productList.map((product: Product) => (
                        <IonItem key={product.id}>
                            <ProductCard id={product.id} name={product.name} price={product.price} category={product.category} status={product.status} showActions={false}/>
                            <IonButton onClick={() => handleRemoveProduct(product.id)}>Rimuovi dal pacchetto</IonButton>
                        </IonItem>
                    ))}
                </IonList>
            </IonContent>
                <IonButton expand="block" onClick={handleSubmit}>
                    {isEdit ? "Salva Modifiche" : "Aggiungi"}
                </IonButton>

                <IonButton expand="block" color="danger" onClick={handleCancel}>
                    Annulla
                </IonButton>

                <IonToast
                    isOpen={showToast}
                    message={isEdit ? "Pacchetto aggiornato!" : "Pacchetto aggiunto!"}
                    duration={2000}
                    onDidDismiss={() => setShowToast(false)}
                />
        </IonPage>
    );
};

export default PackageForm;
