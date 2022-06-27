package fr.ben.oth.kata.exceptions;

public class AccountNotBelongException extends RuntimeException{

    public AccountNotBelongException(String message) {
        super(message);
    }
}
