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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.679 -0400", hash_original_field = "9B54CF4C9AEF2A42C8430B43936B405A", hash_generated_field = "F0F600057F56A09C7F67C507D581D80D")

    protected boolean isglobal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.680 -0400", hash_original_field = "C9AA10B21BC611B05B1D8E0C01E5D397", hash_generated_field = "A5887F206856305D82FC53512CE55D3B")

    protected String phoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.680 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.680 -0400", hash_original_method = "C2E661A0F0E8603FDB28C1E5F6957C6B", hash_generated_method = "ED4544B8D5B014FCD0F73770D6821934")
    public  TelephoneNumber() {
        parameters = new NameValueList();
        // ---------- Original Method ----------
        //parameters = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.681 -0400", hash_original_method = "482E6E79DCAAF2107BA2BF4B499737C2", hash_generated_method = "D8C2E8FB7BA5010630FE4FF4E325CC22")
    public void deleteParm(String name) {
        parameters.delete(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.681 -0400", hash_original_method = "52800C2C905EEB817404225ADBC057C1", hash_generated_method = "3BEA6234AC55D956ACB16A7EC6BE5642")
    public String getPhoneNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_162412650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_162412650 = phoneNumber;
        varB4EAC82CA7396A68D541C85D26508E83_162412650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_162412650;
        // ---------- Original Method ----------
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.686 -0400", hash_original_method = "46AF8366350CE91B864B76E1571FD560", hash_generated_method = "54E01A9DE58B7AD131103000110E6B2F")
    public String getPostDial() {
        String varB4EAC82CA7396A68D541C85D26508E83_1463011625 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1463011625 = (String) parameters.getValue(POSTDIAL);
        varB4EAC82CA7396A68D541C85D26508E83_1463011625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1463011625;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(POSTDIAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.686 -0400", hash_original_method = "E5D57B503B0E16A000773FA057D6B1B7", hash_generated_method = "5752D38FD328F0C5F83F8457E480BDC2")
    public String getIsdnSubaddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_86098566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_86098566 = (String) parameters.getValue(ISUB);
        varB4EAC82CA7396A68D541C85D26508E83_86098566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_86098566;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.699 -0400", hash_original_method = "E1FFD425535E2D30F5D43A147688D9A7", hash_generated_method = "BF16CB838064692E6088912254DC6DC6")
    public boolean hasPostDial() {
        boolean varFF226E7C7804B4C8779D204E4C372EA7_936273277 = (parameters.getValue(POSTDIAL) != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577993084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577993084;
        // ---------- Original Method ----------
        //return parameters.getValue(POSTDIAL) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.700 -0400", hash_original_method = "588E30C769F46315FA0899538D14C7E2", hash_generated_method = "0F33A908F3DC7B218F6706301F58F225")
    public boolean hasParm(String pname) {
        boolean varE874A1721B6ED57B3E89011DE98FC817_360709947 = (parameters.hasNameValue(pname));
        addTaint(pname.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101658544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101658544;
        // ---------- Original Method ----------
        //return parameters.hasNameValue(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.713 -0400", hash_original_method = "647E85AB615972325C277E376A221EF0", hash_generated_method = "6790EB28442493984065F594ED88963D")
    public boolean hasIsdnSubaddress() {
        boolean varC0122FBF9B823CE23BEE88359CCBAA0B_1329883896 = (hasParm(ISUB));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983943385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983943385;
        // ---------- Original Method ----------
        //return hasParm(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.713 -0400", hash_original_method = "26808293282132329FBEA070B2AD722D", hash_generated_method = "43AA7982380017694BFCF221EB31CE2D")
    public boolean isGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426597194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426597194;
        // ---------- Original Method ----------
        //return isglobal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.713 -0400", hash_original_method = "872EACB97AA4D13F74BE9616D4416942", hash_generated_method = "E8F7D5A33418C1A5618069298CBCDFC0")
    public void removePostDial() {
        parameters.delete(POSTDIAL);
        // ---------- Original Method ----------
        //parameters.delete(POSTDIAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.714 -0400", hash_original_method = "C4A054C6DC361788E8A02206DAB97797", hash_generated_method = "57EE5CD2FBB1671F10B9A34884F9DD7B")
    public void removeIsdnSubaddress() {
        deleteParm(ISUB);
        // ---------- Original Method ----------
        //deleteParm(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.714 -0400", hash_original_method = "779B73549EB95AA1112D17D4BD37698F", hash_generated_method = "959236CB1F720298C9BF15740EF84153")
    public void setParameters(NameValueList p) {
        parameters = p;
        // ---------- Original Method ----------
        //parameters = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.715 -0400", hash_original_method = "AC69D7A5F7431BD993B4E02357C1C328", hash_generated_method = "8AE7A45CDBFC0F972181147E0F3ACDEE")
    public void setGlobal(boolean g) {
        isglobal = g;
        // ---------- Original Method ----------
        //isglobal = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.715 -0400", hash_original_method = "3187783A98FD3EF3CF221F591C928162", hash_generated_method = "8A91489609E8DB55637E79DA8E575E2D")
    public void setPostDial(String p) {
        NameValue nv;
        nv = new NameValue(POSTDIAL, p);
        parameters.set(nv);
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(POSTDIAL, p);
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.719 -0400", hash_original_method = "1017383CE0C4E09E719151FC1E532DF6", hash_generated_method = "9F9E74DA1672DEF3018674F54AEC4E5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.719 -0400", hash_original_method = "2C7FD6CD1F9BBF926548B29323136AA0", hash_generated_method = "8E6BBF662E42950F7E197C716E63603D")
    public void setIsdnSubaddress(String isub) {
        setParm(ISUB, isub);
        addTaint(isub.getTaint());
        // ---------- Original Method ----------
        //setParm(ISUB, isub);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.723 -0400", hash_original_method = "0D906AA6E6C51748158DF0E26B379B98", hash_generated_method = "5792C7D29465A82AFE011B3B06F20683")
    public void setPhoneNumber(String num) {
        phoneNumber = num;
        // ---------- Original Method ----------
        //phoneNumber = num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.731 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3D0131B86DA030D815BD23871DBAB329")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1217707497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1217707497 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1217707497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217707497;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.732 -0400", hash_original_method = "4745D56EA907C8F5BA4F4E737AF3537A", hash_generated_method = "4C6EE67BA910D584876C74B0E2B5E5D0")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1604669838 = null; //Variable for return #1
        buffer.append('+');
        buffer.append(phoneNumber);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1272389186 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1604669838 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1604669838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1604669838;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.794 -0400", hash_original_method = "6A189D1F37381970473560C000F9F148", hash_generated_method = "E7611AD48BA3FF70522F5FAF39B91494")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_637014867 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1608518417 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1233526474 = null; //Variable for return #3
        Object val;
        val = parameters.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_637014867 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1608518417 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_1233526474 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1197406705; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1197406705 = varB4EAC82CA7396A68D541C85D26508E83_637014867;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1197406705 = varB4EAC82CA7396A68D541C85D26508E83_1608518417;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1197406705 = varB4EAC82CA7396A68D541C85D26508E83_1233526474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1197406705.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1197406705;
        // ---------- Original Method ----------
        //Object val = parameters.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.795 -0400", hash_original_method = "CB48E75FADF5A296C71C66E8605F8AA2", hash_generated_method = "34EDE3CD8EF4F913E519E9E5AD6CCD12")
    public Iterator<String> getParameterNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_163785602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_163785602 = this.parameters.getNames();
        varB4EAC82CA7396A68D541C85D26508E83_163785602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_163785602;
        // ---------- Original Method ----------
        //return this.parameters.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.796 -0400", hash_original_method = "B7E395B29F4AF7C2E05F5A2CCFC8AF7A", hash_generated_method = "C83C6AB6ED548A5CB8FB517C05404B21")
    public void removeParameter(String parameter) {
        this.parameters.delete(parameter);
        addTaint(parameter.getTaint());
        // ---------- Original Method ----------
        //this.parameters.delete(parameter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.809 -0400", hash_original_method = "EF9A54632618F205C3C318D3100361E8", hash_generated_method = "B2567FBE1331A7F553A56B7AF7CDAA52")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.809 -0400", hash_original_method = "459B956E59E9D185995D481A4A763AF3", hash_generated_method = "7267EECDBF04BE331D3A935A75BD3ED9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_34010916 = null; //Variable for return #1
        TelephoneNumber retval;
        retval = (TelephoneNumber) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_34010916 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_34010916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_34010916;
        // ---------- Original Method ----------
        //TelephoneNumber retval = (TelephoneNumber) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.810 -0400", hash_original_method = "3F9E254F8A6DAF7B33BDD77A0CAB2530", hash_generated_method = "1BF79164AD4666D42FDD16CAD1D5E164")
    public NameValueList getParameters() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_2019258622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2019258622 = this.parameters;
        varB4EAC82CA7396A68D541C85D26508E83_2019258622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2019258622;
        // ---------- Original Method ----------
        //return this.parameters;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.810 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.810 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.810 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.810 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

