package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

public class BasicHeader implements Header, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.291 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.291 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.292 -0400", hash_original_method = "2FB38EAD7D5E85502A5A04936633433A", hash_generated_method = "42B0BBAD61589F6A9EF1CEBAFAE3D625")
    public  BasicHeader(final String name, final String value) {
        super();
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_33273333 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_33273333.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_33273333;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.292 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "C63B9344E7A2A0D13B47D86A0A5778A2")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_1995769392 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_1995769392.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_1995769392;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.293 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "39BC0351337F4E1697288DF15B89A89D")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_699538575 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_699538575.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_699538575;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.293 -0400", hash_original_method = "F969228997B8CD2234867EA0CA894312", hash_generated_method = "59732DCD7848B402EC69BDB90B5A4527")
    public String toString() {
String var3240027F019094032D6E79F8261F1C67_1085096651 =         BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
        var3240027F019094032D6E79F8261F1C67_1085096651.addTaint(taint);
        return var3240027F019094032D6E79F8261F1C67_1085096651;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.293 -0400", hash_original_method = "4A0D34AA034E5A375AA25DFEEA935661", hash_generated_method = "E5AB925D6B92F5C605D17F80F484109F")
    public HeaderElement[] getElements() throws ParseException {
    if(this.value != null)        
        {
HeaderElement[] var8E9BB83D47D4791E94E3C45066284CBD_594505654 =             BasicHeaderValueParser.parseElements(this.value, null);
            var8E9BB83D47D4791E94E3C45066284CBD_594505654.addTaint(taint);
            return var8E9BB83D47D4791E94E3C45066284CBD_594505654;
        } //End block
        else
        {
HeaderElement[] var500E91C31ED37DF8B17C895D7E8D1295_2097140452 =             new HeaderElement[] {};
            var500E91C31ED37DF8B17C895D7E8D1295_2097140452.addTaint(taint);
            return var500E91C31ED37DF8B17C895D7E8D1295_2097140452;
        } //End block
        // ---------- Original Method ----------
        //if (this.value != null) {
            //return BasicHeaderValueParser.parseElements(this.value, null);
        //} else {
            //return new HeaderElement[] {}; 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.304 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "94BBFB1E565D9FF75C5711AFC5BBC7F0")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_203666803 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_203666803.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_203666803;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

