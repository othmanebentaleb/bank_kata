package fr.ben.oth.kata.enums;

public enum OperationTypeEnum {

    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal"),
    CREATION("Creation of account");

    private String operationType;
    OperationTypeEnum(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return operationType;
    }
}
