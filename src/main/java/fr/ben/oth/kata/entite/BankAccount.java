package fr.ben.oth.kata.entite;

import fr.ben.oth.kata.enums.OperationStatusEnum;
import fr.ben.oth.kata.enums.OperationTypeEnum;
import lombok.Data;

@Data
public class BankAccount {

    private int accountId = 0;
    private double balance;
    private History history;

    public BankAccount() {
        this.accountId++;
        this.balance = 0l;
        history = new History();
    }

    public BankAccount deposit(double amount) {
        double oldBalance = this.balance;
        this.balance+=amount;
        history = history.newOperation(OperationTypeEnum.DEPOSIT.toString(),
                    OperationStatusEnum.SUCCESS.toString(),
                    amount,oldBalance,balance);
        return this;
    }

    public BankAccount withdraw(double amount) throws Exception {
        if(balance == 0 || balance < amount) {
            history = history.newOperation(OperationTypeEnum.WITHDRAWAL.toString(),
                        OperationStatusEnum.FAIL.toString(),
                        amount,balance,balance);
            throw new Exception("The amount is higher than your account balance");
        }
        double oldBalance = balance;
        this.balance-=amount;
        history = history.newOperation(OperationTypeEnum.WITHDRAWAL.toString(),
                OperationStatusEnum.SUCCESS.toString(),
                amount,oldBalance,balance);
        return this;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "history= " + history.toString() +
                '}';
    }
}
