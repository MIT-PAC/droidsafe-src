package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.AddressImpl;
import javax.sip.InvalidArgumentException;
import javax.sip.header.ContactHeader;
import java.text.ParseException;

public final class Contact extends AddressParametersHeader implements javax.sip.header.ContactHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.359 -0400", hash_original_field = "2C04975BEEFBAA5B93021155A216F16C", hash_generated_field = "F8D42AD524689A7075829FDA71AD2B65")

    private ContactList contactList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.359 -0400", hash_original_field = "2B693317E0EDEF07068B2C8EBF6F79C5", hash_generated_field = "59B10415DC4BAEC3C3C191C79EC370BD")

    protected boolean wildCardFlag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.360 -0400", hash_original_method = "91EC1BE71FCEDDA82A3A1E5DD0E8F369", hash_generated_method = "2C3BCCEE45586F853C3FCDA950D37478")
    public  Contact() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.360 -0400", hash_original_method = "610F5F9F0EA9EBC7B3CD81D4F6E695C1", hash_generated_method = "BA27AF5FA8C6A77454ADCACE3EAC7BEA")
    public void setParameter(String name, String value) throws ParseException {
        NameValue nv = parameters.getNameValue(name);
        {
            nv.setValueAsObject(value);
        } //End block
        {
            nv = new NameValue(name, value);
            {
                boolean var647F956355671F9455B48FA87E1C745B_54009974 = (name.equalsIgnoreCase("methods"));
                nv.setQuotedValue();
            } //End collapsed parenthetic
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
            //if (name.equalsIgnoreCase("methods"))
                //nv.setQuotedValue();
            //this.parameters.set(nv);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.361 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "C4EA5BD20904C2A46D5A099AE22A2A4D")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_415941180 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_415941180 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_415941180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415941180;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.361 -0400", hash_original_method = "E69C365FF0754FE9819DC42713FEDDD9", hash_generated_method = "7B700BB3C5ECEB84E1CE0F833898A06F")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1312876600 = null; //Variable for return #1
        {
            buffer.append('*');
        } //End block
        {
            {
                boolean var7F47A3C4E14B8FA5E4D03686CD4BF75C_501584517 = (address.getAddressType() == AddressImpl.NAME_ADDR);
                {
                    address.encode(buffer);
                } //End block
                {
                    buffer.append('<');
                    address.encode(buffer);
                    buffer.append('>');
                } //End block
            } //End collapsed parenthetic
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1955239030 = (!parameters.isEmpty());
                {
                    buffer.append(SEMICOLON);
                    parameters.encode(buffer);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1312876600 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1312876600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1312876600;
        // ---------- Original Method ----------
        //if (wildCardFlag) {
            //buffer.append('*');
        //}
        //else {
            //if (address.getAddressType() == AddressImpl.NAME_ADDR) {
                //address.encode(buffer);
            //} else {
                //buffer.append('<');
                //address.encode(buffer);
                //buffer.append('>');
            //}
            //if (!parameters.isEmpty()) {
                //buffer.append(SEMICOLON);
                //parameters.encode(buffer);
            //}
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.362 -0400", hash_original_method = "1B424E93D6F15660DA959554DF30A2C0", hash_generated_method = "3057F687892413FFCB26A8BE654C4F4F")
    public ContactList getContactList() {
        ContactList varB4EAC82CA7396A68D541C85D26508E83_1427333944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1427333944 = contactList;
        varB4EAC82CA7396A68D541C85D26508E83_1427333944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1427333944;
        // ---------- Original Method ----------
        //return contactList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.362 -0400", hash_original_method = "B792A1C78C2262E486AC16BC668CCB6D", hash_generated_method = "20B3CC80E4907C5A607ABB0545E16696")
    public boolean getWildCardFlag() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160381066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160381066;
        // ---------- Original Method ----------
        //return wildCardFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.362 -0400", hash_original_method = "569FFD65B001A83BF27BFBDAD6B4F486", hash_generated_method = "746D4CF4A3C156520F273ECC87268A6E")
    public javax.sip.address.Address getAddress() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1561394333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1561394333 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1561394333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561394333;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.363 -0400", hash_original_method = "4240C3A651BA1AB39E9A42DB8D1F003A", hash_generated_method = "6B8CB6E8FDCCEE1E4D7BCB65FD483C84")
    public NameValueList getContactParms() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1070688939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1070688939 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1070688939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1070688939;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.363 -0400", hash_original_method = "96E910216AC02ADF852A54B56C70C152", hash_generated_method = "E09C2E2D7B754C091E1E8D31870ED240")
    public int getExpires() {
        int varFDB2492FCE1BE234DBA6E54BD115D16E_1879920826 = (getParameterAsInt(EXPIRES));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326992270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326992270;
        // ---------- Original Method ----------
        //return getParameterAsInt(EXPIRES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.363 -0400", hash_original_method = "C2F655E77754B7E4118A4EC585DCE004", hash_generated_method = "7B174AFAED55CE1AE0F7FF255C67A6A8")
    public void setExpires(int expiryDeltaSeconds) {
        Integer deltaSeconds = Integer.valueOf(expiryDeltaSeconds);
        this.parameters.set(EXPIRES, deltaSeconds);
        addTaint(expiryDeltaSeconds);
        // ---------- Original Method ----------
        //Integer deltaSeconds = Integer.valueOf(expiryDeltaSeconds);
        //this.parameters.set(EXPIRES, deltaSeconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.364 -0400", hash_original_method = "99DBCB27F8E3FF6C21E31F78BC4B32FC", hash_generated_method = "E5887BAAAF34D5E671B0558EE93A1604")
    public float getQValue() {
        float var09D64B94381E59C3343DF734687BCE8D_184792855 = (getParameterAsFloat(Q));
        float var546ADE640B6EDFBC8A086EF31347E768_1392155915 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1392155915;
        // ---------- Original Method ----------
        //return getParameterAsFloat(Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.364 -0400", hash_original_method = "395F7CDC4269F17B37AD1CEF3C00E158", hash_generated_method = "F406E6A3D3ADCD0A3AC23AB6EA1E1A36")
    public void setContactList(ContactList cl) {
        contactList = cl;
        // ---------- Original Method ----------
        //contactList = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.364 -0400", hash_original_method = "967084D665F0048759202AF27AE04FCB", hash_generated_method = "D06631695EA609A336B08F28D5E3C66A")
    public void setWildCardFlag(boolean w) {
        this.wildCardFlag = true;
        this.address = new AddressImpl();
        this.address.setWildCardFlag();
        addTaint(w);
        // ---------- Original Method ----------
        //this.wildCardFlag = true;
        //this.address = new AddressImpl();
        //this.address.setWildCardFlag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.364 -0400", hash_original_method = "8D515165C9CEE70CC9BAE834218A7BF9", hash_generated_method = "B12B262FD4F882CC398E0DE33695E0B7")
    public void setAddress(javax.sip.address.Address address) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        this.address = (AddressImpl) address;
        this.wildCardFlag = false;
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //this.address = (AddressImpl) address;
        //this.wildCardFlag = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.365 -0400", hash_original_method = "BB23584FB6F9D8E00697707A3889A96F", hash_generated_method = "2304920DFC646EFDDBE8669B077A18D0")
    public void setQValue(float qValue) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception, Contact, setQValue(), "
                    + "the qValue is not between 0 and 1");
        this.parameters.set(Q, Float.valueOf(qValue));
        addTaint(qValue);
        // ---------- Original Method ----------
        //if (qValue != -1 && (qValue < 0 || qValue > 1))
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception, Contact, setQValue(), "
                    //+ "the qValue is not between 0 and 1");
        //this.parameters.set(Q, Float.valueOf(qValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.365 -0400", hash_original_method = "286D385E6B16CCC7A8923BBB55E45ED9", hash_generated_method = "F0825B373EDEA1D894DA77971C4D7189")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_492879236 = null; //Variable for return #1
        Contact retval = (Contact) super.clone();
        retval.contactList = (ContactList) this.contactList.clone();
        varB4EAC82CA7396A68D541C85D26508E83_492879236 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_492879236.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492879236;
        // ---------- Original Method ----------
        //Contact retval = (Contact) super.clone();
        //if (this.contactList != null)
            //retval.contactList = (ContactList) this.contactList.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.365 -0400", hash_original_method = "1E8417DABA85DBF8E3B8DCC75DF6036F", hash_generated_method = "BD71C9D7F2E71AD98661C4BC21983493")
    public void setWildCard() {
        this.setWildCardFlag(true);
        // ---------- Original Method ----------
        //this.setWildCardFlag(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.366 -0400", hash_original_method = "BD70FF709E52160B451422333F6894A9", hash_generated_method = "EEAF32EE21000CB6F5A116EFDCE65F6F")
    public boolean isWildCard() {
        boolean var42CAEB14A894C820412D4A66F4594354_470339337 = (this.address.isWildcard());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253592042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253592042;
        // ---------- Original Method ----------
        //return this.address.isWildcard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.366 -0400", hash_original_method = "BA2F3C2ED46538A7D01836631FBE38C7", hash_generated_method = "71D42D43AD56EA306EACB8262A4CBCB9")
    public boolean equals(Object other) {
        boolean varB1A526B930D24017C6DCC02F251EF32F_1873297776 = ((other instanceof ContactHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273590080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273590080;
        // ---------- Original Method ----------
        //return (other instanceof ContactHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.366 -0400", hash_original_method = "D8F26C6BEBC4025EE87D6A90A29B455D", hash_generated_method = "5FC82894F372EBFD5DEDB17DE40FB716")
    public void removeSipInstanceParam() {
        parameters.delete(ParameterNames.SIP_INSTANCE);
        // ---------- Original Method ----------
        //if (parameters != null)
            //parameters.delete(ParameterNames.SIP_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.366 -0400", hash_original_method = "EA50318741E259995DB1E983FC6CAFD1", hash_generated_method = "2F2DCCEE7528D3D689C0F5F9A9D455BB")
    public String getSipInstanceParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_1443703907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1443703907 = (String) parameters.getValue(ParameterNames.SIP_INSTANCE);
        varB4EAC82CA7396A68D541C85D26508E83_1443703907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1443703907;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ParameterNames.SIP_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.366 -0400", hash_original_method = "B439361A999D0B73C2E9828E38E26B04", hash_generated_method = "75B18E01D86390E18C952838495F9BF7")
    public void setSipInstanceParam(String value) {
        this.parameters.set(ParameterNames.SIP_INSTANCE, value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(ParameterNames.SIP_INSTANCE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.367 -0400", hash_original_method = "8AD6127ED19B3CFA328D7ED80A755AFB", hash_generated_method = "F387D63A901A1E8DF9D1EBC9C16D1426")
    public void removePubGruuParam() {
        parameters.delete(ParameterNames.PUB_GRUU);
        // ---------- Original Method ----------
        //if (parameters != null)
            //parameters.delete(ParameterNames.PUB_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.367 -0400", hash_original_method = "3B3B357FD219B3690182EE4F60CD3DC6", hash_generated_method = "74F1200BFF2425D3C9AE06D8957AE965")
    public String getPubGruuParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_1255298337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1255298337 = (String) parameters.getValue(ParameterNames.PUB_GRUU);
        varB4EAC82CA7396A68D541C85D26508E83_1255298337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1255298337;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ParameterNames.PUB_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.367 -0400", hash_original_method = "E6BD4CB1D1049F858BE017703EF776B9", hash_generated_method = "8FF7F3CC862DDA60F352BA5F13775D56")
    public void setPubGruuParam(String value) {
        this.parameters.set(ParameterNames.PUB_GRUU, value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(ParameterNames.PUB_GRUU, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.368 -0400", hash_original_method = "493973B7C3E0E7D72E4F9CB95002E20E", hash_generated_method = "97C9A645527B3A1ACBDF16518A06250A")
    public void removeTempGruuParam() {
        parameters.delete(ParameterNames.TEMP_GRUU);
        // ---------- Original Method ----------
        //if (parameters != null)
            //parameters.delete(ParameterNames.TEMP_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.368 -0400", hash_original_method = "19861AEE803C91FE7A0A9CDBD1C78B9E", hash_generated_method = "4FCE34E5F50B8D9AB3BFE7614DDC4212")
    public String getTempGruuParam() {
        String varB4EAC82CA7396A68D541C85D26508E83_935712742 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_935712742 = (String) parameters.getValue(ParameterNames.TEMP_GRUU);
        varB4EAC82CA7396A68D541C85D26508E83_935712742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_935712742;
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ParameterNames.TEMP_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.368 -0400", hash_original_method = "64FD1572329B063AD4EC10A23207E509", hash_generated_method = "E3D76782A7B00CA2B61FF0995AAD6308")
    public void setTempGruuParam(String value) {
        this.parameters.set(ParameterNames.TEMP_GRUU, value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.parameters.set(ParameterNames.TEMP_GRUU, value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.368 -0400", hash_original_field = "5AFC9165F4F13161D6E81B7A52284790", hash_generated_field = "D5EF41A2EAE5A5CDE5AE467B71E69779")

    private static final long serialVersionUID = 1677294871695706288L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.368 -0400", hash_original_field = "5273C05B8C162F0DB818C1AB4FDFA2C6", hash_generated_field = "625B8D92ECBBC935F308044A15203C68")

    public static final String ACTION = ParameterNames.ACTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.369 -0400", hash_original_field = "C2AD9A521A1D1921C119673CB9B1F68D", hash_generated_field = "E03817F60405358048E53FECF5415E6C")

    public static final String PROXY = ParameterNames.PROXY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.369 -0400", hash_original_field = "E6426B79DCBB46AAF1038F671A23F80C", hash_generated_field = "6F331C4088ABB38593B6B56E77FD3DE2")

    public static final String REDIRECT = ParameterNames.REDIRECT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.369 -0400", hash_original_field = "8206C7AE7A741E76A468E0365AAB524A", hash_generated_field = "2F624D23D3BCA37A8CA767DF354E972D")

    public static final String EXPIRES = ParameterNames.EXPIRES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.369 -0400", hash_original_field = "C499215B945D2E6EF56503E60F1557DE", hash_generated_field = "FF045AAD7F2A2328EB43131E44B9ED97")

    public static final String Q = ParameterNames.Q;
}

