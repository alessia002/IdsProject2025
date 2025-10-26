package it.unicam.cs.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PRODUCER")
public class Producer extends UserEntity {
}
