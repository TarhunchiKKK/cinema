package org.example.films;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.*;

import org.example.shared.interfaces.IAdapter;
import org.example.shared.interfaces.IRepository;
import org.example.shared.utils.ConnectionsManager;

public class FilmsRepository implements IRepository<Film> {
    private Connection connection = null;

    private IAdapter<Film> adapter = new FilmsAdapter();

    private Long nextId = 1l;

    public FilmsRepository() {
        this.connection = ConnectionsManager.getConnecction();
    }

    protected void finalize() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            Logger.getLogger(FilmsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Film entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO public.films(id, title, year, country) VALUES (?, ?, ?, ?);");
            statement.setLong(1, this.nextId++);
            statement.setString(2, entity.getTitle());
            statement.setInt(3, entity.getYear());
            statement.setString(4, entity.getCountry());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(FilmsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Film> findAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM public.films;");
            return this.adapter.parseMultiple(set);
        } catch (Exception ex) {
            Logger.getLogger(FilmsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Film entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "UPDATE public.films SET title=?, year=?, country=? WHERE id = ?;");
            statement.setString(1, entity.getTitle());
            statement.setInt(2, entity.getYear());
            statement.setString(3, entity.getCountry());
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(FilmsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM public.films WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(FilmsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
