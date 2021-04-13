package by.tms.project.entity;

import by.tms.project.config.TypeOperation;

import java.util.List;

public class Operation {
    private TypeOperation operation;
    private List<Integer> numbers;
    private int id;

    public Operation(TypeOperation operation, List<Integer> numbers, int id) {
        this.operation = operation;
        this.numbers = numbers;
        this.id = id;
    }

    public Operation() {
    }

    public TypeOperation getOperation() {
        return operation;
    }

    public void setOperation(TypeOperation operation) {
        this.operation = operation;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
