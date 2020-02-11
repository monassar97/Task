package com.trainitg.eventsourcing.events;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DrawAccountEvent {
    private String accountId;
    private double amount;
}
