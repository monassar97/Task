package com.trainitg.eventsourcing.events;

import com.trainitg.eventsourcing.aggregate.AccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenAccountEvent {
    private String accountId;
    private String name;
    private double balance;
    private AccountType accountType;
}
