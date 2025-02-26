package org.example.shared.interfaces;

import java.sql.ResultSet;
import java.util.List;

public interface IAdapter<T> {
    T parseOne(ResultSet set);

    List<T> parseMultiple(ResultSet set);
}
