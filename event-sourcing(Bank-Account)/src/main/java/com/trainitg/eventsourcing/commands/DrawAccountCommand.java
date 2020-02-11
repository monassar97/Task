package com.trainitg.eventsourcing.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DrawAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;
    private double amount;
}
