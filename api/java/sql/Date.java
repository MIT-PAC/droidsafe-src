package java.sql;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Date extends java.util.Date {

    /**
     * Creates a {@code Date} from a string representation of a date in SQL
     * format.
     *
     * @param dateString
     *            the string representation of a date in SQL format - " {@code yyyy-MM-dd}".
     * @return the {@code Date} object.
     * @throws IllegalArgumentException
     *             if the format of the supplied string does not match the SQL
     *             format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.285 -0500", hash_original_method = "FC7C79FC527809241DADD4534B95BE5B", hash_generated_method = "19DF358F7CC2DBEF4A33710192D3BA9D")
    
public static Date valueOf(String dateString) {
        if (dateString == null) {
            throw new IllegalArgumentException();
        }
        int firstIndex = dateString.indexOf('-');
        int secondIndex = dateString.indexOf('-', firstIndex + 1);
        // secondIndex == -1 means none or only one separator '-' has been
        // found.
        // The string is separated into three parts by two separator characters,
        // if the first or the third part is null string, we should throw
        // IllegalArgumentException to follow RI
        if (secondIndex == -1 || firstIndex == 0
                || secondIndex + 1 == dateString.length()) {
            throw new IllegalArgumentException();
        }
        // parse each part of the string
        int year = Integer.parseInt(dateString.substring(0, firstIndex));
        int month = Integer.parseInt(dateString.substring(firstIndex + 1,
                secondIndex));
        int day = Integer.parseInt(dateString.substring(secondIndex + 1,
                dateString.length()));
        return new Date(year - 1900, month - 1, day);
    }

    /*
     * Private method which normalizes a Time value, removing all low
     * significance digits corresponding to milliseconds, seconds, minutes and
     * hours, so that the returned Time value corresponds to 00:00:00 GMT on a
     * particular day.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.288 -0500", hash_original_method = "01A3FB6B1C784C6B589498BF3E72AF89", hash_generated_method = "39FC440E592AD958D3DA1840FF8C82F1")
    
private static long normalizeTime(long theTime) {
        return theTime;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.251 -0500", hash_original_field = "5D55247CCC38757754CBD23F9C238832", hash_generated_field = "AB50B4CB64B1076350F49E3C7CD4E9DD")

    private static final long serialVersionUID = 1511598038487230103L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.280 -0500", hash_original_field = "6B63AE749ABE3056A4CC87C225475479", hash_generated_field = "E91DD4FD05D62E2720598D28C18C7C9E")

    private static final String PADDING = "0000";

    /**
     * Constructs a {@code Date} object corresponding to the supplied year,
     * month and day.
     *
     * @deprecated Use the constructor {@link #Date(long)}.
     * @param theYear
     *            the year, specified as the year minus 1900. Must be in the
     *            range {@code [0,8099]}.
     * @param theMonth
     *            the month, specified as a number with 0 = January. Must be in
     *            the range {@code [0,11]}.
     * @param theDay
     *            the day in the month. Must be in the range {@code [1,31]}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.254 -0500", hash_original_method = "54033E67BCAF2131C1DBBD633092C516", hash_generated_method = "C8C4841D2C7D069BC9CC87A5545C4A0A")
    
@Deprecated
    public Date(int theYear, int theMonth, int theDay) {
        super(theYear, theMonth, theDay);
    }

    /**
     * Creates a date which corresponds to the day determined by the supplied
     * milliseconds time value {@code theDate}.
     *
     * @param theDate
     *            a time value in milliseconds since the epoch - January 1 1970
     *            00:00:00 GMT. The time value (hours, minutes, seconds,
     *            milliseconds) stored in the {@code Date} object is adjusted to
     *            correspond to 00:00:00 GMT on the day determined by the supplied
     *            time value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.256 -0500", hash_original_method = "0597C0984A3A8E2CF9C870E073A794F7", hash_generated_method = "652642F15E965BBB7E5FD61A824E4250")
    
public Date(long theDate) {
        super(normalizeTime(theDate));
    }

    /**
     * @deprecated This method is deprecated and must not be used. SQL {@code
     *             Date} values do not have an hours component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.259 -0500", hash_original_method = "9D3BFA18991740345E9C4B50C3BC1C7B", hash_generated_method = "B6CC43AFE75FBF41D2D4659E1E0D1F48")
    
@Deprecated
    @Override
    public int getHours() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. SQL {@code
     *             Date} values do not have a minutes component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.262 -0500", hash_original_method = "20D35DA199D26861EF3B1850BF9B2C7B", hash_generated_method = "58BF9117E986858BF62F057055FD3040")
    
@Deprecated
    @Override
    public int getMinutes() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. SQL {@code
     *             Date} values do not have a seconds component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.264 -0500", hash_original_method = "5B3A8174ABF60BC4DD674AADB526CA5F", hash_generated_method = "7D47E178A24671905EFC2BF8A7641B44")
    
@Deprecated
    @Override
    public int getSeconds() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. SQL {@code
     *             Date} values do not have an hours component.
     * @param theHours
     *            the number of hours to set.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.267 -0500", hash_original_method = "8AEDCDA359475E67EC180A6BBC9EA00B", hash_generated_method = "4677C451B586B55518155F6083ED075A")
    
@Deprecated
    @Override
    public void setHours(int theHours) {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. SQL {@code
     *             Date} values do not have a minutes component.
     * @param theMinutes
     *            the number of minutes to set.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.269 -0500", hash_original_method = "C3170E6698742DBDFB0C085047CF3D73", hash_generated_method = "27DE06E63346B337DEAC08462741A1B4")
    
@Deprecated
    @Override
    public void setMinutes(int theMinutes) {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. SQL {@code
     *             Date} values do not have a seconds component.
     * @param theSeconds
     *            the number of seconds to set.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.272 -0500", hash_original_method = "90D475806A3C76BA7C308DE5A81BA772", hash_generated_method = "3CFC7943A6A6DD444A1E4FC2D2547F87")
    
@Deprecated
    @Override
    public void setSeconds(int theSeconds) {
        throw new IllegalArgumentException();
    }

    /**
     * Sets this date to a date supplied as a milliseconds value. The date is
     * set based on the supplied time value and rounded to zero GMT for that day.
     *
     * @param theTime
     *            the time in milliseconds since the Epoch.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.275 -0500", hash_original_method = "58DD96CFC8DDA00016DEC24CC6519017", hash_generated_method = "1F810C618BA62488684578EB05C3C6A1")
    
@Override
    public void setTime(long theTime) {
        /*
         * Store the Date based on the supplied time after removing any time
         * elements finer than the day based on zero GMT
         */
        super.setTime(normalizeTime(theTime));
    }

    /**
     * Produces a string representation of the date in SQL format
     *
     * @return a string representation of the date in SQL format - {@code "yyyy-MM-dd"}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.277 -0500", hash_original_method = "F7971D7A9962AA78000A8292B336C43C", hash_generated_method = "C4F82B04518E944139744F728FE1B9E7")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(10);

        format((getYear() + 1900), 4, sb);
        sb.append('-');
        format((getMonth() + 1), 2, sb);
        sb.append('-');
        format(getDate(), 2, sb);

        return sb.toString();
    }

    /*
    * Private method to format the time
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.282 -0500", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "42C4F2A798161F88780A237C678B7BD2")
    
private void format(int date, int digits, StringBuilder sb) {
        String str = String.valueOf(date);
        if (digits - str.length() > 0) {
            sb.append(PADDING.substring(0, digits - str.length()));
        }
        sb.append(str);
    }
}

