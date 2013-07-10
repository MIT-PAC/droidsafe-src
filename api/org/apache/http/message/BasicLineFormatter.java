package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.Header;
import org.apache.http.FormattedHeader;
import org.apache.http.util.CharArrayBuffer;

public class BasicLineFormatter implements LineFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.126 -0400", hash_original_method = "8022E7B2B110A3478739271765EA4718", hash_generated_method = "8022E7B2B110A3478739271765EA4718")
    public BasicLineFormatter ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.127 -0400", hash_original_method = "88607DBCC47E4B4D98332640E6FF147F", hash_generated_method = "2E9859DA3B54989FFBF37F7942A69E76")
    protected CharArrayBuffer initBuffer(CharArrayBuffer buffer) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_382142851 = null; 
        {
            buffer.clear();
        } 
        {
            buffer = new CharArrayBuffer(64);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_382142851 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_382142851.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_382142851;
        
        
            
        
            
        
        
    }

    
    public final static String formatProtocolVersion(final ProtocolVersion version,
                                     LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.appendProtocolVersion(null, version).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.129 -0400", hash_original_method = "A0F2D5AC053D278723790680878C18C6", hash_generated_method = "512CC1615A71031D0388DEC0C591925C")
    public CharArrayBuffer appendProtocolVersion(final CharArrayBuffer buffer,
                                                 final ProtocolVersion version) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1168634317 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version may not be null");
        } 
        CharArrayBuffer result = buffer;
        final int len = estimateProtocolVersionLen(version);
        {
            result = new CharArrayBuffer(len);
        } 
        {
            result.ensureCapacity(len);
        } 
        result.append(version.getProtocol());
        result.append('/');
        result.append(Integer.toString(version.getMajor()));
        result.append('.');
        result.append(Integer.toString(version.getMinor()));
        varB4EAC82CA7396A68D541C85D26508E83_1168634317 = result;
        addTaint(buffer.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1168634317.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1168634317;
        
        
            
                
        
        
        
        
            
        
            
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.131 -0400", hash_original_method = "84522AAB157FB837ECA38AFA8517069A", hash_generated_method = "38C40C36E5119101EB12D4B8FFCB090E")
    protected int estimateProtocolVersionLen(final ProtocolVersion version) {
        int var8BA8F7D595857DF63FBD486C6413F0B2_142691027 = (version.getProtocol().length() + 4);
        addTaint(version.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963180239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963180239;
        
        
    }

    
    public final static String formatRequestLine(final RequestLine reqline,
                                                 LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatRequestLine(null, reqline).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.134 -0400", hash_original_method = "19984FDC599EEB66F432BF4C8D33EB13", hash_generated_method = "FFC1D76061ECB0345974F831FED3BCB4")
    public CharArrayBuffer formatRequestLine(CharArrayBuffer buffer,
                                             RequestLine reqline) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_628056953 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Request line may not be null");
        } 
        CharArrayBuffer result = initBuffer(buffer);
        doFormatRequestLine(result, reqline);
        varB4EAC82CA7396A68D541C85D26508E83_628056953 = result;
        addTaint(buffer.getTaint());
        addTaint(reqline.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_628056953.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_628056953;
        
        
            
                
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.134 -0400", hash_original_method = "1E31567E89FBC15B9220080016C6779D", hash_generated_method = "4A6303492292D4DFE09EB77EA299BCFD")
    protected void doFormatRequestLine(final CharArrayBuffer buffer,
                                       final RequestLine reqline) {
        final String method = reqline.getMethod();
        final String uri = reqline.getUri();
        int len = method.length() + 1 + uri.length() + 1 + 
            estimateProtocolVersionLen(reqline.getProtocolVersion());
        buffer.ensureCapacity(len);
        buffer.append(method);
        buffer.append(' ');
        buffer.append(uri);
        buffer.append(' ');
        appendProtocolVersion(buffer, reqline.getProtocolVersion());
        addTaint(buffer.getTaint());
        addTaint(reqline.getTaint());
        
        
        
        
            
        
        
        
        
        
        
    }

    
    public final static String formatStatusLine(final StatusLine statline,
                                                LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatStatusLine(null, statline).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.136 -0400", hash_original_method = "48A800039F857A6F8C24EAA9095C9D1B", hash_generated_method = "83CF66B97F7E5AB928DB6B47DEBBEFA2")
    public CharArrayBuffer formatStatusLine(final CharArrayBuffer buffer,
                                            final StatusLine statline) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_723208454 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Status line may not be null");
        } 
        CharArrayBuffer result = initBuffer(buffer);
        doFormatStatusLine(result, statline);
        varB4EAC82CA7396A68D541C85D26508E83_723208454 = result;
        addTaint(buffer.getTaint());
        addTaint(statline.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_723208454.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_723208454;
        
        
            
                
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.136 -0400", hash_original_method = "060574F84EC41767BDDD7A9C8F77F8CE", hash_generated_method = "E824A5A47CDF34F73B2ED2F31A4023F9")
    protected void doFormatStatusLine(final CharArrayBuffer buffer,
                                      final StatusLine statline) {
        int len = estimateProtocolVersionLen(statline.getProtocolVersion())
            + 1 + 3 + 1;
        final String reason = statline.getReasonPhrase();
        {
            len += reason.length();
        } 
        buffer.ensureCapacity(len);
        appendProtocolVersion(buffer, statline.getProtocolVersion());
        buffer.append(' ');
        buffer.append(Integer.toString(statline.getStatusCode()));
        buffer.append(' ');
        {
            buffer.append(reason);
        } 
        addTaint(buffer.getTaint());
        addTaint(statline.getTaint());
        
        
            
        
        
            
        
        
        
        
        
        
        
            
        
    }

    
    public final static String formatHeader(final Header header,
                                            LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatHeader(null, header).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.137 -0400", hash_original_method = "D1D568624BAE5D479E93207457DBA769", hash_generated_method = "D0902EFC03E24BD1EC7398DC5FD9259D")
    public CharArrayBuffer formatHeader(CharArrayBuffer buffer,
                                        Header header) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_908086631 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header may not be null");
        } 
        CharArrayBuffer result = null;
        {
            result = ((FormattedHeader)header).getBuffer();
        } 
        {
            result = initBuffer(buffer);
            doFormatHeader(result, header);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_908086631 = result;
        addTaint(buffer.getTaint());
        addTaint(header.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_908086631.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_908086631;
        
        
            
                
        
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.137 -0400", hash_original_method = "5945CD23ACFD85646C236C445ADEE4F3", hash_generated_method = "425055C2073E081E6ED441D811DC8211")
    protected void doFormatHeader(final CharArrayBuffer buffer,
                                  final Header header) {
        final String name = header.getName();
        final String value = header.getValue();
        int len = name.length() + 2;
        {
            len += value.length();
        } 
        buffer.ensureCapacity(len);
        buffer.append(name);
        buffer.append(": ");
        {
            buffer.append(value);
        } 
        addTaint(buffer.getTaint());
        addTaint(header.getTaint());
        
        
        
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.138 -0400", hash_original_field = "4E812101A2AB7EB3EF0FDB7BC86CAAC5", hash_generated_field = "B42F8A4CEDBB52474BB29599F82217A2")

    public final static BasicLineFormatter DEFAULT = new BasicLineFormatter();
}

