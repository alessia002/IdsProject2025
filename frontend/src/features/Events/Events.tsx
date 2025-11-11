import {
    IonContent,
    IonGrid,
    IonPage,
    IonSearchbar,
} from "@ionic/react";


const Events: React.FC = () => {

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

export default Events;
