package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;






public class BasicLineFormatter implements LineFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.925 -0400", hash_original_method = "8022E7B2B110A3478739271765EA4718", hash_generated_method = "8022E7B2B110A3478739271765EA4718")
    public BasicLineFormatter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.926 -0400", hash_original_method = "88607DBCC47E4B4D98332640E6FF147F", hash_generated_method = "50ACB207FCCAB1DC95A00BAC2DAE5789")
    protected CharArrayBuffer initBuffer(CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        if(buffer != null)        
        {
            buffer.clear();
        } //End block
        else
        {
            buffer = new CharArrayBuffer(64);
        } //End block
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_923146644 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_923146644.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_923146644;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.927 -0400", hash_original_method = "A0F2D5AC053D278723790680878C18C6", hash_generated_method = "B9AC0D5F7FD70474EA825ED76B6949BE")
    public CharArrayBuffer appendProtocolVersion(final CharArrayBuffer buffer,
                                                 final ProtocolVersion version) {
        addTaint(version.getTaint());
        addTaint(buffer.getTaint());
        if(version == null)        
        {
            IllegalArgumentException varF737F3A2E71D18506546E7DDB6A73FE6_1620664311 = new IllegalArgumentException
                ("Protocol version may not be null");
            varF737F3A2E71D18506546E7DDB6A73FE6_1620664311.addTaint(taint);
            throw varF737F3A2E71D18506546E7DDB6A73FE6_1620664311;
        } //End block
        CharArrayBuffer result = buffer;
        final int len = estimateProtocolVersionLen(version);
        if(result == null)        
        {
            result = new CharArrayBuffer(len);
        } //End block
        else
        {
            result.ensureCapacity(len);
        } //End block
        result.append(version.getProtocol());
        result.append('/');
        result.append(Integer.toString(version.getMajor()));
        result.append('.');
        result.append(Integer.toString(version.getMinor()));
CharArrayBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_331633846 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_331633846.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_331633846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.928 -0400", hash_original_method = "84522AAB157FB837ECA38AFA8517069A", hash_generated_method = "22A52263C246E7D6D7ABEEAF932C322D")
    protected int estimateProtocolVersionLen(final ProtocolVersion version) {
        addTaint(version.getTaint());
        int varF63604D5EC935185E5C11D3C268BAF12_275040079 = (version.getProtocol().length() + 4);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1075448749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1075448749;
        // ---------- Original Method ----------
        //return version.getProtocol().length() + 4;
    }

    
    public final static String formatRequestLine(final RequestLine reqline,
                                                 LineFormatter formatter) {
        if (formatter == null)
            formatter = BasicLineFormatter.DEFAULT;
        return formatter.formatRequestLine(null, reqline).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.929 -0400", hash_original_method = "19984FDC599EEB66F432BF4C8D33EB13", hash_generated_method = "E5440F8D70C23EAABAB72DB256AAB4AE")
    public CharArrayBuffer formatRequestLine(CharArrayBuffer buffer,
                                             RequestLine reqline) {
        addTaint(reqline.getTaint());
        addTaint(buffer.getTaint());
        if(reqline == null)        
        {
            IllegalArgumentException var57E7C227464A845296BA51EE2C094FE3_285947611 = new IllegalArgumentException
                ("Request line may not be null");
            var57E7C227464A845296BA51EE2C094FE3_285947611.addTaint(taint);
            throw var57E7C227464A845296BA51EE2C094FE3_285947611;
        } //End block
        CharArrayBuffer result = initBuffer(buffer);
        doFormatRequestLine(result, reqline);
CharArrayBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1495433838 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1495433838.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1495433838;
        // ---------- Original Method ----------
        //if (reqline == null) {
            //throw new IllegalArgumentException
                //("Request line may not be null");
        //}
        //CharArrayBuffer result = initBuffer(buffer);
        //doFormatRequestLine(result, reqline);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.930 -0400", hash_original_method = "1E31567E89FBC15B9220080016C6779D", hash_generated_method = "5C6CD29D248F38EE0C1375AB555AA7F3")
    protected void doFormatRequestLine(final CharArrayBuffer buffer,
                                       final RequestLine reqline) {
        addTaint(reqline.getTaint());
        addTaint(buffer.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.931 -0400", hash_original_method = "48A800039F857A6F8C24EAA9095C9D1B", hash_generated_method = "47F8380F9732D59D9A019AA066CE703B")
    public CharArrayBuffer formatStatusLine(final CharArrayBuffer buffer,
                                            final StatusLine statline) {
        addTaint(statline.getTaint());
        addTaint(buffer.getTaint());
        if(statline == null)        
        {
            IllegalArgumentException var1636A5AFF6F53BF0101E09315281948D_167624008 = new IllegalArgumentException
                ("Status line may not be null");
            var1636A5AFF6F53BF0101E09315281948D_167624008.addTaint(taint);
            throw var1636A5AFF6F53BF0101E09315281948D_167624008;
        } //End block
        CharArrayBuffer result = initBuffer(buffer);
        doFormatStatusLine(result, statline);
CharArrayBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1090352477 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1090352477.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1090352477;
        // ---------- Original Method ----------
        //if (statline == null) {
            //throw new IllegalArgumentException
                //("Status line may not be null");
        //}
        //CharArrayBuffer result = initBuffer(buffer);
        //doFormatStatusLine(result, statline);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.932 -0400", hash_original_method = "060574F84EC41767BDDD7A9C8F77F8CE", hash_generated_method = "8DDAD7270D3C4D37EBDE3773E784FFA5")
    protected void doFormatStatusLine(final CharArrayBuffer buffer,
                                      final StatusLine statline) {
        addTaint(statline.getTaint());
        addTaint(buffer.getTaint());
        int len = estimateProtocolVersionLen(statline.getProtocolVersion())
            + 1 + 3 + 1;
        final String reason = statline.getReasonPhrase();
        if(reason != null)        
        {
            len += reason.length();
        } //End block
        buffer.ensureCapacity(len);
        appendProtocolVersion(buffer, statline.getProtocolVersion());
        buffer.append(' ');
        buffer.append(Integer.toString(statline.getStatusCode()));
        buffer.append(' ');
        if(reason != null)        
        {
            buffer.append(reason);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.933 -0400", hash_original_method = "D1D568624BAE5D479E93207457DBA769", hash_generated_method = "BDB22B9365CB83DB2290FD74479D5B12")
    public CharArrayBuffer formatHeader(CharArrayBuffer buffer,
                                        Header header) {
        addTaint(header.getTaint());
        addTaint(buffer.getTaint());
        if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_639109694 = new IllegalArgumentException
                ("Header may not be null");
            var655E57DE77F969F763516260E292795B_639109694.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_639109694;
        } //End block
        CharArrayBuffer result = null;
        if(header instanceof FormattedHeader)        
        {
            result = ((FormattedHeader)header).getBuffer();
        } //End block
        else
        {
            result = initBuffer(buffer);
            doFormatHeader(result, header);
        } //End block
CharArrayBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1822822869 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1822822869.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1822822869;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.934 -0400", hash_original_method = "5945CD23ACFD85646C236C445ADEE4F3", hash_generated_method = "6524535C10E06475092019B3D3973DF7")
    protected void doFormatHeader(final CharArrayBuffer buffer,
                                  final Header header) {
        addTaint(header.getTaint());
        addTaint(buffer.getTaint());
        final String name = header.getName();
        final String value = header.getValue();
        int len = name.length() + 2;
        if(value != null)        
        {
            len += value.length();
        } //End block
        buffer.ensureCapacity(len);
        buffer.append(name);
        buffer.append(": ");
        if(value != null)        
        {
            buffer.append(value);
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.934 -0400", hash_original_field = "4E812101A2AB7EB3EF0FDB7BC86CAAC5", hash_generated_field = "B42F8A4CEDBB52474BB29599F82217A2")

    public final static BasicLineFormatter DEFAULT = new BasicLineFormatter();
}

