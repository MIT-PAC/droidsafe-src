package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;

public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "5D06E8A33AF1DD392678AE6DB220FDCF", hash_generated_field = "BD82217BCB79695C8D4F8280F58492AC")

    private Map<String, String> attribs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "22661022A0983AA8183EF5D4E781E343", hash_generated_field = "49AE069214DB59605844F82137D49FC9")

    private String cookieComment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "767EB00E7715D288DABD8726BB764A83", hash_generated_field = "AD16EF7E737207351A1DDFC924A741C2")

    private String cookieDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "D9E63AC71ED0406E327CF645C4EFB44F", hash_generated_field = "02CE10C2C10E05605173AB6CDB0713BF")

    private Date cookieExpiryDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "3B142C711BA30EE5FCE7FCAE4807F0BB", hash_generated_field = "147D52111E3980107A61285ED7C02D65")

    private String cookiePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "36E886528CA418649444F49929E4002D", hash_generated_field = "186FB9276C264E60A48BA46FB55EBBA1")

    private boolean isSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.191 -0400", hash_original_field = "40C4910675D17E7863242064AA3CD190", hash_generated_field = "D7C5934E6BB3D016D39F231A3AC7994A")

    private int cookieVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.202 -0400", hash_original_method = "C8595E792CE20A5CAAE662B588946A62", hash_generated_method = "93859B78F685916FCF553A849B7226F0")
    public  BasicClientCookie(final String name, final String value) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        this.name = name;
        this.attribs = new HashMap<String, String>();
        this.value = value;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //this.name = name;
        //this.attribs = new HashMap<String, String>();
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.203 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "173AB5E199E27A21A9195655658851D6")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_349254882 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_349254882 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_349254882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_349254882;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.203 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "32E158AC1C88B84D4E71F68FC85B6C5A")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1900492171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1900492171 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_1900492171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1900492171;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.205 -0400", hash_original_method = "5A9FD1CB2995C306AE14120138CE8987", hash_generated_method = "5A3F164F4419E5A4EF475391DD8D78C7")
    public void setValue(final String value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.206 -0400", hash_original_method = "C285B5EE8A6AFFAC313010465DD6E476", hash_generated_method = "11DE74BB88F5A20CAEE3F9C5BB878552")
    public String getComment() {
        String varB4EAC82CA7396A68D541C85D26508E83_186589463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_186589463 = cookieComment;
        varB4EAC82CA7396A68D541C85D26508E83_186589463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_186589463;
        // ---------- Original Method ----------
        //return cookieComment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.206 -0400", hash_original_method = "B910B62E15C5C49D6C444731F0D794D6", hash_generated_method = "8D1DC8BDEA78694CF65D7EA1B7927347")
    public void setComment(String comment) {
        cookieComment = comment;
        // ---------- Original Method ----------
        //cookieComment = comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.218 -0400", hash_original_method = "6B60F393FA3D6EFC64000C911A9295EA", hash_generated_method = "C026F26749E09A531ED78457880AE2D8")
    public String getCommentURL() {
        String varB4EAC82CA7396A68D541C85D26508E83_512611083 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_512611083 = null;
        varB4EAC82CA7396A68D541C85D26508E83_512611083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_512611083;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.226 -0400", hash_original_method = "153D1D995EFAB40360B52407F1FDC7D7", hash_generated_method = "9F3E975A1AEDE87C7B178725FC8F9566")
    public Date getExpiryDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_312742797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_312742797 = cookieExpiryDate;
        varB4EAC82CA7396A68D541C85D26508E83_312742797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_312742797;
        // ---------- Original Method ----------
        //return cookieExpiryDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.227 -0400", hash_original_method = "9EF44BF5019D61A7024C6B9C062EE43B", hash_generated_method = "A14828052CB170795C206EB13DEE42D8")
    public void setExpiryDate(Date expiryDate) {
        cookieExpiryDate = expiryDate;
        // ---------- Original Method ----------
        //cookieExpiryDate = expiryDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.231 -0400", hash_original_method = "74F524BD848D4FFA3F86046FEE25CAD1", hash_generated_method = "EB80EDE4D6A36FE165A5F07ADF4C32AE")
    public boolean isPersistent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493123525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493123525;
        // ---------- Original Method ----------
        //return (null != cookieExpiryDate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.248 -0400", hash_original_method = "B5778DA5E5DD3144D1C6A09AC82C1FC8", hash_generated_method = "87668122FF67FE20571035A8D1C0CE4C")
    public String getDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_6479718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_6479718 = cookieDomain;
        varB4EAC82CA7396A68D541C85D26508E83_6479718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_6479718;
        // ---------- Original Method ----------
        //return cookieDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.249 -0400", hash_original_method = "9546A6CFEBFFD917E6EED03BE1DAE2AE", hash_generated_method = "4BA41462DCA9D1C817579CE32542D4B4")
    public void setDomain(String domain) {
        {
            cookieDomain = domain.toLowerCase(Locale.ENGLISH);
        } //End block
        {
            cookieDomain = null;
        } //End block
        // ---------- Original Method ----------
        //if (domain != null) {
            //cookieDomain = domain.toLowerCase(Locale.ENGLISH);
        //} else {
            //cookieDomain = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.250 -0400", hash_original_method = "EE441836AE1D2ED7AB4F531592BB0685", hash_generated_method = "9263A549C25827C3025ED449C1E94BB8")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_713715343 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_713715343 = cookiePath;
        varB4EAC82CA7396A68D541C85D26508E83_713715343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_713715343;
        // ---------- Original Method ----------
        //return cookiePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.250 -0400", hash_original_method = "FED8F85952C629683C8FDDFF3694A209", hash_generated_method = "828287FBFA9DF4DF9FF629A59C31B365")
    public void setPath(String path) {
        cookiePath = path;
        // ---------- Original Method ----------
        //cookiePath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.250 -0400", hash_original_method = "2B20469DA455C9BD6D7FF0533B3892AF", hash_generated_method = "06310D09010BE069E0D92779C739A9C2")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1384614115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1384614115;
        // ---------- Original Method ----------
        //return isSecure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.251 -0400", hash_original_method = "4AAA79ACC137AF686983B7EBC1139378", hash_generated_method = "80C814C26050D1BDD00FD772F40A8600")
    public void setSecure(boolean secure) {
        isSecure = secure;
        // ---------- Original Method ----------
        //isSecure = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.251 -0400", hash_original_method = "792AB1F2DAEB6EDF4EEAFF71CFA593C4", hash_generated_method = "0D4B823CB9CC0A6EEF76A7BCD9ACDD47")
    public int[] getPorts() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1973768530 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1973768530;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.251 -0400", hash_original_method = "2C800BF7E3C2BFE0AFF685103351615E", hash_generated_method = "091FC7CA68C332EF259799DABA8CF468")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408490690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408490690;
        // ---------- Original Method ----------
        //return cookieVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.267 -0400", hash_original_method = "F7EA098B11400592DB8473D6C4214C87", hash_generated_method = "DD9B9B71929423C85BF662F8126E82BA")
    public void setVersion(int version) {
        cookieVersion = version;
        // ---------- Original Method ----------
        //cookieVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.267 -0400", hash_original_method = "D870EC906D46A0EDE777AE892D1551DA", hash_generated_method = "3E573C973683DFA1CBE875CD33B6BE90")
    public boolean isExpired(final Date date) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Date may not be null");
        } //End block
        boolean varA740ACE64F8524941C9B74882C66FD7E_888742107 = ((cookieExpiryDate != null  
            && cookieExpiryDate.getTime() <= date.getTime()));
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590837246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_590837246;
        // ---------- Original Method ----------
        //if (date == null) {
            //throw new IllegalArgumentException("Date may not be null");
        //}
        //return (cookieExpiryDate != null  
            //&& cookieExpiryDate.getTime() <= date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.268 -0400", hash_original_method = "E880BF6096DC9B6A4C51BBDC86AAFD73", hash_generated_method = "290E1CBEB1F1EAD2561882647238D151")
    public void setAttribute(final String name, final String value) {
        this.attribs.put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.attribs.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.319 -0400", hash_original_method = "A480B1BC0B8318470327D71D112D198A", hash_generated_method = "ECBBF9031CCEC4E2EFC1430A943A4533")
    public String getAttribute(final String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1187848030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1187848030 = this.attribs.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1187848030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1187848030;
        // ---------- Original Method ----------
        //return this.attribs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.319 -0400", hash_original_method = "9757AE15474AD638D5A2DA06803715D2", hash_generated_method = "45AEC8A41D2AF75B6FDC2E9C31207BE5")
    public boolean containsAttribute(final String name) {
        boolean varECB03B7EDFEDA4C0C645315D5AC48D3D_1567174757 = (this.attribs.get(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503743813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503743813;
        // ---------- Original Method ----------
        //return this.attribs.get(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.320 -0400", hash_original_method = "7C7353B3FBE3C8967FDD9EF259B3710A", hash_generated_method = "DDFB2C33E1E2FA477A0A65F1820AC1CC")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_755457978 = null; //Variable for return #1
        BasicClientCookie clone;
        clone = (BasicClientCookie) super.clone();
        clone.attribs = new HashMap<String, String>(this.attribs);
        varB4EAC82CA7396A68D541C85D26508E83_755457978 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_755457978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755457978;
        // ---------- Original Method ----------
        //BasicClientCookie clone = (BasicClientCookie) super.clone();
        //clone.attribs = new HashMap<String, String>(this.attribs);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.321 -0400", hash_original_method = "A8332973B56773C2F5F00A4DF3A49927", hash_generated_method = "2DAF9F7FEC97321D04900E8974D928C4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1514221035 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
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
        varB4EAC82CA7396A68D541C85D26508E83_1514221035 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1514221035.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514221035;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append("[version: ");
        //buffer.append(Integer.toString(this.cookieVersion));
        //buffer.append("]");
        //buffer.append("[name: ");
        //buffer.append(this.name);
        //buffer.append("]");
        //buffer.append("[value: ");
        //buffer.append(this.value);
        //buffer.append("]");
        //buffer.append("[domain: ");
        //buffer.append(this.cookieDomain);
        //buffer.append("]");
        //buffer.append("[path: ");
        //buffer.append(this.cookiePath);
        //buffer.append("]");
        //buffer.append("[expiry: ");
        //buffer.append(this.cookieExpiryDate);
        //buffer.append("]");
        //return buffer.toString();
    }

    
}

