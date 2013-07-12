package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.List;
import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderValueParser implements HeaderValueParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.438 -0400", hash_original_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C", hash_generated_method = "E5D5EDFEB9DFD5F75BF9F31254D7292C")
    public BasicHeaderValueParser ()
    {
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.439 -0400", hash_original_method = "5016300DF78E74A02C94B3D9AD513F2B", hash_generated_method = "A01848BC5E0CF398F05E7CCE4ACEB06D")
    public HeaderElement[] parseElements(final CharArrayBuffer buffer,
                                         final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
    if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1056691174 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1056691174.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1056691174;
        } 
    if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1732714165 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1732714165.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1732714165;
        } 
        List elements = new ArrayList();
        while
(!cursor.atEnd())        
        {
            HeaderElement element = parseHeaderElement(buffer, cursor);
    if(!(element.getName().length() == 0 && element.getValue() == null))            
            {
                elements.add(element);
            } 
        } 
HeaderElement[] var554A6F34E30C47381133FE125CCC4AC2_1123467989 =         (HeaderElement[])
            elements.toArray(new HeaderElement[elements.size()]);
        var554A6F34E30C47381133FE125CCC4AC2_1123467989.addTaint(taint);
        return var554A6F34E30C47381133FE125CCC4AC2_1123467989;
        
        
            
        
        
            
        
        
        
            
            
                
            
        
        
            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.440 -0400", hash_original_method = "9DB78E4EDC9AB24886813ADD5ECD3AEC", hash_generated_method = "F5C6348B7ACB9BD07D610DB2FB8AB485")
    public HeaderElement parseHeaderElement(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
    if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1528107494 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1528107494.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1528107494;
        } 
    if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_2054828878 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_2054828878.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_2054828878;
        } 
        NameValuePair nvp = parseNameValuePair(buffer, cursor);
        NameValuePair[] params = null;
    if(!cursor.atEnd())        
        {
            char ch = buffer.charAt(cursor.getPos() - 1);
    if(ch != ELEM_DELIMITER)            
            {
                params = parseParameters(buffer, cursor);
            } 
        } 
HeaderElement varB465087E72E60C51FEF16EFDDEB3D72D_902617318 =         createHeaderElement(nvp.getName(), nvp.getValue(), params);
        varB465087E72E60C51FEF16EFDDEB3D72D_902617318.addTaint(taint);
        return varB465087E72E60C51FEF16EFDDEB3D72D_902617318;
        
        
            
        
        
            
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.441 -0400", hash_original_method = "1E408228B87D655655D78320EF19A97F", hash_generated_method = "6F9DDC432071F6320F6FCB433A7B1D5D")
    protected HeaderElement createHeaderElement(
            final String name, 
            final String value, 
            final NameValuePair[] params) {
        addTaint(params[0].getTaint());
        addTaint(value.getTaint());
        addTaint(name.getTaint());
HeaderElement var7F31DAC00D84C92DB3DA09B50D518202_1785161156 =         new BasicHeaderElement(name, value, params);
        var7F31DAC00D84C92DB3DA09B50D518202_1785161156.addTaint(taint);
        return var7F31DAC00D84C92DB3DA09B50D518202_1785161156;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.442 -0400", hash_original_method = "AD12DE8E127E3F34D456FD84EFD432E9", hash_generated_method = "5CBC7F70E6B7643105F988006E2E1C67")
    public NameValuePair[] parseParameters(final CharArrayBuffer buffer,
                                           final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
    if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1143511747 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1143511747.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1143511747;
        } 
    if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1541530221 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1541530221.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1541530221;
        } 
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        while
(pos < indexTo)        
        {
            char ch = buffer.charAt(pos);
    if(HTTP.isWhitespace(ch))            
            {
                pos++;
            } 
            else
            {
                break;
            } 
        } 
        cursor.updatePos(pos);
    if(cursor.atEnd())        
        {
NameValuePair[] varF868564B236F065D2537C0B779B34247_1314670501 =             new NameValuePair[] {};
            varF868564B236F065D2537C0B779B34247_1314670501.addTaint(taint);
            return varF868564B236F065D2537C0B779B34247_1314670501;
        } 
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
            } 
        } 
NameValuePair[] var775797A1DB981CCD7D6A3DE99C60A910_62724930 =         (NameValuePair[])
            params.toArray(new NameValuePair[params.size()]);
        var775797A1DB981CCD7D6A3DE99C60A910_62724930.addTaint(taint);
        return var775797A1DB981CCD7D6A3DE99C60A910_62724930;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.443 -0400", hash_original_method = "CDDF563B77C55AAFFCDB4B7B75BDCA50", hash_generated_method = "BC0892A2A646E59096C8539D3720EA77")
    public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
