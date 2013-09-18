package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;






public class BasicHeader implements Header, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.698 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.698 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.699 -0400", hash_original_method = "2FB38EAD7D5E85502A5A04936633433A", hash_generated_method = "2268A122220E70DE109390FAFB9203FD")
    public  BasicHeader(final String name, final String value) {
        super();
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_1266158471 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_1266158471.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_1266158471;
        } //End block
        this.name = name;
        this.value = value;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //this.name = name;
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.700 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "A948D4EBDDA015FB210E74C94506B256")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_2100216373 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_2100216373.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_2100216373;
        // ---------- Original Method ----------
        //return this.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.700 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "54A11BC7D8E978B8E110946FC12F8AB4")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_8538494 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_8538494.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_8538494;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.700 -0400", hash_original_method = "F969228997B8CD2234867EA0CA894312", hash_generated_method = "353E06F6F402A9A35531AFA216E0E961")
    public String toString() {
String var3240027F019094032D6E79F8261F1C67_1213109702 =         BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
        var3240027F019094032D6E79F8261F1C67_1213109702.addTaint(taint);
        return var3240027F019094032D6E79F8261F1C67_1213109702;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.700 -0400", hash_original_method = "4A0D34AA034E5A375AA25DFEEA935661", hash_generated_method = "4A0321A6709B7DC2518ED64D52C71137")
    public HeaderElement[] getElements() throws ParseException {
        if(this.value != null)        
        {
HeaderElement[] var8E9BB83D47D4791E94E3C45066284CBD_1131267438 =             BasicHeaderValueParser.parseElements(this.value, null);
            var8E9BB83D47D4791E94E3C45066284CBD_1131267438.addTaint(taint);
            return var8E9BB83D47D4791E94E3C45066284CBD_1131267438;
        } //End block
        else
        {
HeaderElement[] var500E91C31ED37DF8B17C895D7E8D1295_922484526 =             new HeaderElement[] {};
            var500E91C31ED37DF8B17C895D7E8D1295_922484526.addTaint(taint);
            return var500E91C31ED37DF8B17C895D7E8D1295_922484526;
        } //End block
        // ---------- Original Method ----------
        //if (this.value != null) {
            //return BasicHeaderValueParser.parseElements(this.value, null);
        //} else {
            //return new HeaderElement[] {}; 
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.701 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "8201A9DDD02921B6DDD510BAB8504846")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_387153739 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_387153739.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_387153739;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

