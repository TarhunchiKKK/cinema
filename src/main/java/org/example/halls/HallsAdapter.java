package org.example.halls;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.shared.interfaces.IAdapter;

public class HallsAdapter implements IAdapter<Hall> {
    public Hall parseOne(ResultSet set) {
        try {
            Long id = set.getLong("id");
            String type = set.getString("type");
            Integer seatsCount = set.getInt("seats_count");
            return new Hall(id, type, seatsCount);
        } catch (Exception ex) {
            Logger.getLogger(HallsAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Hall> parseMultiple(ResultSet set) {
        List<Hall> halls = new ArrayList<Hall>();

        try {
            while (set.next()) {
                Hall hall = this.parseOne(set);

                if (hall != null) {
                    halls.add(hall);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HallsAdapter.class.getName()).log(Level.SEVERE, null, ex);

        }

        return halls;
    }
}
