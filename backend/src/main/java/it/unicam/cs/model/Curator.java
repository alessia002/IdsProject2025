package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CURATOR")
public class Curator extends User {
}
