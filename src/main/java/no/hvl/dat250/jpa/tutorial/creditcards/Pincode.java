package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter // Adding Getter and Setter for code
    private String code;

    @Getter
    @Setter // Adding Getter and Setter for count
    private Integer count;

    // OneToMany relationship with CreditCard
    @OneToMany(mappedBy = "pincode", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<CreditCard> creditCards;

}
