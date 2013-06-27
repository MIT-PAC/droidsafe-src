package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OperationApplicationException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.400 -0400", hash_original_field = "11FC6C9D498EE8CC3E52A83CA9847515", hash_generated_field = "394223B065D0D359C43F3F4B72BA8F23")

    private int mNumSuccessfulYieldPoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.419 -0400", hash_original_method = "825A0D209F83C788198717CC73F99489", hash_generated_method = "85FE8CBA0DFF6372570E3B97FB915BDB")
    public  OperationApplicationException() {
        super();
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.421 -0400", hash_original_method = "77E2AE76D845D6FB97485837BDB7758B", hash_generated_method = "34F2A1304EAE31B84D2B2836635531C9")
    public  OperationApplicationException(String message) {
        super(message);
        mNumSuccessfulYieldPoints = 0;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.422 -0400", hash_original_method = "F0F6059D3EFC4E5FE3F6EC4FF0F2FDFB", hash_generated_method = "5CFEE486E1CDB552099E0C73F6F09A44")
    public  OperationApplicationException(String message, Throwable cause) {
        super(message, cause);
        mNumSuccessfulYieldPoints = 0;
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.430 -0400", hash_original_method = "64BB28A032D4059B850837C1A5699554", hash_generated_method = "0720F65D702775E76BFEA9DA1E6F2727")
    public  OperationApplicationException(Throwable cause) {
        super(cause);
        mNumSuccessfulYieldPoints = 0;
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.444 -0400", hash_original_method = "E4F3CE45A3791740F0C42342B2E05EC8", hash_generated_method = "522BBB0FF5C08BFA31C8EA8FBA543C01")
    public  OperationApplicationException(int numSuccessfulYieldPoints) {
        super();
        mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.446 -0400", hash_original_method = "8F9006EEA79EF42E9E468007193B747B", hash_generated_method = "4C34C05D1BA3DA6BF733176688BB7336")
    public  OperationApplicationException(String message, int numSuccessfulYieldPoints) {
        super(message);
        mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.455 -0400", hash_original_method = "0D03973B4F1A76863E3DF446BDE01596", hash_generated_method = "676547777FF5D0D1F9696CB51B577EA4")
    public int getNumSuccessfulYieldPoints() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279901003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279901003;
        // ---------- Original Method ----------
        //return mNumSuccessfulYieldPoints;
    }

    
}

