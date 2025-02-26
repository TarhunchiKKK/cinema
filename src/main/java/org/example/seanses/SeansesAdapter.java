package org.example.seanses;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.films.FilmsAdapter;
import org.example.shared.interfaces.IAdapter;

public class SeansesAdapter implements IAdapter<Seans> {
    public Seans parseOne(ResultSet set) {
        try {
            Long id = set.getLong("id");
            Date date = set.getDate("date");
            Float price = set.getFloat("price");
            Integer duration = set.getInt("duration");
            return new Seans(id, date, price, duration);
        } catch (Exception ex) {
            Logger.getLogger(FilmsAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Seans> parseMultiple(ResultSet set) {
        List<Seans> seanses = new ArrayList<Seans>();

        try {
            while (set.next()) {
                Seans seans = this.parseOne(set);

                if (seans != null) {
                    seanses.add(seans);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FilmsAdapter.class.getName()).log(Level.SEVERE, null, ex);

        }

        return seanses;
    }
}
