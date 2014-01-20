package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.PendingIntent.CanceledException;
import android.os.RemoteException;

public class AlarmManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.465 -0500", hash_original_field = "A79C594EF1F8295CEC2F680A3F012CC9", hash_generated_field = "3BDDF2E6C62B61826F4AFF48F237BDD3")

    public static final int RTC_WAKEUP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.468 -0500", hash_original_field = "B28688ECBE03F0A42BF545F3C0A6452D", hash_generated_field = "EB67B90A8A2E111C6347420D2B97F28C")

    public static final int RTC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.470 -0500", hash_original_field = "76DCE8449C5402A9E93812423EB049EB", hash_generated_field = "ABF765CFDB37414A63F9D9B3EB8070AA")

    public static final int ELAPSED_REALTIME_WAKEUP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.472 -0500", hash_original_field = "FAA07250D70BA1BBE180B4D41DDCF472", hash_generated_field = "CB9D2A7B12A900A079B5C7C73BD1E071")

    public static final int ELAPSED_REALTIME = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.484 -0500", hash_original_field = "9711BA5DCC6F17A8C82FD1FE97DA019E", hash_generated_field = "BC6DE1F06E7A4A96C50BEC47050378FE")

    public static final long INTERVAL_FIFTEEN_MINUTES = 15 * 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.486 -0500", hash_original_field = "E56FFC2FCBBDCA42B728F66C74BE67C5", hash_generated_field = "D7247C7D04FAD26613BA5A928B7A127F")

    public static final long INTERVAL_HALF_HOUR = 2*INTERVAL_FIFTEEN_MINUTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.488 -0500", hash_original_field = "4D2F510611FAF06EFCB154BE0F2AA686", hash_generated_field = "65DF78638E6704F70AB927B27E503A2F")

    public static final long INTERVAL_HOUR = 2*INTERVAL_HALF_HOUR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.491 -0500", hash_original_field = "DBB54F21F9E1304BD50A11638DB93EB2", hash_generated_field = "4FB20661ECA35BFCFD5B4B24221EA2B2")

    public static final long INTERVAL_HALF_DAY = 12*INTERVAL_HOUR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.494 -0500", hash_original_field = "9DDFDB36DE5A203A8A6213774120E514", hash_generated_field = "4A18EAC313489EC85F334E948E3F7EA3")

    public static final long INTERVAL_DAY = 2*INTERVAL_HALF_DAY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.475 -0500", hash_original_field = "3F1555D92913CFFB08BED31758021BAE", hash_generated_field = "86B776A6A69718EFA060C569C84D8641")

    private  IAlarmManager mService;

    /**
     * package private on purpose
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:28.478 -0500", hash_original_method = "777E43DCC11684FA65853DF87647331C", hash_generated_method = "777E43DCC11684FA65853DF87647331C")
    
AlarmManager(IAlarmManager service) {
        mService = service;
    }
    
    public AlarmManager(){
        
    }
    
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.886 -0400", hash_original_method = "62DAF5BCFF42E7C3B71DA4EC3FF03273", hash_generated_method = "00637051DDD716CB394E09B323080F9C")
    public void set(int type, long triggerAtTime, PendingIntent operation) {
        addTaint(operation.getTaint());
        addTaint(triggerAtTime);
        addTaint(type);
        try {
            operation.send(getTaintInt());
        } catch (CanceledException e) {
            // TODO Auto-generated catch block
            //actual interface does not have throw statement
        }
        /*
        try 
        {
            mService.set(type, triggerAtTime, operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        */
        // ---------- Original Method ----------
        //try {
            //mService.set(type, triggerAtTime, operation);
        //} catch (RemoteException ex) {
        //}
    }
    
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.887 -0400", hash_original_method = "B76B6BC989D8817E7D8138A521E8EB08", hash_generated_method = "1F883AD2D5B31B8D04A551F102467DCA")
    public void setRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        addTaint(operation.getTaint());
        addTaint(interval);
        addTaint(triggerAtTime);
        addTaint(type);
        try {
            operation.send(getTaintInt());
        } catch (CanceledException e) {
            // TODO Auto-generated catch block
            //actual interface does not have throw statement
        }
        /*
        try 
        {
            mService.setRepeating(type, triggerAtTime, interval, operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        */
        // ---------- Original Method ----------
        //try {
            //mService.setRepeating(type, triggerAtTime, interval, operation);
        //} catch (RemoteException ex) {
        //}
    }
    
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.888 -0400", hash_original_method = "BA6CD3CD848F31D3C4801F13BE104684", hash_generated_method = "40BDCE1F7737607563795EC245C2DF50")
    public void setInexactRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        addTaint(operation.getTaint());
        addTaint(interval);
        addTaint(triggerAtTime);
        addTaint(type);
        /*
        try 
        {
            mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        */
        // ---------- Original Method ----------
        //try {
            //mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        //} catch (RemoteException ex) {
        //}
    }
    
    @DSComment("IPC activity")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.889 -0400", hash_original_method = "201C17E876772752E3C1FB6083A5FC0F", hash_generated_method = "C077AA8A887A89A055EBE697EB5271ED")
    public void cancel(PendingIntent operation) {
        addTaint(operation.getTaint());
        operation.cancel();

        /*
        try 
        {
            mService.remove(operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        */
        // ---------- Original Method ----------
        //try {
            //mService.remove(operation);
        //} catch (RemoteException ex) {
        //}
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.890 -0400", hash_original_method = "3A70CE6E172EDC0255F255C60401C6D7", hash_generated_method = "4D8770A8C859AEC78E4AD69D8F646E10")
    
    public void setTime(long millis) {
        addTaint(millis);
        // ---------- Original Method ----------
        //try {
            //mService.setTime(millis);
        //} catch (RemoteException ex) {
        //}
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.891 -0400", hash_original_method = "7328E8391AD5750BAC4B3B8A138446CC", hash_generated_method = "5BAF798F717A2B1B1FCDA60799BC94BA")
    public void setTimeZone(String timeZone) {
        addTaint(timeZone.getTaint());
        /*
        try 
        {
            mService.setTimeZone(timeZone);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        */
        // ---------- Original Method ----------
        //try {
            //mService.setTimeZone(timeZone);
        //} catch (RemoteException ex) {
        //}
    }
}

