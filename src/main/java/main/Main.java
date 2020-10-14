package main;

import business.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import javax.persistence.Query;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        employeeService.add(employee);
        System.out.println(employeeService.getById(1));
        List<Employee> list = employeeService.getAll();
        for (Employee e:list
             ) {
            System.out.println(e);
        }
        HibernateUtil.shutdown();

    }
}
