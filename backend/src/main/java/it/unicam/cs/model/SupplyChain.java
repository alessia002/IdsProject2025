package it.unicam.cs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name= "supply_chain")
@NoArgsConstructor
@AllArgsConstructor
public class SupplyChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "supplyChain", cascade = CascadeType.ALL)
    private List<User> companies;

    public void addCompany(User company) {
        if (companies == null) throw new NullPointerException("Companies is null");
        if (companies.contains(company)) throw new IllegalArgumentException("Company already exists in the supply chain");
        this.companies.add(company);
    }
}
