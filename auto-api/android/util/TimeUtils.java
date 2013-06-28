package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import libcore.util.ZoneInfoDB;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TimeZone;
import java.util.Date;
import com.android.internal.util.XmlUtils;

public class TimeUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.738 -0400", hash_original_method = "90FFA2BDF77FA646318F5F30EF504BD2", hash_generated_method = "011199797FD3B540ED86DA17205AFF1D")
    public  TimeUtils() {
        // ---------- Original Method ----------
    }

    
    public static TimeZone getTimeZone(int offset, boolean dst, long when, String country) {
        if (country == null) {
            return null;
        }
        TimeZone best = null;
        Resources r = Resources.getSystem();
        XmlResourceParser parser = r.getXml(com.android.internal.R.xml.time_zones_by_country);
        Date d = new Date(when);
        TimeZone current = TimeZone.getDefault();
        String currentName = current.getID();
        int currentOffset = current.getOffset(when);
        boolean currentDst = current.inDaylightTime(d);
        try {
            XmlUtils.beginDocument(parser, "timezones");
            while (true) {
                XmlUtils.nextElement(parser);
                String element = parser.getName();
                if (element == null || !(element.equals("timezone"))) {
                    break;
                }
                String code = parser.getAttributeValue(null, "code");
                if (country.equals(code)) {
                    if (parser.next() == XmlPullParser.TEXT) {
                        String maybe = parser.getText();
                        if (maybe.equals(currentName)) {
                            if (currentOffset == offset && currentDst == dst) {
                                return current;
                            }
                        }
                        if (best == null) {
                            TimeZone tz = TimeZone.getTimeZone(maybe);
                            if (tz.getOffset(when) == offset &&
                                tz.inDaylightTime(d) == dst) {
                                best = tz;
                            }
                        }
                    }
                }
            }
        } catch (XmlPullParserException e) {
            Log.e(TAG, "Got exception while getting preferred time zone.", e);
        } catch (IOException e) {
            Log.e(TAG, "Got exception while getting preferred time zone.", e);
        } finally {
            parser.close();
        }
        return best;
    }

    
    public static String getTimeZoneDatabaseVersion() {
        return ZoneInfoDB.getVersion();
    }

    
    static private int accumField(int amt, int suffix, boolean always, int zeropad) {
        if (amt > 99 || (always && zeropad >= 3)) {
            return 3+suffix;
        }
        if (amt > 9 || (always && zeropad >= 2)) {
            return 2+suffix;
        }
        if (always || amt > 0) {
            return 1+suffix;
        }
        return 0;
    }

    
    static private int printField(char[] formatStr, int amt, char suffix, int pos,
            boolean always, int zeropad) {
        if (always || amt > 0) {
            final int startPos = pos;
            if ((always && zeropad >= 3) || amt > 99) {
                int dig = amt/100;
                formatStr[pos] = (char)(dig + '0');
                pos++;
                amt -= (dig*100);
            }
            if ((always && zeropad >= 2) || amt > 9 || startPos != pos) {
                int dig = amt/10;
                formatStr[pos] = (char)(dig + '0');
                pos++;
                amt -= (dig*10);
            }
            formatStr[pos] = (char)(amt + '0');
            pos++;
            formatStr[pos] = suffix;
            pos++;
        }
        return pos;
    }

    
    private static int formatDurationLocked(long duration, int fieldLen) {
        if (sFormatStr.length < fieldLen) {
            sFormatStr = new char[fieldLen];
        }
        char[] formatStr = sFormatStr;
        if (duration == 0) {
            int pos = 0;
            fieldLen -= 1;
            while (pos < fieldLen) {
                formatStr[pos++] = ' ';
            }
            formatStr[pos] = '0';
            return pos+1;
        }
        char prefix;
        if (duration > 0) {
            prefix = '+';
        } else {
            prefix = '-';
            duration = -duration;
        }
        int millis = (int)(duration%1000);
        int seconds = (int) Math.floor(duration / 1000);
        int days = 0, hours = 0, minutes = 0;
        if (seconds > SECONDS_PER_DAY) {
            days = seconds / SECONDS_PER_DAY;
            seconds -= days * SECONDS_PER_DAY;
        }
        if (seconds > SECONDS_PER_HOUR) {
            hours = seconds / SECONDS_PER_HOUR;
            seconds -= hours * SECONDS_PER_HOUR;
        }
        if (seconds > SECONDS_PER_MINUTE) {
            minutes = seconds / SECONDS_PER_MINUTE;
            seconds -= minutes * SECONDS_PER_MINUTE;
        }
        int pos = 0;
        if (fieldLen != 0) {
            int myLen = accumField(days, 1, false, 0);
            myLen += accumField(hours, 1, myLen > 0, 2);
            myLen += accumField(minutes, 1, myLen > 0, 2);
            myLen += accumField(seconds, 1, myLen > 0, 2);
            myLen += accumField(millis, 2, true, myLen > 0 ? 3 : 0) + 1;
            while (myLen < fieldLen) {
                formatStr[pos] = ' ';
                pos++;
                myLen++;
            }
        }
        formatStr[pos] = prefix;
        pos++;
        int start = pos;
        boolean zeropad = fieldLen != 0;
        pos = printField(formatStr, days, 'd', pos, false, 0);
        pos = printField(formatStr, hours, 'h', pos, pos != start, zeropad ? 2 : 0);
        pos = printField(formatStr, minutes, 'm', pos, pos != start, zeropad ? 2 : 0);
        pos = printField(formatStr, seconds, 's', pos, pos != start, zeropad ? 2 : 0);
        pos = printField(formatStr, millis, 'm', pos, true, (zeropad && pos != start) ? 3 : 0);
        formatStr[pos] = 's';
        return pos + 1;
    }

    
    public static void formatDuration(long duration, StringBuilder builder) {
        synchronized (sFormatSync) {
            int len = formatDurationLocked(duration, 0);
            builder.append(sFormatStr, 0, len);
        }
    }

    
    public static void formatDuration(long duration, PrintWriter pw, int fieldLen) {
        synchronized (sFormatSync) {
            int len = formatDurationLocked(duration, fieldLen);
            pw.print(new String(sFormatStr, 0, len));
        }
    }

    
    public static void formatDuration(long duration, PrintWriter pw) {
        formatDuration(duration, pw, 0);
    }

    
    public static void formatDuration(long time, long now, PrintWriter pw) {
        if (time == 0) {
            pw.print("--");
            return;
        }
        formatDuration(time-now, pw, 0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "2C9DBBB61E206F14FFD73174F05A8667", hash_generated_field = "A8D43672FE1DF54C2E9BEE03AC76E5B4")

    private static final String TAG = "TimeUtils";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "4BD1A217FD230CDD43CFFB71E099EC84", hash_generated_field = "AA8754543EDE9EF090339F4F4DB754BC")

    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "6DF9C5AB42E1E0E9960BE792F6F8A042", hash_generated_field = "B4A690B48563C09FDB0833103369D4EF")

    private static final int SECONDS_PER_MINUTE = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "684A237ED847F645256FBA1485351335", hash_generated_field = "EE6A9733E692805B2E523E6D33DA4ACC")

    private static final int SECONDS_PER_HOUR = 60 * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "85D87D41138F9BD13B31F986F32BFCBF", hash_generated_field = "9A0BD6EC4A8335B331F784B15445E7E6")

    private static final int SECONDS_PER_DAY = 24 * 60 * 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "C2324637B57092049D7068095D7E9185", hash_generated_field = "B62D876955C414BB9350CE4A9427EEC8")

    private static final Object sFormatSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.740 -0400", hash_original_field = "7F8EE94BEA697832BE6AFEC9AD753453", hash_generated_field = "23A1022E9F725A0F3BAADDA607255C69")

    private static char[] sFormatStr = new char[HUNDRED_DAY_FIELD_LEN+5];
}

