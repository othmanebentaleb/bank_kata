package fr.ben.oth.kata.entite;

import fr.ben.oth.kata.enums.OperationStatusEnum;
import fr.ben.oth.kata.enums.OperationTypeEnum;
import fr.ben.oth.kata.exceptions.AccountNotBelongException;
import fr.ben.oth.kata.exceptions.NotAllowedException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class BankClient {

    private Integer clientId;
    private String firstName;
    private String lastName;
    private List<BankAccount> accounts;

    public static final String NOT_ALLOWED_TO_DEPOSIT_MSG_ERROR = "You are not allowed to deposit into this account";
    public static final String NOT_ALLOWED_TO_WITHDRAW_MSG_ERROR = "You are not allowed to withdraw from this account";

    public static final String ACCOUNT_NOT_BELONG_MSG_ERROR = "This Account does not belong to this client";
    public BankClient(Integer clientId, String firstName, String lastName,BankAccount account) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(account);
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
        this.accounts.add(account);
    }

    //
    public BankClient save(int accountId, double amount, int clientId) throws Exception {
        BankAccount account = checkAccountsBelongToClient(accountId);
        if(this.clientId != clientId) {
            updateHistoryAfterValidationFail(account, OperationTypeEnum.DEPOSIT.toString(), amount);
            throw new NotAllowedException(NOT_ALLOWED_TO_DEPOSIT_MSG_ERROR);
        } else {
            account.deposit(amount);
            updateClientAccount(account);
        }
        return this;
    }

    public BankClient retrieve(int accountId, double amount, int clientId) throws Exception {
        BankAccount account = checkAccountsBelongToClient(accountId);
        if(this.clientId != clientId) {
            updateHistoryAfterValidationFail(account, OperationTypeEnum.DEPOSIT.toString(), amount);
            throw new NotAllowedException(NOT_ALLOWED_TO_WITHDRAW_MSG_ERROR);
        } else {
            account.withdraw(amount);
            updateClientAccount(account);
        }
        return this;
    }

    public String showHistory(int accountId) throws Exception {
        BankAccount account = checkAccountsBelongToClient(accountId);
        return firstName
                .concat(" ")
                .concat(lastName)
                .concat(": ")
                .concat(account.toString());
    }

    /**
     * PRIVATE METHODS
     */
    private BankAccount checkAccountsBelongToClient(int accountId) throws Exception {
        return  this.accounts.stream()
                                .filter(accountToFind -> accountId == accountToFind.getAccountId())
                                .findFirst()
                                .orElseThrow(()->new AccountNotBelongException(ACCOUNT_NOT_BELONG_MSG_ERROR));
    }

    private void updateClientAccount(BankAccount account){
        this.accounts.stream()
                .filter(accountToFind -> account.getAccountId() == accountToFind.getAccountId())
                .findFirst()
                .get()
                .setBalance(account.getBalance());
    }

    private void updateHistoryAfterValidationFail(BankAccount account, String operationType, double amount){
        account.getHistory()
                .newOperation(operationType, OperationStatusEnum.FAIL.toString(),amount, account.getBalance(), account.getBalance());
    }







}
