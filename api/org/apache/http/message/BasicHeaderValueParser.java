package org.apache.http.message;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class BasicHeaderValueParser implements HeaderValueParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.831 -0400", hash_original_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C", hash_generated_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.832 -0400", hash_original_method = "5016300DF78E74A02C94B3D9AD513F2B", hash_generated_method = "6B10CAB0EB78DACB5CEC05E1F14B7C00")
    public HeaderElement[] parseElements(final CharArrayBuffer buffer,
                                         final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1658876421 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1658876421.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1658876421;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1181190845 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1181190845.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1181190845;
        } //End block
        List elements = new ArrayList();
        while
(!cursor.atEnd())        
        {
            HeaderElement element = parseHeaderElement(buffer, cursor);
            if(!(element.getName().length() == 0 && element.getValue() == null))            
            {
                elements.add(element);
            } //End block
        } //End block
HeaderElement[] var554A6F34E30C47381133FE125CCC4AC2_1810078205 =         (HeaderElement[])
            elements.toArray(new HeaderElement[elements.size()]);
        var554A6F34E30C47381133FE125CCC4AC2_1810078205.addTaint(taint);
        return var554A6F34E30C47381133FE125CCC4AC2_1810078205;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.833 -0400", hash_original_method = "9DB78E4EDC9AB24886813ADD5ECD3AEC", hash_generated_method = "B60375F622D2A35BCB6EDE6BCF1866EC")
    public HeaderElement parseHeaderElement(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1631843036 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1631843036.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1631843036;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1676501074 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1676501074.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1676501074;
        } //End block
        NameValuePair nvp = parseNameValuePair(buffer, cursor);
        NameValuePair[] params = null;
        if(!cursor.atEnd())        
        {
            char ch = buffer.charAt(cursor.getPos() - 1);
            if(ch != ELEM_DELIMITER)            
            {
                params = parseParameters(buffer, cursor);
            } //End block
        } //End block
HeaderElement varB465087E72E60C51FEF16EFDDEB3D72D_360231988 =         createHeaderElement(nvp.getName(), nvp.getValue(), params);
        varB465087E72E60C51FEF16EFDDEB3D72D_360231988.addTaint(taint);
        return varB465087E72E60C51FEF16EFDDEB3D72D_360231988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.834 -0400", hash_original_method = "1E408228B87D655655D78320EF19A97F", hash_generated_method = "415C9F73A7829158E7DE74345E2CA0D3")
    protected HeaderElement createHeaderElement(
            final String name, 
            final String value, 
            final NameValuePair[] params) {
        addTaint(params[0].getTaint());
        addTaint(value.getTaint());
        addTaint(name.getTaint());
HeaderElement var7F31DAC00D84C92DB3DA09B50D518202_1258161006 =         new BasicHeaderElement(name, value, params);
        var7F31DAC00D84C92DB3DA09B50D518202_1258161006.addTaint(taint);
        return var7F31DAC00D84C92DB3DA09B50D518202_1258161006;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.835 -0400", hash_original_method = "AD12DE8E127E3F34D456FD84EFD432E9", hash_generated_method = "270E85F043ED36FAFD48B462942D8F2F")
    public NameValuePair[] parseParameters(final CharArrayBuffer buffer,
                                           final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1563182752 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1563182752.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1563182752;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1744596461 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1744596461.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1744596461;
        } //End block
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        while
(pos < indexTo)        
        {
            char ch = buffer.charAt(pos);
            if(HTTP.isWhitespace(ch))            
            {
                pos++;
            } //End block
            else
            {
                break;
            } //End block
        } //End block
        cursor.updatePos(pos);
        if(cursor.atEnd())        
        {
NameValuePair[] varF868564B236F065D2537C0B779B34247_239233133 =             new NameValuePair[] {};
            varF868564B236F065D2537C0B779B34247_239233133.addTaint(taint);
            return varF868564B236F065D2537C0B779B34247_239233133;
        } //End block
        List params = new ArrayList();
        while
(!cursor.atEnd())        
        {
            NameValuePair param = parseNameValuePair(buffer, cursor);
            params.add(param);
            char ch = buffer.charAt(cursor.getPos() - 1);
            if(ch == ELEM_DELIMITER)            
            {
                break;
            } //End block
        } //End block
NameValuePair[] var775797A1DB981CCD7D6A3DE99C60A910_1264819741 =         (NameValuePair[])
            params.toArray(new NameValuePair[params.size()]);
        var775797A1DB981CCD7D6A3DE99C60A910_1264819741.addTaint(taint);
        return var775797A1DB981CCD7D6A3DE99C60A910_1264819741;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.836 -0400", hash_original_method = "CDDF563B77C55AAFFCDB4B7B75BDCA50", hash_generated_method = "A435C2FD5C6E65F8653B7FAD6D692628")
    public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
NameValuePair var318CCD15B7AA3EEEC3B989AEA01F0945_1758492287 =         parseNameValuePair(buffer, cursor, ALL_DELIMITERS);
        var318CCD15B7AA3EEEC3B989AEA01F0945_1758492287.addTaint(taint);
        return var318CCD15B7AA3EEEC3B989AEA01F0945_1758492287;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.838 -0400", hash_original_method = "406DCF62228C794C94DA9032C1E82314", hash_generated_method = "F51E3F284FFD2C9A8FEC1368A3B148DD")
    public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor,
                                            final char[] delimiters) {
        addTaint(delimiters[0]);
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_2099442781 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_2099442781.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_2099442781;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1673195388 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1673195388.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1673195388;
        } //End block
        boolean terminated = false;
        int pos = cursor.getPos();
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        String name = null;
        while
