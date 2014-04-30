package java.nio.charset.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class CharsetProvider {
    /**
     * Constructor for subclassing with concrete types.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.735 -0500", hash_original_method = "71B9A0846B394A5E85543A853F8CC262", hash_generated_method = "59DF855CF64856033BCC1CA3D13C2C92")
    
protected CharsetProvider() {
    }

    /**
     * Returns an iterator over all the available charsets.
     *
     * @return the iterator.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.737 -0500", hash_original_method = "709EC9B16996CA6DF02EC1EFC9088A58", hash_generated_method = "94B3EF507179C12F4E718B1D8C107E28")
    
public abstract Iterator<Charset> charsets();

    /**
     * Returns the named charset.
     * <p>
     * If the charset is unavailable the method returns <code>null</code>.
     * </p>
     *
     * @param charsetName
     *            the canonical or alias name of a character set.
     * @return the charset, or <code>null</code> if unavailable.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.740 -0500", hash_original_method = "BA31824ED4CC04936E987AEF123C88CF", hash_generated_method = "7483DA9550BEF926E3779E9C676D05E8")
    
public abstract Charset charsetForName(String charsetName);
    
}

