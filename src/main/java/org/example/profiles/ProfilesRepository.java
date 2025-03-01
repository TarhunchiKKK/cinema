package org.example.profiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.profiles.ProfilesRepository;
import org.example.shared.interfaces.IAdapter;
import org.example.shared.interfaces.IRepository;
import org.example.shared.utils.ConnectionsManager;

public class ProfilesRepository implements IRepository<Profile> {
    private Connection connection = null;

    private IAdapter<Profile> adapter = new ProfilesAdapter();

    private Long nextId = 1l;

    public ProfilesRepository() {
        this.connection = ConnectionsManager.getConnecction();
    }

    protected void finalize() {
        try {
            this.connection.close();
        } catch (Exception ex) {
            Logger.getLogger(ProfilesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Profile entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "INSERT INTO public.profiles(id, email, password, role) VALUES (?, ?, ?, ?);");
            statement.setLong(1, this.nextId++);
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPassword());
            statement.setString(4, entity.getRole());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProfilesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Profile> findAll() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM public.profiles;");
            return this.adapter.parseMultiple(set);
        } catch (Exception ex) {
            Logger.getLogger(ProfilesRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void update(Profile entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "UPDATE public.profiles SET email=?, password=?, role=? WHERE id=?;");
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRole().toString());
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProfilesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "DELETE FROM public.profiles WHERE id=?;");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProfilesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
