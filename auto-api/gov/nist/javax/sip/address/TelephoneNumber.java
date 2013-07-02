package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import java.util.Iterator;

public class TelephoneNumber extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.528 -0400", hash_original_field = "9B54CF4C9AEF2A42C8430B43936B405A", hash_generated_field = "F0F600057F56A09C7F67C507D581D80D")

    protected boolean isglobal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.528 -0400", hash_original_field = "C9AA10B21BC611B05B1D8E0C01E5D397", hash_generated_field = "A5887F206856305D82FC53512CE55D3B")

    protected String phoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.528 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.528 -0400", hash_original_method = "C2E661A0F0E8603FDB28C1E5F6957C6B", hash_generated_method = "ED4544B8D5B014FCD0F73770D6821934")
    public  TelephoneNumber() {
        parameters = new NameValueList();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.529 -0400", hash_original_method = "482E6E79DCAAF2107BA2BF4B499737C2", hash_generated_method = "D8C2E8FB7BA5010630FE4FF4E325CC22")
    public void deleteParm(String name) {
        parameters.delete(name);
        addTaint(name.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.529 -0400", hash_original_method = "52800C2C905EEB817404225ADBC057C1", hash_generated_method = "580875D4DCEBDCA687491970632FC9DE")
    public String getPhoneNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_437266796 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_437266796 = phoneNumber;
        varB4EAC82CA7396A68D541C85D26508E83_437266796.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_437266796;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.530 -0400", hash_original_method = "46AF8366350CE91B864B76E1571FD560", hash_generated_method = "1DEFCBE4AA654379C00B29B2A9814545")
    public String getPostDial() {
        String varB4EAC82CA7396A68D541C85D26508E83_382205271 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_382205271 = (String) parameters.getValue(POSTDIAL);
        varB4EAC82CA7396A68D541C85D26508E83_382205271.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_382205271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.530 -0400", hash_original_method = "E5D57B503B0E16A000773FA057D6B1B7", hash_generated_method = "2EA9F2C70BE9CDE9A439F78401F9D664")
    public String getIsdnSubaddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1090806545 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1090806545 = (String) parameters.getValue(ISUB);
        varB4EAC82CA7396A68D541C85D26508E83_1090806545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1090806545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.531 -0400", hash_original_method = "E1FFD425535E2D30F5D43A147688D9A7", hash_generated_method = "0483EC27E1DEC62E188C878653701DCF")
    public boolean hasPostDial() {
        boolean varFF226E7C7804B4C8779D204E4C372EA7_2061873523 = (parameters.getValue(POSTDIAL) != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123907343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123907343;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.531 -0400", hash_original_method = "588E30C769F46315FA0899538D14C7E2", hash_generated_method = "CA05F75F564972ABDA7DE3712ED50678")
    public boolean hasParm(String pname) {
        boolean varE874A1721B6ED57B3E89011DE98FC817_2009655789 = (parameters.hasNameValue(pname));
        addTaint(pname.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963592138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963592138;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.531 -0400", hash_original_method = "647E85AB615972325C277E376A221EF0", hash_generated_method = "77AD4FA59571107B2443CCEE9B0A1DE9")
    public boolean hasIsdnSubaddress() {
        boolean varC0122FBF9B823CE23BEE88359CCBAA0B_887189676 = (hasParm(ISUB));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391182825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391182825;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.531 -0400", hash_original_method = "26808293282132329FBEA070B2AD722D", hash_generated_method = "119B96D9FA0A7226931CA17471E3A0BB")
    public boolean isGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275235545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275235545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.531 -0400", hash_original_method = "872EACB97AA4D13F74BE9616D4416942", hash_generated_method = "E8F7D5A33418C1A5618069298CBCDFC0")
    public void removePostDial() {
        parameters.delete(POSTDIAL);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.532 -0400", hash_original_method = "C4A054C6DC361788E8A02206DAB97797", hash_generated_method = "57EE5CD2FBB1671F10B9A34884F9DD7B")
    public void removeIsdnSubaddress() {
        deleteParm(ISUB);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.532 -0400", hash_original_method = "779B73549EB95AA1112D17D4BD37698F", hash_generated_method = "959236CB1F720298C9BF15740EF84153")
    public void setParameters(NameValueList p) {
        parameters = p;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.532 -0400", hash_original_method = "AC69D7A5F7431BD993B4E02357C1C328", hash_generated_method = "8AE7A45CDBFC0F972181147E0F3ACDEE")
    public void setGlobal(boolean g) {
        isglobal = g;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.532 -0400", hash_original_method = "3187783A98FD3EF3CF221F591C928162", hash_generated_method = "94F230A9301B324529FCCA174572AED3")
    public void setPostDial(String p) {
        NameValue nv = new NameValue(POSTDIAL, p);
        parameters.set(nv);
        addTaint(p.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.533 -0400", hash_original_method = "1017383CE0C4E09E719151FC1E532DF6", hash_generated_method = "2667D4D75381DCD4625C3B684AE897FF")
    public void setParm(String name, Object value) {
        NameValue nv = new NameValue(name, value);
        parameters.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.533 -0400", hash_original_method = "2C7FD6CD1F9BBF926548B29323136AA0", hash_generated_method = "8E6BBF662E42950F7E197C716E63603D")
    public void setIsdnSubaddress(String isub) {
        setParm(ISUB, isub);
        addTaint(isub.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.533 -0400", hash_original_method = "0D906AA6E6C51748158DF0E26B379B98", hash_generated_method = "5792C7D29465A82AFE011B3B06F20683")
    public void setPhoneNumber(String num) {
        phoneNumber = num;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.533 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "C9976C872E0B1F8E6908697A28563A71")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_866576836 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_866576836 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_866576836.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_866576836;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.534 -0400", hash_original_method = "4745D56EA907C8F5BA4F4E737AF3537A", hash_generated_method = "D071DA68B7F88CBDB51C6937D191EE3A")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1938168893 = null; 
        buffer.append('+');
        buffer.append(phoneNumber);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2134076343 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1938168893 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1938168893.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1938168893;
        
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.534 -0400", hash_original_method = "6A189D1F37381970473560C000F9F148", hash_generated_method = "5177C25771464896A634B367068DDCE9")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_2115005307 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_848065418 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_995781335 = null; 
        Object val = parameters.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_2115005307 = null;
        varB4EAC82CA7396A68D541C85D26508E83_848065418 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_995781335 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_592746292; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_592746292 = varB4EAC82CA7396A68D541C85D26508E83_2115005307;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_592746292 = varB4EAC82CA7396A68D541C85D26508E83_848065418;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_592746292 = varB4EAC82CA7396A68D541C85D26508E83_995781335;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_592746292.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_592746292;
        
        
        
            
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.535 -0400", hash_original_method = "CB48E75FADF5A296C71C66E8605F8AA2", hash_generated_method = "E931D28122F09B84E38437353553B70F")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_823697845 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_823697845 = this.parameters.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_823697845.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_823697845;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.535 -0400", hash_original_method = "B7E395B29F4AF7C2E05F5A2CCFC8AF7A", hash_generated_method = "C83C6AB6ED548A5CB8FB517C05404B21")
    public void removeParameter(String parameter) {
        this.parameters.delete(parameter);
        addTaint(parameter.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.535 -0400", hash_original_method = "EF9A54632618F205C3C318D3100361E8", hash_generated_method = "9A0FB63A3FC0A53760AA2C21627BF601")
    public void setParameter(String name, String value) {
        NameValue nv = new NameValue(name, value);
        this.parameters.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.536 -0400", hash_original_method = "459B956E59E9D185995D481A4A763AF3", hash_generated_method = "E48DCBB6156DB089C0DD8298F74AE302")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1571945509 = null; 
        TelephoneNumber retval = (TelephoneNumber) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1571945509 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1571945509.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1571945509;
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.537 -0400", hash_original_method = "3F9E254F8A6DAF7B33BDD77A0CAB2530", hash_generated_method = "E7025CDD3145EF153A8F08EF4BE691AD")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_860718743 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_860718743 = this.parameters;
        varB4EAC82CA7396A68D541C85D26508E83_860718743.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_860718743;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.537 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.537 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.537 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.537 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

