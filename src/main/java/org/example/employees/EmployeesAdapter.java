package org.example.employees;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.shared.interfaces.IAdapter;

public class EmployeesAdapter implements IAdapter<Employee> {
    public Employee parseOne(ResultSet set) {
        try {
            Long id = set.getLong("id");
            String fio = set.getString("fio");
            String post = set.getString("post");
            Float experience = set.getFloat("experience");
            return new Employee(id, fio, post, experience);
        } catch (Exception ex) {
            Logger.getLogger(EmployeesAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Employee> parseMultiple(ResultSet set) {
        List<Employee> halls = new ArrayList<Employee>();

        try {
            while (set.next()) {
                Employee hall = this.parseOne(set);

                if (hall != null) {
                    halls.add(hall);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeesAdapter.class.getName()).log(Level.SEVERE, null, ex);

        }

        return halls;
    }
}
