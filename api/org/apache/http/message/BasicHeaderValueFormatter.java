package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;






public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.788 -0400", hash_original_method = "88ED703AD5842214D5052F930ED18AF6", hash_generated_method = "88ED703AD5842214D5052F930ED18AF6")
    public BasicHeaderValueFormatter ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public final static String formatElements(final HeaderElement[] elems,
                              final boolean quote,
                              HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatElements(null, elems, quote).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.789 -0400", hash_original_method = "3B962169F247D53704261A5A24F1A431", hash_generated_method = "057D0187E0768CCDBA74E05F1DE2027C")
    public CharArrayBuffer formatElements(CharArrayBuffer buffer,
                                          final HeaderElement[] elems,
                                          final boolean quote) {
        addTaint(quote);
        addTaint(elems[0].getTaint());
        addTaint(buffer.getTaint());
        if(elems == null)        
        {
            IllegalArgumentException var6D707BD8515CDA6B9DA15274F01073DE_1810429466 = new IllegalArgumentException
                ("Header element array must not be null.");
            var6D707BD8515CDA6B9DA15274F01073DE_1810429466.addTaint(taint);
            throw var6D707BD8515CDA6B9DA15274F01073DE_1810429466;
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
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_699731864 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_699731864.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_699731864;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.790 -0400", hash_original_method = "62CDCB67E7EC0B179AEAB50C07EF0602", hash_generated_method = "8444B2E487454AC73C9DD8D24749E409")
    protected int estimateElementsLen(final HeaderElement[] elems) {
        addTaint(elems[0].getTaint());
        if((elems == null) || (elems.length < 1))        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1104443595 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057211952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057211952;
        }
        int result = (elems.length-1) * 2;
for(int i=0;i<elems.length;i++)
        {
            result += estimateHeaderElementLen(elems[i]);
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_279236595 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322503986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322503986;
        // ---------- Original Method ----------
        //if ((elems == null) || (elems.length < 1))
            //return 0;
        //int result = (elems.length-1) * 2;
        //for (int i=0; i<elems.length; i++) {
            //result += estimateHeaderElementLen(elems[i]);
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    public final static String formatHeaderElement(final HeaderElement elem,
                                   boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatHeaderElement(null, elem, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.791 -0400", hash_original_method = "355882C41BE16D37B0209DA6D54CCB3E", hash_generated_method = "4C1FEB53C4CA98084AED5253153C4D2A")
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer,
                                               final HeaderElement elem,
                                               final boolean quote) {
        addTaint(quote);
        addTaint(elem.getTaint());
        addTaint(buffer.getTaint());
        if(elem == null)        
        {
            IllegalArgumentException varBA949992CEE23490EC32B9C602A0BD6E_961859480 = new IllegalArgumentException
                ("Header element must not be null.");
            varBA949992CEE23490EC32B9C602A0BD6E_961859480.addTaint(taint);
            throw varBA949992CEE23490EC32B9C602A0BD6E_961859480;
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
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_920462969 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_920462969.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_920462969;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.792 -0400", hash_original_method = "8E6899628E610E70351C174244187E71", hash_generated_method = "0F24D153E162073CC6CA5A642720AEEA")
    protected int estimateHeaderElementLen(final HeaderElement elem) {
        addTaint(elem.getTaint());
        if(elem == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1083537128 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872565905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872565905;
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
        int varB4A88417B3D0170D754C647C30B7216A_607412122 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669028660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669028660;
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

    
    @DSModeled(DSC.SAFE)
    public final static String formatParameters(final NameValuePair[] nvps,
                                final boolean quote,
                                HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatParameters(null, nvps, quote).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.794 -0400", hash_original_method = "7ECB2224BD638F620F916826D26E8E08", hash_generated_method = "9429941FD22A8D55ABFA58C35CD522A9")
    public CharArrayBuffer formatParameters(CharArrayBuffer buffer,
                                            NameValuePair[] nvps,
                                            boolean quote) {
        addTaint(quote);
        addTaint(nvps[0].getTaint());
        addTaint(buffer.getTaint());
        if(nvps == null)        
        {
            IllegalArgumentException var08D38DBCA08B6FB4CC571675E42E3D3C_1844263274 = new IllegalArgumentException
                ("Parameters must not be null.");
            var08D38DBCA08B6FB4CC571675E42E3D3C_1844263274.addTaint(taint);
            throw var08D38DBCA08B6FB4CC571675E42E3D3C_1844263274;
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
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_780645178 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_780645178.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_780645178;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.795 -0400", hash_original_method = "C68A0319865C468C0B8527915CD85227", hash_generated_method = "62EFA48EAEAFFAF244ED2281D37B86FF")
    protected int estimateParametersLen(final NameValuePair[] nvps) {
        addTaint(nvps[0].getTaint());
        if((nvps == null) || (nvps.length < 1))        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1237146701 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514643046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514643046;
        }
        int result = (nvps.length-1) * 2;
for(int i=0;i<nvps.length;i++)
        {
            result += estimateNameValuePairLen(nvps[i]);
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1020183458 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370097996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1370097996;
        // ---------- Original Method ----------
        //if ((nvps == null) || (nvps.length < 1))
            //return 0;
        //int result = (nvps.length-1) * 2;
        //for (int i=0; i<nvps.length; i++) {
            //result += estimateNameValuePairLen(nvps[i]);
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    public final static String formatNameValuePair(final NameValuePair nvp,
                                   final boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatNameValuePair(null, nvp, quote).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.796 -0400", hash_original_method = "0780CB3EF81283DFA07B40BE9042FB6E", hash_generated_method = "0E5F0ACC69D11195F191E5D69AE5FA94")
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer,
                                               final NameValuePair nvp,
                                               final boolean quote) {
        addTaint(quote);
        addTaint(nvp.getTaint());
        addTaint(buffer.getTaint());
        if(nvp == null)        
        {
            IllegalArgumentException varA1F8A6CE6808E68C9B992D6FC903119E_1818182126 = new IllegalArgumentException
                ("NameValuePair must not be null.");
            varA1F8A6CE6808E68C9B992D6FC903119E_1818182126.addTaint(taint);
            throw varA1F8A6CE6808E68C9B992D6FC903119E_1818182126;
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
CharArrayBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1808750356 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1808750356.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1808750356;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.797 -0400", hash_original_method = "91AA35E40301ABCAA7663733F9252D07", hash_generated_method = "312CEA6270F2D65AAE488FCC428F380A")
    protected int estimateNameValuePairLen(final NameValuePair nvp) {
        addTaint(nvp.getTaint());
        if(nvp == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_57895816 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993396916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993396916;
        }
        int result = nvp.getName().length();
        final String value = nvp.getValue();
        if(value != null)        
        {
            result += 3 + value.length();
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_721276201 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041631137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041631137;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.797 -0400", hash_original_method = "11FAB29668F5F530D34F327A08D6984E", hash_generated_method = "11B333DC0DF26D3A7F7EC853D25F9B6D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.798 -0400", hash_original_method = "541354ACFD70CC9FA3913AE1E29B9D2A", hash_generated_method = "DDF1EC967FE534FC831FAB52475FE046")
    protected boolean isSeparator(char ch) {
        addTaint(ch);
        boolean varAC113434AC91E6DC6AC175EDA7A204A2_766888669 = (SEPARATORS.indexOf(ch) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899326399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899326399;
        // ---------- Original Method ----------
        //return SEPARATORS.indexOf(ch) >= 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.799 -0400", hash_original_method = "8B650CEFA0EAACAAB9B471FC321305C5", hash_generated_method = "8F8291BDAFDB9FF604131BBA9BA64963")
    protected boolean isUnsafe(char ch) {
        addTaint(ch);
        boolean varF124CB936D13034F60493ECEBAF12FB1_1275996793 = (UNSAFE_CHARS.indexOf(ch) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223618347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223618347;
        // ---------- Original Method ----------
        //return UNSAFE_CHARS.indexOf(ch) >= 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.799 -0400", hash_original_field = "B32F5FD1BA49A8E63FFEF96B3A0A0C20", hash_generated_field = "87CD1F964F54FF38D274F82D32A3B239")

    public final static
        BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.799 -0400", hash_original_field = "B71391202C4389CBFFE3FBD230540CE0", hash_generated_field = "A7ED65FEAF3FE8A2CDE4A15F0B581CC9")

    public final static String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.799 -0400", hash_original_field = "EDAB28946017116F0FC318F67C7B369D", hash_generated_field = "9EFC8BAC7FF2406E13D9C9CA1C607AA5")

    public final static String UNSAFE_CHARS = "\"\\";
}

