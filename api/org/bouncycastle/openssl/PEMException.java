package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class PEMException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.221 -0400", hash_original_field = "4AB57483724829010C32E288B605D5E5", hash_generated_field = "C31C43ABE3D5D61AFE96A228698D8959")

    Exception underlying;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.221 -0400", hash_original_method = "DBCE2D6935FCAE6513D26D3BE9F92180", hash_generated_method = "3B5A6E1FAC809290D7BA159E9C8E5806")
    public  PEMException(
        String    message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.222 -0400", hash_original_method = "62F9842AAA557466DBCCBFAEB65A702E", hash_generated_method = "8684CFB22E02D8156ADEFBB1AF7A7F30")
    public  PEMException(
        String        message,
        Exception    underlying) {
        super(message);
        addTaint(message.getTaint());
        this.underlying = underlying;
        // ---------- Original Method ----------
        //this.underlying = underlying;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.222 -0400", hash_original_method = "8D4B98C08FC53F956480CC6A65685E20", hash_generated_method = "1B93EF2BA42B83A8797D34C142E642FF")
    public Exception getUnderlyingException() {
Exception var77A55F525D35035B29E3829296BB2E65_1803845219 =         underlying;
        var77A55F525D35035B29E3829296BB2E65_1803845219.addTaint(taint);
        return var77A55F525D35035B29E3829296BB2E65_1803845219;
        // ---------- Original Method ----------
        //return underlying;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.223 -0400", hash_original_method = "F2813220852B09056C9C149C0538BE80", hash_generated_method = "86DE7EBA85AF42BB9207CD69EC402079")
    public Throwable getCause() {
Throwable var77A55F525D35035B29E3829296BB2E65_676516243 =         underlying;
        var77A55F525D35035B29E3829296BB2E65_676516243.addTaint(taint);
        return var77A55F525D35035B29E3829296BB2E65_676516243;
        // ---------- Original Method ----------
        //return underlying;
    }

    
}

