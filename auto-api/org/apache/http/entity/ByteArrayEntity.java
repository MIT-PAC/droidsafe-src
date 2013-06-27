package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.863 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "5694DF6F087835D263272D46C49C87A7")

    protected byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.864 -0400", hash_original_method = "85F43E7DC885CA97417C9F3E2732068E", hash_generated_method = "DC081671B5731685DF6419372C99946A")
    public  ByteArrayEntity(final byte[] b) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Source byte array may not be null");
        } //End block
        this.content = b;
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Source byte array may not be null");
        //}
        //this.content = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.864 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "D4C03D85B0DA4A6E1381F2833D8E3E1B")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027957347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027957347;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.870 -0400", hash_original_method = "161FF0185286748984501E39486F36ED", hash_generated_method = "A66BA94BB0B75403B2ADDAB5C2678C2E")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1221791221 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1221791221;
        // ---------- Original Method ----------
        //return this.content.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.871 -0400", hash_original_method = "004C3F78EC3F500E7D7F762D94BAEB0E", hash_generated_method = "A916B4C291DF012E6A3E83C00AAB51C5")
    public InputStream getContent() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1333599365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1333599365 = new ByteArrayInputStream(this.content);
        varB4EAC82CA7396A68D541C85D26508E83_1333599365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1333599365;
        // ---------- Original Method ----------
        //return new ByteArrayInputStream(this.content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.877 -0400", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "54161771E12CA61F63AA77C457A76B65")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } //End block
        outstream.write(this.content);
        outstream.flush();
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //outstream.write(this.content);
        //outstream.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.880 -0400", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "BDFFF813536089DDCE23659EAF1FAA5D")
    public boolean isStreaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735375884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735375884;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.881 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "FE0C17A249777E040B8EFE1420698AFC")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_411848667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_411848667 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_411848667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_411848667;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

