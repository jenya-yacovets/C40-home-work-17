package by.tms.project.dao;

import by.tms.project.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class HistoryMemoryDAO implements HistoryDAO{

    private static HistoryMemoryDAO instance;
    private List<Operation> history;

    private HistoryMemoryDAO() {
        history = new ArrayList<>();
    }

    public static HistoryMemoryDAO getInstance() {
        if(instance == null) {
            instance = new HistoryMemoryDAO();
        }
        return instance;
    }

    @Override
    public void save(Operation operation) {
        history.add(operation);
    }

    @Override
    public List<Operation> getAll() {
        return new ArrayList<>(history);
    }
}
