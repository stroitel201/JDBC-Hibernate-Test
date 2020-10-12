package dao;

import entity.Employee;
import entity.Project;

import java.util.List;

public interface ProjectDAO {

    void add(Project project) throws Exception;

    List<Project> getAll() throws Exception;
    Project getById(long id) throws Exception;

    void update(Project project) throws Exception;

    void remove(Project project) throws Exception;
}