(pos < indexTo)        
        {
            char ch = buffer.charAt(pos);
            if(ch == '=')            
            {
                break;
            } //End block
            if(isOneOf(ch, delimiters))            
            {
                terminated = true;
                break;
            } //End block
            pos++;
        } //End block
        if(pos == indexTo)        
        {
            terminated = true;
            name = buffer.substringTrimmed(indexFrom, indexTo);
        } //End block
        else
        {
            name = buffer.substringTrimmed(indexFrom, pos);
            pos++;
        } //End block
        if(terminated)        
        {
            cursor.updatePos(pos);
NameValuePair var936EB01DC49F9DC5803D5D6826C1E111_614519080 =             createNameValuePair(name, null);
            var936EB01DC49F9DC5803D5D6826C1E111_614519080.addTaint(taint);
            return var936EB01DC49F9DC5803D5D6826C1E111_614519080;
        } //End block
        String value = null;
        int i1 = pos;
        boolean qouted = false;
        boolean escaped = false;
        while
(pos < indexTo)        
        {
            char ch = buffer.charAt(pos);
            if(ch == '"' && !escaped)            
            {
                qouted = !qouted;
            } //End block
            if(!qouted && !escaped && isOneOf(ch, delimiters))            
            {
                terminated = true;
                break;
            } //End block
            if(escaped)            
            {
                escaped = false;
            } //End block
            else
            {
                escaped = qouted && ch == '\\';
            } //End block
            pos++;
        } //End block
        int i2 = pos;
        while
(i1 < i2 && (HTTP.isWhitespace(buffer.charAt(i1))))        
        {
            i1++;
        } //End block
        while
((i2 > i1) && (HTTP.isWhitespace(buffer.charAt(i2 - 1))))        
        {
            i2--;
        } //End block
        if(((i2 - i1) >= 2) 
            && (buffer.charAt(i1) == '"') 
            && (buffer.charAt(i2 - 1) == '"'))        
        {
            i1++;
            i2--;
        } //End block
        value = buffer.substring(i1, i2);
        if(terminated)        
        {
            pos++;
        } //End block
        cursor.updatePos(pos);
NameValuePair varC334BCF85B9429A14AC7E9CE58B8CEBB_957051486 =         createNameValuePair(name, value);
        varC334BCF85B9429A14AC7E9CE58B8CEBB_957051486.addTaint(taint);
        return varC334BCF85B9429A14AC7E9CE58B8CEBB_957051486;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.839 -0400", hash_original_method = "8A2AA75D4FAD157F6ECAF6793118129D", hash_generated_method = "A1632E2155F78DCEB7D5461214AC43C1")
    protected NameValuePair createNameValuePair(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
NameValuePair varF2851DDA9B912670ED8070D224835E50_1969976921 =         new BasicNameValuePair(name, value);
        varF2851DDA9B912670ED8070D224835E50_1969976921.addTaint(taint);
        return varF2851DDA9B912670ED8070D224835E50_1969976921;
        // ---------- Original Method ----------
        //return new BasicNameValuePair(name, value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.839 -0400", hash_original_field = "5F1FDB9705AE9CC060B8F3D421F03F13", hash_generated_field = "ECC028BAEF8182C6FB58A65CF09C5A31")

    public final static
        BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.840 -0400", hash_original_field = "BED2682364722421205ED8EC47E82686", hash_generated_field = "D4A4655610E5AD33BAD13A5088D74510")

    private final static char PARAM_DELIMITER = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.840 -0400", hash_original_field = "03F3466BEBFD2754305BDC70DBE8C173", hash_generated_field = "9F3335048E6514264D4F2903B65E5B12")

    private final static char ELEM_DELIMITER = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.840 -0400", hash_original_field = "030E466F6924A750F09610A6BEB10D63", hash_generated_field = "BD0D07C2953F078E3657679087F8ABF7")

    private final static char[] ALL_DELIMITERS = new char[] {
                                                                PARAM_DELIMITER, 
                                                                ELEM_DELIMITER
                                                                };
}

