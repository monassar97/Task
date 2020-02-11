package com.training.cartservice.command;

import lombok.Data;

@Data
public class OpenCartCommand extends AbstractCartCommand{

    private String userId;

}
