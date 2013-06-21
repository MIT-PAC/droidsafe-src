package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.DuplicateNameValueList;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.GenericURI;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;
import javax.sip.header.Parameters;

public abstract class ParametersHeader extends SIPHeader implements javax.sip.header.Parameters, Serializable {
    protected NameValueList parameters;
    protected DuplicateNameValueList duplicates;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.047 -0400", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "10DB31FD032678791D17A89BE2F8FCA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.048 -0400", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "FCC1FB77CAD6E4974D6625342B2FC8F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ParametersHeader(String hdrName) {
        super(hdrName);
        dsTaint.addTaint(hdrName);
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.048 -0400", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "6DB6E761A70FC14120268C936CBF78A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        dsTaint.addTaint(sync);
        dsTaint.addTaint(hdrName);
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList(sync);
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.048 -0400", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "6A0746645C5720CD8E206181DE96BF8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        String varFE60A2314A0611908F90AA290472C12A_742626300 = (this.parameters.getParameter(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.parameters.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.048 -0400", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "8A35FCFAFDDA586A575CFD5E95A13278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getParameterValue(String name) {
        dsTaint.addTaint(name);
        Object var59D373327F9C7C3AB65076246FD28A80_280652328 = (this.parameters.getValue(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.parameters.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.049 -0400", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "5F5F78349B1E47D1175C46DEF7D61A3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getParameterNames() {
        Iterator<String> var3601AE5F47A9A5ECC7A39A1C9E7E9971_588590983 = (parameters.getNames());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.049 -0400", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "9AA75CF5A0CF2F370E43857F6A42BDF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasParameters() {
        boolean var206E105C644276542211E959405EB155_1042525145 = (parameters != null && !parameters.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parameters != null && !parameters.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.049 -0400", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "3E34FD9C1A7C1A1D7CDD17AF7A04321A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameter(String name) {
        dsTaint.addTaint(name);
        this.parameters.delete(name);
        // ---------- Original Method ----------
        //this.parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.052 -0400", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "30564733A83D74200E9EBCC39C8A5265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        NameValue nv;
        nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(value);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.053 -0400", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "E8DFFA6D39B7C199AF29631BC18447C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQuotedParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        NameValue nv;
        nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(value);
            nv.setQuotedValue();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.053 -0400", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "A937D61686B8738DCCF1473491FEBF29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setParameter(String name, int value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Integer val;
        val = Integer.valueOf(value);
        this.parameters.set(name,val);
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.053 -0400", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "EE08A9DE938C55AE05EE8C2F2A38F857")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setParameter(String name, boolean value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Boolean val;
        val = Boolean.valueOf(value);
        this.parameters.set(name,val);
        // ---------- Original Method ----------
        //Boolean val = Boolean.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.054 -0400", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "EA49572BE08F7B85A0D6669AEE726233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setParameter(String name, float value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Float val;
        val = Float.valueOf(value);
        NameValue nv;
        nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(val);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.054 -0400", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "1E1B008786C087E0CCFD49311392B0B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setParameter(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        this.parameters.set(name,value);
        // ---------- Original Method ----------
        //this.parameters.set(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.055 -0400", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "9F38E6C96F97EF425DB1C4C2A4716173")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasParameter(String parameterName) {
        dsTaint.addTaint(parameterName);
        boolean varC5B78D921DE741F88D07226445CC20BF_23239303 = (this.parameters.hasNameValue(parameterName));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.parameters.hasNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.055 -0400", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "3176E2C5AADE4344A52763E0CD3017CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameters() {
        this.parameters = new NameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.055 -0400", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "6CFD20B628F114B6D1365A7653FE3409")
    @DSModeled(DSC.SAFE)
    public NameValueList getParameters() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.056 -0400", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "57C96519E80562FF277650AD295AE54D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(NameValue nameValue) {
        dsTaint.addTaint(nameValue.dsTaint);
        this.parameters.set(nameValue);
        // ---------- Original Method ----------
        //this.parameters.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.056 -0400", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "857F6763DB77F0D1CFC29B8F5F79BF3B")
    @DSModeled(DSC.SAFE)
    public void setParameters(NameValueList parameters) {
        dsTaint.addTaint(parameters.dsTaint);
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.056 -0400", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "46E00534FC703C6EC4E9318740AC4F2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getParameterAsInt(String parameterName) {
        dsTaint.addTaint(parameterName);
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_836498201 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1890112174 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varF47086191C2F0170A1295970D0989661_1024232727 = (Integer.parseInt(this.getParameter(parameterName)));
                        } //End block
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_178532405 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.057 -0400", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "18646A0D1C0F0F241747EE8FD217C258")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getParameterAsHexInt(String parameterName) {
        dsTaint.addTaint(parameterName);
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_2123247503 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_324534021 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varEC2CD9A8D8FD6ADF8EE74DC1AFDE6D7B_988533450 = (Integer.parseInt(
                        this.getParameter(parameterName),
                        16));
                        } //End block
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_1146795276 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.058 -0400", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "9AE65D34D99686E965F0346B4BE52498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getParameterAsFloat(String parameterName) {
        dsTaint.addTaint(parameterName);
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_2130927336 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_645144805 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            float varB1A9FACAFD025CE9E264CF06AE87B0F6_219162490 = (Float.parseFloat(this.getParameter(parameterName)));
                        } //End block
                        {
                            float var085B0D6C18304764784A3850D01C35F4_2103882799 = (((Float) getParameterValue(parameterName))
                        .floatValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.058 -0400", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "95BAA858E172E2CD4412BD043EFD477E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected long getParameterAsLong(String parameterName) {
        dsTaint.addTaint(parameterName);
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_1490578639 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1379232741 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            long var50566DA681027A181C7A46693A3F8100_2102233614 = (Long.parseLong(this.getParameter(parameterName)));
                        } //End block
                        {
                            long varEE8BEF11E3C93C926EB44323DBDDC318_120868757 = (((Long) getParameterValue(parameterName))
                        .longValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.059 -0400", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "198B443E1AF4FE9E069486EB33B0059F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected GenericURI getParameterAsURI(String parameterName) {
        dsTaint.addTaint(parameterName);
        Object val;
        val = getParameterValue(parameterName);
        {
            try 
            {
                GenericURI varC8142713AC3FD49F092CE7C1FD0DD1C0_1510951754 = (new GenericURI((String) val));
            } //End block
            catch (ParseException ex)
            { }
        } //End block
        return (GenericURI)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.059 -0400", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "42DB9B7168C955181738D329F2060FB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean getParameterAsBoolean(String parameterName) {
        dsTaint.addTaint(parameterName);
        Object val;
        val = getParameterValue(parameterName);
        {
            boolean varA505FE4E58FB5F6420F72D84075BB90E_915229114 = (((Boolean) val).booleanValue());
        } //End block
        {
            boolean varE9177BB9C3D6BE7B25464D9D7092C675_2008519070 = (Boolean.valueOf((String) val).booleanValue());
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.060 -0400", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "0097F48A2207236477510ACB4E26B86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue getNameValue(String parameterName) {
        dsTaint.addTaint(parameterName);
        NameValue var135A5E650266FC715AEAC7D61C33482A_823795084 = (parameters.getNameValue(parameterName));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters.getNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.060 -0400", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "DE7F790517FCDDFDBB12AA4CCA30AA33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ParametersHeader retval;
        retval = (ParametersHeader) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ParametersHeader retval = (ParametersHeader) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.060 -0400", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "63AD64FFB2CBC4D1FE2763F3660FC7E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMultiParameter(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        NameValue nv;
        nv = new NameValue();
        nv.setName(name);
        nv.setValue(value);
        duplicates.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue();
        //nv.setName(name);
        //nv.setValue(value);
        //duplicates.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.061 -0400", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "6ED94EB046BA87A82F23BDE39A3A4265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMultiParameter(NameValue nameValue) {
        dsTaint.addTaint(nameValue.dsTaint);
        this.duplicates.set(nameValue);
        // ---------- Original Method ----------
        //this.duplicates.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.061 -0400", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "74031CED49D70A13D4ABB042B232682F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMultiParameter(String name) {
        dsTaint.addTaint(name);
        String var7F70500A4CADC665D7B18779A45147B4_198300117 = (this.duplicates.getParameter(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.duplicates.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.061 -0400", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "2B04289F1E4DC6C11CD3BD7AAB55CCBA")
    @DSModeled(DSC.SAFE)
    public DuplicateNameValueList getMultiParameters() {
        return (DuplicateNameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.062 -0400", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "CE3E22D6E8DEFE546FB548C7E88A63EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getMultiParameterValue(String name) {
        dsTaint.addTaint(name);
        Object varA7C5810D39CCDD9CF83DB2DCB5306897_501464416 = (this.duplicates.getValue(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.duplicates.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.062 -0400", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "2915D9E72293DEE938B4DF7BA924EB33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getMultiParameterNames() {
        Iterator<String> var70108D166A2B6E0CF8C87FD02C542A01_339728799 = (duplicates.getNames());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return duplicates.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.062 -0400", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "3545A8789FF9D983521608F80739E60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMultiParameters() {
        boolean varF545179EEFDFD4F932FA08EA4A09FA79_100737429 = (duplicates != null && !duplicates.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return duplicates != null && !duplicates.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.063 -0400", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "12AD1C56DE0EFF3ECC44C4565F4A5B13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMultiParameter(String name) {
        dsTaint.addTaint(name);
        this.duplicates.delete(name);
        // ---------- Original Method ----------
        //this.duplicates.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.063 -0400", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "621971D230DF8E16D4832741B757410B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMultiParameter(String parameterName) {
        dsTaint.addTaint(parameterName);
        boolean varD76A825B7B06EFFF1DA0D39A3D12471F_140645519 = (this.duplicates.hasNameValue(parameterName));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.duplicates.hasNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.064 -0400", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "3241AA6292FA8FCBD80F737F272440C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.064 -0400", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "E99F226752543C232FD9D7FB6A21C81F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        dsTaint.addTaint(other.dsTaint);
        {
            Iterator i;
            i = this.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1880957538 = (i.hasNext());
            {
                String pname;
                pname = (String) i.next();
                String p1;
                p1 = this.getParameter( pname );
                String p2;
                p2 = other.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_1284641280 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Iterator i;
            i = other.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_761253746 = (i.hasNext());
            {
                String pname;
                pname = (String) i.next();
                String p1;
                p1 = other.getParameter( pname );
                String p2;
                p2 = this.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_1280310943 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract String encodeBody();

    
}

