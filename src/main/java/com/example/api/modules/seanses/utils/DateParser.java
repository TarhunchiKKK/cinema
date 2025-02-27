package com.example.api.modules.seanses.utils;

import java.sql.Date;

public class DateParser {
    public static Date parseDate(String str) {
        if (str == null) {
            return null;
        }

        Integer day = Integer.parseInt(str.substring(8));
        Integer month = Integer.parseInt(str.substring(5, 7)) - 1;
        Integer year = Integer.parseInt(str.substring(0, 4));
        return new Date(year, month, day);
    }
}
