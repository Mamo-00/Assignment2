package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter // Adding Getter and Setter for street
    private String street;

    @Getter @Setter // Adding Getter and Setter for number
    private Integer number;

    // ManyToMany relationship with Customer
    @Getter @Setter
    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners;


}
