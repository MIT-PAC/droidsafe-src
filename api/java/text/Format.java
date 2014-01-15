package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public abstract class Format implements Serializable, Cloneable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.562 -0500", hash_original_method = "342F58D58D7CDE61587D20CC55F1BF65", hash_generated_method = "E40E3DF50A129A615CEDF26F12F19796")
    
static boolean upTo(String string, ParsePosition position,
            StringBuffer buffer, char stop) {
        int index = position.getIndex(), length = string.length();
        boolean lastQuote = false, quote = false;
        while (index < length) {
            char ch = string.charAt(index++);
            if (ch == '\'') {
                if (lastQuote) {
                    buffer.append('\'');
                }
                quote = !quote;
                lastQuote = true;
            } else if (ch == stop && !quote) {
                position.setIndex(index);
                return true;
            } else {
                lastQuote = false;
                buffer.append(ch);
            }
        }
        position.setIndex(index);
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.565 -0500", hash_original_method = "E4DAD8C2181AF3C8695050B31E68F195", hash_generated_method = "EC7B532152BFC21D3BEC28BD5621AAB5")
    
static boolean upToWithQuotes(String string, ParsePosition position,
            StringBuffer buffer, char stop, char start) {
        int index = position.getIndex(), length = string.length(), count = 1;
        boolean quote = false;
        while (index < length) {
            char ch = string.charAt(index++);
            if (ch == '\'') {
                quote = !quote;
            }
            if (!quote) {
                if (ch == stop) {
                    count--;
                }
                if (count == 0) {
                    position.setIndex(index);
                    return true;
                }
                if (ch == start) {
                    count++;
                }
            }
            buffer.append(ch);
        }
        throw new IllegalArgumentException("Unmatched braces in the pattern");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.541 -0500", hash_original_field = "0DB40A090DF073D3D23310F63EA8393F", hash_generated_field = "F20B0022FF8D3E84304897148427AD29")

    private static final long serialVersionUID = -299282585814624189L;

    /**
     * Used by subclasses. This was public in Java 5.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.544 -0500", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "EFA7B769FE1AEB1EF8661CFADF6D58B2")
    
protected Format() {
    }

    /**
     * Returns a copy of this {@code Format} instance.
     *
     * @return a shallow copy of this format.
     *
     * @see java.lang.Cloneable
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.547 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    
@Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Formats the specified object using the rules of this format.
     *
     * @param object
     *            the object to format.
     * @return the formatted string.
     * @throws IllegalArgumentException
     *         if the object cannot be formatted by this format.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.549 -0500", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "D6FF871E879357E151D2BDB709C4FF98")
    
public final String format(Object object) {
        return format(object, new StringBuffer(), new FieldPosition(0))
                .toString();
    }

    /**
     * Appends the specified object to the specified string buffer using the
     * rules of this format.
     * <p>
     * {@code field} is an input/output parameter. If its {@code field}
     * member contains an enum value specifying a field on input, then its
     * {@code beginIndex} and {@code endIndex} members will be updated with the
     * text offset of the first occurrence of this field in the formatted text.
     *
     * @param object
     *            the object to format.
     * @param buffer
     *            the string buffer where the formatted string is appended to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     * @throws IllegalArgumentException
     *            if the object cannot be formatted by this format.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.553 -0500", hash_original_method = "51EFA60E0E20FDE37B9F085D9B58A623", hash_generated_method = "8613FF54F89F6D1F30A04F56DAF4DDD3")
    
public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    /**
     * Formats the specified object using the rules of this format and returns
     * an {@code AttributedCharacterIterator} with the formatted string and no
     * attributes.
     * <p>
     * Subclasses should return an {@code AttributedCharacterIterator} with the
     * appropriate attributes.
     *
     * @param object
     *            the object to format.
     * @return an {@code AttributedCharacterIterator} with the formatted object
     *         and attributes.
     * @throws IllegalArgumentException
     *            if the object cannot be formatted by this format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.555 -0500", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "EE414D44458FA6E5766F6B76051CCB77")
    
public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        return new AttributedString(format(object)).getIterator();
    }

    /**
     * Parses the specified string using the rules of this format.
     *
     * @param string
     *            the string to parse.
     * @return the object resulting from the parse.
     * @throws ParseException
     *            if an error occurs during parsing.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.557 -0500", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "4599B9C84ED9B8144980A818CAE01834")
    
public Object parseObject(String string) throws ParseException {
        ParsePosition position = new ParsePosition(0);
        Object result = parseObject(string, position);
        if (position.getIndex() == 0) {
            throw new ParseException("Parse failure", position.getErrorIndex());
        }
        return result;
    }
    
    public static class Field extends AttributedCharacterIterator.Attribute {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.568 -0500", hash_original_field = "7B33E614D84C5CC7F14E8DA120EFE29B", hash_generated_field = "DE61A40CF1E88A2D4F1C7CBD694BE984")

        private static final long serialVersionUID = 276966692217360283L;

        /**
         * Constructs a new instance of {@code Field} with the given field name.
         *
         * @param fieldName
         *            the field name.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.572 -0500", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "8E9E2E9A1129AAE1C0A40E201C67690D")
        
protected Field(String fieldName) {
            super(fieldName);
        }
    }

    /**
     * Parses the specified string starting at the index specified by
     * {@code position}. If the string is successfully parsed then the index of
     * the {@code ParsePosition} is updated to the index following the parsed
     * text. On error, the index is unchanged and the error index of
     * {@code ParsePosition} is set to the index where the error occurred.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in
     *            {@code string} from where to start parsing. If parsing is
     *            successful, it is updated with the index following the parsed
     *            text; on error, the index is unchanged and the error index is
     *            set to the index where the error occurred.
     * @return the object resulting from the parse or {@code null} if there is
     *         an error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:04.560 -0500", hash_original_method = "B30F2D29CF174E11D687387FB98BED90", hash_generated_method = "2D7138DA8CBCBAF9EF63AF3FC800E113")
    
public abstract Object parseObject(String string, ParsePosition position);
}

