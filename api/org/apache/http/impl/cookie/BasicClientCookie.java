package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;






public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.552 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.552 -0400", hash_original_field = "5D06E8A33AF1DD392678AE6DB220FDCF", hash_generated_field = "BD82217BCB79695C8D4F8280F58492AC")

    private Map<String, String> attribs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.552 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.552 -0400", hash_original_field = "22661022A0983AA8183EF5D4E781E343", hash_generated_field = "49AE069214DB59605844F82137D49FC9")

    private String cookieComment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.553 -0400", hash_original_field = "767EB00E7715D288DABD8726BB764A83", hash_generated_field = "AD16EF7E737207351A1DDFC924A741C2")

    private String cookieDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.553 -0400", hash_original_field = "D9E63AC71ED0406E327CF645C4EFB44F", hash_generated_field = "02CE10C2C10E05605173AB6CDB0713BF")

    private Date cookieExpiryDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.553 -0400", hash_original_field = "3B142C711BA30EE5FCE7FCAE4807F0BB", hash_generated_field = "147D52111E3980107A61285ED7C02D65")

    private String cookiePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.553 -0400", hash_original_field = "36E886528CA418649444F49929E4002D", hash_generated_field = "186FB9276C264E60A48BA46FB55EBBA1")

    private boolean isSecure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.553 -0400", hash_original_field = "40C4910675D17E7863242064AA3CD190", hash_generated_field = "D7C5934E6BB3D016D39F231A3AC7994A")

    private int cookieVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.554 -0400", hash_original_method = "C8595E792CE20A5CAAE662B588946A62", hash_generated_method = "12198C279F869D07CDF5D51D24C02AD2")
    public  BasicClientCookie(final String name, final String value) {
        super();
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_654037581 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_654037581.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_654037581;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.555 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "4E3A419C6BB2A9A71E00F14E7DA66C7E")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_1365215108 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_1365215108.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_1365215108;
        // ---------- Original Method ----------
        //return this.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.555 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "CDB83B22713AFA26326CEEA8B5FAB726")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_1908402108 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_1908402108.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_1908402108;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.555 -0400", hash_original_method = "5A9FD1CB2995C306AE14120138CE8987", hash_generated_method = "5A3F164F4419E5A4EF475391DD8D78C7")
    public void setValue(final String value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.556 -0400", hash_original_method = "C285B5EE8A6AFFAC313010465DD6E476", hash_generated_method = "53110823B72CBD36CC56F601DF5B7240")
    public String getComment() {
String var897C03D6997B8BD0081694FECC68E47D_709249033 =         cookieComment;
        var897C03D6997B8BD0081694FECC68E47D_709249033.addTaint(taint);
        return var897C03D6997B8BD0081694FECC68E47D_709249033;
        // ---------- Original Method ----------
        //return cookieComment;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.556 -0400", hash_original_method = "B910B62E15C5C49D6C444731F0D794D6", hash_generated_method = "8D1DC8BDEA78694CF65D7EA1B7927347")
    public void setComment(String comment) {
        cookieComment = comment;
        // ---------- Original Method ----------
        //cookieComment = comment;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.556 -0400", hash_original_method = "6B60F393FA3D6EFC64000C911A9295EA", hash_generated_method = "ACDFE3F57E09E4FE95F8FCBA2E39B23A")
    public String getCommentURL() {
String var540C13E9E156B687226421B24F2DF178_788225357 =         null;
        var540C13E9E156B687226421B24F2DF178_788225357.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_788225357;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.557 -0400", hash_original_method = "153D1D995EFAB40360B52407F1FDC7D7", hash_generated_method = "7C8DDDDF0077AD48B9A15994CA8103E7")
    public Date getExpiryDate() {
Date var32DC78FB10CF90DFF9332483DAC63C36_59294018 =         cookieExpiryDate;
        var32DC78FB10CF90DFF9332483DAC63C36_59294018.addTaint(taint);
        return var32DC78FB10CF90DFF9332483DAC63C36_59294018;
        // ---------- Original Method ----------
        //return cookieExpiryDate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.557 -0400", hash_original_method = "9EF44BF5019D61A7024C6B9C062EE43B", hash_generated_method = "A14828052CB170795C206EB13DEE42D8")
    public void setExpiryDate(Date expiryDate) {
        cookieExpiryDate = expiryDate;
        // ---------- Original Method ----------
        //cookieExpiryDate = expiryDate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.557 -0400", hash_original_method = "74F524BD848D4FFA3F86046FEE25CAD1", hash_generated_method = "96F5665E1011892C27567C1A7E62EBE0")
    public boolean isPersistent() {
        boolean var435C74A5B280AFD7A23FC98D07156E06_1596141010 = ((null != cookieExpiryDate));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1931990331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1931990331;
        // ---------- Original Method ----------
        //return (null != cookieExpiryDate);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.558 -0400", hash_original_method = "B5778DA5E5DD3144D1C6A09AC82C1FC8", hash_generated_method = "93F93ED95D2A7066D67C12EB6B72A264")
    public String getDomain() {
String varACAC48560E52CE1EFCABFE20FBBB64C4_2039643330 =         cookieDomain;
        varACAC48560E52CE1EFCABFE20FBBB64C4_2039643330.addTaint(taint);
        return varACAC48560E52CE1EFCABFE20FBBB64C4_2039643330;
        // ---------- Original Method ----------
        //return cookieDomain;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.558 -0400", hash_original_method = "9546A6CFEBFFD917E6EED03BE1DAE2AE", hash_generated_method = "BD9590C31883150E832F283F907790C5")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.558 -0400", hash_original_method = "EE441836AE1D2ED7AB4F531592BB0685", hash_generated_method = "47907765BB0BADCDB3DC33D5D8E4F219")
    public String getPath() {
String varBC6F7C939633E3CAB88354B71B894197_1634658164 =         cookiePath;
        varBC6F7C939633E3CAB88354B71B894197_1634658164.addTaint(taint);
        return varBC6F7C939633E3CAB88354B71B894197_1634658164;
        // ---------- Original Method ----------
        //return cookiePath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.559 -0400", hash_original_method = "FED8F85952C629683C8FDDFF3694A209", hash_generated_method = "828287FBFA9DF4DF9FF629A59C31B365")
    public void setPath(String path) {
        cookiePath = path;
        // ---------- Original Method ----------
        //cookiePath = path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.559 -0400", hash_original_method = "2B20469DA455C9BD6D7FF0533B3892AF", hash_generated_method = "56D11E448B718258E9AE2064AF8577DB")
    public boolean isSecure() {
        boolean var36E886528CA418649444F49929E4002D_1937807497 = (isSecure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050938674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050938674;
        // ---------- Original Method ----------
        //return isSecure;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.560 -0400", hash_original_method = "4AAA79ACC137AF686983B7EBC1139378", hash_generated_method = "80C814C26050D1BDD00FD772F40A8600")
    public void setSecure(boolean secure) {
        isSecure = secure;
        // ---------- Original Method ----------
        //isSecure = secure;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.560 -0400", hash_original_method = "792AB1F2DAEB6EDF4EEAFF71CFA593C4", hash_generated_method = "7846C9823AF86BA58BD8EC3F128258C5")
    public int[] getPorts() {
        int[] var37A6259CC0C1DAE299A7866489DFF0BD_1610947675 = (null);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1278353735 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1278353735;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.560 -0400", hash_original_method = "2C800BF7E3C2BFE0AFF685103351615E", hash_generated_method = "0C372FFBDEFDD4BB48E7CDBEB5DA7DD0")
    public int getVersion() {
        int var40C4910675D17E7863242064AA3CD190_1208926373 = (cookieVersion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412708591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412708591;
        // ---------- Original Method ----------
        //return cookieVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.561 -0400", hash_original_method = "F7EA098B11400592DB8473D6C4214C87", hash_generated_method = "DD9B9B71929423C85BF662F8126E82BA")
    public void setVersion(int version) {
        cookieVersion = version;
        // ---------- Original Method ----------
        //cookieVersion = version;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.561 -0400", hash_original_method = "D870EC906D46A0EDE777AE892D1551DA", hash_generated_method = "0613269E739C51CF8FB9C8AA183DD236")
    public boolean isExpired(final Date date) {
        addTaint(date.getTaint());
        if(date == null)        
        {
            IllegalArgumentException var6B5792103FDA66EE9F0A2A9C683ED19B_91685024 = new IllegalArgumentException("Date may not be null");
            var6B5792103FDA66EE9F0A2A9C683ED19B_91685024.addTaint(taint);
            throw var6B5792103FDA66EE9F0A2A9C683ED19B_91685024;
        } //End block
        boolean var8A7CA1F1C44F16863E7DB2E5ACE72CA0_1531873321 = ((cookieExpiryDate != null  
            && cookieExpiryDate.getTime() <= date.getTime()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079797311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079797311;
        // ---------- Original Method ----------
        //if (date == null) {
            //throw new IllegalArgumentException("Date may not be null");
        //}
        //return (cookieExpiryDate != null  
            //&& cookieExpiryDate.getTime() <= date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.561 -0400", hash_original_method = "E880BF6096DC9B6A4C51BBDC86AAFD73", hash_generated_method = "D52F0ADE5F5D3BC2CEEE00CAD63C8C1D")
    public void setAttribute(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        this.attribs.put(name, value);
        // ---------- Original Method ----------
        //this.attribs.put(name, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.562 -0400", hash_original_method = "A480B1BC0B8318470327D71D112D198A", hash_generated_method = "AE47E2E8326EE0845F32DB3BF2FB7651")
    public String getAttribute(final String name) {
        addTaint(name.getTaint());
String var504D37BFBBEF030602D3BBE73E3371D5_346211558 =         this.attribs.get(name);
        var504D37BFBBEF030602D3BBE73E3371D5_346211558.addTaint(taint);
        return var504D37BFBBEF030602D3BBE73E3371D5_346211558;
        // ---------- Original Method ----------
        //return this.attribs.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.562 -0400", hash_original_method = "9757AE15474AD638D5A2DA06803715D2", hash_generated_method = "144F8904F9AEB6BB346628ABC8B229BE")
    public boolean containsAttribute(final String name) {
        addTaint(name.getTaint());
        boolean var30FB0ED9E11AC680182846F927FAFD26_767185348 = (this.attribs.get(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287631071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287631071;
        // ---------- Original Method ----------
        //return this.attribs.get(name) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.562 -0400", hash_original_method = "7C7353B3FBE3C8967FDD9EF259B3710A", hash_generated_method = "B80877437F182F73D99C5108399BF229")
    @Override
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie clone = (BasicClientCookie) super.clone();
        clone.attribs = new HashMap<String, String>(this.attribs);
Object var3DE52045BFD3C1BF3742F994ED6139AD_2077191576 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_2077191576.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_2077191576;
        // ---------- Original Method ----------
        //BasicClientCookie clone = (BasicClientCookie) super.clone();
        //clone.attribs = new HashMap<String, String>(this.attribs);
        //return clone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.563 -0400", hash_original_method = "A8332973B56773C2F5F00A4DF3A49927", hash_generated_method = "4B24296BFE853A7D43BCB017A5E16155")
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
String varD03843288D33B9E1D3062E25339ECF6D_714125681 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_714125681.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_714125681;
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

