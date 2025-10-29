package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TRANSFORMER")
public class Transformer extends User {
}
