package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.100 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "A4856836C99EFEC9056A47B6A2A817BC")

    protected ProtocolVersion protocol;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.105 -0400", hash_original_method = "7165DC7A4A8D5E7DFBA683C58AA682D9", hash_generated_method = "2BCF8BDBD178CA0CDF629ED274A9249E")
    public  BasicLineParser(ProtocolVersion proto) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.106 -0400", hash_original_method = "214300EBA90AB0F87C7DC4ACF56AF3C7", hash_generated_method = "E1AC9D5EDA5F536927594BFCD2962534")
    public  BasicLineParser() {
        this(null);
        // ---------- Original Method ----------
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.119 -0400", hash_original_method = "9BF4BF2A71D6F582F34C94EF6EF05C09", hash_generated_method = "4E2AB375743D06AAEB2A812009C53F62")
    public ProtocolVersion parseProtocolVersion(final CharArrayBuffer buffer,
                                                final ParserCursor cursor) throws ParseException {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1892700570 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        String protoname;
        protoname = this.protocol.getProtocol();
        int protolength;
        protolength = protoname.length();
        int indexFrom;
        indexFrom = cursor.getPos();
        int indexTo;
        indexTo = cursor.getUpperBound();
        skipWhitespace(buffer, cursor);
        int i;
        i = cursor.getPos();
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
        } //End block
        boolean ok;
        ok = true;
        {
            int j;
            j = 0;
            {
                ok = (buffer.charAt(i+j) == protoname.charAt(j));
            } //End block
        } //End collapsed parenthetic
        {
            ok = (buffer.charAt(i+protolength) == '/');
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
        } //End block
        i += protolength+1;
        int period;
        period = buffer.indexOf('.', i, indexTo);
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid protocol version number: " + 
                 buffer.substring(indexFrom, indexTo));
        } //End block
        int major;
        try 
        {
            major = Integer.parseInt(buffer.substringTrimmed(i, period));
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid protocol major version number: " + 
                 buffer.substring(indexFrom, indexTo));
        } //End block
        i = period + 1;
        int blank;
        blank = buffer.indexOf(' ', i, indexTo);
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
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "Invalid protocol minor version number: " + 
                buffer.substring(indexFrom, indexTo));
        } //End block
        cursor.updatePos(blank);
        varB4EAC82CA7396A68D541C85D26508E83_1892700570 = createProtocolVersion(major, minor);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1892700570.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1892700570;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.120 -0400", hash_original_method = "F06FC4538680E4058C900A508AFBEA3D", hash_generated_method = "D43784303AA52367862658BAB4BAA0BD")
    protected ProtocolVersion createProtocolVersion(int major, int minor) {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1919844634 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1919844634 = protocol.forVersion(major, minor);
        addTaint(major);
        addTaint(minor);
        varB4EAC82CA7396A68D541C85D26508E83_1919844634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1919844634;
        // ---------- Original Method ----------
        //return protocol.forVersion(major, minor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.128 -0400", hash_original_method = "131811FCACED18FCD6DF993D05551A72", hash_generated_method = "5F3641BDA900E18A941A4AB8027BBC68")
    public boolean hasProtocolVersion(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        int index;
        index = cursor.getPos();
        String protoname;
        protoname = this.protocol.getProtocol();
        int protolength;
        protolength = protoname.length();
        {
            boolean var81DEE7C103A4DA6D73DC127E872AC078_2105834666 = (buffer.length() < protolength+4);
        } //End collapsed parenthetic
        {
            index = buffer.length() -4 -protolength;
        } //End block
        {
            {
                boolean var69188F7437059161AD091DC917ADC2AF_1470224946 = ((index < buffer.length()) &&
                    HTTP.isWhitespace(buffer.charAt(index)));
            } //End collapsed parenthetic
        } //End block
        {
            boolean var11DB40AFEC729D9B262674B7B7F2C5A8_83405397 = (index + protolength + 4 > buffer.length());
        } //End collapsed parenthetic
        boolean ok;
        ok = true;
        {
            int j;
            j = 0;
            {
                ok = (buffer.charAt(index+j) == protoname.charAt(j));
            } //End block
        } //End collapsed parenthetic
        {
            ok = (buffer.charAt(index+protolength) == '/');
        } //End block
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673252059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673252059;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.130 -0400", hash_original_method = "A423B7B4A530981615672A2507B78318", hash_generated_method = "85ADE5C8DBFA4C5C1373DCDAE9FBF8FD")
    public RequestLine parseRequestLine(final CharArrayBuffer buffer,
                                        final ParserCursor cursor) throws ParseException {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1910999492 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        int indexFrom;
        indexFrom = cursor.getPos();
        int indexTo;
        indexTo = cursor.getUpperBound();
        try 
        {
            skipWhitespace(buffer, cursor);
            int i;
            i = cursor.getPos();
            int blank;
            blank = buffer.indexOf(' ', i, indexTo);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            } //End block
            String method;
            method = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);
            skipWhitespace(buffer, cursor);
            i = cursor.getPos();
            blank = buffer.indexOf(' ', i, indexTo);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            } //End block
            String uri;
            uri = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);
            ProtocolVersion ver;
            ver = parseProtocolVersion(buffer, cursor);
            skipWhitespace(buffer, cursor);
            {
                boolean var1DFFED53F2DB420D2C7AF6460C3832FC_736705367 = (!cursor.atEnd());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1910999492 = createRequestLine(method, uri, ver);
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid request line: " + 
                                     buffer.substring(indexFrom, indexTo));
        } //End block
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1910999492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1910999492;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.145 -0400", hash_original_method = "4FEC66C772DF65B86E47F131D643F059", hash_generated_method = "BE8925C334B645417CE0785EF0B193FD")
    protected RequestLine createRequestLine(final String method,
                                            final String uri,
                                            final ProtocolVersion ver) {
        RequestLine varB4EAC82CA7396A68D541C85D26508E83_1618561776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1618561776 = new BasicRequestLine(method, uri, ver);
        addTaint(method.getTaint());
        addTaint(uri.getTaint());
        addTaint(ver.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1618561776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1618561776;
        // ---------- Original Method ----------
        //return new BasicRequestLine(method, uri, ver);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.146 -0400", hash_original_method = "25C42EFA872F90FCC52B9EB0DE702858", hash_generated_method = "352BDA3060B2B181DA5C5D826F621D7A")
    public StatusLine parseStatusLine(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) throws ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_451623709 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        int indexFrom;
        indexFrom = cursor.getPos();
        int indexTo;
        indexTo = cursor.getUpperBound();
        try 
        {
            ProtocolVersion ver;
            ver = parseProtocolVersion(buffer, cursor);
            skipWhitespace(buffer, cursor);
            int i;
            i = cursor.getPos();
            int blank;
            blank = buffer.indexOf(' ', i, indexTo);
            {
                blank = indexTo;
            } //End block
            int statusCode;
            statusCode = 0;
            try 
            {
                statusCode =
                    Integer.parseInt(buffer.substringTrimmed(i, blank));
            } //End block
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    "Unable to parse status code from status line: " 
                    + buffer.substring(indexFrom, indexTo));
            } //End block
            i = blank;
            String reasonPhrase;
            reasonPhrase = null;
            {
                reasonPhrase = buffer.substringTrimmed(i, indexTo);
            } //End block
            {
                reasonPhrase = "";
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_451623709 = createStatusLine(ver, statusCode, reasonPhrase);
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("Invalid status line: " + 
                                     buffer.substring(indexFrom, indexTo));
        } //End block
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_451623709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451623709;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.147 -0400", hash_original_method = "6514ACEBF21FB82A84D20506623D0A23", hash_generated_method = "76FB7724013FA89B6695209240BB5DAB")
    protected StatusLine createStatusLine(final ProtocolVersion ver,
                                          final int status, 
                                          final String reason) {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_819854059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_819854059 = new BasicStatusLine(ver, status, reason);
        addTaint(ver.getTaint());
        addTaint(status);
        addTaint(reason.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_819854059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819854059;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.147 -0400", hash_original_method = "96877585E3C205FD7438BA36DB87A742", hash_generated_method = "9D845EBDE896B5A1EB31C774BC641857")
    public Header parseHeader(CharArrayBuffer buffer) throws ParseException {
        Header varB4EAC82CA7396A68D541C85D26508E83_1459325839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459325839 = new BufferedHeader(buffer);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1459325839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459325839;
        // ---------- Original Method ----------
        //return new BufferedHeader(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.148 -0400", hash_original_method = "3365DB1911434298DB39102FDA0B0A6B", hash_generated_method = "5297000A993EA3F44F2355F159336D89")
    protected void skipWhitespace(final CharArrayBuffer buffer, final ParserCursor cursor) {
        int pos;
        pos = cursor.getPos();
        int indexTo;
        indexTo = cursor.getUpperBound();
        {
            boolean var74A9BE1A863EE5315411475CF0B0407C_1987775001 = ((pos < indexTo) &&
               HTTP.isWhitespace(buffer.charAt(pos)));
        } //End collapsed parenthetic
        cursor.updatePos(pos);
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        // ---------- Original Method ----------
        //int pos = cursor.getPos();
        //int indexTo = cursor.getUpperBound();
        //while ((pos < indexTo) &&
               //HTTP.isWhitespace(buffer.charAt(pos))) {
            //pos++;
        //}
        //cursor.updatePos(pos);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.148 -0400", hash_original_field = "4CABF341CC2653CD37864343CA741E33", hash_generated_field = "67CEFB7766AD0E32B0A93ADD488598F1")

    public final static BasicLineParser DEFAULT = new BasicLineParser();
}

