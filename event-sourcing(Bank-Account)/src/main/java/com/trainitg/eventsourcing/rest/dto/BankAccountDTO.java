package com.trainitg.eventsourcing.rest.dto;

import com.trainitg.eventsourcing.aggregate.AccountType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
public class BankAccountDTO {
    private String accountId;
    private String name;
    private double balance;
    private AccountType accountType;
}
