package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;






public class BasicLineFormatter implements LineFormatter {


    /**
     * Formats a protocol version.
     *
     * @param version           the protocol version to format
     * @param formatter         the formatter to use, or
     *                          <code>null</code> for the
     *                          {@link #DEFAULT default}
     *
     * @return  the formatted protocol version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.110 -0500", hash_original_method = "81A7E4EE2F08FBBD96C14DB561A7E449", hash_generated_method = "377B7C76F20CFA7DA93BEAD5B14F9315")
    public final static String formatProtocolVersion(final ProtocolVersion version,
                                     LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.appendProtocolVersion(null, version).toString();
    }


    /**
     * Formats a request line.
     *
     * @param reqline           the request line to format
     * @param formatter         the formatter to use, or
     *                          <code>null</code> for the
     *                          {@link #DEFAULT default}
     *
     * @return  the formatted request line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.112 -0500", hash_original_method = "D6F9919A17E283BD99102CFFD7EAE0C0", hash_generated_method = "C32E1FE0862478D2407E8882511A9429")
    public final static String formatRequestLine(final RequestLine reqline,
                                                 LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatRequestLine(null, reqline).toString();
    }



    /**
     * Formats a status line.
     *
     * @param statline          the status line to format
     * @param formatter         the formatter to use, or
     *                          <code>null</code> for the
     *                          {@link #DEFAULT default}
     *
     * @return  the formatted status line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.115 -0500", hash_original_method = "AF3A14095123D56D09822378D0F36CC8", hash_generated_method = "AAC6E813101FE7A1B2D6DEBB4EB4C029")
    public final static String formatStatusLine(final StatusLine statline,
                                                LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatStatusLine(null, statline).toString();
    }


    /**
     * Formats a header.
     *
     * @param header            the header to format
     * @param formatter         the formatter to use, or
     *                          <code>null</code> for the
     *                          {@link #DEFAULT default}
     *
     * @return  the formatted header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.117 -0500", hash_original_method = "36B01295C5B2DBDA962DAB198BFBD1DB", hash_generated_method = "E5BA0EAE21006208C176273F071C6E0E")
    public final static String formatHeader(final Header header,
                                            LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatHeader(null, header).toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.108 -0500", hash_original_field = "FD3345E09E8D21D0DFAA609038A979D3", hash_generated_field = "B42F8A4CEDBB52474BB29599F82217A2")

    public final static BasicLineFormatter DEFAULT = new BasicLineFormatter();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.925 -0400", hash_original_method = "8022E7B2B110A3478739271765EA4718", hash_generated_method = "8022E7B2B110A3478739271765EA4718")
    public BasicLineFormatter ()
    {
        //Synthesized constructor
    }



    // public default constructor


    /**
     * Obtains a buffer for formatting.
     *
     * @param buffer    a buffer already available, or <code>null</code>
     *
     * @return  the cleared argument buffer if there is one, or
     *          a new empty buffer that can be used for formatting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.109 -0500", hash_original_method = "88607DBCC47E4B4D98332640E6FF147F", hash_generated_method = "9AD675F881D01A7CFF2FF9537A3A3961")
    protected CharArrayBuffer initBuffer(CharArrayBuffer buffer) {
        if (buffer != null) {
            buffer.clear();
        } else {
            buffer = new CharArrayBuffer(64);
        }
        return buffer;
    }


    // non-javadoc, see interface LineFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.111 -0500", hash_original_method = "A0F2D5AC053D278723790680878C18C6", hash_generated_method = "920DDB076D9EBC191A61E6C77A344EB8")
    public CharArrayBuffer appendProtocolVersion(final CharArrayBuffer buffer,
                                                 final ProtocolVersion version) {
        if (version == null) {
            throw new IllegalArgumentException
                ("Protocol version may not be null");
        }

        // can't use initBuffer, that would clear the argument!
        CharArrayBuffer result = buffer;
        final int len = estimateProtocolVersionLen(version);
        if (result == null) {
            result = new CharArrayBuffer(len);
        } else {
            result.ensureCapacity(len);
        }

        result.append(version.getProtocol());
        result.append('/'); 
        result.append(Integer.toString(version.getMajor())); 
        result.append('.'); 
        result.append(Integer.toString(version.getMinor())); 

        return result;
    }


    /**
     * Guesses the length of a formatted protocol version.
     * Needed to guess the length of a formatted request or status line.
     *
     * @param version   the protocol version to format, or <code>null</code>
     *
     * @return  the estimated length of the formatted protocol version,
     *          in characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.112 -0500", hash_original_method = "84522AAB157FB837ECA38AFA8517069A", hash_generated_method = "BFC3383B5D1FDCC90DF21FE83B73B161")
    protected int estimateProtocolVersionLen(final ProtocolVersion version) {
        return version.getProtocol().length() + 4; // room for "HTTP/1.1"
    }


    // non-javadoc, see interface LineFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.113 -0500", hash_original_method = "19984FDC599EEB66F432BF4C8D33EB13", hash_generated_method = "7B42C4BC482C8BA10FF36B14E50194B8")
    public CharArrayBuffer formatRequestLine(CharArrayBuffer buffer,
                                             RequestLine reqline) {
        if (reqline == null) {
            throw new IllegalArgumentException
                ("Request line may not be null");
        }

        CharArrayBuffer result = initBuffer(buffer);
        doFormatRequestLine(result, reqline);

        return result;
    }


    /**
     * Actually formats a request line.
     * Called from {@link #formatRequestLine}.
     *
     * @param buffer    the empty buffer into which to format,
     *                  never <code>null</code>
     * @param reqline   the request line to format, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.114 -0500", hash_original_method = "1E31567E89FBC15B9220080016C6779D", hash_generated_method = "3887F203E069CD5917C63B0231E04E0C")
    protected void doFormatRequestLine(final CharArrayBuffer buffer,
                                       final RequestLine reqline) {
        final String method = reqline.getMethod();
        final String uri    = reqline.getUri();

        // room for "GET /index.html HTTP/1.1"
        int len = method.length() + 1 + uri.length() + 1 + 
            estimateProtocolVersionLen(reqline.getProtocolVersion());
        buffer.ensureCapacity(len);

        buffer.append(method);
        buffer.append(' ');
        buffer.append(uri);
        buffer.append(' ');
        appendProtocolVersion(buffer, reqline.getProtocolVersion());
    }


    // non-javadoc, see interface LineFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.116 -0500", hash_original_method = "48A800039F857A6F8C24EAA9095C9D1B", hash_generated_method = "171601DF15FB6EE29D6FA8C6A2CBDFD4")
    public CharArrayBuffer formatStatusLine(final CharArrayBuffer buffer,
                                            final StatusLine statline) {
        if (statline == null) {
            throw new IllegalArgumentException
                ("Status line may not be null");
        }

        CharArrayBuffer result = initBuffer(buffer);
        doFormatStatusLine(result, statline);

        return result;
    }


    /**
     * Actually formats a status line.
     * Called from {@link #formatStatusLine}.
     *
     * @param buffer    the empty buffer into which to format,
     *                  never <code>null</code>
     * @param statline  the status line to format, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.116 -0500", hash_original_method = "060574F84EC41767BDDD7A9C8F77F8CE", hash_generated_method = "54BA8F26B8B4264101BA10FB3646F0DB")
    protected void doFormatStatusLine(final CharArrayBuffer buffer,
                                      final StatusLine statline) {

        int len = estimateProtocolVersionLen(statline.getProtocolVersion())
            + 1 + 3 + 1; // room for "HTTP/1.1 200 "
        final String reason = statline.getReasonPhrase();
        if (reason != null) {
            len += reason.length();
        }
        buffer.ensureCapacity(len);

        appendProtocolVersion(buffer, statline.getProtocolVersion());
        buffer.append(' ');
        buffer.append(Integer.toString(statline.getStatusCode()));
        buffer.append(' '); // keep whitespace even if reason phrase is empty
        if (reason != null) {
            buffer.append(reason);
        }
    }


    // non-javadoc, see interface LineFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.118 -0500", hash_original_method = "D1D568624BAE5D479E93207457DBA769", hash_generated_method = "ABBE22CD73E36042399BAE0445D44DFE")
    public CharArrayBuffer formatHeader(CharArrayBuffer buffer,
                                        Header header) {
        if (header == null) {
            throw new IllegalArgumentException
                ("Header may not be null");
        }
        CharArrayBuffer result = null;

        if (header instanceof FormattedHeader) {
            // If the header is backed by a buffer, re-use the buffer
            result = ((FormattedHeader)header).getBuffer();
        } else {
            result = initBuffer(buffer);
            doFormatHeader(result, header);
        }
        return result;

    } // formatHeader


    /**
     * Actually formats a header.
     * Called from {@link #formatHeader}.
     *
     * @param buffer    the empty buffer into which to format,
     *                  never <code>null</code>
     * @param header    the header to format, never <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.119 -0500", hash_original_method = "5945CD23ACFD85646C236C445ADEE4F3", hash_generated_method = "8177BA1244F497D8A56C89770F3B650B")
    protected void doFormatHeader(final CharArrayBuffer buffer,
                                  final Header header) {
        final String name = header.getName();
        final String value = header.getValue();

        int len = name.length() + 2;
        if (value != null) {
            len += value.length();
        }
        buffer.ensureCapacity(len);

        buffer.append(name);
        buffer.append(": ");
        if (value != null) {
            buffer.append(value);
        }
    }
}

