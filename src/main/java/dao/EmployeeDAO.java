package dao;

import entity.Address;
import entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void add(Employee employee) throws Exception;

    List<Employee> getAll() throws Exception;
    Employee getById(long id) throws Exception;

    void update(Employee employee) throws Exception;

    void remove(Employee employee) throws Exception;

}
