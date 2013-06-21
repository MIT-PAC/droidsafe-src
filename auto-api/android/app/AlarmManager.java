package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.ServiceManager;

public class AlarmManager {
    private IAlarmManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.441 -0400", hash_original_method = "777E43DCC11684FA65853DF87647331C", hash_generated_method = "0868CC825ECDC4D77CD82934222509C3")
    @DSModeled(DSC.SAFE)
     AlarmManager(IAlarmManager service) {
        dsTaint.addTaint(service.dsTaint);
        // ---------- Original Method ----------
        //mService = service;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.442 -0400", hash_original_method = "62DAF5BCFF42E7C3B71DA4EC3FF03273", hash_generated_method = "E01141BE8BF0F1611BC7909C7DAAD465")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.443 -0400", hash_original_method = "B76B6BC989D8817E7D8138A521E8EB08", hash_generated_method = "612FA1BAEEF25F2408569F7CE4CF6C2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.444 -0400", hash_original_method = "BA6CD3CD848F31D3C4801F13BE104684", hash_generated_method = "192E21F63FF61E5531DFA8ACEF5EAFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.445 -0400", hash_original_method = "201C17E876772752E3C1FB6083A5FC0F", hash_generated_method = "35C1FA47A9E2F7F59A9DCDDDC386C3A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.445 -0400", hash_original_method = "3A70CE6E172EDC0255F255C60401C6D7", hash_generated_method = "EB62F601E12FA9713486C2B9C0E944B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.446 -0400", hash_original_method = "7328E8391AD5750BAC4B3B8A138446CC", hash_generated_method = "546A33D5FE3CDF2DDB8BB26FFB4425D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    public static final int RTC_WAKEUP = 0;
    public static final int RTC = 1;
    public static final int ELAPSED_REALTIME_WAKEUP = 2;
    public static final int ELAPSED_REALTIME = 3;
    public static final long INTERVAL_FIFTEEN_MINUTES = 15 * 60 * 1000;
    public static final long INTERVAL_HALF_HOUR = 2*INTERVAL_FIFTEEN_MINUTES;
    public static final long INTERVAL_HOUR = 2*INTERVAL_HALF_HOUR;
    public static final long INTERVAL_HALF_DAY = 12*INTERVAL_HOUR;
    public static final long INTERVAL_DAY = 2*INTERVAL_HALF_DAY;
}

