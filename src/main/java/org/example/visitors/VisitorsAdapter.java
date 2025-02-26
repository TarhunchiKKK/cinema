package org.example.visitors;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.shared.interfaces.IAdapter;

public class VisitorsAdapter implements IAdapter<Visitor> {
    public Visitor parseOne(ResultSet set) {
        try {
            Long id = set.getLong("id");
            String type = set.getString("type");
            Integer seatsCount = set.getInt("seats_count");
            return new Visitor(id, type, seatsCount);
        } catch (Exception ex) {
            Logger.getLogger(VisitorsAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Visitor> parseMultiple(ResultSet set) {
        List<Visitor> visitors = new ArrayList<Visitor>();

        try {
            while (set.next()) {
                Visitor visitor = this.parseOne(set);

                if (visitor != null) {
                    visitors.add(visitor);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VisitorsAdapter.class.getName()).log(Level.SEVERE, null, ex);

        }

        return visitors;
    }
}
