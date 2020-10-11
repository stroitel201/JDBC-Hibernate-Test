package dao;

import entity.Address;
import entity.Employee;

import java.util.List;

public interface EmplopyeeDAO {

    void add(Employee employee);

    List<Employee> getAll();
    Employee getById(long id);

    void update(Employee employee);

    void remove(Employee employee);

}
