package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;





public class OperationApplicationException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.674 -0400", hash_original_field = "11FC6C9D498EE8CC3E52A83CA9847515", hash_generated_field = "394223B065D0D359C43F3F4B72BA8F23")

    private int mNumSuccessfulYieldPoints;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.675 -0400", hash_original_method = "825A0D209F83C788198717CC73F99489", hash_generated_method = "85FE8CBA0DFF6372570E3B97FB915BDB")
    public  OperationApplicationException() {
        super();
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.676 -0400", hash_original_method = "77E2AE76D845D6FB97485837BDB7758B", hash_generated_method = "1CDECDA01604F48671BC09023CB5F2B6")
    public  OperationApplicationException(String message) {
        super(message);
        addTaint(message.getTaint());
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.677 -0400", hash_original_method = "F0F6059D3EFC4E5FE3F6EC4FF0F2FDFB", hash_generated_method = "2074D5E35EDC56DE297841C175B5CEC1")
    public  OperationApplicationException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.677 -0400", hash_original_method = "64BB28A032D4059B850837C1A5699554", hash_generated_method = "250C4BD044EBA8F40145B235295E7FB1")
    public  OperationApplicationException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        mNumSuccessfulYieldPoints = 0;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.678 -0400", hash_original_method = "E4F3CE45A3791740F0C42342B2E05EC8", hash_generated_method = "522BBB0FF5C08BFA31C8EA8FBA543C01")
    public  OperationApplicationException(int numSuccessfulYieldPoints) {
        super();
        mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.679 -0400", hash_original_method = "8F9006EEA79EF42E9E468007193B747B", hash_generated_method = "1A923BDAF5AD4126AD6991EFEEDC1625")
    public  OperationApplicationException(String message, int numSuccessfulYieldPoints) {
        super(message);
        addTaint(message.getTaint());
        mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
        // ---------- Original Method ----------
        //mNumSuccessfulYieldPoints = numSuccessfulYieldPoints;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.680 -0400", hash_original_method = "0D03973B4F1A76863E3DF446BDE01596", hash_generated_method = "BCAD7F69CFB196769598FC56BAABF1DC")
    public int getNumSuccessfulYieldPoints() {
        int var11FC6C9D498EE8CC3E52A83CA9847515_396485242 = (mNumSuccessfulYieldPoints);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640711800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640711800;
        // ---------- Original Method ----------
        //return mNumSuccessfulYieldPoints;
    }

    
}

