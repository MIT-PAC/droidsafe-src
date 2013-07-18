package java.nio.charset.spi;

// Droidsafe Imports
import java.nio.charset.Charset;
import java.util.Iterator;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class CharsetProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.711 -0400", hash_original_method = "71B9A0846B394A5E85543A853F8CC262", hash_generated_method = "E9423E783CD0299C830EA4AD9E2C58C1")
    protected  CharsetProvider() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Iterator<Charset> charsets();

    
    @DSModeled(DSC.SAFE)
    public abstract Charset charsetForName(String charsetName);

    
}

