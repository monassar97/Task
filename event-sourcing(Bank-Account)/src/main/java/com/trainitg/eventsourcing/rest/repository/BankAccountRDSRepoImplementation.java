package com.trainitg.eventsourcing.rest.repository;

import org.springframework.stereotype.Component;

@Component
public class BankAccountRDSRepoImplementation implements BankAccountImpl {
    private final BankAccountJPARepository bankAccountJPARepository;

    public BankAccountRDSRepoImplementation(BankAccountJPARepository bankAccountJPARepository) {
        this.bankAccountJPARepository = bankAccountJPARepository;
    }

}
