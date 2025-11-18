package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ROLE_DISTRIBUTOR")
public class Distributor extends User {
}
