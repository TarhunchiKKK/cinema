package org.example.films;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.shared.interfaces.IAdapter;

public class FilmsAdapter implements IAdapter<Film> {
    public Film parseOne(ResultSet set) {
        try {
            Long id = set.getLong("id");
            String title = set.getString("title");
            Integer year = set.getInt("year");
            String country = set.getString("country");
            return new Film(id, title, year, country);
        } catch (Exception ex) {
            Logger.getLogger(FilmsAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Film> parseMultiple(ResultSet set) {
        List<Film> films = new ArrayList<Film>();

        try {
            while (set.next()) {
                Film film = this.parseOne(set);

                if (film != null) {
                    films.add(film);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FilmsAdapter.class.getName()).log(Level.SEVERE, null, ex);

        }

        return films;
    }
}
