package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import libcore.util.EmptyArray;





public class ChoiceFormat extends NumberFormat {

    /**
     * Returns the double value which is closest to the specified double but
     * larger.
     *
     * @param value
     *            a double value.
     * @return the next larger double value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.839 -0500", hash_original_method = "56A64FBC0E40A49398895D90D31F38E3", hash_generated_method = "779C3A233A5833DCABF81EFED0688FA6")
    
public static final double nextDouble(double value) {
        if (value == Double.POSITIVE_INFINITY) {
            return value;
        }
        long bits;
        // Handle -0.0
        if (value == 0) {
            bits = 0;
        } else {
            bits = Double.doubleToLongBits(value);
        }
        return Double.longBitsToDouble(value < 0 ? bits - 1 : bits + 1);
    }

    /**
     * Returns the double value which is closest to the specified double but
     * either larger or smaller as specified.
     *
     * @param value
     *            a double value.
     * @param increment
     *            {@code true} to get the next larger value, {@code false} to
     *            get the previous smaller value.
     * @return the next larger or smaller double value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.842 -0500", hash_original_method = "EB590363B29E0495CDDD74FB1BC0A86C", hash_generated_method = "27FD248C294DCBE13C71C3108FF8B5D5")
    
public static double nextDouble(double value, boolean increment) {
        return increment ? nextDouble(value) : previousDouble(value);
    }

    /**
     * Returns the double value which is closest to the specified double but
     * smaller.
     *
     * @param value
     *            a double value.
     * @return the next smaller double value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.847 -0500", hash_original_method = "8FBD80CA87526A3E9471194C397AFFA8", hash_generated_method = "AF58E0EE0F9F172D31B40E7C3E5F1D1B")
    
public static final double previousDouble(double value) {
        if (value == Double.NEGATIVE_INFINITY) {
            return value;
        }
        long bits;
        // Handle 0.0
        if (value == 0) {
            bits = 0x8000000000000000L;
        } else {
            bits = Double.doubleToLongBits(value);
        }
        return Double.longBitsToDouble(value <= 0 ? bits + 1 : bits - 1);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.801 -0500", hash_original_field = "3BF89E88CB72DE7A21FABBE3E2E23DE7", hash_generated_field = "74F3624CBC64496D38F62E5EDD514F89")


    private static final long serialVersionUID = 1795184449645032964L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.803 -0500", hash_original_field = "385C660A7438388F4AAC0F402F17E811", hash_generated_field = "ED2D30C35903F5702DFA6B6B053F7D87")


    private double[] choiceLimits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.806 -0500", hash_original_field = "CDF517F27851927B5C5ADD8084AE9F33", hash_generated_field = "05C2A4AC24967E0A070ABD8FDE0D9A95")


    private String[] choiceFormats;

    /**
     * Constructs a new {@code ChoiceFormat} with the specified double values
     * and associated strings. When calling
     * {@link #format(double, StringBuffer, FieldPosition) format} with a double
     * value {@code d}, then the element {@code i} in {@code formats} is
     * selected where {@code i} fulfills {@code limits[i] <= d < limits[i+1]}.
     * <p>
     * The length of the {@code limits} and {@code formats} arrays must be the
     * same.
     *
     * @param limits
     *            an array of doubles in ascending order. The lowest and highest
     *            possible values are negative and positive infinity.
     * @param formats
     *            the strings associated with the ranges defined through {@code
     *            limits}. The lower bound of the associated range is at the
     *            same index as the string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.809 -0500", hash_original_method = "6AA98ECEF055DFD6530181EFB704802A", hash_generated_method = "E02FD01E958226DF6093A985AE554776")
    
public ChoiceFormat(double[] limits, String[] formats) {
        setChoices(limits, formats);
    }

    /**
     * Constructs a new {@code ChoiceFormat} with the strings and limits parsed
     * from the specified pattern.
     *
     * @param template
     *            the pattern of strings and ranges.
     * @throws IllegalArgumentException
     *            if an error occurs while parsing the pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.811 -0500", hash_original_method = "7A22DFD5F0C8BF76D2134AD604327DD6", hash_generated_method = "4901BF97DF15B4A7B2C36C9BA69F9B95")
    
public ChoiceFormat(String template) {
        applyPattern(template);
    }

    /**
     * Parses the pattern to determine new strings and ranges for this
     * {@code ChoiceFormat}.
     *
     * @param template
     *            the pattern of strings and ranges.
     * @throws IllegalArgumentException
     *            if an error occurs while parsing the pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.815 -0500", hash_original_method = "61054E3E36618E298A5F058604E71A93", hash_generated_method = "B2F03782C34884D28DA28821550AA2A6")
    
public void applyPattern(String template) {
        double[] limits = new double[5];
        List<String> formats = new ArrayList<String>();
        int length = template.length(), limitCount = 0, index = 0;
        StringBuffer buffer = new StringBuffer();
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        ParsePosition position = new ParsePosition(0);
        while (true) {
            index = skipWhitespace(template, index);
            if (index >= length) {
                if (limitCount == limits.length) {
                    choiceLimits = limits;
                } else {
                    choiceLimits = new double[limitCount];
                    System.arraycopy(limits, 0, choiceLimits, 0, limitCount);
                }
                choiceFormats = new String[formats.size()];
                for (int i = 0; i < formats.size(); i++) {
                    choiceFormats[i] = formats.get(i);
                }
                return;
            }

            position.setIndex(index);
            Number value = format.parse(template, position);
            index = skipWhitespace(template, position.getIndex());
            if (position.getErrorIndex() != -1 || index >= length) {
                // Fix Harmony 540
                choiceLimits = EmptyArray.DOUBLE;
                choiceFormats = EmptyArray.STRING;
                return;
            }
            char ch = template.charAt(index++);
            if (limitCount == limits.length) {
                double[] newLimits = new double[limitCount * 2];
                System.arraycopy(limits, 0, newLimits, 0, limitCount);
                limits = newLimits;
            }
            double next;
            switch (ch) {
                case '#':
                case '\u2264':
                    next = value.doubleValue();
                    break;
                case '<':
                    next = nextDouble(value.doubleValue());
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            if (limitCount > 0 && next <= limits[limitCount - 1]) {
                throw new IllegalArgumentException();
            }
            buffer.setLength(0);
            position.setIndex(index);
            upTo(template, position, buffer, '|');
            index = position.getIndex();
            limits[limitCount++] = next;
            formats.add(buffer.toString());
        }
    }

    /**
     * Returns a new instance of {@code ChoiceFormat} with the same ranges and
     * strings as this {@code ChoiceFormat}.
     *
     * @return a shallow copy of this {@code ChoiceFormat}.
     *
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.818 -0500", hash_original_method = "0E78DE057CBD16D1EEA99DBEA20DA3A1", hash_generated_method = "23543D2B0160711A7FD831421C479CCA")
    
@Override
    public Object clone() {
        ChoiceFormat clone = (ChoiceFormat) super.clone();
        clone.choiceLimits = choiceLimits.clone();
        clone.choiceFormats = choiceFormats.clone();
        return clone;
    }

    /**
     * Compares the specified object with this {@code ChoiceFormat}. The object
     * must be an instance of {@code ChoiceFormat} and have the same limits and
     * formats to be equal to this instance.
     *
     * @param object
     *            the object to compare with this instance.
     * @return {@code true} if the specified object is equal to this instance;
     *         {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.821 -0500", hash_original_method = "F2D7C03023A3AAC9DFCE95AB2EC2A780", hash_generated_method = "F6C5ACF13148585DCE3804BB4BA541D9")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChoiceFormat)) {
            return false;
        }
        ChoiceFormat choice = (ChoiceFormat) object;
        return Arrays.equals(choiceLimits, choice.choiceLimits)
                && Arrays.equals(choiceFormats, choice.choiceFormats);
    }

    /**
     * Appends the string associated with the range in which the specified
     * double value fits to the specified string buffer.
     *
     * @param value
     *            the double to format.
     * @param buffer
     *            the target string buffer to append the formatted value to.
     * @param field
     *            a {@code FieldPosition} which is ignored.
     * @return the string buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.824 -0500", hash_original_method = "BC91D466505972771C623F66D301FB6D", hash_generated_method = "7C493D9A024EBA9C3DD4B1E2D6674691")
    
@Override
    public StringBuffer format(double value, StringBuffer buffer,
            FieldPosition field) {
        for (int i = choiceLimits.length - 1; i >= 0; i--) {
            if (choiceLimits[i] <= value) {
                return buffer.append(choiceFormats[i]);
            }
        }
        return choiceFormats.length == 0 ? buffer : buffer
                .append(choiceFormats[0]);
    }

    /**
     * Appends the string associated with the range in which the specified long
     * value fits to the specified string buffer.
     *
     * @param value
     *            the long to format.
     * @param buffer
     *            the target string buffer to append the formatted value to.
     * @param field
     *            a {@code FieldPosition} which is ignored.
     * @return the string buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.827 -0500", hash_original_method = "F9B960B049B919C822FEECA2E3BD7537", hash_generated_method = "0F244610EE4E1DE2BBEE8C7AC9256CCA")
    
@Override
    public StringBuffer format(long value, StringBuffer buffer,
            FieldPosition field) {
        return format((double) value, buffer, field);
    }

    /**
     * Returns the strings associated with the ranges of this {@code
     * ChoiceFormat}.
     *
     * @return an array of format strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.829 -0500", hash_original_method = "989D9CABCA800EE4DFA0CFCD3DE77FA9", hash_generated_method = "5957C9D2934F4D28458980FA43F21FBD")
    
public Object[] getFormats() {
        return choiceFormats;
    }

    /**
     * Returns the limits of this {@code ChoiceFormat}.
     *
     * @return the array of doubles which make up the limits of this {@code
     *         ChoiceFormat}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.832 -0500", hash_original_method = "290809530CC76A10C33738C53A5176B9", hash_generated_method = "4462B4ADD3CBA8B48052A73F3EA65136")
    
public double[] getLimits() {
        return choiceLimits;
    }

    /**
     * Returns an integer hash code for the receiver. Objects which are equal
     * return the same value for this method.
     *
     * @return the receiver's hash.
     *
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.836 -0500", hash_original_method = "9AF9F658465E6920280B1655C8022A86", hash_generated_method = "2B6A38C70D9EB0CA23B980DC8F6B3D48")
    
@Override
    public int hashCode() {
        int hashCode = 0;
        for (int i = 0; i < choiceLimits.length; i++) {
            long v = Double.doubleToLongBits(choiceLimits[i]);
            hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
        }
        return hashCode;
    }

    /**
     * Parses a double from the specified string starting at the index specified
     * by {@code position}. The string is compared to the strings of this
     * {@code ChoiceFormat} and if a match occurs then the lower bound of the
     * corresponding range in the limits array is returned. If the string is
     * successfully parsed then the index of the {@code ParsePosition} passed to
     * this method is updated to the index following the parsed text.
     * <p>
     * If one of the format strings of this {@code ChoiceFormat} instance is
     * found in {@code string} starting at {@code position.getIndex()} then
     * <ul>
     * <li>the index in {@code position} is set to the index following the
     * parsed text;
     * <li>the {@link java.lang.Double Double} corresponding to the format
     * string is returned.</li>
     * </ul>
     * <p>
     * If none of the format strings is found in {@code string} then
     * <ul>
     * <li>the error index in {@code position} is set to the current index in
     * {@code position};</li>
     * <li> {@link java.lang.Double#NaN Double.NaN} is returned.
     * </ul>
     * @param string
     *            the source string to parse.
     * @param position
     *            input/output parameter, specifies the start index in {@code
     *            string} from where to start parsing. See the <em>Returns</em>
     *            section for a description of the output values.
     * @return a Double resulting from the parse, or Double.NaN if there is an
     *         error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.845 -0500", hash_original_method = "609F300632C6A9AB79113AF961C366BC", hash_generated_method = "6E603FA1F2D9295D5AD0EFE6E369A8C2")
    
@Override
    public Number parse(String string, ParsePosition position) {
        int offset = position.getIndex();
        for (int i = 0; i < choiceFormats.length; i++) {
            if (string.startsWith(choiceFormats[i], offset)) {
                position.setIndex(offset + choiceFormats[i].length());
                return new Double(choiceLimits[i]);
            }
        }
        position.setErrorIndex(offset);
        return new Double(Double.NaN);
    }

    /**
     * Sets the double values and associated strings of this ChoiceFormat. When
     * calling {@link #format(double, StringBuffer, FieldPosition) format} with
     * a double value {@code d}, then the element {@code i} in {@code formats}
     * is selected where {@code i} fulfills
     * {@code limits[i] <= d < limits[i+1]}.
     * <p>
     * The length of the {@code limits} and {@code formats} arrays must be the
     * same.
     *
     * @param limits
     *            an array of doubles in ascending order. The lowest and highest
     *            possible values are negative and positive infinity.
     * @param formats
     *            the strings associated with the ranges defined through {@code
     *            limits}. The lower bound of the associated range is at the
     *            same index as the string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.850 -0500", hash_original_method = "A68DB2E05654867D5DABBF703FA90F00", hash_generated_method = "48FD31804241588464A37BDF825EAE7E")
    
public void setChoices(double[] limits, String[] formats) {
        if (limits.length != formats.length) {
            throw new IllegalArgumentException();
        }
        choiceLimits = limits;
        choiceFormats = formats;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.852 -0500", hash_original_method = "55E8B28E1CF4E8D52478B124E3FA683B", hash_generated_method = "3C2A0E91FFDA79693203BA4400F4E944")
    
private int skipWhitespace(String string, int index) {
        int length = string.length();
        while (index < length && Character.isWhitespace(string.charAt(index))) {
            index++;
        }
        return index;
    }

    /**
     * Returns the pattern of this {@code ChoiceFormat} which specifies the
     * ranges and their associated strings.
     *
     * @return the pattern.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:05.855 -0500", hash_original_method = "C892C3517E889BA7A99732103703F353", hash_generated_method = "A16188C800987A064F2D3C803BCB551C")
    
public String toPattern() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < choiceLimits.length; i++) {
            if (i != 0) {
                buffer.append('|');
            }
            String previous = String.valueOf(previousDouble(choiceLimits[i]));
            String limit = String.valueOf(choiceLimits[i]);
            if (previous.length() < limit.length()) {
                buffer.append(previous);
                buffer.append('<');
            } else {
                buffer.append(limit);
                buffer.append('#');
            }
            boolean quote = (choiceFormats[i].indexOf('|') != -1);
            if (quote) {
                buffer.append('\'');
            }
            buffer.append(choiceFormats[i]);
            if (quote) {
                buffer.append('\'');
            }
        }
        return buffer.toString();
    }
}

