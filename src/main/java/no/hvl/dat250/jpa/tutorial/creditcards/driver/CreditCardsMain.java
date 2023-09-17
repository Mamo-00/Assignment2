package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
            PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // Create a new Customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    // Create a new Address and associate it with the Customer
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    customer.setAddresses(Set.of(address));
    address.setOwners(Set.of(customer));

    // Create a new Bank
    Bank bank = new Bank();
    bank.setName("Pengebank");

    // Create a new Pincode
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    // Create two new CreditCards and associate them with the Customer, Bank, and Pincode
    CreditCard firstCard = new CreditCard();
    firstCard.setNumber(12345);
    firstCard.setBalance(-5000);
    firstCard.setCreditLimit(-10000);
    firstCard.setPincode(pincode);
    firstCard.setOwningBank(bank);

    CreditCard secondCard = new CreditCard();
    secondCard.setNumber(123);
    secondCard.setBalance(1);
    secondCard.setCreditLimit(2000);
    secondCard.setPincode(pincode);
    secondCard.setOwningBank(bank);

    // Set the CreditCards for the Customer and Bank
    customer.setCreditCards(Set.of(firstCard, secondCard));
    bank.setOwnedCards(Set.of(firstCard, secondCard));

    // Persist all entities
    em.persist(customer);
    em.persist(address);
    em.persist(bank);
    em.persist(pincode);
    em.persist(firstCard);
    em.persist(secondCard);
  }

}
