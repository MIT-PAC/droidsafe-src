package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.ServiceManager;

public class AlarmManager {
    public static final int RTC_WAKEUP = 0;
    public static final int RTC = 1;
    public static final int ELAPSED_REALTIME_WAKEUP = 2;
    public static final int ELAPSED_REALTIME = 3;
    private final IAlarmManager mService;
    public static final long INTERVAL_FIFTEEN_MINUTES = 15 * 60 * 1000;
    public static final long INTERVAL_HALF_HOUR = 2*INTERVAL_FIFTEEN_MINUTES;
    public static final long INTERVAL_HOUR = 2*INTERVAL_HALF_HOUR;
    public static final long INTERVAL_HALF_DAY = 12*INTERVAL_HOUR;
    public static final long INTERVAL_DAY = 2*INTERVAL_HALF_DAY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.678 -0400", hash_original_method = "777E43DCC11684FA65853DF87647331C", hash_generated_method = "EDA170362B934E9E2790F051F9C3E962")
    @DSModeled(DSC.SAFE)
     AlarmManager(IAlarmManager service) {
        dsTaint.addTaint(service.dsTaint);
        mService = service;
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.678 -0400", hash_original_method = "62DAF5BCFF42E7C3B71DA4EC3FF03273", hash_generated_method = "948AF8E484B55CB772F74AB56FA2B89D")
    @DSModeled(DSC.SAFE)
    public void set(int type, long triggerAtTime, PendingIntent operation) {
        dsTaint.addTaint(operation.dsTaint);
        dsTaint.addTaint(type);
        dsTaint.addTaint(triggerAtTime);
        try 
        {
            mService.set(type, triggerAtTime, operation);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.set(type, triggerAtTime, operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.679 -0400", hash_original_method = "B76B6BC989D8817E7D8138A521E8EB08", hash_generated_method = "597093F2E0CAF4E6F3A5A3FC46636F42")
    @DSModeled(DSC.SAFE)
    public void setRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        dsTaint.addTaint(operation.dsTaint);
        dsTaint.addTaint(interval);
        dsTaint.addTaint(type);
        dsTaint.addTaint(triggerAtTime);
        try 
        {
            mService.setRepeating(type, triggerAtTime, interval, operation);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setRepeating(type, triggerAtTime, interval, operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.679 -0400", hash_original_method = "BA6CD3CD848F31D3C4801F13BE104684", hash_generated_method = "2FD58353E76222FF1CC980A07C71A70B")
    @DSModeled(DSC.SAFE)
    public void setInexactRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        dsTaint.addTaint(operation.dsTaint);
        dsTaint.addTaint(interval);
        dsTaint.addTaint(type);
        dsTaint.addTaint(triggerAtTime);
        try 
        {
            mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.680 -0400", hash_original_method = "201C17E876772752E3C1FB6083A5FC0F", hash_generated_method = "6B7576957ADCBF11D0DA02DB7A13B120")
    @DSModeled(DSC.SAFE)
    public void cancel(PendingIntent operation) {
        dsTaint.addTaint(operation.dsTaint);
        try 
        {
            mService.remove(operation);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.remove(operation);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.680 -0400", hash_original_method = "3A70CE6E172EDC0255F255C60401C6D7", hash_generated_method = "849B438BB5372EB2646D9476FC89ECDE")
    @DSModeled(DSC.SAFE)
    public void setTime(long millis) {
        dsTaint.addTaint(millis);
        try 
        {
            mService.setTime(millis);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setTime(millis);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.680 -0400", hash_original_method = "7328E8391AD5750BAC4B3B8A138446CC", hash_generated_method = "4409DAE31736F737C09EED4BC30FCA8C")
    @DSModeled(DSC.SAFE)
    public void setTimeZone(String timeZone) {
        dsTaint.addTaint(timeZone);
        try 
        {
            mService.setTimeZone(timeZone);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.setTimeZone(timeZone);
        //} catch (RemoteException ex) {
        //}
    }

    
}


