import {
    IonPage, IonHeader, IonToolbar, IonTitle, IonContent, IonList, IonItem, IonButton, useIonViewWillEnter,
    useIonRouter
} from '@ionic/react';
import {usePackages} from "../hooks/usePackages";
import PackageCard from "../components/PackageCard";

const PackageList: React.FC = () => {
    const { productPackages, refreshPackages } = usePackages();
    const router = useIonRouter();

    useIonViewWillEnter(() => {
        refreshPackages();
    });

    const goToAddPackages = () => {
        router.push('/add-package');
    };

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar className="ion-padding">
                    <IonTitle>Pacchetti</IonTitle>
                    <IonButton slot="end" onClick={goToAddPackages}>Aggiungi pacchetto</IonButton>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonList>
                    {productPackages.map(c => (
                        <IonItem key={c.id}>
                            <PackageCard id={c.id} total={c.total} productList={c.productList} status={c.status}></PackageCard>
                        </IonItem>
                    ))}
                </IonList>
            </IonContent>
        </IonPage>
    );
};

export default PackageList;
