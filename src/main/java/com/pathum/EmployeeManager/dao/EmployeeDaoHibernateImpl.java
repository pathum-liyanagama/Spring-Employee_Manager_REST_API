package com.pathum.EmployeeManager.dao;

import com.pathum.EmployeeManager.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;

    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Employee.class, employeeId);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
