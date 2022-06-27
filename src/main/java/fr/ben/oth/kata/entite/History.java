package fr.ben.oth.kata.entite;

import fr.ben.oth.kata.enums.OperationStatusEnum;
import fr.ben.oth.kata.enums.OperationTypeEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class History {

    private long idHistory=0l;
    private List<Operation> operations;

    public History() {
        this.idHistory++;
        operations = new ArrayList<>();
        operations.add(new Operation(new Date(), OperationTypeEnum.CREATION.toString(), 0, 0, 0, OperationStatusEnum.SUCCESS.toString()));
    }

    public History newOperation(String operationType, String operationStatus, double amount, double balanceBeforeOperation, double balanceAfterOperation) {
        Operation newOperation = new Operation(new Date(), operationType,amount,balanceBeforeOperation,balanceAfterOperation,operationStatus);
        this.operations.add(newOperation);
        return this;

    }

    @Override
    public String toString() {
        return operations.toString();
    }
}
