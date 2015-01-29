package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class PEMException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.852 -0500", hash_original_field = "C31C43ABE3D5D61AFE96A228698D8959", hash_generated_field = "C31C43ABE3D5D61AFE96A228698D8959")

    Exception    underlying;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.855 -0500", hash_original_method = "DBCE2D6935FCAE6513D26D3BE9F92180", hash_generated_method = "FBB110F8C2C8D2BDA1B7FB415599F813")
    
public PEMException(
        String    message)
    {
        super(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.857 -0500", hash_original_method = "62F9842AAA557466DBCCBFAEB65A702E", hash_generated_method = "D633543E3946C10AB812170AACBF1533")
    
public PEMException(
        String        message,
        Exception    underlying)
    {
        super(message);
        this.underlying = underlying;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.860 -0500", hash_original_method = "8D4B98C08FC53F956480CC6A65685E20", hash_generated_method = "9C5E8BA174A66235E6EF329588AE9D8D")
    
public Exception getUnderlyingException()
    {
        return underlying;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.862 -0500", hash_original_method = "F2813220852B09056C9C149C0538BE80", hash_generated_method = "8657704834A58ECB84D4FA51B844934B")
    
public Throwable getCause()
    {
        return underlying;
    }
    
}

