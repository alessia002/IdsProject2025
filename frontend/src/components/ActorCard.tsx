import React from 'react';
import { IonCard, IonCardHeader, IonCardTitle, IonCardContent, IonButton, IonIcon } from '@ionic/react';

interface ActorCardProps {
    title: string;
    description: string;
    icon: string;
    href?: string;
}

const ActorCard: React.FC<ActorCardProps> = ({ title, description, icon, href }) => {
    return (
        <IonCard routerLink={href} button>
            <IonCardHeader>
                <IonCardTitle>{title}</IonCardTitle>
            </IonCardHeader>
            <IonCardContent>
                <p style={{ marginBottom: '12px' }}>{description}</p>
                <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
                    <IonButton size="small" fill="clear">
                        <IonIcon icon={icon as any} slot="start" />
                    </IonButton>
                </div>
            </IonCardContent>
        </IonCard>
    );
};

export default ActorCard;
