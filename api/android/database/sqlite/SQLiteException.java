package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.SQLException;

public class SQLiteException extends SQLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.992 -0400", hash_original_method = "C0EDC6814EAFE55CC8FBE8FC40236BE6", hash_generated_method = "C8AAD5FA2174518FBC9F4F247BAD5FBE")
    public  SQLiteException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.993 -0400", hash_original_method = "0C0BEBB87E389634BC41A00A87165715", hash_generated_method = "13CE004E2289F072BFF57DEEB7DF3105")
    public  SQLiteException(String error) {
        super(error);
        addTaint(error.getTaint());
        
    }

    
}

