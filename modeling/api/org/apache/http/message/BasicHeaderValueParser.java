package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderValueParser implements HeaderValueParser {
    
    // public default constructor

    /**
     * Parses elements with the given parser.
     *
     * @param value     the header value to parse
     * @param parser    the parser to use, or <code>null</code> for default
     *
     * @return  array holding the header elements, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.370 -0500", hash_original_method = "3BFD510AFFBAA2A375FE57A270664097", hash_generated_method = "346E8A503E38C5937D6603AE9CF91D6D")
    
public final static
        HeaderElement[] parseElements(final String value,
                                      HeaderValueParser parser)
        throws ParseException {

        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null");
        }

        if (parser == null)
            parser = BasicHeaderValueParser.DEFAULT;

        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseElements(buffer, cursor);
    }

    /**
     * Parses an element with the given parser.
     *
     * @param value     the header element to parse
     * @param parser    the parser to use, or <code>null</code> for default
     *
     * @return  the parsed header element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.376 -0500", hash_original_method = "16F26E6B49FE203D5A6C49E570EC8B0F", hash_generated_method = "CA14A5F3B64850E8A1A6CE5E8406B180")
    
public final static
        HeaderElement parseHeaderElement(final String value,
                                         HeaderValueParser parser)
        throws ParseException {

        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null");
        }

        if (parser == null)
            parser = BasicHeaderValueParser.DEFAULT;

        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseHeaderElement(buffer, cursor);
    }

    /**
     * Parses parameters with the given parser.
     *
     * @param value     the parameter list to parse
     * @param parser    the parser to use, or <code>null</code> for default
     *
     * @return  array holding the parameters, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.384 -0500", hash_original_method = "A3D128052E6DBB71E212001BDC0EAD27", hash_generated_method = "37AE479593AFCE0B900F586B9EA225CE")
    
public final static
        NameValuePair[] parseParameters(final String value,
                                        HeaderValueParser parser)
        throws ParseException {

        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null");
        }

        if (parser == null)
            parser = BasicHeaderValueParser.DEFAULT;

        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseParameters(buffer, cursor);
    }

    /**
     * Parses a name-value-pair with the given parser.
     *
     * @param value     the NVP to parse
     * @param parser    the parser to use, or <code>null</code> for default
     *
     * @return  the parsed name-value pair
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.392 -0500", hash_original_method = "9EE51BDDDFEA067740CEE5DDE13516BE", hash_generated_method = "77266D89E2E51D3BE587A966F559436A")
    
public final static
       NameValuePair parseNameValuePair(final String value,
                                        HeaderValueParser parser)
        throws ParseException {

        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null");
        }

        if (parser == null)
            parser = BasicHeaderValueParser.DEFAULT;

        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseNameValuePair(buffer, cursor);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.397 -0500", hash_original_method = "74EBD3D20C7FE20EA6B10D14D89238DB", hash_generated_method = "0989BD96DAD028C80B5B528A321351A5")
    
private static boolean isOneOf(final char ch, final char[] chs) {
        if (chs != null) {
            for (int i = 0; i < chs.length; i++) {
                if (ch == chs[i]) {
                    return true;
                }
            }
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.360 -0500", hash_original_field = "AB5C98D3797C53D42574AA44FF06B020", hash_generated_field = "ECC028BAEF8182C6FB58A65CF09C5A31")

    public final static
        BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.363 -0500", hash_original_field = "AD17628587A42C99D7C5E8647BB417E7", hash_generated_field = "D4A4655610E5AD33BAD13A5088D74510")

    private final static char PARAM_DELIMITER                = ';';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.365 -0500", hash_original_field = "00CC834AB95DBBAA3C6197CB6D21E09D", hash_generated_field = "9F3335048E6514264D4F2903B65E5B12")

    private final static char ELEM_DELIMITER                 = ',';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.368 -0500", hash_original_field = "57FB05B058A738A0C198DA2AC58B427D", hash_generated_field = "BD0D07C2953F078E3657679087F8ABF7")

    private final static char[] ALL_DELIMITERS               = new char[] {
                                                                PARAM_DELIMITER, 
                                                                ELEM_DELIMITER
                                                                };
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.831 -0400", hash_original_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C", hash_generated_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C")
    public BasicHeaderValueParser ()
    {
        //Synthesized constructor
    }

    // non-javadoc, see interface HeaderValueParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.373 -0500", hash_original_method = "5016300DF78E74A02C94B3D9AD513F2B", hash_generated_method = "DDEC0A5D635225F759FB3EDC18624748")
    
public HeaderElement[] parseElements(final CharArrayBuffer buffer,
                                         final ParserCursor cursor) {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }

        List elements = new ArrayList(); 
        while (!cursor.atEnd()) {
            HeaderElement element = parseHeaderElement(buffer, cursor);
            if (!(element.getName().length() == 0 && element.getValue() == null)) {
                elements.add(element);
            }
        }
        return (HeaderElement[])
            elements.toArray(new HeaderElement[elements.size()]);
    }

    // non-javadoc, see interface HeaderValueParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.379 -0500", hash_original_method = "9DB78E4EDC9AB24886813ADD5ECD3AEC", hash_generated_method = "E2B30DD172331B018DDEDD6B8DA86828")
    
public HeaderElement parseHeaderElement(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
        
        NameValuePair nvp = parseNameValuePair(buffer, cursor);
        NameValuePair[] params = null;
        if (!cursor.atEnd()) {
            char ch = buffer.charAt(cursor.getPos() - 1); 
            if (ch != ELEM_DELIMITER) {
                params = parseParameters(buffer, cursor);
            }
        }
        return createHeaderElement(nvp.getName(), nvp.getValue(), params);
    }

    /**
     * Creates a header element.
     * Called from {@link #parseHeaderElement}.
     *
     * @return  a header element representing the argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.381 -0500", hash_original_method = "1E408228B87D655655D78320EF19A97F", hash_generated_method = "4397EC0CE8DA8894619D95DECB117CDD")
    
protected HeaderElement createHeaderElement(
            final String name, 
            final String value, 
            final NameValuePair[] params) {
        return new BasicHeaderElement(name, value, params);
    }

    // non-javadoc, see interface HeaderValueParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.388 -0500", hash_original_method = "AD12DE8E127E3F34D456FD84EFD432E9", hash_generated_method = "9FBF95A0EA203A135F1E3284D60E467B")
    
public NameValuePair[] parseParameters(final CharArrayBuffer buffer,
                                           final ParserCursor cursor) {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
        
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        
        while (pos < indexTo) {
            char ch = buffer.charAt(pos);
            if (HTTP.isWhitespace(ch)) {
                pos++;
            } else {
                break;
            }
        }
        cursor.updatePos(pos);
        if (cursor.atEnd()) {
            return new NameValuePair[] {};
        }
        
        List params = new ArrayList(); 
        while (!cursor.atEnd()) {
            NameValuePair param = parseNameValuePair(buffer, cursor);
            params.add(param);
            char ch = buffer.charAt(cursor.getPos() - 1);
            if (ch == ELEM_DELIMITER) {
                break;
            }
        }
        
        return (NameValuePair[])
            params.toArray(new NameValuePair[params.size()]);
    }

    // non-javadoc, see interface HeaderValueParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.394 -0500", hash_original_method = "CDDF563B77C55AAFFCDB4B7B75BDCA50", hash_generated_method = "9270E18A54D61050C3549785E3137523")
    
public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        return parseNameValuePair(buffer, cursor, ALL_DELIMITERS);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.400 -0500", hash_original_method = "406DCF62228C794C94DA9032C1E82314", hash_generated_method = "B2051719B630239276E990FA166A68B2")
    
public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor,
                                            final char[] delimiters) {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }

        boolean terminated = false;
        
        int pos = cursor.getPos();
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        
        // Find name
        String name = null;
        while (pos < indexTo) {
            char ch = buffer.charAt(pos);
            if (ch == '=') {
                break;
            }
            if (isOneOf(ch, delimiters)) {
                terminated = true;
                break;
            }
            pos++;
        }
        
        if (pos == indexTo) {
            terminated = true;
            name = buffer.substringTrimmed(indexFrom, indexTo);
        } else {
            name = buffer.substringTrimmed(indexFrom, pos);
            pos++;
        }
        
        if (terminated) {
            cursor.updatePos(pos);
            return createNameValuePair(name, null);
        }

        // Find value
        String value = null;
        int i1 = pos;
        
        boolean qouted = false;
        boolean escaped = false;
        while (pos < indexTo) {
            char ch = buffer.charAt(pos);
            if (ch == '"' && !escaped) {
                qouted = !qouted;
            }
            if (!qouted && !escaped && isOneOf(ch, delimiters)) {
                terminated = true;
                break;
            }
            if (escaped) {
                escaped = false;
            } else {
                escaped = qouted && ch == '\\';
            }
            pos++;
        }
        
        int i2 = pos;
        // Trim leading white spaces
        while (i1 < i2 && (HTTP.isWhitespace(buffer.charAt(i1)))) {
            i1++;
        }
        // Trim trailing white spaces
        while ((i2 > i1) && (HTTP.isWhitespace(buffer.charAt(i2 - 1)))) {
            i2--;
        }
        // Strip away quotes if necessary
        if (((i2 - i1) >= 2) 
            && (buffer.charAt(i1) == '"') 
            && (buffer.charAt(i2 - 1) == '"')) {
            i1++;
            i2--;
        }
        value = buffer.substring(i1, i2);
        if (terminated) {
            pos++;
        }
        cursor.updatePos(pos);
        return createNameValuePair(name, value);
    }

    /**
     * Creates a name-value pair.
     * Called from {@link #parseNameValuePair}.
     *
     * @param name      the name
     * @param value     the value, or <code>null</code>
     *
     * @return  a name-value pair representing the arguments
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.402 -0500", hash_original_method = "8A2AA75D4FAD157F6ECAF6793118129D", hash_generated_method = "98C0BA0769A46B2642DDBD9D2DE05897")
    
protected NameValuePair createNameValuePair(final String name, final String value) {
        return new BasicNameValuePair(name, value);
    }
}

