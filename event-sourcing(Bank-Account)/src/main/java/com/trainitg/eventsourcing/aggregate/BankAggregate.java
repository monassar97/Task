package com.trainitg.eventsourcing.aggregate;

import com.trainitg.eventsourcing.commands.DepositAccountCommand;
import com.trainitg.eventsourcing.commands.DrawAccountCommand;
import com.trainitg.eventsourcing.commands.OpenAccountCommand;
import com.trainitg.eventsourcing.events.DepositAccountEvent;
import com.trainitg.eventsourcing.events.DrawAccountEvent;
import com.trainitg.eventsourcing.events.OpenAccountEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;


@Aggregate
public class BankAggregate {
    @AggregateIdentifier
    private String accountId;
    private String name;
    private double balance;
    private AccountType accountType;

    public BankAggregate() {
    }

    @CommandHandler
    public BankAggregate(OpenAccountCommand openAccountCommand) {
        this.accountId = openAccountCommand.getAccountId();
        OpenAccountEvent openAccountEvent = OpenAccountEvent.builder()
                .accountId(openAccountCommand.getAccountId())
                .accountType(openAccountCommand.getAccountType())
                .name(openAccountCommand.getName())
                .build();
        apply(openAccountEvent);
    }

    @CommandHandler
    public void deposit(DepositAccountCommand depositAccountCommand) {
        DepositAccountEvent depositAccountEvent = DepositAccountEvent.builder()
                .accountId(depositAccountCommand.getAccountId())
                .amount(depositAccountCommand.getAmount())
                .build();
        apply(depositAccountEvent);
    }

    @CommandHandler
    public void draw(DrawAccountCommand drawAccountCommand) {
        DrawAccountEvent drawAccountEvent = DrawAccountEvent.builder()
                .accountId(drawAccountCommand.getAccountId())
                .amount(drawAccountCommand.getAmount())
                .build();
        apply(drawAccountEvent);
    }

    @EventSourcingHandler
    public void accountOpened(OpenAccountEvent openAccountEvent) {
        this.accountId = openAccountEvent.getAccountId();
        this.accountType = openAccountEvent.getAccountType();
        this.balance = 0;
        this.name = openAccountEvent.getName();
        System.out.println("Created "+balance);

    }

    @EventSourcingHandler
    public void accountBalanceDraw(DrawAccountEvent drawAccountEvent) {
        if (drawAccountEvent.getAccountId() == null)
            throw new RuntimeException("Account Not exist !");
        this.accountId = drawAccountEvent.getAccountId();
        if (this.balance - drawAccountEvent.getAmount() >= 0) {
            this.balance -= drawAccountEvent.getAmount();
        } else {
            throw new RuntimeException("Not Enough Balance !");
        }
        System.out.println("this.balance = " + this.balance);
    }

    @EventSourcingHandler
    public void accountBalanceDeposited(DepositAccountEvent depositAccountEvent) {
        if (depositAccountEvent.getAccountId() == null)
            throw new RuntimeException("Account Not exist !");
        this.accountId = depositAccountEvent.getAccountId();
        this.balance += depositAccountEvent.getAmount();
        System.out.println("this.balance = " + this.balance);
    }
}
