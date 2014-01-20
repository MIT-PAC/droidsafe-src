package android.support.v4.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;

public class TimeUtils {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.424 -0500", hash_original_method = "3FC6E7A781E4B58A630369339A3D0BEC", hash_generated_method = "EECD5E318F2EA565268D88054CAB5761")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.427 -0500", hash_original_method = "1BBF330F6A4567EA2AE19E3B3560AD54", hash_generated_method = "07A4496E10EC28E39A60E68D4CA6C3CF")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.431 -0500", hash_original_method = "826438819CB717CC8A3FB2457A65894D", hash_generated_method = "EF538B9BD0004222912AD3282380374C")
    
private static int formatDurationLocked(long duration, int fieldLen) {
        if (sFormatStr.length < fieldLen) {
            sFormatStr = new char[fieldLen];
        }
        
        char[] formatStr = sFormatStr;
        
        if (duration == 0) {
            int pos = 0;
            fieldLen -= 1;
            while (pos < fieldLen) {
                formatStr[pos] = ' ';
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
    
    /** @hide Just for debugging; not internationalized. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.433 -0500", hash_original_method = "1366E789E8CAAE7D93C89843FCE6813C", hash_generated_method = "E6F8E30BB5EB4EE5C89A332DA649D340")
    
public static void formatDuration(long duration, StringBuilder builder) {
        synchronized (sFormatSync) {
            int len = formatDurationLocked(duration, 0);
            builder.append(sFormatStr, 0, len);
        }
    }

    /** @hide Just for debugging; not internationalized. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.436 -0500", hash_original_method = "DBDFBA5038D80AC5162259AFC65B8D4F", hash_generated_method = "E6DF4AD700BBBE4613CA341D1572CE70")
    
public static void formatDuration(long duration, PrintWriter pw, int fieldLen) {
        synchronized (sFormatSync) {
            int len = formatDurationLocked(duration, fieldLen);
            pw.print(new String(sFormatStr, 0, len));
        }
    }

    /** @hide Just for debugging; not internationalized. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.438 -0500", hash_original_method = "47E75E59C6A2D5D19177425D09DE2E1A", hash_generated_method = "F77CBB27F677652FA95219D81770895A")
    
public static void formatDuration(long duration, PrintWriter pw) {
        formatDuration(duration, pw, 0);
    }
    
    /** @hide Just for debugging; not internationalized. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.441 -0500", hash_original_method = "3AF68F24D91F7F9985830C67404B19FC", hash_generated_method = "AA8801589BF409B1AC30FEF25C089C46")
    
public static void formatDuration(long time, long now, PrintWriter pw) {
        if (time == 0) {
            pw.print("--");
            return;
        }
        formatDuration(time-now, pw, 0);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.408 -0500", hash_original_field = "A41642690A9A95087E80F8ADBE7A1451", hash_generated_field = "AA8754543EDE9EF090339F4F4DB754BC")

    public static final int HUNDRED_DAY_FIELD_LEN = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.411 -0500", hash_original_field = "CCF3D7934C5CF0E828DC919DE4C03FBB", hash_generated_field = "B4A690B48563C09FDB0833103369D4EF")
    
    private static final int SECONDS_PER_MINUTE = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.414 -0500", hash_original_field = "B74C4AAABF949CC9638421C3FF2ED2F9", hash_generated_field = "EE6A9733E692805B2E523E6D33DA4ACC")

    private static final int SECONDS_PER_HOUR = 60 * 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.416 -0500", hash_original_field = "326917843CE49F43CA3C8BFD7B20CB98", hash_generated_field = "9A0BD6EC4A8335B331F784B15445E7E6")

    private static final int SECONDS_PER_DAY = 24 * 60 * 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.419 -0500", hash_original_field = "57122C12B14FAFC205DF7ECFC3D203DA", hash_generated_field = "B62D876955C414BB9350CE4A9427EEC8")

    private static final Object sFormatSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:27.421 -0500", hash_original_field = "2C9FFE246E6936B3E5EBBCA18E32E183", hash_generated_field = "23A1022E9F725A0F3BAADDA607255C69")

    private static char[] sFormatStr = new char[HUNDRED_DAY_FIELD_LEN+5];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.156 -0400", hash_original_method = "6BC0B1A4515F305A86E1A30B3A6583CB", hash_generated_method = "6BC0B1A4515F305A86E1A30B3A6583CB")
    public TimeUtils ()
    {
        //Synthesized constructor
    }
}

