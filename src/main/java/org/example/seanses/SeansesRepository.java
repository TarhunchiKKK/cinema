package org.example.seanses;

import java.sql.*;
import java.util.List;
import java.util.logging.*;
import org.example.shared.interfaces.*;
import org.example.shared.utils.ConnectionsManager;

public class SeansesRepository implements IRepository<Seans> {
    private Connection connection = null;

    private IAdapter<Seans> adapter = new SeansesAdapter();

    private Long nextId = 1l;

    public SeansesRepository() {
        this.connection = ConnectionsManager.getConnecction();
    }

    protected void finalize() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            Logger.getLogger(SeansesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createBlank() {
        Seans seans = new Seans(1l, new java.util.Date(1990, 11, 5), 0.5f, 173);
        delete(seans.getId());
    }

    @Override
    public void create(Seans entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO public.seanses(id, date, price, duration, film_id, hall_id) VALUES (?, ?, ?, ?, ?, ?);");
            statement.setLong(1, this.nextId++);
            statement.setDate(2, entity.getDate());
            statement.setFloat(3, entity.getPrice());
            statement.setInt(4, entity.getDuration());
            statement.setNull(5, Types.INTEGER);
            statement.setNull(6, Types.INTEGER);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SeansesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Seans> findAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM public.seanses;");
            return this.adapter.parseMultiple(set);
        } catch (Exception ex) {
            Logger.getLogger(SeansesRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Seans entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "UPDATE public.seanses SET date=?, price=?, duration=?, film_id=?, hall_id=? WHERE id = ?;");
            statement.setDate(1, entity.getDate());
            statement.setFloat(2, entity.getPrice());
            statement.setInt(3, entity.getDuration());
            statement.setNull(4, Types.INTEGER);
            statement.setNull(5, Types.INTEGER);
            statement.setLong(6, entity.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SeansesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM public.seanses WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SeansesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
