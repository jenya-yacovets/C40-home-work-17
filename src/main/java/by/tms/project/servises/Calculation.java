package by.tms.project.servises;

import by.tms.project.config.TypeOperation;
import by.tms.project.dao.HistoryMemoryDAO;
import by.tms.project.entity.Operation;
import by.tms.project.exceptions.ParametersNotPassedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculation {

    private TypeOperation operation;
    private List<Integer> numbers;
    private int nextId = 1;

    public Calculation(String operation, String numbers) throws ParametersNotPassedException {
        // Проверяем параметр numbers
        if(numbers == null) throw new ParametersNotPassedException("numbers");

        String[] numberStrArray = numbers.trim().split(",");
        this.numbers = new ArrayList<>();

        for (String item : numberStrArray) {
            try{
                this.numbers.add(Integer.parseInt(item));
            } catch (NumberFormatException ex){
                throw new ParametersNotPassedException("numbers");
            }
        }

        // Проверяем параметр operation
        if (operation.equals(TypeOperation.MINUS.getNameParam())) {
            this.operation = TypeOperation.MINUS;
        } else if (operation.equals(TypeOperation.PLUS.getNameParam())) {
            this.operation = TypeOperation.PLUS;
        } else {
            throw new ParametersNotPassedException("operation");
        }
    }

    public Calculation() {
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

    public double response() {
        HistoryMemoryDAO.getInstance().save(new Operation(operation, numbers, nextId));
        nextId++;
        return operation.action(numbers);
    }

    public String history() {
        String resultStr = "";

        for(Operation operation : HistoryMemoryDAO.getInstance().getAll()) {
            String numbersToString = operation.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "));
            resultStr += String.format("Операция: %s | Числа: %s <br>", operation.getOperation().getName(), numbersToString);
        }
        return resultStr;
    }
}
