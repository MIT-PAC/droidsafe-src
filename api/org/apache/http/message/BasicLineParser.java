package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;




public class BasicLineParser implements LineParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.979 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "A4856836C99EFEC9056A47B6A2A817BC")

    protected ProtocolVersion protocol;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.979 -0400", hash_original_method = "7165DC7A4A8D5E7DFBA683C58AA682D9", hash_generated_method = "D54893D8C2619A0C5763718124450DF6")
    public  BasicLineParser(ProtocolVersion proto) {
        if(proto == null)        
        {
            proto = HttpVersion.HTTP_1_1;
        } //End block
        this.protocol = proto;
        // ---------- Original Method ----------
        //if (proto == null) {
            //proto = HttpVersion.HTTP_1_1;
        //}
        //this.protocol = proto;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.980 -0400", hash_original_method = "214300EBA90AB0F87C7DC4ACF56AF3C7", hash_generated_method = "E1AC9D5EDA5F536927594BFCD2962534")
    public  BasicLineParser() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public final static ProtocolVersion parseProtocolVersion(String value,
                                             LineParser parser) throws ParseException {
        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null.");
        }
        if (parser == null)
            parser = BasicLineParser.DEFAULT;
        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseProtocolVersion(buffer, cursor);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.982 -0400", hash_original_method = "9BF4BF2A71D6F582F34C94EF6EF05C09", hash_generated_method = "D8BF95339E2C5E9480CF4D6850B08DE3")
    public ProtocolVersion parseProtocolVersion(final CharArrayBuffer buffer,
                                                final ParserCursor cursor) throws ParseException {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1587799778 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1587799778.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1587799778;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_2125685881 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_2125685881.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_2125685881;
        } //End block
        final String protoname = this.protocol.getProtocol();
        final int protolength = protoname.length();
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        skipWhitespace(buffer, cursor);
        int i = cursor.getPos();
        if(i + protolength + 4 > indexTo)        
        {
            ParseException var6ADED26E4CD538774103DA31BCED7784_1972133457 = new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
            var6ADED26E4CD538774103DA31BCED7784_1972133457.addTaint(taint);
            throw var6ADED26E4CD538774103DA31BCED7784_1972133457;
        } //End block
        boolean ok = true;
for(int j=0;ok && (j<protolength);j++)
        {
            ok = (buffer.charAt(i+j) == protoname.charAt(j));
        } //End block
        if(ok)        
        {
            ok = (buffer.charAt(i+protolength) == '/');
        } //End block
        if(!ok)        
        {
            ParseException var6ADED26E4CD538774103DA31BCED7784_718188173 = new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
            var6ADED26E4CD538774103DA31BCED7784_718188173.addTaint(taint);
            throw var6ADED26E4CD538774103DA31BCED7784_718188173;
        } //End block
        i += protolength+1;
        int period = buffer.indexOf('.', i, indexTo);
        if(period == -1)        
        {
            ParseException var351DDCFBA064BB3CCA4D629CDF058E34_722248194 = new ParseException
                ("Invalid protocol version number: " + 
                 buffer.substring(indexFrom, indexTo));
            var351DDCFBA064BB3CCA4D629CDF058E34_722248194.addTaint(taint);
            throw var351DDCFBA064BB3CCA4D629CDF058E34_722248194;
        } //End block
        int major;
        try 
        {
            major = Integer.parseInt(buffer.substringTrimmed(i, period));
        } //End block
        catch (NumberFormatException e)
        {
            ParseException varEE07770C5BA9EB3A78FFF01785DEE06F_1424738620 = new ParseException
                ("Invalid protocol major version number: " + 
                 buffer.substring(indexFrom, indexTo));
            varEE07770C5BA9EB3A78FFF01785DEE06F_1424738620.addTaint(taint);
            throw varEE07770C5BA9EB3A78FFF01785DEE06F_1424738620;
        } //End block
        i = period + 1;
        int blank = buffer.indexOf(' ', i, indexTo);
        if(blank == -1)        
        {
            blank = indexTo;
        } //End block
        int minor;
        try 
        {
            minor = Integer.parseInt(buffer.substringTrimmed(i, blank));
        } //End block
        catch (NumberFormatException e)
        {
            ParseException varB45AE5F4E578A2CA45A4F3D1266B7D8B_960578900 = new ParseException(
                "Invalid protocol minor version number: " + 
                buffer.substring(indexFrom, indexTo));
            varB45AE5F4E578A2CA45A4F3D1266B7D8B_960578900.addTaint(taint);
            throw varB45AE5F4E578A2CA45A4F3D1266B7D8B_960578900;
        } //End block
        cursor.updatePos(blank);
ProtocolVersion varF2205928791B2E1CCE50A23C9DF678D3_1295282009 =         createProtocolVersion(major, minor);
        varF2205928791B2E1CCE50A23C9DF678D3_1295282009.addTaint(taint);
        return varF2205928791B2E1CCE50A23C9DF678D3_1295282009;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.983 -0400", hash_original_method = "F06FC4538680E4058C900A508AFBEA3D", hash_generated_method = "FE721D87A53729F6DC53CEAC6990F176")
    protected ProtocolVersion createProtocolVersion(int major, int minor) {
        addTaint(minor);
        addTaint(major);
ProtocolVersion var6103A6032F3333D8CD36C83A0BC5134B_542539560 =         protocol.forVersion(major, minor);
        var6103A6032F3333D8CD36C83A0BC5134B_542539560.addTaint(taint);
        return var6103A6032F3333D8CD36C83A0BC5134B_542539560;
        // ---------- Original Method ----------
        //return protocol.forVersion(major, minor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.984 -0400", hash_original_method = "131811FCACED18FCD6DF993D05551A72", hash_generated_method = "8EAF1008596DDE51C5E39D35DA2D999E")
    public boolean hasProtocolVersion(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_826828490 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_826828490.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_826828490;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_48774634 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_48774634.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_48774634;
        } //End block
        int index = cursor.getPos();
        final String protoname = this.protocol.getProtocol();
        final int protolength = protoname.length();
        if(buffer.length() < protolength+4)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1147788883 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145690563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145690563;
        }
        if(index < 0)        
        {
            index = buffer.length() -4 -protolength;
        } //End block
        else
        if(index == 0)        
        {
            while
((index < buffer.length()) &&
                    HTTP.isWhitespace(buffer.charAt(index)))            
            {
                index++;
            } //End block
        } //End block
        if(index + protolength + 4 > buffer.length())        
        {
        boolean var68934A3E9455FA72420237EB05902327_980527213 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881121747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_881121747;
        }
        boolean ok = true;
for(int j=0;ok && (j<protolength);j++)
        {
            ok = (buffer.charAt(index+j) == protoname.charAt(j));
        } //End block
        if(ok)        
        {
            ok = (buffer.charAt(index+protolength) == '/');
        } //End block
        boolean var444BCB3A3FCF8389296C49467F27E1D6_43353670 = (ok);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992314104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992314104;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    public final static RequestLine parseRequestLine(final String value,
                                     LineParser parser) throws ParseException {
        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null.");
        }
        if (parser == null)
            parser = BasicLineParser.DEFAULT;
        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseRequestLine(buffer, cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.986 -0400", hash_original_method = "A423B7B4A530981615672A2507B78318", hash_generated_method = "E1C2F9471B757A683DCC7DB531768E41")
    public RequestLine parseRequestLine(final CharArrayBuffer buffer,
                                        final ParserCursor cursor) throws ParseException {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1211741481 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1211741481.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1211741481;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_747041178 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_747041178.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_747041178;
        } //End block
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        try 
        {
            skipWhitespace(buffer, cursor);
            int i = cursor.getPos();
            int blank = buffer.indexOf(' ', i, indexTo);
            if(blank < 0)            
            {
                ParseException var9D425035B5F9F7514E71F47640F0A03B_275416722 = new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
                var9D425035B5F9F7514E71F47640F0A03B_275416722.addTaint(taint);
                throw var9D425035B5F9F7514E71F47640F0A03B_275416722;
            } //End block
            String method = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);
            skipWhitespace(buffer, cursor);
            i = cursor.getPos();
            blank = buffer.indexOf(' ', i, indexTo);
            if(blank < 0)            
            {
                ParseException var9D425035B5F9F7514E71F47640F0A03B_1563738290 = new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
                var9D425035B5F9F7514E71F47640F0A03B_1563738290.addTaint(taint);
                throw var9D425035B5F9F7514E71F47640F0A03B_1563738290;
            } //End block
            String uri = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);
            ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
            skipWhitespace(buffer, cursor);
            if(!cursor.atEnd())            
            {
                ParseException var9D425035B5F9F7514E71F47640F0A03B_1863791049 = new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
                var9D425035B5F9F7514E71F47640F0A03B_1863791049.addTaint(taint);
                throw var9D425035B5F9F7514E71F47640F0A03B_1863791049;
            } //End block
RequestLine varF2255B0B7430193D41EA321978E75271_93969057 =             createRequestLine(method, uri, ver);
            varF2255B0B7430193D41EA321978E75271_93969057.addTaint(taint);
            return varF2255B0B7430193D41EA321978E75271_93969057;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            ParseException var9D425035B5F9F7514E71F47640F0A03B_1553560390 = new ParseException("Invalid request line: " + 
                                     buffer.substring(indexFrom, indexTo));
            var9D425035B5F9F7514E71F47640F0A03B_1553560390.addTaint(taint);
            throw var9D425035B5F9F7514E71F47640F0A03B_1553560390;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.986 -0400", hash_original_method = "4FEC66C772DF65B86E47F131D643F059", hash_generated_method = "17EA297BB1F58F46ABDECBFDD8D55BEC")
    protected RequestLine createRequestLine(final String method,
                                            final String uri,
                                            final ProtocolVersion ver) {
        addTaint(ver.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
RequestLine var21398EE0F79F6732234579A2A1746261_954315659 =         new BasicRequestLine(method, uri, ver);
        var21398EE0F79F6732234579A2A1746261_954315659.addTaint(taint);
        return var21398EE0F79F6732234579A2A1746261_954315659;
        // ---------- Original Method ----------
        //return new BasicRequestLine(method, uri, ver);
    }

    
    @DSModeled(DSC.SAFE)
    public final static StatusLine parseStatusLine(final String value,
                                   LineParser parser) throws ParseException {
        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null.");
        }
        if (parser == null)
            parser = BasicLineParser.DEFAULT;
        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        ParserCursor cursor = new ParserCursor(0, value.length());
        return parser.parseStatusLine(buffer, cursor);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.988 -0400", hash_original_method = "25C42EFA872F90FCC52B9EB0DE702858", hash_generated_method = "48A0138E617C364C305AB9AB009861FA")
    public StatusLine parseStatusLine(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) throws ParseException {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1904639229 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1904639229.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1904639229;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1281526561 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1281526561.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1281526561;
        } //End block
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        try 
        {
            ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
            skipWhitespace(buffer, cursor);
            int i = cursor.getPos();
            int blank = buffer.indexOf(' ', i, indexTo);
            if(blank < 0)            
            {
                blank = indexTo;
            } //End block
            int statusCode = 0;
            try 
            {
                statusCode =
                    Integer.parseInt(buffer.substringTrimmed(i, blank));
            } //End block
            catch (NumberFormatException e)
            {
                ParseException var78DE7686257645235023A96281C150DF_1155450160 = new ParseException(
                    "Unable to parse status code from status line: " 
                    + buffer.substring(indexFrom, indexTo));
                var78DE7686257645235023A96281C150DF_1155450160.addTaint(taint);
                throw var78DE7686257645235023A96281C150DF_1155450160;
            } //End block
            i = blank;
            String reasonPhrase = null;
            if(i < indexTo)            
            {
                reasonPhrase = buffer.substringTrimmed(i, indexTo);
            } //End block
            else
            {
                reasonPhrase = "";
            } //End block
StatusLine var0B0E9078CC8F6F2F5D3BE8156FA67B50_821056794 =             createStatusLine(ver, statusCode, reasonPhrase);
            var0B0E9078CC8F6F2F5D3BE8156FA67B50_821056794.addTaint(taint);
            return var0B0E9078CC8F6F2F5D3BE8156FA67B50_821056794;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            ParseException var839BD94C0C2AF9E2A366392FADC8DE8D_69505902 = new ParseException("Invalid status line: " + 
                                     buffer.substring(indexFrom, indexTo));
            var839BD94C0C2AF9E2A366392FADC8DE8D_69505902.addTaint(taint);
            throw var839BD94C0C2AF9E2A366392FADC8DE8D_69505902;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.988 -0400", hash_original_method = "6514ACEBF21FB82A84D20506623D0A23", hash_generated_method = "06081C7BC5AC26FD95CCB84014710568")
    protected StatusLine createStatusLine(final ProtocolVersion ver,
                                          final int status, 
                                          final String reason) {
        addTaint(reason.getTaint());
        addTaint(status);
        addTaint(ver.getTaint());
StatusLine var7EDDFAD7D61BF3995B3F3AC2FA08033B_1513332169 =         new BasicStatusLine(ver, status, reason);
        var7EDDFAD7D61BF3995B3F3AC2FA08033B_1513332169.addTaint(taint);
        return var7EDDFAD7D61BF3995B3F3AC2FA08033B_1513332169;
        // ---------- Original Method ----------
        //return new BasicStatusLine(ver, status, reason);
    }

    
    public final static Header parseHeader(final String value, 
                           LineParser parser) throws ParseException {
        if (value == null) {
            throw new IllegalArgumentException
                ("Value to parse may not be null");
        }
        if (parser == null)
            parser = BasicLineParser.DEFAULT;
        CharArrayBuffer buffer = new CharArrayBuffer(value.length());
        buffer.append(value);
        return parser.parseHeader(buffer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.989 -0400", hash_original_method = "96877585E3C205FD7438BA36DB87A742", hash_generated_method = "9B7772FC8FE21B8C286408673C74D82F")
    public Header parseHeader(CharArrayBuffer buffer) throws ParseException {
        addTaint(buffer.getTaint());
Header varA538F19AF489509DED0A3819B3004747_1059738740 =         new BufferedHeader(buffer);
        varA538F19AF489509DED0A3819B3004747_1059738740.addTaint(taint);
        return varA538F19AF489509DED0A3819B3004747_1059738740;
        // ---------- Original Method ----------
        //return new BufferedHeader(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.989 -0400", hash_original_method = "3365DB1911434298DB39102FDA0B0A6B", hash_generated_method = "B74DFFB9DE2E56F5F9046B8F78968ABD")
    protected void skipWhitespace(final CharArrayBuffer buffer, final ParserCursor cursor) {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        while
((pos < indexTo) &&
               HTTP.isWhitespace(buffer.charAt(pos)))        
        {
            pos++;
        } //End block
        cursor.updatePos(pos);
        // ---------- Original Method ----------
        //int pos = cursor.getPos();
        //int indexTo = cursor.getUpperBound();
        //while ((pos < indexTo) &&
               //HTTP.isWhitespace(buffer.charAt(pos))) {
            //pos++;
        //}
        //cursor.updatePos(pos);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.989 -0400", hash_original_field = "4CABF341CC2653CD37864343CA741E33", hash_generated_field = "67CEFB7766AD0E32B0A93ADD488598F1")

    public final static BasicLineParser DEFAULT = new BasicLineParser();
}

