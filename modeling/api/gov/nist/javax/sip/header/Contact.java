package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.AddressImpl;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ContactHeader;

public final class Contact extends AddressParametersHeader implements javax.sip.header.ContactHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.568 -0500", hash_original_field = "ED3D850F50B9048EB37C0F340B1A3ED3", hash_generated_field = "D5EF41A2EAE5A5CDE5AE467B71E69779")

    private static final long serialVersionUID = 1677294871695706288L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.571 -0500", hash_original_field = "332EA16E5EF2EF54F879FBC05CE88E52", hash_generated_field = "625B8D92ECBBC935F308044A15203C68")

    public static final String ACTION = ParameterNames.ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.575 -0500", hash_original_field = "A4066604D71C525A3BD0E8FB50AE3585", hash_generated_field = "E03817F60405358048E53FECF5415E6C")

    public static final String PROXY = ParameterNames.PROXY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.578 -0500", hash_original_field = "C6EE72E5CF8D91039A83A56DC642FD70", hash_generated_field = "6F331C4088ABB38593B6B56E77FD3DE2")

    public static final String REDIRECT = ParameterNames.REDIRECT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.582 -0500", hash_original_field = "A2479E372D51C1C294C891D7F4A8DA4F", hash_generated_field = "2F624D23D3BCA37A8CA767DF354E972D")

    public static final String EXPIRES = ParameterNames.EXPIRES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.585 -0500", hash_original_field = "A9DBCEC012E6F4C7FB8AD4170FF7732A", hash_generated_field = "FF045AAD7F2A2328EB43131E44B9ED97")

    public static final String Q = ParameterNames.Q;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.589 -0500", hash_original_field = "4D9076F1AB729EA660E21FCB20FDBA45", hash_generated_field = "F8D42AD524689A7075829FDA71AD2B65")

    private ContactList contactList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.592 -0500", hash_original_field = "F132EBBA4EF462D8B375BABC23D0BCF9", hash_generated_field = "59B10415DC4BAEC3C3C191C79EC370BD")

    protected boolean wildCardFlag;

    /** Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.595 -0500", hash_original_method = "91EC1BE71FCEDDA82A3A1E5DD0E8F369", hash_generated_method = "C2E35331058AC0FEDE392895A2E0540F")
    
public Contact() {
        super(NAME);
    }

    /** Set a parameter.
    */
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.598 -0500", hash_original_method = "610F5F9F0EA9EBC7B3CD81D4F6E695C1", hash_generated_method = "A31CA48CB3246B2754ABA1561DD7FF00")
    
public void setParameter(String name, String value) throws ParseException {
        NameValue nv = parameters.getNameValue(name);
        if (nv != null) {
            nv.setValueAsObject(value);
        } else {
            nv = new NameValue(name, value);
            if (name.equalsIgnoreCase("methods"))
                nv.setQuotedValue();
            this.parameters.set(nv);
        }
    }

    /**
     * Encode body of the header into a cannonical String.
     * @return string encoding of the header value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.602 -0500", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "BBFCFD2AD6BD270AD38D8FE87FD0572B")
    
protected String encodeBody() {
        return encodeBody(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.605 -0500", hash_original_method = "E69C365FF0754FE9819DC42713FEDDD9", hash_generated_method = "3CC39BCE6D256CE0DCE12B4C0D5F3D4D")
    
protected StringBuffer encodeBody(StringBuffer buffer) {
        if (wildCardFlag) {
            buffer.append('*');
        }
        else {
            // Bug report by Joao Paulo
            if (address.getAddressType() == AddressImpl.NAME_ADDR) {
                address.encode(buffer);
            } else {
                // Encoding in canonical form must have <> around address.
                buffer.append('<');
                address.encode(buffer);
                buffer.append('>');
            }
            if (!parameters.isEmpty()) {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            }
        }

        return buffer;
    }

    /** get the Contact list.
     * @return ContactList
     */
    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.607 -0500", hash_original_method = "1B424E93D6F15660DA959554DF30A2C0", hash_generated_method = "D219FD0D6453B315E2C64EA0A7C7D040")
    
