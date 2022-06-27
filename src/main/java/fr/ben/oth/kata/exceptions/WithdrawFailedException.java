package fr.ben.oth.kata.exceptions;

public class WithdrawFailedException extends RuntimeException{

    public WithdrawFailedException(String message) {
        super(message);
    }
}
