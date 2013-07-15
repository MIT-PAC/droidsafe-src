package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ContentResolver;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SmsUsageMonitor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.035 -0400", hash_original_field = "7D2C0C2BF475877740FC4F4370379B27", hash_generated_field = "8251D8E7267A3EFD6EC445592CA97E50")

    private int mCheckPeriod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.035 -0400", hash_original_field = "9975895F9DB80EFF35D4CCBB757209DA", hash_generated_field = "88D310A8EA39C1E84390420AD9B4808A")

    private int mMaxAllowed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.035 -0400", hash_original_field = "C43BF27E7C4A474A450E53DD288AFA67", hash_generated_field = "DFE168BFE7372EC4F2AF98D6A5D9F6B4")

    private final HashMap<String, ArrayList<Long>> mSmsStamp = new HashMap<String, ArrayList<Long>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.035 -0400", hash_original_method = "AA58276D63D2163182FD805D073EE67C", hash_generated_method = "41E1494827BFC473DCA67AF4C2849C94")
    public  SmsUsageMonitor(ContentResolver resolver) {
        mMaxAllowed = Settings.Secure.getInt(resolver,
                Settings.Secure.SMS_OUTGOING_CHECK_MAX_COUNT,
                DEFAULT_SMS_MAX_COUNT);
        mCheckPeriod = Settings.Secure.getInt(resolver,
                Settings.Secure.SMS_OUTGOING_CHECK_INTERVAL_MS,
                DEFAULT_SMS_CHECK_PERIOD);
        
        
                
                
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.035 -0400", hash_original_method = "7B2C29F4698952FF45E2699BBB5DEB62", hash_generated_method = "F5020B67D30B77B9A0B8E7C878C54BF3")
     void dispose() {
        mSmsStamp.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.036 -0400", hash_original_method = "EA1BFE3566BC11C4D089155AC6363183", hash_generated_method = "AD1874E4FF28D0CBCBCF71D3F4E779D8")
    public boolean check(String appName, int smsWaiting) {
        {
            removeExpiredTimestamps();
            ArrayList<Long> sentList = mSmsStamp.get(appName);
            {
                sentList = new ArrayList<Long>();
                mSmsStamp.put(appName, sentList);
            } 
            boolean var091A67795636C5B7E20E47F6F889C23B_2093976672 = (isUnderLimit(sentList, smsWaiting));
        } 
        addTaint(appName.getTaint());
        addTaint(smsWaiting);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270586330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270586330;
        
        
            
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.037 -0400", hash_original_method = "0C89C3F43D481EBAFC32AEEAE6183BD3", hash_generated_method = "47347124F9655C56438D0B39692CB677")
    private void removeExpiredTimestamps() {
        long beginCheckPeriod = System.currentTimeMillis() - mCheckPeriod;
        {
            Iterator<Map.Entry<String, ArrayList<Long>>> iter = mSmsStamp.entrySet().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1897682315 = (iter.hasNext());
                {
                    Map.Entry<String, ArrayList<Long>> entry = iter.next();
                    ArrayList<Long> oldList = entry.getValue();
                    {
                        boolean var6B058BCE74663B8CCC2D65D7403CD832_1141984669 = (oldList.isEmpty() || oldList.get(oldList.size() - 1) < beginCheckPeriod);
                        {
                            iter.remove();
                        } 
                    } 
                } 
            } 
        } 
        
        
        
            
            
                
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.038 -0400", hash_original_method = "FED252455D0F59F9866280B84F72F407", hash_generated_method = "A6C0CD971758D37A6978BAAAD1BA6802")
    private boolean isUnderLimit(ArrayList<Long> sent, int smsWaiting) {
        Long ct = System.currentTimeMillis();
        long beginCheckPeriod = ct - mCheckPeriod;
        Log.d(TAG, "SMS send size=" + sent.size() + " time=" + ct);
        {
            boolean var5667D581C2F5DFCA02DEFCCDFE1CFB02_1745582104 = (!sent.isEmpty() && sent.get(0) < beginCheckPeriod);
            {
                sent.remove(0);
            } 
        } 
        {
            boolean varDFD6A4FA9327973346539BB265A37305_1679811720 = ((sent.size() + smsWaiting) <= mMaxAllowed);
            {
                {
                    int i = 0;
                    {
                        sent.add(ct);
                    } 
                } 
            } 
        } 
        addTaint(sent.getTaint());
        addTaint(smsWaiting);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086147641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086147641;
        
        
        
        
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.038 -0400", hash_original_field = "35B10AB3CDA09F3B2F3131AD6DBAA325", hash_generated_field = "ADC819F4640257478A9F0F8C0177ED0F")

    private static final String TAG = "SmsStorageMonitor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.038 -0400", hash_original_field = "86C04E306979E0A3ED6C10E477ABFEDA", hash_generated_field = "D184D1254BA3A87EB9E381BB216E30EE")

    private static final int DEFAULT_SMS_CHECK_PERIOD = 3600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.038 -0400", hash_original_field = "5B383FE3921C2BBCDC2AD6E7B1F1197C", hash_generated_field = "E11F7FB3C4CB97EA2BC23371FE5A5E5F")

    private static final int DEFAULT_SMS_MAX_COUNT = 100;
}

