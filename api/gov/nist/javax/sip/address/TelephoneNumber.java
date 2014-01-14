package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.GenericObject;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;

import java.util.Iterator;

public class TelephoneNumber extends NetObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.981 -0500", hash_original_field = "D104C1337470F36AA025365EB957B7D6", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.984 -0500", hash_original_field = "4F833DA0B2EA492F72D2F4DF55E7A6E2", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.986 -0500", hash_original_field = "C6769006DFB5E1A378E4FAA30CA809DE", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.989 -0500", hash_original_field = "34038E5BEFCC81136653C76DB115C017", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.991 -0500", hash_original_field = "7FC57AD385B2D3F8C9978D3503003DAD", hash_generated_field = "F0F600057F56A09C7F67C507D581D80D")

    protected boolean isglobal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.993 -0500", hash_original_field = "A04F843FCA6ED01F4CA0662FF1DB199D", hash_generated_field = "A5887F206856305D82FC53512CE55D3B")

    protected String phoneNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.996 -0500", hash_original_field = "C664820D6996E8B6AE3D3EE9831870E4", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;

    /** Creates new TelephoneNumber */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.999 -0500", hash_original_method = "C2E661A0F0E8603FDB28C1E5F6957C6B", hash_generated_method = "95DC2C129422F64A66344E11E737DF10")
    
