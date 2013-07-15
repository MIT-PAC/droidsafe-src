package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.DuplicateNameValueList;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.GenericURI;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;
import javax.sip.header.Parameters;

public abstract class ParametersHeader extends SIPHeader implements javax.sip.header.Parameters, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.662 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.662 -0400", hash_original_field = "F5FECD842ADEDCE379FA16D3177B6626", hash_generated_field = "2A6C410AA135B90D8494B5D88641CA12")

    protected DuplicateNameValueList duplicates;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.663 -0400", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "10DB31FD032678791D17A89BE2F8FCA2")
    protected  ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.663 -0400", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "F2454A12911238A788F750FE54C02479")
    protected  ParametersHeader(String hdrName) {
        super(hdrName);
        addTaint(hdrName.getTaint());
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.664 -0400", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "958A4A124848D5D203F68C42C1BE913E")
    protected  ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        addTaint(hdrName.getTaint());
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList(sync);
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.664 -0400", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "662286513318523740D6E72C451C7E61")
    public String getParameter(String name) {
        addTaint(name.getTaint());
String var8A1749FAD7B99F8EBC5597D3A1804F80_67676649 =         this.parameters.getParameter(name);
        var8A1749FAD7B99F8EBC5597D3A1804F80_67676649.addTaint(taint);
        return var8A1749FAD7B99F8EBC5597D3A1804F80_67676649;
        // ---------- Original Method ----------
        //return this.parameters.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.665 -0400", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "6EEE51521E2F04EDB20E0C226C2890F1")
    public Object getParameterValue(String name) {
        addTaint(name.getTaint());
Object varBC9779CAE1B0B3F377A7233BBF31E6E3_1623991453 =         this.parameters.getValue(name);
        varBC9779CAE1B0B3F377A7233BBF31E6E3_1623991453.addTaint(taint);
        return varBC9779CAE1B0B3F377A7233BBF31E6E3_1623991453;
        // ---------- Original Method ----------
        //return this.parameters.getValue(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.665 -0400", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "8FA157B2CB30040B9291643C0169A1AD")
    public Iterator<String> getParameterNames() {
Iterator<String> var77947D245EC7574A1CEE7335325FA03A_1348663904 =         parameters.getNames();
        var77947D245EC7574A1CEE7335325FA03A_1348663904.addTaint(taint);
        return var77947D245EC7574A1CEE7335325FA03A_1348663904;
        // ---------- Original Method ----------
        //return parameters.getNames();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.665 -0400", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "0B9B6C1442404F79CE824C29F1585F28")
    public boolean hasParameters() {
        boolean varE78CA04AAABFA12049DF42B6393D6408_1216978074 = (parameters != null && !parameters.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636878709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636878709;
        // ---------- Original Method ----------
        //return parameters != null && !parameters.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.666 -0400", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "BF3C79E07ED38C8C068CCF75F4E53C6E")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        this.parameters.delete(name);
        // ---------- Original Method ----------
        //this.parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.666 -0400", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "86403B3A66D4B6EEBA4A6D8C1DE78B17")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = parameters.getNameValue(name);
    if(nv != null)        
        {
            nv.setValueAsObject(value);
        } //End block
        else
        {
            nv = new NameValue(name, value);
            this.parameters.set(nv);
        } //End block
        // ---------- Original Method ----------
        //NameValue nv = parameters.getNameValue(name);
        //if (nv != null) {
            //nv.setValueAsObject(value);
        //} else {
            //nv = new NameValue(name, value);
            //this.parameters.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.667 -0400", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "3F2F907D08715BCCDDC137A4243D9384")
    public void setQuotedParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = parameters.getNameValue(name);
    if(nv != null)        
        {
            nv.setValueAsObject(value);
            nv.setQuotedValue();
        } //End block
        else
        {
            nv = new NameValue(name, value);
            nv.setQuotedValue();
            this.parameters.set(nv);
        } //End block
        // ---------- Original Method ----------
        //NameValue nv = parameters.getNameValue(name);
        //if (nv != null) {
            //nv.setValueAsObject(value);
            //nv.setQuotedValue();
        //} else {
            //nv = new NameValue(name, value);
            //nv.setQuotedValue();
            //this.parameters.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.667 -0400", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "C5AA3A51996199F1EDD14512F2328A4B")
    protected void setParameter(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        Integer val = Integer.valueOf(value);
        this.parameters.set(name,val);
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.668 -0400", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "FF8208D1A6A68346CF4B4BE17B86D984")
    protected void setParameter(String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        Boolean val = Boolean.valueOf(value);
        this.parameters.set(name,val);
        // ---------- Original Method ----------
        //Boolean val = Boolean.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.678 -0400", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "31F80637715B0377779C13FC4463CB6D")
    protected void setParameter(String name, float value) {
        addTaint(value);
        addTaint(name.getTaint());
        Float val = Float.valueOf(value);
        NameValue nv = parameters.getNameValue(name);
    if(nv != null)        
        {
            nv.setValueAsObject(val);
        } //End block
        else
        {
            nv = new NameValue(name, val);
            this.parameters.set(nv);
        } //End block
        // ---------- Original Method ----------
        //Float val = Float.valueOf(value);
        //NameValue nv = parameters.getNameValue(name);
        //if (nv != null) {
            //nv.setValueAsObject(val);
        //} else {
            //nv = new NameValue(name, val);
            //this.parameters.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.678 -0400", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "0ACEA7F53073B73B19BEA9AAB3724081")
    protected void setParameter(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        this.parameters.set(name,value);
        // ---------- Original Method ----------
        //this.parameters.set(name,value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.679 -0400", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "D2B905DDF5678BF57359DC94D856B8D9")
    public boolean hasParameter(String parameterName) {
        addTaint(parameterName.getTaint());
        boolean varD55E94CFFD8E7B4F76EC489FF32C412F_1888312552 = (this.parameters.hasNameValue(parameterName));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686241245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_686241245;
        // ---------- Original Method ----------
        //return this.parameters.hasNameValue(parameterName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.679 -0400", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "3176E2C5AADE4344A52763E0CD3017CC")
    public void removeParameters() {
        this.parameters = new NameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.679 -0400", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "B6675E566A687590EB57F7FDD127A537")
    public NameValueList getParameters() {
NameValueList var3CB0A38B794BDEDADB1F50256E0AE35B_718652248 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_718652248.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_718652248;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.680 -0400", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "DE8A606608AC93825A7D19B444AEB299")
    public void setParameter(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.parameters.set(nameValue);
        // ---------- Original Method ----------
        //this.parameters.set(nameValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.680 -0400", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "4804A4F492C9506D4B5EB3825EC6EDA1")
    public void setParameters(NameValueList parameters) {
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.680 -0400", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "41431B9E9A9EBD5388EEBB7D4EEC1745")
    protected int getParameterAsInt(String parameterName) {
        addTaint(parameterName.getTaint());
    if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
    if(this.getParameterValue(parameterName) instanceof String)                
                {
                    int varE1AE32D9799EC6865803FCF788ED2E38_599427383 = (Integer.parseInt(this.getParameter(parameterName)));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769353723 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1769353723;
                } //End block
                else
                {
                    int varB6E3EA7438256A4A2A39E66BF48F9B95_2074518050 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725655684 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725655684;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_63984487 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_472489694 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_472489694;
            } //End block
        } //End block
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_310437600 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701447009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701447009;
        }
        // ---------- Original Method ----------
        //if (this.getParameterValue(parameterName) != null) {
            //try {
                //if (this.getParameterValue(parameterName) instanceof String) {
                    //return Integer.parseInt(this.getParameter(parameterName));
                //} else {
                    //return ((Integer) getParameterValue(parameterName))
                        //.intValue();
                //}
            //} catch (NumberFormatException ex) {
                //return -1;
            //}
        //} else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.682 -0400", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "10787BAB40C07F7055EBFD6BCAA7DDF4")
    protected int getParameterAsHexInt(String parameterName) {
        addTaint(parameterName.getTaint());
    if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
    if(this.getParameterValue(parameterName) instanceof String)                
                {
                    int var520CA95BBC5A38C7BC8F7A25622A412E_330102951 = (Integer.parseInt(
                        this.getParameter(parameterName),
                        16));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549654120 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549654120;
                } //End block
                else
                {
                    int varB6E3EA7438256A4A2A39E66BF48F9B95_1389071523 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439162682 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439162682;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_311442650 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922229388 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1922229388;
            } //End block
        } //End block
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_351757351 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092912872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092912872;
        }
        // ---------- Original Method ----------
        //if (this.getParameterValue(parameterName) != null) {
            //try {
                //if (this.getParameterValue(parameterName) instanceof String) {
                    //return Integer.parseInt(
                        //this.getParameter(parameterName),
                        //16);
                //} else {
                    //return ((Integer) getParameterValue(parameterName))
                        //.intValue();
                //}
            //} catch (NumberFormatException ex) {
                //return -1;
            //}
        //} else
            //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.683 -0400", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "3A87846521A77C44712346B938AFB765")
    protected float getParameterAsFloat(String parameterName) {
        addTaint(parameterName.getTaint());
    if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
    if(this.getParameterValue(parameterName) instanceof String)                
                {
                    float varA1C76E3F83DEAFAEF57046A793100846_470130611 = (Float.parseFloat(this.getParameter(parameterName)));
                                        float var546ADE640B6EDFBC8A086EF31347E768_1601411360 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_1601411360;
                } //End block
                else
                {
                    float varCDBEE4864421A8883CBABDDB7B295C77_2087754139 = (((Float) getParameterValue(parameterName))
                        .floatValue());
                                        float var546ADE640B6EDFBC8A086EF31347E768_2004572325 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_2004572325;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                float var6BB61E3B7BCE0931DA574D19D1D82C88_762889428 = (-1);
                                float var546ADE640B6EDFBC8A086EF31347E768_1953066057 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1953066057;
            } //End block
        } //End block
        else
        {
        float var6BB61E3B7BCE0931DA574D19D1D82C88_1774096658 = (-1);
                float var546ADE640B6EDFBC8A086EF31347E768_1912715162 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1912715162;
        }
        // ---------- Original Method ----------
        //if (this.getParameterValue(parameterName) != null) {
            //try {
                //if (this.getParameterValue(parameterName) instanceof String) {
                    //return Float.parseFloat(this.getParameter(parameterName));
                //} else {
                    //return ((Float) getParameterValue(parameterName))
                        //.floatValue();
                //}
            //} catch (NumberFormatException ex) {
                //return -1;
            //}
        //} else
            //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.683 -0400", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "843E2785C77D7E05006F8B8066B78B79")
    protected long getParameterAsLong(String parameterName) {
        addTaint(parameterName.getTaint());
    if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
    if(this.getParameterValue(parameterName) instanceof String)                
                {
                    long var83D47843416B806A6BDBD77A79E9894F_1843721904 = (Long.parseLong(this.getParameter(parameterName)));
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1885186956 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1885186956;
                } //End block
                else
                {
                    long var9AFE6145308AB8E095A181CE2C9011F5_1533835412 = (((Long) getParameterValue(parameterName))
                        .longValue());
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_882675601 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_882675601;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1111664801 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1946917618 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1946917618;
            } //End block
        } //End block
        else
        {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_233281662 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_367474531 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_367474531;
        }
        // ---------- Original Method ----------
        //if (this.getParameterValue(parameterName) != null) {
            //try {
                //if (this.getParameterValue(parameterName) instanceof String) {
                    //return Long.parseLong(this.getParameter(parameterName));
                //} else {
                    //return ((Long) getParameterValue(parameterName))
                        //.longValue();
                //}
            //} catch (NumberFormatException ex) {
                //return -1;
            //}
        //} else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.684 -0400", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "3BEBADF5FC793A943893D7A2EA396FA4")
    protected GenericURI getParameterAsURI(String parameterName) {
        addTaint(parameterName.getTaint());
        Object val = getParameterValue(parameterName);
    if(val instanceof GenericURI)        
        {
GenericURI varFA532447BD104689BA97989E2356EBFB_1388306287 =         (GenericURI) val;
        varFA532447BD104689BA97989E2356EBFB_1388306287.addTaint(taint);
        return varFA532447BD104689BA97989E2356EBFB_1388306287;
        }
        else
        {
            try 
            {
GenericURI var57A8BC3E993C4A8DAC635478C0AA826A_908602687 =                 new GenericURI((String) val);
                var57A8BC3E993C4A8DAC635478C0AA826A_908602687.addTaint(taint);
                return var57A8BC3E993C4A8DAC635478C0AA826A_908602687;
            } //End block
            catch (ParseException ex)
            {
GenericURI var540C13E9E156B687226421B24F2DF178_895842782 =                 null;
                var540C13E9E156B687226421B24F2DF178_895842782.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_895842782;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object val = getParameterValue(parameterName);
        //if (val instanceof GenericURI)
            //return (GenericURI) val;
        //else {
            //try {
                //return new GenericURI((String) val);
            //} catch (ParseException ex) {
                //return null;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.684 -0400", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "455F58F4161175C82F4090584D51EFE8")
    protected boolean getParameterAsBoolean(String parameterName) {
        addTaint(parameterName.getTaint());
        Object val = getParameterValue(parameterName);
    if(val == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2016018688 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089577507 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089577507;
        } //End block
        else
    if(val instanceof Boolean)        
        {
            boolean var0B144680FB3BC875E9E2B28FA61BBD52_1557806584 = (((Boolean) val).booleanValue());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483635217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_483635217;
        } //End block
        else
    if(val instanceof String)        
        {
            boolean var90D07544EBC61B33AC2D18D508BEEB76_1018612000 = (Boolean.valueOf((String) val).booleanValue());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952463053 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_952463053;
        } //End block
        else
        {
        boolean var68934A3E9455FA72420237EB05902327_920447749 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113961899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113961899;
        }
        // ---------- Original Method ----------
        //Object val = getParameterValue(parameterName);
        //if (val == null) {
            //return false;
        //} else if (val instanceof Boolean) {
            //return ((Boolean) val).booleanValue();
        //} else if (val instanceof String) {
            //return Boolean.valueOf((String) val).booleanValue();
        //} else
            //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.684 -0400", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "94064DF78EAC5BFF3FF12ADC1DA6B11F")
    public NameValue getNameValue(String parameterName) {
        addTaint(parameterName.getTaint());
NameValue varEF5E994C04E75B8B4EA6C33DDA055061_1112483521 =         parameters.getNameValue(parameterName);
        varEF5E994C04E75B8B4EA6C33DDA055061_1112483521.addTaint(taint);
        return varEF5E994C04E75B8B4EA6C33DDA055061_1112483521;
        // ---------- Original Method ----------
        //return parameters.getNameValue(parameterName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.684 -0400", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "96EDB0086471D7D30D0143B5A6DB9C6F")
    public Object clone() {
        ParametersHeader retval = (ParametersHeader) super.clone();
    if(this.parameters != null)        
        retval.parameters = (NameValueList) this.parameters.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_44192794 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_44192794.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_44192794;
        // ---------- Original Method ----------
        //ParametersHeader retval = (ParametersHeader) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "9D0AE3B447F81E94CEDBA426796E5C2E")
    public void setMultiParameter(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nv = new NameValue();
        nv.setName(name);
        nv.setValue(value);
        duplicates.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue();
        //nv.setName(name);
        //nv.setValue(value);
        //duplicates.set(nv);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "622379517747DFF65293F274774F086E")
    public void setMultiParameter(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.duplicates.set(nameValue);
        // ---------- Original Method ----------
        //this.duplicates.set(nameValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "DC007F430DC8DCE124D871C79B4EA710")
    public String getMultiParameter(String name) {
        addTaint(name.getTaint());
String var0FA821C9ECD09BA15988E2EC17BD3FE5_1637079407 =         this.duplicates.getParameter(name);
        var0FA821C9ECD09BA15988E2EC17BD3FE5_1637079407.addTaint(taint);
        return var0FA821C9ECD09BA15988E2EC17BD3FE5_1637079407;
        // ---------- Original Method ----------
        //return this.duplicates.getParameter(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "54D80CB3F1D83AB9A263BBD50CE4154D")
    public DuplicateNameValueList getMultiParameters() {
DuplicateNameValueList var5BDA0BC0D1D0A85895335C7E572C371A_793585705 =         duplicates;
        var5BDA0BC0D1D0A85895335C7E572C371A_793585705.addTaint(taint);
        return var5BDA0BC0D1D0A85895335C7E572C371A_793585705;
        // ---------- Original Method ----------
        //return duplicates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "A0F3108A137E9147A8600990D9DAF529")
    public Object getMultiParameterValue(String name) {
        addTaint(name.getTaint());
Object varB6921D10A49072688DDAA4B0ED17F658_536688930 =         this.duplicates.getValue(name);
        varB6921D10A49072688DDAA4B0ED17F658_536688930.addTaint(taint);
        return varB6921D10A49072688DDAA4B0ED17F658_536688930;
        // ---------- Original Method ----------
        //return this.duplicates.getValue(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "8C82610FC674D0C7FA82A3836033BB1F")
    public Iterator<String> getMultiParameterNames() {
Iterator<String> var5015060E52232B6144F92024DB04D587_1544243182 =         duplicates.getNames();
        var5015060E52232B6144F92024DB04D587_1544243182.addTaint(taint);
        return var5015060E52232B6144F92024DB04D587_1544243182;
        // ---------- Original Method ----------
        //return duplicates.getNames();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "6AD47E008D655449ED1C316EB5ABF671")
    public boolean hasMultiParameters() {
        boolean var053FC6EDDA59099FA8EBDFAF39D93468_1385154411 = (duplicates != null && !duplicates.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35625057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_35625057;
        // ---------- Original Method ----------
        //return duplicates != null && !duplicates.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "871E72CE5EAD891C7465AEE8C7481A56")
    public void removeMultiParameter(String name) {
        addTaint(name.getTaint());
        this.duplicates.delete(name);
        // ---------- Original Method ----------
        //this.duplicates.delete(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.685 -0400", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "D795F403E32B5F11666D94B23F47F9B9")
    public boolean hasMultiParameter(String parameterName) {
        addTaint(parameterName.getTaint());
        boolean varF87FE143C288CA6B5918F3A947E75FE7_623311457 = (this.duplicates.hasNameValue(parameterName));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626168326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626168326;
        // ---------- Original Method ----------
        //return this.duplicates.hasNameValue(parameterName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.686 -0400", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "3241AA6292FA8FCBD80F737F272440C2")
    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.686 -0400", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "7298EAF48154AF6C86B605F6E1E72414")
    @SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        addTaint(other.getTaint());
    if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_304911465 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013953051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013953051;
        }
for(Iterator i = this.getParameterNames();i.hasNext();)
        {
            String pname = (String) i.next();
            String p1 = this.getParameter( pname );
            String p2 = other.getParameter( pname );
    if(p1 == null ^ p2 == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1157966101 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984766897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984766897;
            }
            else
    if(p1 != null && !p1.equalsIgnoreCase(p2))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1575825001 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374339811 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_374339811;
            }
        } //End block
for(Iterator i = other.getParameterNames();i.hasNext();)
        {
            String pname = (String) i.next();
            String p1 = other.getParameter( pname );
            String p2 = this.getParameter( pname );
    if(p1 == null ^ p2 == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_534584927 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414806528 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_414806528;
            }
            else
    if(p1 != null && !p1.equalsIgnoreCase(p2))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1331052060 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556864715 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_556864715;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1375771794 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915069623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915069623;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract String encodeBody();

    
}

