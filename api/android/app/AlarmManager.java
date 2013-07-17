package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.ServiceManager;

public class AlarmManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.885 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "86B776A6A69718EFA060C569C84D8641")

    private IAlarmManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.886 -0400", hash_original_method = "777E43DCC11684FA65853DF87647331C", hash_generated_method = "C807E43424CB7C729C805FCAFCCB79C4")
      AlarmManager(IAlarmManager service) {
        mService = service;
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.886 -0400", hash_original_method = "62DAF5BCFF42E7C3B71DA4EC3FF03273", hash_generated_method = "00637051DDD716CB394E09B323080F9C")
    public void set(int type, long triggerAtTime, PendingIntent operation) {
        addTaint(operation.getTaint());
        addTaint(triggerAtTime);
        addTaint(type);
        try 
        {
            mService.set(type, triggerAtTime, operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.set(type, triggerAtTime, operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.887 -0400", hash_original_method = "B76B6BC989D8817E7D8138A521E8EB08", hash_generated_method = "1F883AD2D5B31B8D04A551F102467DCA")
    public void setRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        addTaint(operation.getTaint());
        addTaint(interval);
        addTaint(triggerAtTime);
        addTaint(type);
        try 
        {
            mService.setRepeating(type, triggerAtTime, interval, operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setRepeating(type, triggerAtTime, interval, operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.888 -0400", hash_original_method = "BA6CD3CD848F31D3C4801F13BE104684", hash_generated_method = "40BDCE1F7737607563795EC245C2DF50")
    public void setInexactRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        addTaint(operation.getTaint());
        addTaint(interval);
        addTaint(triggerAtTime);
        addTaint(type);
        try 
        {
            mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.889 -0400", hash_original_method = "201C17E876772752E3C1FB6083A5FC0F", hash_generated_method = "C077AA8A887A89A055EBE697EB5271ED")
    public void cancel(PendingIntent operation) {
        addTaint(operation.getTaint());
        try 
        {
            mService.remove(operation);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.remove(operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.890 -0400", hash_original_method = "3A70CE6E172EDC0255F255C60401C6D7", hash_generated_method = "4D8770A8C859AEC78E4AD69D8F646E10")
    public void setTime(long millis) {
        addTaint(millis);
        try 
        {
            mService.setTime(millis);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setTime(millis);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.891 -0400", hash_original_method = "7328E8391AD5750BAC4B3B8A138446CC", hash_generated_method = "5BAF798F717A2B1B1FCDA60799BC94BA")
    public void setTimeZone(String timeZone) {
        addTaint(timeZone.getTaint());
        try 
        {
            mService.setTimeZone(timeZone);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mService.setTimeZone(timeZone);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.891 -0400", hash_original_field = "5E1E77863C8E6490C44436BE3A56C251", hash_generated_field = "3BDDF2E6C62B61826F4AFF48F237BDD3")

    public static final int RTC_WAKEUP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.891 -0400", hash_original_field = "E127F27E2E9809EA3815ED6DEE1B202D", hash_generated_field = "EB67B90A8A2E111C6347420D2B97F28C")

    public static final int RTC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.892 -0400", hash_original_field = "858FC67A1C7310E0E9594322644A0C9D", hash_generated_field = "ABF765CFDB37414A63F9D9B3EB8070AA")

    public static final int ELAPSED_REALTIME_WAKEUP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.892 -0400", hash_original_field = "C63B7F85BFDAC1E98047CD4653AEEF96", hash_generated_field = "CB9D2A7B12A900A079B5C7C73BD1E071")

    public static final int ELAPSED_REALTIME = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.892 -0400", hash_original_field = "6A8E55324C90536CDF1A0FD33C798F28", hash_generated_field = "BC6DE1F06E7A4A96C50BEC47050378FE")

    public static final long INTERVAL_FIFTEEN_MINUTES = 15 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.892 -0400", hash_original_field = "7BEAF73C04E0707111B3C39423553EF3", hash_generated_field = "D7247C7D04FAD26613BA5A928B7A127F")

    public static final long INTERVAL_HALF_HOUR = 2*INTERVAL_FIFTEEN_MINUTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.892 -0400", hash_original_field = "7E0FA646D345ABE8BCBD76B0572E29C7", hash_generated_field = "65DF78638E6704F70AB927B27E503A2F")

    public static final long INTERVAL_HOUR = 2*INTERVAL_HALF_HOUR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.893 -0400", hash_original_field = "23F14586630BE9F5A58DCDEE891781A6", hash_generated_field = "4FB20661ECA35BFCFD5B4B24221EA2B2")

    public static final long INTERVAL_HALF_DAY = 12*INTERVAL_HOUR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.893 -0400", hash_original_field = "970A0FC923282B138C0E365794CE1967", hash_generated_field = "4A18EAC313489EC85F334E948E3F7EA3")

    public static final long INTERVAL_DAY = 2*INTERVAL_HALF_DAY;
}

