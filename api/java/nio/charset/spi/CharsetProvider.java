package java.nio.charset.spi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class CharsetProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.905 -0400", hash_original_method = "71B9A0846B394A5E85543A853F8CC262", hash_generated_method = "E9423E783CD0299C830EA4AD9E2C58C1")
    protected  CharsetProvider() {
        
    }

    
    public abstract Iterator<Charset> charsets();

    
    public abstract Charset charsetForName(String charsetName);

    
}

