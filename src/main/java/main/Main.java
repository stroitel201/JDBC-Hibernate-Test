package main;

import business.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("USA");
        address.setCity("LA");
        address.setStreet("Avenue 5");
        address.setPostCode("222060");

        Employee employee = new Employee();
        employee.setFirstName("Ivan");
        employee.setLastName("Ivanovich");
        employee.setAddress(address);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.APRIL, 1);
        employee.setBirthday(new Date(calendar.getTime().getTime()));

        Project project = new Project();
        project.setTitle("228");

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
