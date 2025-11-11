import {
    IonButton,
    IonContent,
    IonHeader, IonItem, IonLabel,
    IonPage,
    IonTitle, IonToolbar,
    useIonRouter, useIonViewWillEnter
} from "@ionic/react";
import {useState} from "react";
import {me} from "./Login/authApi";


const Profile: React.FC = () => {
    const router = useIonRouter();
    const [username, setUsername] = useState('');

    useIonViewWillEnter(() => {
        const token = localStorage.getItem("token");
        if(!token) {
            router.push("/login");
            return;
        }
        me(token).then(data => {
            setUsername(data.username);
        });
    })

    const handleLogout = () => {
        const token = localStorage.getItem("token");
        if(token) localStorage.removeItem("token");
        router.push("/login");
    }

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Profile</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent className="ion-padding">
                <IonItem>
                    <IonLabel>Username: {username}</IonLabel>
                    <IonButton onClick={handleLogout}>Logout</IonButton>
                </IonItem>
            </IonContent>

        </IonPage>
    );
};

export default Profile;
