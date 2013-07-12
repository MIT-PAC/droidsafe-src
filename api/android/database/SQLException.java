package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SQLException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.454 -0400", hash_original_method = "556E5C618BFB2928AAC4F47E36A85E30", hash_generated_method = "CE8DBAD1AAD3061916D28F23A768DE2E")
    public  SQLException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.454 -0400", hash_original_method = "DC2A21E6520D20A30A0F3CD7D71F8640", hash_generated_method = "BB58135DA5FDA50810DD1A1AA4932711")
    public  SQLException(String error) {
        super(error);
        addTaint(error.getTaint());
        
    }

    
}

