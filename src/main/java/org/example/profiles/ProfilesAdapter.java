package org.example.profiles;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import org.example.shared.interfaces.IAdapter;

public class ProfilesAdapter implements IAdapter<Profile> {
    public Profile parseOne(ResultSet set) {
        try {
            Long id = set.getLong("id");
            String email = set.getString("email");
            String password = set.getString("password");
            String role = set.getString("role");
            return new Profile(id, email, password, role);
        } catch (Exception ex) {
            Logger.getLogger(ProfilesAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Profile> parseMultiple(ResultSet set) {
        List<Profile> profiles = new ArrayList<Profile>();

        try {
            while (set.next()) {
                Profile profile = this.parseOne(set);

                if (profile != null) {
                    profiles.add(profile);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProfilesAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profiles;
    }
}
