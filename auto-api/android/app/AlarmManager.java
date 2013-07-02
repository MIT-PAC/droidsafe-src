package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.ServiceManager;

public class AlarmManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.055 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "86B776A6A69718EFA060C569C84D8641")

    private IAlarmManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.056 -0400", hash_original_method = "777E43DCC11684FA65853DF87647331C", hash_generated_method = "C807E43424CB7C729C805FCAFCCB79C4")
      AlarmManager(IAlarmManager service) {
        mService = service;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.056 -0400", hash_original_method = "62DAF5BCFF42E7C3B71DA4EC3FF03273", hash_generated_method = "060D92FF5CCC2275C60DE3047C61630C")
    public void set(int type, long triggerAtTime, PendingIntent operation) {
        try 
        {
            mService.set(type, triggerAtTime, operation);
        } 
        catch (RemoteException ex)
        { }
        addTaint(type);
        addTaint(triggerAtTime);
        addTaint(operation.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.057 -0400", hash_original_method = "B76B6BC989D8817E7D8138A521E8EB08", hash_generated_method = "55DA4475E79257CA341876398D9077E3")
    public void setRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        try 
        {
            mService.setRepeating(type, triggerAtTime, interval, operation);
        } 
        catch (RemoteException ex)
        { }
        addTaint(type);
        addTaint(triggerAtTime);
        addTaint(interval);
        addTaint(operation.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.058 -0400", hash_original_method = "BA6CD3CD848F31D3C4801F13BE104684", hash_generated_method = "70008594B1A564B68C6F4DF6F3B8848D")
    public void setInexactRepeating(int type, long triggerAtTime, long interval,
            PendingIntent operation) {
        try 
        {
            mService.setInexactRepeating(type, triggerAtTime, interval, operation);
        } 
        catch (RemoteException ex)
        { }
        addTaint(type);
        addTaint(triggerAtTime);
        addTaint(interval);
        addTaint(operation.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.058 -0400", hash_original_method = "201C17E876772752E3C1FB6083A5FC0F", hash_generated_method = "22018CCCF7704D105945F9504E0C1498")
    public void cancel(PendingIntent operation) {
        try 
        {
            mService.remove(operation);
        } 
        catch (RemoteException ex)
        { }
        addTaint(operation.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.059 -0400", hash_original_method = "3A70CE6E172EDC0255F255C60401C6D7", hash_generated_method = "E5CED6B9B68D154CC6470B95686BA5DD")
    public void setTime(long millis) {
        try 
        {
            mService.setTime(millis);
        } 
        catch (RemoteException ex)
        { }
        addTaint(millis);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.059 -0400", hash_original_method = "7328E8391AD5750BAC4B3B8A138446CC", hash_generated_method = "182371D668734157F922FF057293545F")
    public void setTimeZone(String timeZone) {
        try 
        {
            mService.setTimeZone(timeZone);
        } 
        catch (RemoteException ex)
        { }
        addTaint(timeZone.getTaint());
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.059 -0400", hash_original_field = "5E1E77863C8E6490C44436BE3A56C251", hash_generated_field = "3BDDF2E6C62B61826F4AFF48F237BDD3")

    public static final int RTC_WAKEUP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.060 -0400", hash_original_field = "E127F27E2E9809EA3815ED6DEE1B202D", hash_generated_field = "EB67B90A8A2E111C6347420D2B97F28C")

    public static final int RTC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.060 -0400", hash_original_field = "858FC67A1C7310E0E9594322644A0C9D", hash_generated_field = "ABF765CFDB37414A63F9D9B3EB8070AA")

    public static final int ELAPSED_REALTIME_WAKEUP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.060 -0400", hash_original_field = "C63B7F85BFDAC1E98047CD4653AEEF96", hash_generated_field = "CB9D2A7B12A900A079B5C7C73BD1E071")

    public static final int ELAPSED_REALTIME = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.060 -0400", hash_original_field = "6A8E55324C90536CDF1A0FD33C798F28", hash_generated_field = "BC6DE1F06E7A4A96C50BEC47050378FE")

    public static final long INTERVAL_FIFTEEN_MINUTES = 15 * 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.060 -0400", hash_original_field = "7BEAF73C04E0707111B3C39423553EF3", hash_generated_field = "D7247C7D04FAD26613BA5A928B7A127F")

    public static final long INTERVAL_HALF_HOUR = 2*INTERVAL_FIFTEEN_MINUTES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.060 -0400", hash_original_field = "7E0FA646D345ABE8BCBD76B0572E29C7", hash_generated_field = "65DF78638E6704F70AB927B27E503A2F")

    public static final long INTERVAL_HOUR = 2*INTERVAL_HALF_HOUR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.061 -0400", hash_original_field = "23F14586630BE9F5A58DCDEE891781A6", hash_generated_field = "4FB20661ECA35BFCFD5B4B24221EA2B2")

    public static final long INTERVAL_HALF_DAY = 12*INTERVAL_HOUR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.061 -0400", hash_original_field = "970A0FC923282B138C0E365794CE1967", hash_generated_field = "4A18EAC313489EC85F334E948E3F7EA3")

    public static final long INTERVAL_DAY = 2*INTERVAL_HALF_DAY;
}