public ContactList getContactList() {
        return contactList;
    }

    /** get the WildCardFlag field
     * @return boolean
     */
    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.610 -0500", hash_original_method = "B792A1C78C2262E486AC16BC668CCB6D", hash_generated_method = "9CD570CA0BDFAB4911C9BACEDF3F5409")
    
public boolean getWildCardFlag() {
        return wildCardFlag;
    }

    /** get the address field.
     * @return Address
     */
    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.613 -0500", hash_original_method = "569FFD65B001A83BF27BFBDAD6B4F486", hash_generated_method = "7A358BB5EB823E64AB634D23E3290BF0")
    
public javax.sip.address.Address getAddress() {
        // JAIN-SIP stores the wild card as an address!
        return address;
    }

    /** get the parameters List
     * @return NameValueList
     */
    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.616 -0500", hash_original_method = "4240C3A651BA1AB39E9A42DB8D1F003A", hash_generated_method = "3105CA54F2A1ED06B119BFD769999773")
    
public NameValueList getContactParms() {
        return parameters;
    }

    /** get Expires parameter.
     * @return the Expires parameter.
     */
    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.619 -0500", hash_original_method = "96E910216AC02ADF852A54B56C70C152", hash_generated_method = "B739B0608DF04309A293C914C1A68108")
    
public int getExpires() {
        return getParameterAsInt(EXPIRES);
    }

    /** Set the expiry time in seconds.
    *@param expiryDeltaSeconds exipry time.
    */

    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.622 -0500", hash_original_method = "C2F655E77754B7E4118A4EC585DCE004", hash_generated_method = "B4C1B6FA45BA3A94B39E44D305675F86")
    
public void setExpires(int expiryDeltaSeconds) {
        Integer deltaSeconds = Integer.valueOf(expiryDeltaSeconds);
        this.parameters.set(EXPIRES, deltaSeconds);
    }

    /** get the Q-value
     * @return float
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.625 -0500", hash_original_method = "99DBCB27F8E3FF6C21E31F78BC4B32FC", hash_generated_method = "43B361F3EAA446D6D8AF1A35EBDA4265")
    
public float getQValue() {
        return getParameterAsFloat(Q);
    }

    /** set the Contact List
     * @param cl ContactList to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.629 -0500", hash_original_method = "395F7CDC4269F17B37AD1CEF3C00E158", hash_generated_method = "210238A495BBBB78307406E4793FDC83")
    
public void setContactList(ContactList cl) {
        contactList = cl;
    }

    /**
     * Set the wildCardFlag member
     * @param w boolean to set
     */
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.632 -0500", hash_original_method = "967084D665F0048759202AF27AE04FCB", hash_generated_method = "BF131F906168D148B49ED9A46083C2DA")
    
public void setWildCardFlag(boolean w) {
        this.wildCardFlag = true;
        this.address = new AddressImpl();
        this.address.setWildCardFlag();
    }

    /**
     * Set the address member
     *
     * @param address Address to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.635 -0500", hash_original_method = "8D515165C9CEE70CC9BAE834218A7BF9", hash_generated_method = "A19B5A73AD60259F56463EAABBFBAB2C")
    
public void setAddress(javax.sip.address.Address address) {
        // Canonical form must have <> around the address.
        if (address == null)
            throw new NullPointerException("null address");
        this.address = (AddressImpl) address;
        this.wildCardFlag = false;
    }

    /**
     * set the Q-value parameter
     * @param qValue float to set
     */
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.638 -0500", hash_original_method = "BB23584FB6F9D8E00697707A3889A96F", hash_generated_method = "B0152FDAFD3601EB2617913EB6BF3239")
    
