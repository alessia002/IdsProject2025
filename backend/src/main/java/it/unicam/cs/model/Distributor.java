package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DISTRIBUTOR")
public class Distributor extends User {
}
