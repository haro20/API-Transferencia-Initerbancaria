package com.cruz.bbva.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_customer" )
    private Long idCustomer;

    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String civilState;

    @OneToMany(mappedBy = "idBankAccount")
    private List<BankAccount> bankAccounts;
}
