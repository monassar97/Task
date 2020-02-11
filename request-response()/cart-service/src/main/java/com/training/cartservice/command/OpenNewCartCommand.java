package com.training.cartservice.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenNewCartCommand {
    private String userId;
}
