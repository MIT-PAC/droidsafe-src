package org.apache.http.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEntity extends AbstractHttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.634 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "E10265C22C3282384A3FF9B20A322BFE")

    private InputStream content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.634 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.634 -0400", hash_original_field = "56ABCB31D60DF0EE33CD31B673E135E7", hash_generated_field = "7CAB7C0CCDF9ABBB1D6144ACE3ECB9F8")

    private boolean consumed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.635 -0400", hash_original_method = "9ECB63D0474F50482B9F88A6526A3761", hash_generated_method = "D8071E8644AF2D53D625A1C593BCBAFF")
    public  InputStreamEntity(final InputStream instream, long length) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Source input stream may not be null");
        } 
        this.content = instream;
        this.length = length;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.635 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "FB2B69B59F62BE48FAE9EACE8D9706E1")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687518374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_687518374;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.636 -0400", hash_original_method = "120309BFFDD6935F8B30886147626A04", hash_generated_method = "4114004BC034CADB25AEF2F243620D34")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_363971981 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_363971981;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.636 -0400", hash_original_method = "ED2F9B5D6194544F22CDAF63FF5B39F6", hash_generated_method = "4484FEB8881F3A85AF7606704CB3C370")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2106244019 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2106244019 = this.content;
        varB4EAC82CA7396A68D541C85D26508E83_2106244019.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2106244019;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.637 -0400", hash_original_method = "094DB6B8612142F129E3320AF13B6EB0", hash_generated_method = "A8A198FE8CB4B85433645FCB969D4819")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } 
        InputStream instream = this.content;
        byte[] buffer = new byte[BUFFER_SIZE];
        int l;
        {
            {
                boolean var20A239439BFC45885A38ACB5E9FF40DA_556877905 = ((l = instream.read(buffer)) != -1);
                {
                    outstream.write(buffer, 0, l);
                } 
            } 
        } 
        {
            long remaining = this.length;
            {
                l = instream.read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
                outstream.write(buffer, 0, l);
                remaining -= l;
            } 
        } 
        this.consumed = true;
        addTaint(outstream.getTaint());
        
        
            
        
        
        
        
        
            
                
            
        
            
            
                
                
                    
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.638 -0400", hash_original_method = "3E82383C0A86BE67DCD75D0F1508916B", hash_generated_method = "135AD0009CF2CA3C2E5EF048D81A077D")
    public boolean isStreaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1307236178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1307236178;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.638 -0400", hash_original_method = "1B9AD287611C066C29846341DA0AFC9D", hash_generated_method = "BB7A77B851C987DED184DD1B2AE91934")
    public void consumeContent() throws IOException {
        this.consumed = true;
        this.content.close();
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.638 -0400", hash_original_field = "D4808A3FE7592153FBF8721DE2EDDCBC", hash_generated_field = "6E2192BB486EB38AA227C1403F5C8AE0")

    private final static int BUFFER_SIZE = 2048;
}

