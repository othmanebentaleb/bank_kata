package fr.ben.oth.kata.entite;

import lombok.Data;

import java.util.Date;
@Data
public class Operation {

    private long idOperation = 0l;
    private Date operationDate;
    private String operationType;
    private double amountOperation;
    private double balanceBeforeOperation;
    private double balanceAfterOperation;
    private String operationStatus;


    public Operation(Date operationDate, String operationType, double amountOperation, double balanceBeforeOperation, double balanceAfterOperation, String operationStatus) {
        this.idOperation++;
        this.operationDate = operationDate;
        this.operationType = operationType;
        this.amountOperation = amountOperation;
        this.balanceBeforeOperation = balanceBeforeOperation;
        this.balanceAfterOperation = balanceAfterOperation;
        this.operationStatus = operationStatus;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationDate=" + operationDate +
                ", operationType='" + operationType + '\'' +
                ", amountOperation=" + amountOperation +
                ", balanceBeforeOperation=" + balanceBeforeOperation +
                ", balanceAfterOperation=" + balanceAfterOperation +
                ", operationStatus='" + operationStatus + '\'' +
                "} \n";
    }
}
