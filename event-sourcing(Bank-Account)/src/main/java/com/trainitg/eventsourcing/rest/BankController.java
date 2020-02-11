package com.trainitg.eventsourcing.rest;

import com.trainitg.eventsourcing.rest.dto.AccountDrawDepositDTO;
import com.trainitg.eventsourcing.rest.dto.BankAccountDTO;
import com.trainitg.eventsourcing.commands.DepositAccountCommand;
import com.trainitg.eventsourcing.commands.DrawAccountCommand;
import com.trainitg.eventsourcing.commands.OpenAccountCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BankController {
    private final CommandGateway commandGateway;

    public BankController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public void openAccount(@RequestBody BankAccountDTO bankAccountDTO) {
        OpenAccountCommand openAccountCommand = OpenAccountCommand.builder()
                .accountId(bankAccountDTO.getAccountId())
                .accountType(bankAccountDTO.getAccountType())
                .name(bankAccountDTO.getName())
                .build();
        commandGateway.sendAndWait(openAccountCommand);
    }

    @PatchMapping("draw")
    public void drawFromAccount(@RequestBody AccountDrawDepositDTO accountDrawDepositDTO) {
        DrawAccountCommand drawAccountCommand = DrawAccountCommand.builder()
                .accountId(accountDrawDepositDTO.getAccountId())
                .amount(accountDrawDepositDTO.getAmount())
                .build();
        commandGateway.sendAndWait(drawAccountCommand);
    }

    @PatchMapping("deposit")
    public void depositToAccount(@RequestBody AccountDrawDepositDTO accountDrawDepositDTO) {
        DepositAccountCommand depositAccountCommand = DepositAccountCommand.builder()
                .accountId(accountDrawDepositDTO.getAccountId())
                .amount(accountDrawDepositDTO.getAmount())
                .build();
        commandGateway.sendAndWait(depositAccountCommand);
    }
}
