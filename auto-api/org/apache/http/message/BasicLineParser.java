package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.ParseException;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.Header;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public class BasicLineParser implements LineParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.178 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "A4856836C99EFEC9056A47B6A2A817BC")

    protected ProtocolVersion protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.179 -0400", hash_original_method = "7165DC7A4A8D5E7DFBA683C58AA682D9", hash_generated_method = "2BCF8BDBD178CA0CDF629ED274A9249E")
    public  BasicLineParser(ProtocolVersion proto) {
        {
            proto = HttpVersion.HTTP_1_1;
        } 
        this.protocol = proto;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.180 -0400", hash_original_method = "214300EBA90AB0F87C7DC4ACF56AF3C7", hash_generated_method = "E1AC9D5EDA5F536927594BFCD2962534")
    public  BasicLineParser() {
        this(null);
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.182 -0400", hash_original_method = "9BF4BF2A71D6F582F34C94EF6EF05C09", hash_generated_method = "440D4D1A01B0D6A829A133623B0B3680")
    public ProtocolVersion parseProtocolVersion(final CharArrayBuffer buffer,
                                                final ParserCursor cursor) throws ParseException {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_274727420 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } 
        final String protoname = this.protocol.getProtocol();
        final int protolength = protoname.length();
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        skipWhitespace(buffer, cursor);
        int i = cursor.getPos();
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
        } 
        boolean ok = true;
        {
            int j = 0;
            {
                ok = (buffer.charAt(i+j) == protoname.charAt(j));
            } 
        } 
        {
            ok = (buffer.charAt(i+protolength) == '/');
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
        } 
        i += protolength+1;
        int period = buffer.indexOf('.', i, indexTo);
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid protocol version number: " + 
                 buffer.substring(indexFrom, indexTo));
        } 
        int major;
        try 
        {
            major = Integer.parseInt(buffer.substringTrimmed(i, period));
        } 
        catch (NumberFormatException e)
        {
        	throw new ParseException
                ("Invalid protocol major version number: " + 
                 buffer.substring(indexFrom, indexTo));
        } 
        i = period + 1;
        int blank = buffer.indexOf(' ', i, indexTo);
        {
            blank = indexTo;
        } 
        int minor;
        try 
        {
            minor = Integer.parseInt(buffer.substringTrimmed(i, blank));
        } 
        catch (NumberFormatException e)
        {
        	throw new ParseException(
                "Invalid protocol minor version number: " + 
                buffer.substring(indexFrom, indexTo));
        } 
        cursor.updatePos(blank);
        varB4EAC82CA7396A68D541C85D26508E83_274727420 = createProtocolVersion(major, minor);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_274727420.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_274727420;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.184 -0400", hash_original_method = "F06FC4538680E4058C900A508AFBEA3D", hash_generated_method = "43D9334001DFE80EE3AD02F2031AEAFB")
    protected ProtocolVersion createProtocolVersion(int major, int minor) {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1985897210 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1985897210 = protocol.forVersion(major, minor);
        addTaint(major);
        addTaint(minor);
        varB4EAC82CA7396A68D541C85D26508E83_1985897210.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1985897210;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.185 -0400", hash_original_method = "131811FCACED18FCD6DF993D05551A72", hash_generated_method = "084E53A8E0004F23F3E4794691D5F807")
    public boolean hasProtocolVersion(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } 
        int index = cursor.getPos();
        final String protoname = this.protocol.getProtocol();
        final int protolength = protoname.length();
        {
            boolean var81DEE7C103A4DA6D73DC127E872AC078_31148633 = (buffer.length() < protolength+4);
        } 
        {
            index = buffer.length() -4 -protolength;
        } 
        {
            {
                boolean var69188F7437059161AD091DC917ADC2AF_164633195 = ((index < buffer.length()) &&
                    HTTP.isWhitespace(buffer.charAt(index)));
            } 
        } 
        {
            boolean var11DB40AFEC729D9B262674B7B7F2C5A8_1509373932 = (index + protolength + 4 > buffer.length());
        } 
        boolean ok = true;
        {
            int j = 0;
            {
                ok = (buffer.charAt(index+j) == protoname.charAt(j));
            } 
        } 
        {
            ok = (buffer.charAt(index+protolength) == '/');
        } 
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720701428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720701428;
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.186 -0400", hash_original_method = "A423B7B4A530981615672A2507B78318", hash_generated_method = "46BF94C029F770E8B543EAF7532ADFC9")
    public RequestLine parseRequestLine(final CharArrayBuffer buffer,
                                        final ParserCursor cursor) throws ParseException {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_921236275 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } 
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        try 
        {
            skipWhitespace(buffer, cursor);
            int i = cursor.getPos();
            int blank = buffer.indexOf(' ', i, indexTo);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            } 
            String method = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);
            skipWhitespace(buffer, cursor);
            i = cursor.getPos();
            blank = buffer.indexOf(' ', i, indexTo);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            } 
            String uri = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);
            ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
            skipWhitespace(buffer, cursor);
            {
                boolean var1DFFED53F2DB420D2C7AF6460C3832FC_1119714406 = (!cursor.atEnd());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_921236275 = createRequestLine(method, uri, ver);
        } 
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                                     buffer.substring(indexFrom, indexTo));
        } 
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_921236275.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_921236275;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.187 -0400", hash_original_method = "4FEC66C772DF65B86E47F131D643F059", hash_generated_method = "12980E9DB39FBF9780C8993D46140926")
    protected RequestLine createRequestLine(final String method,
                                            final String uri,
                                            final ProtocolVersion ver) {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1588678096 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1588678096 = new BasicRequestLine(method, uri, ver);
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(ver.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1588678096.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1588678096;
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.188 -0400", hash_original_method = "25C42EFA872F90FCC52B9EB0DE702858", hash_generated_method = "4724833A31B0D9814498970FC66FD24F")
    public StatusLine parseStatusLine(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_32582302 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } 
        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        try 
        {
            ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
            skipWhitespace(buffer, cursor);
            int i = cursor.getPos();
            int blank = buffer.indexOf(' ', i, indexTo);
            {
                blank = indexTo;
            } 
            int statusCode = 0;
            try 
            {
                statusCode =
                    Integer.parseInt(buffer.substringTrimmed(i, blank));
            } 
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "Unable to parse status code from status line: " 
                    + buffer.substring(indexFrom, indexTo));
            } 
            i = blank;
            String reasonPhrase = null;
            {
                reasonPhrase = buffer.substringTrimmed(i, indexTo);
            } 
            {
                reasonPhrase = "";
            } 
            varB4EAC82CA7396A68D541C85D26508E83_32582302 = createStatusLine(ver, statusCode, reasonPhrase);
        } 
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid status line: " + 
                                     buffer.substring(indexFrom, indexTo));
        } 
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_32582302.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32582302;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.188 -0400", hash_original_method = "6514ACEBF21FB82A84D20506623D0A23", hash_generated_method = "C32C8AC506362079B69D817C1DE415F4")
    protected StatusLine createStatusLine(final ProtocolVersion ver,
                                          final int status, 
                                          final String reason) {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_2112191742 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2112191742 = new BasicStatusLine(ver, status, reason);
        addTaint(ver.getTaint());
        addTaint(status);
        addTaint(reason.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2112191742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2112191742;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.189 -0400", hash_original_method = "96877585E3C205FD7438BA36DB87A742", hash_generated_method = "6B53855D476FC3D95DCDA09043293C31")
    public Header parseHeader(CharArrayBuffer buffer) throws ParseException {
        Header varB4EAC82CA7396A68D541C85D26508E83_1075609930 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1075609930 = new BufferedHeader(buffer);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1075609930.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1075609930;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.189 -0400", hash_original_method = "3365DB1911434298DB39102FDA0B0A6B", hash_generated_method = "EC50D6296A9137B4E3B13645A7726A93")
    protected void skipWhitespace(final CharArrayBuffer buffer, final ParserCursor cursor) {
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        {
            boolean var74A9BE1A863EE5315411475CF0B0407C_369108135 = ((pos < indexTo) &&
               HTTP.isWhitespace(buffer.charAt(pos)));
        } 
        cursor.updatePos(pos);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        
        
        
        
               
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.189 -0400", hash_original_field = "4CABF341CC2653CD37864343CA741E33", hash_generated_field = "67CEFB7766AD0E32B0A93ADD488598F1")

    public final static BasicLineParser DEFAULT = new BasicLineParser();
}

