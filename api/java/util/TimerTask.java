package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class TimerTask implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.935 -0400", hash_original_field = "DD465B0839A70592931A97D99A9DB042", hash_generated_field = "444D55F7E87A46DB2BC47514D8909813")

    final Object lock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.935 -0400", hash_original_field = "38881E0A24039DC2621E1D6F86CB71F7", hash_generated_field = "FE3EA34D60211B160636288AB9105E56")

    boolean cancelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.935 -0400", hash_original_field = "DF491A4DE50739FA9CFFDBD4E3F4B4BB", hash_generated_field = "4E7289569777021C55877266ACAD1845")

    long when;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.935 -0400", hash_original_field = "A0ACFA46D86F7610B2C73DBB28F64701", hash_generated_field = "21C6B258F031958D40A6DAC5279E0EE8")

    long period;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_field = "7D0BDE61DE22D77DD30397B8469304B7", hash_generated_field = "28408F90702CEE9413B76824113C0001")

    boolean fixedRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_field = "D2DDA425E4864CAC7B1D489588F99ABC", hash_generated_field = "2A084075C1B0C69D6880285CCF039DBD")

    private long scheduledTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_method = "41AFEAE31E9AFC51442EB32F1B803F09", hash_generated_method = "77D10C16E519E63639DFE51A512851F6")
    protected  TimerTask() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_method = "61DD03075FF1927377D7CEC2AE97ED1A", hash_generated_method = "2AFF3D5046FCAE960C8C46DAD299DB87")
     long getWhen() {
        synchronized
(lock)        {
            long varDF491A4DE50739FA9CFFDBD4E3F4B4BB_832989907 = (when);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1735712240 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1735712240;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_method = "AE139E2AB369CB1B1C48D00C62C96DCB", hash_generated_method = "A9573B48ADB09ADFE8DADC78CC51F376")
     void setScheduledTime(long time) {
        synchronized
(lock)        {
            scheduledTime = time;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_method = "0BC3D740AEEAEAE472C572E03A1906A5", hash_generated_method = "EFCAA4942CD8B52F1390536D44FDA5B1")
     boolean isScheduled() {
        synchronized
(lock)        {
            boolean varA2AB6FCA069AF5ADD6E13BE35BFFC2DD_122397547 = (when > 0 || scheduledTime > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1441393306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1441393306;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.936 -0400", hash_original_method = "1700D6DAFB7BC2815E6FE0B3C1768102", hash_generated_method = "BD0461B6CCF2DDF9A67DA5F21C81FD89")
    public boolean cancel() {
        synchronized
(lock)        {
            boolean willRun = !cancelled && when > 0;
            cancelled = true;
            boolean varC621FE5823F5FB29797383D294DB8EC2_900994701 = (willRun);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351401634 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_351401634;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.937 -0400", hash_original_method = "BAEF9B11043548CD5E25A5F175F23300", hash_generated_method = "54B5C10B813ECBF9F70042BD4FDAEC7C")
    public long scheduledExecutionTime() {
        synchronized
(lock)        {
            long varD2DDA425E4864CAC7B1D489588F99ABC_1211630301 = (scheduledTime);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_486927416 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_486927416;
        } 
        
        
            
        
    }

    
    public abstract void run();

    
}

