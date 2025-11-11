import {
    IonCol,
    IonContent,
    IonGrid,
    IonPage,
    IonRow,
    IonSearchbar,
} from "@ionic/react";
import ActorCard from "../../components/ActorCard";
import {bagOutline, fastFoodOutline, journalOutline} from "ionicons/icons";


const Marketplace: React.FC = () => {

    return (
        <IonPage>
            <IonContent>
                <IonSearchbar placeholder="Cerca"></IonSearchbar>
                <IonGrid>
                    <IonRow>
                        <IonCol><ActorCard href={'/products'} title="Prodotti" description="Prodotti singoli" icon={fastFoodOutline}/></IonCol>
                        <IonCol><ActorCard href={'/packages'} title="Pacchetti" description="Pacchetti di prodotti" icon={bagOutline}/></IonCol>
                    </IonRow>
                    <IonRow>
                        <IonCol><ActorCard href={'/catalogs'} title="Cataloghi" description="Cataloghi di prodotti e pacchetti" icon={journalOutline}/></IonCol>
                    </IonRow>
                </IonGrid>
            </IonContent>

        </IonPage>
    );
};

export default Marketplace;
