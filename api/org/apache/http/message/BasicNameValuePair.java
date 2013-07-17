package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.021 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.022 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.023 -0400", hash_original_method = "9B16B3F0FD8B0C655E61EA7019E7F0C5", hash_generated_method = "028C6F5A6ABFF2627683D88B217460D2")
    public  BasicNameValuePair(final String name, final String value) {
        super();
        if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_2012762784 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_2012762784.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_2012762784;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.023 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "21676BB51A71671ED2A7BDA1FE77AE4E")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_156255620 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_156255620.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_156255620;
        // ---------- Original Method ----------
        //return this.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.024 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "0B3E1EBBDFA4773DCE66A7F8031DDE1F")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_1056472866 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_1056472866.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_1056472866;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.024 -0400", hash_original_method = "93FF9F6BC44FD78A86FF56612368CE29", hash_generated_method = "AA1699EF68054BABEB5ED34E720236F6")
    public String toString() {
        int len = this.name.length();
        if(this.value != null)        
        len += 1 + this.value.length();
        CharArrayBuffer buffer = new CharArrayBuffer(len);
        buffer.append(this.name);
        if(this.value != null)        
        {
            buffer.append("=");
            buffer.append(this.value);
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_227381843 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_227381843.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_227381843;
        // ---------- Original Method ----------
        //int len = this.name.length();
        //if (this.value != null)
            //len += 1 + this.value.length();
        //CharArrayBuffer buffer = new CharArrayBuffer(len);
        //buffer.append(this.name);
        //if (this.value != null) {
            //buffer.append("=");
            //buffer.append(this.value);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.025 -0400", hash_original_method = "3849D74FE9AE53A80E5FA00389489FFC", hash_generated_method = "E69F88751F6C8B4710352C6A893FB9E2")
    public boolean equals(final Object object) {
        addTaint(object.getTaint());
        if(object == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1750245450 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706780623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706780623;
        }
        if(this == object)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_655373971 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294202961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_294202961;
        }
        if(object instanceof NameValuePair)        
        {
            BasicNameValuePair that = (BasicNameValuePair) object;
            boolean var48FF2A40BD6D02BC6D12EC051CAF18CA_896382867 = (this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240087990 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_240087990;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1416827452 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976534970 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976534970;
        } //End block
        // ---------- Original Method ----------
        //if (object == null) return false;
        //if (this == object) return true;
        //if (object instanceof NameValuePair) {
            //BasicNameValuePair that = (BasicNameValuePair) object;
            //return this.name.equals(that.name)
                  //&& LangUtils.equals(this.value, that.value);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.026 -0400", hash_original_method = "A586BF0615CE91E5DB31F98DF42747A4", hash_generated_method = "660BA3311477E55A58A146B217929EA3")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        int var0800FC577294C34E0B28AD2839435945_431013725 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120852418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120852418;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.026 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "6D231CA30DB8E8C24C96E83FDAD7045E")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1235562194 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1235562194.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1235562194;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

