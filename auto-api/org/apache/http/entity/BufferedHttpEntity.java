package org.apache.http.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class BufferedHttpEntity extends HttpEntityWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.590 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.592 -0400", hash_original_method = "9933624B15A1F62492A5E829A3A364D0", hash_generated_method = "3F28E916793E00ADB0A2C83C84174CFD")
    public  BufferedHttpEntity(final HttpEntity entity) throws IOException {
        super(entity);
        {
            boolean var42645DCCE1E77C405020D4089695E44D_1689791776 = (!entity.isRepeatable() || entity.getContentLength() < 0);
            {
                this.buffer = EntityUtils.toByteArray(entity);
            } 
            {
                this.buffer = null;
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.594 -0400", hash_original_method = "26AA3A162E430A9FEBBBBE7476A32626", hash_generated_method = "342E9471B5A7925AE385EAC33F293590")
    public long getContentLength() {
        {
            long varB6AA5DA0DD38948E6D83260B0102CBFF_773370598 = (wrappedEntity.getContentLength());
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_81298395 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_81298395;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.596 -0400", hash_original_method = "C66624A0F56D5B3373911F6483E82581", hash_generated_method = "F67A79BF2D568EFEE44DB8E0103D9D69")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1664709385 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_700485066 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1664709385 = new ByteArrayInputStream(this.buffer);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_700485066 = wrappedEntity.getContent();
        } 
        InputStream varA7E53CE21691AB073D9660D615818899_128625107; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_128625107 = varB4EAC82CA7396A68D541C85D26508E83_1664709385;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_128625107 = varB4EAC82CA7396A68D541C85D26508E83_700485066;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_128625107.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_128625107;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.596 -0400", hash_original_method = "2A121AFE9268A901CC611E90FC00D0E8", hash_generated_method = "C686E270ADBE2DB08CC763495117BABC")
    public boolean isChunked() {
        boolean var5B8668F885218BF58EAEE896094735B0_183061608 = ((buffer == null) && wrappedEntity.isChunked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256091881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256091881;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.597 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "A0FA756BF78F5E6B636748C4CEC84B36")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985680179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985680179;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.597 -0400", hash_original_method = "6978AFF2D6BA6FB48D86DE86B3A93492", hash_generated_method = "B91875387B08AEAA90BB8BC66D026C00")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } 
        {
            outstream.write(this.buffer);
        } 
        {
            wrappedEntity.writeTo(outstream);
        } 
        addTaint(outstream.getTaint());
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.598 -0400", hash_original_method = "298A03178432926E5E6E7F0EA9A50E03", hash_generated_method = "A6308C5E4C5AF9DC4A0B8F5E020B0161")
    public boolean isStreaming() {
        boolean var9EEC56ECE9813C929E1EF0389C57597D_2054994159 = ((buffer == null) && wrappedEntity.isStreaming());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_994811658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_994811658;
        
        
    }

    
}

