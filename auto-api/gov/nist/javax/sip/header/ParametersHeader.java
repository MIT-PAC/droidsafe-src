package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.869 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.869 -0400", hash_original_field = "F5FECD842ADEDCE379FA16D3177B6626", hash_generated_field = "2A6C410AA135B90D8494B5D88641CA12")

    protected DuplicateNameValueList duplicates;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.870 -0400", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "10DB31FD032678791D17A89BE2F8FCA2")
    protected  ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.870 -0400", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "C702C968C109BB849D350860E774D845")
    protected  ParametersHeader(String hdrName) {
        super(hdrName);
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
        addTaint(hdrName.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.870 -0400", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "015EEDF23CF4543C16124049631DFA75")
    protected  ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
        addTaint(hdrName.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.871 -0400", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "C23F0C9E32A753298916F1181005A5EC")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1499472325 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1499472325 = this.parameters.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1499472325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1499472325;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.871 -0400", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "27C7E754459441A2ECE0AB44B69F1962")
    public Object getParameterValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2092828054 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2092828054 = this.parameters.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2092828054.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2092828054;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.872 -0400", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "1D8D912E0058DA7126C767B92875CEDB")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1802586470 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1802586470 = parameters.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_1802586470.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1802586470;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.872 -0400", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "B5CB88527576EB0EFB158398BEAF1E6F")
    public boolean hasParameters() {
        boolean var206E105C644276542211E959405EB155_1729426458 = (parameters != null && !parameters.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205449139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205449139;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.872 -0400", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "4796F04AEF8035D0D20E3822001ACD07")
    public void removeParameter(String name) {
        this.parameters.delete(name);
        addTaint(name.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.873 -0400", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "DFCAFA46A5180AB723E91B3BC6E756D0")
    public void setParameter(String name, String value) throws ParseException {
        NameValue nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(value);
        } 
        {
            nv = new NameValue(name, value);
            this.parameters.set(nv);
        } 
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.873 -0400", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "C696B241B4C8AC0902DBA8B1B1000A49")
    public void setQuotedParameter(String name, String value) throws ParseException {
        NameValue nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(value);
            nv.setQuotedValue();
        } 
        {
            nv = new NameValue(name, value);
            nv.setQuotedValue();
            this.parameters.set(nv);
        } 
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
            
            
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.874 -0400", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "19B9E47B9A4AE5BF2AA06C99B4357288")
    protected void setParameter(String name, int value) {
        Integer val = Integer.valueOf(value);
        this.parameters.set(name,val);
        addTaint(name.getTaint());
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.874 -0400", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "1153AD397B0688F21A2325ADA4E30795")
    protected void setParameter(String name, boolean value) {
        Boolean val = Boolean.valueOf(value);
        this.parameters.set(name,val);
        addTaint(name.getTaint());
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.875 -0400", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "4F5B8B2355D8AA8F418978B6C81D08FF")
    protected void setParameter(String name, float value) {
        Float val = Float.valueOf(value);
        NameValue nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(val);
        } 
        {
            nv = new NameValue(name, val);
            this.parameters.set(nv);
        } 
        addTaint(name.getTaint());
        addTaint(value);
        
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.875 -0400", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "C6FBDA35FCB170640D213ED199D09AC6")
    protected void setParameter(String name, Object value) {
        this.parameters.set(name,value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.875 -0400", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "9D287184309F2ECAB42B3826F9143CE3")
    public boolean hasParameter(String parameterName) {
        boolean varC5B78D921DE741F88D07226445CC20BF_1231818570 = (this.parameters.hasNameValue(parameterName));
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304448598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_304448598;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.875 -0400", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "3176E2C5AADE4344A52763E0CD3017CC")
    public void removeParameters() {
        this.parameters = new NameValueList();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.876 -0400", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "D9958AF130AC6B51E35E614556E391CE")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1098970334 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1098970334 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1098970334.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1098970334;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.876 -0400", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "95CEF21560BF13AA85AED52BC508C1EA")
    public void setParameter(NameValue nameValue) {
        this.parameters.set(nameValue);
        addTaint(nameValue.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.876 -0400", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "4804A4F492C9506D4B5EB3825EC6EDA1")
    public void setParameters(NameValueList parameters) {
        this.parameters = parameters;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.877 -0400", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "B46AB32622C8566AF10788E8DC29B514")
    protected int getParameterAsInt(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_125613165 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1971576652 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varF47086191C2F0170A1295970D0989661_1710993835 = (Integer.parseInt(this.getParameter(parameterName)));
                        } 
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_485502798 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } 
                    } 
                } 
                catch (NumberFormatException ex)
                { }
            } 
        } 
        addTaint(parameterName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294014281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294014281;
        
        
            
                
                    
                
                    
                        
                
            
                
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.877 -0400", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "1B96A6B7A7508D663D79DA8ED9BBD1B9")
    protected int getParameterAsHexInt(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_308995514 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_915350866 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            int varEC2CD9A8D8FD6ADF8EE74DC1AFDE6D7B_1321946093 = (Integer.parseInt(
                        this.getParameter(parameterName),
                        16));
                        } 
                        {
                            int var282E9B6AF99C85ED568DE196DBA4C145_72453731 = (((Integer) getParameterValue(parameterName))
                        .intValue());
                        } 
                    } 
                } 
                catch (NumberFormatException ex)
                { }
            } 
        } 
        addTaint(parameterName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449119955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449119955;
        
        
            
                
                    
                        
                        
                
                    
                        
                
            
                
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.877 -0400", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "F97B024A6B67EC79D394BF97FF19F1EE")
    protected float getParameterAsFloat(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_1422221372 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1070921384 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            float varB1A9FACAFD025CE9E264CF06AE87B0F6_905894846 = (Float.parseFloat(this.getParameter(parameterName)));
                        } 
                        {
                            float var085B0D6C18304764784A3850D01C35F4_945908483 = (((Float) getParameterValue(parameterName))
                        .floatValue());
                        } 
                    } 
                } 
                catch (NumberFormatException ex)
                { }
            } 
        } 
        addTaint(parameterName.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1387084064 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1387084064;
        
        
            
                
                    
                
                    
                        
                
            
                
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.878 -0400", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "2F2F71B4AF6502A52D917DF6ECCDF25B")
    protected long getParameterAsLong(String parameterName) {
        {
            boolean var15D52F8A75DD53F4A7CAC37E640C8667_852915376 = (this.getParameterValue(parameterName) != null);
            {
                try 
                {
                    {
                        boolean var6F7FA25DA7257F1EE30AEB9BF45F67F3_1937440264 = (this.getParameterValue(parameterName) instanceof String);
                        {
                            long var50566DA681027A181C7A46693A3F8100_1394095417 = (Long.parseLong(this.getParameter(parameterName)));
                        } 
                        {
                            long varEE8BEF11E3C93C926EB44323DBDDC318_293028552 = (((Long) getParameterValue(parameterName))
                        .longValue());
                        } 
                    } 
                } 
                catch (NumberFormatException ex)
                { }
            } 
        } 
        addTaint(parameterName.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1982400527 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1982400527;
        
        
            
                
                    
                
                    
                        
                
            
                
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.879 -0400", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "445393A2DB3F563E093678249A5D74A7")
    protected GenericURI getParameterAsURI(String parameterName) {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1601737369 = null; 
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_750775909 = null; 
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_482541509 = null; 
        Object val = getParameterValue(parameterName);
        varB4EAC82CA7396A68D541C85D26508E83_1601737369 = (GenericURI) val;
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_750775909 = new GenericURI((String) val);
            } 
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_482541509 = null;
            } 
        } 
        addTaint(parameterName.getTaint());
        GenericURI varA7E53CE21691AB073D9660D615818899_932089324; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_932089324 = varB4EAC82CA7396A68D541C85D26508E83_1601737369;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_932089324 = varB4EAC82CA7396A68D541C85D26508E83_750775909;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_932089324 = varB4EAC82CA7396A68D541C85D26508E83_482541509;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_932089324.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_932089324;
        
        
        
            
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.879 -0400", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "E8216ECFBCDBD6809FA60BF28D9B8D39")
    protected boolean getParameterAsBoolean(String parameterName) {
        Object val = getParameterValue(parameterName);
        {
            boolean varA505FE4E58FB5F6420F72D84075BB90E_1435783168 = (((Boolean) val).booleanValue());
        } 
        {
            boolean varE9177BB9C3D6BE7B25464D9D7092C675_954555121 = (Boolean.valueOf((String) val).booleanValue());
        } 
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1145724479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1145724479;
        
        
        
            
        
            
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.879 -0400", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "46D869439183BBAFFEDA4E41DD471760")
    public NameValue getNameValue(String parameterName) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1720503068 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1720503068 = parameters.getNameValue(parameterName);
        addTaint(parameterName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1720503068.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1720503068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.880 -0400", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "C2C39293467ADA4716A3345881BFF3B9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_77272049 = null; 
        ParametersHeader retval = (ParametersHeader) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_77272049 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_77272049.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_77272049;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.880 -0400", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "6BD1CC80EF8C1DF45453779295B66496")
    public void setMultiParameter(String name, String value) {
        NameValue nv = new NameValue();
        nv.setName(name);
        nv.setValue(value);
        duplicates.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.880 -0400", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "E2E2A6FDC73F11634D7811A988EAF7E6")
    public void setMultiParameter(NameValue nameValue) {
        this.duplicates.set(nameValue);
        addTaint(nameValue.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.881 -0400", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "E182B886AAE66EDC1DBF41999841B79F")
    public String getMultiParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1032615811 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1032615811 = this.duplicates.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1032615811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1032615811;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.881 -0400", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "C97E10D5759B39FC6F80DBCD7C116457")
    public DuplicateNameValueList getMultiParameters() {
        DuplicateNameValueList varB4EAC82CA7396A68D541C85D26508E83_1908038532 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1908038532 = duplicates;
        varB4EAC82CA7396A68D541C85D26508E83_1908038532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1908038532;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.882 -0400", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "299D1EB49AC19B15ADAA16D216DA863F")
    public Object getMultiParameterValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1017936735 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1017936735 = this.duplicates.getValue(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1017936735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1017936735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.882 -0400", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "B8EECD398A94569B672354384594FBD2")
    public Iterator<String> getMultiParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_973243798 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_973243798 = duplicates.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_973243798.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_973243798;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.883 -0400", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "561494853059ECC1F16D2E9B7A06A796")
    public boolean hasMultiParameters() {
        boolean varF545179EEFDFD4F932FA08EA4A09FA79_164993329 = (duplicates != null && !duplicates.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551950898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_551950898;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.883 -0400", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "C59B0DEF0CC7FCD610491511E18ACBC9")
    public void removeMultiParameter(String name) {
        this.duplicates.delete(name);
        addTaint(name.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.883 -0400", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "6F6AA1132D293BBBD360B62AF86769D8")
    public boolean hasMultiParameter(String parameterName) {
        boolean varD76A825B7B06EFFF1DA0D39A3D12471F_1080560297 = (this.duplicates.hasNameValue(parameterName));
        addTaint(parameterName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780332928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780332928;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.883 -0400", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "3241AA6292FA8FCBD80F737F272440C2")
    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.884 -0400", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "07A839E06341118D01BEF03B5D16370A")
    @SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        {
            Iterator i = this.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1729189231 = (i.hasNext());
            {
                String pname = (String) i.next();
                String p1 = this.getParameter( pname );
                String p2 = other.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_1252099443 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } 
            } 
        } 
        {
            Iterator i = other.getParameterNames();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_688668165 = (i.hasNext());
            {
                String pname = (String) i.next();
                String p1 = other.getParameter( pname );
                String p2 = this.getParameter( pname );
                {
                    boolean var7F883A88AC881ECEB868D7432912E485_273126591 = (p1 != null && !p1.equalsIgnoreCase(p2));
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613130187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_613130187;
        
        
    }

    
    protected abstract String encodeBody();

    
}

