package org.apache.http.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

public abstract class AbstractHttpEntity implements HttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.558 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "7707552268699116A6B81DCAB1E039E0")

    protected Header contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.558 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "EE4016A6B9EC527F15082EA3FB92CF90")

    protected Header contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.558 -0400", hash_original_field = "DFAB03D14C0C8E9BD80B4D5DB07170D3", hash_generated_field = "AC5AAC899B99DDB88A53898F83C297BE")

    protected boolean chunked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.559 -0400", hash_original_method = "7092D401475F156326EB612012D50800", hash_generated_method = "8090890FE04071B33C38618871FDA9FD")
    protected  AbstractHttpEntity() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.559 -0400", hash_original_method = "DA5232C01B88DD776A78D6C1E0EF7DB4", hash_generated_method = "07112480FF2865763DB5810BC08C9A28")
    public Header getContentType() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1232197752 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1232197752 = this.contentType;
        varB4EAC82CA7396A68D541C85D26508E83_1232197752.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1232197752;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.560 -0400", hash_original_method = "0300179EF34C28254565E1D29B0088D9", hash_generated_method = "B48AA0BE1396BC1973BA98B6FBB4A228")
    public Header getContentEncoding() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1926877715 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1926877715 = this.contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1926877715.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1926877715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.560 -0400", hash_original_method = "A2E32B99DD6261F3B5CB31D5FA7FC0FC", hash_generated_method = "821985E0A61B89B70A4C5322796BCABE")
    public boolean isChunked() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829288661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829288661;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.560 -0400", hash_original_method = "2A50843ADF5A0160EFC9E5758FE12891", hash_generated_method = "513E2D2C622089B4C38694763A24458C")
    public void setContentType(final Header contentType) {
        this.contentType = contentType;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.560 -0400", hash_original_method = "E88DF46252A0D3C2D0E67C1F492FFB2C", hash_generated_method = "D8325C98FA32017BC76D97638B596A07")
    public void setContentType(final String ctString) {
        Header h = null;
        {
            h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        } 
        setContentType(h);
        addTaint(ctString.getTaint());
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.561 -0400", hash_original_method = "DEBEEA900825B0657525159073BC33A3", hash_generated_method = "1A414CB42618A24BED38C8E50DD477A0")
    public void setContentEncoding(final Header contentEncoding) {
        this.contentEncoding = contentEncoding;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.561 -0400", hash_original_method = "C8D25A66722ADB2A8BE857D43D852F52", hash_generated_method = "705C7C5F967F349705509B931ACD6826")
    public void setContentEncoding(final String ceString) {
        Header h = null;
        {
            h = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        } 
        setContentEncoding(h);
        addTaint(ceString.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.562 -0400", hash_original_method = "1B88FA65FDF60169F373F298E33E777E", hash_generated_method = "31F89D88E68A040DC2DABC5362BEB7BE")
    public void setChunked(boolean b) {
        this.chunked = b;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.562 -0400", hash_original_method = "3048E7043703056EA818491E1D9863FC", hash_generated_method = "BD8F81ECEE3C8C289EA4E6C52F13D9DD")
    public void consumeContent() throws IOException, UnsupportedOperationException {
        {
            boolean var72EBA2DE13150A13520A1CB39AEB2004_2091279294 = (isStreaming());
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
                ("streaming entity does not implement consumeContent()");
            } 
        } 
        
        
            
                
        
    }

    
}

