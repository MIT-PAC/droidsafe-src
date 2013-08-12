package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.415 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.416 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSModeled(DSC.SAFE)
	public BasicNameValuePair(final String name, final String value) {
		addTaint(name.getTaint());
		addTaint(value.getTaint());
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.423 -0400", hash_original_method = "93FF9F6BC44FD78A86FF56612368CE29", hash_generated_method = "38D4F2713259BF406952562B96165348")
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
String varD03843288D33B9E1D3062E25339ECF6D_851499724 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_851499724.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_851499724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.428 -0400", hash_original_method = "3849D74FE9AE53A80E5FA00389489FFC", hash_generated_method = "E501B96FDC97F1CADB8113019EE6C063")
    public boolean equals(final Object object) {
        addTaint(object.getTaint());
        if(object == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_702796866 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670600246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670600246;
        }
        if(this == object)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1908485907 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815360279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815360279;
        }
        if(object instanceof NameValuePair)        
        {
            BasicNameValuePair that = (BasicNameValuePair) object;
            boolean var48FF2A40BD6D02BC6D12EC051CAF18CA_731374716 = (this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795498025 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795498025;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1047844280 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591341563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_591341563;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.435 -0400", hash_original_method = "A586BF0615CE91E5DB31F98DF42747A4", hash_generated_method = "88EBD1952D09F35559303C272D58EA9A")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        int var0800FC577294C34E0B28AD2839435945_1339908801 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109733194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109733194;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.437 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "2DE6C0F71CA8F7260FB3725663DEBEA7")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1514908937 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1514908937.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1514908937;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

