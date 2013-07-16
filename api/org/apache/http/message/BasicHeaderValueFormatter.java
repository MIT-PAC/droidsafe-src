package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.394 -0400", hash_original_method = "88ED703AD5842214D5052F930ED18AF6", hash_generated_method = "88ED703AD5842214D5052F930ED18AF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.395 -0400", hash_original_method = "3B962169F247D53704261A5A24F1A431", hash_generated_method = "5B441636843276B77E084DD2836352F4")
    public CharArrayBuffer formatElements(CharArrayBuffer buffer,
                                          final HeaderElement[] elems,
                                          final boolean quote) {
        addTaint(quote);
        addTaint(elems[0].getTaint());
        addTaint(buffer.getTaint());
    if(elems == null)        
        {
            IllegalArgumentException var6D707BD8515CDA6B9DA15274F01073DE_958281942 = new IllegalArgumentException
                ("Header element array must not be null.");
            var6D707BD8515CDA6B9DA15274F01073DE_958281942.addTaint(taint);
            throw var6D707BD8515CDA6B9DA15274F01073DE_958281942;
        } //End block
        int len = estimateElementsLen(elems);
    if(buffer == null)        
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        else
        {
            buffer.ensureCapacity(len);
        } //End block
for(int i=0;i<elems.length;i++)
        {
    if(i > 0)            
            {
                buffer.append(", ");
            } //End block
            formatHeaderElement(buffer, elems[i], quote);
        } //End block
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1169590738 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1169590738.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1169590738;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.396 -0400", hash_original_method = "62CDCB67E7EC0B179AEAB50C07EF0602", hash_generated_method = "2FC0830C4025563FC13290DB494CD865")
    protected int estimateElementsLen(final HeaderElement[] elems) {
        addTaint(elems[0].getTaint());
    if((elems == null) || (elems.length < 1))        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_16111957 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728863503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728863503;
        }
        int result = (elems.length-1) * 2;
for(int i=0;i<elems.length;i++)
        {
            result += estimateHeaderElementLen(elems[i]);
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_492057875 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919533048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919533048;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.398 -0400", hash_original_method = "355882C41BE16D37B0209DA6D54CCB3E", hash_generated_method = "D6932EBF09154C06E3CD17CF8FE0A4CB")
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer,
                                               final HeaderElement elem,
                                               final boolean quote) {
        addTaint(quote);
        addTaint(elem.getTaint());
        addTaint(buffer.getTaint());
    if(elem == null)        
        {
            IllegalArgumentException varBA949992CEE23490EC32B9C602A0BD6E_1081638887 = new IllegalArgumentException
                ("Header element must not be null.");
            varBA949992CEE23490EC32B9C602A0BD6E_1081638887.addTaint(taint);
            throw varBA949992CEE23490EC32B9C602A0BD6E_1081638887;
        } //End block
        int len = estimateHeaderElementLen(elem);
    if(buffer == null)        
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        else
        {
            buffer.ensureCapacity(len);
        } //End block
        buffer.append(elem.getName());
        final String value = elem.getValue();
    if(value != null)        
        {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        } //End block
        final int parcnt = elem.getParameterCount();
    if(parcnt > 0)        
        {
for(int i=0;i<parcnt;i++)
            {
                buffer.append("; ");
                formatNameValuePair(buffer, elem.getParameter(i), quote);
            } //End block
        } //End block
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_214870945 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_214870945.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_214870945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.400 -0400", hash_original_method = "8E6899628E610E70351C174244187E71", hash_generated_method = "EAE46AF662E3A49239551187ECFC4762")
    protected int estimateHeaderElementLen(final HeaderElement elem) {
        addTaint(elem.getTaint());
    if(elem == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_2059198691 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246503946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1246503946;
        }
        int result = elem.getName().length();
        final String value = elem.getValue();
    if(value != null)        
        {
            result += 3 + value.length();
        } //End block
        final int parcnt = elem.getParameterCount();
    if(parcnt > 0)        
        {
for(int i=0;i<parcnt;i++)
            {
                result += 2 +                   
                    estimateNameValuePairLen(elem.getParameter(i));
            } //End block
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1960646829 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408384588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408384588;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.402 -0400", hash_original_method = "7ECB2224BD638F620F916826D26E8E08", hash_generated_method = "4F007819C4DDCF3950DD198D605988BF")
    public CharArrayBuffer formatParameters(CharArrayBuffer buffer,
                                            NameValuePair[] nvps,
                                            boolean quote) {
        addTaint(quote);
        addTaint(nvps[0].getTaint());
        addTaint(buffer.getTaint());
    if(nvps == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_106241579 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_106241579.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_106241579;
        } //End block
        int len = estimateParametersLen(nvps);
    if(buffer == null)        
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        else
        {
            buffer.ensureCapacity(len);
        } //End block
for(int i = 0;i < nvps.length;i++)
        {
    if(i > 0)            
            {
                buffer.append("; ");
            } //End block
            formatNameValuePair(buffer, nvps[i], quote);
        } //End block
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2100508571 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_2100508571.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2100508571;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.404 -0400", hash_original_method = "C68A0319865C468C0B8527915CD85227", hash_generated_method = "A03E4A91AAE02F180277E5177847213B")
    protected int estimateParametersLen(final NameValuePair[] nvps) {
        addTaint(nvps[0].getTaint());
    if((nvps == null) || (nvps.length < 1))        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1333616022 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203552555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1203552555;
        }
        int result = (nvps.length-1) * 2;
for(int i=0;i<nvps.length;i++)
        {
            result += estimateNameValuePairLen(nvps[i]);
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1005115624 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011888564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011888564;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.405 -0400", hash_original_method = "0780CB3EF81283DFA07B40BE9042FB6E", hash_generated_method = "980915F9296257C33655C157819F48CC")
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer,
                                               final NameValuePair nvp,
                                               final boolean quote) {
        addTaint(quote);
        addTaint(nvp.getTaint());
        addTaint(buffer.getTaint());
    if(nvp == null)        
        {
            IllegalArgumentException varA1F8A6CE6808E68C9B992D6FC903119E_2102473921 = new IllegalArgumentException
                ("NameValuePair must not be null.");
            varA1F8A6CE6808E68C9B992D6FC903119E_2102473921.addTaint(taint);
            throw varA1F8A6CE6808E68C9B992D6FC903119E_2102473921;
        } //End block
        int len = estimateNameValuePairLen(nvp);
    if(buffer == null)        
        {
            buffer = new CharArrayBuffer(len);
        } //End block
        else
        {
            buffer.ensureCapacity(len);
        } //End block
        buffer.append(nvp.getName());
        final String value = nvp.getValue();
    if(value != null)        
        {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        } //End block
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1100984869 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1100984869.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1100984869;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.406 -0400", hash_original_method = "91AA35E40301ABCAA7663733F9252D07", hash_generated_method = "0051B2F08A2E4F560B1CB39FDCA5C1BC")
    protected int estimateNameValuePairLen(final NameValuePair nvp) {
        addTaint(nvp.getTaint());
    if(nvp == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_414713832 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2134258072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2134258072;
        }
        int result = nvp.getName().length();
        final String value = nvp.getValue();
    if(value != null)        
        {
            result += 3 + value.length();
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1097233836 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403206214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403206214;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.407 -0400", hash_original_method = "11FAB29668F5F530D34F327A08D6984E", hash_generated_method = "11B333DC0DF26D3A7F7EC853D25F9B6D")
    protected void doFormatValue(final CharArrayBuffer buffer,
                                 final String value,
                                 boolean quote) {
        addTaint(quote);
        addTaint(value.getTaint());
        addTaint(buffer.getTaint());
    if(!quote)        
        {
for(int i = 0;(i < value.length()) && !quote;i++)
            {
                quote = isSeparator(value.charAt(i));
            } //End block
        } //End block
    if(quote)        
        {
            buffer.append('"');
        } //End block
for(int i = 0;i < value.length();i++)
        {
            char ch = value.charAt(i);
    if(isUnsafe(ch))            
            {
                buffer.append('\\');
            } //End block
            buffer.append(ch);
        } //End block
    if(quote)        
        {
            buffer.append('"');
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.407 -0400", hash_original_method = "541354ACFD70CC9FA3913AE1E29B9D2A", hash_generated_method = "73E75CBCA3F3B3825604B7E2F5B786C9")
    protected boolean isSeparator(char ch) {
        addTaint(ch);
        boolean varAC113434AC91E6DC6AC175EDA7A204A2_1139209236 = (SEPARATORS.indexOf(ch) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395039352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395039352;
        // ---------- Original Method ----------
        //return SEPARATORS.indexOf(ch) >= 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.407 -0400", hash_original_method = "8B650CEFA0EAACAAB9B471FC321305C5", hash_generated_method = "E63D00D28FE89CDAF58E5B87B0533FC1")
    protected boolean isUnsafe(char ch) {
        addTaint(ch);
        boolean varF124CB936D13034F60493ECEBAF12FB1_1946513062 = (UNSAFE_CHARS.indexOf(ch) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393915393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393915393;
        // ---------- Original Method ----------
        //return UNSAFE_CHARS.indexOf(ch) >= 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.408 -0400", hash_original_field = "B32F5FD1BA49A8E63FFEF96B3A0A0C20", hash_generated_field = "87CD1F964F54FF38D274F82D32A3B239")

    public final static
        BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.408 -0400", hash_original_field = "B71391202C4389CBFFE3FBD230540CE0", hash_generated_field = "A7ED65FEAF3FE8A2CDE4A15F0B581CC9")

    public final static String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.408 -0400", hash_original_field = "EDAB28946017116F0FC318F67C7B369D", hash_generated_field = "9EFC8BAC7FF2406E13D9C9CA1C607AA5")

    public final static String UNSAFE_CHARS = "\"\\";
}

