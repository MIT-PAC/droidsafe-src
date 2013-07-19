package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.core.DuplicateNameValueList;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.GenericURI;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;

import javax.sip.header.Parameters;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class ParametersHeader extends SIPHeader implements javax.sip.header.Parameters, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.648 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.648 -0400", hash_original_field = "F5FECD842ADEDCE379FA16D3177B6626", hash_generated_field = "2A6C410AA135B90D8494B5D88641CA12")

    protected DuplicateNameValueList duplicates;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.649 -0400", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "10DB31FD032678791D17A89BE2F8FCA2")
    protected  ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.649 -0400", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "F2454A12911238A788F750FE54C02479")
    protected  ParametersHeader(String hdrName) {
        super(hdrName);
        addTaint(hdrName.getTaint());
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.650 -0400", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "958A4A124848D5D203F68C42C1BE913E")
    protected  ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        addTaint(hdrName.getTaint());
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList(sync);
        //this.duplicates = new DuplicateNameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.650 -0400", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "08D4B27745D013D534DDA73ED8E68936")
    public String getParameter(String name) {
        addTaint(name.getTaint());
String var8A1749FAD7B99F8EBC5597D3A1804F80_1820883152 =         this.parameters.getParameter(name);
        var8A1749FAD7B99F8EBC5597D3A1804F80_1820883152.addTaint(taint);
        return var8A1749FAD7B99F8EBC5597D3A1804F80_1820883152;
        // ---------- Original Method ----------
        //return this.parameters.getParameter(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.650 -0400", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "B030CDB8799924BA920FADAA976A8164")
    public Object getParameterValue(String name) {
        addTaint(name.getTaint());
Object varBC9779CAE1B0B3F377A7233BBF31E6E3_1757505478 =         this.parameters.getValue(name);
        varBC9779CAE1B0B3F377A7233BBF31E6E3_1757505478.addTaint(taint);
        return varBC9779CAE1B0B3F377A7233BBF31E6E3_1757505478;
        // ---------- Original Method ----------
        //return this.parameters.getValue(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.651 -0400", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "DC6AA9FCCEF918BC10975F35BF54D4CA")
    public Iterator<String> getParameterNames() {
Iterator<String> var77947D245EC7574A1CEE7335325FA03A_1614733325 =         parameters.getNames();
        var77947D245EC7574A1CEE7335325FA03A_1614733325.addTaint(taint);
        return var77947D245EC7574A1CEE7335325FA03A_1614733325;
        // ---------- Original Method ----------
        //return parameters.getNames();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.651 -0400", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "2A042E4B070C8011ABEE930B0F22C465")
    public boolean hasParameters() {
        boolean varE78CA04AAABFA12049DF42B6393D6408_1702835904 = (parameters != null && !parameters.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653010846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653010846;
        // ---------- Original Method ----------
        //return parameters != null && !parameters.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.651 -0400", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "BF3C79E07ED38C8C068CCF75F4E53C6E")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        this.parameters.delete(name);
        // ---------- Original Method ----------
        //this.parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.652 -0400", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "86403B3A66D4B6EEBA4A6D8C1DE78B17")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.652 -0400", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "3F2F907D08715BCCDDC137A4243D9384")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.653 -0400", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "C5AA3A51996199F1EDD14512F2328A4B")
    protected void setParameter(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        Integer val = Integer.valueOf(value);
        this.parameters.set(name,val);
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.653 -0400", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "FF8208D1A6A68346CF4B4BE17B86D984")
    protected void setParameter(String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        Boolean val = Boolean.valueOf(value);
        this.parameters.set(name,val);
        // ---------- Original Method ----------
        //Boolean val = Boolean.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.654 -0400", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "31F80637715B0377779C13FC4463CB6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.654 -0400", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "0ACEA7F53073B73B19BEA9AAB3724081")
    protected void setParameter(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        this.parameters.set(name,value);
        // ---------- Original Method ----------
        //this.parameters.set(name,value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.655 -0400", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "5C98F017AFCE2DA7F29238C567098034")
    public boolean hasParameter(String parameterName) {
        addTaint(parameterName.getTaint());
        boolean varD55E94CFFD8E7B4F76EC489FF32C412F_988376629 = (this.parameters.hasNameValue(parameterName));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436277962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436277962;
        // ---------- Original Method ----------
        //return this.parameters.hasNameValue(parameterName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.655 -0400", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "3176E2C5AADE4344A52763E0CD3017CC")
    public void removeParameters() {
        this.parameters = new NameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.656 -0400", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "23AA2F38BEC22A2EEA257657161348CC")
    public NameValueList getParameters() {
NameValueList var3CB0A38B794BDEDADB1F50256E0AE35B_1014913852 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_1014913852.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_1014913852;
        // ---------- Original Method ----------
        //return parameters;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.656 -0400", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "DE8A606608AC93825A7D19B444AEB299")
    public void setParameter(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.parameters.set(nameValue);
        // ---------- Original Method ----------
        //this.parameters.set(nameValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.701 -0400", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "4804A4F492C9506D4B5EB3825EC6EDA1")
    public void setParameters(NameValueList parameters) {
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.701 -0400", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "BCAB8AD80FF0737F32F41C63A732410B")
    protected int getParameterAsInt(String parameterName) {
        addTaint(parameterName.getTaint());
        if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
                if(this.getParameterValue(parameterName) instanceof String)                
                {
                    int varE1AE32D9799EC6865803FCF788ED2E38_2090454959 = (Integer.parseInt(this.getParameter(parameterName)));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725431374 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1725431374;
                } //End block
                else
                {
                    int varB6E3EA7438256A4A2A39E66BF48F9B95_1111504492 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379073 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379073;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1766156244 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566831972 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_566831972;
            } //End block
        } //End block
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2091908518 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908993311 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908993311;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.701 -0400", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "95D41B3AAF23222FE2447BE71737DD0C")
    protected int getParameterAsHexInt(String parameterName) {
        addTaint(parameterName.getTaint());
        if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
                if(this.getParameterValue(parameterName) instanceof String)                
                {
                    int var520CA95BBC5A38C7BC8F7A25622A412E_2144272733 = (Integer.parseInt(
                        this.getParameter(parameterName),
                        16));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442162356 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442162356;
                } //End block
                else
                {
                    int varB6E3EA7438256A4A2A39E66BF48F9B95_426125694 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434394442 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434394442;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_333301136 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787165438 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787165438;
            } //End block
        } //End block
        else
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1854619750 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403001070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403001070;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.702 -0400", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "4D86C0A5AC8FC603A498DD7460D14F17")
    protected float getParameterAsFloat(String parameterName) {
        addTaint(parameterName.getTaint());
        if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
                if(this.getParameterValue(parameterName) instanceof String)                
                {
                    float varA1C76E3F83DEAFAEF57046A793100846_1367157879 = (Float.parseFloat(this.getParameter(parameterName)));
                                        float var546ADE640B6EDFBC8A086EF31347E768_236302737 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_236302737;
                } //End block
                else
                {
                    float varCDBEE4864421A8883CBABDDB7B295C77_727070067 = (((Float) getParameterValue(parameterName))
                        .floatValue());
                                        float var546ADE640B6EDFBC8A086EF31347E768_99294806 = getTaintFloat();
                    return var546ADE640B6EDFBC8A086EF31347E768_99294806;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                float var6BB61E3B7BCE0931DA574D19D1D82C88_743938982 = (-1);
                                float var546ADE640B6EDFBC8A086EF31347E768_253691958 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_253691958;
            } //End block
        } //End block
        else
        {
        float var6BB61E3B7BCE0931DA574D19D1D82C88_112018218 = (-1);
                float var546ADE640B6EDFBC8A086EF31347E768_457407738 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_457407738;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.702 -0400", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "BFF1FDF338FC8E927FD971468DE1911C")
    protected long getParameterAsLong(String parameterName) {
        addTaint(parameterName.getTaint());
        if(this.getParameterValue(parameterName) != null)        
        {
            try 
            {
                if(this.getParameterValue(parameterName) instanceof String)                
                {
                    long var83D47843416B806A6BDBD77A79E9894F_849087780 = (Long.parseLong(this.getParameter(parameterName)));
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1739305815 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1739305815;
                } //End block
                else
                {
                    long var9AFE6145308AB8E095A181CE2C9011F5_2067175205 = (((Long) getParameterValue(parameterName))
                        .longValue());
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_387296809 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_387296809;
                } //End block
            } //End block
            catch (NumberFormatException ex)
            {
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1029143050 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1399271234 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1399271234;
            } //End block
        } //End block
        else
        {
        long var6BB61E3B7BCE0931DA574D19D1D82C88_1475047827 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_346210061 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_346210061;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.702 -0400", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "17EA8447CDF6248A4126209EFD9D45EE")
    protected GenericURI getParameterAsURI(String parameterName) {
        addTaint(parameterName.getTaint());
        Object val = getParameterValue(parameterName);
        if(val instanceof GenericURI)        
        {
GenericURI varFA532447BD104689BA97989E2356EBFB_347515579 =         (GenericURI) val;
        varFA532447BD104689BA97989E2356EBFB_347515579.addTaint(taint);
        return varFA532447BD104689BA97989E2356EBFB_347515579;
        }
        else
        {
            try 
            {
GenericURI var57A8BC3E993C4A8DAC635478C0AA826A_2141562218 =                 new GenericURI((String) val);
                var57A8BC3E993C4A8DAC635478C0AA826A_2141562218.addTaint(taint);
                return var57A8BC3E993C4A8DAC635478C0AA826A_2141562218;
            } //End block
            catch (ParseException ex)
            {
GenericURI var540C13E9E156B687226421B24F2DF178_1187698423 =                 null;
                var540C13E9E156B687226421B24F2DF178_1187698423.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1187698423;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.702 -0400", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "96F028A36B8716446F42ACECEA39BA04")
    protected boolean getParameterAsBoolean(String parameterName) {
        addTaint(parameterName.getTaint());
        Object val = getParameterValue(parameterName);
        if(val == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1591938289 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911921388 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_911921388;
        } //End block
        else
        if(val instanceof Boolean)        
        {
            boolean var0B144680FB3BC875E9E2B28FA61BBD52_2127303387 = (((Boolean) val).booleanValue());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732855749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732855749;
        } //End block
        else
        if(val instanceof String)        
        {
            boolean var90D07544EBC61B33AC2D18D508BEEB76_392586805 = (Boolean.valueOf((String) val).booleanValue());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070385574 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070385574;
        } //End block
        else
        {
        boolean var68934A3E9455FA72420237EB05902327_1282693331 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91371885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_91371885;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.702 -0400", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "F8B71EAB03B535FF40CCADB0DF3BA433")
    public NameValue getNameValue(String parameterName) {
        addTaint(parameterName.getTaint());
NameValue varEF5E994C04E75B8B4EA6C33DDA055061_643098301 =         parameters.getNameValue(parameterName);
        varEF5E994C04E75B8B4EA6C33DDA055061_643098301.addTaint(taint);
        return varEF5E994C04E75B8B4EA6C33DDA055061_643098301;
        // ---------- Original Method ----------
        //return parameters.getNameValue(parameterName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.702 -0400", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "EBA66A8780B6AD958E2B7B7DE1FD25AE")
    public Object clone() {
        ParametersHeader retval = (ParametersHeader) super.clone();
        if(this.parameters != null)        
        retval.parameters = (NameValueList) this.parameters.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1422372864 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1422372864.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1422372864;
        // ---------- Original Method ----------
        //ParametersHeader retval = (ParametersHeader) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "9D0AE3B447F81E94CEDBA426796E5C2E")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "622379517747DFF65293F274774F086E")
    public void setMultiParameter(NameValue nameValue) {
        addTaint(nameValue.getTaint());
        this.duplicates.set(nameValue);
        // ---------- Original Method ----------
        //this.duplicates.set(nameValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "202D261FD3983CC634BC1A65AA16CFFA")
    public String getMultiParameter(String name) {
        addTaint(name.getTaint());
String var0FA821C9ECD09BA15988E2EC17BD3FE5_1649361433 =         this.duplicates.getParameter(name);
        var0FA821C9ECD09BA15988E2EC17BD3FE5_1649361433.addTaint(taint);
        return var0FA821C9ECD09BA15988E2EC17BD3FE5_1649361433;
        // ---------- Original Method ----------
        //return this.duplicates.getParameter(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "8E85584A41233367D3C25BE63032FC4B")
    public DuplicateNameValueList getMultiParameters() {
DuplicateNameValueList var5BDA0BC0D1D0A85895335C7E572C371A_1410607162 =         duplicates;
        var5BDA0BC0D1D0A85895335C7E572C371A_1410607162.addTaint(taint);
        return var5BDA0BC0D1D0A85895335C7E572C371A_1410607162;
        // ---------- Original Method ----------
        //return duplicates;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "A1FAA6460AFB1784A8C1D2A3538DE0B1")
    public Object getMultiParameterValue(String name) {
        addTaint(name.getTaint());
Object varB6921D10A49072688DDAA4B0ED17F658_1562325892 =         this.duplicates.getValue(name);
        varB6921D10A49072688DDAA4B0ED17F658_1562325892.addTaint(taint);
        return varB6921D10A49072688DDAA4B0ED17F658_1562325892;
        // ---------- Original Method ----------
        //return this.duplicates.getValue(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "2CAC1015D55F1838E60D20D0FDC95B78")
    public Iterator<String> getMultiParameterNames() {
Iterator<String> var5015060E52232B6144F92024DB04D587_757326116 =         duplicates.getNames();
        var5015060E52232B6144F92024DB04D587_757326116.addTaint(taint);
        return var5015060E52232B6144F92024DB04D587_757326116;
        // ---------- Original Method ----------
        //return duplicates.getNames();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "8B6604980F8D9B58981D584F0D3B9201")
    public boolean hasMultiParameters() {
        boolean var053FC6EDDA59099FA8EBDFAF39D93468_1196441712 = (duplicates != null && !duplicates.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99147307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_99147307;
        // ---------- Original Method ----------
        //return duplicates != null && !duplicates.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "871E72CE5EAD891C7465AEE8C7481A56")
    public void removeMultiParameter(String name) {
        addTaint(name.getTaint());
        this.duplicates.delete(name);
        // ---------- Original Method ----------
        //this.duplicates.delete(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "6F3E922D24FE35A4AE67DC79B1AF322D")
    public boolean hasMultiParameter(String parameterName) {
        addTaint(parameterName.getTaint());
        boolean varF87FE143C288CA6B5918F3A947E75FE7_779732168 = (this.duplicates.hasNameValue(parameterName));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862635887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862635887;
        // ---------- Original Method ----------
        //return this.duplicates.hasNameValue(parameterName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.703 -0400", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "3241AA6292FA8FCBD80F737F272440C2")
    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.704 -0400", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "37F979930D8A5C957F0D3F0E8D3B6DD4")
    @SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        addTaint(other.getTaint());
        if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1614378704 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1219922593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1219922593;
        }
for(Iterator i = this.getParameterNames();i.hasNext();)
        {
            String pname = (String) i.next();
            String p1 = this.getParameter( pname );
            String p2 = other.getParameter( pname );
            if(p1 == null ^ p2 == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1518402517 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549128258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_549128258;
            }
            else
            if(p1 != null && !p1.equalsIgnoreCase(p2))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1154430842 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074438289 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074438289;
            }
        } //End block
for(Iterator i = other.getParameterNames();i.hasNext();)
        {
            String pname = (String) i.next();
            String p1 = other.getParameter( pname );
            String p2 = this.getParameter( pname );
            if(p1 == null ^ p2 == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_938625647 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993084900 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993084900;
            }
            else
            if(p1 != null && !p1.equalsIgnoreCase(p2))            
            {
            boolean var68934A3E9455FA72420237EB05902327_483735192 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546905088 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_546905088;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_790176938 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1450743207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1450743207;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract String encodeBody();

    
}

