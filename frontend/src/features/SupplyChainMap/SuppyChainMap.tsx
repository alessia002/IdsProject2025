import {
    IonContent,
    IonGrid,
    IonPage,
    IonSearchbar,
} from "@ionic/react";


const SupplyChainMap: React.FC = () => {

    return (
        <IonPage>
            <IonContent>
                <IonSearchbar placeholder="Cerca"></IonSearchbar>
                <IonGrid>
                </IonGrid>
            </IonContent>

        </IonPage>
    );
};

export default SupplyChainMap;
