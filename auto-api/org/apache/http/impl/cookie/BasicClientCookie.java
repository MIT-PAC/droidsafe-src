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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "5D06E8A33AF1DD392678AE6DB220FDCF", hash_generated_field = "BD82217BCB79695C8D4F8280F58492AC")

    private Map<String, String> attribs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "22661022A0983AA8183EF5D4E781E343", hash_generated_field = "49AE069214DB59605844F82137D49FC9")

    private String cookieComment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "767EB00E7715D288DABD8726BB764A83", hash_generated_field = "AD16EF7E737207351A1DDFC924A741C2")

    private String cookieDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "D9E63AC71ED0406E327CF645C4EFB44F", hash_generated_field = "02CE10C2C10E05605173AB6CDB0713BF")

    private Date cookieExpiryDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "3B142C711BA30EE5FCE7FCAE4807F0BB", hash_generated_field = "147D52111E3980107A61285ED7C02D65")

    private String cookiePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "36E886528CA418649444F49929E4002D", hash_generated_field = "186FB9276C264E60A48BA46FB55EBBA1")

    private boolean isSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_field = "40C4910675D17E7863242064AA3CD190", hash_generated_field = "D7C5934E6BB3D016D39F231A3AC7994A")

    private int cookieVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.878 -0400", hash_original_method = "C8595E792CE20A5CAAE662B588946A62", hash_generated_method = "93859B78F685916FCF553A849B7226F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.879 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "F42DE380A3F6066A56D0E81D15DDCF2E")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2012254884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012254884 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_2012254884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012254884;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.880 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "97C9575DA601CF25647D91FBCBFB77DE")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_179527984 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_179527984 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_179527984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179527984;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.880 -0400", hash_original_method = "5A9FD1CB2995C306AE14120138CE8987", hash_generated_method = "5A3F164F4419E5A4EF475391DD8D78C7")
    public void setValue(final String value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.880 -0400", hash_original_method = "C285B5EE8A6AFFAC313010465DD6E476", hash_generated_method = "03110CFF481EE4C8B71E4C4B4359F8D9")
    public String getComment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1664808323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1664808323 = cookieComment;
        varB4EAC82CA7396A68D541C85D26508E83_1664808323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1664808323;
        // ---------- Original Method ----------
        //return cookieComment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.881 -0400", hash_original_method = "B910B62E15C5C49D6C444731F0D794D6", hash_generated_method = "8D1DC8BDEA78694CF65D7EA1B7927347")
    public void setComment(String comment) {
        cookieComment = comment;
        // ---------- Original Method ----------
        //cookieComment = comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.881 -0400", hash_original_method = "6B60F393FA3D6EFC64000C911A9295EA", hash_generated_method = "F6C76145B3C634D87D35BF8550BEA930")
    public String getCommentURL() {
        String varB4EAC82CA7396A68D541C85D26508E83_844971063 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_844971063 = null;
        varB4EAC82CA7396A68D541C85D26508E83_844971063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_844971063;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.881 -0400", hash_original_method = "153D1D995EFAB40360B52407F1FDC7D7", hash_generated_method = "D84411323201BBA3480F987F526681C0")
    public Date getExpiryDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_2021082925 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021082925 = cookieExpiryDate;
        varB4EAC82CA7396A68D541C85D26508E83_2021082925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021082925;
        // ---------- Original Method ----------
        //return cookieExpiryDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.882 -0400", hash_original_method = "9EF44BF5019D61A7024C6B9C062EE43B", hash_generated_method = "A14828052CB170795C206EB13DEE42D8")
    public void setExpiryDate(Date expiryDate) {
        cookieExpiryDate = expiryDate;
        // ---------- Original Method ----------
        //cookieExpiryDate = expiryDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.882 -0400", hash_original_method = "74F524BD848D4FFA3F86046FEE25CAD1", hash_generated_method = "3EF6C3A526D286762EDD76BCEDC07717")
    public boolean isPersistent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697954159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_697954159;
        // ---------- Original Method ----------
        //return (null != cookieExpiryDate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.883 -0400", hash_original_method = "B5778DA5E5DD3144D1C6A09AC82C1FC8", hash_generated_method = "00DB73D8617F082F8AE8A77EDF563CA9")
    public String getDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_476121786 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_476121786 = cookieDomain;
        varB4EAC82CA7396A68D541C85D26508E83_476121786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_476121786;
        // ---------- Original Method ----------
        //return cookieDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.883 -0400", hash_original_method = "9546A6CFEBFFD917E6EED03BE1DAE2AE", hash_generated_method = "4BA41462DCA9D1C817579CE32542D4B4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.884 -0400", hash_original_method = "EE441836AE1D2ED7AB4F531592BB0685", hash_generated_method = "DCCB3E79DF9F653800DA6C8035728FFA")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_497201787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_497201787 = cookiePath;
        varB4EAC82CA7396A68D541C85D26508E83_497201787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_497201787;
        // ---------- Original Method ----------
        //return cookiePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.884 -0400", hash_original_method = "FED8F85952C629683C8FDDFF3694A209", hash_generated_method = "828287FBFA9DF4DF9FF629A59C31B365")
    public void setPath(String path) {
        cookiePath = path;
        // ---------- Original Method ----------
        //cookiePath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.884 -0400", hash_original_method = "2B20469DA455C9BD6D7FF0533B3892AF", hash_generated_method = "9BD99C173F37B809EC0989266E052E0E")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125139194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125139194;
        // ---------- Original Method ----------
        //return isSecure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.885 -0400", hash_original_method = "4AAA79ACC137AF686983B7EBC1139378", hash_generated_method = "80C814C26050D1BDD00FD772F40A8600")
    public void setSecure(boolean secure) {
        isSecure = secure;
        // ---------- Original Method ----------
        //isSecure = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.885 -0400", hash_original_method = "792AB1F2DAEB6EDF4EEAFF71CFA593C4", hash_generated_method = "68C0BC89B3BFF615112766ACD32DF45C")
    public int[] getPorts() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1493396855 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1493396855;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.885 -0400", hash_original_method = "2C800BF7E3C2BFE0AFF685103351615E", hash_generated_method = "F7F2D59412ABA949BABC31F01DF0E8CC")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300751605 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300751605;
        // ---------- Original Method ----------
        //return cookieVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.886 -0400", hash_original_method = "F7EA098B11400592DB8473D6C4214C87", hash_generated_method = "DD9B9B71929423C85BF662F8126E82BA")
    public void setVersion(int version) {
        cookieVersion = version;
        // ---------- Original Method ----------
        //cookieVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.886 -0400", hash_original_method = "D870EC906D46A0EDE777AE892D1551DA", hash_generated_method = "BCC716C5A2C251B768E8623D90D6E7F2")
    public boolean isExpired(final Date date) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Date may not be null");
        } //End block
        boolean varA740ACE64F8524941C9B74882C66FD7E_1844248056 = ((cookieExpiryDate != null  
            && cookieExpiryDate.getTime() <= date.getTime()));
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451965019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_451965019;
        // ---------- Original Method ----------
        //if (date == null) {
            //throw new IllegalArgumentException("Date may not be null");
        //}
        //return (cookieExpiryDate != null  
            //&& cookieExpiryDate.getTime() <= date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.886 -0400", hash_original_method = "E880BF6096DC9B6A4C51BBDC86AAFD73", hash_generated_method = "290E1CBEB1F1EAD2561882647238D151")
    public void setAttribute(final String name, final String value) {
        this.attribs.put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.attribs.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.887 -0400", hash_original_method = "A480B1BC0B8318470327D71D112D198A", hash_generated_method = "EF74E20E3F5E26AE7C26BB4A7BFDE4BE")
    public String getAttribute(final String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_460444185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_460444185 = this.attribs.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_460444185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_460444185;
        // ---------- Original Method ----------
        //return this.attribs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.887 -0400", hash_original_method = "9757AE15474AD638D5A2DA06803715D2", hash_generated_method = "59DC8C22ED7C7BDE4F1219D6A42EB896")
    public boolean containsAttribute(final String name) {
        boolean varECB03B7EDFEDA4C0C645315D5AC48D3D_809733350 = (this.attribs.get(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417404356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417404356;
        // ---------- Original Method ----------
        //return this.attribs.get(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.887 -0400", hash_original_method = "7C7353B3FBE3C8967FDD9EF259B3710A", hash_generated_method = "304CC9F949E49CC172BA971125DBA8DC")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1744726194 = null; //Variable for return #1
        BasicClientCookie clone = (BasicClientCookie) super.clone();
        clone.attribs = new HashMap<String, String>(this.attribs);
        varB4EAC82CA7396A68D541C85D26508E83_1744726194 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1744726194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744726194;
        // ---------- Original Method ----------
        //BasicClientCookie clone = (BasicClientCookie) super.clone();
        //clone.attribs = new HashMap<String, String>(this.attribs);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.888 -0400", hash_original_method = "A8332973B56773C2F5F00A4DF3A49927", hash_generated_method = "FF9D8ACA16B695E83EF4B3BF06F97628")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1634818790 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1634818790 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1634818790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1634818790;
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