NameValuePair var318CCD15B7AA3EEEC3B989AEA01F0945_1126920693 =         parseNameValuePair(buffer, cursor, ALL_DELIMITERS);
        var318CCD15B7AA3EEEC3B989AEA01F0945_1126920693.addTaint(taint);
        return var318CCD15B7AA3EEEC3B989AEA01F0945_1126920693;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.445 -0400", hash_original_method = "406DCF62228C794C94DA9032C1E82314", hash_generated_method = "35D960E22482F917063B817E717E26CF")
    public NameValuePair parseNameValuePair(final CharArrayBuffer buffer,
                                            final ParserCursor cursor,
                                            final char[] delimiters) {
        addTaint(delimiters[0]);
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
    if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1285142262 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1285142262.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1285142262;
        } 
    if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_230225145 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_230225145.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_230225145;
        } 
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
            } 
    if(isOneOf(ch, delimiters))            
            {
                terminated = true;
                break;
            } 
            pos++;
        } 
    if(pos == indexTo)        
        {
            terminated = true;
            name = buffer.substringTrimmed(indexFrom, indexTo);
        } 
        else
        {
            name = buffer.substringTrimmed(indexFrom, pos);
            pos++;
        } 
    if(terminated)        
        {
            cursor.updatePos(pos);
NameValuePair var936EB01DC49F9DC5803D5D6826C1E111_1550293743 =             createNameValuePair(name, null);
            var936EB01DC49F9DC5803D5D6826C1E111_1550293743.addTaint(taint);
            return var936EB01DC49F9DC5803D5D6826C1E111_1550293743;
        } 
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
            } 
    if(!qouted && !escaped && isOneOf(ch, delimiters))            
            {
                terminated = true;
                break;
            } 
    if(escaped)            
            {
                escaped = false;
            } 
            else
            {
                escaped = qouted && ch == '\\';
            } 
            pos++;
        } 
        int i2 = pos;
        while
(i1 < i2 && (HTTP.isWhitespace(buffer.charAt(i1))))        
        {
            i1++;
        } 
        while
((i2 > i1) && (HTTP.isWhitespace(buffer.charAt(i2 - 1))))        
        {
            i2--;
        } 
    if(((i2 - i1) >= 2) 
            && (buffer.charAt(i1) == '"') 
            && (buffer.charAt(i2 - 1) == '"'))        
        {
            i1++;
            i2--;
        } 
        value = buffer.substring(i1, i2);
    if(terminated)        
        {
            pos++;
        } 
        cursor.updatePos(pos);
NameValuePair varC334BCF85B9429A14AC7E9CE58B8CEBB_1607842466 =         createNameValuePair(name, value);
        varC334BCF85B9429A14AC7E9CE58B8CEBB_1607842466.addTaint(taint);
        return varC334BCF85B9429A14AC7E9CE58B8CEBB_1607842466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.446 -0400", hash_original_method = "8A2AA75D4FAD157F6ECAF6793118129D", hash_generated_method = "02C4D3A6301593701553756004CC39EA")
    protected NameValuePair createNameValuePair(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
NameValuePair varF2851DDA9B912670ED8070D224835E50_861601639 =         new BasicNameValuePair(name, value);
        varF2851DDA9B912670ED8070D224835E50_861601639.addTaint(taint);
        return varF2851DDA9B912670ED8070D224835E50_861601639;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.446 -0400", hash_original_field = "5F1FDB9705AE9CC060B8F3D421F03F13", hash_generated_field = "ECC028BAEF8182C6FB58A65CF09C5A31")

    public final static
        BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.446 -0400", hash_original_field = "BED2682364722421205ED8EC47E82686", hash_generated_field = "D4A4655610E5AD33BAD13A5088D74510")

    private final static char PARAM_DELIMITER = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.446 -0400", hash_original_field = "03F3466BEBFD2754305BDC70DBE8C173", hash_generated_field = "9F3335048E6514264D4F2903B65E5B12")

    private final static char ELEM_DELIMITER = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.446 -0400", hash_original_field = "030E466F6924A750F09610A6BEB10D63", hash_generated_field = "BD0D07C2953F078E3657679087F8ABF7")

    private final static char[] ALL_DELIMITERS = new char[] {
                                                                PARAM_DELIMITER, 
                                                                ELEM_DELIMITER
                                                                };
}

