import {
    IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonList, IonItem, IonButton, useIonViewWillEnter,
    useIonRouter
} from '@ionic/react';
import {useCatalogs} from "../hooks/useCatalogs";
import CatalogCard from "../components/CatalogCard";

const CatalogList: React.FC = () => {
    const { catalogs, refreshCatalogs } = useCatalogs();
    const router = useIonRouter();

    useIonViewWillEnter(() => {
        refreshCatalogs();
    });

    const goToAddCatalog = () => {
        router.push('/add-catalog');
    };

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar className="ion-padding">
                    <IonTitle>Cataloghi</IonTitle>
                    <IonButton slot="end" onClick={goToAddCatalog}>Aggiungi catalogo</IonButton>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonList>
                    {catalogs.map(c => (
                        <IonItem key={c.id}>
                            <CatalogCard id={c.id} name={c.name} description={c.description} productList={c.productList} numProduct={c.numProduct} status={c.status}></CatalogCard>
                        </IonItem>
                    ))}
                </IonList>
            </IonContent>
        </IonPage>
    );
};

export default CatalogList;
