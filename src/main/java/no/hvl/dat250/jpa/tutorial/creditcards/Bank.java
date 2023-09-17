package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter // Adding Getter and Setter for name
    private String name;

    // OneToMany relationship with CreditCard
    @Getter @Setter
    @OneToMany(mappedBy = "owningBank", cascade = CascadeType.ALL)
    private Set<CreditCard> ownedCards;

    public Long getId() {
        return id;
    }

}
