package com.bank.model;

import javax.persistence.*;
import java.util.List;

import static com.bank.model.Client.ALL_SORTED;
import static com.bank.model.Client.DELETE;

@NamedQueries({@NamedQuery(name = ALL_SORTED, query = "SELECT c FROM Client c ORDER BY c.name"),
        @NamedQuery(name = DELETE, query = "DELETE FROM Client c where c.id=:id")})
@Entity
@Table
public class Client extends BaseEntity {

    public static final String ALL_SORTED = "Client.getAllSorted";
    public static final String DELETE = "Client.delete";

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    public Client() {
    }

    public Client(Integer id, String name, int age, Address address) {
        super(id);
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
