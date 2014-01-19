package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.NameValueList;

import java.text.ParseException;
import java.util.Iterator;

public class TelURLImpl extends GenericURI implements javax.sip.address.TelURL {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.549 -0500", hash_original_field = "EB98B2C1C5DDDB070B9763C0642166F4", hash_generated_field = "F6119FF81BCE9EC280E1CB921273774A")

    private static final long serialVersionUID = 5873527320305915954L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.551 -0500", hash_original_field = "8D5BD0E8A4B4FC2B44A628B6466E0222", hash_generated_field = "A24B43E0CC935DC17A1CF71DA4A58F34")

    protected TelephoneNumber telephoneNumber;

    /** Creates a new instance of TelURLImpl */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.554 -0500", hash_original_method = "C17135FC5CC76AEB5F88156629F51796", hash_generated_method = "B29099714AF8AAA83987C7A4AD7ED6B1")
    
public TelURLImpl() {
        this.scheme = "tel";
    }

    /** Set the telephone number.
     *@param telephoneNumber -- telephone number to set.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.556 -0500", hash_original_method = "C9EB332176FD96276A0692D7B71B3B1C", hash_generated_method = "349209D36D94926B8146C68AAC071ACA")
    
public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /** Returns the value of the <code>isdnSubAddress</code> parameter, or null
     * if it is not set.
     *
     * @return  the value of the <code>isdnSubAddress</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.558 -0500", hash_original_method = "7749933BE9F1A8F770924BE8E0DD80B2", hash_generated_method = "0D99869AB8EBAD9A6878E75CDEE2C742")
    
public String getIsdnSubAddress() {
        return telephoneNumber.getIsdnSubaddress();
    }

    /** Returns the value of the <code>postDial</code> parameter, or null if it
     * is not set.
     *
     * @return  the value of the <code>postDial</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.561 -0500", hash_original_method = "A07C64D3F1CC8848A39F332213EC7E5C", hash_generated_method = "8B732813DC52AEE3FC41F4F80C8C915A")
    
public String getPostDial() {
        return telephoneNumber.getPostDial();
    }

    /** Returns the value of the "scheme" of this URI, for example "sip", "sips"
     * or "tel".
     *
     * @return the scheme paramter of the URI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.563 -0500", hash_original_method = "76031D31C1CA528B8F038117D6808811", hash_generated_method = "8C187E31064D5FC7E4CBD4735C1E35F0")
    
public String getScheme() {
        return this.scheme;
    }

    /** Returns <code>true</code> if this TelURL is global i.e. if the TelURI
     * has a global phone user.
     *
     * @return <code>true</code> if this TelURL represents a global phone user,
     * and <code>false</code> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.566 -0500", hash_original_method = "95ED443083D9E3C79BD9C6E46A138264", hash_generated_method = "09757E248DE21B2C34A5F30B6AA9EECF")
    
public boolean isGlobal() {
        return telephoneNumber.isGlobal();
    }

    /** This method determines if this is a URI with a scheme of "sip" or "sips".
     *
     * @return true if the scheme is "sip" or "sips", false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.568 -0500", hash_original_method = "317E4D17172E12E605B8E6C02B3A9523", hash_generated_method = "F21628E06D2EB101E8BF08E6003BD5F3")
    
public boolean isSipURI() {
        return false;
    }

    /** Sets phone user of this TelURL to be either global or local. The default
     * value is false, hence the TelURL is defaulted to local.
     *
     * @param global - the boolean value indicating if the TelURL has a global
     * phone user.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.571 -0500", hash_original_method = "EE86C87982E4E6CE462C2F1CF12245F2", hash_generated_method = "F2045C78708A88088EB7B549BAC9C6F3")
    
public void setGlobal(boolean global) {
        this.telephoneNumber.setGlobal(global);
    }

    /** Sets ISDN subaddress of this TelURL. If a subaddress is present, it is
     * appended to the phone number after ";isub=".
     *
     * @param isdnSubAddress - new value of the <code>isdnSubAddress</code>
     * parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.573 -0500", hash_original_method = "122F825A7097C68E3CD71E8CD7DD2208", hash_generated_method = "4C6A96F5ED0C04C2B520A6E6426968B4")
    
public void setIsdnSubAddress(String isdnSubAddress) {
        this.telephoneNumber.setIsdnSubaddress(isdnSubAddress);
    }

    /** Sets post dial of this TelURL. The post-dial sequence describes what and
     * when the local entity should send to the phone line.
     *
     * @param postDial - new value of the <code>postDial</code> parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.575 -0500", hash_original_method = "19BDC1422936CE8CD2446692653D846C", hash_generated_method = "B3D5FCF602B8B3CF113C4A5EEFDAB725")
    
public void setPostDial(String postDial) {
        this.telephoneNumber.setPostDial(postDial);
    }

    /**
     * Set the telephone number.
     * @param telephoneNumber long phone number to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.577 -0500", hash_original_method = "57F725D8D07902BEB47C996DF34801CB", hash_generated_method = "7015548877C01D0F312E56ADA53A4EF0")
    
public void setPhoneNumber(String telephoneNumber) {
        this.telephoneNumber.setPhoneNumber(telephoneNumber);
    }

    /** Get the telephone number.
     *
     *@return -- the telephone number.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.581 -0500", hash_original_method = "9932D29BF514A34CC6953B51ADDD0B1C", hash_generated_method = "27C04231D84C1A5AA2A04949D711189B")
    
public String getPhoneNumber() {
        return this.telephoneNumber.getPhoneNumber();
    }

    /** Return the string encoding.
     *
     *@return -- the string encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.583 -0500", hash_original_method = "5EC62A2B879CA2B5D87DB46D668C10E0", hash_generated_method = "1C9505ACA5C0BEEC4B42665E83FAB5E1")
    
public String toString() {
        return this.scheme + ":" + telephoneNumber.encode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.586 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.588 -0500", hash_original_method = "CF877865ECD493DE460A284390F03152", hash_generated_method = "96B459D37AB92C14871E567C1417B937")
    
public StringBuffer encode(StringBuffer buffer) {
        buffer.append(this.scheme).append(':');
        telephoneNumber.encode(buffer);
        return buffer;
    }

    /** Deep copy clone operation.
    *
    *@return -- a cloned version of this telephone number.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.591 -0500", hash_original_method = "6B8A416F4757BDF00BB53E081B0C9027", hash_generated_method = "407CEFCA9B87D47157A714D5BD5826AC")
    
public Object clone() {
        TelURLImpl retval = (TelURLImpl) super.clone();
        if (this.telephoneNumber != null)
            retval.telephoneNumber = (TelephoneNumber) this.telephoneNumber.clone();
        return retval;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.593 -0500", hash_original_method = "7FADC9FB5FA5B5E8B9D3FF343952F7D6", hash_generated_method = "0D73B0CC779BAA6F00BAEFCB0842C08B")
    
public String getParameter(String parameterName) {
        return telephoneNumber.getParameter(parameterName);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.595 -0500", hash_original_method = "7B12A3BFEAC170D72CC4E531FEDC5259", hash_generated_method = "0A74B085FD912C24F491E0EAE4369AE3")
    
public void setParameter(String name, String value) {
        telephoneNumber.setParameter(name, value);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.597 -0500", hash_original_method = "9F3A3B5343A94A5C27FE8CB7C132960C", hash_generated_method = "E0BC0A9EC821D49125AFA1A6AE4DAD69")
    
public Iterator<String> getParameterNames() {
        return telephoneNumber.getParameterNames();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.599 -0500", hash_original_method = "9F42A8DF83D29C58CCE55D9B05B30108", hash_generated_method = "9783BBC2E2B8A803EF52324A0248BF3B")
    
public NameValueList getParameters() {
        return telephoneNumber.getParameters();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.602 -0500", hash_original_method = "7A5BAA5627804B12C2CD072560767D2A", hash_generated_method = "C65A9665CD1DBA923500390596000F9C")
    
public void removeParameter(String name) {
        telephoneNumber.removeParameter(name);
    }

    /* (non-Javadoc)
     * @see javax.sip.address.TelURL#setPhoneContext(java.lang.String)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.604 -0500", hash_original_method = "601A60F168280AF8DB609489286F142F", hash_generated_method = "2AC3C30BD53425EA85184E84C79BDC78")
    
public void setPhoneContext(String phoneContext) throws ParseException {

        // JvB: set (null) should be interpreted as 'remove'
        if (phoneContext==null) {
            this.removeParameter("phone-context");
        } else {
            this.setParameter("phone-context",phoneContext);
        }
    }

    /* (non-Javadoc)
     * @see javax.sip.address.TelURL#getPhoneContext()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.607 -0500", hash_original_method = "E99D05466523D70C189436EBEEC64347", hash_generated_method = "9C868F482C0254EEDAFB0985997199CF")
    
public String getPhoneContext() {

        return this.getParameter("phone-context");
    }
}

