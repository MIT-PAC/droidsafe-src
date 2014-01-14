package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;

public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.780 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "C8D0DAE3C1F33EF1956D4324C7266C1E")

    /** Cookie name */
    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.782 -0500", hash_original_field = "023E4A9235EA8E667C82644BB263F099", hash_generated_field = "BD82217BCB79695C8D4F8280F58492AC")

    private Map<String, String> attribs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.784 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.787 -0500", hash_original_field = "5ABE95D6EC195B2B7AE2885AE486E7EF", hash_generated_field = "49AE069214DB59605844F82137D49FC9")

    private String  cookieComment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.789 -0500", hash_original_field = "716EB3B87F81B7028A827EEF83BCD5AA", hash_generated_field = "AD16EF7E737207351A1DDFC924A741C2")

    private String  cookieDomain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.792 -0500", hash_original_field = "B24AE4FA8E20E91BE6364390E2E81385", hash_generated_field = "02CE10C2C10E05605173AB6CDB0713BF")

    private Date cookieExpiryDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.794 -0500", hash_original_field = "54517AD0C86917ED5B5E8BA8718DDE16", hash_generated_field = "147D52111E3980107A61285ED7C02D65")

    private String cookiePath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.796 -0500", hash_original_field = "E4552EEEE3ECEA00EAEA078888450E62", hash_generated_field = "186FB9276C264E60A48BA46FB55EBBA1")

    private boolean isSecure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.798 -0500", hash_original_field = "BD60C7840FF7AB98DD7009789BB1E035", hash_generated_field = "D7C5934E6BB3D016D39F231A3AC7994A")

    private int cookieVersion;

    /**
     * Default Constructor taking a name and a value. The value may be null.
     * 
     * @param name The name.
     * @param value The value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.724 -0500", hash_original_method = "C8595E792CE20A5CAAE662B588946A62", hash_generated_method = "F8E766289461345ADB8A61C33C6E2CE3")
    
public BasicClientCookie(final String name, final String value) {
        super();
        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = name;
        this.attribs = new HashMap<String, String>();
        this.value = value;
    }

    /**
     * Returns the name.
     *
     * @return String name The name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.727 -0500", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "10AFD575EA26BE807F18801FAC02C531")
    
public String getName() {
        return this.name;
    }

    /**
     * Returns the value.
     *
     * @return String value The current value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.729 -0500", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "FC2353DBE9194DE53203DA3AB851288B")
    
public String getValue() {
        return this.value;
    }

    /**
     * Sets the value
     * 
     * @param value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.731 -0500", hash_original_method = "5A9FD1CB2995C306AE14120138CE8987", hash_generated_method = "242C58F92EEE791143FBC7898F7969EC")
    
public void setValue(final String value) {
        this.value = value;
    }

    /**
     * Returns the comment describing the purpose of this cookie, or
     * <tt>null</tt> if no such comment has been defined.
     * 
     * @return comment 
     *
     * @see #setComment(String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.733 -0500", hash_original_method = "C285B5EE8A6AFFAC313010465DD6E476", hash_generated_method = "BB4933C4A9392027783728A6E515322A")
    
public String getComment() {
        return cookieComment;
    }

    /**
     * If a user agent (web browser) presents this cookie to a user, the
     * cookie's purpose will be described using this comment.
     * 
     * @param comment
     *  
     * @see #getComment()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.735 -0500", hash_original_method = "B910B62E15C5C49D6C444731F0D794D6", hash_generated_method = "5232074D0297F7AC7D184985C6E8A407")
    
public void setComment(String comment) {
        cookieComment = comment;
    }
    
    /**
     * Returns null. Cookies prior to RFC2965 do not set this attribute
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.737 -0500", hash_original_method = "6B60F393FA3D6EFC64000C911A9295EA", hash_generated_method = "F5B49484CACA7C8E21EAB56749BDB294")
    
public String getCommentURL() {
        return null;
    }
    
    /**
     * Returns the expiration {@link Date} of the cookie, or <tt>null</tt>
     * if none exists.
     * <p><strong>Note:</strong> the object returned by this method is 
     * considered immutable. Changing it (e.g. using setTime()) could result
     * in undefined behaviour. Do so at your peril. </p>
     * @return Expiration {@link Date}, or <tt>null</tt>.
     *
     * @see #setExpiryDate(java.util.Date)
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.739 -0500", hash_original_method = "153D1D995EFAB40360B52407F1FDC7D7", hash_generated_method = "9FC259B0CB2D79FD7ED45AB9B521BA7C")
    
public Date getExpiryDate() {
        return cookieExpiryDate;
    }

    /**
     * Sets expiration date.
     * <p><strong>Note:</strong> the object returned by this method is considered
     * immutable. Changing it (e.g. using setTime()) could result in undefined 
     * behaviour. Do so at your peril.</p>
     *
     * @param expiryDate the {@link Date} after which this cookie is no longer valid.
     *
     * @see #getExpiryDate
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.742 -0500", hash_original_method = "9EF44BF5019D61A7024C6B9C062EE43B", hash_generated_method = "2B89798CA7C0A5D60C24E3B451357022")
    
public void setExpiryDate (Date expiryDate) {
        cookieExpiryDate = expiryDate;
    }

    /**
     * Returns <tt>false</tt> if the cookie should be discarded at the end
     * of the "session"; <tt>true</tt> otherwise.
     *
     * @return <tt>false</tt> if the cookie should be discarded at the end
     *         of the "session"; <tt>true</tt> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.744 -0500", hash_original_method = "74F524BD848D4FFA3F86046FEE25CAD1", hash_generated_method = "E0306EC52B4E6528DBB4B1225DA1C5E3")
    
public boolean isPersistent() {
        return (null != cookieExpiryDate);
    }

    /**
     * Returns domain attribute of the cookie.
     * 
     * @return the value of the domain attribute
     *
     * @see #setDomain(java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.746 -0500", hash_original_method = "B5778DA5E5DD3144D1C6A09AC82C1FC8", hash_generated_method = "C097B53CD050DBED1188E4D5B7D72B23")
    
public String getDomain() {
        return cookieDomain;
    }

    /**
     * Sets the domain attribute.
     * 
     * @param domain The value of the domain attribute
     *
     * @see #getDomain
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.748 -0500", hash_original_method = "9546A6CFEBFFD917E6EED03BE1DAE2AE", hash_generated_method = "C6FBD4B37EEB28CB002FD9A82B308549")
    
public void setDomain(String domain) {
        if (domain != null) {
            cookieDomain = domain.toLowerCase(Locale.ENGLISH);
        } else {
            cookieDomain = null;
        }
    }

    /**
     * Returns the path attribute of the cookie
     * 
     * @return The value of the path attribute.
     * 
     * @see #setPath(java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.751 -0500", hash_original_method = "EE441836AE1D2ED7AB4F531592BB0685", hash_generated_method = "013643D58A013C6DFDA1ACFD6FFFC389")
    
public String getPath() {
        return cookiePath;
    }

    /**
     * Sets the path attribute.
     *
     * @param path The value of the path attribute
     *
     * @see #getPath
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.753 -0500", hash_original_method = "FED8F85952C629683C8FDDFF3694A209", hash_generated_method = "68F586B714EE36CA5E1422A70ACCF18E")
    
public void setPath(String path) {
        cookiePath = path;
    }

    /**
     * @return <code>true</code> if this cookie should only be sent over secure connections.
     * @see #setSecure(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.755 -0500", hash_original_method = "2B20469DA455C9BD6D7FF0533B3892AF", hash_generated_method = "2B2DFAD40FC507B76641AD45347FBB7C")
    
public boolean isSecure() {
        return isSecure;
    }

    /**
     * Sets the secure attribute of the cookie.
     * <p>
     * When <tt>true</tt> the cookie should only be sent
     * using a secure protocol (https).  This should only be set when
     * the cookie's originating server used a secure protocol to set the
     * cookie's value.
     *
     * @param secure The value of the secure attribute
     * 
     * @see #isSecure()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.757 -0500", hash_original_method = "4AAA79ACC137AF686983B7EBC1139378", hash_generated_method = "0A4BA4C809232586BD8720561A3FDEE0")
    
public void setSecure (boolean secure) {
        isSecure = secure;
    }

    /**
     * Returns null. Cookies prior to RFC2965 do not set this attribute
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.759 -0500", hash_original_method = "792AB1F2DAEB6EDF4EEAFF71CFA593C4", hash_generated_method = "BF80BF9EEE804DC77F5CFE62C450CE6F")
    
public int[] getPorts() {
        return null;
    }
    
    /**
     * Returns the version of the cookie specification to which this
     * cookie conforms.
     *
     * @return the version of the cookie.
     * 
     * @see #setVersion(int)
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.761 -0500", hash_original_method = "2C800BF7E3C2BFE0AFF685103351615E", hash_generated_method = "B82AF0320C68319D14C57B9C010BDB4E")
    
public int getVersion() {
        return cookieVersion;
    }

    /**
     * Sets the version of the cookie specification to which this
     * cookie conforms. 
     *
     * @param version the version of the cookie.
     * 
     * @see #getVersion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.764 -0500", hash_original_method = "F7EA098B11400592DB8473D6C4214C87", hash_generated_method = "F4603277A2771F12DF1500FF7CE9315E")
    
public void setVersion(int version) {
        cookieVersion = version;
    }

    /**
     * Returns true if this cookie has expired.
     * @param date Current time
     * 
     * @return <tt>true</tt> if the cookie has expired.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.766 -0500", hash_original_method = "D870EC906D46A0EDE777AE892D1551DA", hash_generated_method = "1AF934A0C9560E8B4C2D9A553AB9ECF1")
    
public boolean isExpired(final Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date may not be null");
        }
        return (cookieExpiryDate != null  
            && cookieExpiryDate.getTime() <= date.getTime());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.768 -0500", hash_original_method = "E880BF6096DC9B6A4C51BBDC86AAFD73", hash_generated_method = "9D28F60F49BA661CED9F89C844107FF9")
    
public void setAttribute(final String name, final String value) {
        this.attribs.put(name, value);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.771 -0500", hash_original_method = "A480B1BC0B8318470327D71D112D198A", hash_generated_method = "3202F2683A7BCF6C1AACD1A31C2B7355")
    
public String getAttribute(final String name) {
        return this.attribs.get(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.773 -0500", hash_original_method = "9757AE15474AD638D5A2DA06803715D2", hash_generated_method = "562E795FA2A3744D5E7F95728A9CD481")
    
public boolean containsAttribute(final String name) {
        return this.attribs.get(name) != null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.776 -0500", hash_original_method = "7C7353B3FBE3C8967FDD9EF259B3710A", hash_generated_method = "59DE34238412A4B9ACF11DE696F3C228")
    
@Override
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie clone = (BasicClientCookie) super.clone();
        clone.attribs = new HashMap<String, String>(this.attribs);
        return clone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:36.778 -0500", hash_original_method = "A8332973B56773C2F5F00A4DF3A49927", hash_generated_method = "EB2F86DE168216B60F4BBF66618A85D5")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[version: ");
        buffer.append(Integer.toString(this.cookieVersion));
        buffer.append("]");
        buffer.append("[name: ");
        buffer.append(this.name);
        buffer.append("]");
        buffer.append("[value: ");
        buffer.append(this.value);
        buffer.append("]");
        buffer.append("[domain: ");
        buffer.append(this.cookieDomain);
        buffer.append("]");
        buffer.append("[path: ");
        buffer.append(this.cookiePath);
        buffer.append("]");
        buffer.append("[expiry: ");
        buffer.append(this.cookieExpiryDate);
        buffer.append("]");
        return buffer.toString();
    }
    
}

