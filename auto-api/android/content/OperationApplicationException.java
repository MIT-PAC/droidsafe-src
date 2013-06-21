package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OperationApplicationException extends Exception {
    private int mNumSuccessfulYieldPoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.061 -0400", hash_original_method = "825A0D209F83C788198717CC73F99489", hash_generated_method = "85FE8CBA0DFF6372570E3B97FB915BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException() {
        super();
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.061 -0400", hash_original_method = "77E2AE76D845D6FB97485837BDB7758B", hash_generated_method = "3A3B6C011B29DFA15BB04DD2942D9DDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(String message) {
        super(message);
        dsTaint.addTaint(message);
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.062 -0400", hash_original_method = "F0F6059D3EFC4E5FE3F6EC4FF0F2FDFB", hash_generated_method = "1AF34D3EF714ACA7F8FAD834AD687619")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.062 -0400", hash_original_method = "64BB28A032D4059B850837C1A5699554", hash_generated_method = "8ADD89E42B88E93412798C526DEEBB03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.062 -0400", hash_original_method = "E4F3CE45A3791740F0C42342B2E05EC8", hash_generated_method = "7945E4FCBCE465FAEC653FABB2D76C09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(int numSuccessfulYieldPoints) {
        super();
        dsTaint.addTaint(numSuccessfulYieldPoints);
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.062 -0400", hash_original_method = "8F9006EEA79EF42E9E468007193B747B", hash_generated_method = "52BEBF60DF7CBFCD7D4E3F11A33FACEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(String message, int numSuccessfulYieldPoints) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(numSuccessfulYieldPoints);
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.063 -0400", hash_original_method = "0D03973B4F1A76863E3DF446BDE01596", hash_generated_method = "9607563B51D97930BF1EF55A640CDFF3")
    @DSModeled(DSC.SAFE)
    public int getNumSuccessfulYieldPoints() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNumSuccessfulYieldPoints;
    }

    
}