public TelephoneNumber() {
        parameters = new NameValueList();
    }

    /** delete the specified parameter.
     * @param name String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.001 -0500", hash_original_method = "482E6E79DCAAF2107BA2BF4B499737C2", hash_generated_method = "9D4B12A61BFB1D2AC131CA59E47BD88A")
    
public void deleteParm(String name) {
        parameters.delete(name);
    }

    /** get the PhoneNumber field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.004 -0500", hash_original_method = "52800C2C905EEB817404225ADBC057C1", hash_generated_method = "C5F3A0B43CCDF32B57638463AE04B6FD")
    
public String getPhoneNumber() {
        return phoneNumber;
    }

    /** get the PostDial field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.007 -0500", hash_original_method = "46AF8366350CE91B864B76E1571FD560", hash_generated_method = "4758906A5493DFDD06C61F8D199C8AC2")
    
public String getPostDial() {
        return (String) parameters.getValue(POSTDIAL);
    }

    /**
     * Get the isdn subaddress for this number.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.009 -0500", hash_original_method = "E5D57B503B0E16A000773FA057D6B1B7", hash_generated_method = "A1EF2097DB4348ADD75838AEFAC59440")
    
public String getIsdnSubaddress() {
        return (String) parameters.getValue(ISUB);
    }

    /** returns true if th PostDial field exists
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.012 -0500", hash_original_method = "E1FFD425535E2D30F5D43A147688D9A7", hash_generated_method = "0C49D2C39D6052044BC4541376015902")
    
public boolean hasPostDial() {
        return parameters.getValue(POSTDIAL) != null;
    }

    /** return true if this header has parameters.
     * @param pname String to set
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.014 -0500", hash_original_method = "588E30C769F46315FA0899538D14C7E2", hash_generated_method = "D856B998DECD43338AFD989E289B53ED")
    
public boolean hasParm(String pname) {
        return parameters.hasNameValue(pname);
    }

    /**
     * return true if the isdn subaddress exists.
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.017 -0500", hash_original_method = "647E85AB615972325C277E376A221EF0", hash_generated_method = "9835D90D4E0E7CCFFD07C436051E80EB")
    
public boolean hasIsdnSubaddress() {
        return hasParm(ISUB);
    }

    /**
     * is a global telephone number.
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.019 -0500", hash_original_method = "26808293282132329FBEA070B2AD722D", hash_generated_method = "8BED95A0719243A753F175FC203918B8")
    
public boolean isGlobal() {
        return isglobal;
    }

    /** remove the PostDial field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.021 -0500", hash_original_method = "872EACB97AA4D13F74BE9616D4416942", hash_generated_method = "F2C0CE0A613EB32C96FB34719DA1F31D")
    
public void removePostDial() {
        parameters.delete(POSTDIAL);
    }

    /**
     * Remove the isdn subaddress (if it exists).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.024 -0500", hash_original_method = "C4A054C6DC361788E8A02206DAB97797", hash_generated_method = "8B729B70D3C5403C9FC935F93F5F2237")
    
public void removeIsdnSubaddress() {
        deleteParm(ISUB);
    }

    /**
     * Set the list of parameters.
     * @param p NameValueList to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.026 -0500", hash_original_method = "779B73549EB95AA1112D17D4BD37698F", hash_generated_method = "5A890016F18B5174326B4408E2B58722")
    
public void setParameters(NameValueList p) {
        parameters = p;
    }

    /** set the Global field
     * @param g boolean to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.029 -0500", hash_original_method = "AC69D7A5F7431BD993B4E02357C1C328", hash_generated_method = "3C9C65E24BEAAC241CEBE7C234D27E12")
    
public void setGlobal(boolean g) {
        isglobal = g;
    }

    /** set the PostDial field
     * @param p String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.031 -0500", hash_original_method = "3187783A98FD3EF3CF221F591C928162", hash_generated_method = "4F0C1AF4598E1C7F778653C94336D06A")
    
public void setPostDial(String p) {
        NameValue nv = new NameValue(POSTDIAL, p);
        parameters.set(nv);
    }

    /** set the specified parameter
     * @param name String to set
     * @param value Object to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.033 -0500", hash_original_method = "1017383CE0C4E09E719151FC1E532DF6", hash_generated_method = "706B69033C1ACCBFE93063D1B4901BB8")
    
public void setParm(String name, Object value) {
        NameValue nv = new NameValue(name, value);
        parameters.set(nv);
    }

    /**
     * set the isdn subaddress for this structure.
     * @param isub String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.035 -0500", hash_original_method = "2C7FD6CD1F9BBF926548B29323136AA0", hash_generated_method = "D817A7F7C9104170242DD5B80D1DEF8E")
    
public void setIsdnSubaddress(String isub) {
        setParm(ISUB, isub);
    }

    /** set the PhoneNumber field
     * @param num String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.038 -0500", hash_original_method = "0D906AA6E6C51748158DF0E26B379B98", hash_generated_method = "C76FA94565480B08FFAEC1C9D76FDB57")
    
public void setPhoneNumber(String num) {
        phoneNumber = num;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.041 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.043 -0500", hash_original_method = "4745D56EA907C8F5BA4F4E737AF3537A", hash_generated_method = "1690F171EEAC94077F43EC25A18E2C37")
    
public StringBuffer encode(StringBuffer buffer) {
        if (isglobal)
            buffer.append('+');
        buffer.append(phoneNumber);
        if (!parameters.isEmpty()) {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        }
        return buffer;
    }

    /**
     * Returns the value of the named parameter, or null if it is not set. A
     * zero-length String indicates flag parameter.
     *
     * @param name name of parameter to retrieve
     *
     * @return the value of specified parameter
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.046 -0500", hash_original_method = "6A189D1F37381970473560C000F9F148", hash_generated_method = "CAAB1790A22E8E2F0E1916C17126B8EF")
    
public String getParameter(String name) {
        Object val = parameters.getValue(name);
        if (val == null)
            return null;
        if (val instanceof GenericObject)
            return ((GenericObject) val).encode();
        else
            return val.toString();
    }

    /**
     *
     * Returns an Iterator over the names (Strings) of all parameters.
     *
     * @return an Iterator over all the parameter names
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.048 -0500", hash_original_method = "CB48E75FADF5A296C71C66E8605F8AA2", hash_generated_method = "EA8343FF79F148A5D8DAEE1F865A3E68")
    
public Iterator<String> getParameterNames() {
        return this.parameters.getNames();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.051 -0500", hash_original_method = "B7E395B29F4AF7C2E05F5A2CCFC8AF7A", hash_generated_method = "70787DF37E018DB92A92FE1944208937")
    
public void removeParameter(String parameter) {
        this.parameters.delete(parameter);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.054 -0500", hash_original_method = "EF9A54632618F205C3C318D3100361E8", hash_generated_method = "6DD1F73AFDBFE5DDAF2ADFBD44A4E230")
    
public void setParameter(String name, String value) {
        NameValue nv = new NameValue(name, value);
        this.parameters.set(nv);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.056 -0500", hash_original_method = "459B956E59E9D185995D481A4A763AF3", hash_generated_method = "1635BF90DFA255E67007974322FCC816")
    
public Object clone() {
        TelephoneNumber retval = (TelephoneNumber) super.clone();
        if (this.parameters != null)
            retval.parameters = (NameValueList) this.parameters.clone();
        return retval;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.058 -0500", hash_original_method = "3F9E254F8A6DAF7B33BDD77A0CAB2530", hash_generated_method = "EBF708559E4879AB7699F55874776EE2")
    
public NameValueList getParameters() {
        return this.parameters;
    }
}

