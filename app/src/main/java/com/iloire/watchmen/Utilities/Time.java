package com.iloire.watchmen.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {

    public static String humanizeEpoch(long unixTimeInMs, String format){
        Date dateTime = new java.util.Date(unixTimeInMs);
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(dateTime);
    }

    /**
     * Based on http://stackoverflow.com/a/7663966/1026692
     *
     * Convert a millisecond duration to a string format
     *
     * @param millis A duration to convert to a string form
     * @return A string of the form "X Days Y Hours Z Minutes A Seconds".
     */
    public static String getHumanizedOutageDuration(long millis)
    {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        if (days > 0) {
            sb.append(days);
            sb.append(days == 1 ? "day" : " day");

            if (hours > 0) {
                sb.append(hours);
                sb.append(" h. ");
            }
        } else { // less than a day
            if (hours > 0) {
                sb.append(hours);
                sb.append(" h. ");

                sb.append(minutes);
                sb.append(" min. ");
            } else { // less than one hour
                if (minutes > 0) {
                    sb.append(minutes);
                    sb.append(" min. ");
                } else { // less than one minute
                    if (seconds > 0) {
                        sb.append(seconds);
                        sb.append(" secs.");
                    }
                }
            }
        }
        return(sb.toString());
    }
}
