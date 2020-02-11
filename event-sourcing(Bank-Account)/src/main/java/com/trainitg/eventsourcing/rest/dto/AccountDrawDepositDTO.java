package com.trainitg.eventsourcing.rest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
public class AccountDrawDepositDTO {
    private String accountId;
    private double amount;
}
