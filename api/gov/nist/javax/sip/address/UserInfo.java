package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class UserInfo extends NetObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.753 -0500", hash_original_field = "9304317C14889A351A8EA0D9F9C6C8E9", hash_generated_field = "E4DBADE234AE16A77F53FEF34BDC568F")

    private static final long serialVersionUID = 7268593273924256144L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.763 -0500", hash_original_field = "EE92A15F686F0E035A7FE1AC53752059", hash_generated_field = "2961967C21DF0AFF555C9722B216BAA2")

    public final static int TELEPHONE_SUBSCRIBER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.766 -0500", hash_original_field = "2BE2A1E4642EAD0EAA09F9464A665F69", hash_generated_field = "10FB0621E7A7DF7F148CB5C5899EF9ED")

    public final static int USER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.755 -0500", hash_original_field = "B37EB1ED61432756B8E994D3D7BA4599", hash_generated_field = "2E8D8BE8172FDAA496B4216DD847F959")

    protected String user;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.757 -0500", hash_original_field = "2AFEDC818D0EF3384B2D2537704E6E21", hash_generated_field = "24B4D2B0B8A23D8C0FAB238006B574DA")

    protected String password;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.760 -0500", hash_original_field = "F58DEF50E41D3023AE1765826940EF9B", hash_generated_field = "A84E54971210FD20E9F93C9D58D4FA09")

    protected int userType;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.768 -0500", hash_original_method = "F45B016F8E384DB218E594119B9CAF8C", hash_generated_method = "D72E2E8D97932CF9D212F26545BD45ED")
    
public UserInfo() {
        super();
    }

    /**
     * Compare for equality.
     * @param obj Object to set
     * @return true if the two headers are equals, false otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.771 -0500", hash_original_method = "A09C3D32ACE02300A3630780DF7DA73F", hash_generated_method = "32F0C96A3AE6D3E038F875614DB6300C")
    
public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserInfo other = (UserInfo) obj;
        if (this.userType != other.userType) {
            return false;
        }
        if (!this.user.equalsIgnoreCase(other.user)) {
            return false;
        }
        if (this.password != null && other.password == null)
            return false;

        if (other.password != null && this.password == null)
            return false;

        if (this.password == other.password)
            return true;

        return (this.password.equals(other.password));
    }

    /**
     * Encode the user information as a string.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.774 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.776 -0500", hash_original_method = "7AE7B8A415769E92878FFEC035C52AE0", hash_generated_method = "9749A0E07E8665468D2B31D3CA6E6F46")
    
public StringBuffer encode(StringBuffer buffer) {
        if (password != null)
            buffer.append(user).append(COLON).append(password);
        else
            buffer.append(user);

        return buffer;
    }

    /** Clear the password field.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.778 -0500", hash_original_method = "B45A9D19151CAED15569D78F83AD2095", hash_generated_method = "643ADB5C95A2E9CDD4F158DFE1BAB0C5")
    
public void clearPassword() {
        this.password = null;
    }

    /**
     * Gets the user type (which can be set to TELEPHONE_SUBSCRIBER or USER)
     * @return the type of user.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.780 -0500", hash_original_method = "0304D4B17F9026D87C6633B5EFA54170", hash_generated_method = "43C35D644C6F5C43F0C728653BB5D839")
    
public int getUserType() {
        return userType;
    }

    /** get the user field.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.782 -0500", hash_original_method = "067A1216625EE4AD320B5B1536FC853E", hash_generated_method = "768A7D1D5D0FCDDB7735C26A1B322FA4")
    
public String getUser() {
        return user;
    }

    /** get the password field.
     * @return String
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.785 -0500", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "3422D16EB2EB2FA3C8F125F717D7CA7E")
    
public String getPassword() {
        return password;
    }

    /**
     * Set the user member
     * @param user String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.788 -0500", hash_original_method = "3D02333C0789FC569CF57CEE9E3D36D7", hash_generated_method = "4FE3B74B78D0A7A0C8FEC349451EBE6B")
    
public void setUser(String user) {
        this.user = user;
        // BUG Fix submitted by Lamine Brahimi
        // add this (taken form sip_messageParser)
        // otherwise comparison of two SipUrl will fail because this
        // parameter is not set (whereas it is set in sip_messageParser).
        if (user != null
            && (user.indexOf(POUND) >= 0 || user.indexOf(SEMICOLON) >= 0)) {
            setUserType(TELEPHONE_SUBSCRIBER);
        } else {
            setUserType(USER);
        }
    }

    /**
     * Set the password member
     * @param p String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.790 -0500", hash_original_method = "914969AC5F0FD02943850406A5ADB2DF", hash_generated_method = "EE5E537AE6B60E03E627F9FD987393B5")
    
public void setPassword(String p) {
        password = p;
    }

    /**
     * Set the user type (to TELEPHONE_SUBSCRIBER or USER).
     * @param type int to set
     * @throws IllegalArgumentException if type is not in range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.793 -0500", hash_original_method = "D88C19BFECDFF9E40F4106FE0C0D9444", hash_generated_method = "5FD668171013FE716D566DA2525DF335")
    
public void setUserType(int type) throws IllegalArgumentException {
        if (type != TELEPHONE_SUBSCRIBER && type != USER) {
            throw new IllegalArgumentException("Parameter not in range");
        }
        userType = type;
    }
}

