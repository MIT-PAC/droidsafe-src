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
    protected boolean isglobal;
    protected String phoneNumber;
    protected NameValueList parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.502 -0400", hash_original_method = "C2E661A0F0E8603FDB28C1E5F6957C6B", hash_generated_method = "ED4544B8D5B014FCD0F73770D6821934")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TelephoneNumber() {
        parameters = new NameValueList();
        // ---------- Original Method ----------
        //parameters = new NameValueList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.503 -0400", hash_original_method = "482E6E79DCAAF2107BA2BF4B499737C2", hash_generated_method = "7FE3525D9276F22AA3CC4A1898EE17B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteParm(String name) {
        dsTaint.addTaint(name);
        parameters.delete(name);
        // ---------- Original Method ----------
        //parameters.delete(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.503 -0400", hash_original_method = "52800C2C905EEB817404225ADBC057C1", hash_generated_method = "B07CA44C3669A227F17FDAFDDEFA6CA1")
    @DSModeled(DSC.SAFE)
    public String getPhoneNumber() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.503 -0400", hash_original_method = "46AF8366350CE91B864B76E1571FD560", hash_generated_method = "C803CB310E1FE871276280ADCB9B15BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPostDial() {
        String var2CBBE47D66F5BD7B268DA9331DD12F10_145223129 = ((String) parameters.getValue(POSTDIAL));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) parameters.getValue(POSTDIAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.503 -0400", hash_original_method = "E5D57B503B0E16A000773FA057D6B1B7", hash_generated_method = "FEEEDBA22E199E1120B71076E5DB53FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsdnSubaddress() {
        String varE12808E639646487E11F6D397FB96095_305061553 = ((String) parameters.getValue(ISUB));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.503 -0400", hash_original_method = "E1FFD425535E2D30F5D43A147688D9A7", hash_generated_method = "B20813B9D209BF240BEC19080AD4CEB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasPostDial() {
        boolean varFF226E7C7804B4C8779D204E4C372EA7_702741061 = (parameters.getValue(POSTDIAL) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parameters.getValue(POSTDIAL) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.503 -0400", hash_original_method = "588E30C769F46315FA0899538D14C7E2", hash_generated_method = "733326927DF3EBD4CEBB5A803EB1C48F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasParm(String pname) {
        dsTaint.addTaint(pname);
        boolean varE874A1721B6ED57B3E89011DE98FC817_2688417 = (parameters.hasNameValue(pname));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parameters.hasNameValue(pname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "647E85AB615972325C277E376A221EF0", hash_generated_method = "EB3E796FC7F3BB8D5633403A9C64DFFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasIsdnSubaddress() {
        boolean varC0122FBF9B823CE23BEE88359CCBAA0B_994269995 = (hasParm(ISUB));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasParm(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "26808293282132329FBEA070B2AD722D", hash_generated_method = "A4301166523599FBFC3C2086F968D0F3")
    @DSModeled(DSC.SAFE)
    public boolean isGlobal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isglobal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "872EACB97AA4D13F74BE9616D4416942", hash_generated_method = "E8F7D5A33418C1A5618069298CBCDFC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePostDial() {
        parameters.delete(POSTDIAL);
        // ---------- Original Method ----------
        //parameters.delete(POSTDIAL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "C4A054C6DC361788E8A02206DAB97797", hash_generated_method = "57EE5CD2FBB1671F10B9A34884F9DD7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeIsdnSubaddress() {
        deleteParm(ISUB);
        // ---------- Original Method ----------
        //deleteParm(ISUB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "779B73549EB95AA1112D17D4BD37698F", hash_generated_method = "2F84034A3C868B94DFF0DFCE6E09F9C9")
    @DSModeled(DSC.SAFE)
    public void setParameters(NameValueList p) {
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
        //parameters = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "AC69D7A5F7431BD993B4E02357C1C328", hash_generated_method = "57083573D8769380DFE80F1167D5DA1E")
    @DSModeled(DSC.SAFE)
    public void setGlobal(boolean g) {
        dsTaint.addTaint(g);
        // ---------- Original Method ----------
        //isglobal = g;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "3187783A98FD3EF3CF221F591C928162", hash_generated_method = "87B7B9CD1033C5AAFC69B00B02D784E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPostDial(String p) {
        dsTaint.addTaint(p);
        NameValue nv;
        nv = new NameValue(POSTDIAL, p);
        parameters.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(POSTDIAL, p);
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.504 -0400", hash_original_method = "1017383CE0C4E09E719151FC1E532DF6", hash_generated_method = "301F2A0F6A72546187436976C752ED62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParm(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        NameValue nv;
        nv = new NameValue(name, value);
        parameters.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.505 -0400", hash_original_method = "2C7FD6CD1F9BBF926548B29323136AA0", hash_generated_method = "BE5FDBC55169DFDADB5B29D9AD976466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsdnSubaddress(String isub) {
        dsTaint.addTaint(isub);
        setParm(ISUB, isub);
        // ---------- Original Method ----------
        //setParm(ISUB, isub);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.505 -0400", hash_original_method = "0D906AA6E6C51748158DF0E26B379B98", hash_generated_method = "F2B852BC86834CBD615B25306DEA9A02")
    @DSModeled(DSC.SAFE)
    public void setPhoneNumber(String num) {
        dsTaint.addTaint(num);
        // ---------- Original Method ----------
        //phoneNumber = num;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.505 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "5C436EED7C853FF30470A8A71C9F6631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_430808754 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.505 -0400", hash_original_method = "4745D56EA907C8F5BA4F4E737AF3537A", hash_generated_method = "2D670377B60F4E0D8F9D5B1D08956F86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append('+');
        buffer.append(phoneNumber);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1606342488 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.505 -0400", hash_original_method = "6A189D1F37381970473560C000F9F148", hash_generated_method = "17224C8BDF8006474ECB919A3F35988F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        Object val;
        val = parameters.getValue(name);
        String var95441B18ED228B9E74BF37F54C5F5827_2012613299 = (((GenericObject) val).encode());
        String var1256D27AA7319A7570F46BC6DF2B0099_1638645023 = (val.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object val = parameters.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.505 -0400", hash_original_method = "CB48E75FADF5A296C71C66E8605F8AA2", hash_generated_method = "D663E40AD2542224D8C66F936F88A6DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getParameterNames() {
        Iterator<String> var3602ED351EA29A0326F2925B271A1230_560857771 = (this.parameters.getNames());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.parameters.getNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.506 -0400", hash_original_method = "B7E395B29F4AF7C2E05F5A2CCFC8AF7A", hash_generated_method = "9CE6D10269F45D248F61F0A59625FA0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameter(String parameter) {
        dsTaint.addTaint(parameter);
        this.parameters.delete(parameter);
        // ---------- Original Method ----------
        //this.parameters.delete(parameter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.506 -0400", hash_original_method = "EF9A54632618F205C3C318D3100361E8", hash_generated_method = "8A913B74C480FE8804BA0374716AB37A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        NameValue nv;
        nv = new NameValue(name, value);
        this.parameters.set(nv);
        // ---------- Original Method ----------
        //NameValue nv = new NameValue(name, value);
        //this.parameters.set(nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.506 -0400", hash_original_method = "459B956E59E9D185995D481A4A763AF3", hash_generated_method = "A8ABAF5EE6B30A7448A3BCE4614DC313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        TelephoneNumber retval;
        retval = (TelephoneNumber) super.clone();
        retval.parameters = (NameValueList) this.parameters.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TelephoneNumber retval = (TelephoneNumber) super.clone();
        //if (this.parameters != null)
            //retval.parameters = (NameValueList) this.parameters.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.506 -0400", hash_original_method = "3F9E254F8A6DAF7B33BDD77A0CAB2530", hash_generated_method = "67DA72AE4E847B3AD3BF200F76376A91")
    @DSModeled(DSC.SAFE)
    public NameValueList getParameters() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.parameters;
    }

    
    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    public static final String ISUB = ParameterNames.ISUB;
    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

