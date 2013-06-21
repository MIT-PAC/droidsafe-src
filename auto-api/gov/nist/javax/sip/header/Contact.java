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
    private ContactList contactList;
    protected boolean wildCardFlag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.876 -0400", hash_original_method = "91EC1BE71FCEDDA82A3A1E5DD0E8F369", hash_generated_method = "2C3BCCEE45586F853C3FCDA950D37478")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Contact() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.876 -0400", hash_original_method = "610F5F9F0EA9EBC7B3CD81D4F6E695C1", hash_generated_method = "A3A72E409F2B8381894FFCFCD97AA93F")
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
            {
                boolean var647F956355671F9455B48FA87E1C745B_1417668290 = (name.equalsIgnoreCase("methods"));
                nv.setQuotedValue();
            } //End collapsed parenthetic
            this.parameters.set(nv);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.876 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "C1E781EB2B98FAF69EADE82432DA77FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1236935646 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.876 -0400", hash_original_method = "E69C365FF0754FE9819DC42713FEDDD9", hash_generated_method = "90F36180B3B46D4F5FC30A3334DC3E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            buffer.append('*');
        } //End block
        {
            {
                boolean var7F47A3C4E14B8FA5E4D03686CD4BF75C_1724926229 = (address.getAddressType() == AddressImpl.NAME_ADDR);
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
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1847794923 = (!parameters.isEmpty());
                {
                    buffer.append(SEMICOLON);
                    parameters.encode(buffer);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.877 -0400", hash_original_method = "1B424E93D6F15660DA959554DF30A2C0", hash_generated_method = "4905082CF3CA7DD4239D4308D1D15A35")
    @DSModeled(DSC.SAFE)
    public ContactList getContactList() {
        return (ContactList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contactList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.877 -0400", hash_original_method = "B792A1C78C2262E486AC16BC668CCB6D", hash_generated_method = "DF3C6A297A05B89CB89FB967557AFB2E")
    @DSModeled(DSC.SAFE)
    public boolean getWildCardFlag() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return wildCardFlag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.877 -0400", hash_original_method = "569FFD65B001A83BF27BFBDAD6B4F486", hash_generated_method = "096165C381DEAC5C67EEAC413D9BBBE3")
    @DSModeled(DSC.SAFE)
    public javax.sip.address.Address getAddress() {
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.877 -0400", hash_original_method = "4240C3A651BA1AB39E9A42DB8D1F003A", hash_generated_method = "880038BF375DA3526A78BDEF569DE946")
    @DSModeled(DSC.SAFE)
    public NameValueList getContactParms() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.877 -0400", hash_original_method = "96E910216AC02ADF852A54B56C70C152", hash_generated_method = "B9D42E0066A7672A56987D856627F674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getExpires() {
        int varFDB2492FCE1BE234DBA6E54BD115D16E_1761664359 = (getParameterAsInt(EXPIRES));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getParameterAsInt(EXPIRES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.878 -0400", hash_original_method = "C2F655E77754B7E4118A4EC585DCE004", hash_generated_method = "053A3351847970629E0D64D8D0EE93CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(int expiryDeltaSeconds) {
        dsTaint.addTaint(expiryDeltaSeconds);
        Integer deltaSeconds;
        deltaSeconds = Integer.valueOf(expiryDeltaSeconds);
        this.parameters.set(EXPIRES, deltaSeconds);
        // ---------- Original Method ----------
        //Integer deltaSeconds = Integer.valueOf(expiryDeltaSeconds);
        //this.parameters.set(EXPIRES, deltaSeconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.878 -0400", hash_original_method = "99DBCB27F8E3FF6C21E31F78BC4B32FC", hash_generated_method = "9FE16ED4C365BA8CB37A149825409F24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getQValue() {
        float var09D64B94381E59C3343DF734687BCE8D_1302594970 = (getParameterAsFloat(Q));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getParameterAsFloat(Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.878 -0400", hash_original_method = "395F7CDC4269F17B37AD1CEF3C00E158", hash_generated_method = "BE1C846860C1787F0C68F1F17D7A6DDE")
    @DSModeled(DSC.SAFE)
    public void setContactList(ContactList cl) {
        dsTaint.addTaint(cl.dsTaint);
        // ---------- Original Method ----------
        //contactList = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.878 -0400", hash_original_method = "967084D665F0048759202AF27AE04FCB", hash_generated_method = "C1DF9193DA336F66619A1FA5477DAA12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWildCardFlag(boolean w) {
        dsTaint.addTaint(w);
        this.wildCardFlag = true;
        this.address = new AddressImpl();
        this.address.setWildCardFlag();
        // ---------- Original Method ----------
        //this.wildCardFlag = true;
        //this.address = new AddressImpl();
        //this.address.setWildCardFlag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.878 -0400", hash_original_method = "8D515165C9CEE70CC9BAE834218A7BF9", hash_generated_method = "7AE0823A77D6DA6530D6578FB82DA98D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAddress(javax.sip.address.Address address) {
        dsTaint.addTaint(address.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        this.address = (AddressImpl) address;
        this.wildCardFlag = false;
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //this.address = (AddressImpl) address;
        //this.wildCardFlag = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.879 -0400", hash_original_method = "BB23584FB6F9D8E00697707A3889A96F", hash_generated_method = "534E284A4C2C952F86814F83047187A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQValue(float qValue) throws InvalidArgumentException {
        dsTaint.addTaint(qValue);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception, Contact, setQValue(), "
                    + "the qValue is not between 0 and 1");
        this.parameters.set(Q, Float.valueOf(qValue));
        // ---------- Original Method ----------
        //if (qValue != -1 && (qValue < 0 || qValue > 1))
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception, Contact, setQValue(), "
                    //+ "the qValue is not between 0 and 1");
        //this.parameters.set(Q, Float.valueOf(qValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.879 -0400", hash_original_method = "286D385E6B16CCC7A8923BBB55E45ED9", hash_generated_method = "5C4356033401328F661928ACC0797BCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Contact retval;
        retval = (Contact) super.clone();
        retval.contactList = (ContactList) this.contactList.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Contact retval = (Contact) super.clone();
        //if (this.contactList != null)
            //retval.contactList = (ContactList) this.contactList.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.879 -0400", hash_original_method = "1E8417DABA85DBF8E3B8DCC75DF6036F", hash_generated_method = "BD71C9D7F2E71AD98661C4BC21983493")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWildCard() {
        this.setWildCardFlag(true);
        // ---------- Original Method ----------
        //this.setWildCardFlag(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.879 -0400", hash_original_method = "BD70FF709E52160B451422333F6894A9", hash_generated_method = "A8073B224B1C0C09EFE612D9F16F35F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWildCard() {
        boolean var42CAEB14A894C820412D4A66F4594354_1470770000 = (this.address.isWildcard());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.address.isWildcard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.879 -0400", hash_original_method = "BA2F3C2ED46538A7D01836631FBE38C7", hash_generated_method = "BEF16FF031BB852848FEC82842719B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean varB1A526B930D24017C6DCC02F251EF32F_1170077660 = ((other instanceof ContactHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof ContactHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.880 -0400", hash_original_method = "D8F26C6BEBC4025EE87D6A90A29B455D", hash_generated_method = "5FC82894F372EBFD5DEDB17DE40FB716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeSipInstanceParam() {
        parameters.delete(ParameterNames.SIP_INSTANCE);
        // ---------- Original Method ----------
        //if (parameters != null)
            //parameters.delete(ParameterNames.SIP_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.880 -0400", hash_original_method = "EA50318741E259995DB1E983FC6CAFD1", hash_generated_method = "92D72EAF736898EF35EE9A7F978357E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSipInstanceParam() {
        String varBEF6797D921B173B88718F4872584B93_296123214 = ((String) parameters.getValue(ParameterNames.SIP_INSTANCE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ParameterNames.SIP_INSTANCE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.880 -0400", hash_original_method = "B439361A999D0B73C2E9828E38E26B04", hash_generated_method = "77601F127932EAF41010F5DBBD65DDA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSipInstanceParam(String value) {
        dsTaint.addTaint(value);
        this.parameters.set(ParameterNames.SIP_INSTANCE, value);
        // ---------- Original Method ----------
        //this.parameters.set(ParameterNames.SIP_INSTANCE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.880 -0400", hash_original_method = "8AD6127ED19B3CFA328D7ED80A755AFB", hash_generated_method = "F387D63A901A1E8DF9D1EBC9C16D1426")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePubGruuParam() {
        parameters.delete(ParameterNames.PUB_GRUU);
        // ---------- Original Method ----------
        //if (parameters != null)
            //parameters.delete(ParameterNames.PUB_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.880 -0400", hash_original_method = "3B3B357FD219B3690182EE4F60CD3DC6", hash_generated_method = "EBB2681ED196D002157DC09A180CF230")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPubGruuParam() {
        String var9CC617821C282107B8218B492984FE11_1008880567 = ((String) parameters.getValue(ParameterNames.PUB_GRUU));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ParameterNames.PUB_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.880 -0400", hash_original_method = "E6BD4CB1D1049F858BE017703EF776B9", hash_generated_method = "3B16B47DA420FFF7CC156336633CC398")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPubGruuParam(String value) {
        dsTaint.addTaint(value);
        this.parameters.set(ParameterNames.PUB_GRUU, value);
        // ---------- Original Method ----------
        //this.parameters.set(ParameterNames.PUB_GRUU, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.881 -0400", hash_original_method = "493973B7C3E0E7D72E4F9CB95002E20E", hash_generated_method = "97C9A645527B3A1ACBDF16518A06250A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTempGruuParam() {
        parameters.delete(ParameterNames.TEMP_GRUU);
        // ---------- Original Method ----------
        //if (parameters != null)
            //parameters.delete(ParameterNames.TEMP_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.881 -0400", hash_original_method = "19861AEE803C91FE7A0A9CDBD1C78B9E", hash_generated_method = "CBE5ED9E7BD04CAC33C7709CCA0CCD32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTempGruuParam() {
        String varE8D93834DCA44B2B4DCDF145A08A16D0_92227908 = ((String) parameters.getValue(ParameterNames.TEMP_GRUU));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) parameters.getValue(ParameterNames.TEMP_GRUU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.881 -0400", hash_original_method = "64FD1572329B063AD4EC10A23207E509", hash_generated_method = "74939633ED1340405CB4612882123A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTempGruuParam(String value) {
        dsTaint.addTaint(value);
        this.parameters.set(ParameterNames.TEMP_GRUU, value);
        // ---------- Original Method ----------
        //this.parameters.set(ParameterNames.TEMP_GRUU, value);
    }

    
    private static final long serialVersionUID = 1677294871695706288L;
    public static final String ACTION = ParameterNames.ACTION;
    public static final String PROXY = ParameterNames.PROXY;
    public static final String REDIRECT = ParameterNames.REDIRECT;
    public static final String EXPIRES = ParameterNames.EXPIRES;
    public static final String Q = ParameterNames.Q;
}

