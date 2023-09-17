package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private Integer number;

    @Getter @Setter
    private Integer balance;

    @Getter @Setter
    private Integer creditLimit;

    // Unidirectional ManyToOne with Pincode
    @ManyToOne
    @Getter @Setter
    private Pincode pincode;

    // Bidirectional ManyToOne with Bank
    @ManyToOne
    @JoinColumn(name = "bank_id")
    @Getter @Setter
    private Bank owningBank;

    public CreditCard() {
        // Default constructor
    }

    // Additional constructors and methods can be added as needed
}