public void setQValue(float qValue) throws InvalidArgumentException {
        if (qValue != -1 && (qValue < 0 || qValue > 1))
            throw new InvalidArgumentException(
                "JAIN-SIP Exception, Contact, setQValue(), "
                    + "the qValue is not between 0 and 1");
        this.parameters.set(Q, Float.valueOf(qValue));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.641 -0500", hash_original_method = "286D385E6B16CCC7A8923BBB55E45ED9", hash_generated_method = "FE736C53CFC884347A0B2B8DF85D7263")
    
public Object clone() {
        Contact retval = (Contact) super.clone();
        if (this.contactList != null)
            retval.contactList = (ContactList) this.contactList.clone();
        return retval;
    }

    /* (non-Javadoc)
     * @see javax.sip.header.ContactHeader#setWildCard()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.644 -0500", hash_original_method = "1E8417DABA85DBF8E3B8DCC75DF6036F", hash_generated_method = "E44BD03FFDA6C49D83D3F01719765D67")
    
public void setWildCard() {
       this.setWildCardFlag(true);

    }

    /* (non-Javadoc)
     * @see javax.sip.header.ContactHeader#isWildCard()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.647 -0500", hash_original_method = "BD70FF709E52160B451422333F6894A9", hash_generated_method = "43FF2D00352EF551614D004EE43D8B83")
    
public boolean isWildCard() {

        return this.address.isWildcard();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.650 -0500", hash_original_method = "BA2F3C2ED46538A7D01836631FBE38C7", hash_generated_method = "99D5D0C9ED88D72D0120AE5AD100D38A")
    
public boolean equals(Object other) {
        return (other instanceof ContactHeader) && super.equals(other);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.653 -0500", hash_original_method = "D8F26C6BEBC4025EE87D6A90A29B455D", hash_generated_method = "3F02D503781A2CF2F44D7AF63DF047D8")
    
public void removeSipInstanceParam() {
        if (parameters != null)
            parameters.delete(ParameterNames.SIP_INSTANCE);
    }

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.657 -0500", hash_original_method = "EA50318741E259995DB1E983FC6CAFD1", hash_generated_method = "44B110862A0F1FA7C5F9067DEC3EA0D7")
    
public String getSipInstanceParam() {
        return (String) parameters.getValue(ParameterNames.SIP_INSTANCE);
    }

    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.660 -0500", hash_original_method = "B439361A999D0B73C2E9828E38E26B04", hash_generated_method = "A86F4E5B11E3A91B4CFB0111E4FB4EBC")
    
public void setSipInstanceParam(String value) {
        this.parameters.set(ParameterNames.SIP_INSTANCE, value);
    }

    /**
     *remove the pub-gruu value from the parameter list if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.664 -0500", hash_original_method = "8AD6127ED19B3CFA328D7ED80A755AFB", hash_generated_method = "10F869287E42A17356B67A9DA6374214")
    
public void removePubGruuParam() {
        if (parameters != null)
            parameters.delete(ParameterNames.PUB_GRUU);
    }

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.667 -0500", hash_original_method = "3B3B357FD219B3690182EE4F60CD3DC6", hash_generated_method = "120ABB33278EBBADA28E37C8A790DA63")
    
public String getPubGruuParam() {
        return (String) parameters.getValue(ParameterNames.PUB_GRUU);
    }

    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.670 -0500", hash_original_method = "E6BD4CB1D1049F858BE017703EF776B9", hash_generated_method = "5E1FCD4B5BB46C35AD55FCB721D7F36D")
    
public void setPubGruuParam(String value)
    {
        this.parameters.set(ParameterNames.PUB_GRUU, value);
    }

    /**
     *remove the pub-gruu value from the parameter list if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.673 -0500", hash_original_method = "493973B7C3E0E7D72E4F9CB95002E20E", hash_generated_method = "A1BC58B5414298479A45B46DF4D67064")
    
public void removeTempGruuParam() {
        if (parameters != null)
            parameters.delete(ParameterNames.TEMP_GRUU);
    }

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.675 -0500", hash_original_method = "19861AEE803C91FE7A0A9CDBD1C78B9E", hash_generated_method = "4482E8A45131311BB6370A5E83AC275D")
    
public String getTempGruuParam() {
        return (String) parameters.getValue(ParameterNames.TEMP_GRUU);
    }

    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:02.678 -0500", hash_original_method = "64FD1572329B063AD4EC10A23207E509", hash_generated_method = "61570D90E2A5659220B872C46334CDA2")
    
public void setTempGruuParam(String value)
    {
        this.parameters.set(ParameterNames.TEMP_GRUU, value);
    }
}

