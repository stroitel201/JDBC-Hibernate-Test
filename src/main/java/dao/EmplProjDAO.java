package dao;

import entity.EmplProj;
import entity.Project;

import java.util.List;

public interface EmplProjDAO {

    void add(EmplProj emplProj);

    List<EmplProj> getAll();
    EmplProj getById(long employeeId, long projectId);

    void update(EmplProj emplProj);

    void remove(EmplProj emplProj);
}
