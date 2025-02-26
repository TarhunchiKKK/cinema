package org.example.visitors;

import java.sql.*;
import java.util.List;
import java.util.logging.*;
import org.example.shared.interfaces.*;
import org.example.shared.utils.ConnectionsManager;

public class VisitorsRepository implements IRepository<Visitor> {
    private Connection connection = null;

    private IAdapter<Visitor> adapter = new VisitorsAdapter();

    private Long nextId = 1l;

    public VisitorsRepository() {
        this.connection = ConnectionsManager.getConnecction();
    }

    protected void finalize() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            Logger.getLogger(VisitorsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void create(Visitor entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO public.visitors(id, fio, age) VALUES (?, ?, ?);");
            statement.setLong(1, this.nextId++);
            statement.setString(2, entity.getFio());
            statement.setInt(3, entity.getAge());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(VisitorsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Visitor> findAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM public.visitors;");
            return this.adapter.parseMultiple(set);
        } catch (Exception ex) {
            Logger.getLogger(VisitorsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Visitor entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "UPDATE public.visitors SET fio=?, age=? WHERE id = ?;");
            statement.setString(1, entity.getFio());
            statement.setInt(2, entity.getAge());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(VisitorsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM public.visitors WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(VisitorsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
