package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;

public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.227 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "5D06E8A33AF1DD392678AE6DB220FDCF", hash_generated_field = "BD82217BCB79695C8D4F8280F58492AC")

    private Map<String, String> attribs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "22661022A0983AA8183EF5D4E781E343", hash_generated_field = "49AE069214DB59605844F82137D49FC9")

    private String cookieComment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "767EB00E7715D288DABD8726BB764A83", hash_generated_field = "AD16EF7E737207351A1DDFC924A741C2")

    private String cookieDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "D9E63AC71ED0406E327CF645C4EFB44F", hash_generated_field = "02CE10C2C10E05605173AB6CDB0713BF")

    private Date cookieExpiryDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "3B142C711BA30EE5FCE7FCAE4807F0BB", hash_generated_field = "147D52111E3980107A61285ED7C02D65")

    private String cookiePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "36E886528CA418649444F49929E4002D", hash_generated_field = "186FB9276C264E60A48BA46FB55EBBA1")

    private boolean isSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.228 -0400", hash_original_field = "40C4910675D17E7863242064AA3CD190", hash_generated_field = "D7C5934E6BB3D016D39F231A3AC7994A")

    private int cookieVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.229 -0400", hash_original_method = "C8595E792CE20A5CAAE662B588946A62", hash_generated_method = "648D532CF69F4855F4082F60606ABBF2")
    public  BasicClientCookie(final String name, final String value) {
        super();
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1466078296 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1466078296.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1466078296;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.229 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "FF2C23F64EB0FE72FBCC0C862F316C78")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_2091032832 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_2091032832.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_2091032832;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.229 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "D448109B7B547EF3131B6FFB56B15E4A")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_906564628 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_906564628.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_906564628;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.230 -0400", hash_original_method = "5A9FD1CB2995C306AE14120138CE8987", hash_generated_method = "5A3F164F4419E5A4EF475391DD8D78C7")
    public void setValue(final String value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.230 -0400", hash_original_method = "C285B5EE8A6AFFAC313010465DD6E476", hash_generated_method = "8013EAA735DF37F39E647BACFB508970")
    public String getComment() {
String var897C03D6997B8BD0081694FECC68E47D_50098262 =         cookieComment;
        var897C03D6997B8BD0081694FECC68E47D_50098262.addTaint(taint);
        return var897C03D6997B8BD0081694FECC68E47D_50098262;
        // ---------- Original Method ----------
        //return cookieComment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.231 -0400", hash_original_method = "B910B62E15C5C49D6C444731F0D794D6", hash_generated_method = "8D1DC8BDEA78694CF65D7EA1B7927347")
    public void setComment(String comment) {
        cookieComment = comment;
        // ---------- Original Method ----------
        //cookieComment = comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.231 -0400", hash_original_method = "6B60F393FA3D6EFC64000C911A9295EA", hash_generated_method = "BECFC0058FF1E8D5900A26E106D662E2")
    public String getCommentURL() {
String var540C13E9E156B687226421B24F2DF178_1560612337 =         null;
        var540C13E9E156B687226421B24F2DF178_1560612337.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1560612337;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.231 -0400", hash_original_method = "153D1D995EFAB40360B52407F1FDC7D7", hash_generated_method = "6E4700C4DFC6119C6BD9D8DFEE20CB21")
    public Date getExpiryDate() {
Date var32DC78FB10CF90DFF9332483DAC63C36_524741979 =         cookieExpiryDate;
        var32DC78FB10CF90DFF9332483DAC63C36_524741979.addTaint(taint);
        return var32DC78FB10CF90DFF9332483DAC63C36_524741979;
        // ---------- Original Method ----------
        //return cookieExpiryDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.232 -0400", hash_original_method = "9EF44BF5019D61A7024C6B9C062EE43B", hash_generated_method = "A14828052CB170795C206EB13DEE42D8")
    public void setExpiryDate(Date expiryDate) {
        cookieExpiryDate = expiryDate;
        // ---------- Original Method ----------
        //cookieExpiryDate = expiryDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.232 -0400", hash_original_method = "74F524BD848D4FFA3F86046FEE25CAD1", hash_generated_method = "9D690B5D4BF5D157CE878E998E3B3521")
    public boolean isPersistent() {
        boolean var435C74A5B280AFD7A23FC98D07156E06_1244827999 = ((null != cookieExpiryDate));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957245798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957245798;
        // ---------- Original Method ----------
        //return (null != cookieExpiryDate);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.232 -0400", hash_original_method = "B5778DA5E5DD3144D1C6A09AC82C1FC8", hash_generated_method = "F277A53EB2A728777FA770315A4B2732")
    public String getDomain() {
String varACAC48560E52CE1EFCABFE20FBBB64C4_835661487 =         cookieDomain;
        varACAC48560E52CE1EFCABFE20FBBB64C4_835661487.addTaint(taint);
        return varACAC48560E52CE1EFCABFE20FBBB64C4_835661487;
        // ---------- Original Method ----------
        //return cookieDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.233 -0400", hash_original_method = "9546A6CFEBFFD917E6EED03BE1DAE2AE", hash_generated_method = "BD9590C31883150E832F283F907790C5")
    public void setDomain(String domain) {
    if(domain != null)        
        {
            cookieDomain = domain.toLowerCase(Locale.ENGLISH);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.233 -0400", hash_original_method = "EE441836AE1D2ED7AB4F531592BB0685", hash_generated_method = "C0E890A81940935FCA7BC7C8CA976E37")
    public String getPath() {
String varBC6F7C939633E3CAB88354B71B894197_290462947 =         cookiePath;
        varBC6F7C939633E3CAB88354B71B894197_290462947.addTaint(taint);
        return varBC6F7C939633E3CAB88354B71B894197_290462947;
        // ---------- Original Method ----------
        //return cookiePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.233 -0400", hash_original_method = "FED8F85952C629683C8FDDFF3694A209", hash_generated_method = "828287FBFA9DF4DF9FF629A59C31B365")
    public void setPath(String path) {
        cookiePath = path;
        // ---------- Original Method ----------
        //cookiePath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.234 -0400", hash_original_method = "2B20469DA455C9BD6D7FF0533B3892AF", hash_generated_method = "59E76304B686FA1233DAACC92385834E")
    public boolean isSecure() {
        boolean var36E886528CA418649444F49929E4002D_60858888 = (isSecure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885449661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885449661;
        // ---------- Original Method ----------
        //return isSecure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.234 -0400", hash_original_method = "4AAA79ACC137AF686983B7EBC1139378", hash_generated_method = "80C814C26050D1BDD00FD772F40A8600")
    public void setSecure(boolean secure) {
        isSecure = secure;
        // ---------- Original Method ----------
        //isSecure = secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.234 -0400", hash_original_method = "792AB1F2DAEB6EDF4EEAFF71CFA593C4", hash_generated_method = "A351298FB5C74BC522521F0E44EAF30B")
    public int[] getPorts() {
        int[] var37A6259CC0C1DAE299A7866489DFF0BD_436169204 = (null);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1426566511 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1426566511;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.234 -0400", hash_original_method = "2C800BF7E3C2BFE0AFF685103351615E", hash_generated_method = "FEE38C3A0A28100C7E5BCDCC3C317D49")
    public int getVersion() {
        int var40C4910675D17E7863242064AA3CD190_1487770439 = (cookieVersion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187516496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187516496;
        // ---------- Original Method ----------
        //return cookieVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.235 -0400", hash_original_method = "F7EA098B11400592DB8473D6C4214C87", hash_generated_method = "DD9B9B71929423C85BF662F8126E82BA")
    public void setVersion(int version) {
        cookieVersion = version;
        // ---------- Original Method ----------
        //cookieVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.235 -0400", hash_original_method = "D870EC906D46A0EDE777AE892D1551DA", hash_generated_method = "EE6A39B4CDDB9C9153ABF2A5DA52759B")
    public boolean isExpired(final Date date) {
        addTaint(date.getTaint());
    if(date == null)        
        {
            IllegalArgumentException var6B5792103FDA66EE9F0A2A9C683ED19B_203209241 = new IllegalArgumentException("Date may not be null");
            var6B5792103FDA66EE9F0A2A9C683ED19B_203209241.addTaint(taint);
            throw var6B5792103FDA66EE9F0A2A9C683ED19B_203209241;
        } //End block
        boolean var8A7CA1F1C44F16863E7DB2E5ACE72CA0_225716294 = ((cookieExpiryDate != null  
            && cookieExpiryDate.getTime() <= date.getTime()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969815603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969815603;
        // ---------- Original Method ----------
        //if (date == null) {
            //throw new IllegalArgumentException("Date may not be null");
        //}
        //return (cookieExpiryDate != null  
            //&& cookieExpiryDate.getTime() <= date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.235 -0400", hash_original_method = "E880BF6096DC9B6A4C51BBDC86AAFD73", hash_generated_method = "D52F0ADE5F5D3BC2CEEE00CAD63C8C1D")
    public void setAttribute(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        this.attribs.put(name, value);
        // ---------- Original Method ----------
        //this.attribs.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.235 -0400", hash_original_method = "A480B1BC0B8318470327D71D112D198A", hash_generated_method = "C1DF6AB63C2B5EEC0CA81BB7060990E5")
    public String getAttribute(final String name) {
        addTaint(name.getTaint());
String var504D37BFBBEF030602D3BBE73E3371D5_1911059006 =         this.attribs.get(name);
        var504D37BFBBEF030602D3BBE73E3371D5_1911059006.addTaint(taint);
        return var504D37BFBBEF030602D3BBE73E3371D5_1911059006;
        // ---------- Original Method ----------
        //return this.attribs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.236 -0400", hash_original_method = "9757AE15474AD638D5A2DA06803715D2", hash_generated_method = "9794436084A986BE4CE7A7F5277F1417")
    public boolean containsAttribute(final String name) {
        addTaint(name.getTaint());
        boolean var30FB0ED9E11AC680182846F927FAFD26_437847019 = (this.attribs.get(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83418894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83418894;
        // ---------- Original Method ----------
        //return this.attribs.get(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.236 -0400", hash_original_method = "7C7353B3FBE3C8967FDD9EF259B3710A", hash_generated_method = "57C5CBFD85B0039606D5E8F8375F40D4")
    @Override
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie clone = (BasicClientCookie) super.clone();
        clone.attribs = new HashMap<String, String>(this.attribs);
Object var3DE52045BFD3C1BF3742F994ED6139AD_928345417 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_928345417.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_928345417;
        // ---------- Original Method ----------
        //BasicClientCookie clone = (BasicClientCookie) super.clone();
        //clone.attribs = new HashMap<String, String>(this.attribs);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.237 -0400", hash_original_method = "A8332973B56773C2F5F00A4DF3A49927", hash_generated_method = "28EB7E3D732A7AB0D0961344666A2C61")
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
String varD03843288D33B9E1D3062E25339ECF6D_1893333676 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1893333676.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1893333676;
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

