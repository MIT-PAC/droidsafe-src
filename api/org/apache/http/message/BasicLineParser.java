package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.024 -0500", hash_original_method = "0AAD6F43EB19D666089E9328760FB37E", hash_generated_method = "BD1D9295E80BF056AEDAD0D273447E7B")
    
public final static
        ProtocolVersion parseProtocolVersion(String value,
                                             LineParser parser)
        throws ParseException {

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.036 -0500", hash_original_method = "853D60735C6BCBB19B57E743C939D1E8", hash_generated_method = "A6D147B9274B5C046963186C4AC7D9E6")
    
public final static
        RequestLine parseRequestLine(final String value,
                                     LineParser parser)
        throws ParseException {

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.044 -0500", hash_original_method = "848468A78C901FCE20F620D15728243A", hash_generated_method = "6B50C02D8ABDCF788257D18C2D53AB1D")
    
public final static
        StatusLine parseStatusLine(final String value,
                                   LineParser parser)
        throws ParseException {

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.053 -0500", hash_original_method = "AD8DAE3D775454D5A67D9F9BDF341DE3", hash_generated_method = "190DEEEC0F7712C307245BAECAE9FF6D")
    
public final static
        Header parseHeader(final String value, 
                           LineParser parser)
        throws ParseException {

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.011 -0500", hash_original_field = "1EEAC37A9274861F2A66DB5E33C0D445", hash_generated_field = "67CEFB7766AD0E32B0A93ADD488598F1")

    public final static BasicLineParser DEFAULT = new BasicLineParser();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.014 -0500", hash_original_field = "47A36952B8C6C23935E0D010B5EDBA00", hash_generated_field = "A4856836C99EFEC9056A47B6A2A817BC")

    protected  ProtocolVersion protocol;

    /**
     * Creates a new line parser for the given HTTP-like protocol.
     *
     * @param proto     a version of the protocol to parse, or
     *                  <code>null</code> for HTTP. The actual version
     *                  is not relevant, only the protocol name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.017 -0500", hash_original_method = "7165DC7A4A8D5E7DFBA683C58AA682D9", hash_generated_method = "5EE318B3E04436ECB25706D9B5714E2F")
    
public BasicLineParser(ProtocolVersion proto) {
        if (proto == null) {
            proto = HttpVersion.HTTP_1_1;
        }
        this.protocol = proto;
    }

    /**
     * Creates a new line parser for HTTP.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.021 -0500", hash_original_method = "214300EBA90AB0F87C7DC4ACF56AF3C7", hash_generated_method = "F399CF64715CBBD01F5D1839B7643A13")
    
public BasicLineParser() {
        this(null);
    }

    // non-javadoc, see interface LineParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.028 -0500", hash_original_method = "9BF4BF2A71D6F582F34C94EF6EF05C09", hash_generated_method = "CCF5A9E25E9DF76ABB3B196EB530C05C")
    
public ProtocolVersion parseProtocolVersion(final CharArrayBuffer buffer,
                                                final ParserCursor cursor) 
        throws ParseException {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }

        final String protoname = this.protocol.getProtocol();
        final int protolength  = protoname.length();

        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        
        skipWhitespace(buffer, cursor);

        int i = cursor.getPos();
        
        // long enough for "HTTP/1.1"?
        if (i + protolength + 4 > indexTo) {
            throw new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
        }

        // check the protocol name and slash
        boolean ok = true;
        for (int j=0; ok && (j<protolength); j++) {
            ok = (buffer.charAt(i+j) == protoname.charAt(j));
        }
        if (ok) {
            ok = (buffer.charAt(i+protolength) == '/');
        }
        if (!ok) {
            throw new ParseException
                ("Not a valid protocol version: " +
                 buffer.substring(indexFrom, indexTo));
        }

        i += protolength+1;

        int period = buffer.indexOf('.', i, indexTo);
        if (period == -1) {
            throw new ParseException
                ("Invalid protocol version number: " + 
                 buffer.substring(indexFrom, indexTo));
        }
        int major;
        try {
            major = Integer.parseInt(buffer.substringTrimmed(i, period)); 
        } catch (NumberFormatException e) {
            throw new ParseException
                ("Invalid protocol major version number: " + 
                 buffer.substring(indexFrom, indexTo));
        }
        i = period + 1;
        
        int blank = buffer.indexOf(' ', i, indexTo);
        if (blank == -1) {
            blank = indexTo;
        }
        int minor;
        try {
            minor = Integer.parseInt(buffer.substringTrimmed(i, blank)); 
        } catch (NumberFormatException e) {
            throw new ParseException(
                "Invalid protocol minor version number: " + 
                buffer.substring(indexFrom, indexTo));
        }
        
        cursor.updatePos(blank);

        return createProtocolVersion(major, minor);

    } // parseProtocolVersion

    /**
     * Creates a protocol version.
     * Called from {@link #parseProtocolVersion}.
     *
     * @param major     the major version number, for example 1 in HTTP/1.0
     * @param minor     the minor version number, for example 0 in HTTP/1.0
     *
     * @return  the protocol version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.030 -0500", hash_original_method = "F06FC4538680E4058C900A508AFBEA3D", hash_generated_method = "DFFE2331C7CF38EA2E3FB6C7D40D2AB5")
    
protected ProtocolVersion createProtocolVersion(int major, int minor) {
        return protocol.forVersion(major, minor);
    }

    // non-javadoc, see interface LineParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.033 -0500", hash_original_method = "131811FCACED18FCD6DF993D05551A72", hash_generated_method = "E8314049A250DAA75E533992BB661948")
    
public boolean hasProtocolVersion(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
        int index = cursor.getPos();

        final String protoname = this.protocol.getProtocol();
        final int  protolength = protoname.length();

        if (buffer.length() < protolength+4)
            return false; // not long enough for "HTTP/1.1"

        if (index < 0) {
            // end of line, no tolerance for trailing whitespace
            // this works only for single-digit major and minor version
            index = buffer.length() -4 -protolength;
        } else if (index == 0) {
            // beginning of line, tolerate leading whitespace
            while ((index < buffer.length()) &&
                    HTTP.isWhitespace(buffer.charAt(index))) {
                 index++;
             }
        } // else within line, don't tolerate whitespace

        if (index + protolength + 4 > buffer.length())
            return false;

        // just check protocol name and slash, no need to analyse the version
        boolean ok = true;
        for (int j=0; ok && (j<protolength); j++) {
            ok = (buffer.charAt(index+j) == protoname.charAt(j));
        }
        if (ok) {
            ok = (buffer.charAt(index+protolength) == '/');
        }

        return ok;
    }

    /**
     * Parses a request line.
     *
     * @param buffer    a buffer holding the line to parse
     *
     * @return  the parsed request line
     *
     * @throws ParseException        in case of a parse error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.039 -0500", hash_original_method = "A423B7B4A530981615672A2507B78318", hash_generated_method = "5F183A883A40B4B48DDCB6212970033D")
    
public RequestLine parseRequestLine(final CharArrayBuffer buffer,
                                        final ParserCursor cursor)
        throws ParseException {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }

        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        
        try {
            skipWhitespace(buffer, cursor);
            int i = cursor.getPos();
            
            int blank = buffer.indexOf(' ', i, indexTo);
            if (blank < 0) {
                throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            }
            String method = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);

            skipWhitespace(buffer, cursor);
            i = cursor.getPos();

            blank = buffer.indexOf(' ', i, indexTo);
            if (blank < 0) {
                throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            }
            String uri = buffer.substringTrimmed(i, blank);
            cursor.updatePos(blank);

            ProtocolVersion ver = parseProtocolVersion(buffer, cursor);
            
            skipWhitespace(buffer, cursor);
            if (!cursor.atEnd()) {
                throw new ParseException("Invalid request line: " + 
                        buffer.substring(indexFrom, indexTo));
            }
            
            return createRequestLine(method, uri, ver);
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid request line: " + 
                                     buffer.substring(indexFrom, indexTo)); 
        }
    } // parseRequestLine

    /**
     * Instantiates a new request line.
     * Called from {@link #parseRequestLine}.
     *
     * @param method    the request method
     * @param uri       the requested URI
     * @param ver       the protocol version
     *
     * @return  a new status line with the given data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.042 -0500", hash_original_method = "4FEC66C772DF65B86E47F131D643F059", hash_generated_method = "6B1A9D3B5B8DC374BAC19777BF9CC7B5")
    
protected RequestLine createRequestLine(final String method,
                                            final String uri,
                                            final ProtocolVersion ver) {
        return new BasicRequestLine(method, uri, ver);
    }

    // non-javadoc, see interface LineParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.048 -0500", hash_original_method = "25C42EFA872F90FCC52B9EB0DE702858", hash_generated_method = "D7B4DEF84F8787F85107ED813C79A5D4")
    
public StatusLine parseStatusLine(final CharArrayBuffer buffer,
                                      final ParserCursor cursor) 
        throws ParseException {

        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }

        int indexFrom = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        
        try {
            // handle the HTTP-Version
            ProtocolVersion ver = parseProtocolVersion(buffer, cursor);

            // handle the Status-Code
            skipWhitespace(buffer, cursor);
            int i = cursor.getPos();
            
            int blank = buffer.indexOf(' ', i, indexTo);
            if (blank < 0) {
                blank = indexTo;
            }
            int statusCode = 0;
            try {
                statusCode =
                    Integer.parseInt(buffer.substringTrimmed(i, blank));
            } catch (NumberFormatException e) {
                throw new ParseException(
                    "Unable to parse status code from status line: " 
                    + buffer.substring(indexFrom, indexTo));
            }
            //handle the Reason-Phrase
            i = blank;
            String reasonPhrase = null;
            if (i < indexTo) {
                reasonPhrase = buffer.substringTrimmed(i, indexTo);
            } else {
                reasonPhrase = "";
            }
            return createStatusLine(ver, statusCode, reasonPhrase);

        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid status line: " + 
                                     buffer.substring(indexFrom, indexTo)); 
        }
    } // parseStatusLine

    /**
     * Instantiates a new status line.
     * Called from {@link #parseStatusLine}.
     *
     * @param ver       the protocol version
     * @param status    the status code
     * @param reason    the reason phrase
     *
     * @return  a new status line with the given data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.050 -0500", hash_original_method = "6514ACEBF21FB82A84D20506623D0A23", hash_generated_method = "83A71FC8AB8CA478F9B67C7731FB56F1")
    
protected StatusLine createStatusLine(final ProtocolVersion ver,
                                          final int status, 
                                          final String reason) {
        return new BasicStatusLine(ver, status, reason);
    }

    // non-javadoc, see interface LineParser
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.055 -0500", hash_original_method = "96877585E3C205FD7438BA36DB87A742", hash_generated_method = "075B379A31BB36F4FC35D0BAF03C96B1")
    
public Header parseHeader(CharArrayBuffer buffer)
        throws ParseException {

        // the actual parser code is in the constructor of BufferedHeader
        return new BufferedHeader(buffer);
    }

    /**
     * Helper to skip whitespace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.058 -0500", hash_original_method = "3365DB1911434298DB39102FDA0B0A6B", hash_generated_method = "F9D24BCE540631E978BB617B4CE94DD8")
    
protected void skipWhitespace(final CharArrayBuffer buffer, final ParserCursor cursor) {
        int pos = cursor.getPos();
        int indexTo = cursor.getUpperBound();
        while ((pos < indexTo) &&
               HTTP.isWhitespace(buffer.charAt(pos))) {
            pos++;
        }
        cursor.updatePos(pos);
    }
}

