package com.trainitg.eventsourcing.rest.entity;

import com.trainitg.eventsourcing.aggregate.AccountType;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class OpenAccountEntity {
    @Id
    private String accountId;
    private String name;
    private double balance;
    private AccountType accountType;
}
