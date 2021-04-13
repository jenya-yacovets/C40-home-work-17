package by.tms.project.dao;

import by.tms.project.entity.Operation;

import java.util.List;

public interface HistoryDAO {
    void save(Operation operation);
    List<Operation> getAll();
}
