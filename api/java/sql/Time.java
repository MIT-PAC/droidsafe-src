package java.sql;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

public class Time extends Date {

    /**
     * Creates a {@code Time} object from a string holding a time represented in
     * JDBC escape format: {@code hh:mm:ss}.
     * <p>
     * An exception occurs if the input string does not comply with this format.
     *
     * @param timeString
     *            A String representing the time value in JDBC escape format:
     *            {@code hh:mm:ss}.
     * @return The {@code Time} object set to a time corresponding to the given
     *         time.
     * @throws IllegalArgumentException
     *             if the supplied time string is not in JDBC escape format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.435 -0500", hash_original_method = "AA506CC3B0FAA4D759DD5518FC1CB57C", hash_generated_method = "BFF4DC3C3EAF5AF467939B509F8DF063")
    
public static Time valueOf(String timeString) {
        if (timeString == null) {
            throw new IllegalArgumentException();
        }
        int firstIndex = timeString.indexOf(':');
        int secondIndex = timeString.indexOf(':', firstIndex + 1);
        // secondIndex == -1 means none or only one separator '-' has been
        // found.
        // The string is separated into three parts by two separator characters,
        // if the first or the third part is null string, we should throw
        // IllegalArgumentException to follow RI
        if (secondIndex == -1 || firstIndex == 0
                || secondIndex + 1 == timeString.length()) {
            throw new IllegalArgumentException();
        }
        // parse each part of the string
        int hour = Integer.parseInt(timeString.substring(0, firstIndex));
        int minute = Integer.parseInt(timeString.substring(firstIndex + 1,
                secondIndex));
        int second = Integer.parseInt(timeString.substring(secondIndex + 1,
                timeString.length()));
        return new Time(hour, minute, second);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.395 -0500", hash_original_field = "566E16E9A1BEC2B21274067FBF29DFFA", hash_generated_field = "4135C293268358DD66284F75791C870B")

    private static final long serialVersionUID = 8397324403548013681L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.429 -0500", hash_original_field = "497A72B691A0ED83978226EE6DC45FA0", hash_generated_field = "87ECBDD5C24F81CDDFA22805D091687F")

    private static final String PADDING = "00";

    /**
     * Constructs a {@code Time} object using the supplied values for <i>Hour</i>,
     * <i>Minute</i> and <i>Second</i>. The <i>Year</i>, <i>Month</i> and
     * <i>Day</i> elements of the {@code Time} object are set to the date
     * of the Epoch (January 1, 1970).
     * <p>
     * Any attempt to access the <i>Year</i>, <i>Month</i> or <i>Day</i>
     * elements of a {@code Time} object will result in an {@code
     * IllegalArgumentException}.
     * <p>
     * The result is undefined if any argument is out of bounds.
     *
     * @deprecated Use the constructor {@link #Time(long)}.
     * @param theHour
     *            a value in the range {@code [0,23]}.
     * @param theMinute
     *            a value in the range {@code [0,59]}.
     * @param theSecond
     *            a value in the range {@code [0,59]}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.399 -0500", hash_original_method = "90AD2E582B6AD132E43906287427EB15", hash_generated_method = "CBC503D6A3E6A288968A9EBBC459EA7A")
    
@SuppressWarnings("deprecation")
    @Deprecated
    public Time(int theHour, int theMinute, int theSecond) {
        super(70, 0, 1, theHour, theMinute, theSecond);
    }

    /**
     * Constructs a {@code Time} object using a supplied time specified in
     * milliseconds.
     *
     * @param theTime
     *            a {@code Time} specified in milliseconds since the
     *            <i>Epoch</i> (January 1st 1970, 00:00:00.000).
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.401 -0500", hash_original_method = "B92128F71421A4A6F232F0ACA6BED466", hash_generated_method = "A7E8C95BC20E27D3316018E3FD76067B")
    
public Time(long theTime) {
        super(theTime);
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a {@code Date} component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.404 -0500", hash_original_method = "B5DD06F1BCDFBA8A25753DB83CF1DFDC", hash_generated_method = "3A65018A2CD5D3018A5C2756E768040B")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getDate() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a <i>Day</i> component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.407 -0500", hash_original_method = "665EBFB3A2ED57C64152ECE07C939E3F", hash_generated_method = "4C5FFEA472B1DA43678EE8BF20CE37C3")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getDay() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a <i>Month</i> component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.410 -0500", hash_original_method = "69C5A301771AF98F1D4892C6CE16968D", hash_generated_method = "DDA89909FBA9B60BF2EE4EC94510791E")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getMonth() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a <i>Year</i> component.
     * @return does not return anything.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.412 -0500", hash_original_method = "7CCE4B7904CC8188031B8C2C69560853", hash_generated_method = "2E2EA23BFB4A5BEDFF1D2A7D91FD2C58")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public int getYear() {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a {@code Date} component.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.415 -0500", hash_original_method = "06E47849A7E1FF17AD4998EA261CC682", hash_generated_method = "C6D6750EA2C02FB82933AEE5459A1727")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setDate(int i) {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a <i>Month</i> component.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.418 -0500", hash_original_method = "C1F6FF91AA347F0EE969BFBA7872CFEF", hash_generated_method = "7737A7C42FEABB64EE8DFBF4B2B900E7")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setMonth(int i) {
        throw new IllegalArgumentException();
    }

    /**
     * @deprecated This method is deprecated and must not be used. An SQL
     *             {@code Time} object does not have a <i>Year</i> component.
     * @throws IllegalArgumentException
     *             if this method is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.421 -0500", hash_original_method = "C3860AE5740D96D0AEE02219E848BE80", hash_generated_method = "9B16E29124C6F3DAEA6C72946B4FB8F4")
    
@SuppressWarnings("deprecation")
    @Deprecated
    @Override
    public void setYear(int i) {
        throw new IllegalArgumentException();
    }

    /**
     * Sets the time for this {@code Time} object to the supplied milliseconds
     * value.
     *
     * @param time
     *            A time value expressed as milliseconds since the <i>Epoch</i>.
     *            Negative values are milliseconds before the Epoch. The Epoch
     *            is January 1 1970, 00:00:00.000.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.424 -0500", hash_original_method = "5C30660C9B840F0068D4ACA53BC409AF", hash_generated_method = "2A73D86A0F2B0467E05B2671F95B43C2")
    
@Override
    public void setTime(long time) {
        super.setTime(time);
    }

    /**
     * Formats the {@code Time} as a String in JDBC escape format: {@code
     * hh:mm:ss}.
     *
     * @return A String representing the {@code Time} value in JDBC escape
     *         format: {@code HH:mm:ss}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.426 -0500", hash_original_method = "DF37E49816EA2C75935CB3795350B39F", hash_generated_method = "346AE4E29A4F7882008D887D1F8667F6")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(8);

        format(getHours(), 2, sb);
        sb.append(':');
        format(getMinutes(), 2, sb);
        sb.append(':');
        format(getSeconds(), 2, sb);

        return sb.toString();
    }

    /*
    * Private method to format the time
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:11.431 -0500", hash_original_method = "D5825B232A74B71A26A12413148003F7", hash_generated_method = "42C4F2A798161F88780A237C678B7BD2")
    
private void format(int date, int digits, StringBuilder sb) {
        String str = String.valueOf(date);
        if (digits - str.length() > 0) {
            sb.append(PADDING.substring(0, digits - str.length()));
        }
        sb.append(str);
    }
}

