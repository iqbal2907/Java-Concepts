package com.concept.genralprograms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateToStringAndStringToDate {
    public static void main(String[] args) {

        Date date1 = new Date();
        System.out.println("Date1 object : "+date1);
        String str = "Friday, Jan 23, 2015 00:00:00 AM";//formatter.format(date1);

//        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");

/*        String str = "Tue Feb 03 11:10:17 IST 2015";//formatter.format(date1);
        String str = "Friday, Jan 23, 2015 00:00:00 AM";//formatter.format(date1);
*/        System.out.println("Date in string : "+str);

        SimpleDateFormat formatter2 = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");

        try {
            Date date2 = formatter2.parse(str);
            System.out.println("Date2 object : "+date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

/*        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
        try {
            Date date2 = formatter.parse(str);
            System.out.println("Date2 object : "+date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/

    }
}
