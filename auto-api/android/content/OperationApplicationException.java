package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class OperationApplicationException extends Exception {
    private final int mNumSuccessfulYieldPoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.797 -0400", hash_original_method = "825A0D209F83C788198717CC73F99489", hash_generated_method = "EAE0888636D469FD0A7AD0411D576E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException() {
        super();
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.797 -0400", hash_original_method = "77E2AE76D845D6FB97485837BDB7758B", hash_generated_method = "D312ACC97D36C75CBED77BEAAA50D676")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(String message) {
        super(message);
        dsTaint.addTaint(message);
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.797 -0400", hash_original_method = "F0F6059D3EFC4E5FE3F6EC4FF0F2FDFB", hash_generated_method = "94FB2E8B0B24A061275FBBB9739F844C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.797 -0400", hash_original_method = "64BB28A032D4059B850837C1A5699554", hash_generated_method = "668155243B1DECD21F77594578E08387")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.797 -0400", hash_original_method = "E4F3CE45A3791740F0C42342B2E05EC8", hash_generated_method = "8431AD22103AE68FE92DACC4A2879F8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(int numSuccessfulYieldPoints) {
        super();
        dsTaint.addTaint(numSuccessfulYieldPoints);
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.798 -0400", hash_original_method = "8F9006EEA79EF42E9E468007193B747B", hash_generated_method = "453A4262D52676ABA8A441847344D3C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperationApplicationException(String message, int numSuccessfulYieldPoints) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(numSuccessfulYieldPoints);
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.798 -0400", hash_original_method = "0D03973B4F1A76863E3DF446BDE01596", hash_generated_method = "5739120E57730064A90D7068014C5FCD")
    @DSModeled(DSC.SAFE)
    public int getNumSuccessfulYieldPoints() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNumSuccessfulYieldPoints;
    }

    
}


