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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.231 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.231 -0400", hash_original_field = "F5FECD842ADEDCE379FA16D3177B6626", hash_generated_field = "2A6C410AA135B90D8494B5D88641CA12")

    protected DuplicateNameValueList duplicates;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.250 -0400", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "10DB31FD032678791D17A89BE2F8FCA2")
    protected  ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.252 -0400", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "C702C968C109BB849D350860E774D845")
    protected  ParametersHeader(String hdrName) {
        super(hdrName);
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        addTaint(hdrName.getTaint());
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.253 -0400", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "015EEDF23CF4543C16124049631DFA75")
    protected  ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
        addTaint(hdrName.getTaint());
        // ---------- Original Method ----------
        //this.parameters = new NameValueList(sync);
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.254 -0400", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "C4AAD0E21E851743D02C460A008DF132")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1297604875 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1297604875 = this.parameters.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1297604875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1297604875;
        // ---------- Original Method ----------
        //return this.parameters.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.254 -0400", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "71E087C734A8223E408C6FC400902F1E")
    public Object getParameterValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_930443795 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_930443795 = this.parameters.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_930443795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_930443795;
        // ---------- Original Method ----------
        //return this.parameters.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.256 -0400", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "E31F5479B88C21E9E1A76BAF17A10230")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1619218825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1619218825 = parameters.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_1619218825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1619218825;
        // ---------- Original Method ----------
        //return parameters.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.257 -0400", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "24948B8DC0FE3EDA0E654F2CD75BAA2B")
    public boolean hasParameters() {
        boolean var206E105C644276542211E959405EB155_2032606403 = (parameters != null && !parameters.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1106981345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1106981345;
        // ---------- Original Method ----------
        //return parameters != null && !parameters.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.260 -0400", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "4796F04AEF8035D0D20E3822001ACD07")
    public void removeParameter(String name) {
        this.parameters.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //this.parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.264 -0400", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "19DC519CF9CC75E1CAA4E79B636A8A1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.272 -0400", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "E576818F61AB6673A7CA6D3492CF0F51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.273 -0400", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "4566BB4FD5B0D09EA0699606EEC84104")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.273 -0400", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "E699ECB6F7386888B56D36CEEAEED393")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.282 -0400", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "47C509B6ECAF5AB22778024F6C6F2131")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.283 -0400", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "C6FBDA35FCB170640D213ED199D09AC6")
    protected void setParameter(String name, Object value) {
        this.parameters.set(name,value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.284 -0400", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "CB564F7D93CA9632D06A4DBFB51EE675")
    public boolean hasParameter(String parameterName) {
        boolean varC5B78D921DE741F88D07226445CC20BF_636920129 = (this.parameters.hasNameValue(parameterName));
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805329729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805329729;
        // ---------- Original Method ----------
        //return this.parameters.hasNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.296 -0400", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "3176E2C5AADE4344A52763E0CD3017CC")
    public void removeParameters() {
        this.parameters = new NameValueList();
        // ---------- Original Method ----------
        //this.parameters = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.297 -0400", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "3A807ED91D05984EF389EBE248C77D13")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1823134335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1823134335 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1823134335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823134335;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.313 -0400", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "95CEF21560BF13AA85AED52BC508C1EA")
    public void setParameter(NameValue nameValue) {
        this.parameters.set(nameValue);
        addTaint(nameValue.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.313 -0400", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "4804A4F492C9506D4B5EB3825EC6EDA1")
    public void setParameters(NameValueList parameters) {
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.314 -0400", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "494053B1660CB2BF3FE818B9D54E7B20")
    protected int getParameterAsInt(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_1846369562 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1074915560 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varF47086191C2F0170A1295970D0989661_1925980351 = (Integer.parseInt(this.getParameter(parameterName)));
                        } //End block
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_819281737 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2134631362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2134631362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.315 -0400", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "CC765539713CA8D3625C1B57F8B2781F")
    protected int getParameterAsHexInt(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_1486878420 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_250274677 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varEC2CD9A8D8FD6ADF8EE74DC1AFDE6D7B_1615698251 = (Integer.parseInt(
                        this.getParameter(parameterName),
                        16));
                        } //End block
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_601714697 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481465471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481465471;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.316 -0400", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "E83188C058945FB117C911AE65DA5FBD")
    protected float getParameterAsFloat(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_97174974 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1476957743 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            float varB1A9FACAFD025CE9E264CF06AE87B0F6_1567200267 = (Float.parseFloat(this.getParameter(parameterName)));
                        } //End block
                        {
                            float var085B0D6C18304764784A3850D01C35F4_992399201 = (((Float) getParameterValue(parameterName))
                        .floatValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1648468710 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1648468710;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.326 -0400", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "97EA41ABE1F5CD0E1A2E1C9305077AA9")
    protected long getParameterAsLong(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_156247331 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_768360141 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            long var50566DA681027A181C7A46693A3F8100_1397258055 = (Long.parseLong(this.getParameter(parameterName)));
                        } //End block
                        {
                            long varEE8BEF11E3C93C926EB44323DBDDC318_804522744 = (((Long) getParameterValue(parameterName))
                        .longValue());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(parameterName.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_231924132 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_231924132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.336 -0400", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "354EDB12AF7F143ACA741D76BE4C96A5")
    protected GenericURI getParameterAsURI(String parameterName) {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1813390417 = null; //Variable for return #1
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_454755151 = null; //Variable for return #2
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1909227689 = null; //Variable for return #3
        Object val;
        val = getParameterValue(parameterName);
        varB4EAC82CA7396A68D541C85D26508E83_1813390417 = (GenericURI) val;
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_454755151 = new GenericURI((String) val);
            } //End block
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1909227689 = null;
            } //End block
        } //End block
        addTaint(parameterName.getTaint());
        GenericURI varA7E53CE21691AB073D9660D615818899_465986692; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_465986692 = varB4EAC82CA7396A68D541C85D26508E83_1813390417;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_465986692 = varB4EAC82CA7396A68D541C85D26508E83_454755151;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_465986692 = varB4EAC82CA7396A68D541C85D26508E83_1909227689;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_465986692.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_465986692;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.337 -0400", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "C10F0A905C87BCB43013DD21407069BD")
    protected boolean getParameterAsBoolean(String parameterName) {
        Object val;
        val = getParameterValue(parameterName);
        {
            boolean varA505FE4E58FB5F6420F72D84075BB90E_1538909680 = (((Boolean) val).booleanValue());
        } //End block
        {
            boolean varE9177BB9C3D6BE7B25464D9D7092C675_2078037881 = (Boolean.valueOf((String) val).booleanValue());
        } //End block
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125008288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125008288;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.337 -0400", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "30D35BEF608C08A685237A7A63E0494C")
    public NameValue getNameValue(String parameterName) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_171278655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_171278655 = parameters.getNameValue(parameterName);
        addTaint(parameterName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_171278655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_171278655;
        // ---------- Original Method ----------
        //return parameters.getNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.341 -0400", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "2DAFC86D29F6C0F83467F63D7DE53669")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1331944141 = null; //Variable for return #1
        ParametersHeader retval;
        retval = (ParametersHeader) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1331944141 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1331944141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1331944141;
        // ---------- Original Method ----------
        //ParametersHeader retval = (ParametersHeader) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.341 -0400", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "916A763886DDA65DEA2D7DDF4503C151")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.341 -0400", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "E2E2A6FDC73F11634D7811A988EAF7E6")
    public void setMultiParameter(NameValue nameValue) {
        this.duplicates.set(nameValue);
        addTaint(nameValue.getTaint());
        // ---------- Original Method ----------
        //this.duplicates.set(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.342 -0400", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "A9F9DC7914B88282EE65FBB8CCAB1C13")
    public String getMultiParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1541971815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1541971815 = this.duplicates.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1541971815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1541971815;
        // ---------- Original Method ----------
        //return this.duplicates.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.342 -0400", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "51ED47843C1C7E9225428F5D7CFFD70E")
    public DuplicateNameValueList getMultiParameters() {
        DuplicateNameValueList varB4EAC82CA7396A68D541C85D26508E83_1581779997 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1581779997 = duplicates;
        varB4EAC82CA7396A68D541C85D26508E83_1581779997.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1581779997;
        // ---------- Original Method ----------
        //return duplicates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.343 -0400", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "E638C321BEE110969045898006DDB9BD")
    public Object getMultiParameterValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_462837332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_462837332 = this.duplicates.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_462837332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_462837332;
        // ---------- Original Method ----------
        //return this.duplicates.getValue(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.343 -0400", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "ACBC48D7A1B0ED92965E000AB2DDAB41")
    public Iterator<String> getMultiParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_2021959865 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021959865 = duplicates.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_2021959865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021959865;
        // ---------- Original Method ----------
        //return duplicates.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.343 -0400", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "E857E72646DAE7F20F497E2628F5E90E")
    public boolean hasMultiParameters() {
        boolean varF545179EEFDFD4F932FA08EA4A09FA79_780130757 = (duplicates != null && !duplicates.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373551286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373551286;
        // ---------- Original Method ----------
        //return duplicates != null && !duplicates.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.344 -0400", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "C59B0DEF0CC7FCD610491511E18ACBC9")
    public void removeMultiParameter(String name) {
        this.duplicates.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //this.duplicates.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.344 -0400", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "87C13C6962CAFFEAA30F5F7C98D4B92F")
    public boolean hasMultiParameter(String parameterName) {
        boolean varD76A825B7B06EFFF1DA0D39A3D12471F_2147266044 = (this.duplicates.hasNameValue(parameterName));
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827769985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827769985;
        // ---------- Original Method ----------
        //return this.duplicates.hasNameValue(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.344 -0400", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "3241AA6292FA8FCBD80F737F272440C2")
    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
        // ---------- Original Method ----------
        //this.duplicates = new DuplicateNameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.345 -0400", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "1014161701221A7358D7FF86744248F8")
    @SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        {
            Iterator i;
            i = this.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_2133881292 = (i.hasNext());
            {
                String pname;
                pname = (String) i.next();
                String p1;
                p1 = this.getParameter( pname );
                String p2;
                p2 = other.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_1522958033 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Iterator i;
            i = other.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_929818030 = (i.hasNext());
            {
                String pname;
                pname = (String) i.next();
                String p1;
                p1 = other.getParameter( pname );
                String p2;
                p2 = this.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_799376956 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853860206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853860206;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract String encodeBody();

    
}

