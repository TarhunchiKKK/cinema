package org.example.halls;

import java.sql.*;
import java.util.List;
import java.util.logging.*;
import org.example.shared.interfaces.*;
import org.example.shared.utils.ConnectionsManager;

public class HallsRepository implements IRepository<Hall> {
    private Connection connection = null;

    private IAdapter<Hall> adapter = new HallsAdapter();

    private Long nextId = 1l;

    public HallsRepository() {
        this.connection = ConnectionsManager.getConnecction();
    }

    protected void finalize() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            Logger.getLogger(HallsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Hall entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO public.halls(id, type, seats_count) VALUES (?, ?, ?);");
            statement.setLong(1, this.nextId++);
            statement.setString(2, entity.getType());
            statement.setInt(3, entity.getSeatsCount());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HallsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Hall> findAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM public.films;");
            return this.adapter.parseMultiple(set);
        } catch (Exception ex) {
            Logger.getLogger(HallsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Hall entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "UPDATE public.halls SET type=?, seats_count=? WHERE id = ?;");
            statement.setString(1, entity.getType());
            statement.setInt(2, entity.getSeatsCount());
            statement.setLong(3, entity.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HallsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM public.halls WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(HallsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
