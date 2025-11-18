package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ROLE_PRODUCER")
public class Producer extends User {
}
