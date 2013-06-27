package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import java.util.Iterator;

public class TelephoneNumber extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.859 -0400", hash_original_field = "9B54CF4C9AEF2A42C8430B43936B405A", hash_generated_field = "F0F600057F56A09C7F67C507D581D80D")

    protected boolean isglobal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.859 -0400", hash_original_field = "C9AA10B21BC611B05B1D8E0C01E5D397", hash_generated_field = "A5887F206856305D82FC53512CE55D3B")

    protected String phoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.859 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.860 -0400", hash_original_method = "C2E661A0F0E8603FDB28C1E5F6957C6B", hash_generated_method = "ED4544B8D5B014FCD0F73770D6821934")
    public  TelephoneNumber() {
        parameters = new NameValueList();
        // ---------- Original Method ----------
        //parameters = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.870 -0400", hash_original_method = "482E6E79DCAAF2107BA2BF4B499737C2", hash_generated_method = "D8C2E8FB7BA5010630FE4FF4E325CC22")
    public void deleteParm(String name) {
        parameters.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.870 -0400", hash_original_method = "52800C2C905EEB817404225ADBC057C1", hash_generated_method = "0D1B9A0877427F3EB49FAEB551BA457B")
    public String getPhoneNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1759227024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1759227024 = phoneNumber;
        varB4EAC82CA7396A68D541C85D26508E83_1759227024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1759227024;
        // ---------- Original Method ----------
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.878 -0400", hash_original_method = "46AF8366350CE91B864B76E1571FD560", hash_generated_method = "DB4312C3A9392E0A2029B26237819D88")
    public String getPostDial() {
        String varB4EAC82CA7396A68D541C85D26508E83_1579163808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1579163808 = (String) parameters.getValue(POSTDIAL);
        varB4EAC82CA7396A68D541C85D26508E83_1579163808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1579163808;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(POSTDIAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.878 -0400", hash_original_method = "E5D57B503B0E16A000773FA057D6B1B7", hash_generated_method = "804E74F7A7E8721C0F9C34F1D02B97A5")
    public String getIsdnSubaddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1223141205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1223141205 = (String) parameters.getValue(ISUB);
        varB4EAC82CA7396A68D541C85D26508E83_1223141205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1223141205;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.879 -0400", hash_original_method = "E1FFD425535E2D30F5D43A147688D9A7", hash_generated_method = "DACA002E3049E1B411838B1D93DD2B36")
    public boolean hasPostDial() {
        boolean varFF226E7C7804B4C8779D204E4C372EA7_878216184 = (parameters.getValue(POSTDIAL) != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550733745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550733745;
        // ---------- Original Method ----------
        //return parameters.getValue(POSTDIAL) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.879 -0400", hash_original_method = "588E30C769F46315FA0899538D14C7E2", hash_generated_method = "08342A57E9B981E6AF432617AD250504")
    public boolean hasParm(String pname) {
        boolean varE874A1721B6ED57B3E89011DE98FC817_808457940 = (parameters.hasNameValue(pname));
        addTaint(pname.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962601434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962601434;
        // ---------- Original Method ----------
        //return parameters.hasNameValue(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.879 -0400", hash_original_method = "647E85AB615972325C277E376A221EF0", hash_generated_method = "4033776E4AFBAFEE787F0C20DE2A818F")
    public boolean hasIsdnSubaddress() {
        boolean varC0122FBF9B823CE23BEE88359CCBAA0B_2085974958 = (hasParm(ISUB));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159728031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_159728031;
        // ---------- Original Method ----------
        //return hasParm(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.879 -0400", hash_original_method = "26808293282132329FBEA070B2AD722D", hash_generated_method = "57DDA04C465897A8C8A11CE8AF4280FC")
    public boolean isGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164144186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_164144186;
        // ---------- Original Method ----------
        //return isglobal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.880 -0400", hash_original_method = "872EACB97AA4D13F74BE9616D4416942", hash_generated_method = "E8F7D5A33418C1A5618069298CBCDFC0")
    public void removePostDial() {
        parameters.delete(POSTDIAL);
        // ---------- Original Method ----------
        //parameters.delete(POSTDIAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.880 -0400", hash_original_method = "C4A054C6DC361788E8A02206DAB97797", hash_generated_method = "57EE5CD2FBB1671F10B9A34884F9DD7B")
    public void removeIsdnSubaddress() {
        deleteParm(ISUB);
        // ---------- Original Method ----------
        //deleteParm(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.880 -0400", hash_original_method = "779B73549EB95AA1112D17D4BD37698F", hash_generated_method = "959236CB1F720298C9BF15740EF84153")
    public void setParameters(NameValueList p) {
        parameters = p;
        // ---------- Original Method ----------
        //parameters = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.880 -0400", hash_original_method = "AC69D7A5F7431BD993B4E02357C1C328", hash_generated_method = "8AE7A45CDBFC0F972181147E0F3ACDEE")
    public void setGlobal(boolean g) {
        isglobal = g;
        // ---------- Original Method ----------
        //isglobal = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.881 -0400", hash_original_method = "3187783A98FD3EF3CF221F591C928162", hash_generated_method = "8A91489609E8DB55637E79DA8E575E2D")
    public void setPostDial(String p) {
        NameValue nv;
        nv = new NameValue(POSTDIAL, p);
        parameters.set(nv);
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(POSTDIAL, p);
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.881 -0400", hash_original_method = "1017383CE0C4E09E719151FC1E532DF6", hash_generated_method = "9F9E74DA1672DEF3018674F54AEC4E5E")
    public void setParm(String name, Object value) {
        NameValue nv;
        nv = new NameValue(name, value);
        parameters.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.881 -0400", hash_original_method = "2C7FD6CD1F9BBF926548B29323136AA0", hash_generated_method = "8E6BBF662E42950F7E197C716E63603D")
    public void setIsdnSubaddress(String isub) {
        setParm(ISUB, isub);
        addTaint(isub.getTaint());
        // ---------- Original Method ----------
        //setParm(ISUB, isub);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.881 -0400", hash_original_method = "0D906AA6E6C51748158DF0E26B379B98", hash_generated_method = "5792C7D29465A82AFE011B3B06F20683")
    public void setPhoneNumber(String num) {
        phoneNumber = num;
        // ---------- Original Method ----------
        //phoneNumber = num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.882 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "DAED6E422A8A639D15648C4203A28EBC")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_469854691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_469854691 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_469854691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_469854691;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.882 -0400", hash_original_method = "4745D56EA907C8F5BA4F4E737AF3537A", hash_generated_method = "D330D97B0B9A06E07CF3864EC657D1CD")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1844749482 = null; //Variable for return #1
        buffer.append('+');
        buffer.append(phoneNumber);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_682978405 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1844749482 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1844749482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1844749482;
        // ---------- Original Method ----------
        //if (isglobal)
            //buffer.append('+');
        //buffer.append(phoneNumber);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.901 -0400", hash_original_method = "6A189D1F37381970473560C000F9F148", hash_generated_method = "400BAF50589649AF7C525D228AB034D5")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_975724034 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2090927445 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_254253452 = null; //Variable for return #3
        Object val;
        val = parameters.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_975724034 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2090927445 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_254253452 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2067825088; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2067825088 = varB4EAC82CA7396A68D541C85D26508E83_975724034;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2067825088 = varB4EAC82CA7396A68D541C85D26508E83_2090927445;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2067825088 = varB4EAC82CA7396A68D541C85D26508E83_254253452;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2067825088.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2067825088;
        // ---------- Original Method ----------
        //Object val = parameters.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.902 -0400", hash_original_method = "CB48E75FADF5A296C71C66E8605F8AA2", hash_generated_method = "0B9440999041D85B18DAE185CD12F10F")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1150586648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1150586648 = this.parameters.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_1150586648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1150586648;
        // ---------- Original Method ----------
        //return this.parameters.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.902 -0400", hash_original_method = "B7E395B29F4AF7C2E05F5A2CCFC8AF7A", hash_generated_method = "C83C6AB6ED548A5CB8FB517C05404B21")
    public void removeParameter(String parameter) {
        this.parameters.delete(parameter);
        addTaint(parameter.getTaint());
        // ---------- Original Method ----------
        //this.parameters.delete(parameter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.902 -0400", hash_original_method = "EF9A54632618F205C3C318D3100361E8", hash_generated_method = "B2567FBE1331A7F553A56B7AF7CDAA52")
    public void setParameter(String name, String value) {
        NameValue nv;
        nv = new NameValue(name, value);
        this.parameters.set(nv);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //this.parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.903 -0400", hash_original_method = "459B956E59E9D185995D481A4A763AF3", hash_generated_method = "D69CA1435E26BC04A1A061AF2E9F350B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1025067694 = null; //Variable for return #1
        TelephoneNumber retval;
        retval = (TelephoneNumber) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1025067694 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1025067694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1025067694;
        // ---------- Original Method ----------
        //TelephoneNumber retval = (TelephoneNumber) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.903 -0400", hash_original_method = "3F9E254F8A6DAF7B33BDD77A0CAB2530", hash_generated_method = "9354ACA5AD1E541A5C43EA5426869E2E")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_997336272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_997336272 = this.parameters;
        varB4EAC82CA7396A68D541C85D26508E83_997336272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_997336272;
        // ---------- Original Method ----------
        //return this.parameters;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.903 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.903 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.903 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.903 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

