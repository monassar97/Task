package com.trainitg.eventsourcing.commands;

import com.trainitg.eventsourcing.aggregate.AccountType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class OpenAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;
    private String name;
    private AccountType accountType;
}
