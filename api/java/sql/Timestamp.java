package java.sql;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Timestamp extends Date {

    /**
     * Creates a {@code Timestamp} object with a time value equal to the time
     * specified by a supplied String holding the time in JDBC timestamp escape
     * format, which is {@code "yyyy-MM-dd HH:mm:ss.nnnnnnnnn}"
     *
     * @param s
     *            the {@code String} containing a time in JDBC timestamp escape
     *            format.
     * @return A {@code Timestamp} object with time value as defined by the
     *         supplied {@code String}.
     * @throws IllegalArgumentException
     *             if the provided string is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.640 -0500", hash_original_method = "A43DAE0ECA210F02BC68FC6C9F903531", hash_generated_method = "64D2B9677B4DA705F673AC6E92B504F9")
    
public static Timestamp valueOf(String s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }

        // omit trailing whitespace
        s = s.trim();
        if (!Pattern.matches(TIME_FORMAT_REGEX, s)) {
            throw badTimestampString(s);
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pp = new ParsePosition(0);

        /*
         * First parse out the yyyy-MM-dd HH:mm:ss component of the String into
         * a Date object using the SimpleDateFormat. This should stop after the
         * seconds value, according to the definition of SimpleDateFormat.parse,
         * with the ParsePosition indicating the index of the "." which should
         * precede the nanoseconds value
         */
        Date theDate;
        try {
            theDate = df.parse(s, pp);
        } catch (Exception e) {
            throw badTimestampString(s);
        }

        if (theDate == null) {
            throw badTimestampString(s);
        }

        /*
         * If we get here, the Date part of the string was OK - now for the
         * nanoseconds value. Strictly, this requires the remaining part of the
         * String to look like ".nnnnnnnnn". However, we accept anything with a
         * '.' followed by 1 to 9 digits - we also accept nothing (no fractions
         * of a second). Anything else is interpreted as incorrect format which
         * will generate an IllegalArgumentException
         */
        int position = pp.getIndex();
        int remaining = s.length() - position;
        int theNanos;

        if (remaining == 0) {
            // First, allow for the case where no fraction of a second is given:
            theNanos = 0;
        } else {
            /*
             * Case where fraction of a second is specified: Require 1 character
             * plus the "." in the remaining part of the string...
             */
            if ((s.length() - position) < ".n".length()) {
                throw badTimestampString(s);
            }

            /*
             * If we're strict, we should not allow any EXTRA characters after
             * the 9 digits
             */
            if ((s.length() - position) > ".nnnnnnnnn".length()) {
                throw badTimestampString(s);
            }

            // Require the next character to be a "."
            if (s.charAt(position) != '.') {
                throw new NumberFormatException("Bad input string format: expected '.' not '" +
                        s.charAt(position) + "' in \"" + s + "\"");
            }
            // Get the length of the number string - need to account for the '.'
            int nanoLength = s.length() - position - 1;

            // Get the 9 characters following the "." as an integer
            String theNanoString = s.substring(position + 1, position + 1
                    + nanoLength);
            /*
             * We must adjust for the cases where the nanos String was not 9
             * characters long by padding out with zeros
             */
            theNanoString = theNanoString + "000000000";
            theNanoString = theNanoString.substring(0, 9);

            try {
                theNanos = Integer.parseInt(theNanoString);
            } catch (Exception e) {
                // If we get here, the string was not a number
                throw badTimestampString(s);
            }
        }

        if (theNanos < 0 || theNanos > 999999999) {
            throw badTimestampString(s);
        }

        Timestamp theTimestamp = new Timestamp(theDate.getTime());
        theTimestamp.setNanos(theNanos);

        return theTimestamp;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.643 -0500", hash_original_method = "379D498F436DC6BA5AB970731D566E79", hash_generated_method = "4E15F3DA83104176E624A00C745457DB")
    
private static IllegalArgumentException badTimestampString(String s) {
        throw new IllegalArgumentException("Timestamp format must be " +
                "yyyy-MM-dd HH:mm:ss.fffffffff; was '" + s + "'");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.588 -0500", hash_original_field = "85130567E01D776BB425A7E2B6DDD69E", hash_generated_field = "5666E37C9E24829F13915667F1E900D0")

    private static final long serialVersionUID = 2745179027874758501L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.593 -0500", hash_original_field = "7DA69D00556E43AC749EDD5D759ED918", hash_generated_field = "1DE35ED5D2701F5BA25ACDF3A3E82857")

    private static final String TIME_FORMAT_REGEX = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.633 -0500", hash_original_field = "889B8613D7221EB67E3BCB1C4A118158", hash_generated_field = "7CD6F5F30BFE0B9B9FCAF17A4B57A1F7")

    private static final String PADDING = "000000000";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.591 -0500", hash_original_field = "9BEB14807E9BD25C91ACC11514BF28AE", hash_generated_field = "02AA9EFEAC0A700829C2BFFE89AB3713")

    private int nanos;

    /**
     * Returns a {@code Timestamp} corresponding to the time specified by the
     * supplied values for <i>Year</i>, <i>Month</i>, <i>Date</i>, <i>Hour</i>,
     * <i>Minutes</i>, <i>Seconds</i> and <i>Nanoseconds</i>.
     *
     * @deprecated Use the constructor {@link #Timestamp(long)}.
     * @param theYear
     *            specified as the year minus 1900.
     * @param theMonth
     *            specified as an integer in the range [0,11].
     * @param theDate
     *            specified as an integer in the range [1,31].
     * @param theHour
     *            specified as an integer in the range [0,23].
     * @param theMinute
     *            specified as an integer in the range [0,59].
     * @param theSecond
     *            specified as an integer in the range [0,59].
     * @param theNano
     *            which defines the nanosecond value of the timestamp specified
     *            as an integer in the range [0,999'999'999]
     * @throws IllegalArgumentException
     *             if any of the parameters is out of range.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.596 -0500", hash_original_method = "48500113F421714EC43BE387D502DA70", hash_generated_method = "9E29B82E0CE991AA90D9D496CB994378")
    
@SuppressWarnings("deprecation")
    @Deprecated
    public Timestamp(int theYear, int theMonth, int theDate, int theHour,
            int theMinute, int theSecond, int theNano)
            throws IllegalArgumentException {
        super(theYear, theMonth, theDate, theHour, theMinute, theSecond);
        if (theNano < 0 || theNano > 999999999) {
            throw new IllegalArgumentException();
        }
        nanos = theNano;
    }

    /**
     * Returns a {@code Timestamp} object corresponding to the time represented
     * by a supplied time value.
     *
     * @param theTime
     *            a time value in the format of milliseconds since the Epoch
     *            (January 1 1970 00:00:00.000 GMT).
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.599 -0500", hash_original_method = "86C700BF2C693DDDD6950F4A0D10E64A", hash_generated_method = "1906AE39ACDEF7A3327208E54D6A248D")
    
public Timestamp(long theTime) {
        super(theTime);
        /*
         * Now set the time for this Timestamp object - which deals with the
         * nanosecond value as well as the base time
         */
        setTimeImpl(theTime);
    }

    /**
     * Returns {@code true} if this timestamp object is later than the supplied
     * timestamp, otherwise returns {@code false}.
     *
     * @param theTimestamp
     *            the timestamp to compare with this timestamp object.
     * @return {@code true} if this {@code Timestamp} object is later than the
     *         supplied timestamp, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.602 -0500", hash_original_method = "BA6D499959EBEE9331B456EE3E086445", hash_generated_method = "9A3B7D7B1F8A38BBAA9C6E5669C5024C")
    
public boolean after(Timestamp theTimestamp) {
        long thisTime = this.getTime();
        long compareTime = theTimestamp.getTime();

        // If the time value is later, the timestamp is later
        if (thisTime > compareTime) {
            return true;
        }
        // If the time value is earlier, the timestamp is not later
        else if (thisTime < compareTime) {
            return false;
        }
        /*
         * Otherwise the time values are equal in which case the nanoseconds
         * value determines whether this timestamp is later...
         */
        else if (this.getNanos() > theTimestamp.getNanos()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns {@code true} if this {@code Timestamp} object is earlier than the
     * supplied timestamp, otherwise returns {@code false}.
     *
     * @param theTimestamp
     *            the timestamp to compare with this {@code Timestamp} object.
     * @return {@code true} if this {@code Timestamp} object is earlier than the
     *         supplied timestamp, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.604 -0500", hash_original_method = "C18CB1ECE736F4CE544A02EE2F0A015C", hash_generated_method = "54B150F35462A968131F326A2EDBB745")
    
public boolean before(Timestamp theTimestamp) {
        long thisTime = this.getTime();
        long compareTime = theTimestamp.getTime();

        // If the time value is later, the timestamp is later
        if (thisTime < compareTime) {
            return true;
        }
        // If the time value is earlier, the timestamp is not later
        else if (thisTime > compareTime) {
            return false;
        }
        /*
         * Otherwise the time values are equal in which case the nanoseconds
         * value determines whether this timestamp is later...
         */
        else if (this.getNanos() < theTimestamp.getNanos()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Compares this {@code Timestamp} object with a supplied {@code Timestamp}
     * object.
     *
     * @param theObject
     *            the timestamp to compare with this {@code Timestamp} object,
     *            passed as an {@code Object}.
     * @return <dd>
     *         <dl>
     *         {@code 0} if the two {@code Timestamp} objects are equal in time
     *         </dl>
     *         <dl>
     *         a value {@code < 0} if this {@code Timestamp} object is before
     *         the supplied {@code Timestamp} and a value
     *         </dl>
     *         <dl>
     *         {@code > 0} if this {@code Timestamp} object is after the
     *         supplied {@code Timestamp}
     *         </dl>
     *         </dd>
     * @throws ClassCastException
     *             if the supplied object is not a {@code Timestamp} object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.607 -0500", hash_original_method = "05A91DEA116C3E2F5603F3F0D29353F9", hash_generated_method = "6913C2CAA66A64CC02A4479F7027889D")
    
@Override
    public int compareTo(Date theObject) throws ClassCastException {
        return this.compareTo((Timestamp) theObject);
    }

    /**
     * Compares this {@code Timestamp} object with a supplied {@code Timestamp}
     * object.
     *
     * @param theTimestamp
     *            the timestamp to compare with this {@code Timestamp} object,
     *            passed in as a {@code Timestamp}.
     * @return one of the following:
     *         <ul>
     *         <li>{@code 0}, if the two {@code Timestamp} objects are
     *         equal in time</li>
     *         <li>{@code < 0}, if this {@code Timestamp} object is before the
     *         supplied {@code Timestamp}</li>
     *         <li> {@code > 0}, if this {@code Timestamp} object is after the
     *         supplied {@code Timestamp}</li>
     *         </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.609 -0500", hash_original_method = "5F716ED3C44AF0E8E5B469B5E8E10C8F", hash_generated_method = "4BF9FAA4B4AB3AC55D9B8EB82863EA44")
    
public int compareTo(Timestamp theTimestamp) {
        int result = super.compareTo(theTimestamp);
        if (result == 0) {
            int thisNano = this.getNanos();
            int thatNano = theTimestamp.getNanos();
            if (thisNano > thatNano) {
                return 1;
            } else if (thisNano == thatNano) {
                return 0;
            } else {
                return -1;
            }
        }
        return result;
    }

    /**
     * Tests to see if this timestamp is equal to a supplied object.
     *
     * @param theObject
     *            the object to which this timestamp is compared.
     * @return {@code true} if this {@code Timestamp} object is equal to the
     *         supplied {@code Timestamp} object<br>{@code false} if the object
     *         is not a {@code Timestamp} object or if the object is a {@code
     *         Timestamp} but represents a different instant in time.
     */
    @DSSpec(DSCat.TRIGGER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.612 -0500", hash_original_method = "94CEF17B9A7A2098B0DD6F205E7F606C", hash_generated_method = "E9928B27F2DF539B2F0201B1CD0966F1")
    
@Override
    public boolean equals(Object theObject) {
        if (theObject instanceof Timestamp) {
            return equals((Timestamp) theObject);
        }
        return false;
    }

    /**
     * Tests to see if this timestamp is equal to a supplied timestamp.
     *
     * @param theTimestamp
     *            the timestamp to compare with this {@code Timestamp} object,
     *            passed as an {@code Object}.
     * @return {@code true} if this {@code Timestamp} object is equal to the
     *         supplied {@code Timestamp} object, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.615 -0500", hash_original_method = "42296DC9EADFEA8A232AFEC4CE089FE4", hash_generated_method = "5F24148571F9B41E8B35FB5513F9ABD6")
    
public boolean equals(Timestamp theTimestamp) {
        if (theTimestamp == null) {
            return false;
        }
        return (this.getTime() == theTimestamp.getTime())
                && (this.getNanos() == theTimestamp.getNanos());
    }

    /**
     * Gets this {@code Timestamp}'s nanosecond value
     *
     * @return The timestamp's nanosecond value, an integer between 0 and
     *         999,999,999.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.618 -0500", hash_original_method = "B1AC9E2AEA3FCD014890A3BD86F2475F", hash_generated_method = "5FFF6A10F1154688321D79459C5AFC52")
    
public int getNanos() {
        return nanos;
    }

    /**
     * Returns the time represented by this {@code Timestamp} object, as a long
     * value containing the number of milliseconds since the Epoch (January 1
     * 1970, 00:00:00.000 GMT).
     *
     * @return the number of milliseconds that have passed since January 1 1970,
     *         00:00:00.000 GMT.
     */
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.CALENDAR_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.620 -0500", hash_original_method = "66C377BC30C9278F77FB30382314DC3B", hash_generated_method = "500B3D6CEDD1457D33FBA0F9085B83A5")
    
@Override
    public long getTime() {
        long theTime = super.getTime();
        theTime = theTime + (nanos / 1000000);
        return theTime;
    }

    /**
     * Sets the nanosecond value for this {@code Timestamp}.
     *
     * @param n
     *            number of nanoseconds.
     * @throws IllegalArgumentException
     *             if number of nanoseconds smaller than 0 or greater than
     *             999,999,999.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.623 -0500", hash_original_method = "37C2FDD9B2CBC513E6901A3C5AB99296", hash_generated_method = "8C475577E81C1FA3F24829BD01FB3CD2")
    
public void setNanos(int n) throws IllegalArgumentException {
        if ((n < 0) || (n > 999999999)) {
            throw new IllegalArgumentException("Value out of range");
        }
        nanos = n;
    }

    /**
     * Sets the time represented by this {@code Timestamp} object to the
     * supplied time, defined as the number of milliseconds since the Epoch
     * (January 1 1970, 00:00:00.000 GMT).
     *
     * @param theTime
     *            number of milliseconds since the Epoch (January 1 1970,
     *            00:00:00.000 GMT).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.625 -0500", hash_original_method = "3EB39E1DE2409F6F629FCF4F69DCED8F", hash_generated_method = "96446DD26B134BD21BA230C177DCDF09")
    
@Override
    public void setTime(long theTime) {
        setTimeImpl(theTime);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.627 -0500", hash_original_method = "359A4BB179960D3D4DBBF4A52D3B05F3", hash_generated_method = "BAC1B09601CE7610058933820B7B6EF3")
    
private void setTimeImpl(long theTime) {
        /*
         * Deal with the nanoseconds value. The supplied time is in milliseconds -
         * so we must extract the milliseconds value and multiply by 1000000 to
         * get nanoseconds. Things are more complex if theTime value is
         * negative, since then the time value is the time before the Epoch but
         * the nanoseconds value of the Timestamp must be positive - so we must
         * take the "raw" milliseconds value and subtract it from 1000 to get to
         * the true nanoseconds value Simultaneously, recalculate the time value
         * to the exact nearest second and reset the Date time value
         */
        int milliseconds = (int) (theTime % 1000);
        theTime = theTime - milliseconds;
        if (milliseconds < 0) {
            theTime = theTime - 1000;
            milliseconds = 1000 + milliseconds;
        }
        super.setTime(theTime);
        setNanos(milliseconds * 1000000);
    }

    /**
     * Returns the timestamp formatted as a String in the JDBC Timestamp Escape
     * format, which is {@code "yyyy-MM-dd HH:mm:ss.nnnnnnnnn"}.
     *
     * @return A string representing the instant defined by the {@code
     *         Timestamp}, in JDBC Timestamp escape format.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.630 -0500", hash_original_method = "2B0509572F21FC3F2C9AAE0AC4AFD2F5", hash_generated_method = "1A641F963856371CD431B2C5A921C583")
    
@SuppressWarnings("deprecation")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(29);

        format((getYear() + 1900), 4, sb);
        sb.append('-');
        format((getMonth() + 1), 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);
        sb.append(' ');
        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);
        sb.append('.');
        if (nanos == 0) {
            sb.append('0');
        } else {
            format(nanos, 9, sb);
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
        }

        return sb.toString();
    }

    /*
    * Private method to format the time
    */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.636 -0500", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "42C4F2A798161F88780A237C678B7BD2")
    
private void format(int date, int digits, StringBuilder sb) {
        String str = String.valueOf(date);
        if (digits - str.length() > 0) {
            sb.append(PADDING.substring(0, digits - str.length()));
        }
        sb.append(str);
    }
}

