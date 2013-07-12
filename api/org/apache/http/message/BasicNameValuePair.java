package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.640 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.640 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.641 -0400", hash_original_method = "9B16B3F0FD8B0C655E61EA7019E7F0C5", hash_generated_method = "67F062AD1E6FBDDA967D44CA35ED0360")
    public  BasicNameValuePair(final String name, final String value) {
        super();
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_351379625 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_351379625.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_351379625;
        } 
        this.name = name;
        this.value = value;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.641 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "3703D79C0E179FC54ACEB7DD2C3908CC")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_1493112174 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_1493112174.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_1493112174;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.641 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "34D8EBD3287C215C12855BF38D44D2A8")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_1544299887 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_1544299887.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_1544299887;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.641 -0400", hash_original_method = "93FF9F6BC44FD78A86FF56612368CE29", hash_generated_method = "03B8169764C2D36308E0CE0F8F2A22FE")
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
        } 
String varD03843288D33B9E1D3062E25339ECF6D_278800300 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_278800300.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_278800300;
        
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.642 -0400", hash_original_method = "3849D74FE9AE53A80E5FA00389489FFC", hash_generated_method = "B10F4900E72B7BD6BFFFD4773706169F")
    public boolean equals(final Object object) {
        addTaint(object.getTaint());
    if(object == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_525258238 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_360261182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_360261182;
        }
    if(this == object)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_900107437 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327523081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327523081;
        }
    if(object instanceof NameValuePair)        
        {
            BasicNameValuePair that = (BasicNameValuePair) object;
            boolean var48FF2A40BD6D02BC6D12EC051CAF18CA_473947315 = (this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399211909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_399211909;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1965121390 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051697535 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051697535;
        } 
        
        
        
        
            
            
                  
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.643 -0400", hash_original_method = "A586BF0615CE91E5DB31F98DF42747A4", hash_generated_method = "1A86F391B8A9C563BB3C592502D0F47A")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        int var0800FC577294C34E0B28AD2839435945_1058766626 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858352886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858352886;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.644 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "536C70E4300C39AAB3E7885FC8D3C48D")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_372403417 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_372403417.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_372403417;
        
        
    }

    
}

