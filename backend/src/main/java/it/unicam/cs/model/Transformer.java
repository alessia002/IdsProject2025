package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ROLE_TRANSFORMER")
public class Transformer extends User {
}
