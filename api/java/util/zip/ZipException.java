package java.util.zip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class ZipException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.512 -0400", hash_original_method = "2167A1F4D125B524620850E643449987", hash_generated_method = "26CDA45503C3CB1EA8909514B5B7B27F")
    public  ZipException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.512 -0400", hash_original_method = "594D1061F67CD3EF6F4592503B4204F0", hash_generated_method = "578ACCD10E461F8BB245A2FF358B352E")
    public  ZipException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.513 -0400", hash_original_field = "F6F5B28DF01D2886A1A2A304D964ABD6", hash_generated_field = "7A3B8D4739EACA05C4F8E66A30715AB1")

    private static final long serialVersionUID = 8000196834066748623L;
}

