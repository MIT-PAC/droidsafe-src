package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import libcore.util.EmptyArray;

public class MessageFormat extends Format {

    /**
     * Formats the supplied objects using the specified message format pattern.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return the formatted result.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.056 -0500", hash_original_method = "028A0A610E31197643C52E1AA7424EFD", hash_generated_method = "1A432DCE8A1D9FDC87F89E0825D717EC")
    
public static String format(String format, Object... args) {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    args[i] = "null";
                }
            }
        }
        return new MessageFormat(format).format(args);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.994 -0500", hash_original_field = "85F1E124B97D00A90D3E87E898848851", hash_generated_field = "DDAF9963C56DC8D3CC72243FA6D60F41")

    private static final long serialVersionUID = 6479157306784022952L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.146 -0500", hash_original_field = "C160E54DEE9507CFBF7E5C8074ABADA4", hash_generated_field = "F3984ED43D46FE3C3FFDBA430A29142D")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("argumentNumbers", int[].class),
        new ObjectStreamField("formats", Format[].class),
        new ObjectStreamField("locale", Locale.class),
        new ObjectStreamField("maxOffset", int.class),
        new ObjectStreamField("offsets", int[].class),
        new ObjectStreamField("pattern", String.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.996 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.999 -0500", hash_original_field = "7EC9F198E5C9DB627479076AA671E13C", hash_generated_field = "44BD3039B18FC631AF3469BBAABEF8A6")

    transient private String[] strings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.001 -0500", hash_original_field = "464C7E4860BE692CF9902BB4BA8A342C", hash_generated_field = "0CC8F912A4CE816F33718A9E926CC5E3")

    private int[] argumentNumbers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.004 -0500", hash_original_field = "487548212267DE48557B9CCE14AB5577", hash_generated_field = "4840DFEFCC78103675C456B661F97552")

    private Format[] formats;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.006 -0500", hash_original_field = "B77A978D018717DE754B211259BC526D", hash_generated_field = "8E5941FA03E4EAD10C76316C2B10EB9E")

    private int maxOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.008 -0500", hash_original_field = "A02BC4DC53512ED88E55A9A6CFBF2C5B", hash_generated_field = "D0A8CB4E81B16C7EDB6C78624EE723CF")

    transient private int maxArgumentIndex;

    /**
     * Constructs a new {@code MessageFormat} using the specified pattern and {@code locale}.
     *
     * @param template
     *            the pattern.
     * @param locale
     *            the locale.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.011 -0500", hash_original_method = "DF99A7D88BE30484426F461C5ED2222D", hash_generated_method = "5C72D6FD9844B81FF2D91678F28F001B")
    
public MessageFormat(String template, Locale locale) {
        this.locale = locale;
        applyPattern(template);
    }

    /**
     * Constructs a new {@code MessageFormat} using the specified pattern and
     * the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param template
     *            the pattern.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.013 -0500", hash_original_method = "BAA918AD1B6BB7758E580E5A4864BDBA", hash_generated_method = "4E40857C718EFBC3ADDFDFD00CC1B9D9")
    
public MessageFormat(String template) {
        this(template, Locale.getDefault());
    }

    /**
     * Changes this {@code MessageFormat} to use the specified pattern.
     *
     * @param template
     *            the new pattern.
     * @throws IllegalArgumentException
     *            if the pattern cannot be parsed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.018 -0500", hash_original_method = "20F481C3B4FB7D239D889AD1AE3136D7", hash_generated_method = "BD92F01FABE93B475B84627EAB102842")
    
public void applyPattern(String template) {
        int length = template.length();
        StringBuffer buffer = new StringBuffer();
        ParsePosition position = new ParsePosition(0);
        ArrayList<String> localStrings = new ArrayList<String>();
        int argCount = 0;
        int[] args = new int[10];
        int maxArg = -1;
        ArrayList<Format> localFormats = new ArrayList<Format>();
        while (position.getIndex() < length) {
            if (Format.upTo(template, position, buffer, '{')) {
                int arg = 0;
                int offset = position.getIndex();
                if (offset >= length) {
                    throw new IllegalArgumentException("Invalid argument number");
                }
                // Get argument number
                char ch;
                while ((ch = template.charAt(offset++)) != '}' && ch != ',') {
                    if (ch < '0' && ch > '9') {
                        throw new IllegalArgumentException("Invalid argument number");
                    }

                    arg = arg * 10 + (ch - '0');

                    if (arg < 0 || offset >= length) {
                        throw new IllegalArgumentException("Invalid argument number");
                    }
                }
                offset--;
                position.setIndex(offset);
                localFormats.add(parseVariable(template, position));
                if (argCount >= args.length) {
                    int[] newArgs = new int[args.length * 2];
                    System.arraycopy(args, 0, newArgs, 0, args.length);
                    args = newArgs;
                }
                args[argCount++] = arg;
                if (arg > maxArg) {
                    maxArg = arg;
                }
            }
            localStrings.add(buffer.toString());
            buffer.setLength(0);
        }
        this.strings = localStrings.toArray(new String[localStrings.size()]);
        argumentNumbers = args;
        this.formats = localFormats.toArray(new Format[argCount]);
        maxOffset = argCount - 1;
        maxArgumentIndex = maxArg;
    }

    /**
     * Returns a new instance of {@code MessageFormat} with the same pattern and
     * formats as this {@code MessageFormat}.
     *
     * @return a shallow copy of this {@code MessageFormat}.
     * @see java.lang.Cloneable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.021 -0500", hash_original_method = "B53A9961D24B646CE17498A2E8FD8A6F", hash_generated_method = "BE9C143266B7735695443EF07FD6A8D8")
    
@Override
    public Object clone() {
        MessageFormat clone = (MessageFormat) super.clone();
        Format[] array = new Format[formats.length];
        for (int i = formats.length; --i >= 0;) {
            if (formats[i] != null) {
                array[i] = (Format) formats[i].clone();
            }
        }
        clone.formats = array;
        return clone;
    }

    /**
     * Compares the specified object to this {@code MessageFormat} and indicates
     * if they are equal. In order to be equal, {@code object} must be an
     * instance of {@code MessageFormat} and have the same pattern.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this
     *         {@code MessageFormat}; {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.024 -0500", hash_original_method = "2E70B47400B10858E99F75E16A06D539", hash_generated_method = "72FD03440AA98A2EBBBBE6A2972227C4")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof MessageFormat)) {
            return false;
        }
        MessageFormat format = (MessageFormat) object;
        if (maxOffset != format.maxOffset) {
            return false;
        }
        // Must use a loop since the lengths may be different due
        // to serialization cross-loading
        for (int i = 0; i <= maxOffset; i++) {
            if (argumentNumbers[i] != format.argumentNumbers[i]) {
                return false;
            }
        }
        return locale.equals(format.locale)
                && Arrays.equals(strings, format.strings)
                && Arrays.equals(formats, format.formats);
    }

    /**
     * Formats the specified object using the rules of this message format and
     * returns an {@code AttributedCharacterIterator} with the formatted message and
     * attributes. The {@code AttributedCharacterIterator} returned also includes the
     * attributes from the formats of this message format.
     *
     * @param object
     *            the object to format.
     * @return an {@code AttributedCharacterIterator} with the formatted message and
     *         attributes.
     * @throws IllegalArgumentException
     *            if the arguments in the object array cannot be formatted
     *            by this message format.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.027 -0500", hash_original_method = "2F36A5BCF5EDBC18FDC7136A6298BFC9", hash_generated_method = "CDFF5F0C66FBFAF4CD44AA0CF0CCCC67")
    
@Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }

        StringBuffer buffer = new StringBuffer();
        ArrayList<FieldContainer> fields = new ArrayList<FieldContainer>();

        // format the message, and find fields
        formatImpl((Object[]) object, buffer, new FieldPosition(0), fields);

        // create an AttributedString with the formatted buffer
        AttributedString as = new AttributedString(buffer.toString());

        // add MessageFormat field attributes and values to the AttributedString
        for (FieldContainer fc : fields) {
            as.addAttribute(fc.attribute, fc.value, fc.start, fc.end);
        }

        // return the CharacterIterator from AttributedString
        return as.getIterator();
    }

    /**
     * Converts the specified objects into a string which it appends to the
     * specified string buffer using the pattern of this message format.
     * <p>
     * If the {@code field} member of the specified {@code FieldPosition} is
     * {@code MessageFormat.Field.ARGUMENT}, then the begin and end index of
     * this field position is set to the location of the first occurrence of a
     * message format argument. Otherwise, the {@code FieldPosition} is ignored.
     *
     * @param objects
     *            the array of objects to format.
     * @param buffer
     *            the target string buffer to append the formatted message to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.029 -0500", hash_original_method = "A9B03AC07F14FDC18F9B212B66591284", hash_generated_method = "C954A19EC965760787C56DC99EEC2864")
    
public final StringBuffer format(Object[] objects, StringBuffer buffer,
            FieldPosition field) {
        return formatImpl(objects, buffer, field, null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.033 -0500", hash_original_method = "CB09F1AB0972A7396E3B2DB81FB1793E", hash_generated_method = "7897DDC60620BE71C92184A47C283A6E")
    
private StringBuffer formatImpl(Object[] objects, StringBuffer buffer,
            FieldPosition position, List<FieldContainer> fields) {
        FieldPosition passedField = new FieldPosition(0);
        for (int i = 0; i <= maxOffset; i++) {
            buffer.append(strings[i]);
            int begin = buffer.length();
            Object arg;
            if (objects != null && argumentNumbers[i] < objects.length) {
                arg = objects[argumentNumbers[i]];
            } else {
                buffer.append('{');
                buffer.append(argumentNumbers[i]);
                buffer.append('}');
                handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                continue;
            }
            Format format = formats[i];
            if (format == null || arg == null) {
                if (arg instanceof Number) {
                    format = NumberFormat.getInstance();
                } else if (arg instanceof Date) {
                    format = DateFormat.getInstance();
                } else {
                    buffer.append(arg);
                    handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                    continue;
                }
            }
            if (format instanceof ChoiceFormat) {
                String result = format.format(arg);
                MessageFormat mf = new MessageFormat(result);
                mf.setLocale(locale);
                mf.format(objects, buffer, passedField);
                handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                handleFormat(format, arg, begin, fields);
            } else {
                format.format(arg, buffer, passedField);
                handleArgumentField(begin, buffer.length(), argumentNumbers[i], position, fields);
                handleFormat(format, arg, begin, fields);
            }
        }
        if (maxOffset + 1 < strings.length) {
            buffer.append(strings[maxOffset + 1]);
        }
        return buffer;
    }

    /**
     * Adds a new FieldContainer with MessageFormat.Field.ARGUMENT field,
     * argIndex, begin and end index to the fields list, or sets the
     * position's begin and end index if it has MessageFormat.Field.ARGUMENT as
     * its field attribute.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.035 -0500", hash_original_method = "C43D87ABB966C2154325453E86772F9C", hash_generated_method = "92BB0A2A02A372271A864A9F99200768")
    
private void handleArgumentField(int begin, int end, int argIndex,
            FieldPosition position, List<FieldContainer> fields) {
        if (fields != null) {
            fields.add(new FieldContainer(begin, end, Field.ARGUMENT, Integer.valueOf(argIndex)));
        } else {
            if (position != null
                    && position.getFieldAttribute() == Field.ARGUMENT
                    && position.getEndIndex() == 0) {
                position.setBeginIndex(begin);
                position.setEndIndex(end);
            }
        }
    }

    /**
     * If fields list is not null, find and add the fields of this format to
     * the fields list by iterating through its AttributedCharacterIterator
     *
     * @param format
     *            the format to find fields for
     * @param arg
     *            object to format
     * @param begin
     *            the index where the string this format has formatted begins
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.051 -0500", hash_original_method = "DE679CD49EEE558B2CA2B7C9C9DE5810", hash_generated_method = "F2295C7377E10FA5920FF277B65858FC")
    
private void handleFormat(Format format, Object arg, int begin, List<FieldContainer> fields) {
        if (fields == null) {
            return;
        }
        AttributedCharacterIterator iterator = format.formatToCharacterIterator(arg);
        while (iterator.getIndex() != iterator.getEndIndex()) {
            int start = iterator.getRunStart();
            int end = iterator.getRunLimit();
            Iterator<?> it = iterator.getAttributes().keySet().iterator();
            while (it.hasNext()) {
                AttributedCharacterIterator.Attribute attribute =
                        (AttributedCharacterIterator.Attribute) it.next();
                Object value = iterator.getAttribute(attribute);
                fields.add(new FieldContainer(begin + start, begin + end, attribute, value));
            }
            iterator.setIndex(end);
        }
    }

    /**
     * Converts the specified objects into a string which it appends to the
     * specified string buffer using the pattern of this message format.
     * <p>
     * If the {@code field} member of the specified {@code FieldPosition} is
     * {@code MessageFormat.Field.ARGUMENT}, then the begin and end index of
     * this field position is set to the location of the first occurrence of a
     * message format argument. Otherwise, the {@code FieldPosition} is ignored.
     * <p>
     * Calling this method is equivalent to calling
     * <blockquote>
     *
     * <pre>
     * format((Object[])object, buffer, field)
     * </pre>
     *
     * </blockquote>
     *
     * @param object
     *            the object to format, must be an array of {@code Object}.
     * @param buffer
     *            the target string buffer to append the formatted message to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     * @throws ClassCastException
     *             if {@code object} is not an array of {@code Object}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.053 -0500", hash_original_method = "86D79FEBC73D19AFFF1CE089D06D0A2E", hash_generated_method = "5177FD74747F715BDF1462BB61283E0F")
    
@Override
    public final StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field) {
        return format((Object[]) object, buffer, field);
    }

    /**
     * Returns the {@code Format} instances used by this message format.
     *
     * @return an array of {@code Format} instances.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.058 -0500", hash_original_method = "7EB79515AF02A4588C0D82DEFC2945FA", hash_generated_method = "7EFEE9D91FE14B594D203FA10FB1BCC1")
    
public Format[] getFormats() {
        return formats.clone();
    }

    /**
     * Returns the formats used for each argument index. If an argument is
     * placed more than once in the pattern string, then this returns the format
     * of the last one.
     *
     * @return an array of formats, ordered by argument index.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.061 -0500", hash_original_method = "6305A24530517BEB5A0FB94704F4E840", hash_generated_method = "7256C96823D4554EB8A201ECE2978ADC")
    
public Format[] getFormatsByArgumentIndex() {
        Format[] answer = new Format[maxArgumentIndex + 1];
        for (int i = 0; i < maxOffset + 1; i++) {
            answer[argumentNumbers[i]] = formats[i];
        }
        return answer;
    }

    /**
     * Sets the format used for the argument at index {@code argIndex} to
     * {@code format}.
     *
     * @param argIndex
     *            the index of the format to set.
     * @param format
     *            the format that will be set at index {@code argIndex}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.064 -0500", hash_original_method = "A090F158D8C76258E8307612B54D8E7F", hash_generated_method = "BFFBE18BA64F9C4CA5AC6433624C3006")
    
public void setFormatByArgumentIndex(int argIndex, Format format) {
        for (int i = 0; i < maxOffset + 1; i++) {
            if (argumentNumbers[i] == argIndex) {
                formats[i] = format;
            }
        }
    }

    /**
     * Sets the formats used for each argument. The {@code formats} array
     * elements should be in the order of the argument indices.
     *
     * @param formats
     *            the formats in an array.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.076 -0500", hash_original_method = "A9324DA1CAF88845D05BF77827620ABB", hash_generated_method = "FA410B89D84CEDA94F1AB0CCDADC3C2F")
    
public void setFormatsByArgumentIndex(Format[] formats) {
        for (int j = 0; j < formats.length; j++) {
            for (int i = 0; i < maxOffset + 1; i++) {
                if (argumentNumbers[i] == j) {
                    this.formats[i] = formats[j];
                }
            }
        }
    }

    /**
     * Returns the locale used when creating formats.
     *
     * @return the locale used to create formats.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.080 -0500", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "424B5570E26DE121275BC9C58AD53C4D")
    
public Locale getLocale() {
        return locale;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.085 -0500", hash_original_method = "C3648461AA348ABE73C14E89998C9B55", hash_generated_method = "42842E44531261FB5273C00ABBA16DEA")
    
@Override
    public int hashCode() {
        int hashCode = 0;
        for (int i = 0; i <= maxOffset; i++) {
            hashCode += argumentNumbers[i] + strings[i].hashCode();
            if (formats[i] != null) {
                hashCode += formats[i].hashCode();
            }
        }
        if (maxOffset + 1 < strings.length) {
            hashCode += strings[maxOffset + 1].hashCode();
        }
        if (locale != null) {
            return hashCode + locale.hashCode();
        }
        return hashCode;
    }

    /**
     * Parses the message arguments from the specified string using the rules of
     * this message format.
     *
     * @param string
     *            the string to parse.
     * @return the array of {@code Object} arguments resulting from the parse.
     * @throws ParseException
     *            if an error occurs during parsing.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.091 -0500", hash_original_method = "EC21A725ACD65B59B44C587C03791CB0", hash_generated_method = "1E6275FC145A23B549543A655868D2B3")
    
public Object[] parse(String string) throws ParseException {
        ParsePosition position = new ParsePosition(0);
        Object[] result = parse(string, position);
        if (position.getIndex() == 0) {
            throw new ParseException("Parse failure", position.getErrorIndex());
        }
        return result;
    }

    /**
     * Parses the message argument from the specified string starting at the
     * index specified by {@code position}. If the string is successfully
     * parsed then the index of the {@code ParsePosition} is updated to the
     * index following the parsed text. On error, the index is unchanged and the
     * error index of {@code ParsePosition} is set to the index where the error
     * occurred.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in
     *            {@code string} from where to start parsing. If parsing is
     *            successful, it is updated with the index following the parsed
     *            text; on error, the index is unchanged and the error index is
     *            set to the index where the error occurred.
     * @return the array of objects resulting from the parse, or {@code null} if
     *         there is an error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.097 -0500", hash_original_method = "D7228DDFC0E7ACF8FDCF2D792E0983E6", hash_generated_method = "A2B9D3FBF818C01E8D5B2503E2B4BBFD")
    
public Object[] parse(String string, ParsePosition position) {
        if (string == null) {
            return EmptyArray.OBJECT;
        }
        ParsePosition internalPos = new ParsePosition(0);
        int offset = position.getIndex();
        Object[] result = new Object[maxArgumentIndex + 1];
        for (int i = 0; i <= maxOffset; i++) {
            String sub = strings[i];
            if (!string.startsWith(sub, offset)) {
                position.setErrorIndex(offset);
                return null;
            }
            offset += sub.length();
            Object parse;
            Format format = formats[i];
            if (format == null) {
                if (i + 1 < strings.length) {
                    int next = string.indexOf(strings[i + 1], offset);
                    if (next == -1) {
                        position.setErrorIndex(offset);
                        return null;
                    }
                    parse = string.substring(offset, next);
                    offset = next;
                } else {
                    parse = string.substring(offset);
                    offset = string.length();
                }
            } else {
                internalPos.setIndex(offset);
                parse = format.parseObject(string, internalPos);
                if (internalPos.getErrorIndex() != -1) {
                    position.setErrorIndex(offset);
                    return null;
                }
                offset = internalPos.getIndex();
            }
            result[argumentNumbers[i]] = parse;
        }
        if (maxOffset + 1 < strings.length) {
            String sub = strings[maxOffset + 1];
            if (!string.startsWith(sub, offset)) {
                position.setErrorIndex(offset);
                return null;
            }
            offset += sub.length();
        }
        position.setIndex(offset);
        return result;
    }

    /**
     * Parses the message argument from the specified string starting at the
     * index specified by {@code position}. If the string is successfully
     * parsed then the index of the {@code ParsePosition} is updated to the
     * index following the parsed text. On error, the index is unchanged and the
     * error index of {@code ParsePosition} is set to the index where the error
     * occurred.
     *
     * @param string
     *            the string to parse.
     * @param position
     *            input/output parameter, specifies the start index in
     *            {@code string} from where to start parsing. If parsing is
     *            successful, it is updated with the index following the parsed
     *            text; on error, the index is unchanged and the error index is
     *            set to the index where the error occurred.
     * @return the array of objects resulting from the parse, or {@code null} if
     *         there is an error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.101 -0500", hash_original_method = "C9AA8969DE1792F4979FB5B1F65B9849", hash_generated_method = "63216C42E69B7A23B760025E3A8B8D9B")
    
@Override
    public Object parseObject(String string, ParsePosition position) {
        return parse(string, position);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.107 -0500", hash_original_method = "F0EBB1D410262325E53A6EB4F51F6A54", hash_generated_method = "2DE98B380D6132E3EB063D2F69DC49F7")
    
private int match(String string, ParsePosition position, boolean last,
            String[] tokens) {
        int length = string.length(), offset = position.getIndex(), token = -1;
        while (offset < length && Character.isWhitespace(string.charAt(offset))) {
            offset++;
        }
        for (int i = tokens.length; --i >= 0;) {
            if (string.regionMatches(true, offset, tokens[i], 0, tokens[i]
                    .length())) {
                token = i;
                break;
            }
        }
        if (token == -1) {
            return -1;
        }
        offset += tokens[token].length();
        while (offset < length && Character.isWhitespace(string.charAt(offset))) {
            offset++;
        }
        char ch;
        if (offset < length
                && ((ch = string.charAt(offset)) == '}' || (!last && ch == ','))) {
            position.setIndex(offset + 1);
            return token;
        }
        return -1;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.113 -0500", hash_original_method = "C959BA9FF5D67B6099707C942E630082", hash_generated_method = "AB480404738039F21DDCBF37C62E644B")
    
private Format parseVariable(String string, ParsePosition position) {
        int length = string.length(), offset = position.getIndex();
        char ch;
        if (offset >= length || ((ch = string.charAt(offset++)) != '}' && ch != ',')) {
            throw new IllegalArgumentException("Missing element format");
        }
        position.setIndex(offset);
        if (ch == '}') {
            return null;
        }
        int type = match(string, position, false,
                new String[] { "time", "date", "number", "choice" });
        if (type == -1) {
            throw new IllegalArgumentException("Unknown element format");
        }
        StringBuffer buffer = new StringBuffer();
        ch = string.charAt(position.getIndex() - 1);
        switch (type) {
            case 0: // time
            case 1: // date
                if (ch == '}') {
                    return type == 1 ? DateFormat.getDateInstance(
                            DateFormat.DEFAULT, locale) : DateFormat
                            .getTimeInstance(DateFormat.DEFAULT, locale);
                }
                int dateStyle = match(string, position, true,
                        new String[] { "full", "long", "medium", "short" });
                if (dateStyle == -1) {
                    Format.upToWithQuotes(string, position, buffer, '}', '{');
                    return new SimpleDateFormat(buffer.toString(), locale);
                }
                switch (dateStyle) {
                    case 0:
                        dateStyle = DateFormat.FULL;
                        break;
                    case 1:
                        dateStyle = DateFormat.LONG;
                        break;
                    case 2:
                        dateStyle = DateFormat.MEDIUM;
                        break;
                    case 3:
                        dateStyle = DateFormat.SHORT;
                        break;
                }
                return type == 1 ? DateFormat
                        .getDateInstance(dateStyle, locale) : DateFormat
                        .getTimeInstance(dateStyle, locale);
            case 2: // number
                if (ch == '}') {
                    return NumberFormat.getInstance(locale);
                }
                int numberStyle = match(string, position, true,
                        new String[] { "currency", "percent", "integer" });
                if (numberStyle == -1) {
                    Format.upToWithQuotes(string, position, buffer, '}', '{');
                    return new DecimalFormat(buffer.toString(),
                            new DecimalFormatSymbols(locale));
                }
                switch (numberStyle) {
                    case 0: // currency
                        return NumberFormat.getCurrencyInstance(locale);
                    case 1: // percent
                        return NumberFormat.getPercentInstance(locale);
                }
                return NumberFormat.getIntegerInstance(locale);
        }
        // choice
        try {
            Format.upToWithQuotes(string, position, buffer, '}', '{');
        } catch (IllegalArgumentException e) {
            // ignored
        }
        return new ChoiceFormat(buffer.toString());
    }

    /**
     * Sets the specified format used by this message format.
     *
     * @param offset
     *            the index of the format to change.
     * @param format
     *            the {@code Format} that replaces the old format.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.118 -0500", hash_original_method = "40ED9258145F8A9FA53AE23CC8BC5498", hash_generated_method = "D72E7BA9462DF346425955850537E9C6")
    
public void setFormat(int offset, Format format) {
        formats[offset] = format;
    }

    /**
     * Sets the formats used by this message format.
     *
     * @param formats
     *            an array of {@code Format}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.123 -0500", hash_original_method = "F9E7D69C4CD5EB0783A6761389D5E01C", hash_generated_method = "FD117B80C69E8A4F820A18E6F08B47EA")
    
public void setFormats(Format[] formats) {
        int min = this.formats.length;
        if (formats.length < min) {
            min = formats.length;
        }
        for (int i = 0; i < min; i++) {
            this.formats[i] = formats[i];
        }
    }

    /**
     * Sets the locale to use when creating {@code Format} instances. Changing
     * the locale may change the behavior of {@code applyPattern},
     * {@code toPattern}, {@code format} and {@code formatToCharacterIterator}.
     *
     * @param locale
     *            the new locale.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.128 -0500", hash_original_method = "2EE5DAE8254A09BA3EE14891BDB8B487", hash_generated_method = "11A2FAE11FC1A5D597923FE104A96F38")
    
public void setLocale(Locale locale) {
        this.locale = locale;
        for (int i = 0; i <= maxOffset; i++) {
            Format format = formats[i];
            // java specification undefined for null argument, change into
            // a more tolerant implementation
            if (format instanceof DecimalFormat) {
                try {
                    formats[i] = new DecimalFormat(((DecimalFormat) format)
                            .toPattern(), new DecimalFormatSymbols(locale));
                } catch (NullPointerException npe){
                    formats[i] = null;
                }
            } else if (format instanceof SimpleDateFormat) {
                try {
                    formats[i] = new SimpleDateFormat(((SimpleDateFormat) format)
                            .toPattern(), locale);
                } catch (NullPointerException npe) {
                    formats[i] = null;
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.132 -0500", hash_original_method = "BE681D9EC5F601D03AA4D2DED505610A", hash_generated_method = "2C86DA88F5AEBCB45B6AD2C00721CD90")
    
private String decodeDecimalFormat(StringBuffer buffer, Format format) {
        buffer.append(",number");
        if (format.equals(NumberFormat.getNumberInstance(locale))) {
            // Empty block
        } else if (format.equals(NumberFormat.getIntegerInstance(locale))) {
            buffer.append(",integer");
        } else if (format.equals(NumberFormat.getCurrencyInstance(locale))) {
            buffer.append(",currency");
        } else if (format.equals(NumberFormat.getPercentInstance(locale))) {
            buffer.append(",percent");
        } else {
            buffer.append(',');
            return ((DecimalFormat) format).toPattern();
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.137 -0500", hash_original_method = "4C7466ADB5C592A5046867709A03D0C4", hash_generated_method = "BBDE23B5D43A7B9999261B473823AB28")
    
private String decodeSimpleDateFormat(StringBuffer buffer, Format format) {
        if (format.equals(DateFormat.getTimeInstance(DateFormat.DEFAULT, locale))) {
            buffer.append(",time");
        } else if (format.equals(DateFormat.getDateInstance(DateFormat.DEFAULT,
                locale))) {
            buffer.append(",date");
        } else if (format.equals(DateFormat.getTimeInstance(DateFormat.SHORT,
                locale))) {
            buffer.append(",time,short");
        } else if (format.equals(DateFormat.getDateInstance(DateFormat.SHORT,
                locale))) {
            buffer.append(",date,short");
        } else if (format.equals(DateFormat.getTimeInstance(DateFormat.LONG,
                locale))) {
            buffer.append(",time,long");
        } else if (format.equals(DateFormat.getDateInstance(DateFormat.LONG,
                locale))) {
            buffer.append(",date,long");
        } else if (format.equals(DateFormat.getTimeInstance(DateFormat.FULL,
                locale))) {
            buffer.append(",time,full");
        } else if (format.equals(DateFormat.getDateInstance(DateFormat.FULL,
                locale))) {
            buffer.append(",date,full");
        } else {
            buffer.append(",date,");
            return ((SimpleDateFormat) format).toPattern();
        }
        return null;
    }

    /**
     * Returns the pattern of this message format.
     *
     * @return the pattern.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.140 -0500", hash_original_method = "0A7E6003101ED48A94DA0D4F2E79183E", hash_generated_method = "5A29D53EB005C97126A1E9F2282E7B30")
    
public String toPattern() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <= maxOffset; i++) {
            appendQuoted(buffer, strings[i]);
            buffer.append('{');
            buffer.append(argumentNumbers[i]);
            Format format = formats[i];
            String pattern = null;
            if (format instanceof ChoiceFormat) {
                buffer.append(",choice,");
                pattern = ((ChoiceFormat) format).toPattern();
            } else if (format instanceof DecimalFormat) {
                pattern = decodeDecimalFormat(buffer, format);
            } else if (format instanceof SimpleDateFormat) {
                pattern = decodeSimpleDateFormat(buffer, format);
            } else if (format != null) {
                throw new IllegalArgumentException("Unknown format");
            }
            if (pattern != null) {
                boolean quote = false;
                int index = 0, length = pattern.length(), count = 0;
                while (index < length) {
                    char ch = pattern.charAt(index++);
                    if (ch == '\'') {
                        quote = !quote;
                    }
                    if (!quote) {
                        if (ch == '{') {
                            count++;
                        }
                        if (ch == '}') {
                            if (count > 0) {
                                count--;
                            } else {
                                buffer.append("'}");
                                ch = '\'';
                            }
                        }
                    }
                    buffer.append(ch);
                }
            }
            buffer.append('}');
        }
        if (maxOffset + 1 < strings.length) {
            appendQuoted(buffer, strings[maxOffset + 1]);
        }
        return buffer.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.143 -0500", hash_original_method = "6D428A023D401981380713AD4CDA7F82", hash_generated_method = "2C1000AF8EA055B09AE9790989767646")
    
private void appendQuoted(StringBuffer buffer, String string) {
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (ch == '{' || ch == '}') {
                buffer.append('\'');
                buffer.append(ch);
                buffer.append('\'');
            } else {
                buffer.append(ch);
            }
        }
    }
    
    private static class FieldContainer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.753 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.041 -0500", hash_original_field = "3C510FC4DA58A78E7F390C1B8DF1DA17", hash_generated_field = "3C510FC4DA58A78E7F390C1B8DF1DA17")

        AttributedCharacterIterator.Attribute attribute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.043 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.046 -0500", hash_original_method = "79F81C9DE3A6ED731ECF4F86681A281A", hash_generated_method = "155E4C8EC62888044A6C19A3E266ED36")
        
public FieldContainer(int start, int end,
                AttributedCharacterIterator.Attribute attribute, Object value) {
            this.start = start;
            this.end = end;
            this.attribute = attribute;
            this.value = value;
        }
        
    }
    
    public static class Field extends Format.Field {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.155 -0500", hash_original_field = "5C42A4FC0D53FB69002D928FD16AB64B", hash_generated_field = "82B93A1D640327089FF038CC1C876D1A")

        private static final long serialVersionUID = 7899943957617360810L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.158 -0500", hash_original_field = "9F48ECB84499A13E88DB0AEA48EA998A", hash_generated_field = "BDDCF15FC3001123F8D4DF824E83B022")

        public static final Field ARGUMENT = new Field("message argument field");

        /**
         * Constructs a new instance of {@code MessageFormat.Field} with the
         * given field name.
         *
         * @param fieldName
         *            the field name.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.161 -0500", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "8E9E2E9A1129AAE1C0A40E201C67690D")
        
protected Field(String fieldName) {
            super(fieldName);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.148 -0500", hash_original_method = "9DFEE475D15759FEAAC0AFBD81E7E5BF", hash_generated_method = "9D0446B89AD916C03E682E9C7948B6D9")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("argumentNumbers", argumentNumbers);
        Format[] compatibleFormats = formats;
        fields.put("formats", compatibleFormats);
        fields.put("locale", locale);
        fields.put("maxOffset", maxOffset);
        int offset = 0;
        int offsetsLength = maxOffset + 1;
        int[] offsets = new int[offsetsLength];
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i <= maxOffset; i++) {
            offset += strings[i].length();
            offsets[i] = offset;
            pattern.append(strings[i]);
        }
        if (maxOffset + 1 < strings.length) {
            pattern.append(strings[maxOffset + 1]);
        }
        fields.put("offsets", offsets);
        fields.put("pattern", pattern.toString());
        stream.writeFields();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:08.152 -0500", hash_original_method = "A9ED7844547D5D70718F3EA12242A430", hash_generated_method = "B81107E9FD03D52517BB8A93C941EE90")
    
private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        argumentNumbers = (int[]) fields.get("argumentNumbers", null);
        formats = (Format[]) fields.get("formats", null);
        locale = (Locale) fields.get("locale", null);
        maxOffset = fields.get("maxOffset", 0);
        int[] offsets = (int[]) fields.get("offsets", null);
        String pattern = (String) fields.get("pattern", null);
        int length;
        if (maxOffset < 0) {
            length = pattern.length() > 0 ? 1 : 0;
        } else {
            length = maxOffset
                    + (offsets[maxOffset] == pattern.length() ? 1 : 2);
        }
        strings = new String[length];
        int last = 0;
        for (int i = 0; i <= maxOffset; i++) {
            strings[i] = pattern.substring(last, offsets[i]);
            last = offsets[i];
        }
        if (maxOffset + 1 < strings.length) {
            strings[strings.length - 1] = pattern.substring(last, pattern
                    .length());
        }
    }
}

