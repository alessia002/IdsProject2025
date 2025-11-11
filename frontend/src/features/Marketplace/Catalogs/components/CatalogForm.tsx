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
import {getCatalogById, updateCatalog, uploadCatalog} from "../catalogsApi";
import {Product} from "../../Products/types";
import {getProductById} from "../../Products/productsApi";
import ProductCard from "../../Products/components/ProductCard";

const CatalogForm: React.FC<{ isEdit?: boolean }> = ({ isEdit = false }) => {
    const router = useIonRouter();
    const { id } = useParams<{ id: string }>();
    const token = localStorage.getItem("token");
    const [name, setName] = useState("");
    const [description, setDescription] = useState<string | undefined>(undefined);
    const [idProductToAdd, setIdProductToAdd] = useState<number>();
    const [productList, setProductList] = useState<Product[]>([]);
    const [status, setStatus] = useState("DRAFT");
    const [showToast, setShowToast] = useState(false);

    useIonViewWillEnter(() => {
        if (isEdit && id && token) {
            getCatalogById(parseInt(id), token).then(data => {
                setName(data.name);
                setDescription(data.description);
                setProductList(data.productList);
                setStatus(data.status);
            });
        } else if(!isEdit && token) {
            setName("");
            setDescription("");
            setProductList([]);
            setStatus("DRAFT");
        }
    }, [isEdit, id, token]);

    const handleAddProduct = async () => {
        if (!token) return;
        if (!idProductToAdd) return;
        if (productList.some(p => p.id === idProductToAdd)) {
            console.error("Prodotto già presente nel catalogo")
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
            console.error("Prodotto non presente nel catalogo")
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
                await updateCatalog(parseInt(id), { name,  description: description!, productList: productList, numProduct: 0, status: null }, token);
            } else {
                await uploadCatalog({ name,  description: description!, productList: productList, numProduct: 0, status: null }, token);
            }
            router.push("/catalogs");
            setShowToast(true);
        } catch (err) {
            console.error(err);
            setShowToast(true);
        }
    };

    const handleCancel = () => {
        router.push('/catalogs');
    }

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>{isEdit ? "Modifica Catalogo" : "Aggiungi Catalogo"}</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonItem>
                    <IonLabel position="floating">Nome</IonLabel>
                    <IonInput value={name} onIonChange={e => setName(e.detail.value!)} />
                </IonItem>
                <IonItem>
                    <IonLabel position="floating">Descrizione</IonLabel>
                    <IonInput value={description} onIonChange={e => setDescription(e.detail.value!)} />
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
                            <IonButton onClick={() => handleRemoveProduct(product.id)}>Rimuovi dal catalogo</IonButton>
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
                    message={isEdit ? "Catalogo aggiornato!" : "Catalogo aggiunto!"}
                    duration={2000}
                    onDidDismiss={() => setShowToast(false)}
                />
        </IonPage>
    );
};

export default CatalogForm;
