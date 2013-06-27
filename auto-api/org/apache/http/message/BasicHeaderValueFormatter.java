package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.918 -0400", hash_original_method = "88ED703AD5842214D5052F930ED18AF6", hash_generated_method = "88ED703AD5842214D5052F930ED18AF6")
    public BasicHeaderValueFormatter ()
    {
        //Synthesized constructor
    }


        public final static String formatElements(final HeaderElement[] elems,
                              final boolean quote,
                              HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatElements(null, elems, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.919 -0400", hash_original_method = "3B962169F247D53704261A5A24F1A431", hash_generated_method = "C6422DD570A7BEBF552F50C75AA08BCE")
    public CharArrayBuffer formatElements(CharArrayBuffer buffer,
                                          final HeaderElement[] elems,
                                          final boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_978613469 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header element array must not be null.");
        } //End block
        int len;
        len = estimateElementsLen(elems);
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        {
            buffer.ensureCapacity(len);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    buffer.append(", ");
                } //End block
                formatHeaderElement(buffer, elems[i], quote);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_978613469 = buffer;
        addTaint(buffer.getTaint());
        addTaint(elems[0].getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_978613469.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978613469;
        // ---------- Original Method ----------
        //if (elems == null) {
            //throw new IllegalArgumentException
                //("Header element array must not be null.");
        //}
        //int len = estimateElementsLen(elems);
        //if (buffer == null) {
            //buffer = new CharArrayBuffer(len);
        //} else {
            //buffer.ensureCapacity(len);
        //}
        //for (int i=0; i<elems.length; i++) {
            //if (i > 0) {
                //buffer.append(", ");
            //}
            //formatHeaderElement(buffer, elems[i], quote);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.920 -0400", hash_original_method = "62CDCB67E7EC0B179AEAB50C07EF0602", hash_generated_method = "5796B7CE4858D50F95A12EDCF9433ED4")
    protected int estimateElementsLen(final HeaderElement[] elems) {
        int result;
        result = (elems.length-1) * 2;
        {
            int i;
            i = 0;
            {
                result += estimateHeaderElementLen(elems[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(elems[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033887929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2033887929;
        // ---------- Original Method ----------
        //if ((elems == null) || (elems.length < 1))
            //return 0;
        //int result = (elems.length-1) * 2;
        //for (int i=0; i<elems.length; i++) {
            //result += estimateHeaderElementLen(elems[i]);
        //}
        //return result;
    }

    
        public final static String formatHeaderElement(final HeaderElement elem,
                                   boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatHeaderElement(null, elem, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.932 -0400", hash_original_method = "355882C41BE16D37B0209DA6D54CCB3E", hash_generated_method = "D5D455BEE250D417334AE4E5E53BE101")
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer,
                                               final HeaderElement elem,
                                               final boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_495668669 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Header element must not be null.");
        } //End block
        int len;
        len = estimateHeaderElementLen(elem);
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        {
            buffer.ensureCapacity(len);
        } //End block
        buffer.append(elem.getName());
        String value;
        value = elem.getValue();
        {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        } //End block
        int parcnt;
        parcnt = elem.getParameterCount();
        {
            {
                int i;
                i = 0;
                {
                    buffer.append("; ");
                    formatNameValuePair(buffer, elem.getParameter(i), quote);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_495668669 = buffer;
        addTaint(buffer.getTaint());
        addTaint(elem.getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_495668669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_495668669;
        // ---------- Original Method ----------
        //if (elem == null) {
            //throw new IllegalArgumentException
                //("Header element must not be null.");
        //}
        //int len = estimateHeaderElementLen(elem);
        //if (buffer == null) {
            //buffer = new CharArrayBuffer(len);
        //} else {
            //buffer.ensureCapacity(len);
        //}
        //buffer.append(elem.getName());
        //final String value = elem.getValue();
        //if (value != null) {
            //buffer.append('=');
            //doFormatValue(buffer, value, quote);
        //}
        //final int parcnt = elem.getParameterCount();
        //if (parcnt > 0) {
            //for (int i=0; i<parcnt; i++) {
                //buffer.append("; ");
                //formatNameValuePair(buffer, elem.getParameter(i), quote);
            //}
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.933 -0400", hash_original_method = "8E6899628E610E70351C174244187E71", hash_generated_method = "E2932A246C67B9EF97DA841FF6DF5664")
    protected int estimateHeaderElementLen(final HeaderElement elem) {
        int result;
        result = elem.getName().length();
        String value;
        value = elem.getValue();
        {
            result += 3 + value.length();
        } //End block
        int parcnt;
        parcnt = elem.getParameterCount();
        {
            {
                int i;
                i = 0;
                {
                    result += 2 +                   
                    estimateNameValuePairLen(elem.getParameter(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(elem.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462457151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462457151;
        // ---------- Original Method ----------
        //if (elem == null)
            //return 0;
        //int result = elem.getName().length();
        //final String value = elem.getValue();
        //if (value != null) {
            //result += 3 + value.length(); 
        //}
        //final int parcnt = elem.getParameterCount();
        //if (parcnt > 0) {
            //for (int i=0; i<parcnt; i++) {
                //result += 2 +                   
                    //estimateNameValuePairLen(elem.getParameter(i));
            //}
        //}
        //return result;
    }

    
        public final static String formatParameters(final NameValuePair[] nvps,
                                final boolean quote,
                                HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatParameters(null, nvps, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.944 -0400", hash_original_method = "7ECB2224BD638F620F916826D26E8E08", hash_generated_method = "CC950661D7E10B210218EE76665B2D92")
    public CharArrayBuffer formatParameters(CharArrayBuffer buffer,
                                            NameValuePair[] nvps,
                                            boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_1883285007 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameters must not be null.");
        } //End block
        int len;
        len = estimateParametersLen(nvps);
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        {
            buffer.ensureCapacity(len);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    buffer.append("; ");
                } //End block
                formatNameValuePair(buffer, nvps[i], quote);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1883285007 = buffer;
        addTaint(buffer.getTaint());
        addTaint(nvps[0].getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_1883285007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883285007;
        // ---------- Original Method ----------
        //if (nvps == null) {
            //throw new IllegalArgumentException
                //("Parameters must not be null.");
        //}
        //int len = estimateParametersLen(nvps);
        //if (buffer == null) {
            //buffer = new CharArrayBuffer(len);
        //} else {
            //buffer.ensureCapacity(len);
        //}
        //for (int i = 0; i < nvps.length; i++) {
            //if (i > 0) {
                //buffer.append("; ");
            //}
            //formatNameValuePair(buffer, nvps[i], quote);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.944 -0400", hash_original_method = "C68A0319865C468C0B8527915CD85227", hash_generated_method = "C0D632A42A50048972750437FDDF564B")
    protected int estimateParametersLen(final NameValuePair[] nvps) {
        int result;
        result = (nvps.length-1) * 2;
        {
            int i;
            i = 0;
            {
                result += estimateNameValuePairLen(nvps[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(nvps[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1386128083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1386128083;
        // ---------- Original Method ----------
        //if ((nvps == null) || (nvps.length < 1))
            //return 0;
        //int result = (nvps.length-1) * 2;
        //for (int i=0; i<nvps.length; i++) {
            //result += estimateNameValuePairLen(nvps[i]);
        //}
        //return result;
    }

    
        public final static String formatNameValuePair(final NameValuePair nvp,
                                   final boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatNameValuePair(null, nvp, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.945 -0400", hash_original_method = "0780CB3EF81283DFA07B40BE9042FB6E", hash_generated_method = "FE4E58CE763F89029A6D4C6509310FF9")
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer,
                                               final NameValuePair nvp,
                                               final boolean quote) {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_54783133 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("NameValuePair must not be null.");
        } //End block
        int len;
        len = estimateNameValuePairLen(nvp);
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        {
            buffer.ensureCapacity(len);
        } //End block
        buffer.append(nvp.getName());
        String value;
        value = nvp.getValue();
        {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_54783133 = buffer;
        addTaint(buffer.getTaint());
        addTaint(nvp.getTaint());
        addTaint(quote);
        varB4EAC82CA7396A68D541C85D26508E83_54783133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_54783133;
        // ---------- Original Method ----------
        //if (nvp == null) {
            //throw new IllegalArgumentException
                //("NameValuePair must not be null.");
        //}
        //int len = estimateNameValuePairLen(nvp);
        //if (buffer == null) {
            //buffer = new CharArrayBuffer(len);
        //} else {
            //buffer.ensureCapacity(len);
        //}
        //buffer.append(nvp.getName());
        //final String value = nvp.getValue();
        //if (value != null) {
            //buffer.append('=');
            //doFormatValue(buffer, value, quote);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.946 -0400", hash_original_method = "91AA35E40301ABCAA7663733F9252D07", hash_generated_method = "2EA2E58C1BF67F758ECDB1CA68FFE275")
    protected int estimateNameValuePairLen(final NameValuePair nvp) {
        int result;
        result = nvp.getName().length();
        String value;
        value = nvp.getValue();
        {
            result += 3 + value.length();
        } //End block
        addTaint(nvp.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790178446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790178446;
        // ---------- Original Method ----------
        //if (nvp == null)
            //return 0;
        //int result = nvp.getName().length();
        //final String value = nvp.getValue();
        //if (value != null) {
            //result += 3 + value.length(); 
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.946 -0400", hash_original_method = "11FAB29668F5F530D34F327A08D6984E", hash_generated_method = "34F5B2847A954A0990D9F201CEE03920")
    protected void doFormatValue(final CharArrayBuffer buffer,
                                 final String value,
                                 boolean quote) {
        {
            {
                int i;
                i = 0;
                boolean var95C0F713441F37F507EB36E95EAAF313_415476301 = ((i < value.length()) && !quote);
                {
                    quote = isSeparator(value.charAt(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            buffer.append('"');
        } //End block
        {
            int i;
            i = 0;
            boolean var014095120D63C9423806FA705979655B_1248254417 = (i < value.length());
            {
                char ch;
                ch = value.charAt(i);
                {
                    boolean varA6D7992DA1101680A672784A0E8A3647_861775326 = (isUnsafe(ch));
                    {
                        buffer.append('\\');
                    } //End block
                } //End collapsed parenthetic
                buffer.append(ch);
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append('"');
        } //End block
        addTaint(buffer.getTaint());
        addTaint(value.getTaint());
        addTaint(quote);
        // ---------- Original Method ----------
        //if (!quote) {
            //for (int i = 0; (i < value.length()) && !quote; i++) {
                //quote = isSeparator(value.charAt(i));
            //}
        //}
        //if (quote) {
            //buffer.append('"');
        //}
        //for (int i = 0; i < value.length(); i++) {
            //char ch = value.charAt(i);
            //if (isUnsafe(ch)) {
                //buffer.append('\\');
            //}
            //buffer.append(ch);
        //}
        //if (quote) {
            //buffer.append('"');
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.951 -0400", hash_original_method = "541354ACFD70CC9FA3913AE1E29B9D2A", hash_generated_method = "FF0D86744DB7111DD6F83261C16B1D57")
    protected boolean isSeparator(char ch) {
        boolean varC2161B73695B1EE124B60E5BB00919B4_1727827819 = (SEPARATORS.indexOf(ch) >= 0);
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628179150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628179150;
        // ---------- Original Method ----------
        //return SEPARATORS.indexOf(ch) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.952 -0400", hash_original_method = "8B650CEFA0EAACAAB9B471FC321305C5", hash_generated_method = "FFD3FC7C69B789F0DE0A4109225FFF1E")
    protected boolean isUnsafe(char ch) {
        boolean var559BC362A4DCF9DFFFDC98816E3F27ED_439356740 = (UNSAFE_CHARS.indexOf(ch) >= 0);
        addTaint(ch);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143643369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143643369;
        // ---------- Original Method ----------
        //return UNSAFE_CHARS.indexOf(ch) >= 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.952 -0400", hash_original_field = "B32F5FD1BA49A8E63FFEF96B3A0A0C20", hash_generated_field = "87CD1F964F54FF38D274F82D32A3B239")

    public final static
        BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.952 -0400", hash_original_field = "B71391202C4389CBFFE3FBD230540CE0", hash_generated_field = "A7ED65FEAF3FE8A2CDE4A15F0B581CC9")

    public final static String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.952 -0400", hash_original_field = "EDAB28946017116F0FC318F67C7B369D", hash_generated_field = "9EFC8BAC7FF2406E13D9C9CA1C607AA5")

    public final static String UNSAFE_CHARS = "\"\\";
}

