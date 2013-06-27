package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.Header;
import org.apache.http.FormattedHeader;
import org.apache.http.util.CharArrayBuffer;

public class BasicLineFormatter implements LineFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.004 -0400", hash_original_method = "8022E7B2B110A3478739271765EA4718", hash_generated_method = "8022E7B2B110A3478739271765EA4718")
    public BasicLineFormatter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.005 -0400", hash_original_method = "88607DBCC47E4B4D98332640E6FF147F", hash_generated_method = "6C203CAEF177F6230909B63FD71D390B")
    protected CharArrayBuffer initBuffer(CharArrayBuffer buffer) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_254517646 = null; //Variable for return #1
        {
            buffer.clear();
        } //End block
        {
            buffer = new CharArrayBuffer(64);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_254517646 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_254517646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_254517646;
        // ---------- Original Method ----------
        //if (buffer != null) {
            //buffer.clear();
        //} else {
            //buffer = new CharArrayBuffer(64);
        //}
        //return buffer;
    }

    
        public final static String formatProtocolVersion(final ProtocolVersion version,
                                     LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.appendProtocolVersion(null, version).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.008 -0400", hash_original_method = "A0F2D5AC053D278723790680878C18C6", hash_generated_method = "4F715B89630653962ABE9FB0BBB5CA99")
    public CharArrayBuffer appendProtocolVersion(final CharArrayBuffer buffer,
                                                 final ProtocolVersion version) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1837742290 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version may not be null");
        } //End block
        CharArrayBuffer result;
        result = buffer;
        int len;
        len = estimateProtocolVersionLen(version);
        {
            result = new CharArrayBuffer(len);
        } //End block
        {
            result.ensureCapacity(len);
        } //End block
        result.append(version.getProtocol());
        result.append('/');
        result.append(Integer.toString(version.getMajor()));
        result.append('.');
        result.append(Integer.toString(version.getMinor()));
        varB4EAC82CA7396A68D541C85D26508E83_1837742290 = result;
        addTaint(buffer.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1837742290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1837742290;
        // ---------- Original Method ----------
        //if (version == null) {
            //throw new IllegalArgumentException
                //("Protocol version may not be null");
        //}
        //CharArrayBuffer result = buffer;
        //final int len = estimateProtocolVersionLen(version);
        //if (result == null) {
            //result = new CharArrayBuffer(len);
        //} else {
            //result.ensureCapacity(len);
        //}
        //result.append(version.getProtocol());
        //result.append('/');
        //result.append(Integer.toString(version.getMajor()));
        //result.append('.');
        //result.append(Integer.toString(version.getMinor()));
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.008 -0400", hash_original_method = "84522AAB157FB837ECA38AFA8517069A", hash_generated_method = "8954C350FD76AC6E4EAAC171D2A60CBD")
    protected int estimateProtocolVersionLen(final ProtocolVersion version) {
        int var8BA8F7D595857DF63FBD486C6413F0B2_296291109 = (version.getProtocol().length() + 4);
        addTaint(version.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734854894 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734854894;
        // ---------- Original Method ----------
        //return version.getProtocol().length() + 4;
    }

    
        public final static String formatRequestLine(final RequestLine reqline,
                                                 LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatRequestLine(null, reqline).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.023 -0400", hash_original_method = "19984FDC599EEB66F432BF4C8D33EB13", hash_generated_method = "3AE6A8B4E2E44B44FB623BC0C692C181")
    public CharArrayBuffer formatRequestLine(CharArrayBuffer buffer,
                                             RequestLine reqline) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1403955562 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Request line may not be null");
        } //End block
        CharArrayBuffer result;
        result = initBuffer(buffer);
        doFormatRequestLine(result, reqline);
        varB4EAC82CA7396A68D541C85D26508E83_1403955562 = result;
        addTaint(buffer.getTaint());
        addTaint(reqline.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1403955562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1403955562;
        // ---------- Original Method ----------
        //if (reqline == null) {
            //throw new IllegalArgumentException
                //("Request line may not be null");
        //}
        //CharArrayBuffer result = initBuffer(buffer);
        //doFormatRequestLine(result, reqline);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.024 -0400", hash_original_method = "1E31567E89FBC15B9220080016C6779D", hash_generated_method = "4FE677FCAA4F2559B631775F1312CCDD")
    protected void doFormatRequestLine(final CharArrayBuffer buffer,
                                       final RequestLine reqline) {
        String method;
        method = reqline.getMethod();
        String uri;
        uri = reqline.getUri();
        int len;
        len = method.length() + 1 + uri.length() + 1 + 
            estimateProtocolVersionLen(reqline.getProtocolVersion());
        buffer.ensureCapacity(len);
        buffer.append(method);
        buffer.append(' ');
        buffer.append(uri);
        buffer.append(' ');
        appendProtocolVersion(buffer, reqline.getProtocolVersion());
        addTaint(buffer.getTaint());
        addTaint(reqline.getTaint());
        // ---------- Original Method ----------
        //final String method = reqline.getMethod();
        //final String uri    = reqline.getUri();
        //int len = method.length() + 1 + uri.length() + 1 + 
            //estimateProtocolVersionLen(reqline.getProtocolVersion());
        //buffer.ensureCapacity(len);
        //buffer.append(method);
        //buffer.append(' ');
        //buffer.append(uri);
        //buffer.append(' ');
        //appendProtocolVersion(buffer, reqline.getProtocolVersion());
    }

    
        public final static String formatStatusLine(final StatusLine statline,
                                                LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatStatusLine(null, statline).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.024 -0400", hash_original_method = "48A800039F857A6F8C24EAA9095C9D1B", hash_generated_method = "49C705A20A5CF4FBA1EE027995F4ECE4")
    public CharArrayBuffer formatStatusLine(final CharArrayBuffer buffer,
                                            final StatusLine statline) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1945059191 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Status line may not be null");
        } //End block
        CharArrayBuffer result;
        result = initBuffer(buffer);
        doFormatStatusLine(result, statline);
        varB4EAC82CA7396A68D541C85D26508E83_1945059191 = result;
        addTaint(buffer.getTaint());
        addTaint(statline.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1945059191.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1945059191;
        // ---------- Original Method ----------
        //if (statline == null) {
            //throw new IllegalArgumentException
                //("Status line may not be null");
        //}
        //CharArrayBuffer result = initBuffer(buffer);
        //doFormatStatusLine(result, statline);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.025 -0400", hash_original_method = "060574F84EC41767BDDD7A9C8F77F8CE", hash_generated_method = "8B4CA5E5E024FB6CEADCD7FE82008FD1")
    protected void doFormatStatusLine(final CharArrayBuffer buffer,
                                      final StatusLine statline) {
        int len;
        len = estimateProtocolVersionLen(statline.getProtocolVersion())
            + 1 + 3 + 1;
        String reason;
        reason = statline.getReasonPhrase();
        {
            len += reason.length();
        } //End block
        buffer.ensureCapacity(len);
        appendProtocolVersion(buffer, statline.getProtocolVersion());
        buffer.append(' ');
        buffer.append(Integer.toString(statline.getStatusCode()));
        buffer.append(' ');
        {
            buffer.append(reason);
        } //End block
        addTaint(buffer.getTaint());
        addTaint(statline.getTaint());
        // ---------- Original Method ----------
        //int len = estimateProtocolVersionLen(statline.getProtocolVersion())
            //+ 1 + 3 + 1;
        //final String reason = statline.getReasonPhrase();
        //if (reason != null) {
            //len += reason.length();
        //}
        //buffer.ensureCapacity(len);
        //appendProtocolVersion(buffer, statline.getProtocolVersion());
        //buffer.append(' ');
        //buffer.append(Integer.toString(statline.getStatusCode()));
        //buffer.append(' ');
        //if (reason != null) {
            //buffer.append(reason);
        //}
    }

    
        public final static String formatHeader(final Header header,
                                            LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatHeader(null, header).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.030 -0400", hash_original_method = "D1D568624BAE5D479E93207457DBA769", hash_generated_method = "3491AFACE79FBB813D5346FAE1CE4A04")
    public CharArrayBuffer formatHeader(CharArrayBuffer buffer,
                                        Header header) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_679325280 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header may not be null");
        } //End block
        CharArrayBuffer result;
        result = null;
        {
            result = ((FormattedHeader)header).getBuffer();
        } //End block
        {
            result = initBuffer(buffer);
            doFormatHeader(result, header);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_679325280 = result;
        addTaint(buffer.getTaint());
        addTaint(header.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_679325280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_679325280;
        // ---------- Original Method ----------
        //if (header == null) {
            //throw new IllegalArgumentException
                //("Header may not be null");
        //}
        //CharArrayBuffer result = null;
        //if (header instanceof FormattedHeader) {
            //result = ((FormattedHeader)header).getBuffer();
        //} else {
            //result = initBuffer(buffer);
            //doFormatHeader(result, header);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.031 -0400", hash_original_method = "5945CD23ACFD85646C236C445ADEE4F3", hash_generated_method = "AC7968A65FA2059ED1F5DDA32CD79DAD")
    protected void doFormatHeader(final CharArrayBuffer buffer,
                                  final Header header) {
        String name;
        name = header.getName();
        String value;
        value = header.getValue();
        int len;
        len = name.length() + 2;
        {
            len += value.length();
        } //End block
        buffer.ensureCapacity(len);
        buffer.append(name);
        buffer.append(": ");
        {
            buffer.append(value);
        } //End block
        addTaint(buffer.getTaint());
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //final String name = header.getName();
        //final String value = header.getValue();
        //int len = name.length() + 2;
        //if (value != null) {
            //len += value.length();
        //}
        //buffer.ensureCapacity(len);
        //buffer.append(name);
        //buffer.append(": ");
        //if (value != null) {
            //buffer.append(value);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.031 -0400", hash_original_field = "4E812101A2AB7EB3EF0FDB7BC86CAAC5", hash_generated_field = "B42F8A4CEDBB52474BB29599F82217A2")

    public final static BasicLineFormatter DEFAULT = new BasicLineFormatter();
}

