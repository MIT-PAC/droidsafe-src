package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderValueParser implements HeaderValueParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.966 -0400", hash_original_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C", hash_generated_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C")
    public BasicHeaderValueParser ()
    {
        //Synthesized constructor
    }


        public final static HeaderElement[] parseElements(final String value,
                                      HeaderValueParser parser) throws ParseException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.973 -0400", hash_original_method = "5016300DF78E74A02C94B3D9AD513F2B", hash_generated_method = "FE9FC69F19A8C2B3DFC683953FF7156A")
    public HeaderElement[] parseElements(final CharArrayBuffer buffer,
                                         final ParserCursor cursor) {
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_49455846 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        List elements;
        elements = new ArrayList();
        {
            boolean var4BEAEB17B63C1388A85B9C098E9AD4AA_1002188396 = (!cursor.atEnd());
            {
                HeaderElement element;
                element = parseHeaderElement(buffer, cursor);
                {
                    boolean var0B925591F2A208D08B75F2A56CD45C4C_1562134651 = (!(element.getName().length() == 0 && element.getValue() == null));
                    {
                        elements.add(element);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_49455846 = (HeaderElement[])
            elements.toArray(new HeaderElement[elements.size()]);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_49455846.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_49455846;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException("Char array buffer may not be null");
        //}
        //if (cursor == null) {
            //throw new IllegalArgumentException("Parser cursor may not be null");
        //}
        //List elements = new ArrayList();
        //while (!cursor.atEnd()) {
            //HeaderElement element = parseHeaderElement(buffer, cursor);
            //if (!(element.getName().length() == 0 && element.getValue() == null)) {
                //elements.add(element);
            //}
        //}
        //return (HeaderElement[])
            //elements.toArray(new HeaderElement[elements.size()]);
    }

    
        public final static HeaderElement parseHeaderElement(final String value,
                                         HeaderValueParser parser) throws ParseException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.978 -0400", hash_original_method = "9DB78E4EDC9AB24886813ADD5ECD3AEC", hash_generated_method = "F2AFD53FE95FF4A518D137F01A3E5FD0")
    public HeaderElement parseHeaderElement(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        HeaderElement varB4EAC82CA7396A68D541C85D26508E83_150456245 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        NameValuePair nvp;
        nvp = parseNameValuePair(buffer, cursor);
        NameValuePair[] params;
        params = null;
        {
            boolean var4BEAEB17B63C1388A85B9C098E9AD4AA_1811894466 = (!cursor.atEnd());
            {
                char ch;
                ch = buffer.charAt(cursor.getPos() - 1);
                {
                    params = parseParameters(buffer, cursor);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_150456245 = createHeaderElement(nvp.getName(), nvp.getValue(), params);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_150456245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_150456245;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException("Char array buffer may not be null");
        //}
        //if (cursor == null) {
            //throw new IllegalArgumentException("Parser cursor may not be null");
        //}
        //NameValuePair nvp = parseNameValuePair(buffer, cursor);
        //NameValuePair[] params = null;
        //if (!cursor.atEnd()) {
            //char ch = buffer.charAt(cursor.getPos() - 1); 
            //if (ch != ELEM_DELIMITER) {
                //params = parseParameters(buffer, cursor);
            //}
        //}
        //return createHeaderElement(nvp.getName(), nvp.getValue(), params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.979 -0400", hash_original_method = "1E408228B87D655655D78320EF19A97F", hash_generated_method = "83361208630A4A2325C13B5B567FDD7D")
    protected HeaderElement createHeaderElement(
            final String name, 
            final String value, 
            final NameValuePair[] params) {
        HeaderElement varB4EAC82CA7396A68D541C85D26508E83_1202806833 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1202806833 = new BasicHeaderElement(name, value, params);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        addTaint(params[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1202806833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1202806833;
        // ---------- Original Method ----------
        //return new BasicHeaderElement(name, value, params);
    }

    
        public final static NameValuePair[] parseParameters(final String value,
                                        HeaderValueParser parser) throws ParseException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.980 -0400", hash_original_method = "AD12DE8E127E3F34D456FD84EFD432E9", hash_generated_method = "B96B8E00E080FD614FB07954A796F2BD")
    public NameValuePair[] parseParameters(final CharArrayBuffer buffer,
                                           final ParserCursor cursor) {
        NameValuePair[] varB4EAC82CA7396A68D541C85D26508E83_546122607 = null; //Variable for return #1
        NameValuePair[] varB4EAC82CA7396A68D541C85D26508E83_1153511553 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        int pos;
        pos = cursor.getPos();
        int indexTo;
        indexTo = cursor.getUpperBound();
        {
            char ch;
            ch = buffer.charAt(pos);
            {
                boolean var562A80DD7B29195447785372901FBACC_1472224509 = (HTTP.isWhitespace(ch));
            } //End collapsed parenthetic
        } //End block
        cursor.updatePos(pos);
        {
            boolean var960C622592A5439AD1E01565F88F38C7_2080981834 = (cursor.atEnd());
            {
                varB4EAC82CA7396A68D541C85D26508E83_546122607 = new NameValuePair[] {};
            } //End block
        } //End collapsed parenthetic
        List params;
        params = new ArrayList();
        {
            boolean var4BEAEB17B63C1388A85B9C098E9AD4AA_706791232 = (!cursor.atEnd());
            {
                NameValuePair param;
                param = parseNameValuePair(buffer, cursor);
                params.add(param);
                char ch;
                ch = buffer.charAt(cursor.getPos() - 1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1153511553 = (NameValuePair[])
            params.toArray(new NameValuePair[params.size()]);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        NameValuePair[] varA7E53CE21691AB073D9660D615818899_1813381470; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1813381470 = varB4EAC82CA7396A68D541C85D26508E83_546122607;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1813381470 = varB4EAC82CA7396A68D541C85D26508E83_1153511553;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1813381470.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1813381470;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public final static NameValuePair parseNameValuePair(final String value,
                                        HeaderValueParser parser) throws ParseException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.985 -0400", hash_original_method = "CDDF563B77C55AAFFCDB4B7B75BDCA50", hash_generated_method = "BE15FCF08E8EFFB256CDF134DBCA6F3F")
    public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_321629847 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_321629847 = parseNameValuePair(buffer, cursor, ALL_DELIMITERS);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_321629847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_321629847;
        // ---------- Original Method ----------
        //return parseNameValuePair(buffer, cursor, ALL_DELIMITERS);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.004 -0400", hash_original_method = "406DCF62228C794C94DA9032C1E82314", hash_generated_method = "8B14513AE78683305CAA91CA9F870676")
    public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor,
                                            final char[] delimiters) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_1783472667 = null; //Variable for return #1
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_825040559 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        boolean terminated;
        terminated = false;
        int pos;
        pos = cursor.getPos();
        int indexFrom;
        indexFrom = cursor.getPos();
        int indexTo;
        indexTo = cursor.getUpperBound();
        String name;
        name = null;
        {
            char ch;
            ch = buffer.charAt(pos);
            {
                boolean var05C281860646EB7E65999A58787C5F8C_1252885575 = (isOneOf(ch, delimiters));
                {
                    terminated = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            terminated = true;
            name = buffer.substringTrimmed(indexFrom, indexTo);
        } //End block
        {
            name = buffer.substringTrimmed(indexFrom, pos);
        } //End block
        {
            cursor.updatePos(pos);
            varB4EAC82CA7396A68D541C85D26508E83_1783472667 = createNameValuePair(name, null);
        } //End block
        String value;
        value = null;
        int i1;
        i1 = pos;
        boolean qouted;
        qouted = false;
        boolean escaped;
        escaped = false;
        {
            char ch;
            ch = buffer.charAt(pos);
            {
                qouted = !qouted;
            } //End block
            {
                boolean var294D36F6ABAFA3CDB73404E3D2B52643_1882731872 = (!qouted && !escaped && isOneOf(ch, delimiters));
                {
                    terminated = true;
                } //End block
            } //End collapsed parenthetic
            {
                escaped = false;
            } //End block
            {
                escaped = qouted && ch == '\\';
            } //End block
        } //End block
        int i2;
        i2 = pos;
        {
            boolean varDA6FE9C966E1BCC4E2ED682B1F059A30_443758787 = (i1 < i2 && (HTTP.isWhitespace(buffer.charAt(i1))));
        } //End collapsed parenthetic
        {
            boolean var28912CFE96C719B649399375B584A90F_498394942 = ((i2 > i1) && (HTTP.isWhitespace(buffer.charAt(i2 - 1))));
        } //End collapsed parenthetic
        {
            boolean varD6CC0D2201F6AF7D011292F53C3A9E2C_418959707 = (((i2 - i1) >= 2) 
            && (buffer.charAt(i1) == '"') 
            && (buffer.charAt(i2 - 1) == '"'));
        } //End collapsed parenthetic
        value = buffer.substring(i1, i2);
        cursor.updatePos(pos);
        varB4EAC82CA7396A68D541C85D26508E83_825040559 = createNameValuePair(name, value);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        addTaint(delimiters[0]);
        NameValuePair varA7E53CE21691AB073D9660D615818899_1360394583; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1360394583 = varB4EAC82CA7396A68D541C85D26508E83_1783472667;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1360394583 = varB4EAC82CA7396A68D541C85D26508E83_825040559;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1360394583.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1360394583;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.006 -0400", hash_original_method = "8A2AA75D4FAD157F6ECAF6793118129D", hash_generated_method = "8B7C9BF9F18515FECE991DB846E2D026")
    protected NameValuePair createNameValuePair(final String name, final String value) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_1478150361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1478150361 = new BasicNameValuePair(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1478150361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1478150361;
        // ---------- Original Method ----------
        //return new BasicNameValuePair(name, value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.006 -0400", hash_original_field = "5F1FDB9705AE9CC060B8F3D421F03F13", hash_generated_field = "ECC028BAEF8182C6FB58A65CF09C5A31")

    public final static
        BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.006 -0400", hash_original_field = "BED2682364722421205ED8EC47E82686", hash_generated_field = "F2AD40521BDB9F0CE4BD6AA564821279")

    private static char PARAM_DELIMITER = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.006 -0400", hash_original_field = "03F3466BEBFD2754305BDC70DBE8C173", hash_generated_field = "E3BED66DF1AD1DF1B10C6E1F3D84FD32")

    private static char ELEM_DELIMITER = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.006 -0400", hash_original_field = "030E466F6924A750F09610A6BEB10D63", hash_generated_field = "C096CCA8ACE2E9A05829EE22FE127AAB")

    private static char[] ALL_DELIMITERS = new char[] {
                                                                PARAM_DELIMITER, 
                                                                ELEM_DELIMITER
                                                                };
}

