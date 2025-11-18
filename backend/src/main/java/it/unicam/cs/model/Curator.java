package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ROLE_CURATOR")
public class Curator extends User {
}
