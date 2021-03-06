package com.epul.androidcinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Outil {

    ///
    // On convertit une date en chaîne
    ///
    public static String DateToString (Date d)
    {
        // on crée son propre format
        DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
        // on lance la conversion
        return  dateFormatpers.format(d);
    }

    ///
    // On convertit une chaîne en date
    ///
    public  static Date chaineTodate(String s)
    {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date unedate = null;
        try {

            unedate= (Date) formatter.parse(s);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unedate;
    }
}
