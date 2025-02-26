package org.example.employees;

import java.sql.*;
import java.util.List;
import java.util.logging.*;
import org.example.shared.interfaces.*;
import org.example.shared.utils.ConnectionsManager;

public class EmployeesRepository implements IRepository<Employee> {
    private Connection connection = null;

    private IAdapter<Employee> adapter = new EmployeesAdapter();

    private Long nextId = 1l;

    public EmployeesRepository() {
        this.connection = ConnectionsManager.getConnecction();
    }

    protected void finalize() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            Logger.getLogger(EmployeesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void blank() {
        Employee employee = new Employee(1l, "Blank Employee", "sdzffxgc", 0f);
        delete(employee.getId());
    }

    @Override
    public void create(Employee entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO public.employees(id, fio, post, experience) VALUES (?, ?, ?, ?);");
            statement.setLong(1, this.nextId++);
            statement.setString(2, entity.getFio());
            statement.setString(3, entity.getPost());
            statement.setFloat(4, entity.getExperience());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EmployeesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Employee> findAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM public.employees;");
            return this.adapter.parseMultiple(set);
        } catch (Exception ex) {
            Logger.getLogger(EmployeesRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Employee entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "UPDATE public.employees SET fio=?, post=?, experience=? WHERE id = ?;");
            statement.setString(1, entity.getFio());
            statement.setString(2, entity.getPost());
            statement.setFloat(3, entity.getExperience());
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EmployeesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM public.employees WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EmployeesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
