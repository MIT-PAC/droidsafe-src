package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class TimerTask implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.103 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "DA2A3FDBCC0B9B91674644DF55F373AF")

    Object lock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_field = "38881E0A24039DC2621E1D6F86CB71F7", hash_generated_field = "FE3EA34D60211B160636288AB9105E56")

    boolean cancelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_field = "DF491A4DE50739FA9CFFDBD4E3F4B4BB", hash_generated_field = "4E7289569777021C55877266ACAD1845")

    long when;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_field = "A0ACFA46D86F7610B2C73DBB28F64701", hash_generated_field = "21C6B258F031958D40A6DAC5279E0EE8")

    long period;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_field = "7D0BDE61DE22D77DD30397B8469304B7", hash_generated_field = "28408F90702CEE9413B76824113C0001")

    boolean fixedRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_field = "D2DDA425E4864CAC7B1D489588F99ABC", hash_generated_field = "2A084075C1B0C69D6880285CCF039DBD")

    private long scheduledTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_method = "41AFEAE31E9AFC51442EB32F1B803F09", hash_generated_method = "77D10C16E519E63639DFE51A512851F6")
    protected  TimerTask() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.104 -0400", hash_original_method = "61DD03075FF1927377D7CEC2AE97ED1A", hash_generated_method = "08F96665A35B72313E3F465AEADB0AB6")
     long getWhen() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1637228004 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1637228004;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return when;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.105 -0400", hash_original_method = "AE139E2AB369CB1B1C48D00C62C96DCB", hash_generated_method = "EB16D04E9A8397FBD5DAF255AAA28097")
     void setScheduledTime(long time) {
        {
            scheduledTime = time;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //scheduledTime = time;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.105 -0400", hash_original_method = "0BC3D740AEEAEAE472C572E03A1906A5", hash_generated_method = "9509734FC42559D6D83374460A72E3FB")
     boolean isScheduled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341601567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341601567;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return when > 0 || scheduledTime > 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.106 -0400", hash_original_method = "1700D6DAFB7BC2815E6FE0B3C1768102", hash_generated_method = "5FD6AD15F5CAA651C96B7B756E279212")
    public boolean cancel() {
        {
            boolean willRun;
            willRun = !cancelled && when > 0;
            cancelled = true;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629273531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629273531;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //boolean willRun = !cancelled && when > 0;
            //cancelled = true;
            //return willRun;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.106 -0400", hash_original_method = "BAEF9B11043548CD5E25A5F175F23300", hash_generated_method = "6E8AA13E665F805E2B5768844F333DEE")
    public long scheduledExecutionTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2044820595 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2044820595;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //return scheduledTime;
        //}
    }

    
    public abstract void run();

    
}

