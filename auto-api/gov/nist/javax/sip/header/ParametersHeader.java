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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.206 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.206 -0400", hash_original_field = "F5FECD842ADEDCE379FA16D3177B6626", hash_generated_field = "2A6C410AA135B90D8494B5D88641CA12")

    protected DuplicateNameValueList duplicates;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.207 -0400", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "10DB31FD032678791D17A89BE2F8FCA2")
    protected  ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.207 -0400", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "C702C968C109BB849D350860E774D845")
    protected  ParametersHeader(String hdrName) {
        super(hdrName);
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        addTaint(hdrName.getTaint());
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.207 -0400", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "015EEDF23CF4543C16124049631DFA75")
    protected  ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
        addTaint(hdrName.getTaint());
        // ---------- Original Method ----------
        //this.parameters = new NameValueList(sync);
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.223 -0400", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "7D888A28061DBC13B08A4D54817B4882")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1426777046 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1426777046 = this.parameters.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1426777046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426777046;
        // ---------- Original Method ----------
        //return this.parameters.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.224 -0400", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "22F9C743486031CEBF98FE77ACBF8A88")
    public Object getParameterValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1031457620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1031457620 = this.parameters.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1031457620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1031457620;
        // ---------- Original Method ----------
        //return this.parameters.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.225 -0400", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "DFBB333746644C99C15A1112F891D222")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_2098771632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2098771632 = parameters.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_2098771632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2098771632;
        // ---------- Original Method ----------
        //return parameters.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.225 -0400", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "22D9C2749CABEC61E4BFCBDB88E071FB")
    public boolean hasParameters() {
        boolean var206E105C644276542211E959405EB155_1552272632 = (parameters != null && !parameters.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872096909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872096909;
        // ---------- Original Method ----------
        //return parameters != null && !parameters.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.225 -0400", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "4796F04AEF8035D0D20E3822001ACD07")
    public void removeParameter(String name) {
        this.parameters.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //this.parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.227 -0400", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "19DC519CF9CC75E1CAA4E79B636A8A1D")
    public void setParameter(String name, String value) throws ParseException {
        NameValue nv;
        nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(value);
        } //End block
        {
            nv = new NameValue(name, value);
            this.parameters.set(nv);
        } //End block
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = parameters.getNameValue(name);
        //if (nv != null) {
            //nv.setValueAsObject(value);
        //} else {
            //nv = new NameValue(name, value);
            //this.parameters.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.238 -0400", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "E576818F61AB6673A7CA6D3492CF0F51")
    public void setQuotedParameter(String name, String value) throws ParseException {
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
        addTaint(name.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.238 -0400", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "4566BB4FD5B0D09EA0699606EEC84104")
    protected void setParameter(String name, int value) {
        Integer val;
        val = Integer.valueOf(value);
        this.parameters.set(name,val);
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.242 -0400", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "E699ECB6F7386888B56D36CEEAEED393")
    protected void setParameter(String name, boolean value) {
        Boolean val;
        val = Boolean.valueOf(value);
        this.parameters.set(name,val);
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //Boolean val = Boolean.valueOf(value);
        //this.parameters.set(name,val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.259 -0400", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "47C509B6ECAF5AB22778024F6C6F2131")
    protected void setParameter(String name, float value) {
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
        addTaint(name.getTaint());
        addTaint(value);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.260 -0400", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "C6FBDA35FCB170640D213ED199D09AC6")
    protected void setParameter(String name, Object value) {
        this.parameters.set(name,value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.260 -0400", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "E96958601D16EEDB7C4AD8DC0CE1112D")
    public boolean hasParameter(String parameterName) {
        boolean varC5B78D921DE741F88D07226445CC20BF_689943833 = (this.parameters.hasNameValue(parameterName));
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024218452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024218452;
        // ---------- Original Method ----------
        //return this.parameters.hasNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.261 -0400", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "3176E2C5AADE4344A52763E0CD3017CC")
    public void removeParameters() {
        this.parameters = new NameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.262 -0400", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "5973580EEFF6965963B9477195BB8806")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1015644761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1015644761 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1015644761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015644761;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.262 -0400", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "95CEF21560BF13AA85AED52BC508C1EA")
    public void setParameter(NameValue nameValue) {
        this.parameters.set(nameValue);
        addTaint(nameValue.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.262 -0400", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "4804A4F492C9506D4B5EB3825EC6EDA1")
    public void setParameters(NameValueList parameters) {
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.281 -0400", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "0F5F7513B15BD75987CB8D418F4A26AC")
    protected int getParameterAsInt(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_777592881 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1040120396 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varF47086191C2F0170A1295970D0989661_2014003615 = (Integer.parseInt(this.getParameter(parameterName)));
                        } //End block
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_1281790556 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202234240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202234240;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.282 -0400", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "91861F9931CD51E1E8161D539B053D7E")
    protected int getParameterAsHexInt(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_118522535 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_63673651 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varEC2CD9A8D8FD6ADF8EE74DC1AFDE6D7B_1692186883 = (Integer.parseInt(
                        this.getParameter(parameterName),
                        16));
                        } //End block
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_2053765939 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227260571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227260571;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.282 -0400", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "5261E9B3D0B98CA0F979F4EB4630A96F")
    protected float getParameterAsFloat(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_1532118211 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1072572425 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            float varB1A9FACAFD025CE9E264CF06AE87B0F6_1291877544 = (Float.parseFloat(this.getParameter(parameterName)));
                        } //End block
                        {
                            float var085B0D6C18304764784A3850D01C35F4_1616375893 = (((Float) getParameterValue(parameterName))
                        .floatValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_427451244 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_427451244;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.283 -0400", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "C6F1934019B5C9BEE301A7BF6A505980")
    protected long getParameterAsLong(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_538348195 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_879810133 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            long var50566DA681027A181C7A46693A3F8100_1553254308 = (Long.parseLong(this.getParameter(parameterName)));
                        } //End block
                        {
                            long varEE8BEF11E3C93C926EB44323DBDDC318_860215336 = (((Long) getParameterValue(parameterName))
                        .longValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1989308208 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1989308208;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.287 -0400", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "E0D0BDBD04BBF8A0127DC6478AA98953")
    protected GenericURI getParameterAsURI(String parameterName) {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_712112789 = null; //Variable for return #1
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_2121419913 = null; //Variable for return #2
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_476740778 = null; //Variable for return #3
        Object val;
        val = getParameterValue(parameterName);
        varB4EAC82CA7396A68D541C85D26508E83_712112789 = (GenericURI) val;
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2121419913 = new GenericURI((String) val);
            } //End block
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_476740778 = null;
            } //End block
        } //End block
        addTaint(parameterName.getTaint());
        GenericURI varA7E53CE21691AB073D9660D615818899_31480109; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_31480109 = varB4EAC82CA7396A68D541C85D26508E83_712112789;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_31480109 = varB4EAC82CA7396A68D541C85D26508E83_2121419913;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_31480109 = varB4EAC82CA7396A68D541C85D26508E83_476740778;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_31480109.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_31480109;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.290 -0400", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "49CF311F4AC2F3F24D97AD819039E03D")
    protected boolean getParameterAsBoolean(String parameterName) {
        Object val;
        val = getParameterValue(parameterName);
        {
            boolean varA505FE4E58FB5F6420F72D84075BB90E_1898925856 = (((Boolean) val).booleanValue());
        } //End block
        {
            boolean varE9177BB9C3D6BE7B25464D9D7092C675_11762624 = (Boolean.valueOf((String) val).booleanValue());
        } //End block
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125446255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125446255;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.290 -0400", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "423C5D5D0CB4F436BBF2E626D67FB622")
    public NameValue getNameValue(String parameterName) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1749121506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1749121506 = parameters.getNameValue(parameterName);
        addTaint(parameterName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1749121506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749121506;
        // ---------- Original Method ----------
        //return parameters.getNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.291 -0400", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "9A1F8E61CFAEE7D03F5DD46C57AF1B29")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_922936815 = null; //Variable for return #1
        ParametersHeader retval;
        retval = (ParametersHeader) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_922936815 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_922936815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_922936815;
        // ---------- Original Method ----------
        //ParametersHeader retval = (ParametersHeader) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.291 -0400", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "916A763886DDA65DEA2D7DDF4503C151")
    public void setMultiParameter(String name, String value) {
        NameValue nv;
        nv = new NameValue();
        nv.setName(name);
        nv.setValue(value);
        duplicates.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue();
        //nv.setName(name);
        //nv.setValue(value);
        //duplicates.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.291 -0400", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "E2E2A6FDC73F11634D7811A988EAF7E6")
    public void setMultiParameter(NameValue nameValue) {
        this.duplicates.set(nameValue);
        addTaint(nameValue.getTaint());
        // ---------- Original Method ----------
        //this.duplicates.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.301 -0400", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "C517D0E103C26B6500FC6C95FF3F6FAA")
    public String getMultiParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_2061519952 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2061519952 = this.duplicates.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2061519952.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2061519952;
        // ---------- Original Method ----------
        //return this.duplicates.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.316 -0400", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "99D28A2F9F53C196740D408015FF19DD")
    public DuplicateNameValueList getMultiParameters() {
        DuplicateNameValueList varB4EAC82CA7396A68D541C85D26508E83_1928293735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1928293735 = duplicates;
        varB4EAC82CA7396A68D541C85D26508E83_1928293735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928293735;
        // ---------- Original Method ----------
        //return duplicates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.316 -0400", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "189BCB92D3D6BF794E3AF9A457C7C1F2")
    public Object getMultiParameterValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_769609701 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769609701 = this.duplicates.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_769609701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769609701;
        // ---------- Original Method ----------
        //return this.duplicates.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.317 -0400", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "6BED3A24D3AB0413E607147AC7F489F8")
    public Iterator<String> getMultiParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_37664525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_37664525 = duplicates.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_37664525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_37664525;
        // ---------- Original Method ----------
        //return duplicates.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.317 -0400", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "05D5211FAE414DD5FC61F337AD9DEED7")
    public boolean hasMultiParameters() {
        boolean varF545179EEFDFD4F932FA08EA4A09FA79_1596982842 = (duplicates != null && !duplicates.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511152951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_511152951;
        // ---------- Original Method ----------
        //return duplicates != null && !duplicates.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.317 -0400", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "C59B0DEF0CC7FCD610491511E18ACBC9")
    public void removeMultiParameter(String name) {
        this.duplicates.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //this.duplicates.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.317 -0400", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "799527774CE14AA3DC45429AF4947A4F")
    public boolean hasMultiParameter(String parameterName) {
        boolean varD76A825B7B06EFFF1DA0D39A3D12471F_329812375 = (this.duplicates.hasNameValue(parameterName));
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882290366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882290366;
        // ---------- Original Method ----------
        //return this.duplicates.hasNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.322 -0400", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "3241AA6292FA8FCBD80F737F272440C2")
    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.322 -0400", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "DA8DDEEC69CDB9401725C61D6D83AF38")
    @SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        {
            Iterator i;
            i = this.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1290673907 = (i.hasNext());
            {
                String pname;
                pname = (String) i.next();
                String p1;
                p1 = this.getParameter( pname );
                String p2;
                p2 = other.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_2006603604 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Iterator i;
            i = other.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_789107305 = (i.hasNext());
            {
                String pname;
                pname = (String) i.next();
                String p1;
                p1 = other.getParameter( pname );
                String p2;
                p2 = this.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_1569773481 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241159814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241159814;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract String encodeBody();

    
}

