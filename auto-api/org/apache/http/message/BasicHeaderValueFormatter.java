package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.993 -0400", hash_original_method = "88ED703AD5842214D5052F930ED18AF6", hash_generated_method = "88ED703AD5842214D5052F930ED18AF6")
    public BasicHeaderValueFormatter ()
    {
        
    }


    public final static String formatElements(final HeaderElement[] elems,
                              final boolean quote,
                              HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatElements(null, elems, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.994 -0400", hash_original_method = "3B962169F247D53704261A5A24F1A431", hash_generated_method = "8846741D191F60CF47A8E8E2DBFB51D5")
    public CharArrayBuffer formatElements(CharArrayBuffer buffer,
                                          final HeaderElement[] elems,
                                          final boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1651236223 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header element array must not be null.");
        } 
        int len = estimateElementsLen(elems);
        {
            buffer = new CharArrayBuffer(len);
        } 
        {
            buffer.ensureCapacity(len);
        } 
        {
            int i = 0;
            {
                {
                    buffer.append(", ");
                } 
                formatHeaderElement(buffer, elems[i], quote);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1651236223 = buffer;
        addTaint(buffer.getTaint());
        addTaint(elems[0].getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_1651236223.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1651236223;
        
        
            
                
        
        
        
            
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.995 -0400", hash_original_method = "62CDCB67E7EC0B179AEAB50C07EF0602", hash_generated_method = "766742C8779064E77C77B7E0BAD00158")
    protected int estimateElementsLen(final HeaderElement[] elems) {
        int result = (elems.length-1) * 2;
        {
            int i = 0;
            {
                result += estimateHeaderElementLen(elems[i]);
            } 
        } 
        addTaint(elems[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896817924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896817924;
        
        
            
        
        
            
        
        
    }

    
    public final static String formatHeaderElement(final HeaderElement elem,
                                   boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatHeaderElement(null, elem, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.996 -0400", hash_original_method = "355882C41BE16D37B0209DA6D54CCB3E", hash_generated_method = "0ECCD25E56494873274044B20996D27B")
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer,
                                               final HeaderElement elem,
                                               final boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1546762363 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header element must not be null.");
        } 
        int len = estimateHeaderElementLen(elem);
        {
            buffer = new CharArrayBuffer(len);
        } 
        {
            buffer.ensureCapacity(len);
        } 
        buffer.append(elem.getName());
        final String value = elem.getValue();
        {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        } 
        final int parcnt = elem.getParameterCount();
        {
            {
                int i = 0;
                {
                    buffer.append("; ");
                    formatNameValuePair(buffer, elem.getParameter(i), quote);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1546762363 = buffer;
        addTaint(buffer.getTaint());
        addTaint(elem.getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_1546762363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1546762363;
        
        
            
                
        
        
        
            
        
            
        
        
        
        
            
            
        
        
        
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.996 -0400", hash_original_method = "8E6899628E610E70351C174244187E71", hash_generated_method = "E2F2173B287E55A665BB6A38A89453B2")
    protected int estimateHeaderElementLen(final HeaderElement elem) {
        int result = elem.getName().length();
        final String value = elem.getValue();
        {
            result += 3 + value.length();
        } 
        final int parcnt = elem.getParameterCount();
        {
            {
                int i = 0;
                {
                    result += 2 +                   
                    estimateNameValuePairLen(elem.getParameter(i));
                } 
            } 
        } 
        addTaint(elem.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888317226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888317226;
        
        
            
        
        
        
            
        
        
        
            
                
                    
            
        
        
    }

    
    public final static String formatParameters(final NameValuePair[] nvps,
                                final boolean quote,
                                HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatParameters(null, nvps, quote).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.998 -0400", hash_original_method = "7ECB2224BD638F620F916826D26E8E08", hash_generated_method = "E16E8AC7F47ECBA1C089A202E9AC44F4")
    public CharArrayBuffer formatParameters(CharArrayBuffer buffer,
                                            NameValuePair[] nvps,
                                            boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_776652721 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } 
        int len = estimateParametersLen(nvps);
        {
            buffer = new CharArrayBuffer(len);
        } 
        {
            buffer.ensureCapacity(len);
        } 
        {
            int i = 0;
            {
                {
                    buffer.append("; ");
                } 
                formatNameValuePair(buffer, nvps[i], quote);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_776652721 = buffer;
        addTaint(buffer.getTaint());
        addTaint(nvps[0].getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_776652721.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_776652721;
        
        
            
                
        
        
        
            
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.999 -0400", hash_original_method = "C68A0319865C468C0B8527915CD85227", hash_generated_method = "625F81BB4CD1679B37C46728622E86EC")
    protected int estimateParametersLen(final NameValuePair[] nvps) {
        int result = (nvps.length-1) * 2;
        {
            int i = 0;
            {
                result += estimateNameValuePairLen(nvps[i]);
            } 
        } 
        addTaint(nvps[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725787215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725787215;
        
        
            
        
        
            
        
        
    }

    
    public final static String formatNameValuePair(final NameValuePair nvp,
                                   final boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatNameValuePair(null, nvp, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.001 -0400", hash_original_method = "0780CB3EF81283DFA07B40BE9042FB6E", hash_generated_method = "EB7B7532B16EE0F150A504F2EE67117A")
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer,
                                               final NameValuePair nvp,
                                               final boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1021279765 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("NameValuePair must not be null.");
        } 
        int len = estimateNameValuePairLen(nvp);
        {
            buffer = new CharArrayBuffer(len);
        } 
        {
            buffer.ensureCapacity(len);
        } 
        buffer.append(nvp.getName());
        final String value = nvp.getValue();
        {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1021279765 = buffer;
        addTaint(buffer.getTaint());
        addTaint(nvp.getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_1021279765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1021279765;
        
        
            
                
        
        
        
            
        
            
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.002 -0400", hash_original_method = "91AA35E40301ABCAA7663733F9252D07", hash_generated_method = "EDAEA9DCDF92D74ABA1C3509CECAD09A")
    protected int estimateNameValuePairLen(final NameValuePair nvp) {
        int result = nvp.getName().length();
        final String value = nvp.getValue();
        {
            result += 3 + value.length();
        } 
        addTaint(nvp.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686695464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686695464;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.003 -0400", hash_original_method = "11FAB29668F5F530D34F327A08D6984E", hash_generated_method = "44A6D59964AD6610F0309251B4DF03EA")
    protected void doFormatValue(final CharArrayBuffer buffer,
                                 final String value,
                                 boolean quote) {
        {
            {
                int i = 0;
                boolean var95C0F713441F37F507EB36E95EAAF313_1396352007 = ((i < value.length()) && !quote);
                {
                    quote = isSeparator(value.charAt(i));
                } 
            } 
        } 
        {
            buffer.append('"');
        } 
        {
            int i = 0;
            boolean var014095120D63C9423806FA705979655B_727040565 = (i < value.length());
            {
                char ch = value.charAt(i);
                {
                    boolean varA6D7992DA1101680A672784A0E8A3647_872035257 = (isUnsafe(ch));
                    {
                        buffer.append('\\');
                    } 
                } 
                buffer.append(ch);
            } 
        } 
        {
            buffer.append('"');
        } 
        addTaint(buffer.getTaint());
        addTaint(value.getTaint());
        addTaint(quote);
        
        
            
                
            
        
        
            
        
        
            
            
                
            
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.003 -0400", hash_original_method = "541354ACFD70CC9FA3913AE1E29B9D2A", hash_generated_method = "BC12F5150F9B39BB27285E73B4D14763")
    protected boolean isSeparator(char ch) {
        boolean varC2161B73695B1EE124B60E5BB00919B4_936628067 = (SEPARATORS.indexOf(ch) >= 0);
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519521198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519521198;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.004 -0400", hash_original_method = "8B650CEFA0EAACAAB9B471FC321305C5", hash_generated_method = "6E7DC122B2E1EB33899DDD30A17DE37B")
    protected boolean isUnsafe(char ch) {
        boolean var559BC362A4DCF9DFFFDC98816E3F27ED_28080458 = (UNSAFE_CHARS.indexOf(ch) >= 0);
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767337991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_767337991;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.004 -0400", hash_original_field = "B32F5FD1BA49A8E63FFEF96B3A0A0C20", hash_generated_field = "87CD1F964F54FF38D274F82D32A3B239")

    public final static
        BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.004 -0400", hash_original_field = "B71391202C4389CBFFE3FBD230540CE0", hash_generated_field = "A7ED65FEAF3FE8A2CDE4A15F0B581CC9")

    public final static String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.004 -0400", hash_original_field = "EDAB28946017116F0FC318F67C7B369D", hash_generated_field = "9EFC8BAC7FF2406E13D9C9CA1C607AA5")

    public final static String UNSAFE_CHARS = "\"\\";
}

